package com.example.ando.android_base_architecture.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.databinding.FragmentALayoutBinding;
import com.example.ando.android_base_architecture.network.ApiService;
import com.example.ando.android_base_architecture.viewmodel.HomeViewModel;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class FragmentA extends Fragment {
    private static final String TAG = FragmentA.class.getSimpleName();
    @Inject
    ApiService mApiService;
    @Inject
    ViewModelProvider.Factory mFactory;
    private HomeViewModel mViewModel;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
        Log.d(TAG, "onCreate: apiservice " + mApiService);
        initComponents();
    }

    private void initComponents() {
        mViewModel = ViewModelProviders.of(this, mFactory).get(HomeViewModel.class);
        Log.d(TAG, "initComponents: viewMOdel " + mViewModel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentALayoutBinding layoutBinding =
                DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_a_layout, container, false);
        layoutBinding.setHomeViewModel(mViewModel);
        return layoutBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
