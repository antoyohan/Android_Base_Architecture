package com.example.ando.android_base_architecture.ui.recycler_view.common;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.databinding.ActorListItemBinding;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.ActorTileViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.BaseViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.CarouselViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.EmoticonViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.EmptyViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.EpisodeViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.LinearTrayViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.MoviePoster_Type1_Holder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.ShowViewHolder;
import com.example.ando.android_base_architecture.ui.recycler_view.view_holders.SimpleOptionViewHolder;

import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.ACTOR_ITEM;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.EMOTICON_ITEM;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.EMPTY_VIEW;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.EPISODE_ITEM;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.LINEAR_TRAY;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.MOVIE_CAROUSEL;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.MOVIE_POSTER_TYPE_1;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.SHOW_ITEM;
import static com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType.SIMPLE_OPTION_ITEM;

public class RecyclerUtils {


    public static BaseViewHolder getViewHolder(int viewType, ViewGroup viewGroup) {
        BaseViewHolder viewHolder = null;
        switch (viewType) {
            case ACTOR_ITEM:

                ActorListItemBinding binding = DataBindingUtil.inflate(
                        LayoutInflater.from(viewGroup.getContext()),
                        R.layout.actor_list_item, viewGroup, false);
                viewHolder = new ActorTileViewHolder(binding, ACTOR_ITEM);

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

            case SHOW_ITEM:
                viewHolder = new ShowViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(ShowViewHolder.getLayout(), viewGroup, false), SHOW_ITEM);
                break;

            case EPISODE_ITEM:
                viewHolder = new EpisodeViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(EpisodeViewHolder.getLayout(), viewGroup, false), EPISODE_ITEM);
                break;

            case SIMPLE_OPTION_ITEM:
                viewHolder = new SimpleOptionViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(SimpleOptionViewHolder.getLayout(), viewGroup, false), SIMPLE_OPTION_ITEM);
                break;

            default:
                viewHolder = new EmoticonViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(EmptyViewHolder.getLayout(), viewGroup, false), EMPTY_VIEW);
                break;

        }
        return viewHolder;
    }
}
