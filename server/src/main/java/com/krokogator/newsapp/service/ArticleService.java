package com.krokogator.newsapp.service;

import com.krokogator.newsapp.external.NewsApiRequest;
import com.krokogator.newsapp.model.ArticleAdapter;
import com.krokogator.newsapp.model.IArticleAdapter;
import com.krokogator.newsapp.model.NewsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    NewsApiRequest newsApiRequest;

    public NewsPage getNewsPage(String country, String category) {

        //Adapts newsapi.org article model to one specified by the client
        //Grants loose coupling and code transparency
        List<IArticleAdapter> articles = newsApiRequest.getByCountryAndCategory(country, category).stream().map(ArticleAdapter::new).collect(Collectors.toList());

        return new NewsPage(country, category, articles);
    }
}
