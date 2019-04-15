package com.example.ando.android_base_architecture;

import android.app.Activity;
import android.app.Application;

import com.example.ando.android_base_architecture.di.component.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> mDispatchInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder().
                setApplication(this).
                create().inject(this);

        Realm.init(getApplicationContext());


        RealmConfiguration config =
                new RealmConfiguration.Builder()
                        .schemaVersion(1)
                        .deleteRealmIfMigrationNeeded()
                        .build();

        Realm.setDefaultConfiguration(config);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mDispatchInjector;
    }
}