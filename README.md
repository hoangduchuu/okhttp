

## OkHttpClient

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