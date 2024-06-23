package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXTemplateEngine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class NestRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int firstVisibleItemPosition;
    private boolean isBottomToTop;
    private boolean isTopToBottom;
    private int lastVisibleItemPosition;
    private float mLastY;

    public NestRecyclerView(Context context) {
        this(context, null);
    }

    private void isIntercept(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-609528327")) {
            ipChange.ipc$dispatch("-609528327", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.isTopToBottom = false;
        this.isBottomToTop = false;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            this.firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        }
        int childCount = layoutManager.getChildCount();
        int itemCount = layoutManager.getItemCount();
        Log.d("nestScrolling", GXTemplateEngine.f.TYPE_ON_SCROLL_STATE_CHANGED);
        if (childCount <= 0) {
            return;
        }
        if (this.lastVisibleItemPosition == itemCount - 1) {
            Log.d("nestScrolling", "触底了");
            if (!canScrollVertically(-1) || f >= this.mLastY) {
                Log.d("nestScrolling", "向下滑动");
                return;
            }
            Log.d("nestScrolling", "不能向上滑动");
            this.isBottomToTop = true;
        } else if (this.firstVisibleItemPosition == 0) {
            Log.d("nestScrolling", "触顶了");
            if (!canScrollVertically(1) || f <= this.mLastY) {
                Log.d("nestScrolling", "向上滑动");
                return;
            }
            Log.d("nestScrolling", "不能向下滑动");
            this.isTopToBottom = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r0 != 3) goto L_0x0049;
     */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136193295")) {
            return ((Boolean) ipChange.ipc$dispatch("1136193295", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            this.mLastY = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public NestRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastY = 0.0f;
        this.isTopToBottom = false;
        this.isBottomToTop = false;
    }
}
