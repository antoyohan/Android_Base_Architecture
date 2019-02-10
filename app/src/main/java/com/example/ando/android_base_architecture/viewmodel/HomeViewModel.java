package com.example.ando.android_base_architecture.viewmodel;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

public class HomeViewModel extends ViewModel {

    public String mText;

    @Inject
    HomeViewModel() {

    }
}
