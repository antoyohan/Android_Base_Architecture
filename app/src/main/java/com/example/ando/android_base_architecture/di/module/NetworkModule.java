package com.example.ando.android_base_architecture.di.module;

import com.example.ando.android_base_architecture.network.ApiService;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkModule {


    Gson providesGson() {
        return new Gson().newBuilder().create();
    }


    OkHttpClient provideHttpClient() {
        return new OkHttpClient.Builder().build();
    }


    Retrofit provideRetrofit(Gson gson, OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://www.google.com").build();
    }


    ApiService provideApiService(Retrofit restClient) {
        return restClient.create(ApiService.class);
    }
}

