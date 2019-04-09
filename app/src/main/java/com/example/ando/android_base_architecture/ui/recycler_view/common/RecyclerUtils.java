package com.example.ando.android_base_architecture.ui.recycler_view.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.BaseViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.CarouselViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.EmoticonViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.ActorTileViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.EmptyViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.LinearTrayViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.MoviePoster_Type1_Holder;

import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.EMOTICON_ITEM;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.ACTOR_ITEM;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.EMPTY_VIEW;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.LINEAR_TRAY;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.MOVIE_CAROUSEL;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.MOVIE_POSTER_TYPE_1;

public class RecyclerUtils {


    public static BaseViewHolder getViewHolder(int viewType, ViewGroup viewGroup) {
        BaseViewHolder viewHolder = null;
        switch (viewType) {
            case ACTOR_ITEM:
                viewHolder = new ActorTileViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(ActorTileViewHolder.getLayout(), viewGroup, false), ACTOR_ITEM);
                break;

            case EMOTICON_ITEM:
                viewHolder = new EmoticonViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(EmoticonViewHolder.getLayout(), viewGroup, false), EMOTICON_ITEM);
                break;

            case LINEAR_TRAY:
                viewHolder = new LinearTrayViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(LinearTrayViewHolder.getLayout(), viewGroup, false), LINEAR_TRAY);
                break;

            case MOVIE_POSTER_TYPE_1:
                viewHolder = new MoviePoster_Type1_Holder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(MoviePoster_Type1_Holder.getLayout(), viewGroup, false), MOVIE_POSTER_TYPE_1);
                break;

            case MOVIE_CAROUSEL:
                viewHolder = new CarouselViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(CarouselViewHolder.getLayout(), viewGroup, false), MOVIE_CAROUSEL);
                break;

            default:
                viewHolder = new EmoticonViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(EmptyViewHolder.getLayout(), viewGroup, false), EMPTY_VIEW);
                break;

        }
        return viewHolder;
    }
}
