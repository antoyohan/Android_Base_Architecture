package com.example.ando.android_base_architecture.models;

import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponse {

    @SerializedName("items")
    private List<BaseViewItem> mDataList;
    @SerializedName("total_count")
    private int mCount;

    public List<BaseViewItem> getDataList() {
        return mDataList;
    }

    public void setDataList(List<BaseViewItem> dataList) {
        mDataList = dataList;
    }
}
