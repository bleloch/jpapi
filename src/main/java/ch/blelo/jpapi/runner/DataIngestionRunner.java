package ch.blelo.jpapi.runner;

import ch.blelo.jpapi.model.dto.common.KanjiDto;
import ch.blelo.jpapi.model.dto.common.RubyDto;
import ch.blelo.jpapi.model.dto.jmdict.JMDictEntryDto;
import ch.blelo.jpapi.model.dto.jmnedict.JMNEDictEntryDto;
import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2CharacterDto;
import ch.blelo.jpapi.model.dto.serde.FuriganaDeserializer;
import ch.blelo.jpapi.model.entity.jmdict.*;
import ch.blelo.jpapi.model.entity.jmnedict.*;
import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2Character;
import ch.blelo.jpapi.model.entity.kanjidic2.*;
import ch.blelo.jpapi.repository.jmdict.JMDictRepositoryFacade;
import ch.blelo.jpapi.repository.jmnedict.JMNEDictRepositoryFacade;
import ch.blelo.jpapi.repository.kanjidic2.Kanjidic2RepositoryFacade;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Ingests data from</p>
 * <ul>
 *     <li>JMDict (with furigana)</li>
 *     <li>Jmnedict (with furigana)</li>
 *     <li>Kanjidic2</li>
 * </ul>
 *
 * <p>into a common database schema accessed by the rest of the application</p>
 */
@Profile("ingestion")
@Component
@Slf4j
public class DataIngestionRunner implements CommandLineRunner {
    @Value("${file.sources.jmdict}")
    private String jmdictFile;

    @Value("${file.furigana.jmdict}")
    private String jmdictFuriganaFile;

    @Value("${file.sources.jmnedict}")
    private String jmnedictFile;

    @Value("${file.furigana.jmnedict}")
    private String jmnedictFuriganaFile;

    @Value("${file.sources.kanjidic2}")
    private String kanjidic2File;

    // TODO: add more data sources here...

    private final JMDictRepositoryFacade jmdictRepository;
    private final JMNEDictRepositoryFacade jmnedictRepository;
    private final Kanjidic2RepositoryFacade kanjidic2Repository;

    public DataIngestionRunner(
            JMDictRepositoryFacade jmdictRepository,
            JMNEDictRepositoryFacade jmnedictRepository,
            Kanjidic2RepositoryFacade kanjidic2Repository
    ) {
        this.jmdictRepository = jmdictRepository;
        this.jmnedictRepository = jmnedictRepository;
        this.kanjidic2Repository = kanjidic2Repository;
    }

    private static final XmlMapper XML_MAPPER =
            XmlMapper
                    .builder()
                    .build();

    private static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper();

    @SneakyThrows
    private static XMLStreamReader createXMLReader(String filePath) {
        var xmlInputFactory = XMLInputFactory.newInstance();
        xmlInputFactory.setProperty("com.ctc.wstx.maxEntityCount", 1000000);

        return xmlInputFactory.createXMLStreamReader(new FileInputStream(filePath));
    }

    @SneakyThrows
    private Map<String, List<RubyDto>> readFuriganaData(String filePath) {
        Map<String, List<RubyDto>> entries;
        try {
            var start = System.currentTimeMillis();

            SimpleModule module = new SimpleModule();
            module.addDeserializer(Map.class, new FuriganaDeserializer());

            OBJECT_MAPPER.registerModule(module);

            entries = OBJECT_MAPPER
                    .readerFor(new TypeReference<Map<String, List<RubyDto>>>() {
                    })
                    .readValue(new FileInputStream(filePath));

            log.info("Took {}ms to read {} furigana entries from {}", System.currentTimeMillis() - start, entries.size(), filePath);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read JSON file %s".formatted(filePath), e);
        }

        return entries;
    }

    private <T> List<T> readXmlData(String filePath, Class<T> contentClass) {
        List<T> entries;
        var type = XML_MAPPER.getTypeFactory().constructParametricType(List.class, contentClass);
        try {
            var start = System.currentTimeMillis();
            entries = XML_MAPPER.readValue(createXMLReader(filePath), type);
            log.info("Took {}ms to read {} entries of type {}", System.currentTimeMillis() - start, entries.size(), contentClass);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read XML file %s".formatted(filePath), e);
        }

        return entries;
    }

