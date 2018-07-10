package com.example.fileexhibitsloader;

import com.example.model.BasicModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("/t1qKMS")
    Call<BasicModel> getExhibitList();
}
