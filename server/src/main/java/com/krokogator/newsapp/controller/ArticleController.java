package com.krokogator.newsapp.controller;

import com.krokogator.newsapp.model.newsapi.Article;
import com.krokogator.newsapp.model.newsapi.ArticleApiModel;
import com.krokogator.newsapp.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@Api(tags = "ArticleController", description = "Is used to obtain news from Newsapi.org")
public class ArticleController {

    final private
    ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(response = ArticleApiModel.class, value = "Returns news based on country and category")
    @CrossOrigin(origins = "http://localhost:4200")
    // RequestParams could be more flexible than PathVariables
    @GetMapping("/{country}/{category}")
    public List<Article> getArticles(
            @PathVariable CountryEnum country,
            @PathVariable CategoryEnum category) {

        List<Article> articleList = articleService.getArticles(country.toString(), category.toString());

        return articleList;
    }
}
