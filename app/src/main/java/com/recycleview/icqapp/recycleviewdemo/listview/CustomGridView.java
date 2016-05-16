package com.recycleview.icqapp.recycleviewdemo.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * 嵌套在ListView里面的GridView
 * @author icqapp 2016-5-15
 * @Email 508181017@qq.com
 */
public class CustomGridView extends GridView {
	public CustomGridView(Context context) {
		super(context);

	}

	public CustomGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		if (ev.getAction() == MotionEvent.ACTION_MOVE) {
			return true; // 禁止GridView滑动
		}
		return super.dispatchTouchEvent(ev);
	}
}
