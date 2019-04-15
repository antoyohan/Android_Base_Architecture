package com.example.ando.android_base_architecture.network;

import com.example.ando.android_base_architecture.models.DocResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {

    @GET
    Observable getProfilr(@QueryMap String data);

    @Headers({
            "X-COLLECTION:service",
            "X-TOKEN:PriWAmTNpOs9lxkxjVCJ0kjXRzrglXJ0y1+s692u4q1oeOYr/YBShrhw7uTwFlFbNlHkT464Uh1Ry4+hr2kRJA==",
            "X-QUERY:indent=on&q=*:*&wt=json&sort=DATECOL_dt desc&start=0&rows=2000",
            "Content-Type:application/json"
    })
    @GET
    Observable<DocResponse> getBookList(@Url String url);
}
