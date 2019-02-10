package com.example.ando.android_base_architecture.di.component;

import com.example.ando.android_base_architecture.MyApplication;
import com.example.ando.android_base_architecture.di.ActivityBuilder;
import com.example.ando.android_base_architecture.di.AppViewModelFactory;
import com.example.ando.android_base_architecture.di.module.ApplicationModule;
import com.example.ando.android_base_architecture.di.module.NetworkModule;
import com.example.ando.android_base_architecture.di.module.ViewModelModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {AndroidInjectionModule.class, NetworkModule.class, ApplicationModule.class ,
        ActivityBuilder.class, ViewModelModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder setApplication(MyApplication application);
        ApplicationComponent create();
    }
}
