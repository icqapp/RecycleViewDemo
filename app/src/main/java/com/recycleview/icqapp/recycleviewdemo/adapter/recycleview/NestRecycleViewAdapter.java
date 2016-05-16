package com.recycleview.icqapp.recycleviewdemo.adapter.recycleview;

import android.content.Context;

import com.recycleview.icqapp.recycleviewdemo.R;
import com.recycleview.icqapp.recycleviewdemo.adapter.superadapter.SuperAdapter;
import com.recycleview.icqapp.recycleviewdemo.adapter.superadapter.internal.SuperViewHolder;
import com.recycleview.icqapp.recycleviewdemo.bean.Order;
import com.recycleview.icqapp.recycleviewdemo.bean.Products;
import com.recycleview.icqapp.recycleviewdemo.recycleview.FullyLinearLayoutManager;

import java.util.List;

/**
 * Created by icqapp on 16/5/15.
 */
public class NestRecycleViewAdapter extends SuperAdapter<Order> {

    public NestRecycleViewAdapter(Context context, List<Order> items, int layoutResId) {
        super(context, items, layoutResId);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, Order item) {
        holder.setText(R.id.tv_shopname_group, item.getCompanyName());
        NestChildRecycleViewAdapter nestChildRecycleViewAdapter = new NestChildRecycleViewAdapter(mContext, item.getGoodses(), R.layout.item_elv_child_order);
        List<Products> goodsList = item.getGoodses();
        holder.setAdapter(R.id.rv_childdata, new FullyLinearLayoutManager(mContext), nestChildRecycleViewAdapter);

    }


}
