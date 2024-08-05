import { Component } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { SearchService } from "../search.service";
import { NgComponentOutlet, NgIf } from "@angular/common";
import { ResultsComponent } from "../results/results.component";
import { Character } from "../model/kanjidic2/character";
import { Entry } from '../model/jmdict/entry';

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
    this.searchService.getResults(this.searchTerm).subscribe(results => this.dictionaryResults = results);
    this.searchService.getKanji(this.searchTerm).subscribe(results => this.kanjiResults = results);
  }
}
