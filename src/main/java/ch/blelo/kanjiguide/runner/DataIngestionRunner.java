package ch.blelo.kanjiguide.runner;

import ch.blelo.kanjiguide.model.dto.jmdict.EntryDto;
import ch.blelo.kanjiguide.model.dto.jmdict.KanjiDto;
import ch.blelo.kanjiguide.model.dto.kanjidic2.CharacterDto;
import ch.blelo.kanjiguide.model.entity.jmdict.*;
import ch.blelo.kanjiguide.model.entity.kanjidic2.Character;
import ch.blelo.kanjiguide.model.entity.kanjidic2.*;
import ch.blelo.kanjiguide.repository.jmdict.*;
import ch.blelo.kanjiguide.repository.kanjidic2.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * <p>Ingests data from</p>
 * <ul>
 *     <li>JMDict</li>
 *     <li>Kanjidic2</li>
 * </ul>
 *
 * <p>into a common database schema accessed by the rest of the application</p>
 */
@Profile("ingestion")
@Component
@Slf4j
public class DataIngestionRunner implements CommandLineRunner {
    @Value("${file.jmdict}")
    private String jmdictFile;

    @Value("${file.kanjidic2}")
    private String kanjidic2File;

    // TODO: add more data sources here...

    private final JMDictRepositoryFacade jmdict;
    private final Kanjidic2RepositoryFacade kanjidic2;

    public DataIngestionRunner(
            @Autowired JMDictRepositoryFacade jmdict,
            @Autowired Kanjidic2RepositoryFacade kanjidic2
    ) {
        this.jmdict = jmdict;
        this.kanjidic2 = kanjidic2;
    }

    private static final XmlMapper mapper =
            XmlMapper
                    .builder()
                    .build();

    @SneakyThrows
    private static XMLStreamReader createReader(String filePath) {
        var xmlInputFactory = XMLInputFactory.newInstance();
        xmlInputFactory.setProperty("com.ctc.wstx.maxEntityCount", 500000);

        return xmlInputFactory.createXMLStreamReader(
                new FileInputStream(filePath)
        );
    }

    private <T> List<T> readEntries(String filePath, Class<T> contentClass) {
        List<T> entries;
        var type = mapper.getTypeFactory().constructParametricType(List.class, contentClass);
        try {
            var start = System.currentTimeMillis();
            entries = mapper.readValue(createReader(filePath), type);
            log.info("Took {}ms to read {} entries", System.currentTimeMillis() - start, entries.size());
        } catch (IOException e) {
            throw new RuntimeException("Unable to read XML for file %s".formatted(filePath), e);
        }

        return entries;
    }

