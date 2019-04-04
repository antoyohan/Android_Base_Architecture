package com.example.ando.android_base_architecture.network;

import com.example.ando.android_base_architecture.models.StackApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {

    @GET
    Observable getProfilr(@QueryMap String data);

    @GET("answers")
    Observable<StackApiResponse> getTackExchangeData(@Query("page") int page, @Query("pagesize") int size, @Query("site") String site);
}
