package com.example.ando.android_base_architecture.di.module;

import com.example.ando.android_base_architecture.network.ApiService;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkModule {


    private static Gson providesGson() {
        return new Gson().newBuilder().create();
    }


    private static OkHttpClient provideHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(logging).build();
    }


    private static Retrofit provideRetrofit(Gson gson, OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.stackexchange.com/2.2/").build();
    }


    public static ApiService provideApiService() {
        Retrofit restClient = provideRetrofit(providesGson(), provideHttpClient());
        return restClient.create(ApiService.class);
    }
}

