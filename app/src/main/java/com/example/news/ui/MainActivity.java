package com.example.news.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.news.R;
import com.example.news.model.NewsData;
import com.example.news.repo.NewsRepository;

public class MainActivity extends AppCompatActivity {
    private NewsRepository newsRepository = new NewsRepository();
    private LiveData<NewsData> ldNewsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsRepository = new NewsRepository();

        ldNewsData = newsRepository.getNewsDataOnline("story", 1);
        setObserver();

    }

    private void setObserver() {
        ldNewsData.observe(this,newsData -> {
            newsData.getExhaustiveNbHits();
        });
    }
}
