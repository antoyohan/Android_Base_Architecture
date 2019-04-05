package com.example.ando.android_base_architecture.models;

import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

public class Employee extends BaseViewItem {
    private String mTitle;
    private String mSubTitle;

    public Employee(String mTitle, String mSubTitle, int type) {
        this.mTitle = mTitle;
        this.mSubTitle = mSubTitle;
        this.mViewType = type;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmSubTitle() {
        return mSubTitle;
    }

    public void setmSubTitle(String mSubTitle) {
        this.mSubTitle = mSubTitle;
    }
}
