package com.krokogator.newsapp.service;

import com.krokogator.newsapp.external.NewsApiRequest;
import com.krokogator.newsapp.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    NewsApiRequest newsApiRequest;

    public List<Article> getArticles(String country, String category) {
        return newsApiRequest.getByCountryAndCategory(country, category);
    }
}
