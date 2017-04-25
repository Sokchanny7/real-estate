package com.dialog.sokchanny.myapplication.controller.favorite;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dialog.sokchanny.myapplication.R;
import com.dialog.sokchanny.myapplication.model.House;
import com.dialog.sokchanny.myapplication.utilities.Shared;

public class FavoriteFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static FavoriteFragment newInstance() {
        if (Shared.favoriteFragment == null) {
            Shared.favoriteFragment = new FavoriteFragment();
        }
        return Shared.favoriteFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        int[] imgs = {
                R.drawable.room1, R.drawable.room2, R.drawable.room3, R.drawable.room4
        };
        House data[] = {
                new House(990,900,"ABC building, Suprime supermarket.","Phnom Penh", imgs),
                new House(991,12500,"RAFILE building, Suprime supermarket.","Phnom Penh", imgs),
                new House(992,1000,"RUPP BUILE building, Suprime supermarket.","Phnom Penh", imgs),
                new House(993,1200,"Z4  building, Suprime supermarket.","Phnom Penh", imgs),
                new House(993,200,"A4  building, Suprime supermarket.","Phnom Penh", imgs),
                new House(993,1700,"67894  building, Suprime supermarket.","Phnom Penh", imgs),
                new House(993,1100,"hello dadf  building, Suprime supermarket.","Phnom Penh", imgs)
        };

        mRecyclerView = (RecyclerView) view.findViewById(R.id.house_rcv_favorite);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new FavoriteAdapter(data);
        mLayoutManager = new LinearLayoutManager(Shared.homeActivity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

}
