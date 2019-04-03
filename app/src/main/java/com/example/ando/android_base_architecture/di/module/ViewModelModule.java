package com.example.ando.android_base_architecture.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.ando.android_base_architecture.di.AppViewModelFactory;
import com.example.ando.android_base_architecture.di.ViewModelKey;
import com.example.ando.android_base_architecture.viewmodel.HomeViewModel;
import com.example.ando.android_base_architecture.viewmodel.TestViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory getFactory(AppViewModelFactory appViewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    abstract ViewModel bindHomeViewModel(HomeViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TestViewModel.class)
    abstract ViewModel bindTestViewModel(TestViewModel viewModel);

}
