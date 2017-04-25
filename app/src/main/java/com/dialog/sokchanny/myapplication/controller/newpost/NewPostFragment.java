package com.dialog.sokchanny.myapplication.controller.newpost;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dialog.sokchanny.myapplication.R;
import com.dialog.sokchanny.myapplication.model.House;
import com.dialog.sokchanny.myapplication.utilities.Shared;


public class NewPostFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static NewPostFragment newInstance() {
        if (Shared.newPostFragment == null) {
            Shared.newPostFragment = new NewPostFragment();
        }
        return Shared.newPostFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_post, container, false);

        int[] imgs = {
                R.drawable.room1, R.drawable.room2, R.drawable.room3, R.drawable.room4, R.drawable.room6,
        };
        House data[] = {
                new House(990,900,"ABC building, Suprime supermarket.", " Aleloya Phnom Penh", imgs),
                new House(991,12500,"RAFILE building, Suprime supermarket.","Orchroy Orng Keb Phnom Penh", imgs),
                new House(992,1000,"RUPP BUILE building, Suprime supermarket.","Battambang Phnom Penh", imgs),
                new House(993,1200,"Z4  building, Suprime supermarket.","Phnom Penh , Pailin , Posat", imgs),
                new House(993,200,"A4  building, Suprime supermarket.","Phnom Penh", imgs),
                new House(993,1700,"67894  building, Suprime supermarket.","Phnom Penh", imgs),
                new House(993,1100,"hello dadf  building, Suprime supermarket.","Cambodia, Oliko lak smi, Phnom Penh", imgs)
        };

        mRecyclerView = (RecyclerView) view.findViewById(R.id.house_rcv_new_post);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new NewPostAdapter(data);
        mLayoutManager = new LinearLayoutManager(Shared.homeActivity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.print("on attach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.print("on detach");
    }

}
