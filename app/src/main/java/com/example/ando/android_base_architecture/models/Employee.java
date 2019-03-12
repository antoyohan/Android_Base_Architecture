package com.example.ando.android_base_architecture.models;

public class Employee {
    private String mTitle;
    private String mSubTitle;

    public Employee(String mTitle, String mSubTitle) {
        this.mTitle = mTitle;
        this.mSubTitle = mSubTitle;
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
