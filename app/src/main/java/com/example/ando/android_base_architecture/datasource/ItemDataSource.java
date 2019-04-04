package com.example.ando.android_base_architecture.datasource;

import android.util.Log;

import com.example.ando.android_base_architecture.di.module.NetworkModule;
import com.example.ando.android_base_architecture.models.Item;
import com.example.ando.android_base_architecture.models.StackApiResponse;
import com.example.ando.android_base_architecture.network.ApiService;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, Item> {

    public static final int PAGE_SIZE = 50;
    public static final int FIRST_PAGE = 1;
    public static final String SITE_NAME = "stackoverflow";
    private static final String TAG = ItemDataSource.class.getSimpleName();

    ApiService mApiService;

    public ItemDataSource() {
        mApiService = NetworkModule.provideApiService();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Item> callback) {
        Log.d(TAG, "loadInitial() called with: params ");
        mApiService.getTackExchangeData(FIRST_PAGE, PAGE_SIZE, SITE_NAME).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<StackApiResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(StackApiResponse stackApiResponse) {

                if (stackApiResponse != null) {
                    Log.d(TAG, "onNext: " + stackApiResponse.getItems().size());
                    callback.onResult(stackApiResponse.getItems(), null, FIRST_PAGE + 1);
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "  + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });
    }

    ;

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Item> callback) {
        Log.d(TAG, "loadBefore() called with: params = [" + params.key + "]");

        mApiService.getTackExchangeData(FIRST_PAGE, PAGE_SIZE, SITE_NAME).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<StackApiResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(StackApiResponse stackApiResponse) {
                if (stackApiResponse != null) {
                    Log.d(TAG, "onNext: load before" + stackApiResponse.getItems().size());

                    Integer key = params.key > 1 ? params.key - 1 : null;
                    callback.onResult(stackApiResponse.getItems(), key);
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Item> callback) {
        Log.d(TAG, "loadAfter() called with: params = [" + params.key + "]");
        mApiService.getTackExchangeData(FIRST_PAGE, PAGE_SIZE, SITE_NAME).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<StackApiResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(StackApiResponse stackApiResponse) {

                if (stackApiResponse != null) {
                    Log.d(TAG, "onNext: load after " + stackApiResponse.getItems().size());

                    Integer key = stackApiResponse.getHas_more() ? params.key + 1 : null;
                    callback.onResult(stackApiResponse.getItems(), key);
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });
    }
}
