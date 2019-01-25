import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { map } from 'rxjs/operators'

import { api } from "src/shared/global-vars";
import { NewsPage } from "src/models/newsPage";

@Injectable()
export class NewsService {
    
    constructor(private http: HttpClient) {}
    
    getNewsPage(country : String, category : String, searchPhrase? : String): Observable<NewsPage> {
        var endpoint = '/news/'+ country +'/' + category;
        if (searchPhrase) {  endpoint += '?searchPhrase=' + searchPhrase }
        return this.http.get(api + endpoint)
        .pipe(
            map((data: String) => new NewsPage(data))
        );
    }
}