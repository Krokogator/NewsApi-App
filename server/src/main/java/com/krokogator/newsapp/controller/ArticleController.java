package com.krokogator.newsapp.controller;

import com.krokogator.newsapp.model.Article;
import com.krokogator.newsapp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class ArticleController {

    final private
    ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{country}/{category}")
    public ResponseEntity<List<Article>> getArticles(
            @PathVariable String country,
            @PathVariable String category) {

        List<Article> articleList = articleService.getArticles(country, category);

        return new ResponseEntity<>(articleList, HttpStatus.OK);
    }
}
