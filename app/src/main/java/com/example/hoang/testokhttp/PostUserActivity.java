package com.example.hoang.testokhttp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostUserActivity extends AppCompatActivity {

    EditText edtU, edtP;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_user);
        findViewByIds();


    }

    private void findViewByIds() {
        edtP = (EditText) findViewById(R.id.edtUser);
        edtU = (EditText) findViewById(R.id.edtUser);
        btnSend = (Button) findViewById(R.id.btnPostUser);
    }

    public void PostUser(View view) {
        String u = edtU.getText().toString().trim();
        String p = edtP.getText().toString().trim();
        new PostToServer(u, p).execute("http://192.168.1.102/okhttp/postuser.php");
    }

    class PostToServer extends AsyncTask<String, Void, String> {
        String u = edtU.getText().toString().trim();
        String p = edtP.getText().toString().trim();

        public PostToServer(String u, String p) {
            this.u = u;
            this.p = p;
        }

        OkHttpClient httpClient = new OkHttpClient.Builder().build();

        @Override
        protected String doInBackground(String... params) {
            String url = params[0];
            RequestBody requestBody = new MultipartBody.Builder()
                    .addFormDataPart("u", u) // make sure first param equal wwith param in server
                    .addFormDataPart("p", p) //// make sure first param equal wwith param in server
                    .setType(MultipartBody.FORM)
                    .build();


            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();

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
            Log.d("aaa", s);
            super.onPostExecute(s);
        }
    }
}
