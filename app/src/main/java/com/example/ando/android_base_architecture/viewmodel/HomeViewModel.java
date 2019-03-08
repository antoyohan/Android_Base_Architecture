package com.example.ando.android_base_architecture.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.ando.android_base_architecture.network.ApiService;

import javax.inject.Inject;

import io.reactivex.BackpressureStrategy;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class HomeViewModel extends ViewModel {

    private static final String TAG = HomeViewModel.class.getSimpleName();
    public String mText;
    @Inject
    ApiService mApiService;

    @Inject
    HomeViewModel() {

    }

    public void getWeatherInfo() {
        //single();
        flowable();
        //maybe();
        //completable();
    }

    private void maybe() {
        mApiService.getWeatherData_maybe("71cb94ffacc30bb0e50b888b879bde00").
                observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.computation()).subscribe(new MaybeObserver<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void completable() {
        mApiService.getWeatherData_completable("71cb94ffacc30bb0e50b888b879bde00").
                observeOn(AndroidSchedulers.mainThread()).
                        subscribeOn(Schedulers.computation()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private void single() {
        mApiService.getWeatherData("71cb94ffacc30bb0e50b888b879bde00").
                observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.computation()).
                subscribe(new SingleObserver<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe() called with: d = [" + d + "]");
            }

            @Override
            public void onSuccess(Object o) {
                Log.d(TAG, "onSuccess() called with: o = [" + o + "]");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError() called with: e = [" + e + "]");
            }
        });
    }

    private void flowable() {

        FlowableOnSubscribe<Integer> flowableOnSubscribe = emitter -> {
            for (int i = 0; i < 10000; i++) {
                Log.d(TAG, "emitting: " + i);
                emitter.onNext(i);
            }
        };
        Flowable<Integer> observable = Flowable.create(flowableOnSubscribe, BackpressureStrategy.LATEST);

        observable.subscribeOn(Schedulers.computation()).observeOn(Schedulers.newThread()).subscribe(new DisposableSubscriber<Integer>() {
            @Override
            public void onNext(Integer integer) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Log.d(TAG, "onNext: " + e.getMessage());
                }
                Log.d(TAG, "onNext() called with: integer = [" + integer + "]");
            }

            @Override
            public void onError(Throwable t) {
                Log.d(TAG, "onError() called with: t = [" + t + "]");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete() called");
            }
        });
    }
}
