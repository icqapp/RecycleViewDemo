package com.recycleview.icqapp.recycleviewdemo.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 抽象适配器（免去一些有共性的代码）
 * AbstractAdapter<T> 将父类比较有共性的方法重写，自定义适配器时，只要继承AbstractAdapter<T>，重写getView方法就可以了。
 * Created by Administrator on 2016/3/6 0006.
 * Email:508181017@qq.com
 */
public abstract class AbstractAdapter<T> extends BaseAdapter {

    protected Context context;

    protected List<T> listData;

    protected LayoutInflater layoutInflater;

    public AbstractAdapter(Context context, List<T> listData) {
        this.context = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (listData != null) {
            return listData.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (listData != null) {
            return listData.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<T> getListData() {
        return listData;
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }


}
