package ch.blelo.jpapi.repository.kanjidic2;

import org.springframework.stereotype.Repository;

@Repository
public class Kanjidic2RepositoryFacade {

    private final Kanjidic2CharacterRepository characterRepository;
    private final Kanjidic2CodepointRepository codepointRepository;
    private final Kanjidic2DictionaryReferenceRepository dictionaryReferenceRepository;
    private final Kanjidic2ReadingRepository readingRepository;
    private final Kanjidic2MeaningRepository meaningRepository;
    private final Kanjidic2QueryCodeRepository queryCodeRepository;
    private final Kanjidic2RadicalRepository radicalRepository;
    private final Kanjidic2SemanticGroupRepository semanticGroupRepository;
    private final Kanjidic2VariantRepository variantRepository;

    public Kanjidic2RepositoryFacade(
            Kanjidic2CharacterRepository characterRepository,
            Kanjidic2CodepointRepository codepointRepository,
            Kanjidic2DictionaryReferenceRepository dictionaryReferenceRepository,
            Kanjidic2ReadingRepository readingRepository,
            Kanjidic2MeaningRepository meaningRepository,
            Kanjidic2QueryCodeRepository queryCodeRepository,
            Kanjidic2RadicalRepository radicalRepository,
            Kanjidic2SemanticGroupRepository semanticGroupRepository,
            Kanjidic2VariantRepository variantRepository
    ) {
        this.characterRepository = characterRepository;
        this.codepointRepository = codepointRepository;
        this.dictionaryReferenceRepository = dictionaryReferenceRepository;
        this.readingRepository = readingRepository;
        this.meaningRepository = meaningRepository;
        this.queryCodeRepository = queryCodeRepository;
        this.radicalRepository = radicalRepository;
        this.semanticGroupRepository = semanticGroupRepository;
        this.variantRepository = variantRepository;
    }

    public Kanjidic2CharacterRepository characterRepository() {
        return characterRepository;
    }

    public Kanjidic2CodepointRepository codepointRepository() {
        return codepointRepository;
    }

    public Kanjidic2DictionaryReferenceRepository dictionaryReferenceRepository() {
        return dictionaryReferenceRepository;
    }

    public Kanjidic2ReadingRepository readingRepository() {
        return readingRepository;
    }

    public Kanjidic2MeaningRepository meaningRepository() {
        return meaningRepository;
    }

    public Kanjidic2QueryCodeRepository queryCodeRepository() {
        return queryCodeRepository;
    }

    public Kanjidic2RadicalRepository radicalRepository() {
        return radicalRepository;
    }

    public Kanjidic2SemanticGroupRepository semanticGroupRepository() {
        return semanticGroupRepository;
    }

    public Kanjidic2VariantRepository variantRepository() {
        return variantRepository;
    }
}
