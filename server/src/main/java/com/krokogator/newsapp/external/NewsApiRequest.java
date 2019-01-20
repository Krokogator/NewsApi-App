package com.krokogator.newsapp.external;

import com.krokogator.newsapp.model.newsapi.Article;
import com.krokogator.newsapp.resource.ArticleResponseResource;
import org.restlet.data.Parameter;
import org.restlet.engine.Engine;
import org.restlet.engine.converter.ConverterHelper;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.resource.ClientResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsApiRequest {

    @Value( "${api-url}" )
    private String newsApiUrl;

    @Value( "${api-key}")
    private String newsApiKey;



    public NewsApiRequest(){
        // Register serializer
        List<ConverterHelper> converters = Engine.getInstance().getRegisteredConverters();
        converters.add(new JacksonConverter());
    }

    public List<Article> getByCountryAndCategory(String country, String category) {
        ClientResource resource = buildResource();

        List<Parameter> parameterList = new ArrayList<>();
        parameterList.add(new Parameter("category", category));
        parameterList.add(new Parameter("country", country));

        resource.addQueryParameters(parameterList);

        // Creates a wrap for JSON into Object mapping
        ArticleResponseResource articleResource = resource.wrap(ArticleResponseResource.class);

        return articleResource.retrieve().getarticles();
    }

    // Build new client resource for API call
    private ClientResource buildResource() {
        ClientResource resource = new ClientResource(newsApiUrl);
        List<Parameter> parameterList = new ArrayList<>();

        parameterList.add(new Parameter("apiKey", newsApiKey));
        resource.addQueryParameters(parameterList);

        return resource;
    }
}
