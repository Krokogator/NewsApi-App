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

  constructor(private newsService : NewsService) {
    this.country = 'pl';
  }

  ngOnInit() {
  }

  public onCategoryChanged(category : String){
    this.newsService.getNewsPage(this.country, category.toLowerCase()).subscribe( value => {
      this.newsPage = value;
      console.log(value);
    })
  }

}
