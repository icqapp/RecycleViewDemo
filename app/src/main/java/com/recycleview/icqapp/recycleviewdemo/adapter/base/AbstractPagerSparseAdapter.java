package com.recycleview.icqapp.recycleviewdemo.adapter.base;

import android.util.SparseArray;
import android.view.View;

/**
 * 抽象的PagerAdapter实现类,封装了内容为View,数据为SparseArray类型的适配器实现.
 * Created by icqapp on 2016/3/6
 * Email:508181017@qq.com
 */
public abstract class AbstractPagerSparseAdapter<T> extends AbstractViewPagerAdapter {
    protected SparseArray<T> mData;

    public AbstractPagerSparseAdapter(SparseArray<T> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    public abstract View newView(int position);

    public T getItem(int position) {
        return mData.valueAt(position);
    }
}
