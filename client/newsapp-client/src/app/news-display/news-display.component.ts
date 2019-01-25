import { Component, OnInit, Input } from '@angular/core';
import { NewsPage } from 'src/models/newsPage';

@Component({
  selector: 'app-news-display',
  templateUrl: './news-display.component.html',
  styleUrls: ['./news-display.component.css']
})
export class NewsDisplayComponent implements OnInit {

  @Input()
  newsPage : NewsPage;

  constructor(){
  }

  ngOnInit() {
  }

}
