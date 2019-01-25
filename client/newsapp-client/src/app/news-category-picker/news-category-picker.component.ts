import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { newsApiCategoriesEnum } from 'src/shared/newsapi-categories';

@Component({
  selector: 'app-news-category-picker',
  templateUrl: './news-category-picker.component.html',
  styleUrls: ['./news-category-picker.component.css']
})
export class NewsCategoryPickerComponent implements OnInit {

  @Output() selectedCategoryEmitter = new EventEmitter<String>();

  private categories : String[] = [];

  constructor() { 
    for(var category in newsApiCategoriesEnum) {
      this.categories.push(category);
    }

    this.selectedCategoryEmitter = new EventEmitter<string>();
  }

  ngOnInit() {
    this.selectedCategoryEmitter.emit(this.categories[0])
  }

  categoryChanged(value) {
    this.selectedCategoryEmitter.emit(value)
  }

}
