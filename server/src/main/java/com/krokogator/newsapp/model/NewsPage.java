package com.krokogator.newsapp.model;

import java.util.List;

public class NewsPage {
    private String country;
    private String category;
    private List<IArticleAdapter> articles;

    public NewsPage(String country, String category, List<IArticleAdapter> articles) {
        this.country = country;
        this.category = category;
        this.articles = articles;
    }

    public String getCountry() {
        return country;
    }

    public String getCategory() {
        return category;
    }

    public List<IArticleAdapter> getArticles() {
        return articles;
    }
}
