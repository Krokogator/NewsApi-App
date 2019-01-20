import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TestService } from 'src/services/news.service';
import { HttpClientModule } from '@angular/common/http';
import { NewsComponent } from './news/news.component';
import { NewsDisplayComponent } from './news-display/news-display.component';
import { NewsPickerComponent } from './news-picker/news-picker.component';

@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    NewsDisplayComponent,
    NewsPickerComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    TestService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
