package com.youku.live.livesdk.widgets.container.pagable;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RestrictedRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long DEFAULT_SCROLL_DELAYED = 500;
    private static final String LOG_TAG = "PagableRecyclerView";
    private Runnable mEnableScrollRunnable;
    private boolean mEnableScrolling;
    private Handler mHandler;
    private float mInitedScrollX;
    private float mInitedScrollY;
    private RecyclerView.OnScrollListener mInnerScrollListener;
    private long mScrollDelayed;
    private boolean mSliding;
    private float mTouchDownX;
    private float mTouchDownY;

    public RestrictedRecyclerView(Context context) {
        this(context, null);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View findChildViewUnder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285945571")) {
            return ((Boolean) ipChange.ipc$dispatch("-285945571", new Object[]{this, motionEvent})).booleanValue();
        }
        if (this.mEnableScrolling || (findChildViewUnder = findChildViewUnder(motionEvent.getX(), motionEvent.getY())) == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return findChildViewUnder.dispatchTouchEvent(motionEvent);
    }

    public void enableScrolling(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511469291")) {
            ipChange.ipc$dispatch("-511469291", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mEnableScrolling = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-782097268")) {
            return ((Boolean) ipChange.ipc$dispatch("-782097268", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mTouchDownX = motionEvent.getX();
            this.mTouchDownY = motionEvent.getY();
        } else if (action == 1) {
            this.mSliding = false;
        } else if (action == 2) {
            if (Math.abs(motionEvent.getX() - this.mTouchDownX) > Math.abs(motionEvent.getY() - this.mTouchDownY) || this.mSliding) {
                this.mSliding = true;
                return false;
            }
        }
        if (!this.mEnableScrolling || !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "846039832")) {
            return this.mEnableScrolling && super.onTouchEvent(motionEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("846039832", new Object[]{this, motionEvent})).booleanValue();
    }

    public RestrictedRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RestrictedRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTouchDownX = 0.0f;
        this.mTouchDownY = 0.0f;
        this.mSliding = false;
        this.mInitedScrollX = 0.0f;
        this.mInitedScrollY = 0.0f;
        this.mEnableScrolling = false;
        this.mScrollDelayed = 500;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mEnableScrollRunnable = new Runnable() {
            /* class com.youku.live.livesdk.widgets.container.pagable.RestrictedRecyclerView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1885122617")) {
                    ipChange.ipc$dispatch("1885122617", new Object[]{this});
                    return;
                }
                RestrictedRecyclerView.this.enableScrolling(true);
            }
        };
        AnonymousClass2 r4 = new RecyclerView.OnScrollListener() {
            /* class com.youku.live.livesdk.widgets.container.pagable.RestrictedRecyclerView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1570839396")) {
                    ipChange.ipc$dispatch("1570839396", new Object[]{this, recyclerView, Integer.valueOf(i)});
                } else if (i == 0) {
                    RestrictedRecyclerView.this.mInitedScrollX = 0.0f;
                    RestrictedRecyclerView.this.mInitedScrollY = 0.0f;
                    RestrictedRecyclerView.this.mHandler.postDelayed(RestrictedRecyclerView.this.mEnableScrollRunnable, RestrictedRecyclerView.this.mScrollDelayed);
                } else if (i == 2) {
                    RestrictedRecyclerView.this.enableScrolling(false);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "948747323")) {
                    ipChange.ipc$dispatch("948747323", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                RestrictedRecyclerView.this.mInitedScrollX += (float) i;
                RestrictedRecyclerView.this.mInitedScrollY += (float) i2;
            }
        };
        this.mInnerScrollListener = r4;
        addOnScrollListener(r4);
        this.mScrollDelayed = 500;
    }
}
