package com.example.fileexhibitsloader;

import com.example.model.Exhibit;

import java.util.List;

public interface IRetrofitCallback {
    void onRetrofitClearWork(List<Exhibit> exhibitList);
    void onRetrofitError(String msg);
}
