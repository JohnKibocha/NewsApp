package com.news.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NewsDetailActivity extends AppCompatActivity {
    String title, content, imageUrl, url, desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("desc");
        content = getIntent().getStringExtra("content");
        imageUrl = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");
    }
}