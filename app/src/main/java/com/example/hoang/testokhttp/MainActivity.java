package com.example.hoang.testokhttp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    Button btngetUrl, btnGetImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetImg = (Button) findViewById(R.id.btngetImg);
        btngetUrl = (Button) findViewById(R.id.btnGetUrl);
    }

    public void getUrl(View view) {
        Intent i = new Intent(MainActivity.this, GetUrlActivity.class);
        startActivity(i);

        Toast.makeText(this, "getuRL", Toast.LENGTH_SHORT).show();
    }

}
