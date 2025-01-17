package ch.blelo.jpapi.controller;

import ch.blelo.jpapi.model.dto.jmdict.JMDictEntryDto;
import ch.blelo.jpapi.model.dto.jmnedict.JMNEDictEntryDto;
import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2CharacterDto;
import ch.blelo.jpapi.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class SearchController {
    private final SearchService searchService;

    public SearchController(
            SearchService searchService
    ) {
        this.searchService = searchService;
    }

    @GetMapping(value = "/search/word/{searchTerm}")
    public ResponseEntity<List<JMDictEntryDto>> searchWord(
            @PathVariable String searchTerm
    ) {
        var results = searchService.searchWord(searchTerm);

        log.info("Returning {} results for dictionary query {}", results.size(), searchTerm);

        return ResponseEntity.ok(results);
    }

    @GetMapping(value = "/search/kanji/{searchTerm}")
    public ResponseEntity<List<Kanjidic2CharacterDto>> searchKanji(
            @PathVariable String searchTerm
    ) {
        var results = searchService.searchKanji(searchTerm);

        log.info("Returning {} for kanji query {}", results.size(), searchTerm);

        return ResponseEntity.ok(results);
    }

    @GetMapping(value = "/search/name/{searchTerm}")
    public ResponseEntity<List<JMNEDictEntryDto>> searchName(
            @PathVariable String searchTerm
    ) {
        var results = searchService.searchName(searchTerm);

        log.info("Returning {} results for name query {}", results.size(), searchTerm);

        return ResponseEntity.ok(results);
    }

    @GetMapping(value = "/word/{id}")
    public ResponseEntity<JMDictEntryDto> searchWordById(
            @PathVariable long id
    ) {
        var result = searchService.getWordById(id);

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/kanji/{id}")
    public ResponseEntity<Kanjidic2CharacterDto> searchKanjiById(
            @PathVariable long id
    ) {
        var result = searchService.getKanjiById(id);

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/name/{id}")
    public ResponseEntity<JMNEDictEntryDto> searchNameById(
            @PathVariable long id
    ) {
        var result = searchService.getNameById(id);

        return ResponseEntity.ok(result);
    }
}
