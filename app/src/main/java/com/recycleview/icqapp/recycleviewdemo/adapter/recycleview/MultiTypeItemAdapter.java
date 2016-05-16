package com.recycleview.icqapp.recycleviewdemo.adapter.recycleview;

import android.content.Context;
import android.net.Uri;

import com.recycleview.icqapp.recycleviewdemo.R;
import com.recycleview.icqapp.recycleviewdemo.adapter.superadapter.IMulItemViewType;
import com.recycleview.icqapp.recycleviewdemo.adapter.superadapter.SuperAdapter;
import com.recycleview.icqapp.recycleviewdemo.adapter.superadapter.internal.SuperViewHolder;
import com.recycleview.icqapp.recycleviewdemo.bean.Beauty;

import java.util.List;

/**
 * 多个布局item的recycleview adapter
 * @author icqapp 2016-5-16
 * @Email 508181017@qq.com
 */
public class MultiTypeItemAdapter extends SuperAdapter<Beauty>{
    public MultiTypeItemAdapter(Context context, List<Beauty> items, IMulItemViewType<Beauty> mulItemViewType) {
        super(context, items, mulItemViewType);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, Beauty item) {
        switch (viewType) { //布局不一定一样的
            case 1:
                holder.setText(R.id.tv_name, item.getName());
                holder.setText(R.id.tv_age, "我今年 "+item.getAge()+" 岁咯~");
                holder.setImageUri(R.id.sd_img, Uri.parse(item.getHead()));
                break;
            case 2:
                holder.setText(R.id.tv_name, item.getName());
                holder.setText(R.id.tv_age, "我今年 " + item.getAge() + " 岁咯~");
                holder.setImageUri(R.id.sd_img, Uri.parse(item.getHead()));
                break;
        }

    }

    @Override
    protected IMulItemViewType<Beauty> offerMultiItemViewType() {
        return new IMulItemViewType<Beauty>() {
            @Override
            public int getViewTypeCount() {
                return 2;  //多少个布局模板
            }

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
        };
    }


}