    /**
     * Persist a parsed Kanjidic2 character
     *
     * @param character to be persisted
     */
    private void saveKanjidic2Character(Kanjidic2CharacterDto character) {
        log.trace("Persisting Kanjidic2 character {}", character);
        var characterBuilder = Kanjidic2Character.builder()
                .literal(character.literal())
                .frequency(character.metadata().frequency())
                .schoolGrade(character.metadata().schoolGrade())
                .jlptGrade(character.metadata().jlptGrade())
                .strokeCount(character.metadata().strokeCount())
                .radicalNames(character.metadata().radicalNames());

        if (character.semantics() != null) {
            characterBuilder.nanori(character.semantics().nanori());
        }

        var characterEntity = kanjidic2Repository.characterRepository().save(characterBuilder.build());

        character.codepoints().forEach(
                codepoint -> kanjidic2Repository.codepointRepository().save(
                        Kanjidic2Codepoint.builder()
                                .character(characterEntity)
                                .element(codepoint.element())
                                .type(codepoint.type())
                                .build()));

        character.radicals().forEach(
                radical -> kanjidic2Repository.radicalRepository().save(
                        Kanjidic2Radical.builder()
                                .character(characterEntity)
                                .element(radical.element())
                                .type(radical.type())
                                .build()));

        if (character.dictionaryReferences() != null) {
            character.dictionaryReferences().forEach(
                    dictionaryReference -> kanjidic2Repository.dictionaryReferenceRepository().save(
                            Kanjidic2DictionaryReference.builder()
                                    .character(characterEntity)
                                    .element(dictionaryReference.element())
                                    .type(dictionaryReference.type())
                                    .morohashiVolume(dictionaryReference.morohashiVolume())
                                    .morohashiPage(dictionaryReference.morohashiPage())
                                    .build()));
        }

        if (character.queryCodes() != null) {
            character.queryCodes().forEach(
                    queryCode -> kanjidic2Repository.queryCodeRepository().save(
                            Kanjidic2QueryCode.builder()
                                    .character(characterEntity)
                                    .element(queryCode.element())
                                    .type(queryCode.type())
                                    .skipMisclassification(queryCode.skipMisclassification())
                                    .build()));
        }

        if (character.semantics() != null) {
            character.semantics().semanticGroups().forEach(
                    semanticGroup -> {
                        var rmGroupEntity = kanjidic2Repository.semanticGroupRepository().save(
                                Kanjidic2SemanticGroup.builder()
                                        .character(characterEntity)
                                        .build());

                        if (semanticGroup.readings() != null) {
                            semanticGroup.readings().forEach(
                                    reading -> kanjidic2Repository.readingRepository().save(
                                            Kanjidic2Reading.builder()
                                                    .semanticGroup(rmGroupEntity)
                                                    .element(reading.element())
                                                    .type(reading.type())
                                                    .onType(reading.onType())
                                                    .rStatus(reading.rStatus())
                                                    .build()));
                        }

                        if (semanticGroup.meanings() != null) {
                            semanticGroup.meanings().forEach(
                                    meaning -> kanjidic2Repository.meaningRepository().save(
                                            Kanjidic2Meaning.builder()
                                                    .semanticGroup(rmGroupEntity)
                                                    .element(meaning.element())
                                                    .languageCode(meaning.languageCode())
                                                    .build()));
                        }
                    }
            );
        }

        if (character.metadata().variants() != null) {
            character.metadata().variants().forEach(
                    variant -> kanjidic2Repository.variantRepository().save(
                            Kanjidic2Variant.builder()
                                    .character(characterEntity)
                                    .element(variant.element())
                                    .type(variant.type())
                                    .build()));
        }
    }

