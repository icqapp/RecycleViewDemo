package com.recycleview.icqapp.recycleviewdemo.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/3/6 0006.
 * Email:508181017@qq.com
 */
public abstract class GroupBasePagerHolder<T> extends AbstractAdapter<T> {
    public GroupBasePagerHolder(Context context, List<T> listData) {
        super(context, listData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Object holder = null;
        if (convertView == null) {
            convertView = buildConvertView(layoutInflater);
            holder = buildHolder(convertView);
            //AutoUtils.autoSize(convertView);
            convertView.setTag(holder);
        } else {
            holder = convertView.getTag();
        }
        bindViewData(holder, listData.get(position), position);

        return convertView;
    }

    /**
     * 建立convertView
     *
     * @param layoutInflater
     * @return
     */
    public abstract View buildConvertView(LayoutInflater layoutInflater);

    /**
     * 建立视图Holder
     *
     * @param convertView
     * @return
     */
    public abstract Object buildHolder(View convertView);

    /**
     * 绑定数据
     *
     * @param holder
     * @param t
     * @param position
     */
    public abstract void bindViewData(Object holder, T t, int position);
}
