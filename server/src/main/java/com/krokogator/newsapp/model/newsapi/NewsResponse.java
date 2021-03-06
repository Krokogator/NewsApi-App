package com.krokogator.newsapp.model.newsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsResponse implements Serializable {

    private String status;
    private String totalResults;
    private ArrayList<Article> articles;

    public NewsResponse(){}

    public NewsResponse(String status, String totalResults, ArrayList<Article> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<Article> getarticles() {
        return articles;
    }

    public void setarticles(ArrayList<Article> articles) {
        this.articles = articles;
    }
}
