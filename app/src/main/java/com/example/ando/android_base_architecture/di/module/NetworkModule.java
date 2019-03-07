package com.example.ando.android_base_architecture.di.module;

import com.example.ando.android_base_architecture.network.ApiService;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    Gson providesGson() {
        return new Gson().newBuilder().create();
    }

    @Provides
    OkHttpClient provideHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder().
                addInterceptor(interceptor).build();
    }

    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .baseUrl("https://samples.openweathermap.org/").build();
    }

    @Provides
    HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        return loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
    }

    @Provides
    ApiService provideApiService(Retrofit restClient) {
        return restClient.create(ApiService.class);
    }
}

