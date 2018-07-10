package com.example.fileexhibitsloader;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkBuilder {
    private static RetrofitService sRetrofitService = null;

    public static RetrofitService initRetrofit() {
        if (sRetrofitService == null) {
            sRetrofitService = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RetrofitService.class);
        }
        return sRetrofitService;
    }
}
