package com.iashinsergei.mvpmoxy.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestModel {

    @SerializedName("data")
    @Expose private List<MainData> mainDataList;

    @SerializedName("view")
    @Expose private List<String> viewList;

    public List<MainData> getMainDataList() {
        return mainDataList;
    }

    public List<String> getViewList() {
        return viewList;
    }
}
