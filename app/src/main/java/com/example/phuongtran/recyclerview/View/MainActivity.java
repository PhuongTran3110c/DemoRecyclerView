package com.example.phuongtran.recyclerview.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.phuongtran.recyclerview.Model.AdapterAndroid;
import com.example.phuongtran.recyclerview.Model.AndroidDetail;
import com.example.phuongtran.recyclerview.Presenter.PresenterMain;
import com.example.phuongtran.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewMain {
    RecyclerView  recyclerView;
    List<AndroidDetail> list;
    AdapterAndroid adapter;
    PresenterMain presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        presenter = new PresenterMain(this);
        presenter.LoadData();
    }

    void Init(){
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();
        adapter = new AdapterAndroid(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void LoadSuccess(List<AndroidDetail> list) {
        this.list.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void LoadFailed(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
