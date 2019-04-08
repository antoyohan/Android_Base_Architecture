package com.example.ando.android_base_architecture.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ando.android_base_architecture.ui.Fragment_Recycler;

public class HomePagerAdapter extends FragmentStatePagerAdapter {

    private final int mCount;

    public HomePagerAdapter(FragmentManager fm, int count) {
        super(fm);
        mCount = count;
    }

    @Override
    public Fragment getItem(int i) {
        return new Fragment_Recycler();
    }

    @Override
    public int getCount() {
        return mCount;
    }
}
