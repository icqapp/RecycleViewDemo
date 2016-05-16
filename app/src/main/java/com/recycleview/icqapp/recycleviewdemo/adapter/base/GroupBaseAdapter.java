package com.recycleview.icqapp.recycleviewdemo.adapter.base;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * listview，gridview等adapter基类
 * Created by icqapp on 2016/3/6 0006.
 * Email:508181017@qq.com
 */
public abstract class GroupBaseAdapter<T> extends BaseAdapter {
    public static final String TAG = "GroupBaseAdapter";//类标识
    protected List<T> list;//数据列表
    protected Context context;//上下文
    protected LayoutInflater layoutInflater;//布局填充器
    protected int layoutId;//布局Id
    protected Handler handler;//Activity的Handler

    /**
     * WhiteAdapter的构造函数，在这里初始化各项属性值
     * @param context  上下文
     * @param layoutId 布局Id
     * @param list     数据列表
     */
    public GroupBaseAdapter(Context context, int layoutId, List<T> list) {
        this.context = context;
        this.layoutId = layoutId;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);//获取布局填充器实例
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    public void setData(List<T> list) {
        this.list = list;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //复用ViewHolder
        GroupBaseViewHolder baseViewHolder = GroupBaseViewHolder.getInstance(context, convertView, parent, layoutId, position);
        //用于实现数据设置的开放方法
        initialize(baseViewHolder, getItem(position), position);

        //返回View
        return baseViewHolder.getConvertView();
    }
    //数据设置的抽象方法
    public abstract void initialize(GroupBaseViewHolder holder, T item, int position);

    //设置Handler的方法
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
