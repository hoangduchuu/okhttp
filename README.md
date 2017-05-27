

# #1 OkHttpClient with URL,IMG URL

### 001 Config client
    OkHttpClient httpClient = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();


### 002 Buid request
    RequestBody requestBody = new MultipartBody.Builder()
                        .addFormDataPart("u", u) // make sure first param equal wwith param in server
                        .addFormDataPart("p", p) //// make sure first param equal wwith param in server
                        .setType(MultipartBody.FORM)
                        .build();

## 003 Hold your response
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();

# #2 OkHttpClient with PostMethod
### 001 Config client
    OkHttpClient httpClient = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();
### 002 Buid request
    RequestBody requestBody = new MultipartBody.Builder()
                        .addFormDataPart("u", u) // make sure first param equal wwith param in server
                        .addFormDataPart("p", p) //// make sure first param equal wwith param in server
                        .setType(MultipartBody.FORM)
                        .build();

### 003 Hold your response

      Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();


### class [PostUser](https://github.com/hoangduchuu/okhttp/blob/post/app/src/main/java/com/example/hoang/testokhttp/PostUserActivity.java)