package com.example.ando.android_base_architecture.ui.recycler_view.view_item;

import com.example.ando.android_base_architecture.models.Data;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseViewItem {
    @SerializedName("title")
    protected String mTitle;
    protected int mId;
    @SerializedName("layout_type")
    protected int mViewType;
    @SerializedName("subtitle")
    protected String mSubtitle;
    @SerializedName("data")
    protected Data mData;
    @SerializedName("items")
    protected List<BaseViewItem> mItems;

    public String getmTitle() {
        return mTitle;
    }

    public int getmId() {
        return mId;
    }

    public int getViewType() {
        return mViewType;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public void setViewType(int viewType) {
        mViewType = viewType;
    }

    public String getSubtitle() {
        return mSubtitle;
    }

    public void setSubtitle(String subtitle) {
        mSubtitle = subtitle;
    }

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

    public List<BaseViewItem> getItems() {
        return mItems;
    }

    public void setItems(List<BaseViewItem> items) {
        mItems = items;
    }
}
