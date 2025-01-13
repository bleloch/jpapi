package ch.blelo.jpapi.repository.jmnedict;

import org.springframework.stereotype.Repository;

@Repository
public class JMNEDictRepositoryFacade {
    private final JMNEDictEntryRepository entryRepository;
    private final JMNEDictKanjiRepository kanjiRepository;
    private final JMNEDictReadingRepository readingRepository;
    private final JMNEDictReadingFuriganaRepository readingFuriganaRepository;
    private final JMNEDictTranslationRepository translationRepository;
    private final JMNEDictTranslationDetailRepository translationDetailRepository;

    public JMNEDictRepositoryFacade(
            JMNEDictEntryRepository entryRepository,
            JMNEDictKanjiRepository kanjiRepository,
            JMNEDictReadingRepository readingRepository,
            JMNEDictReadingFuriganaRepository readingFuriganaRepository,
            JMNEDictTranslationRepository translationRepository,
            JMNEDictTranslationDetailRepository translationDetailRepository
    ) {
        this.entryRepository = entryRepository;
        this.kanjiRepository = kanjiRepository;
        this.readingRepository = readingRepository;
        this.readingFuriganaRepository = readingFuriganaRepository;
        this.translationRepository = translationRepository;
        this.translationDetailRepository = translationDetailRepository;
    }

    public JMNEDictEntryRepository entryRepository() {
        return entryRepository;
    }

    public JMNEDictKanjiRepository kanjiRepository() {
        return kanjiRepository;
    }

    public JMNEDictReadingRepository readingRepository() {
        return readingRepository;
    }

    public JMNEDictReadingFuriganaRepository readingFuriganaRepository() {
        return readingFuriganaRepository;
    }

    public JMNEDictTranslationRepository translationRepository() {
        return translationRepository;
    }

    public JMNEDictTranslationDetailRepository translationDetailRepository() {
        return translationDetailRepository;
    }
}
