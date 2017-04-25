package com.dialog.sokchanny.myapplication.controller.detail;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dialog.sokchanny.myapplication.R;
import com.dialog.sokchanny.myapplication.model.CommentItem;
import com.dialog.sokchanny.myapplication.utilities.Shared;

/**
 * Created by sokchanny on 3/29/17.
 */

public class HouseDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private CommentItem[] mDataset;

    public static class DetailView extends RecyclerView.ViewHolder implements View.OnClickListener{

        public DetailView(View v) {
            super(v);
            HouseDetailImagesAdapter adapterImagePager = new HouseDetailImagesAdapter(Shared.houseDetailActivity.getSupportFragmentManager());
            ViewPager imgsPager = (ViewPager) v.findViewById(R.id.h_detail_imgs_pager);
            adapterImagePager.appendChild(HouseImagesFragment.newInstance());
            adapterImagePager.appendChild(HouseImagesFragment.newInstance());
            adapterImagePager.appendChild(HouseImagesFragment.newInstance());
            adapterImagePager.appendChild(HouseImagesFragment.newInstance());
            imgsPager.setAdapter(adapterImagePager);
        }
        @Override
        public void onClick(View v) {

        }

    }

    public static class CommentView extends RecyclerView.ViewHolder implements View.OnClickListener{

        public CommentView(View v) {
            super(v);
        }
        @Override
        public void onClick(View v) {

        }

    }

    public HouseDetailAdapter(CommentItem[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;//Shared.ItemType.HOUSE_DETAIL;
        } else {
            return 2;//Shared.ItemType.HOUSE_COMMENT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
            RecyclerView.ViewHolder vh = new HouseDetailAdapter.DetailView(view);
            return vh;
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
            RecyclerView.ViewHolder vh = new HouseDetailAdapter.CommentView(view);
            return vh;
        }

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
