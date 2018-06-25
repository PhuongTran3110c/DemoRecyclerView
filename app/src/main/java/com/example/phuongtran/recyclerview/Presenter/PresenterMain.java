package com.example.phuongtran.recyclerview.Presenter;

import com.example.phuongtran.recyclerview.Model.JSONRequest;
import com.example.phuongtran.recyclerview.Model.JSONResponse;
import com.example.phuongtran.recyclerview.View.ViewMain;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PresenterMain {
    private ViewMain view;

    public PresenterMain(ViewMain view){
        this.view = view;
    }


    public void LoadData()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.learn2crack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final JSONRequest request = retrofit.create(JSONRequest.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                if(response != null && response.isSuccessful() && response.body() != null){
                    view.LoadSuccess(response.body().getData());
                }else{
                    onFailure(null, new Exception("coi lại đi sai rồi"));
                }
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                String s = "Not connect internet !";
                view.LoadFailed(s);
            }
        });
    }
}
