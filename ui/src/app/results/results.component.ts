import { Component, Input } from '@angular/core';
import { Character } from "../model/kanjidic2/character";
import { Entry } from '../model/jmdict/entry';
import { NgIf } from "@angular/common";
import { NgbAccordionModule } from "@ng-bootstrap/ng-bootstrap";
import { SemanticGroup } from "../model/kanjidic2/semanticGroup";
import { RouterLink, RouterOutlet } from "@angular/router";
import { Sense } from "../model/jmdict/sense";
import { lowerCase, toLower, uniq } from "lodash";

@Component({
  selector: 'app-results',
  standalone: true,
  imports: [
    NgIf,
    NgbAccordionModule,
    RouterOutlet,
    RouterLink
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
      let languageForFlag = this.getFlagForLanguage(g.languageCode)

      if (!results.has(languageForFlag)) {
        results.set(languageForFlag, []);
      }
      results.get(languageForFlag)!.push(g.element);
    });

    return results;
  }

  getKanjiMeanings(sg: SemanticGroup): string {
    return sg.meanings
      .filter((m) => m.languageCode == 'en')
      .map((m) => m.element)
      .join(', ');
  }

  getKanjiReadings(sg: SemanticGroup, readingType: string): string {
    if (sg.readings.length > 0) {
      return sg.readings
        .filter((r) => r.type == readingType)
        .map((r) => r.element)
        .join(', ');
    } else return '';
  }

  getPosInformation(senses: Sense[]): string {
    let partsOfSpeech: string[] = [];
    for (let sense of senses) {
      if (sense.partOfSpeech !== undefined && sense.partOfSpeech.length > 0) {
        sense.partOfSpeech
          .forEach((p) => partsOfSpeech.push(toLower(p)));
      }
    }

    return uniq(partsOfSpeech).join(', ');
  }

  getFlagForLanguage(language: string): string {
    switch (language) {
      case 'en':
      case 'eng':
        return '🇬🇧'
      case 'nl': // unused
      case 'dut':
        return '🇳🇱'
      case 'fr':
      case 'fre':
        return '🇫🇷'
      case 'de': // unused
      case 'ger':
        return '🇩🇪'
      case 'hu': // unused
      case 'hun':
        return '🇭🇺'
      case 'ru': // unused
      case 'rus':
        return '🇷🇺'
      case 'sv': // unused
      case 'slv':
        return '🇸🇮'
      case 'es':
      case 'spa':
        return '🇪🇸'
      case 'se':
      case 'swe':
        return '🇸🇪'
      default:
        return '❓'
    }
  }
}
