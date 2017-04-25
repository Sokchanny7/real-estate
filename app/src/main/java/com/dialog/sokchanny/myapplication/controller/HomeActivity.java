package com.dialog.sokchanny.myapplication.controller;

import android.content.Context;
import android.content.res.Configuration;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.dialog.sokchanny.myapplication.R;
import com.dialog.sokchanny.myapplication.controller.favorite.FavoriteFragment;
import com.dialog.sokchanny.myapplication.controller.more.MoreFragment;
import com.dialog.sokchanny.myapplication.controller.nearbypost.NearByFragment;
import com.dialog.sokchanny.myapplication.controller.newpost.NewPostFragment;
import com.dialog.sokchanny.myapplication.utilities.Shared;

import info.hoang8f.android.segmented.SegmentedGroup;

public class HomeActivity extends AppCompatActivity {

    PagerAdapter    adapterViewPager;
    ImageView       seachImage;
    EditText        seachText;
    SegmentedGroup  filterButtonGroup;
    TabLayout       tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        seachImage          =(ImageView)        findViewById(R.id.search_post_img);
        seachText           =(EditText)         findViewById(R.id.search_post_text);
        filterButtonGroup   =(SegmentedGroup)   findViewById(R.id.segment_filter_post);

        Shared.homeActivity = this;

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new PagerAdapter(getSupportFragmentManager());
        adapterViewPager.appendChild("New post" ,   NewPostFragment.newInstance());
        adapterViewPager.appendChild("Near by"  ,   NearByFragment.newInstance());
        adapterViewPager.appendChild("Favorite" ,   FavoriteFragment.newInstance());
        adapterViewPager.appendChild("More",        MoreFragment.newInstance());
        vpPager.setAdapter(adapterViewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(vpPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.latestpost);
        tabLayout.getTabAt(1).setIcon(R.drawable.map);
        tabLayout.getTabAt(2).setIcon(R.drawable.favorite);
        tabLayout.getTabAt(3).setIcon(R.drawable.more);



        this.seachImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSearchState()) {
                    //TODO search functionality
                    seachText.requestFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(seachText, InputMethodManager.SHOW_IMPLICIT);
                } else {

                }

//                filterButtonGroup.setVisibility(View.INVISIBLE);
//                seachText.setVisibility(View.VISIBLE);
//
//                RotateAnimation anim = new RotateAnimation(0f, 350f, 15f, 15f);
//                anim.setInterpolator(new LinearInterpolator());
//                anim.setRepeatCount(Animation.INFINITE);
//                anim.setDuration(700);
//
//                seachImage.startAnimation(anim);
//                seachImage.setAnimation(null);
            }
        });


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
            Log.d("Key", "hidden");
            tabLayout.setVisibility( View.GONE );
        }
        else if (newConfig.hardKeyboardHidden ==Configuration.HARDKEYBOARDHIDDEN_YES) {
            Log.d("Key", "shown");
            tabLayout.setVisibility( View.VISIBLE );
        }
    }
    public boolean checkSearchState() {
        if ( this.filterButtonGroup.getVisibility() == View.VISIBLE) {
            this.filterButtonGroup.setVisibility(View.INVISIBLE);
            this.seachText.setVisibility(View.VISIBLE);
            tabLayout.setVisibility(View.GONE);
            return true;
        }
        return false;
    }

    public void prepareView() {
        if (filterButtonGroup.getVisibility() == View.INVISIBLE) {
            filterButtonGroup.setVisibility(View.VISIBLE);
            seachText.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Log.d("back", "try back");
            if (seachText.getVisibility() == View.VISIBLE) {
                seachText.setVisibility(View.INVISIBLE);
                filterButtonGroup.setVisibility(View.VISIBLE);
                tabLayout.setVisibility(View.VISIBLE);
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }

        return super.onKeyDown(keyCode, event);
    }
}
