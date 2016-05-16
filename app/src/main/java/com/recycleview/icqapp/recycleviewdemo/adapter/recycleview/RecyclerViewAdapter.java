package com.recycleview.icqapp.recycleviewdemo.adapter.recycleview;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.recycleview.icqapp.recycleviewdemo.R;
import com.recycleview.icqapp.recycleviewdemo.bean.Goods;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by icqapp on 16/5/15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private Context mContext;

    private List<Goods> mGoodses = new ArrayList<>();

    public RecyclerViewAdapter(Context context, List<Goods> goodsList) {
        this.mGoodses = goodsList;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(mLayoutInflater.inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Goods bean = (Goods) mGoodses.get(position);
        holder.sdImg.setImageURI(Uri.parse(bean.getImgServerPath() + bean.getProductImage()));
        holder.tvName.setText(bean.getTitle() + "");
        holder.tvPrice.setText("￥ " + bean.getTsPrice());
    }

    @Override
    public int getItemCount() {
        return mGoodses == null ? 0 : mGoodses.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.sd_img)
        SimpleDraweeView sdImg;
        @InjectView(R.id.tv_name)
        TextView tvName;
        @InjectView(R.id.tv_price)
        TextView tvPrice;

        RecyclerViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }

        @OnClick(R.id.sd_img)
        void onItemClick() {
            Toast.makeText(mContext, "onClick--> position = " + getPosition(), Toast.LENGTH_LONG).show();
            //Log.d("RecyclerViewHolder", "onClick--> position = " + getPosition());
        }
    }


}