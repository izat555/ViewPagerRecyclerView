package com.example.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BasicModel {
    @SerializedName("list")
    private List<Exhibit> mExhibitList = null;

    public List<Exhibit> getExhibitList() {
        return mExhibitList;
    }
}
