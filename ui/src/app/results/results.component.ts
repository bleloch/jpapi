import { Component, Input } from '@angular/core';
import { Character } from "../model/kanjidic2/character";
import { Entry } from '../model/jmdict/entry';
import { NgIf } from "@angular/common";
// import { NgbAccordionModule } from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-results',
  standalone: true,
  imports: [
    NgIf
  ],
  templateUrl: './results.component.html',
  styleUrl: './results.component.less'
})
export class ResultsComponent {
  @Input() kanjiResults: Character[] = [];
  @Input() dictionaryResults: Entry[] = [];

  getKanjiElements(entry: Entry): string[] {
    return entry.kanji.map((k) => k.element);
  }

  getReadingElements(entry: Entry): string[] {
    return entry.readings.map((r) => r.element);
  }

  getTranslationsByLanguage(entry: Entry): Map<string, string[]> {
    let glosses = entry.senses.map((s) => s.glosses).flat();

    let results: Map<string, string[]> = new Map();

    glosses.forEach((g) => {
      if (!results.has(g.languageCode)) {
        results.set(g.languageCode, []);
      }
      results.get(g.languageCode)!.push(g.element);
    });

    return results;
  }

  getFlagForLanguage(language: string): string {
    switch (language) {
      case 'eng':
        return '🇬🇧'
      case 'dut':
        return '🇳🇱'
      case 'fre':
        return '🇫🇷'
      case 'ger':
        return '🇩🇪'
      case 'hun':
        return '🇭🇺'
      case 'rus':
        return '🇷🇺'
      case 'slv':
        return '🇸🇮'
      case 'spa':
        return '🇪🇸'
      case 'swe':
        return '🇸🇪'
      default:
        return '❓'
    }
  }
}

