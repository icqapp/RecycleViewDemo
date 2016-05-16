package com.recycleview.icqapp.recycleviewdemo.adapter.groupadapter;

import android.content.Context;


import com.recycleview.icqapp.recycleviewdemo.R;
import com.recycleview.icqapp.recycleviewdemo.adapter.base.*;
import com.recycleview.icqapp.recycleviewdemo.bean.Goods;

import java.util.List;

/**
 * list adapter
 * Created by icqapp on 2016/5.
 * Email:508181017@qq.com
 */
public class GroupListAdapter extends GroupBaseAdapter {

    public GroupListAdapter(Context context, int layoutId, List datas) {
        super(context, layoutId, datas);
    }



    @Override
    public void initialize(GroupBaseViewHolder
                                       holder, Object item, int position) {
        Goods bean = (Goods) item;

        holder.setImage(R.id.sd_img, bean.getImgServerPath()+bean.getProductImage() + "", "", "");
        holder.setText(R.id.tv_name, bean.getTitle()+"");
        holder.setText(R.id.tv_price,"￥ "+bean.getTsPrice());
    }
}
