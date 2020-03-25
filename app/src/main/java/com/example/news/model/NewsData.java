package com.example.news.model;

import com.google.gson.annotations.SerializedName;

public class NewsData {

    @SerializedName("hits")
    private Hits[] hits;

    @SerializedName("exhaustiveNbHits")
    private Boolean exhaustiveNbHits;

    @SerializedName("query")
    private String query;

    @SerializedName("params")
    private String params;


    public NewsData(Hits[] hits, Boolean exhaustiveNbHits, String query, String params) {
        this.hits = hits;
        this.exhaustiveNbHits = exhaustiveNbHits;
        this.query = query;
        this.params = params;
    }

    public void setHits(Hits[] hits) {
        this.hits = hits;
    }


    public void setQuery(String query) {
        this.query = query;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Hits[] getHits() {
        return hits;
    }

    public void setExhaustiveNbHits(Boolean exhaustiveNbHits) {
        this.exhaustiveNbHits = exhaustiveNbHits;
    }

    public Boolean getExhaustiveNbHits() {
        return exhaustiveNbHits;
    }

    public String getQuery() {
        return query;
    }

    public String getParams() {
        return params;
    }


}
