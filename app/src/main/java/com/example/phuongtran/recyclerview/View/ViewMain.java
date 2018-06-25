package com.example.phuongtran.recyclerview.View;

import com.example.phuongtran.recyclerview.Model.AndroidDetail;

import java.util.List;

public interface ViewMain {
    void LoadSuccess(List<AndroidDetail> list);
    void LoadFailed(String error);
}
