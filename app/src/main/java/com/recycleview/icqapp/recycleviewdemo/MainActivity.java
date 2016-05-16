package com.recycleview.icqapp.recycleviewdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.recycleview.icqapp.recycleviewdemo.ui.IncludeViewGroupsActivity;
import com.recycleview.icqapp.recycleviewdemo.ui.ListMainActivity;
import com.recycleview.icqapp.recycleviewdemo.ui.MultiTypeRecycleViewActivity;
import com.recycleview.icqapp.recycleviewdemo.ui.NestRecycleViewActivity;
import com.recycleview.icqapp.recycleviewdemo.ui.RecycleViewActivity;
import com.recycleview.icqapp.recycleviewdemo.ui.SwitchRecycleViewActivity;

/**
 * RecycleViewDemo
 */
public class MainActivity extends FragmentActivity {

    private Context mContext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mContext=this;
        findViewById(R.id.btn_listview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, ListMainActivity.class));
            }
        });

        findViewById(R.id.btn_recycleview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, RecycleViewActivity.class));
            }
        });
        findViewById(R.id.btn_includviewgroup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, IncludeViewGroupsActivity.class));
            }
        });

        findViewById(R.id.btn_nestrecycleview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, NestRecycleViewActivity.class));
            }
        });

        findViewById(R.id.btn_multitypeitem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MultiTypeRecycleViewActivity.class));
            }
        });

        findViewById(R.id.btn_swithview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, SwitchRecycleViewActivity.class));
            }
        });

    }

}
