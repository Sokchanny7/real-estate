package com.dialog.sokchanny.myapplication.controller.newpost;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dialog.sokchanny.myapplication.R;
import com.dialog.sokchanny.myapplication.controller.detail.HouseDetailActivity;
import com.dialog.sokchanny.myapplication.model.House;
import com.dialog.sokchanny.myapplication.utilities.Shared;

import java.util.Random;


/**
 * Created by sokchanny on 3/28/17.
 */

public class NewPostAdapter extends RecyclerView.Adapter<NewPostAdapter.ViewHolder> {

    private House[] posts;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView     txtInfo, txtPrice, txtLocation;
        public ImageView    imgHouse1, imgHouse2;
        public ViewHolder(View v) {
            super(v);
            imgHouse1       = (ImageView) v.findViewById(R.id.image_house_1);
            imgHouse2       = (ImageView) v.findViewById(R.id.image_house_2);
            txtInfo         = (TextView) v.findViewById(R.id.info_text);
            txtPrice        = (TextView) v.findViewById(R.id.price_text);
            txtLocation     = (TextView) v.findViewById(R.id.location_post);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("post_click", "Try to handle click" );
                    Intent intent = new Intent(Shared.homeActivity, HouseDetailActivity.class);
                    Shared.homeActivity.startActivity(intent);
                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }

    public NewPostAdapter(House[] posts) {
        this.posts = posts;
    }

    @Override
    public NewPostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        NewPostAdapter.ViewHolder vh = new NewPostAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(NewPostAdapter.ViewHolder holder, int position) {
        holder.txtInfo.setText("ID :" + posts[position].getId());
        holder.txtPrice.setText(posts[position].getPrice() + " $");
        holder.txtLocation.setText(posts[position].getLocation());
        int random = new Random().nextInt((posts[position].getImages().length));
        Glide
                .with(Shared.homeActivity.getApplicationContext())
                .load(posts[position].getImages()[random])
                .into(holder.imgHouse1);

        random = new Random().nextInt((posts[position].getImages().length));
        Glide
                .with(Shared.homeActivity.getApplicationContext())
                .load(posts[position].getImages()[random])
                .into(holder.imgHouse2);
    }

    @Override
    public int getItemCount() {
        return posts.length;
    }
}