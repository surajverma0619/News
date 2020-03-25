package com.example.news.repo;

import androidx.lifecycle.LiveData;

import com.example.news.model.NewsData;
import com.example.news.network.NetworkRequests;

public class NewsRepository {
    private NetworkRequests networkRequests = new NetworkRequests();

    public LiveData<NewsData> getNewsDataOnline(String tags, int page){
        return networkRequests.getNewsData(tags, page);
    }
}
