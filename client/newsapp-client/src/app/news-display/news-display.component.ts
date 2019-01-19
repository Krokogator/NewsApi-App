import { Component, OnInit } from '@angular/core';
import { TestService } from 'src/services/test.service';
import { Article } from 'src/models/article';

@Component({
  selector: 'app-news-display',
  templateUrl: './news-display.component.html',
  styleUrls: ['./news-display.component.css']
})
export class NewsDisplayComponent implements OnInit {

  private articles : Article[];

  constructor(private testService : TestService) { }


  ngOnInit(){
    this.testService.getTest().subscribe( value => {
      this.articles = value;
      console.log(value);
    })
  }

}
