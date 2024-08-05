package ch.blelo.kanjiguide.runner;

import ch.blelo.kanjiguide.model.dto.jmdict.EntryDto;
import ch.blelo.kanjiguide.model.dto.kanjidic2.CharacterDto;
import ch.blelo.kanjiguide.model.entity.jmdict.*;
import ch.blelo.kanjiguide.model.entity.kanjidic2.Character;
import ch.blelo.kanjiguide.model.entity.kanjidic2.*;
import ch.blelo.kanjiguide.repository.jmdict.*;
import ch.blelo.kanjiguide.repository.kanjidic2.*;
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

@Profile("ingestion")
@Component
@Slf4j
public class DataIngestionRunner implements CommandLineRunner {
    @Value("${file.jmdict}")
    private String jmdictFile;

    @Value("${file.kanjidic2}")
    private String kanjidic2File;

    private final EntryRepository entryRepository;
    private final GlossRepository glossRepository;
    private final KanjiRepository kanjiRepository;
    private final LanguageSourceRepository languageSourceRepository;
    private final JReadingRepository jReadingRepository;
    private final SenseRepository senseRepository;

    private final CharacterRepository characterRepository;
    private final CodepointRepository codepointRepository;
    private final DictionaryReferenceRepository dictionaryReferenceRepository;
    private final MeaningRepository meaningRepository;
    private final QueryCodeRepository queryCodeRepository;
    private final RadicalRepository radicalRepository;
    private final KReadingRepository kReadingRepository;
    private final SemanticGroupRepository semanticGroupRepository;
    private final VariantRepository variantRepository;

