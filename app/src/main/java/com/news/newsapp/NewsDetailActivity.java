package com.news.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
    String title, content, imageUrl, url, desc;
    private TextView titleTV, contentTV, subDescTV;
    private ImageView newsIV;
    private Button readNewsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("desc");
        content = getIntent().getStringExtra("content");
        imageUrl = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");
        titleTV = findViewById(R.id.idTVTitle);
        contentTV = findViewById(R.id.idTVContent);
        subDescTV = findViewById(R.id.idTVSubDesc);
        newsIV = findViewById(R.id.idIVNews);
        readNewsBtn = findViewById(R.id.idBtnReadNews);
        titleTV.setText(title);
        contentTV.setText(content);
        subDescTV.setText(desc);
        Picasso.get().load(url).into(newsIV);
        readNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(imageUrl));
                startActivity(i);
            }
        });
    }
}