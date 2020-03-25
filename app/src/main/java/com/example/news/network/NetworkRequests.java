package com.example.news.network;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.news.model.NewsData;
import com.example.news.util.NetworkUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkRequests {

    private MutableLiveData<NewsData> mutableNewsLivedData = new MutableLiveData<>();

    public LiveData<NewsData> getNewsData(String tags, int page) {
        Call<NewsData> networkCall = NetworkUtil.networkInstance().getNewsData(tags, page);
        networkCall.enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call, Response<NewsData> response) {
                if (response.isSuccessful()) {
                    mutableNewsLivedData.setValue(response.body());
                } else {
                    mutableNewsLivedData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable t) {
                mutableNewsLivedData.setValue(null);
            }
        });
        return mutableNewsLivedData;
    }
}
