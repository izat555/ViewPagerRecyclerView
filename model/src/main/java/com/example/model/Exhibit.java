package com.example.model;

import com.google.gson.annotations.SerializedName;

public class Exhibit {
    @SerializedName("title")
    private String mTitle;
    @SerializedName("images")
    private java.util.List<String> mImageList = null;

    public String getTitle() {
        return mTitle;
    }

    public java.util.List<String> getImages() {
        return mImageList;
    }
}
