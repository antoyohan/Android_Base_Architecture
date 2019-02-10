package com.example.ando.android_base_architecture.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {

    @GET
    Observable getProfilr(@QueryMap String data);
}