    public DataIngestionRunner(
            @Autowired EntryRepository entryRepository,
            @Autowired GlossRepository glossRepository,
            @Autowired KanjiRepository kanjiRepository,
            @Autowired LanguageSourceRepository languageSourceRepository,
            @Autowired JReadingRepository jReadingRepository,
            @Autowired SenseRepository senseRepository,
            @Autowired CharacterRepository characterRepository,
            @Autowired CodepointRepository codepointRepository,
            @Autowired DictionaryReferenceRepository dictionaryReferenceRepository,
            @Autowired MeaningRepository meaningRepository,
            @Autowired QueryCodeRepository queryCodeRepository,
            @Autowired RadicalRepository radicalRepository,
            @Autowired KReadingRepository kReadingRepository,
            @Autowired SemanticGroupRepository semanticGroupRepository,
            @Autowired VariantRepository variantRepository
    ) {
        this.entryRepository = entryRepository;
        this.glossRepository = glossRepository;
        this.kanjiRepository = kanjiRepository;
        this.languageSourceRepository = languageSourceRepository;
        this.jReadingRepository = jReadingRepository;
        this.senseRepository = senseRepository;
        this.characterRepository = characterRepository;
        this.codepointRepository = codepointRepository;
        this.dictionaryReferenceRepository = dictionaryReferenceRepository;
        this.meaningRepository = meaningRepository;
        this.queryCodeRepository = queryCodeRepository;
        this.radicalRepository = radicalRepository;
        this.kReadingRepository = kReadingRepository;
        this.semanticGroupRepository = semanticGroupRepository;
        this.variantRepository = variantRepository;
    }

//    private static final XmlMapper mapper =
//            XmlMapper
//                    .builder()
//                    .build();

//    @SneakyThrows
//    private static XMLStreamReader createReader(String filePath) {
//        var xmlInputFactory = XMLInputFactory.newInstance();
//        xmlInputFactory.setProperty("com.ctc.wstx.maxEntityCount", 500000);
//
//        return xmlInputFactory.createXMLStreamReader(
//                new FileInputStream(filePath)
//        );
//    }
//
//        private <T> List<T> readEntries(String filePath, Class<T> contentClass) {
//        List<T> entries;
//        var type = mapper.getTypeFactory().constructParametricType(List.class, contentClass);
//        try {
//            var start = System.currentTimeMillis();
//            entries = mapper.readValue(createReader(filePath), type);
//            log.info("Took {}ms to read {} entries", System.currentTimeMillis() - start, entries.size());
//        } catch (IOException e) {
//            throw new RuntimeException("Unable to read XML for file %s".formatted(filePath), e);
//        }
//
//        return entries;
//    }
//
//    private void populateDatabase(List<EntryDto> jmdictEntries, List<CharacterDto> kanjidic2Entries) {
//        jmdictEntries.forEach(entry -> {
//            log.info("Persisting JMDict entry {}", entry);
//            var entryEntity = entryRepository.save(Entry.builder()
//                    .entrySequence(entry.entrySequence())
//                    .build());
//
//            entry.kanji().forEach(kanji ->
//                    kanjiRepository.save(Kanji.builder()
//                            .entry(entryEntity)
//                            .element(kanji.element())
//                            .orthographyInformation(kanji.orthographyInformation())
//                            .priorityInformation(kanji.priorityInformation())
//                            .build()
//                    )
//            );
//
//            entry.readings().forEach(reading ->
//                    jReadingRepository.save(JReading.builder()
//                            .entry(entryEntity)
//                            .element(reading.element())
//                            .nokanji(reading.nokanji())
//                            .readingInformation(reading.readingInformation())
//                            .priorityInformation(reading.priorityInformation())
//                            .alternativeReadings(reading.alternativeReadings())
//                            .build()
//                    )
//            );
//
//            entry.senses().forEach(sense -> {
//                var senseEntity = senseRepository.save(Sense.builder()
//                        .entry(entryEntity)
//                        .antonyms(sense.antonyms())
//                        .crossReferences(sense.crossReferences())
//                        .dialects(sense.dialects())
//                        .fieldsOfApplication(sense.fieldsOfApplication())
//                        .limitedToKanji(sense.limitedToKanji())
//                        .limitedToReadings(sense.limitedToReadings())
//                        .miscellaneousInformation(sense.miscellaneousInformation())
//                        .partOfSpeech(sense.partOfSpeech())
//                        .senseInformation(sense.senseInformation())
//                        .build()
//                );
//
//                sense.loanwordSources().forEach(languageSource ->
//                        languageSourceRepository.save(LoanwordSource.builder()
//                                .sense(senseEntity)
//                                .element(languageSource.element())
//                                .languageCode(languageSource.languageCode())
//                                .semanticCoverage(languageSource.semanticCoverage())
//                                .isConstructedFromSourceLanguageWord(languageSource.isConstructedFromSourceLanguageWord())
//                                .build()
//                        )
//                );
//
//                sense.glosses().forEach(gloss ->
//                        glossRepository.save(Gloss.builder()
//                                .sense(senseEntity)
//                                .element(gloss.element())
//                                .languageCode(gloss.languageCode())
//                                .gender(gloss.gender())
//                                .semanticProperty(gloss.semanticProperty())
//                                .build()
//                        )
//                );
//            });
//        });
//
//        kanjidic2Entries.forEach(
//                character -> {
//                    log.info("Persisting Kanjidic2 character {}", character);
//                    var characterBuilder = Character.builder()
//                            .literal(character.literal())
//                            .frequency(character.metadata().frequency())
//                            .schoolGrade(character.metadata().schoolGrade())
//                            .jlptGrade(character.metadata().jlptGrade())
//                            .strokeCount(character.metadata().strokeCount())
//                            .radicalNames(character.metadata().radicalNames());
//
//                    if (character.semantics() != null) {
//                        characterBuilder.nanori(character.semantics().nanori());
//                    }
//
//                    var characterEntity = characterRepository.save(characterBuilder.build());
//
//                    character.codepoints().forEach(
//                            codepoint -> codepointRepository.save(
//                                    Codepoint.builder()
//                                            .character(characterEntity)
//                                            .element(codepoint.element())
//                                            .type(codepoint.type())
//                                            .build()
//                            )
//                    );
//
//                    character.radicals().forEach(
//                            radical -> radicalRepository.save(
//                                    Radical.builder()
//                                            .character(characterEntity)
//                                            .element(radical.element())
//                                            .type(radical.type())
//                                            .build()
//                            )
//                    );
//
//                    if (character.dictionaryReferences() != null) {
//                        character.dictionaryReferences().forEach(
//                                dictionaryReference -> dictionaryReferenceRepository.save(
//                                        DictionaryReference.builder()
//                                                .character(characterEntity)
//                                                .element(dictionaryReference.element())
//                                                .type(dictionaryReference.type())
//                                                .morohashiVolume(dictionaryReference.morohashiVolume())
//                                                .morohashiPage(dictionaryReference.morohashiPage())
//                                                .build()
//                                )
//                        );
//                    }
//
//                    if (character.queryCodes() != null) {
//                        character.queryCodes().forEach(
//                                queryCode -> queryCodeRepository.save(
//                                        QueryCode.builder()
//                                                .character(characterEntity)
//                                                .element(queryCode.element())
//                                                .type(queryCode.type())
//                                                .skipMisclassification(queryCode.skipMisclassification())
//                                                .build()
//                                )
//                        );
//                    }
//
//                    if (character.semantics() != null) {
//                        character.semantics().semanticGroups().forEach(
//                                semanticGroup -> {
//                                    var rmGroupEntity = semanticGroupRepository.save(
//                                            SemanticGroup.builder()
//                                                    .character(characterEntity)
//                                                    .build()
//                                    );
//
//                                    if (semanticGroup.readings() != null) {
//                                        semanticGroup.readings().forEach(
//                                                reading -> kReadingRepository.save(
//                                                        KReading.builder()
//                                                                .semanticGroup(rmGroupEntity)
//                                                                .element(reading.element())
//                                                                .type(reading.type())
//                                                                .onType(reading.onType())
//                                                                .rStatus(reading.rStatus())
//                                                                .build()
//                                                )
//                                        );
//                                    }
//
//                                    if (semanticGroup.meanings() != null) {
//                                        semanticGroup.meanings().forEach(
//                                                meaning -> meaningRepository.save(
//                                                        Meaning.builder()
//                                                                .semanticGroup(rmGroupEntity)
//                                                                .element(meaning.element())
//                                                                .languageCode(meaning.languageCode())
//                                                                .build()
//                                                )
//                                        );
//                                    }
//                                }
//                        );
//                    }
//
//                    if (character.metadata().variants() != null) {
//                        character.metadata().variants().forEach(
//                                variant -> variantRepository.save(
//                                        Variant.builder()
//                                                .character(characterEntity)
//                                                .element(variant.element())
//                                                .type(variant.type())
//                                                .build()
//                                )
//                        );
//                    }
//                }
//        );
//    }

    @Override
    public void run(String... args) throws Exception {
//        var start = System.currentTimeMillis();
//        List<EntryDto> jmdictEntries = readEntries(jmdictFile, EntryDto.class);
//        List<CharacterDto> kanjidic2Entries = readEntries(kanjidic2File, CharacterDto.class);
//        populateDatabase(jmdictEntries, kanjidic2Entries);
//        log.info("Completed in {}ms", System.currentTimeMillis() - start);
}
}
