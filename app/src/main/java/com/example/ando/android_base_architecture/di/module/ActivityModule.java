package com.example.ando.android_base_architecture.di.module;

import com.example.ando.android_base_architecture.ui.FragmentA;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    FragmentA provideFragmentA() {
        return new FragmentA();
    }
}