    private void populateDatabase(List<EntryDto> jmdictEntries, List<CharacterDto> kanjidic2Entries) {

        kanjidic2Entries.forEach(
                character -> {
                    log.info("Persisting Kanjidic2 character {}", character);
                    var characterBuilder = Character.builder()
                            .literal(character.literal())
                            .frequency(character.metadata().frequency())
                            .schoolGrade(character.metadata().schoolGrade())
                            .jlptGrade(character.metadata().jlptGrade())
                            .strokeCount(character.metadata().strokeCount())
                            .radicalNames(character.metadata().radicalNames());

                    if (character.semantics() != null) {
                        characterBuilder.nanori(character.semantics().nanori());
                    }

                    var characterEntity = kanjidic2.characterRepository().save(characterBuilder.build());

                    character.codepoints().forEach(
                            codepoint -> kanjidic2.codepointRepository().save(
                                    Codepoint.builder()
                                            .character(characterEntity)
                                            .element(codepoint.element())
                                            .type(codepoint.type())
                                            .build()
                            )
                    );

                    character.radicals().forEach(
                            radical -> kanjidic2.radicalRepository().save(
                                    Radical.builder()
                                            .character(characterEntity)
                                            .element(radical.element())
                                            .type(radical.type())
                                            .build()
                            )
                    );

                    if (character.dictionaryReferences() != null) {
                        character.dictionaryReferences().forEach(
                                dictionaryReference -> kanjidic2.dictionaryReferenceRepository().save(
                                        DictionaryReference.builder()
                                                .character(characterEntity)
                                                .element(dictionaryReference.element())
                                                .type(dictionaryReference.type())
                                                .morohashiVolume(dictionaryReference.morohashiVolume())
                                                .morohashiPage(dictionaryReference.morohashiPage())
                                                .build()
                                )
                        );
                    }

                    if (character.queryCodes() != null) {
                        character.queryCodes().forEach(
                                queryCode -> kanjidic2.queryCodeRepository().save(
                                        QueryCode.builder()
                                                .character(characterEntity)
                                                .element(queryCode.element())
                                                .type(queryCode.type())
                                                .skipMisclassification(queryCode.skipMisclassification())
                                                .build()
                                )
                        );
                    }

                    if (character.semantics() != null) {
                        character.semantics().semanticGroups().forEach(
                                semanticGroup -> {
                                    var rmGroupEntity = kanjidic2.semanticGroupRepository().save(
                                            SemanticGroup.builder()
                                                    .character(characterEntity)
                                                    .build()
                                    );

                                    if (semanticGroup.readings() != null) {
                                        semanticGroup.readings().forEach(
                                                reading -> kanjidic2.kReadingRepository().save(
                                                        KReading.builder()
                                                                .semanticGroup(rmGroupEntity)
                                                                .element(reading.element())
                                                                .type(reading.type())
                                                                .onType(reading.onType())
                                                                .rStatus(reading.rStatus())
                                                                .build()
                                                )
                                        );
                                    }

                                    if (semanticGroup.meanings() != null) {
                                        semanticGroup.meanings().forEach(
                                                meaning -> kanjidic2.meaningRepository().save(
                                                        Meaning.builder()
                                                                .semanticGroup(rmGroupEntity)
                                                                .element(meaning.element())
                                                                .languageCode(meaning.languageCode())
                                                                .build()
                                                )
                                        );
                                    }
                                }
                        );
                    }

                    if (character.metadata().variants() != null) {
                        character.metadata().variants().forEach(
                                variant -> kanjidic2.variantRepository().save(
                                        Variant.builder()
                                                .character(characterEntity)
                                                .element(variant.element())
                                                .type(variant.type())
                                                .build()
                                )
                        );
                    }
                }
        );

        jmdictEntries.forEach(entry -> {
            log.info("Persisting JMDict entry {}", entry);

            var kanjiMatches = locateKanjiInWord(
                    entry.kanji().stream()
                            .map(KanjiDto::element)
                            .collect(Collectors.toSet()
                            )
            );

            var wordsMatchingKanji = kanjiMatches.stream()
                    .map(kanjidic2.characterRepository()::findByLiteral)
                    .flatMap(List::stream)
                    .collect(Collectors.toSet());

            var entryEntity = jmdict.entryRepository().save(Entry.builder()
                    .entrySequence(entry.entrySequence())
                            .linkedCharacters(wordsMatchingKanji)
                    .build());

            entry.kanji().forEach(kanji -> {
                        jmdict.kanjiRepository().save(Kanji.builder()
                                .entry(entryEntity)
                                .element(kanji.element())
                                .orthographyInformation(kanji.orthographyInformation())
                                .priorityInformation(kanji.priorityInformation())
                                .build()
                        );
                    }
            );

            entry.readings().forEach(reading ->
                    jmdict.jReadingRepository().save(JReading.builder()
                            .entry(entryEntity)
                            .element(reading.element())
                            .nokanji(reading.nokanji())
                            .readingInformation(reading.readingInformation())
                            .priorityInformation(reading.priorityInformation())
                            .alternativeReadings(reading.alternativeReadings())
                            .build()
                    )
            );

            entry.senses().forEach(sense -> {
                var senseEntity = jmdict.senseRepository().save(Sense.builder()
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
                        .build()
                );

                sense.loanwordSources().forEach(languageSource ->
                        jmdict.languageSourceRepository().save(LoanwordSource.builder()
                                .sense(senseEntity)
                                .element(languageSource.element())
                                .languageCode(languageSource.languageCode())
                                .semanticCoverage(languageSource.semanticCoverage())
                                .isConstructedFromSourceLanguageWord(languageSource.isConstructedFromSourceLanguageWord())
                                .build()
                        )
                );

                sense.glosses().forEach(gloss ->
                        jmdict.glossRepository().save(Gloss.builder()
                                .sense(senseEntity)
                                .element(gloss.element())
                                .languageCode(gloss.languageCode())
                                .gender(gloss.gender())
                                .semanticProperty(gloss.semanticProperty())
                                .build()
                        )
                );
            });
        });
    }

    private static Set<String> locateKanjiInWord(Set<String> words) {
        var result = new TreeSet<String>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                var toUnicode = Integer.parseInt(String.format("%04x", (int) c), 16);
                if (toUnicode >= 0x4e00 && toUnicode <= 0x9fbf) {
                    result.add(String.valueOf(c));
                }
            }
        }

        return result;
    }

    @Override
    public void run(String... args) throws Exception {
        var start = System.currentTimeMillis();
        List<EntryDto> jmdictEntries = readEntries(jmdictFile, EntryDto.class);
        List<CharacterDto> kanjidic2Entries = readEntries(kanjidic2File, CharacterDto.class);
        populateDatabase(jmdictEntries, kanjidic2Entries);
        log.info("Completed in {}ms", System.currentTimeMillis() - start);
    }
}
