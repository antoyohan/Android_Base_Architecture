package com.example.ando.android_base_architecture.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.ando.android_base_architecture.network.ApiService;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

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

    private void flowable() {
        PublishSubject<Integer> publishSubject = PublishSubject.create();
        //publishSubject.toFlowable(BackpressureStrategy.MISSING);
        publishSubject.subscribeOn(Schedulers.computation()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe() called with: d = [" + d + "]");
            }

            @Override
            public void onNext(Integer integer) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "onNext() called with: integer = [" + integer + "]");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError() called with: e = [" + e + "]");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete() called");
            }
        });
        for (int i = 0; i < 10000; i ++) {
            Log.d(TAG, "emitting " + i);
            (publishSubject).onNext(i);
        }
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
}
