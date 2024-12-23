package ch.blelo.kanjiguide.repository.kanjidic2;

import org.springframework.stereotype.Repository;

@Repository
public class Kanjidic2RepositoryFacade {

    private final CharacterRepository characterRepository;
    private final CodepointRepository codepointRepository;
    private final DictionaryReferenceRepository dictionaryReferenceRepository;
    private final KReadingRepository kReadingRepository;
    private final MeaningRepository meaningRepository;
    private final QueryCodeRepository queryCodeRepository;
    private final RadicalRepository radicalRepository;
    private final SemanticGroupRepository semanticGroupRepository;
    private final VariantRepository variantRepository;

    public Kanjidic2RepositoryFacade(
            CharacterRepository characterRepository,
            CodepointRepository codepointRepository,
            DictionaryReferenceRepository dictionaryReferenceRepository,
            KReadingRepository kReadingRepository,
            MeaningRepository meaningRepository,
            QueryCodeRepository queryCodeRepository,
            RadicalRepository radicalRepository,
            SemanticGroupRepository semanticGroupRepository,
            VariantRepository variantRepository
    ) {
        this.characterRepository = characterRepository;
        this.codepointRepository = codepointRepository;
        this.dictionaryReferenceRepository = dictionaryReferenceRepository;
        this.kReadingRepository = kReadingRepository;
        this.meaningRepository = meaningRepository;
        this.queryCodeRepository = queryCodeRepository;
        this.radicalRepository = radicalRepository;
        this.semanticGroupRepository = semanticGroupRepository;
        this.variantRepository = variantRepository;
    }

    public CharacterRepository characterRepository() {
        return characterRepository;
    }

    public CodepointRepository codepointRepository() {
        return codepointRepository;
    }

    public DictionaryReferenceRepository dictionaryReferenceRepository() {
        return dictionaryReferenceRepository;
    }

    public KReadingRepository kReadingRepository() {
        return kReadingRepository;
    }

    public MeaningRepository meaningRepository() {
        return meaningRepository;
    }

    public QueryCodeRepository queryCodeRepository() {
        return queryCodeRepository;
    }

    public RadicalRepository radicalRepository() {
        return radicalRepository;
    }

    public SemanticGroupRepository semanticGroupRepository() {
        return semanticGroupRepository;
    }

    public VariantRepository variantRepository() {
        return variantRepository;
    }
}
