package com.example.fileexhibitsloader;


import android.content.Context;

import com.example.model.BasicModel;
import com.example.model.ExhibitsLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FileExhibitsLoader implements ExhibitsLoader {
    private RetrofitService mRetrofitService;
    private IRetrofitCallback mIRetrofitCallback;

    public FileExhibitsLoader(Context context) {
        mRetrofitService = ExhibitApp.get(context).getRetrofitService();
        mIRetrofitCallback = (IRetrofitCallback) context;
    }

    @Override
    public void getExhibitList() {
        Call<BasicModel> call = mRetrofitService.getExhibitList();

        call.enqueue(new Callback<BasicModel>() {
            @Override
            public void onResponse(Call<BasicModel> call, Response<BasicModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mIRetrofitCallback.onRetrofitClearWork(response.body().getExhibitList());
                }
            }

            @Override
            public void onFailure(Call<BasicModel> call, Throwable t) {
                mIRetrofitCallback.onRetrofitError(t.getMessage());
            }
        });
    }
}
