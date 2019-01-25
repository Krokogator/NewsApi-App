import { Component, OnInit } from '@angular/core';
import { NewsService } from 'src/services/news.service';
import { NewsPage } from '../../models/newsPage';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  newsPage : NewsPage;

  private country : String;
  private category : String;
  private searchPhrase : String;

  constructor(private newsService : NewsService) {
    this.country = 'pl';
  }

  ngOnInit() {
  }

  public onCategoryChanged(category : String) {
    this.category = category.toLowerCase();
    this.reloadNews();
  }

  public onSearch(searchPhrase : String) {
    this.searchPhrase = searchPhrase;
    this.reloadNews();
  }

  private reloadNews() : void {
    this.newsService.getNewsPage(this.country, this.category, this.searchPhrase).subscribe( value => {
      this.newsPage = value;
    })
  }

}
