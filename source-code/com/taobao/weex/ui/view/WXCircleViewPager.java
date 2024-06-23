package com.taobao.weex.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.viewpager.widget.ViewPager;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.reflect.Field;

@SuppressLint({"HandlerLeak"})
/* compiled from: Taobao */
public class WXCircleViewPager extends ViewPager implements WXGestureObservable {
    private final int SCROLL_TO_NEXT = 1;
    private long intervalTime = 3000;
    private boolean isAutoScroll;
    private Handler mAutoScrollHandler = new Handler(Looper.getMainLooper()) {
        /* class com.taobao.weex.ui.view.WXCircleViewPager.AnonymousClass1 */

        public void handleMessage(Message message) {
            if (message.what == 1) {
                WXLogUtils.d("[CircleViewPager] trigger auto play action");
                WXCircleViewPager.this.showNextItem();
                sendEmptyMessageDelayed(1, WXCircleViewPager.this.intervalTime);
                return;
            }
            super.handleMessage(message);
        }
    };
    private WXSmoothScroller mScroller;
    private int mState = 0;
    private boolean needLoop = true;
    private boolean scrollable = true;
    private WXGesture wxGesture;

    @SuppressLint({"NewApi"})
    public WXCircleViewPager(Context context) {
        super(context);
        init();
    }

    private void init() {
        setOverScrollMode(2);
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.taobao.weex.ui.view.WXCircleViewPager.AnonymousClass2 */

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                WXCircleViewPager.this.mState = i;
                WXCirclePageAdapter circlePageAdapter = WXCircleViewPager.this.getCirclePageAdapter();
                int currentItem = WXCircleViewPager.super.getCurrentItem();
                if (WXCircleViewPager.this.needLoop && i == 0 && circlePageAdapter.getCount() > 1) {
                    if (currentItem == circlePageAdapter.getCount() - 1) {
                        WXCircleViewPager.this.superSetCurrentItem(1, false);
                    } else if (currentItem == 0) {
                        WXCircleViewPager.this.superSetCurrentItem(circlePageAdapter.getCount() - 2, false);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }
        });
        postInitViewPager();
    }

    private void postInitViewPager() {
        if (!isInEditMode()) {
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                Field declaredField2 = ViewPager.class.getDeclaredField("sInterpolator");
                declaredField2.setAccessible(true);
                WXSmoothScroller wXSmoothScroller = new WXSmoothScroller(getContext(), (Interpolator) declaredField2.get(null));
                this.mScroller = wXSmoothScroller;
                declaredField.set(this, wXSmoothScroller);
            } catch (Exception e) {
                WXLogUtils.e("[CircleViewPager] postInitViewPager: ", e);
            }
        }
    }

    private void setRealCurrentItem(int i) {
        superSetCurrentItem(((WXCirclePageAdapter) getAdapter()).getFirst() + i, false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showNextItem() {
        if (getCirclePageAdapter() == null || !getCirclePageAdapter().isRTL) {
            if (!this.needLoop && superGetCurrentItem() == getRealCount() - 1) {
                return;
            }
            if (getRealCount() == 2 && superGetCurrentItem() == 1) {
                superSetCurrentItem(0, true);
            } else {
                superSetCurrentItem(superGetCurrentItem() + 1, true);
            }
        } else if (!this.needLoop && superGetCurrentItem() == 0) {
        } else {
            if (getRealCount() == 2 && superGetCurrentItem() == 0) {
                superSetCurrentItem(1, true);
            } else {
                superSetCurrentItem(superGetCurrentItem() - 1, true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void superSetCurrentItem(int i, boolean z) {
        try {
            super.setCurrentItem(i, z);
        } catch (IllegalStateException e) {
            WXLogUtils.e(e.toString());
            if (getAdapter() != null) {
                getAdapter().notifyDataSetChanged();
                super.setCurrentItem(i, z);
            }
        }
    }

    public void destory() {
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r0 != 3) goto L_0x0024;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c A[Catch:{ Exception -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                }
            }
            if (isAutoScroll()) {
                this.mAutoScrollHandler.sendEmptyMessageDelayed(1, this.intervalTime);
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            WXGesture wXGesture = this.wxGesture;
            return wXGesture == null ? dispatchTouchEvent | wXGesture.onTouch(this, motionEvent) : dispatchTouchEvent;
        }
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
        try {
            boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            WXGesture wXGesture2 = this.wxGesture;
            if (wXGesture2 == null) {
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public WXCirclePageAdapter getCirclePageAdapter() {
        return (WXCirclePageAdapter) getAdapter();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        return getRealCurrentItem();
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public WXGesture getGestureListener() {
        return this.wxGesture;
    }

    public long getIntervalTime() {
        return this.intervalTime;
    }

    public int getRealCount() {
        return ((WXCirclePageAdapter) getAdapter()).getRealCount();
    }

    public int getRealCurrentItem() {
        return ((WXCirclePageAdapter) getAdapter()).getRealPosition(super.getCurrentItem());
    }

    public boolean isAutoScroll() {
        return this.isAutoScroll;
    }

    public boolean isScrollable() {
        return this.scrollable;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return this.scrollable && super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        } catch (ArrayIndexOutOfBoundsException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (IllegalStateException e) {
            WXLogUtils.e(e.toString());
            if (getAdapter() != null) {
                getAdapter().notifyDataSetChanged();
                super.onMeasure(i, i2);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.scrollable) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void pauseAutoScroll() {
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    public void scrollTo(int i, int i2) {
        if (this.scrollable || this.mState != 1) {
            super.scrollTo(i, i2);
        }
    }

    public void setCircle(boolean z) {
        this.needLoop = z;
    }

    public void setCirclePageAdapter(WXCirclePageAdapter wXCirclePageAdapter) {
        setAdapter(wXCirclePageAdapter);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) {
        setRealCurrentItem(i);
    }

    public void setIntervalTime(long j) {
        this.intervalTime = j;
    }

    public void setScrollable(boolean z) {
        this.scrollable = z;
    }

    public void startAutoScroll() {
        this.isAutoScroll = true;
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
        this.mAutoScrollHandler.sendEmptyMessageDelayed(1, this.intervalTime);
    }

    public void stopAutoScroll() {
        this.isAutoScroll = false;
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
    }

    public int superGetCurrentItem() {
        return super.getCurrentItem();
    }

    @SuppressLint({"NewApi"})
    public WXCircleViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
