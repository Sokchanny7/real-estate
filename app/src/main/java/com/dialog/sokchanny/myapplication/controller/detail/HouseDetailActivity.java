package com.dialog.sokchanny.myapplication.controller.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dialog.sokchanny.myapplication.R;
import com.dialog.sokchanny.myapplication.model.CommentItem;
import com.dialog.sokchanny.myapplication.utilities.Shared;

public class HouseDetailActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_detail);

        Shared.houseDetailActivity = this;

        CommentItem[] commentItems = {
                new CommentItem(), new CommentItem(), new CommentItem(),
                new CommentItem(), new CommentItem(), new CommentItem(),
                new CommentItem(), new CommentItem(), new CommentItem(),
                new CommentItem(), new CommentItem(), new CommentItem()
            };


        mRecyclerView = (RecyclerView) findViewById(R.id.house_detail_rcv_comment);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new HouseDetailAdapter(commentItems);
        mLayoutManager = new LinearLayoutManager(Shared.homeActivity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
