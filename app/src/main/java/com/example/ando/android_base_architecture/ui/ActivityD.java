package com.example.ando.android_base_architecture.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.ando.android_base_architecture.R;

public class ActivityD extends AppCompatActivity {
    private static final String TAG = ActivityD.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(this, ActivityC.class);
        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void launchSameActivity(View view) {
        Intent intent = new Intent(this, ActivityB.class);
        startActivity(intent);
    }
}