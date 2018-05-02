package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AttractionTypeAdapter extends FragmentPagerAdapter {

    private Activity activity;
    private String tabTitles[];

    AttractionTypeAdapter(FragmentManager fm, Activity context) {
        super(fm);
        this.activity = context;
        this.tabTitles = activity.getResources().getStringArray(R.array.tabs);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BridgesFragment();
            case 1:
                return new ViewpointsFragment();
            case 2:
                return new MuseumsFragment();
            case 3:
                return new OtherFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
