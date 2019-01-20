export class Article {
    public author : String;
    public title : String;
    public description : String;
    public date : String;
    public sourceName : String;
    public articleUrl : String;
    public imageUrl : String;

    public constructor(articleJSON){
        this.author = articleJSON.author;
        this.title = articleJSON.title;
        this.description = articleJSON.description;
        this.date = articleJSON.date;
        this.sourceName = articleJSON.sourceName;
        this.articleUrl = articleJSON.articleUrl;
        this.imageUrl = articleJSON.imageUrl;
    }
}