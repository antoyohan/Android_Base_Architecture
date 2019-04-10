package com.example.ando.android_base_architecture.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.common.Constants;
import com.example.ando.android_base_architecture.databinding.FragmentListBinding;
import com.example.ando.android_base_architecture.repository.DataSourceFactory;
import com.example.ando.android_base_architecture.ui.adapters.DynamicRecycleViewAdapter;
import com.example.ando.android_base_architecture.ui.recycler_view.common.VerticalSpaceItemDecoration;
import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;
import com.facebook.shimmer.ShimmerFrameLayout;

import javax.inject.Inject;

public class Fragment_Recycler extends Fragment {
    private static String TAG = Fragment_Recycler.class.getSimpleName();

    private FragmentListBinding layoutBinding;
    private ShimmerFrameLayout mShimmerViewContainer;
    private int mFragmentType;

    @Inject
    public Fragment_Recycler() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getArguments();
        if (data != null) {
            mFragmentType = data.getInt(Constants.FRAGMENT_TYPE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        Log.d(TAG, "onCreateView: ");
        mShimmerViewContainer = layoutBinding.shimmerViewContainer;
        new Handler().postDelayed(this::initViews, 3000);
        return layoutBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    private void initViews() {
        Log.d(TAG, "initViews:");
        DynamicRecycleViewAdapter adapter = new DynamicRecycleViewAdapter();
        layoutBinding.mainList.setLayoutManager(new LinearLayoutManager(this.getContext()));
        VerticalSpaceItemDecoration itemDecoration = new VerticalSpaceItemDecoration(8);
        layoutBinding.mainList.addItemDecoration(itemDecoration);
        layoutBinding.mainList.setAdapter(adapter);
        layoutBinding.mainList.setVisibility(View.VISIBLE);
        initDataSource(adapter);
    }

    private void hideShimmerEffect() {
        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
    }

    private void initDataSource(DynamicRecycleViewAdapter adapter) {
        DataSourceFactory itemDataSourceFactory = new DataSourceFactory(this.getContext(), mFragmentType);

        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(10)
                        .build();

        LiveData<PagedList<BaseViewItem>> itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();
        itemPagedList.observe(this, baseViewItems -> {
            adapter.submitList(baseViewItems);
            hideShimmerEffect();
        });
    }
}
