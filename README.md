

## OkHttpClient with Image(bytes)

### Config client
    OkHttpClient httpClient = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();
### Buid request
     Request.Builder builder = new Request.Builder();
                builder.url(params[0]);
                Request request = builder.build();

## Hold your response
        Response response = httpClient.newCall(request).execute();
                        return response.body().string();


### Example with Bite
        public void getImg(View view) {
            new GetIMG().execute("https://avatars1.githubusercontent.com/u/15043682?v=3&s=460");
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
