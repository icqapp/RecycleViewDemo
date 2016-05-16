package com.recycleview.icqapp.recycleviewdemo.adapter.groupadapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.recycleview.icqapp.recycleviewdemo.R;
import com.recycleview.icqapp.recycleviewdemo.adapter.base.AbstractPagerListAdapter;
import com.recycleview.icqapp.recycleviewdemo.bean.Article;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by icqapp on 16/5/15.
 */
public class ViewPagerAdapter extends AbstractPagerListAdapter<Article> {

    private Context mContext;
    private List<Article> mArticles = new ArrayList<>();

    public ViewPagerAdapter(List<Article> data) {
        super(data);
    }

    public ViewPagerAdapter(Context context, List<Article> data) {

        super(data);
        this.mContext=context;
        this.mArticles = data;
    }

    @Override
    public View newView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_viewpager, null);
        Article article = mArticles.get(position);
        SimpleDraweeView sdImg = (SimpleDraweeView)view.findViewById(R.id.sd_img);
        TextView tvTitle = (TextView)view.findViewById(R.id.tv_title);
        sdImg.setImageURI(Uri.parse(article.getImgUrl()));
        tvTitle.setText(article.getTitle());
        return view;
    }
}
