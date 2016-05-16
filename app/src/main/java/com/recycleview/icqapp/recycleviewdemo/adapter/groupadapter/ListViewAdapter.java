package com.recycleview.icqapp.recycleviewdemo.adapter.groupadapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.recycleview.icqapp.recycleviewdemo.R;
import com.recycleview.icqapp.recycleviewdemo.adapter.base.GroupBaseAdapter;
import com.recycleview.icqapp.recycleviewdemo.adapter.base.GroupBaseViewHolder;
import com.recycleview.icqapp.recycleviewdemo.bean.Article;
import com.recycleview.icqapp.recycleviewdemo.bean.Goods;

import java.util.List;

/**
 * list adapter
 * Created by icqapp on 2016/5.
 * Email:508181017@qq.com
 */
public class ListViewAdapter extends GroupBaseAdapter {

    public ListViewAdapter(Context context, int layoutId, List datas) {
        super(context, layoutId, datas);
    }



    @Override
    public void initialize(GroupBaseViewHolder holder, Object item, int position) {
        Article article =(Article) item;

        holder.setImage(R.id.sd_img, article.getImgUrl() + "", "", "");
        holder.setText(R.id.tv_title, article.getTitle());
    }
}
