package com.example.hoang.testokhttp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetUrlActivity extends AppCompatActivity {

    Button btnGetUrl;
    EditText edtUrl;
    TextView tvUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_url);
        findviewByIds();
    }

    private void findviewByIds() {

        btnGetUrl = (Button) findViewById(R.id.btnGetUrl);
        edtUrl = (EditText) findViewById(R.id.edtUrl);
        tvUrl = (TextView) findViewById(R.id.tvUrl);
    }

    public void getUrl(View view) {
        new GetURL().execute(tvUrl.getText().toString().trim());
    }

    class GetURL extends AsyncTask<String, String, String> {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        @Override
        protected String doInBackground(String... params) {
            Request.Builder builder = new Request.Builder();
            builder.url(params[0]);
            Request request = builder.build();

            try {
                Response response = httpClient.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s != null) {
                tvUrl.append(s);
            } else {
                Log.d("kaka", "loi roi");
            }
        }
    }

}
