package com.example.ando.android_base_architecture.ui.recyclerview.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.models.Item;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImageView;
    private TextView mTitle;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.image_view);
        mTitle = itemView.findViewById(R.id.title);
    }

    public void setData(Item item) {
        mTitle.setText(item.getOwner().getDisplay_name());
    }
}
