package com.nsolution.nfood.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient implements IHttpClient {

    private Retrofit.Builder builder;
    private String baseUrl;

    public HttpClient() {
        // get from dynamic enviroment.
        baseUrl = "https://locahost:2501/api/";     
        builder = createRetrofitBuilder(baseUrl);
    }

    public HttpClient(String otherBaseUrl) {
        baseUrl = otherBaseUrl;
        builder = createRetrofitBuilder(baseUrl);
    }

    @Override
    public Retrofit getRetrofit() {
        return builder.build();
    }

    private Retrofit.Builder createRetrofitBuilder(String url) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(httpClient.build())
                .build()
                .newBuilder();
    }
}
