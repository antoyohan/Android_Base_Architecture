package com.example.ando.android_base_architecture.ui.recycler_view.common;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class HorizontalSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = HorizontalSpaceItemDecoration.class.getSimpleName();
    private int space;

    public HorizontalSpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Log.d(TAG, "getItemOffsets: ");

        outRect.left = space;
        outRect.right = space;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = 0;
        }
    }

    private void clearSpaces(Rect outRect) {
        outRect.left = 0;
        outRect.right = 0;
    }
}