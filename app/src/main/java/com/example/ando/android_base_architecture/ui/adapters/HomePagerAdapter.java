package com.example.ando.android_base_architecture.ui.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ando.android_base_architecture.common.Constants;
import com.example.ando.android_base_architecture.ui.Fragment_Recycler;

public class HomePagerAdapter extends FragmentStatePagerAdapter {

    private final int mCount;

    public HomePagerAdapter(FragmentManager fm, int count) {
        super(fm);
        mCount = count;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment_Recycler fragment_recycler = new Fragment_Recycler();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.FRAGMENT_TYPE, getFragmentType(i));
        fragment_recycler.setArguments(bundle);
        return fragment_recycler;
    }

    private int getFragmentType(int i) {
        int type;
        switch (i) {
            case 0:
                type = Constants.HOME_PAGE;
                break;
            case 1:
                type = Constants.TV_SHOW_PAGE;
                break;
            case 2:
                type = Constants.LIVE_PAGE;
                break;

            default:
                type = -1;
                break;
        }
        return type;
    }

    @Override
    public int getCount() {
        return mCount;
    }
}
