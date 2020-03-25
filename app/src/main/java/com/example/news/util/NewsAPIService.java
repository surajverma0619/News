package com.example.news.util;

import com.example.news.model.NewsData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPIService {

    @GET("search_by_date")
    Call<NewsData> getNewsData(@Query("tags") String tags, @Query("page") int page);
}
