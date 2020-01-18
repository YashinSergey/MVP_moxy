package com.iashinsergei.mvpmoxy.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitData {

    private static RetrofitData retrofitData;
    private RequestAPI API;

    private RetrofitData() {
        API = createAdapter();
    }

    public static RetrofitData getRetrofitData() {
        if (retrofitData == null) {
            retrofitData = new RetrofitData();
        }
        return retrofitData;
    }

    private RequestAPI createAdapter() {
        Retrofit adapter = new Retrofit.Builder().baseUrl("https://chat.pryaniky.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        return adapter.create(RequestAPI.class);
    }

    public RequestAPI getAPI() {
        return API;
    }
}
