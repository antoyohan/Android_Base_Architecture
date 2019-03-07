package com.example.ando.android_base_architecture.network;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {

    @GET
    Observable getProfilr(@QueryMap String data);

    @GET("data/2.5/forecast?id=524901")
    Single<Object> getWeatherData(@Query("appid") String key);

    @GET("data/2.5/forecast?id=524901")
    Maybe<Object> getWeatherData_maybe(@Query("appid") String key);

    @GET("data/2.5/forecast?id=524901")
    Completable getWeatherData_completable(@Query("appid") String key);
}
