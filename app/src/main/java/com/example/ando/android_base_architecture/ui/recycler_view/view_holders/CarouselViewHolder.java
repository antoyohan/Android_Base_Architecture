package com.example.ando.android_base_architecture.ui.recycler_view.view_holders;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.ui.adapters.CarouselPagerAdapter;
import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

public class CarouselViewHolder extends BaseViewHolder {

    private final ViewPager mViewPager;
    private final TabLayout mTabLayout;

    public CarouselViewHolder(@NonNull View itemView, int type) {
        super(itemView, type);
        mViewPager = itemView.findViewById(R.id.viewpager);
        mTabLayout = itemView.findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    public static int getLayout() {
        return R.layout.carousel_view_holder;
    }

    @Override
    public void setData(BaseViewItem item) {
        mViewPager.setAdapter(new CarouselPagerAdapter(mViewPager.getContext(), item.getItems()));
    }
}
