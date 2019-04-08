package com.example.ando.android_base_architecture.ui.recycler_view.view_holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

/**
 * Base class for all RecyclerView.ViewHolder
 * Write getLayout() method in the child class and return corresponding layout id.
 * */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    protected int mType;

    public BaseViewHolder(@NonNull View itemView, int type) {
        super(itemView);
        mType = type;
    }

    public int getType() {
        return mType;
    }

    /**
     * Write this method in childto provide the layout
     */
    protected static int getLayout() {
        return -1;
    }

    public abstract void setData(BaseViewItem item);
}
