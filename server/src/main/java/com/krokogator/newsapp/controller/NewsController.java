package com.krokogator.newsapp.controller;

import com.krokogator.newsapp.shared.CategoryEnum;
import com.krokogator.newsapp.shared.CountryEnum;
import com.krokogator.newsapp.model.NewsPage;
import com.krokogator.newsapp.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/news")
@Api(tags = "NewsController", description = "Is used to obtain news from Newsapi.org")
public class NewsController {

    final private
    ArticleService articleService;

    @Autowired
    public NewsController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns news based on country and category")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @CrossOrigin(origins = "http://localhost:4200")
    // RequestParams could be more flexible than PathVariables
    @GetMapping("/{country}/{category}")
    public ResponseEntity<NewsPage> getNewsPage(
            @PathVariable CountryEnum country,
            @PathVariable CategoryEnum category) {
        NewsPage newsPage = articleService.getNewsPage(country.toString(), category.toString());

        return new ResponseEntity<>(newsPage, HttpStatus.OK);
    }
}