    /**
     * Persist a parsed JMDict entry
     *
     * @param entry to be persisted
     */
    private void saveJMDictEntry(JMDictEntryDto entry, Map<String, List<RubyDto>> jmdictFurigana) {
        {
            log.trace("Persisting JMDict entry {}", entry);

            var wordsMatchingKanji = enrichWithKanjidic2(entry.kanji());

            var entryEntity = jmdictRepository.entryRepository().save(JMDictEntry.builder()
                    .entrySequence(entry.entrySequence())
                    .linkedCharacters(wordsMatchingKanji)
                    .build());

            if (entry.kanji() != null) {
                entry.kanji().forEach(kanji ->
                        jmdictRepository.kanjiRepository().save(JMDictKanji.builder()
                                .entry(entryEntity)
                                .element(kanji.element())
                                .orthographyInformation(kanji.orthographyInformation())
                                .priorityInformation(kanji.priorityInformation())
                                .build()));
            }

            entry.readings().forEach(reading -> {
                var readingEntity = jmdictRepository.readingRepository().save(JMDictReading.builder()
                        .entry(entryEntity).element(reading.element())
                        .nokanji(reading.nokanji())
                        .readingInformation(reading.readingInformation())
                        .priorityInformation(reading.priorityInformation())
                        .alternativeReadings(reading.alternativeReadings())
                        .build());

                if (entry.kanji() != null) {
                    entry.kanji().forEach(kanji -> {
                        var furiganaMatch = jmdictFurigana.get(kanji.element() + "#" + reading.element());
                        var count = 0;
                        if (furiganaMatch != null) {
                            for (RubyDto ruby : furiganaMatch) {
                                jmdictRepository.readingFuriganaRepository().save(JMDictReadingFurigana.builder()
                                        .reading(readingEntity)
                                        .element(ruby.ruby())
                                        .kana(ruby.rt())
                                        .position(count)
                                        .build()
                                );
                                count += ruby.ruby().length();
                            }
                        } else {
                            log.warn("No furigana for JMDict entry {} ({})", kanji.element(), reading.element());
                        }
                    });
                }
            });

            entry.senses().forEach(sense -> {
                var senseEntity = jmdictRepository.senseRepository().save(JMDictSense.builder()
                        .entry(entryEntity)
                        .antonyms(sense.antonyms())
                        .crossReferences(sense.crossReferences())
                        .dialects(sense.dialects())
                        .fieldsOfApplication(sense.fieldsOfApplication())
                        .limitedToKanji(sense.limitedToKanji())
                        .limitedToReadings(sense.limitedToReadings())
                        .miscellaneousInformation(sense.miscellaneousInformation())
                        .partOfSpeech(sense.partOfSpeech())
                        .senseInformation(sense.senseInformation())
                        .build());

                if (sense.loanwordSources() != null) {
                    sense.loanwordSources().forEach(languageSource ->
                            jmdictRepository.languageSourceRepository().save(JMDictLoanwordSource.builder()
                                    .sense(senseEntity)
                                    .element(languageSource.element())
                                    .languageCode(languageSource.languageCode())
                                    .semanticCoverage(languageSource.semanticCoverage())
                                    .isConstructedFromSourceLanguageWord(languageSource.isConstructedFromSourceLanguageWord())
                                    .build()));
                }

                if (sense.glosses() != null) {
                    sense.glosses().forEach(gloss ->
                            jmdictRepository.glossRepository().save(JMDictGloss.builder()
                                    .sense(senseEntity)
                                    .element(gloss.element())
                                    .languageCode(gloss.languageCode())
                                    .gender(gloss.gender())
                                    .semanticProperty(gloss.semanticProperty())
                                    .build()));
                }
            });
        }
    }

