package com.krokogator.newsapp.model;

import com.krokogator.newsapp.model.newsapi.Article;

import java.text.SimpleDateFormat;

public class ArticleAdapter implements IArticleAdapter{
    private Article adaptee;

    public ArticleAdapter(Article adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public String getAuthor() {
        return adaptee.getAuthor();
    }

    @Override
    public String getTitle() {
        return adaptee.getTitle();
    }

    @Override
    public String getDescription() {
        return adaptee.getDescription();
    }

    @Override
    public String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(adaptee.getPublishedAt());
    }

    @Override
    public String getSourceName() {
        return adaptee.getSource().getName();
    }

    @Override
    public String getArticleUrl() {
        return adaptee.getUrl();
    }

    @Override
    public String getImageUrl() {
        return adaptee.getUrlToImage();
    }
}
