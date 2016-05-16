package com.recycleview.icqapp.recycleviewdemo.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ListView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.recycleview.icqapp.recycleviewdemo.R;
import com.recycleview.icqapp.recycleviewdemo.adapter.groupadapter.GroupListAdapter;
import com.recycleview.icqapp.recycleviewdemo.bean.Goods;
import com.recycleview.icqapp.recycleviewdemo.utils.ReadLocationJson;

import java.util.ArrayList;
import java.util.List;

/**
 * ListViewDemo
 */
public class ListMainActivity extends FragmentActivity {

    private Context mContext;

    private MaterialRefreshLayout materialRefreshLayout;
    private ListView mLv_data;

    private List<Goods> mGoodsesData=new ArrayList<>();
    private GroupListAdapter mGroupListAdapter;

    private int page=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mContext=this;

        initView();

        initData();
    }

    private void initView() {
        materialRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.mrl_lvdata);
        mLv_data = (ListView) findViewById(R.id.lv_data);
        mGroupListAdapter = new GroupListAdapter(this,R.layout.item_list,mGoodsesData);
        mLv_data.setAdapter(mGroupListAdapter);
        stopRefresh();
    }

    private void initData() {//模拟网络请求
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                page = 1;

                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String jsonStr = ReadLocationJson.getJson(mContext, "goods.json");
                        List<Goods> goodsList = new ArrayList<Goods>();
                        goodsList = new Gson().fromJson(jsonStr, new TypeToken<List<Goods>>() {
                        }.getType());
                        mGoodsesData.clear();
                        if (!goodsList.isEmpty()) {
                            mGoodsesData.addAll(goodsList);
                            mGroupListAdapter.notifyDataSetChanged();
                        }
                        stopRefresh();
                    }
                }, 500);

            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                page++;//翻页
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String jsonStr = ReadLocationJson.getJson(mContext, "goods.json");
                        List<Goods> goodsList = new ArrayList<Goods>();
                        goodsList = new Gson().fromJson(jsonStr, new TypeToken<List<Goods>>() {
                        }.getType());
                        if (!goodsList.isEmpty()) {
                            mGoodsesData.addAll(goodsList);
                            mGroupListAdapter.notifyDataSetChanged();
                        }
                        stopRefresh();

                    }
                }, 500);


            }
        });

    }

    private void stopRefresh(){
        // refresh complete
        materialRefreshLayout.finishRefresh();
        // load more refresh complete
        materialRefreshLayout.finishRefreshLoadMore();

    }

}
