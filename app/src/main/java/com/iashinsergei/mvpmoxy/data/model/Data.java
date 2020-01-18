package com.iashinsergei.mvpmoxy.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("text")
    @Expose private String text;

    @SerializedName("url")
    @Expose private String url;

    @SerializedName("selectedId")
    @Expose private Integer selectedId;

    @SerializedName("variants")
    @Expose private List<Variant> variants;

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public Integer getSelectedId() {
        return selectedId;
    }

    public List<Variant> getVariants() {
        return variants;
    }
}
