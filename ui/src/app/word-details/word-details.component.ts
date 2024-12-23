import { Component, Input, OnInit } from '@angular/core';
import { Entry } from "../model/jmdict/entry";
import { Observable, switchMap } from 'rxjs';
import { ActivatedRoute } from "@angular/router";
import { SearchService } from "../search.service";

@Component({
  selector: 'app-word-details',
  standalone: true,
  imports: [],
  templateUrl: './word-details.component.html',
  styleUrl: './word-details.component.less'
})
export class WordDetailsComponent implements OnInit {
  // @Input() id: number = 0;
  // entry$: Observable<Entry>;

  constructor(
    private route: ActivatedRoute,
    private service: SearchService,
  ) {}

  ngOnInit(): void {
    // this.entry$ = this.route.paramMap.pipe(
    //   switchMap(params => {
    //     this.id = Number(params.get('id'));
    //     return this.service.getWordById(this.id);
    //   })
    // )
  }

}
