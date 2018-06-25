package com.example.phuongtran.recyclerview.Model;

import com.example.phuongtran.recyclerview.Model.AndroidDetail;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JSONResponse {
    @SerializedName("android")
    private List<AndroidDetail> data;

    public List<AndroidDetail> getData() {
        return data;
    }
}
