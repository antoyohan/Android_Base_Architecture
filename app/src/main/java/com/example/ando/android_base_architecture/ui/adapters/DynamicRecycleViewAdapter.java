package com.example.ando.android_base_architecture.ui.adapters;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.util.Log;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerUtils;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.BaseViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

public class DynamicRecycleViewAdapter extends PagedListAdapter<BaseViewItem, BaseViewHolder> {
    private static final String TAG = DynamicRecycleViewAdapter.class.getSimpleName();

    public DynamicRecycleViewAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        Log.d(TAG, "onCreateViewHolder() called with:  type = [" + type + "]");
        return RecyclerUtils.getViewHolder(type, viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int position) {
        baseViewHolder.setData(getItem(position));
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getViewType();
    }

    private static DiffUtil.ItemCallback<BaseViewItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<BaseViewItem>() {
                @Override
                public boolean areItemsTheSame(BaseViewItem oldItem, BaseViewItem newItem) {
                    Log.d(TAG, "areItemsTheSame: ");
                    return oldItem.getmId() == newItem.getmId();
                }

                @Override
                public boolean areContentsTheSame(BaseViewItem oldItem, BaseViewItem newItem) {
                    Log.d(TAG, "areContentsTheSame: ");
                    return oldItem.equals(newItem);
                }
            };
}
