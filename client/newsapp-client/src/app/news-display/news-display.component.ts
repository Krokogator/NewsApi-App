import { Component, OnInit } from '@angular/core';
import { TestService } from 'src/services/news.service';
import { NewsPage } from 'src/models/newsPage';

@Component({
  selector: 'app-news-display',
  templateUrl: './news-display.component.html',
  styleUrls: ['./news-display.component.css']
})
export class NewsDisplayComponent implements OnInit {

  newsPage : NewsPage;
  private country : String;
  private category : String;

  constructor(private testService : TestService) {
    this.country = 'pl';
    this.category = 'technology';
  }


  ngOnInit(){
    this.testService.getNewsPage(this.country, this.category).subscribe( value => {
      this.newsPage = value;
      console.log(value);
    })
  }

}
