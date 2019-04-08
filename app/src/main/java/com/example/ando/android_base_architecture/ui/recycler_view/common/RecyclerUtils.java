package com.example.ando.android_base_architecture.ui.recycler_view.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.BaseViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.EmployeeTileViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.EmptyViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.LinearTrayViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.MoviePoster_Type1_Holder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.MovieViewHolder;

import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.EMPLOYEE_ITEM;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.EMPTY_VIEW;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.LINEAR_TRAY;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.MOVIE_ITEM;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.MOVIE_POSTER_TYPE_1;

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

            case LINEAR_TRAY:
                viewHolder = new LinearTrayViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(LinearTrayViewHolder.getLayout(), viewGroup, false), LINEAR_TRAY);
                break;

            case MOVIE_POSTER_TYPE_1:
                viewHolder = new MoviePoster_Type1_Holder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(MoviePoster_Type1_Holder.getLayout(), viewGroup, false), MOVIE_POSTER_TYPE_1);
                break;

            default:
                viewHolder = new MovieViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(EmptyViewHolder.getLayout(), viewGroup, false), EMPTY_VIEW);
                break;

        }
        return viewHolder;
    }
}
