package com.example.ando.android_base_architecture.di;

import com.example.ando.android_base_architecture.ui.FragmentA;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilder {
    @ContributesAndroidInjector
    abstract FragmentA provideInjection();
}
