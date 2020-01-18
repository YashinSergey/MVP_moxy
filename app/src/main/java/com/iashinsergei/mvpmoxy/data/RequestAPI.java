package com.iashinsergei.mvpmoxy.data;

import com.iashinsergei.mvpmoxy.data.model.RequestModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestAPI {

    @GET("json/JSONSample.json")
    Call<RequestModel> loadData();
}
