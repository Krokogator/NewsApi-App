export class Article {
    public author : String;
    public title : String;
    public description : String;
    public date : Date;
    public sourceName : String;
    public articleUrl : String;
    public imageUrl : String;

    public constructor(jsonArticle){
        this.author = jsonArticle.author;
        this.title = jsonArticle.title;
        this.description = jsonArticle.description;
        this.date = jsonArticle.date;
        this.sourceName = jsonArticle.source.name;
        this.articleUrl = jsonArticle.url;
        this.imageUrl = jsonArticle.urlToImage;
    }
}