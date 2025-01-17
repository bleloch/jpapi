package ch.blelo.jpapi.service;

import ch.blelo.jpapi.model.dto.jmdict.JMDictEntryDto;
import ch.blelo.jpapi.model.dto.jmnedict.JMNEDictEntryDto;
import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2CharacterDto;
import ch.blelo.jpapi.model.mapper.jmdict.JMDictEntryMapper;
import ch.blelo.jpapi.model.mapper.jmnedict.JMNEDictEntryMapper;
import ch.blelo.jpapi.model.mapper.kanjidic2.Kanjidic2CharacterMapper;
import ch.blelo.jpapi.repository.jmdict.JMDictRepositoryFacade;
import ch.blelo.jpapi.repository.jmnedict.JMNEDictRepositoryFacade;
import ch.blelo.jpapi.repository.kanjidic2.Kanjidic2RepositoryFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class SearchService {
    private final JMDictRepositoryFacade jmdictRepository;
    private final Kanjidic2RepositoryFacade kanjidic2Repository;
    private final JMNEDictRepositoryFacade jmnedictRepository;

    private final JMDictEntryMapper jmdictEntryMapper;
    private final Kanjidic2CharacterMapper kanjidic2CharacterMapper;
    private final JMNEDictEntryMapper jmnedictEntryMapper;

    public SearchService(
            JMDictRepositoryFacade jmdictRepository,
            Kanjidic2RepositoryFacade kanjidic2Repository,
            JMNEDictRepositoryFacade jmnedictRepository,
            JMDictEntryMapper jmdictEntryMapper,
            Kanjidic2CharacterMapper kanjidic2CharacterMapper,
            JMNEDictEntryMapper jmnedictEntryMapper
    ) {
        this.jmdictRepository = jmdictRepository;
        this.kanjidic2Repository = kanjidic2Repository;
        this.jmnedictRepository = jmnedictRepository;

        this.jmdictEntryMapper = jmdictEntryMapper;
        this.kanjidic2CharacterMapper = kanjidic2CharacterMapper;
        this.jmnedictEntryMapper = jmnedictEntryMapper;
    }

    @Cacheable(value = "searchKanji", key = "#searchTerm")
    public List<Kanjidic2CharacterDto> searchKanji(String searchTerm) {
        var kanjiMatches = kanjidic2Repository.characterRepository()
                .findByLiteral(searchTerm);

        return kanjiMatches.stream()
                .map(kanjidic2CharacterMapper::toDto)
                .toList();
    }

    @Cacheable(value = "searchListOfKanji", key = "#searchTerms")
    public List<Kanjidic2CharacterDto> searchKanji(List<String> searchTerms) {
        var kanjiMatches = kanjidic2Repository.characterRepository()
                .findByLiteralIn(searchTerms);

        return kanjiMatches.stream()
                .map(kanjidic2CharacterMapper::toDto)
                .toList();
    }

    // TODO - improve performance
    @Cacheable(value = "searchWord", key = "#searchTerm")
    public List<JMDictEntryDto> searchWord(String searchTerm) {
        var kanjiMatches = jmdictRepository.entryRepository()
                .findByKanjiElementIgnoreCase(searchTerm);
        var readingMatches = jmdictRepository.entryRepository()
                .findByReadingsElementIgnoreCase(searchTerm);
        var senseMatches = jmdictRepository.entryRepository()
                .findBySensesGlossesElementIgnoreCase(searchTerm);

        return Stream
                .of(kanjiMatches, readingMatches, senseMatches)
                .flatMap(List::stream)
                .map(jmdictEntryMapper::toDto)
                .distinct()
                .toList();
    }

    @Cacheable(value = "searchName", key = "#searchTerm")
    public List<JMNEDictEntryDto> searchName(String searchTerm) {
        var nameMatches = jmnedictRepository.entryRepository()
                .findByKanjiElementIgnoreCase(searchTerm);

        var result = nameMatches.stream()
                .map(jmnedictEntryMapper::toDto)
                .toList();

        return result;
    }

    @Cacheable(value = "kanji", key = "#id")
    public Kanjidic2CharacterDto getKanjiById(long id) {
        var result = kanjidic2Repository.characterRepository()
                .findById(id)
                .orElseThrow(); // throw proper exception

        return kanjidic2CharacterMapper.toDto(result);
    }

    @Cacheable(value = "word", key = "#entSeq")
    public JMDictEntryDto getWordByEntrySequence(long entSeq) {
        var result = jmdictRepository.entryRepository()
                .findByEntrySequence(entSeq); // throw proper exception

        return jmdictEntryMapper.toDto(result);
    }

    @Cacheable(value = "name", key = "#id")
    public JMNEDictEntryDto getNameById(long id) {
        var result = jmnedictRepository.entryRepository()
                .findById(id)
                .orElseThrow();

        return jmnedictEntryMapper.toDto(result);
    }
}
