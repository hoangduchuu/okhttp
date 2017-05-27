

## OkHttpClient

### Config client
    OkHttpClient httpClient = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();


### Buid request
    RequestBody requestBody = new MultipartBody.Builder()
                        .addFormDataPart("u", u) // make sure first param equal wwith param in server
                        .addFormDataPart("p", p) //// make sure first param equal wwith param in server
                        .setType(MultipartBody.FORM)
                        .build();

## Hold your response
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();

# class PostToUser

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





