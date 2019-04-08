package com.example.ando.android_base_architecture.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerUtils;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.BaseViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

import java.util.List;

public class ListRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    List<BaseViewItem> mContentLIst;

    public ListRecyclerViewAdapter(List<BaseViewItem> contentList) {
        this.mContentLIst = contentList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        BaseViewItem item = getItem(i);
        return RecyclerUtils.getViewHolder(item.getViewType(), viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.setData(getItem(i));
    }

    private BaseViewItem getItem(int i) {
        return mContentLIst.get(i);
    }

    @Override
    public int getItemCount() {
        return mContentLIst.size();
    }
}
