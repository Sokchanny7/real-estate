package com.dialog.sokchanny.myapplication.controller.detail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by sokchanny on 3/30/17.
 */

public class HouseDetailImagesAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> images = new ArrayList<>();

    public void appendChild(Fragment img) {
        this.images.add(img);
    }

    public HouseDetailImagesAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return this.images.size();
    }

    @Override
    public Fragment getItem(int position) {
        return this.images.get(position);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return "hello world";
    }

}

