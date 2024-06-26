package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.taobao.uikit.feature.view.TRecyclerView;

/* compiled from: Taobao */
public class YKRecyclerView extends TRecyclerView implements GestureDetector.OnGestureListener {
    private static String TAG = "HomePage.YKRecyclerView";

    public YKRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public YKRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public YKRecyclerView(Context context) {
        super(context);
    }
}
