package com.example.ando.android_base_architecture.datasource;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

public class ItemDataSourceFactory extends DataSource.Factory {

    private static final String TAG = ItemDataSourceFactory.class.getSimpleName();
    private MutableLiveData<PageKeyedDataSource> itemLivedataSource = new MutableLiveData<>();
    @NonNull
    @Override
    public DataSource create() {
        Log.d(TAG, "create: ");
        ItemDataSource dataSource = new ItemDataSource();
        itemLivedataSource.postValue(dataSource);
        return dataSource;
    }

    public MutableLiveData<PageKeyedDataSource> getItemLivedataSource() {
        return itemLivedataSource;
    }
}
