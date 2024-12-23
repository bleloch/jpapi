import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Entry } from "./model/jmdict/entry";
import { Observable } from "rxjs";
import { Character } from "./model/kanjidic2/character";

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) {}

  getWords(searchTerm: String): Observable<Entry[]> {
    return this.http.get<Entry[]>(
      `http://localhost:8080/search/word/${searchTerm}`
    );
  }

  getKanji(searchTerm: String): Observable<Character[]> {
    return this.http.get<Character[]>(
      `http://localhost:8080/search/kanji/${searchTerm}`
    );
  }

  getWordById(id: number) {
    return this.http.get<Entry>(`http://localhost:8080/search/word/${id}` );
  }

  getKanjiById(id: number) {
    return this.http.get<Character>(`http://localhost:8080/search/kanji/${id}`);
  }
}
