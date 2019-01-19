import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { map } from 'rxjs/operators'

import { api } from "src/shared/global-vars";
import { Article } from "src/models/article";

@Injectable()
export class TestService {
    
    constructor(private http: HttpClient) {}
    
    getTest(): Observable<Article[]> {
        return this.http.get(api + '/news/pl/technology')
        .pipe(
            map((data: any) => data)
        );
    }
}