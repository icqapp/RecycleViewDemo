package com.recycleview.icqapp.recycleviewdemo.adapter.recycleview;

import android.content.Context;
import android.net.Uri;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.recycleview.icqapp.recycleviewdemo.R;
import com.recycleview.icqapp.recycleviewdemo.adapter.superadapter.IMulItemViewType;
import com.recycleview.icqapp.recycleviewdemo.adapter.superadapter.SuperAdapter;
import com.recycleview.icqapp.recycleviewdemo.adapter.superadapter.internal.SuperViewHolder;
import com.recycleview.icqapp.recycleviewdemo.bean.Goods;
import com.recycleview.icqapp.recycleviewdemo.bean.Products;

import java.util.List;

import butterknife.InjectView;

/**
 * Created by icqapp on 16/5/16.
 */
public class NestChildRecycleViewAdapter extends SuperAdapter<Products> {


    public NestChildRecycleViewAdapter(Context context, List<Products> items, int layoutResId) {
        super(context, items, layoutResId);
    }

    public NestChildRecycleViewAdapter(Context context, List<Products> items, IMulItemViewType<Products> mulItemViewType) {
        super(context, items, mulItemViewType);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, Products item) {

        holder.setImageUri(R.id.iv_goods_url, Uri.parse(item.getImgUrl()));
        holder.setText(R.id.tv_goodsname, item.getGoodsName());
        holder.setText(R.id.tv_current_price, item.getPrice()+"");
    }
}
