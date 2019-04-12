package com.example.ando.android_base_architecture.ui.recycler_view.view_holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

public class SimpleOptionViewHolder extends BaseViewHolder {

    private final TextView mTitle;

    public SimpleOptionViewHolder(@NonNull View itemView, int type) {
        super(itemView, type);
        mTitle = itemView.findViewById(R.id.title);
    }

    public static int getLayout() {
        return R.layout.simple_option_view_item;
    }

    @Override
    public void setData(BaseViewItem item) {
        mTitle.setText(item.getTitle());
    }
}
