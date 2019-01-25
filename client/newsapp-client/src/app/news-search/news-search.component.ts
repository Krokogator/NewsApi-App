import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-news-search',
  templateUrl: './news-search.component.html',
  styleUrls: ['./news-search.component.css']
})
export class NewsSearchComponent implements OnInit {

  @Output()
  searchPhraseEmitter = new EventEmitter<String>();

  constructor() { }

  ngOnInit() {
  }

  public onSearchButtonPress(value){
    this.searchPhraseEmitter.emit(value)
  }

}
