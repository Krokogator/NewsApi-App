package com.krokogator.newsapp.resource;

import com.krokogator.newsapp.model.ArticleResponse;
import org.restlet.resource.Get;

public interface ArticleResponseResource {

    @Get
    ArticleResponse retrieve();

}
