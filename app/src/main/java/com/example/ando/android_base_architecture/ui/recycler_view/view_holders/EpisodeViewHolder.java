package com.example.ando.android_base_architecture.ui.recycler_view.view_holders;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

public class EpisodeViewHolder extends BaseViewHolder {
    public EpisodeViewHolder(@NonNull View itemView, int type) {
        super(itemView, type);
    }

    public static int getLayout() {
        return R.layout.episode_view_item;
    }

    @Override
    public void setData(BaseViewItem item) {

    }
}
