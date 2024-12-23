import { Component } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { SearchService } from "../search.service";
import { NgComponentOutlet, NgIf } from "@angular/common";
import { ResultsComponent } from "../results/results.component";
import { Character } from "../model/kanjidic2/character";
import { Entry } from '../model/jmdict/entry';
import punycode from "punycode/punycode";

@Component({
  selector: 'app-search',
  standalone: true,
  imports: [
    FormsModule,
    NgComponentOutlet,
    ResultsComponent,
    NgIf
  ],
  templateUrl: './search.component.html',
  styleUrl: './search.component.less'
})
export class SearchComponent {

  private searchService: SearchService;

  constructor(searchService: SearchService) {
    this.searchService = searchService;
  }

  searchTerm = '';
  submitted = false;
  kanjiResults: Character[] = [];
  dictionaryResults: Entry[] = [];

  onSubmit() {
    this.submitted = true;
    this.searchService.getWords(this.searchTerm).subscribe(results => this.dictionaryResults = results);

    let locatedKanji = this.locateKanjiInSearchTerm(this.searchTerm);
    for (let k of locatedKanji) {
      this.searchService.getKanji(k).subscribe(results => this.kanjiResults.push(...results));
    }
    this.kanjiResults = [];
  }

  locateKanjiInSearchTerm(searchTerm: string) {
    let results: Set<string> = new Set();

    for (let char of searchTerm) {
      let codepoints = punycode.ucs2.decode(char);
      for (let codepoint of codepoints) {
        if (codepoint >= 19968 && codepoint <= 40895) {
          results.add(char);
        }
      }
    }

    return results;
  }
}
