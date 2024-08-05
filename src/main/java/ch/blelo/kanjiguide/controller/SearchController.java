package ch.blelo.kanjiguide.controller;

import ch.blelo.kanjiguide.model.dto.jmdict.EntryDto;
import ch.blelo.kanjiguide.model.dto.kanjidic2.CharacterDto;
import ch.blelo.kanjiguide.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    public SearchController(@Autowired SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(value = "/search/{searchTerm}")
    public ResponseEntity<List<EntryDto>> search(
            @PathVariable String searchTerm
    ) {
        return ResponseEntity.ok(searchService.search(searchTerm));
    }

    @GetMapping(value = "/search/kanji/{searchTerm}")
    public ResponseEntity<List<CharacterDto>> searchKanji(
            @PathVariable String searchTerm
    ) {
        return ResponseEntity.ok(searchService.searchKanji(searchTerm));
    }
}
