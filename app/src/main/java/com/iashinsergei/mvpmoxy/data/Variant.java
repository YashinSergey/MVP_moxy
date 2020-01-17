package com.iashinsergei.mvpmoxy.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variant {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("text")
    @Expose
    private String varText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVarText() {
        return varText;
    }

    public void setVarText(String varText) {
        this.varText = varText;
    }
}
