package com.youku.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;
import androidx.viewpager.widget.ViewPager;
import com.youku.utils.YoukuUIUtil;

/* compiled from: Taobao */
public class StackGallery extends Gallery {
    private static final int MSG_STACKGALLERY_MOVE = 1;
    private static final int MSG_STACKGALLERY_REQUESTLAYOUT = 2;
    private static final long TIME_STACKGALLERY_MOVE = 5000;
    private String TAG = getClass().getSimpleName();
    private boolean isNeedRefresh = true;
    private Handler mHandler = new Handler() {
        /* class com.youku.widget.StackGallery.AnonymousClass1 */

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                StackGallery.this.scrollToRight();
            } else if (i == 2 && YoukuUIUtil.viewSize(StackGallery.this) == 1.0d) {
                StackGallery.this.requestLayout();
            }
        }
    };
    private MotionEvent mMotionEvent;
    private ViewPager mViewPager = null;

    public StackGallery(Context context) {
        super(context);
        setSoundEffectsEnabled(false);
    }

    private int isScrollingLeft(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent == null || motionEvent2 == null) {
            return -1;
        }
        return motionEvent2.getX() > motionEvent.getX() ? 0 : 1;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void endMove() {
        this.mHandler.removeMessages(1);
    }

    public boolean isNeedRefresh() {
        return this.isNeedRefresh;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        endMove();
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int isScrollingLeft = isScrollingLeft(motionEvent, motionEvent2);
        if (isScrollingLeft == 0) {
            scrollToLeft();
            return false;
        } else if (isScrollingLeft != 1) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        } else {
            scrollToRight();
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.mMotionEvent = MotionEvent.obtain(motionEvent);
            super.onTouchEvent(motionEvent);
            return onInterceptTouchEvent;
        } else if (motionEvent.getAction() != 2) {
            return onInterceptTouchEvent;
        } else {
            if (Math.abs(motionEvent.getX() - this.mMotionEvent.getX()) > 20.0f || Math.abs(motionEvent.getY() - this.mMotionEvent.getY()) > 20.0f) {
                return true;
            }
            return onInterceptTouchEvent;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (this.mViewPager != null && motionEvent.getAction() == 0) {
                this.mViewPager.requestDisallowInterceptTouchEvent(true);
            }
            endMove();
        } else if (action == 1) {
            startMove();
        } else if (action == 3) {
            startMove();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.isNeedRefresh = true;
            startMove();
            return;
        }
        endMove();
    }

    public void scrollToLeft() {
        endMove();
        onScroll(null, null, -1.0f, 0.0f);
        super.onKeyDown(21, null);
        startMove();
    }

    public void scrollToRight() {
        endMove();
        if (getGlobalVisibleRect(new Rect())) {
            onScroll(null, null, 1.0f, 0.0f);
            onKeyDown(22, null);
            this.mHandler.sendEmptyMessageDelayed(2, 500);
        }
        startMove();
    }

    public void setNeedRefresh(boolean z) {
        this.isNeedRefresh = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
    }

    public void startMove() {
        endMove();
        this.mHandler.sendEmptyMessageDelayed(1, 5000);
    }

    public StackGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setSoundEffectsEnabled(false);
    }

    public StackGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
