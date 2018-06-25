package com.example.phuongtran.recyclerview.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONRequest {
    @GET("android/jsonandroid/")
    Call<JSONResponse> getJSON();
}
