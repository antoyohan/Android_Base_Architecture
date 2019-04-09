package com.example.ando.android_base_architecture.ui.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

import java.util.List;

public class CarouselPagerAdapter extends PagerAdapter {

    private final List<BaseViewItem> mItemList;
    private Context mContext;

    public CarouselPagerAdapter(Context context, List<BaseViewItem> items) {
        mContext = context;
        mItemList = items;
    }

    @Override
    public int getCount() {
        return mItemList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o == view;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.carousel_view_item, container, false);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
