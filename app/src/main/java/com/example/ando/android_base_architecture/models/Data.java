package com.example.ando.android_base_architecture.models;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("reputation")
    private String mReputation;
    @SerializedName("user_id")
    private Integer mUserId;
    @SerializedName("user_type")
    private String mUserType;
    @SerializedName("profile_image")
    private String mProfileImage;

    public String getReputation() {
        return mReputation;
    }

    public void setReputation(String reputation) {
        mReputation = reputation;
    }

    public Integer getUserId() {
        return mUserId;
    }

    public void setUserId(Integer userId) {
        mUserId = userId;
    }

    public String getUserType() {
        return mUserType;
    }

    public void setUserType(String userType) {
        mUserType = userType;
    }

    public String getProfileImage() {
        return mProfileImage;
    }

    public void setProfileImage(String profileImage) {
        mProfileImage = profileImage;
    }
}
