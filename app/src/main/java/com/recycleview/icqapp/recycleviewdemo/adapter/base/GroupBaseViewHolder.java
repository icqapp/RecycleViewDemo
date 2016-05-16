package com.recycleview.icqapp.recycleviewdemo.adapter.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 封装的ViewHolder
 * Created by Administrator on 2016/3/6 0006.
 * Email:508181017@qq.com
 */
public class GroupBaseViewHolder {
    private SparseArray<View> viewList; //View的集合
    private int position; //位置
    private View convertView;//导入的布局
    private Context context;//上下文
    private int layoutId;//布局ID

    /**
     * GroupBaseViewHolder 构造函数
     * @param context 上下文
     * @param parent ViewGroup
     * @param layoutId 布局ID
     * @param position index
     */
    private GroupBaseViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.context = context;
        this.layoutId = layoutId;
        this.position = position;

        this.viewList = new SparseArray<View>();

        convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        convertView.setTag(this);
    }

    /**
     * 获取GroupBaseViewHolder的实力
     * @param context 上下文
     * @param convertView 导入的布局View
     * @param parent ViewGroup
     * @param layoutId 布局ID
     * @param position index
     * @return GroupBaseViewHolder
     */
    public static GroupBaseViewHolder getInstance(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (null == convertView) {
            return new GroupBaseViewHolder(context, parent, layoutId, position);
        } else {
            GroupBaseViewHolder GroupBaseViewHolder = (GroupBaseViewHolder) convertView.getTag();
            GroupBaseViewHolder.position = position;
            return GroupBaseViewHolder;
        }
    }

    /**
     * 获取布局View
     * @param ViewId view的ID
     * @param <T>
     * @return T , T extends View
     */
    public <T extends View> T getView(int ViewId) {
        View view = viewList.get(ViewId);
        if (null == view) {
            view = convertView.findViewById(ViewId);
            viewList.put(ViewId, view);
        }
        return (T) view;
    }

    /**
     * 返回convertView
     * @return View
     */
    public View getConvertView() {
        return convertView;
    }

    /**
     * 设置TextView文本
     * @param viewId TextView的ID
     * @param text 显示文本
     * @return
     */
    public GroupBaseViewHolder setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    public GroupBaseViewHolder setImageResource(int viewId, int imageId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(imageId);
        return this;
    }

    public GroupBaseViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView imageView = getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public GroupBaseViewHolder setBackgroundColor(int viewId, int color) {
        ImageView imageView = getView(viewId);
        imageView.setBackgroundColor(color);
        return this;
    }

    public GroupBaseViewHolder setImageUri(int viewId, Uri uri) {
        ImageView imageView = getView(viewId);
        imageView.setImageURI(uri);
        return this;
    }
    public GroupBaseViewHolder setSimpleDraweeViewImageUri(int viewId, Uri uri) {
        SimpleDraweeView imageView = getView(viewId);
        imageView.setImageURI(uri);
        return this;
    }

    public GroupBaseViewHolder setImage(int viewId, String showUrl,String samllPicUrl,String bigPicUrl) {
        SimpleDraweeView draweeView = getView(viewId);
        boolean isCacheInDisk = Fresco.getImagePipelineFactory().getMainDiskStorageCache().hasKey(new SimpleCacheKey(showUrl));

        draweeView.setImageURI(Uri.parse(showUrl));
//        if (isCacheInDisk){
////            Fresco.existsInDiskCache(Uri.parse(showUrl));
//            //and Fresco.existsInMemoryCache(Uri uri)
//
//
//            FileBinaryResource resource = (FileBinaryResource)Fresco.getImagePipelineFactory().getMainDiskStorageCache().getResource(new SimpleCacheKey(showUrl));
//            File file = resource.getFile();
//            String filePath=file.getPath();
////            System.out.println("图片路径为：" + filePath + "，名称为：" + file.getName());
//            //draweeView.setImageURI(Uri.parse(filePath));
//            StringBuilder path = new StringBuilder("file://");
//            path.append(Environment.getExternalStorageDirectory());
//            path.append("/");
//            String fileName = file.getName();
//            path.append(fileName);
//            System.out.println("最终路径为：" + path.toString());
//            draweeView.setImageURI(Uri.parse(path.toString()));
//        }else{
//            draweeView.setImageURI(Uri.parse(showUrl));
//        }

        return this;
    }

    public GroupBaseViewHolder setBackgroundColor(int viewId, Drawable drawable) {
        ImageView imageView = getView(viewId);
        imageView.setBackground(drawable);
        return this;
    }

}
