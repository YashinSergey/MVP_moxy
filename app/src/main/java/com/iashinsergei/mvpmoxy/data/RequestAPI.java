package com.iashinsergei.mvpmoxy.data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestAPI {

    @GET("json/JSONSample.json")
    Call<RequestModel> loadData();
}
