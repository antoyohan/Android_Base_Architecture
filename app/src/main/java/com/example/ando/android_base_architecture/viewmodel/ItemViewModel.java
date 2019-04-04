package com.example.ando.android_base_architecture.viewmodel;

import android.util.Log;

import com.example.ando.android_base_architecture.datasource.ItemDataSource;
import com.example.ando.android_base_architecture.datasource.ItemDataSourceFactory;
import com.example.ando.android_base_architecture.models.Item;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

public class ItemViewModel extends ViewModel {

    private static final String TAG = ItemViewModel.class.getSimpleName();
    public LiveData<PagedList<Item>> itemPagedList;
    private LiveData<PageKeyedDataSource> liveDataSource;

    public ItemViewModel() {
        Log.d(TAG, "ItemViewModel: ");
        ItemDataSourceFactory dataSourceFactory = new ItemDataSourceFactory();

        PagedList.Config config = (new PagedList.Config.Builder()).setEnablePlaceholders(false)
                .setPageSize(ItemDataSource.PAGE_SIZE).build();

        itemPagedList = new LivePagedListBuilder(dataSourceFactory, config).build();
    }
}
