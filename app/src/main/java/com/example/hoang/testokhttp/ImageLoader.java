package com.example.hoang.testokhttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hoang on 27/05/17.
 */

public class ImageLoader {
    public static void load(ImageView imageView, String url) {
        new Loader(imageView).execute(url);
    }
    public static void load2(ImageView imageView, String url) {
        new Loader(imageView).execute(url);
    }


    private static class Loader extends AsyncTask<String, Void, Bitmap> {

        ImageView imageView;

        public Loader(ImageView imageView) {
            this.imageView = imageView;
        }

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .build();

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            String url = params[0];
            Request.Builder builder = new Request.Builder();
            builder.url(url);
            Request request = builder.build();
            try {
                Response response = httpClient.newCall(request).execute();
                InputStream inputStream = response.body().byteStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }

}