    /**
     * Persist a parsed JMNEDict entry
     *
     * @param entry to be persisted
     */
    private void saveJMNEDictEntry(JMNEDictEntryDto entry, Map<String, List<RubyDto>> jmnedictFurigana) {
        {
            log.trace("Persisting Jmnedict entry {}", entry);

            var wordsMatchingKanji = enrichWithKanjidic2(entry.kanji());

            var entryEntity = jmnedictRepository.entryRepository().save(JMNEDictEntry.builder()
                    .linkedCharacters(wordsMatchingKanji)
                    .build());

            if (entry.kanji() != null) {
                entry.kanji().forEach(kanji ->
                        jmnedictRepository.kanjiRepository().save(JMNEDictKanji.builder()
                                .entry(entryEntity)
                                .element(kanji.element())
                                .orthographyInformation(kanji.orthographyInformation())
                                .priorityInformation(kanji.priorityInformation())
                                .build()));
            }

            entry.readings().forEach(reading -> {
                var readingEntity = jmnedictRepository.readingRepository().save(JMNEDictReading.builder()
                        .entry(entryEntity)
                        .element(reading.element())
                        .readingInformation(reading.readingInformation())
                        .priorityInformation(reading.priorityInformation())
                        .alternativeReadings(reading.alternativeReadings())
                        .build());

                if (entry.kanji() != null) {
                    entry.kanji().forEach(kanji -> {
                        var furigana = jmnedictFurigana.get(kanji.element() + "#" + reading.element());
                        var count = 0;
                        if (furigana != null) {
                            for (RubyDto ruby : furigana) {
                                jmnedictRepository.readingFuriganaRepository().save(JMNEDictReadingFurigana.builder()
                                        .reading(readingEntity)
                                        .element(ruby.ruby())
                                        .kana(ruby.rt())
                                        .position(count)
                                        .build()
                                );
                                count += ruby.ruby().length();
                            }
                        } else {
                            log.warn("No furigana for JMNEDict entry {} ({})", kanji.element(), reading.element());

                        }
                    });
                }
            });

            entry.translations().forEach(translation -> {
                var translationEntity = jmnedictRepository.translationRepository().save(JMNEDictTranslation.builder()
                        .entry(entryEntity)
                        .nameTypes(translation.nameTypes())
                        .build());

                translation.details().forEach(detail ->
                        jmnedictRepository.translationDetailRepository().save(JMNEDictTranslationDetail.builder()
                                .translation(translationEntity)
                                .translatedName(detail.element())
                                .languageCode(detail.languageCode())
                                .build()));
            });
        }
    }

    /**
     * Matches input KanjiDtos against Kanjidic2 data, returning all unique located kanji for the given KanjiDto
     *
     * @param kanji input KanjiDtos
     * @return matching Kanjidic2Characters
     */
    private Set<Kanjidic2Character> enrichWithKanjidic2(Set<KanjiDto> kanji) {
        Set<Character> kanjiMatches = new HashSet<>();
        if (kanji != null) {
            kanjiMatches = locateKanjiInWord(
                    kanji.stream()
                            .map(KanjiDto::element)
                            .collect(Collectors.toSet()));
        }

        return kanjiMatches.stream()
                .map(String::valueOf)
                .map(kanjidic2Repository.characterRepository()::findByLiteral)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
    }

    /**
     * Returns true if `c` is a kanji
     *
     * @param c character to test
     * @return kanji-ness of `c`
     */
    private static boolean matchKanji(Character c) {
        var toUnicode = Integer.parseInt(String.format("%04x", (int) c), 16);
        return (toUnicode >= 0x4e00 && toUnicode <= 0x9fbf); // Unicode ranges for kanji
    }

    /**
     * Parses a set of strings (words) and returns a set of unique found kanji
     *
     * @param words words to find kanji in
     * @return all unique kanji matches in the set
     */
    private static Set<Character> locateKanjiInWord(Set<String> words) {
        Set<Character> foundKanji = new TreeSet<>(); // to preserve order

        words.forEach(word -> {
            for (char c : word.toCharArray()) { // bleh, if only there was a CharStream
                if (matchKanji(c)) {
                    foundKanji.add(c);
                }
            }
        });

        return foundKanji;
    }

    @Override
    public void run(String... args) throws Exception {
        var start = System.currentTimeMillis();

        var jmdictFurigana = readFuriganaData(jmdictFuriganaFile);
        var jmnedictFurigana = readFuriganaData(jmnedictFuriganaFile);

        List<JMDictEntryDto> jmdictEntries = readXmlData(jmdictFile, JMDictEntryDto.class);
        List<JMNEDictEntryDto> jmnedictEntries = readXmlData(jmnedictFile, JMNEDictEntryDto.class);
        List<Kanjidic2CharacterDto> kanjidic2Entries = readXmlData(kanjidic2File, Kanjidic2CharacterDto.class);

        kanjidic2Entries.parallelStream().forEach(this::saveKanjidic2Character);
        jmdictEntries.parallelStream().forEach(entry -> saveJMDictEntry(entry, jmdictFurigana));
        jmnedictEntries.parallelStream().forEach(entry -> saveJMNEDictEntry(entry, jmnedictFurigana));

        log.info("Completed in {}ms", System.currentTimeMillis() - start);
    }
}
