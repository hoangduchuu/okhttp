package com.example.hoang.testokhttp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    Button btngetUrl, btnGetImg, btnPostUser;
    ImageView ivMain;
    ImageView ivMain2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetImg = (Button) findViewById(R.id.btngetImg);
        btngetUrl = (Button) findViewById(R.id.btnGetUrl);
        ivMain = (ImageView) findViewById(R.id.ivMain);
        ivMain2 = (ImageView) findViewById(R.id.ivMain2);

        ImageLoader.load(ivMain, "https://www.qhonline.edu.vn/templates/qhover3.0/assets/logo-qh.png");

        Glide.with(this)
                .load("https://www.qhonline.edu.vn/templates/qhover3.0/assets/logo-qh.png")
                .into(ivMain);

    }

    public void getUrl(View view) {
        Intent i = new Intent(MainActivity.this, GetUrlActivity.class);
        startActivity(i);
    }

    public void getImg(View view) {
        Intent i = new Intent(MainActivity.this, GetImgActivity.class);
        startActivity(i);
    }

    public void btnPostUser(View view) {
        Intent i = new Intent(MainActivity.this, PostUserActivity.class);
        startActivity(i);
    }
}
