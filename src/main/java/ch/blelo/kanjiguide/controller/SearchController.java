package ch.blelo.kanjiguide.controller;

import ch.blelo.kanjiguide.model.dto.jmdict.EntryDto;
import ch.blelo.kanjiguide.model.dto.kanjidic2.CharacterDto;
import ch.blelo.kanjiguide.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class SearchController {
    private final SearchService searchService;

    public SearchController(
            @Autowired SearchService searchService
    ) {
        this.searchService = searchService;
    }

    @GetMapping(value = "/search/word/{searchTerm}")
    public ResponseEntity<List<EntryDto>> searchWord(
            @PathVariable String searchTerm
    ) {
        var results = searchService.searchWord(searchTerm);

        log.info("Returning {} results for dictionary query {}", results.size(), searchTerm);

        return ResponseEntity.ok(results);
    }

    @GetMapping(value = "/search/kanji/{searchTerm}")
    public ResponseEntity<List<CharacterDto>> searchKanji(
            @PathVariable String searchTerm
    ) {
        var results = searchService.searchKanji(searchTerm);

        log.info("Returning {} for kanji query {}", results.size(), searchTerm);

        return ResponseEntity.ok(results);
    }

    @GetMapping(value = "/word/{id}")
    public ResponseEntity<EntryDto> searchWordById(
            @PathVariable long id
    ) {
        var result = searchService.getWordById(id);

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/kanji/{id}")
    public ResponseEntity<CharacterDto> searchKanjiById(
            @PathVariable long id
    ) {
        var result = searchService.getKanjiById(id);

        return ResponseEntity.ok(result);
    }
}
