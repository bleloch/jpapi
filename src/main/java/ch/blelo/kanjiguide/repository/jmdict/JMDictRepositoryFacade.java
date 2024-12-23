package ch.blelo.kanjiguide.repository.jmdict;

import org.springframework.stereotype.Repository;

@Repository
public class JMDictRepositoryFacade {

    private final EntryRepository entryRepository;
    private final GlossRepository glossRepository;
    private final JReadingRepository jReadingRepository;
    private final KanjiRepository kanjiRepository;
    private final LanguageSourceRepository languageSourceRepository;
    private final SenseRepository senseRepository;

    public JMDictRepositoryFacade(
            EntryRepository entryRepository,
            GlossRepository glossRepository,
            JReadingRepository jReadingRepository,
            KanjiRepository kanjiRepository,
            LanguageSourceRepository languageSourceRepository,
            SenseRepository senseRepository
    ) {
        this.entryRepository = entryRepository;
        this.glossRepository = glossRepository;
        this.jReadingRepository = jReadingRepository;
        this.kanjiRepository = kanjiRepository;
        this.languageSourceRepository = languageSourceRepository;
        this.senseRepository = senseRepository;
    }

    public EntryRepository entryRepository() {
        return entryRepository;
    }

    public GlossRepository glossRepository() {
        return glossRepository;
    }

    public JReadingRepository jReadingRepository() {
        return jReadingRepository;
    }

    public KanjiRepository kanjiRepository() {
        return kanjiRepository;
    }

    public LanguageSourceRepository languageSourceRepository() {
        return languageSourceRepository;
    }

    public SenseRepository senseRepository() {
        return senseRepository;
    }
}
