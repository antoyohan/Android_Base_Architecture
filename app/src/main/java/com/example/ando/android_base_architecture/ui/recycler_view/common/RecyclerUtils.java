package com.example.ando.android_base_architecture.ui.recycler_view.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.BaseViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.EmployeeTileViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.EmptyViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.MovieViewHolder;

import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.EMPLOYEE_ITEM;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.EMPTY_VIEW;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.MOVIE_ITEM;

public class RecyclerUtils {


    public static BaseViewHolder getViewHolder(int viewType, ViewGroup viewGroup) {
        BaseViewHolder viewHolder = null;
        switch (viewType) {
            case EMPLOYEE_ITEM:
                viewHolder = new EmployeeTileViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(EmployeeTileViewHolder.getLayout(), viewGroup, false), EMPLOYEE_ITEM);
                break;

            case MOVIE_ITEM:
                viewHolder = new MovieViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(MovieViewHolder.getLayout(), viewGroup, false), MOVIE_ITEM);
                break;

            default:
                viewHolder = new MovieViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(EmptyViewHolder.getLayout(), viewGroup, false), EMPTY_VIEW);
                break;

        }
        return viewHolder;
    }
}
