package ch.blelo.kanjiguide.service;

import ch.blelo.kanjiguide.model.dto.jmdict.EntryDto;
import ch.blelo.kanjiguide.model.dto.kanjidic2.CharacterDto;
import ch.blelo.kanjiguide.model.mapper.jmdict.EntryMapper;
import ch.blelo.kanjiguide.model.mapper.kanjidic2.CharacterMapper;
import ch.blelo.kanjiguide.repository.jmdict.EntryRepository;
import ch.blelo.kanjiguide.repository.jmdict.JMDictRepositoryFacade;
import ch.blelo.kanjiguide.repository.kanjidic2.CharacterRepository;
import ch.blelo.kanjiguide.repository.kanjidic2.Kanjidic2RepositoryFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class SearchService {
    private final JMDictRepositoryFacade jmdictRepository;
    private final Kanjidic2RepositoryFacade kanjidic2Repository;
    private final EntryMapper entryMapper;
    private final CharacterMapper characterMapper;

    public SearchService(
            @Autowired JMDictRepositoryFacade jmdictRepository,
            @Autowired Kanjidic2RepositoryFacade kanjidic2Repository,
            @Autowired EntryMapper entryMapper,
            @Autowired CharacterMapper characterMapper
    ) {
        this.jmdictRepository = jmdictRepository;
        this.kanjidic2Repository = kanjidic2Repository;

        this.entryMapper = entryMapper;
        this.characterMapper = characterMapper;
    }

    @Cacheable(value = "searchKanji", key = "#searchTerm")
    public List<CharacterDto> searchKanji(String searchTerm) {
        var kanjiMatches = kanjidic2Repository.characterRepository().findByLiteral(searchTerm);
        return kanjiMatches.stream()
                .map(characterMapper::toDto)
                .toList();
    }

    @Cacheable(value = "searchListOfKanji", key = "#searchTerms")
    public List<CharacterDto> searchKanji(List<String> searchTerms) {
        var kanjiMatches = kanjidic2Repository.characterRepository().findByLiteralIn(searchTerms);
        return kanjiMatches.stream()
                .map(characterMapper::toDto)
                .toList();
    }

    // TODO - improve performance
    @Cacheable(value = "searchWord", key = "#searchTerm")
    public List<EntryDto> searchWord(String searchTerm) {
        var kanjiMatches = jmdictRepository.entryRepository()
                .findByKanjiElementIgnoreCase(searchTerm);
        var readingMatches = jmdictRepository.entryRepository()
                .findByReadingsElementIgnoreCase(searchTerm);
        var senseMatches = jmdictRepository.entryRepository()
                .findBySensesGlossesElementIgnoreCase(searchTerm);

        return Stream
                .of(kanjiMatches, readingMatches, senseMatches)
                .flatMap(List::stream)
                .map(entryMapper::toDto)
                .distinct()
                .toList();
    }

    @Cacheable(value = "kanji", key = "#id")
    public CharacterDto getKanjiById(long id) {
        var result = kanjidic2Repository.characterRepository()
                .findById(id)
                .orElseThrow(); // throw proper exception

        return characterMapper.toDto(result);
    }

    @Cacheable(value = "word", key = "#id")
    public EntryDto getWordById(long id) {
        var result = jmdictRepository.entryRepository()
                .findById(id)
                .orElseThrow(); // throw proper exception

        return entryMapper.toDto(result);
    }
}
