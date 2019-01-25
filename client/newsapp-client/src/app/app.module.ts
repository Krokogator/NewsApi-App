import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NewsService } from 'src/services/news.service';
import { HttpClientModule } from '@angular/common/http';
import { NewsComponent } from './news/news.component';
import { NewsDisplayComponent } from './news-display/news-display.component';
import { NewsPickerComponent } from './news-picker/news-picker.component';
import { NewsCategoryPickerComponent } from './news-category-picker/news-category-picker.component';
import { NewsSearchComponent } from './news-search/news-search.component'

@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    NewsDisplayComponent,
    NewsPickerComponent,
    NewsCategoryPickerComponent,
    NewsSearchComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    NewsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
