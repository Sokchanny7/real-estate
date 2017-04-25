package com.dialog.sokchanny.myapplication.controller.more;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.dialog.sokchanny.myapplication.R;
import com.dialog.sokchanny.myapplication.controller.account.AccountActivity;
import com.dialog.sokchanny.myapplication.utilities.Shared;

public class MoreFragment extends Fragment {

    private RelativeLayout accountLayout;

    public static MoreFragment newInstance() {
        if (Shared.moreFragment == null) {
            Shared.moreFragment = new MoreFragment();
        }
        return Shared.moreFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_more, container, false);

        accountLayout =(RelativeLayout) v.findViewById(R.id.m_account_layout);
        accountLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shared.homeActivity, AccountActivity.class);
                Shared.homeActivity.startActivity(intent);
            }
        });
        return v;
    }

}
