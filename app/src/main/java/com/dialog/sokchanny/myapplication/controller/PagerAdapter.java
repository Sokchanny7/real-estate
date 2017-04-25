package com.dialog.sokchanny.myapplication.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by sokchanny on 3/28/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    class PageItem {
        private String pageTitle;
        private Fragment fragment;

        public PageItem(String pageTitle, Fragment fragment) {
            this.pageTitle = pageTitle;
            this.fragment = fragment;
        }

        public String getPageTitle() {
            return pageTitle;
        }

        public Fragment getFragment() {
            return fragment;
        }
    }

    private ArrayList<PageItem> pageItems = new ArrayList<>();

    public void appendChild(String title, Fragment fragment) {
        this.pageItems.add(new PageItem(title,fragment));
    }

    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return pageItems.size();
    }

    @Override
    public Fragment getItem(int position) {
        return pageItems.get(position).fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageItems.get(position).pageTitle;
    }

}

