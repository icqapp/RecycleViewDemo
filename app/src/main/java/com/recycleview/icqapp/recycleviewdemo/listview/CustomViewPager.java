package com.recycleview.icqapp.recycleviewdemo.listview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 自定义ViewPager不能滑动
 * @author icqapp 2016-5-15
 * @Email 508181017@qq.com
 */
public class CustomViewPager extends ViewPager {
    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        // 返回false
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        // 返回false
        return false;
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }


    // 防止viewpager跟scrollview冲突
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        boolean ret = super.dispatchTouchEvent(ev);
        if(ret)
        {
            requestDisallowInterceptTouchEvent(true);
        }
        return ret;
    }


}
