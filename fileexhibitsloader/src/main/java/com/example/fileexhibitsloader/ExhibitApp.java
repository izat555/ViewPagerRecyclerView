package com.example.fileexhibitsloader;

import android.app.Application;
import android.content.Context;

public class ExhibitApp extends Application {
    private RetrofitService mRetrofitService;

    @Override
    public void onCreate() {
        super.onCreate();
        mRetrofitService = NetworkBuilder.initRetrofit();
    }

    public static ExhibitApp get(Context context) {
        return (ExhibitApp) context.getApplicationContext();
    }

    public RetrofitService getRetrofitService() {
        return mRetrofitService;
    }
}
