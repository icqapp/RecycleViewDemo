package com.recycleview.icqapp.recycleviewdemo.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.recycleview.icqapp.recycleviewdemo.R;
import com.recycleview.icqapp.recycleviewdemo.adapter.groupadapter.ViewPagerAdapter;
import com.recycleview.icqapp.recycleviewdemo.adapter.recycleview.DividerItemDecoration;
import com.recycleview.icqapp.recycleviewdemo.adapter.recycleview.MultiTypeItemAdapter;
import com.recycleview.icqapp.recycleviewdemo.adapter.superadapter.SimpleMulItemViewType;
import com.recycleview.icqapp.recycleviewdemo.bean.Article;
import com.recycleview.icqapp.recycleviewdemo.bean.Beauty;
import com.recycleview.icqapp.recycleviewdemo.utils.ReadLocationJson;

import java.util.ArrayList;
import java.util.List;

/**
 * 多个item的recycleview
 * Created by icqapp on 2016/5/16
 * Email:508181017@qq.com
 */
public class MultiTypeRecycleViewActivity extends FragmentActivity {

    private Context mContext;

    private MaterialRefreshLayout materialRefreshLayout;
    private RecyclerView mRecyclerView;

    private List<Beauty> mBeautysData=new ArrayList<>();
    private MultiTypeItemAdapter mMultiTypeItemAdapter;

    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private List<Article> mHeaderDatas = new ArrayList<>();
    private View headerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        mContext=this;
        initHeader();
        initView();

        initData();
    }

    private void initView() {
        materialRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.mrl_rvdata);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));//用线性显示 类似于listview
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));//线性宫格显示 类似于grid view
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//线性宫格显示 类似于瀑布流
        int color = Resources.getSystem().getColor(android.R.color.holo_red_dark);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));//设置分割线

        mBeautysData = getBeautysData();
        mMultiTypeItemAdapter = new MultiTypeItemAdapter(this, mBeautysData, new SimpleMulItemViewType<Beauty>() {
            @Override
            public int getItemViewType(int position, Beauty beauty) {
                return beauty.getType();
            }

            @Override
            public int getLayoutId(int viewType) {
                if (viewType == 1) {
                    return R.layout.item_list_left;
                }else if (viewType == 2){
                    return R.layout.item_list_right;
                }else {  //可以自己扩展其他布局模板
                    return R.layout.item_list_right;
                }
            }
        });
        mRecyclerView.setAdapter(mMultiTypeItemAdapter);

        if (!mMultiTypeItemAdapter.hasHeaderView()){
            mMultiTypeItemAdapter.addHeaderView(headerView);
            mRecyclerView.scrollToPosition(0); //预防不在第一位
        }

        stopRefresh();
    }

    private void initHeader(){
        headerView = LayoutInflater.from(mContext).inflate(R.layout.layout_header,null);
        mViewPager = (ViewPager)headerView.findViewById(R.id.vp_recycleviewheader);
        mHeaderDatas.addAll(addViewPagerListViewData("article.json"));
        mViewPagerAdapter = new ViewPagerAdapter(mContext,mHeaderDatas);
        mViewPager.setAdapter(mViewPagerAdapter);
    }

    private void initData() {//模拟网络请求
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {

                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<Beauty> beautysList = getBeautysData();
                        mBeautysData.clear();
                        if (!beautysList.isEmpty()) {
                            mBeautysData.addAll(beautysList);
                            mMultiTypeItemAdapter.clear();
                            mMultiTypeItemAdapter.addAll(beautysList);//记住这里和原生的有所区别,直接操作自定义的adapter
                            mMultiTypeItemAdapter.notifyDataSetChanged();
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
                        List<Beauty> beautysList = getBeautysData();
                        if (!beautysList.isEmpty()) {
                            mBeautysData.addAll(beautysList);
                            mMultiTypeItemAdapter.addAll(beautysList);//记住这里和原生的有所区别,直接操作自定义的adapter
                            mMultiTypeItemAdapter.notifyDataSetChanged();

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

    private List<Beauty> getBeautysData(){
        String jsonStr = ReadLocationJson.getJson(mContext, "multitype.json");
        List<Beauty> beautysList = Beauty.arrayBeautyFromData(jsonStr);
        return beautysList;
    }

    private List<Article> addViewPagerListViewData(String jsonFile){
        String jsonStr = ReadLocationJson.getJson(mContext, jsonFile);
        List<Article> articles = new ArrayList<Article>();
        articles = new Gson().fromJson(jsonStr, new TypeToken<List<Article>>() {
        }.getType());
        if (!articles.isEmpty()) {
            return articles;
        }
        return null;
    }

}
