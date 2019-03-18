package com.example.ando.android_base_architecture.ui;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

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
        PlayerView mPlayerView =  new PlayerView();
        lifecycleRegistry.addObserver(mPlayerView);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public AndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(this, ActivityA.class);
        startActivity(intent);
    }

    public void launchSameActivity(View view) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}


