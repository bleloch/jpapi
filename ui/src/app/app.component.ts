import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SearchComponent } from "./search/search.component";
import { FooterComponent } from "./footer/footer.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SearchComponent, FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.less'
})
export class AppComponent {
  title = 'ui';
}
