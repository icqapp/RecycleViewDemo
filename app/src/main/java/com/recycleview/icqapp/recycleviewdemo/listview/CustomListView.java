package com.recycleview.icqapp.recycleviewdemo.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 可以的嵌套的ListView
 * @author icqapp 2016-5-15
 * @Email 508181017@qq.com
 */
public class CustomListView extends ListView{

    public CustomListView(Context context) {
        super(context);
    }

    public CustomListView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public CustomListView(Context context, AttributeSet attrs,int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
