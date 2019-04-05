package com.example.ando.android_base_architecture.repository;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

public class DataSourceFactory extends DataSource.Factory<Integer, BaseViewItem> {
    private MutableLiveData<PageKeyedDataSource> mLiveBaseItem = new MutableLiveData<>();

    @Override
    public DataSource<Integer, BaseViewItem> create() {
        ItemDataSource dataSource = new ItemDataSource();
        mLiveBaseItem.postValue(dataSource);
        return dataSource;
    }

    public MutableLiveData<PageKeyedDataSource> getLiveBaseItem() {
        return mLiveBaseItem;
    }
}
