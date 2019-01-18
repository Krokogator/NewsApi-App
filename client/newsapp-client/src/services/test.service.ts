import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { map } from 'rxjs/operators'

import { api } from "src/shared/global-vars";

@Injectable()
export class TestService {
    
    constructor(private http: HttpClient) {}
    
    getTest(): Observable<String> {
        return this.http.get(api + '/test')
        .pipe(
            map((data: any) => new String(data.value))
        );
    }
}