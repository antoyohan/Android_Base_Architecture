package com.example.ando.android_base_architecture.ui;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.BR;
import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.databinding.FragmentALayoutBinding;
import com.example.ando.android_base_architecture.network.ApiService;
import com.example.ando.android_base_architecture.viewmodel.HomeViewModel;

public class FragmentA extends Fragment {
    private static final String TAG = FragmentA.class.getSimpleName();

    ApiService mApiService;

    ViewModelProvider.Factory mFactory;
    private HomeViewModel mViewModel;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        ViewDataBinding layoutBinding =
                DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_a_layout, container, false);
        layoutBinding.setVariable(BR.HomeViewModel, mViewModel);
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
