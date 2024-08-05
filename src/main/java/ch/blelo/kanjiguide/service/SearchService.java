package ch.blelo.kanjiguide.service;

import ch.blelo.kanjiguide.model.dto.jmdict.EntryDto;
import ch.blelo.kanjiguide.model.dto.kanjidic2.CharacterDto;
import ch.blelo.kanjiguide.model.mapper.jmdict.EntryMapper;
import ch.blelo.kanjiguide.model.mapper.kanjidic2.CharacterMapper;
import ch.blelo.kanjiguide.repository.jmdict.EntryRepository;
import ch.blelo.kanjiguide.repository.kanjidic2.CharacterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class SearchService {
    private final EntryRepository entryRepository;
    private final CharacterRepository characterRepository;
    private final EntryMapper entryMapper;
    private final CharacterMapper characterMapper;

    public SearchService(
            @Autowired EntryRepository entryRepository,
            @Autowired CharacterRepository characterRepository,
            @Autowired EntryMapper entryMapper,
            @Autowired CharacterMapper characterMapper
    ) {
        this.entryRepository = entryRepository;
        this.characterRepository = characterRepository;
        this.entryMapper = entryMapper;
        this.characterMapper = characterMapper;
    }

    @Cacheable(value = "searchKanji", key = "#searchTerm")
    public List<CharacterDto> searchKanji(String searchTerm) {
        var kanjiMatches = characterRepository.findByLiteral(searchTerm);
        return kanjiMatches.stream()
                .map(characterMapper::toDto)
                .toList();
    }

    @Cacheable(value = "search", key = "#searchTerm")
    public List<EntryDto> search(String searchTerm) {
        var totalStart = System.currentTimeMillis();
        var start = System.currentTimeMillis();
        var kanjiMatches = entryRepository.findByKanjiElementIgnoreCase(searchTerm);
        log.info("Took {}ms to retrieve {} kanji for term {}", (System.currentTimeMillis() - start), kanjiMatches.size(), searchTerm);
        start = System.currentTimeMillis();
        var readingMatches = entryRepository.findByReadingsElementIgnoreCase(searchTerm);
        log.info("Took {}ms to retrieve {} readings for term {}", (System.currentTimeMillis() - start), readingMatches.size(), searchTerm);
        start = System.currentTimeMillis();
        var senseMatches = entryRepository.findBySensesGlossesElementIgnoreCase(searchTerm);
        log.info("Took {}ms to retrieve {} senses for term {}", (System.currentTimeMillis() - start), senseMatches.size(), searchTerm);
        log.info("Took {}ms to retrieve {} results for term {}", (System.currentTimeMillis() - totalStart), (kanjiMatches.size() + readingMatches.size() + senseMatches.size()), searchTerm);

        return Stream
                .of(kanjiMatches, readingMatches, senseMatches)
                .flatMap(List::stream)
                .map(entryMapper::toDto)
                .distinct()
                .toList();
    }
}
