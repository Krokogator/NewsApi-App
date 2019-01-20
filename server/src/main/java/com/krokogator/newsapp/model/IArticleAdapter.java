package com.krokogator.newsapp.model;

public interface IArticleAdapter {
    String getAuthor();
    String getTitle();
    String getDescription();
    String getDate();
    String getSourceName();
    String getArticleUrl();
    String getImageUrl();
}
