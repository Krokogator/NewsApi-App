import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { map } from 'rxjs/operators'

import { api } from "src/shared/global-vars";
import { NewsPage } from "src/models/newsPage";

@Injectable()
export class NewsService {
    
    constructor(private http: HttpClient) {}
    
    getNewsPage(country : String, category : String): Observable<NewsPage> {
        return this.http.get(api + '/news/'+ country +'/' + category)
        .pipe(
            map((data: String) => new NewsPage(data))
        );
    }
}