package com.recycleview.icqapp.recycleviewdemo.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.recycleview.icqapp.recycleviewdemo.R;
import com.recycleview.icqapp.recycleviewdemo.adapter.groupadapter.GroupListAdapter;
import com.recycleview.icqapp.recycleviewdemo.adapter.groupadapter.ListViewAdapter;
import com.recycleview.icqapp.recycleviewdemo.adapter.groupadapter.ViewPagerAdapter;
import com.recycleview.icqapp.recycleviewdemo.bean.Article;
import com.recycleview.icqapp.recycleviewdemo.bean.Goods;
import com.recycleview.icqapp.recycleviewdemo.listview.CustomGridView;
import com.recycleview.icqapp.recycleviewdemo.listview.CustomListView;
import com.recycleview.icqapp.recycleviewdemo.listview.CustomScrollView;
import com.recycleview.icqapp.recycleviewdemo.utils.ReadLocationJson;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 多嵌套
 *
 * @author icqapp 2016-5-15
 * @Email 508181017@qq.com
 */
public class IncludeViewGroupsActivity extends FragmentActivity {

    private Context mContext;

    @InjectView(R.id.vp_group)
    ViewPager vpGroup;
    @InjectView(R.id.clv_group)
    CustomListView clvGroup;
    @InjectView(R.id.cgv_group)
    CustomGridView cgvGroup;
    @InjectView(R.id.mrl_group)
    MaterialRefreshLayout mrlGroup;
    @InjectView(R.id.sv_contain)
    CustomScrollView sv_contain;

    List<Goods> gridviewGoodsList = new ArrayList<>();
    List<Article> viewpageArticleList = new ArrayList<>();
    List<Article> listviewArticleList = new ArrayList<>();

    private GroupListAdapter mGroupListAdapter;
    private ViewPagerAdapter mViewPagerAdapter;
    private ListViewAdapter mListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_includeviewgroup);
        ButterKnife.inject(this);
        this.mContext=this;
        mrlGroup.setLoadMore(true);
        stopRefresh();
        initData();
        clvGroup.setFocusable(false);
        vpGroup.setFocusable(false);
        mrlGroup.setFocusable(false);
        sv_contain.smoothScrollTo(0, 0);

    }

    private void stopRefresh(){
        // refresh complete
        mrlGroup.finishRefresh();
        // load more refresh complete
        mrlGroup.finishRefreshLoadMore();

    }

    private void initData() {
        mrlGroup.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {

                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<Goods> goodsList = addGridViewData("goods.json");
                        gridviewGoodsList.clear();
                        gridviewGoodsList.addAll(goodsList);
                        mGroupListAdapter.notifyDataSetChanged();
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
                        List<Goods> goodsList = addGridViewData("goods.json");
                        gridviewGoodsList.addAll(goodsList);
                        mGroupListAdapter.notifyDataSetChanged();
                        stopRefresh();

                    }
                }, 500);
            }
        });

        gridviewGoodsList.addAll(addGridViewData("goods.json"));
        mGroupListAdapter = new GroupListAdapter(this,R.layout.item_list,gridviewGoodsList);
        cgvGroup.setAdapter(mGroupListAdapter);

        viewpageArticleList.addAll(addViewPagerListViewData("article.json"));
        mViewPagerAdapter = new ViewPagerAdapter(mContext,viewpageArticleList);
        vpGroup.setAdapter(mViewPagerAdapter);

        listviewArticleList.addAll(addViewPagerListViewData("article.json"));
        mListViewAdapter = new ListViewAdapter(mContext,R.layout.item_listview,listviewArticleList);
        clvGroup.setAdapter(mListViewAdapter);


    }

    private List<Goods> addGridViewData(String jsonFile){
        String jsonStr = ReadLocationJson.getJson(mContext, jsonFile);
        List<Goods> goodsList = new ArrayList<Goods>();
        goodsList = new Gson().fromJson(jsonStr, new TypeToken<List<Goods>>() {
        }.getType());
        if (!goodsList.isEmpty()) {
            return goodsList;
        }
        return null;
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
