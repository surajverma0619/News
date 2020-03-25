package com.example.news.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.news.R;
import com.example.news.model.Hits;
import com.example.news.model.NewsData;
import com.example.news.repo.NewsRepository;

public class MainActivity extends AppCompatActivity {
    private NewsRepository newsRepository = new NewsRepository();
    private LiveData<NewsData> ldNewsData;
    private RecyclerView newsRecyclerView;
    private NewsAdapter newsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Hits[] hits;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsRepository = new NewsRepository();

        ldNewsData = newsRepository.getNewsDataOnline("story", 1);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swlNews);

        newsRecyclerView = (RecyclerView) findViewById(R.id.rvNews);
        layoutManager = new LinearLayoutManager(this);
        newsAdapter = new NewsAdapter(this,hits);
        newsRecyclerView.setLayoutManager(layoutManager);
        newsRecyclerView.setAdapter(newsAdapter);
        setObserver();
        refreshListener();
    }

    private void refreshListener(){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setObserver();

            }
        });
    }

    private void setObserver() {
        ldNewsData.observe(this,newsData -> {
            hits = newsData.getHits();
            newsAdapter.setData(hits);
            swipeRefreshLayout.setRefreshing(false);
            ldNewsData.removeObservers(this);
        });
    }
}
