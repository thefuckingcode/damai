package com.alient.onearch.adapter.component.horizontal;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;

/* compiled from: Taobao */
public class RecyclerViewHorizontalTouchManager {
    private static final String TAG = "RecyclerViewHorizontalTouchManager";
    private boolean mForceNoInterceptTouchEvent;
    private boolean mIsHorizontalDrag;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() {
        /* class com.alient.onearch.adapter.component.horizontal.RecyclerViewHorizontalTouchManager.AnonymousClass1 */

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop);
            }
            if (action == 0) {
                RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag = false;
                RecyclerViewHorizontalTouchManager.this.startY = motionEvent.getY();
                RecyclerViewHorizontalTouchManager.this.startX = motionEvent.getX();
            } else if (action == 1) {
                RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag = false;
            } else if ((action != 2 && action != 3) || RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag || RecyclerViewHorizontalTouchManager.this.mForceNoInterceptTouchEvent) {
                return false;
            } else {
                float y = motionEvent.getY();
                float x = motionEvent.getX();
                float abs = Math.abs(x - RecyclerViewHorizontalTouchManager.this.startX);
                float abs2 = Math.abs(y - RecyclerViewHorizontalTouchManager.this.startY);
                if (AppInfoProviderProxy.isDebuggable()) {
                    LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop + " startX：" + RecyclerViewHorizontalTouchManager.this.startX + " startY:" + RecyclerViewHorizontalTouchManager.this.startY + " endX：" + x + " endY:" + y + " distanceX:" + abs + " distanceY:" + abs2);
                }
                if (abs < ((float) RecyclerViewHorizontalTouchManager.this.mTouchSlop) && abs2 < ((float) RecyclerViewHorizontalTouchManager.this.mTouchSlop)) {
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop + " call v.requestDisallowInterceptTouchEvent(true)");
                    }
                    RecyclerViewHorizontalTouchManager recyclerViewHorizontalTouchManager = RecyclerViewHorizontalTouchManager.this;
                    RecyclerView listRecyclerView = recyclerViewHorizontalTouchManager.getListRecyclerView(recyclerViewHorizontalTouchManager.mRecyclerView.getParent());
                    if (listRecyclerView != null) {
                        listRecyclerView.requestDisallowInterceptTouchEvent(true);
                    }
                    return false;
                } else if (abs <= ((float) RecyclerViewHorizontalTouchManager.this.mTouchSlop) || abs <= abs2) {
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop + " call v.requestDisallowInterceptTouchEvent(false)");
                    }
                    RecyclerViewHorizontalTouchManager recyclerViewHorizontalTouchManager2 = RecyclerViewHorizontalTouchManager.this;
                    RecyclerView listRecyclerView2 = recyclerViewHorizontalTouchManager2.getListRecyclerView(recyclerViewHorizontalTouchManager2.mRecyclerView.getParent());
                    if (listRecyclerView2 != null) {
                        listRecyclerView2.requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop + " call v.requestDisallowInterceptTouchEvent(true)");
                    }
                    RecyclerViewHorizontalTouchManager recyclerViewHorizontalTouchManager3 = RecyclerViewHorizontalTouchManager.this;
                    RecyclerView listRecyclerView3 = recyclerViewHorizontalTouchManager3.getListRecyclerView(recyclerViewHorizontalTouchManager3.mRecyclerView.getParent());
                    if (listRecyclerView3 != null) {
                        RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag = true;
                        listRecyclerView3.requestDisallowInterceptTouchEvent(true);
                    }
                    return false;
                }
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    };
    private RecyclerView mRecyclerView;
    private int mTouchSlop = 0;
    private float startX = 0.0f;
    private float startY = 0.0f;

    private RecyclerViewHorizontalTouchManager() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private RecyclerView getListRecyclerView(ViewParent viewParent) {
        if (viewParent == null) {
            return null;
        }
        if (viewParent instanceof RecyclerView) {
            return (RecyclerView) viewParent;
        }
        return getListRecyclerView(viewParent.getParent());
    }

    public void delegateHorizontalTouch() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            if (this.mTouchSlop == 0) {
                this.mTouchSlop = ViewConfiguration.get(recyclerView.getContext()).getScaledTouchSlop();
            }
            this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        }
    }

    public void forceNoInterceptTouchEvent(boolean z) {
        this.mForceNoInterceptTouchEvent = z;
    }

    public RecyclerViewHorizontalTouchManager(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        if (recyclerView != null && recyclerView.getContext() != null) {
            this.mTouchSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        }
    }
}
