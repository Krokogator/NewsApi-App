import { Article } from "./article";
import { map } from "rxjs/operators";

export class NewsPage {
    public country : String;
    public category : String;
    public articles : Article[];

    constructor(newsPageJSON){
        this.country = newsPageJSON.country;
        this.category = newsPageJSON.category;
        this.articles = newsPageJSON.articles.map((article : Article) => new Article(article));
    }
}