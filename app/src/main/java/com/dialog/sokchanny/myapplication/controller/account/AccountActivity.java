package com.dialog.sokchanny.myapplication.controller.account;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dialog.sokchanny.myapplication.R;

public class AccountActivity extends AppCompatActivity {

    TextView titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        titleBar =(TextView) findViewById(R.id.toolbar_title);
        titleBar.setText("Account");


    }
}
