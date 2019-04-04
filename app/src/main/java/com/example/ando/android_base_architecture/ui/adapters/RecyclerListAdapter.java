package com.example.ando.android_base_architecture.ui.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.models.Item;
import com.example.ando.android_base_architecture.ui.recyclerview.viewholder.BaseViewHolder;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;


public class RecyclerListAdapter extends PagedListAdapter<Item, BaseViewHolder> {

    private static final String TAG = RecyclerListAdapter.class.getSimpleName();

    public RecyclerListAdapter() {
        super(DIFF_CALLBACK);
        Log.d(TAG, "RecyclerListAdapter: ");
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_list_item, parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        Item item = getItem(position);
        holder.setData(item);
    }

    private static DiffUtil.ItemCallback<Item> DIFF_CALLBACK = new DiffUtil.ItemCallback<Item>() {
        @Override
        public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            Log.d(TAG, "areItemsTheSame: ");
            return oldItem.getAnswer_id() == newItem.getAnswer_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            Log.d(TAG, "areContentsTheSame: ");
            return oldItem.equals(newItem);
        }
    };
}
