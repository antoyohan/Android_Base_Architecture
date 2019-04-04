package com.example.ando.android_base_architecture.ui;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.example.ando.android_base_architecture.PlayerView;
import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.network.ApiService;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    private static final String TAG = MainActivity.class.getSimpleName();
    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    ApiService mApiService;

    FragmentA mFragmentA;

    Fragment_Recycler mFragmentRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: apiService " + mApiService);
        Log.d(TAG, "onCreate: fragment " + mFragmentA);
        loadFragment();
        PlayerView mPlayerView =  new PlayerView();
        lifecycleRegistry.addObserver(mPlayerView);
    }

    private void loadFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        mFragmentRecycler = new Fragment_Recycler();
        transaction.add(R.id.fragment_container, mFragmentRecycler);
        transaction.commitNow();
    }

}


