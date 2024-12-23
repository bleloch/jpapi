import { Routes } from '@angular/router';
import { WordDetailsComponent } from "./word-details/word-details.component";
import { KanjiDetailsComponent } from "./kanji-details/kanji-details.component";
import { PageNotFoundComponent } from "./page-not-found/page-not-found.component";

export const routes: Routes = [
  { path: 'word', component: WordDetailsComponent },
  { path: 'kanji', component: KanjiDetailsComponent },
  // { path: '**', component: PageNotFoundComponent }
];
