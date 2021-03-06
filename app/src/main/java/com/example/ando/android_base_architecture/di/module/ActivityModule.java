package com.example.ando.android_base_architecture.di.module;

import android.support.v4.app.Fragment;

import com.example.ando.android_base_architecture.ui.FragmentA;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public class ActivityModule {

    @Provides
    FragmentA provideFragmentA() {
        return new FragmentA();
    }
}
