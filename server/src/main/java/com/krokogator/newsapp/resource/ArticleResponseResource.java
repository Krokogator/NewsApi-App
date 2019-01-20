package com.krokogator.newsapp.resource;

import com.krokogator.newsapp.model.newsapi.NewsResponse;
import org.restlet.resource.Get;


/**
 * Restlet wrapper for retrieved data
 * Maps JSON to specified object
 */
public interface ArticleResponseResource {

    @Get
    NewsResponse retrieve();

}
