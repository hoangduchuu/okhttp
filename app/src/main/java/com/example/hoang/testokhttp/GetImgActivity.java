package com.example.hoang.testokhttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetImgActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnGetImg;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_img);

        imageView = (ImageView) findViewById(R.id.img);
        btnGetImg = (Button) findViewById(R.id.BtngetImg);
        url = (EditText) findViewById(R.id.imgUrl);
    }

    public void getImg(View view) {
        new GetIMG().execute(url.getText().toString().trim());
    }

    class GetIMG extends AsyncTask<String, Void, byte[]> {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .build();

        @Override
        protected byte[] doInBackground(String... params) {
            String url = params[0];
            Request.Builder builder = new Request.Builder();
            builder.url(url);

            Request request = builder.build();
            try {
                Response response = httpClient.newCall(request).execute();
                return response.body().bytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(byte[] bytes) {
            if (bytes != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                imageView.setImageBitmap(bitmap);
            }
            super.onPostExecute(bytes);
        }
    }

}
