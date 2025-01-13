package ch.blelo.jpapi.repository.jmdict;

import org.springframework.stereotype.Repository;

@Repository
public class JMDictRepositoryFacade {

    private final JMDictEntryRepository entryRepository;
    private final JMDictKanjiRepository kanjiRepository;
    private final JMDictReadingFuriganaRepository readingFuriganaRepository;
    private final JMDictReadingRepository readingRepository;
    private final JMDictSenseRepository senseRepository;
    private final JMDictGlossRepository glossRepository;
    private final JMDictLoanwordSourceRepository loanwordSourceRepository;

    public JMDictRepositoryFacade(
            JMDictEntryRepository entryRepository,
            JMDictKanjiRepository kanjiRepository,
            JMDictReadingRepository readingRepository,
            JMDictReadingFuriganaRepository readingFuriganaRepository,
            JMDictSenseRepository senseRepository,
            JMDictGlossRepository glossRepository,
            JMDictLoanwordSourceRepository loanwordSourceRepository
    ) {
        this.entryRepository = entryRepository;
        this.kanjiRepository = kanjiRepository;
        this.readingRepository = readingRepository;
        this.readingFuriganaRepository = readingFuriganaRepository;
        this.senseRepository = senseRepository;
        this.glossRepository = glossRepository;
        this.loanwordSourceRepository = loanwordSourceRepository;
    }

    public JMDictEntryRepository entryRepository() {
        return entryRepository;
    }

    public JMDictKanjiRepository kanjiRepository() {
        return kanjiRepository;
    }

    public JMDictReadingRepository readingRepository() {
        return readingRepository;
    }

    public JMDictReadingFuriganaRepository readingFuriganaRepository() {
        return readingFuriganaRepository;
    }

    public JMDictSenseRepository senseRepository() {
        return senseRepository;
    }

    public JMDictGlossRepository glossRepository() {
        return glossRepository;
    }

    public JMDictLoanwordSourceRepository languageSourceRepository() {
        return loanwordSourceRepository;
    }
}
