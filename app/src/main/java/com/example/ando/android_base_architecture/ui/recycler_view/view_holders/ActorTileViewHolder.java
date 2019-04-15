package com.example.ando.android_base_architecture.ui.recycler_view.view_holders;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.example.ando.android_base_architecture.BR;
import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.databinding.ActorListItemBinding;
import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

public class ActorTileViewHolder extends BaseViewHolder {
    private final ActorListItemBinding mDataBinding;
    private TextView mTitle;
    private TextView mSubTitle;

    public ActorTileViewHolder(ViewDataBinding dataBinding, int type) {
        super(dataBinding, type);
        mDataBinding = (ActorListItemBinding) dataBinding;
    }


    public static int getLayout() {
        return R.layout.actor_list_item;
    }

    @Override
    public void setData(BaseViewItem item) {
        //mTitle.setText(item.getmTitle());
       // mSubTitle.setText(item.getSubtitle());
        mDataBinding.setVariable(BR.data, item);
        mDataBinding.executePendingBindings();
    }
}
