package com.recycleview.icqapp.recycleviewdemo.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.recycleview.icqapp.recycleviewdemo.R;
import com.recycleview.icqapp.recycleviewdemo.adapter.recycleview.RecyclerViewAdapter;
import com.recycleview.icqapp.recycleviewdemo.bean.Goods;
import com.recycleview.icqapp.recycleviewdemo.utils.ReadLocationJson;

import java.util.ArrayList;
import java.util.List;

/**
 * RecycleViewDemo
 */
public class SwitchRecycleViewActivity extends FragmentActivity {

    private Context mContext;

    private MaterialRefreshLayout materialRefreshLayout;
    private RecyclerView mRecyclerView;

    private List<Goods> mGoodsesData=new ArrayList<>();
    private RecyclerViewAdapter mRecyclerViewAdapter;

    private Button mBtnSwith;

    private boolean isGrid=true; //判断是否是网格




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        mContext=this;

        initView();

        initData();
    }

    private void initView() {
        mBtnSwith= (Button) findViewById(R.id.btn_swith);
        materialRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.mrl_rvdata);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));//用线性显示 类似于listview
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));//线性宫格显示 类似于grid view
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//线性宫格显示 类似于瀑布流
        mRecyclerViewAdapter = new RecyclerViewAdapter(this,mGoodsesData);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mBtnSwith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  //切换浏览模式listview和gridview
//                if (isGrid){
//                    mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
//                    isGrid=true;
//                    System.out.println("设置网格了?");
//                }else{
//                    mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//                    isGrid=false;
//                    System.out.println("没有");
//                }
                //设置有bug,有哪位设置好了请告诉我,谢谢
                if (mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
                    mRecyclerView.requestLayout();
                    mRecyclerView.invalidate();
                    Toast.makeText(mContext,"请到这地址看详情:https://github.com/xushaojie/SwitchListGrid",Toast.LENGTH_LONG).show();
                    //https://github.com/xushaojie/SwitchListGrid
                } else {
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                    System.out.println("设置线性布局");
                }

                mRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
        mBtnSwith.setVisibility(View.VISIBLE);
        stopRefresh();
    }

    private void initData() {//模拟网络请求
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {

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
                            mRecyclerViewAdapter.notifyDataSetChanged();
                        }
                        stopRefresh();
                    }
                }, 500);

            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                //page++;//翻页
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String jsonStr = ReadLocationJson.getJson(mContext, "goods.json");
                        List<Goods> goodsList = new ArrayList<Goods>();
                        goodsList = new Gson().fromJson(jsonStr, new TypeToken<List<Goods>>() {
                        }.getType());
                        if (!goodsList.isEmpty()) {
                            mGoodsesData.addAll(goodsList);
                            mRecyclerViewAdapter.notifyDataSetChanged();
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
