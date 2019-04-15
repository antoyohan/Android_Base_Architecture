package com.example.ando.android_base_architecture.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.view.View;

import com.example.ando.android_base_architecture.models.DocResponse;
import com.example.ando.android_base_architecture.models.Docs;
import com.example.ando.android_base_architecture.network.ApiService;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmResults;

public class HomeViewModel extends ViewModel {

    private static final String TAG = HomeViewModel.class.getSimpleName();
    public String mText;
    public String mValue;
    @Inject
    ApiService mApiService;
    private long mCurrentTime;
    private long mApiHitTime;

    @Inject
    HomeViewModel() {

    }

    public void getDocLIst(View View) {
        mApiService.getBookList("https://dcp.colt.net/portal/mflash")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DocResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                        mApiHitTime = System.currentTimeMillis();
                    }

                    @Override
                    public void onNext(DocResponse docResponse) {
                        Log.d(TAG, "onNext: " + docResponse.getResponse().getDocList().size());
                        Log.d(TAG, "onNext: Time taken for Api " + (System.currentTimeMillis() - mApiHitTime) / 1000 + "sec");
                        Realm realmDb = Realm.getDefaultInstance();
                        realmDb.executeTransactionAsync(
                                realm -> {
                                    mCurrentTime = System.currentTimeMillis();
                                    realm.insertOrUpdate(docResponse.getResponse().getDocList());
                                },
                                () -> {
                                    Log.d(TAG, "onNext: Time Taken for Realm " + (System.currentTimeMillis() - mCurrentTime) / 1000 + "sec");
                                    realmDb.close();
                                },
                                error -> {
                                    Log.d(TAG, "onError: " + error.getMessage());
                                    realmDb.close();
                                });
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    public void getDocLIstFromRealm(View view) {

        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Docs> results = realm.where(Docs.class).findAll();
                Log.d(TAG, "getDocLIstFromRealm: " + results.size());
            }
        });
    }
}
