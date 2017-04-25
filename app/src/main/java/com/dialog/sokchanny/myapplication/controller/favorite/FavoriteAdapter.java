package com.dialog.sokchanny.myapplication.controller.favorite;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dialog.sokchanny.myapplication.R;
import com.dialog.sokchanny.myapplication.model.House;
import com.dialog.sokchanny.myapplication.utilities.Shared;

import java.util.Random;

/**
 * Created by sokchanny on 3/28/17.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    private House[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView     txtInfo;
        public TextView     txtDescription;
        public TextView     txtLocation;
        public ImageView    imgHouse;
        public ViewHolder(View v) {
            super(v);
            imgHouse        = (ImageView) v.findViewById(R.id.image_house);
            txtInfo         = (TextView) v.findViewById(R.id.info_text);
            txtDescription  = (TextView) v.findViewById(R.id.decription_text);
            txtLocation     = (TextView) v.findViewById(R.id.location_text);

        }

        @Override
        public void onClick(View v) {
            System.out.print("ABC DE");
        }
    }

    public FavoriteAdapter(House[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtInfo.setText("ID :" + mDataset[position].getId() + " - " + mDataset[position].getPrice() + " $");
        holder.txtDescription.setText(mDataset[position].getDescription());
        holder.txtLocation.setText(mDataset[position].getLocation());
        int random = new Random().nextInt((mDataset[position].getImages().length));
        Glide
                .with(Shared.homeActivity.getApplicationContext())
                .load(mDataset[position].getImages()[random])
                .into(holder.imgHouse);

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}




