package com.example.ando.android_base_architecture.di;

import com.example.ando.android_base_architecture.di.module.ActivityModule;
import com.example.ando.android_base_architecture.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {ActivityModule.class, FragmentBuilder.class})
    abstract MainActivity bindActivity();
}
