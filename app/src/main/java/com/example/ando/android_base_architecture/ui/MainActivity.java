package com.example.ando.android_base_architecture.ui;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ando.android_base_architecture.PlayerView;
import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.network.ApiService;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector, LifecycleOwner {

    private static final String TAG = MainActivity.class.getSimpleName();
    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Inject
    DispatchingAndroidInjector<android.support.v4.app.Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    ApiService mApiService;
    @Inject
    FragmentA mFragmentA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: apiService " + mApiService);
        Log.d(TAG, "onCreate: fragment " + mFragmentA);
        loadFragment();
        PlayerView mPlayerView =  new PlayerView();
        lifecycleRegistry.addObserver(mPlayerView);
    }

    private void loadFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, mFragmentA);
        transaction.commitNow();
    }

    @Override
    public AndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}


