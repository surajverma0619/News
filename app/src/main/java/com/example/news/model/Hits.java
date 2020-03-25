package com.example.news.model;

import com.google.gson.annotations.SerializedName;

public class Hits {

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("title")
    private String title;

    public Hits(String createdAt, String title) {
        this.createdAt = createdAt;
        this.title = title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
