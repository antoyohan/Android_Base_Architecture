package com.example.ando.android_base_architecture.ui.recycler_view.view_holders;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

public class MoviePoster_Type1_Holder extends BaseViewHolder {

    public MoviePoster_Type1_Holder(@NonNull View itemView, int type) {
        super(itemView, type);
    }

    public static int getLayout() {
        return R.layout.movie_single_item;
    }

    @Override
    public void setData(BaseViewItem item) {

    }
}
