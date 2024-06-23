package cn.damai.h5container.refresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$styleable;
import cn.damai.h5container.DamaiWebView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class JRefreshLayout extends ViewGroup {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String LOG_TAG = "LOG_JRefreshLayout";
    private static final int MAX_OFFSET = 30;
    private int childScrollViewId;
    private int defaultMaxOffset;
    private int defaultRefreshHeight;
    private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    private View mContentView;
    private int mCurrentOffset;
    private long mDurationOffset;
    private int mFlingSlop;
    private GestureDetectorCompat mGesture;
    private boolean mGestureExecute;
    private JRefreshHeader mHeader;
    private int mHeaderOffset;
    private View mHeaderView;
    private float mInitialDownY;
    private boolean mIsBeingDragged;
    private boolean mIsFling;
    private boolean mIsPinContent;
    private boolean mIsReset;
    private boolean mKeepHeaderWhenRefresh;
    private int mLastFlingY;
    private boolean mNestedScrollExecute;
    private boolean mNestedScrollInProgress;
    private ValueAnimator mOffsetAnimator;
    private boolean mRefreshEnable;
    private JRefreshListener mRefreshListener;
    private boolean mRefreshing;
    private JScrollListener mScrollListener;
    private OverScroller mScroller;
    private int mTouchSlop;

    /* compiled from: Taobao */
    public interface JRefreshListener {
        void onRefresh(JRefreshLayout jRefreshLayout);
    }

    /* compiled from: Taobao */
    public interface JScrollListener {
        void onScroll(int i, int i2, float f, boolean z);
    }

    /* compiled from: Taobao */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* compiled from: Taobao */
    public class RefreshGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private RefreshGestureListener() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-256812603")) {
                return ((Boolean) ipChange.ipc$dispatch("-256812603", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            JRefreshLayout.this.mGestureExecute = true;
            int refreshHeight = JRefreshLayout.this.mHeader == null ? JRefreshLayout.this.defaultRefreshHeight : JRefreshLayout.this.mHeader.refreshHeight();
            if (f2 > 0.0f && (!JRefreshLayout.this.mRefreshing || !JRefreshLayout.this.mKeepHeaderWhenRefresh || JRefreshLayout.this.mCurrentOffset >= refreshHeight)) {
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            if (Math.abs(f2) > ((float) JRefreshLayout.this.mFlingSlop)) {
                JRefreshLayout.this.mIsFling = true;
                JRefreshLayout.this.mScroller.fling(0, 0, (int) f, (int) (-f2), Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                JRefreshLayout.this.invalidate();
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "262474808")) {
                return ((Boolean) ipChange.ipc$dispatch("262474808", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            JRefreshLayout.this.mGestureExecute = true;
            int height = JRefreshLayout.this.mHeader == null ? JRefreshLayout.this.defaultMaxOffset == -1 ? JRefreshLayout.this.getHeight() : JRefreshLayout.this.defaultMaxOffset : JRefreshLayout.this.mHeader.maxOffsetHeight();
            if ((JRefreshLayout.this.mCurrentOffset == 0 && f2 > 0.0f) || (JRefreshLayout.this.mCurrentOffset == height && f2 < 0.0f)) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            int i = -JRefreshLayout.this.calculateOffset((int) f2);
            if (JRefreshLayout.this.mCurrentOffset + i > height) {
                i = height - JRefreshLayout.this.mCurrentOffset;
            } else if (JRefreshLayout.this.mCurrentOffset + i < 0) {
                i = -JRefreshLayout.this.mCurrentOffset;
            }
            JRefreshLayout.this.moveView(i);
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    public JRefreshLayout(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void animTo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1163867955")) {
            ipChange.ipc$dispatch("-1163867955", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (this.mOffsetAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.mOffsetAnimator = valueAnimator;
            valueAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        }
        cancelAnimator();
        if (!this.mKeepHeaderWhenRefresh) {
            i = 0;
        }
        if (this.mCurrentOffset != i) {
            Log.d(LOG_TAG, "animTo " + this.mCurrentOffset + " to " + i);
            this.mOffsetAnimator.setDuration(this.mDurationOffset);
            this.mOffsetAnimator.setIntValues(this.mCurrentOffset, i);
            this.mOffsetAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int calculateOffset(int i) {
        int i2;
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1967750759")) {
            return ((Integer) ipChange.ipc$dispatch("1967750759", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        JRefreshHeader jRefreshHeader = this.mHeader;
        if (jRefreshHeader == null) {
            i2 = this.defaultMaxOffset;
            if (i2 == -1) {
                i2 = getHeight();
            }
        } else {
            i2 = jRefreshHeader.maxOffsetHeight();
        }
        if (i > 0) {
            f = 0.8f;
        } else {
            f = 1.0f - (((float) this.mCurrentOffset) / ((float) i2));
        }
        if (i > 0) {
            return Math.min(30, (int) Math.ceil((double) (f * ((float) i))));
        }
        return Math.max(-30, (int) Math.floor((double) (f * ((float) i))));
    }

    private boolean canChildScrollUp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1124363922")) {
            return ((Boolean) ipChange.ipc$dispatch("1124363922", new Object[]{this})).booleanValue();
        }
        try {
            View view = this.mContentView;
            if (!(view instanceof DamaiWebView)) {
                int i = this.childScrollViewId;
                if (i > 0) {
                    if (view == null || !ViewCompat.canScrollVertically(view.findViewById(i), -1)) {
                        return false;
                    }
                    return true;
                } else if (view == null || ((ViewGroup) view).getChildAt(0) == null || !ViewCompat.canScrollVertically(((ViewGroup) this.mContentView).getChildAt(0), -1)) {
                    return false;
                } else {
                    return true;
                }
            } else if (view == null || !ViewCompat.canScrollVertically(((DamaiWebView) view).getCoreView(), -1)) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void cancelAnimator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "498147521")) {
            ipChange.ipc$dispatch("498147521", new Object[]{this});
            return;
        }
        ValueAnimator valueAnimator = this.mOffsetAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mOffsetAnimator.cancel();
        }
    }

    private void finishSpinner() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-41947742")) {
            ipChange.ipc$dispatch("-41947742", new Object[]{this});
        } else if (this.mCurrentOffset > 0) {
            Log.d(LOG_TAG, "finishSpinner mCurrentOffset is " + this.mCurrentOffset + " , mRefreshing is " + this.mRefreshing);
            JRefreshHeader jRefreshHeader = this.mHeader;
            int refreshHeight = jRefreshHeader == null ? this.defaultRefreshHeight : jRefreshHeader.refreshHeight();
            if (!this.mRefreshing) {
                int i2 = this.mCurrentOffset;
                int i3 = (i2 < refreshHeight || !this.mIsReset) ? 0 : refreshHeight;
                if (i2 >= refreshHeight && this.mIsReset) {
                    this.mRefreshing = true;
                    this.mIsReset = false;
                    JRefreshHeader jRefreshHeader2 = this.mHeader;
                    if (jRefreshHeader2 != null) {
                        jRefreshHeader2.onRefresh(this);
                    }
                    JRefreshListener jRefreshListener = this.mRefreshListener;
                    if (jRefreshListener != null) {
                        jRefreshListener.onRefresh(this);
                    }
                }
                i = i3;
            } else if (this.mCurrentOffset >= refreshHeight / 2) {
                i = refreshHeight;
            }
            animTo(i);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void moveView(int i) {
        JRefreshHeader jRefreshHeader;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1230876855")) {
            ipChange.ipc$dispatch("1230876855", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        JRefreshHeader jRefreshHeader2 = this.mHeader;
        int refreshHeight = jRefreshHeader2 == null ? this.defaultRefreshHeight : jRefreshHeader2.refreshHeight();
        if (!this.mRefreshing && this.mCurrentOffset == 0 && i > 0 && (jRefreshHeader = this.mHeader) != null) {
            jRefreshHeader.onPrepare(this);
        }
        if (this.mCurrentOffset > getHeight() || this.mCurrentOffset == 0) {
            z = true;
        }
        this.mCurrentOffset += i;
        View view = this.mHeaderView;
        if (view != null) {
            view.offsetTopAndBottom(i);
        }
        if (!this.mIsPinContent) {
            this.mContentView.offsetTopAndBottom(i);
        }
        if (z) {
            invalidate();
        }
        JRefreshHeader jRefreshHeader3 = this.mHeader;
        if (jRefreshHeader3 != null) {
            int i2 = this.mCurrentOffset;
            jRefreshHeader3.onScroll(this, i2, ((float) i2) / ((float) refreshHeight), this.mRefreshing);
        }
        JScrollListener jScrollListener = this.mScrollListener;
        if (jScrollListener != null) {
            int i3 = this.mCurrentOffset;
            jScrollListener.onScroll(i, i3, ((float) i3) / ((float) refreshHeight), this.mRefreshing);
        }
        if (!this.mRefreshing && i < 0 && this.mCurrentOffset == 0) {
            JRefreshHeader jRefreshHeader4 = this.mHeader;
            if (jRefreshHeader4 != null) {
                jRefreshHeader4.onReset(this);
            }
            this.mIsReset = true;
        }
    }

    public void computeScroll() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-376314620")) {
            ipChange.ipc$dispatch("-376314620", new Object[]{this});
        } else if (this.mScroller.computeScrollOffset() && this.mIsFling) {
            int currY = this.mLastFlingY - this.mScroller.getCurrY();
            JRefreshHeader jRefreshHeader = this.mHeader;
            int refreshHeight = jRefreshHeader == null ? this.defaultRefreshHeight : jRefreshHeader.refreshHeight();
            JRefreshHeader jRefreshHeader2 = this.mHeader;
            if (jRefreshHeader2 == null) {
                i = this.defaultMaxOffset;
                if (i == -1) {
                    i = getHeight();
                }
            } else {
                i = jRefreshHeader2.maxOffsetHeight();
            }
            if (currY <= 0) {
                refreshHeight = i;
            }
            this.mLastFlingY = this.mScroller.getCurrY();
            if (this.mCurrentOffset > 0 || (currY > 0 && !canChildScrollUp())) {
                int i2 = this.mCurrentOffset;
                if (i2 + currY > refreshHeight) {
                    currY = refreshHeight - i2;
                } else if (i2 + currY < 0) {
                    currY = -i2;
                }
                moveView(currY);
                if (this.mCurrentOffset >= refreshHeight) {
                    this.mScroller.forceFinished(true);
                }
            } else if (currY < 0) {
                View view = this.mContentView;
                if (view instanceof RecyclerView) {
                    ((RecyclerView) view).fling(0, (int) this.mScroller.getCurrVelocity());
                } else if (view instanceof NestedScrollView) {
                    ((NestedScrollView) view).fling((int) this.mScroller.getCurrVelocity());
                } else if (view instanceof ScrollView) {
                    ((ScrollView) view).fling((int) this.mScroller.getCurrVelocity());
                }
                this.mScroller.forceFinished(true);
            }
            invalidate();
        } else if (this.mIsFling) {
            Log.d(LOG_TAG, "mScroll fling complete mCurrentOffset is " + this.mCurrentOffset);
            this.mIsFling = false;
            finishSpinner();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2036753818")) {
            return ((Boolean) ipChange.ipc$dispatch("-2036753818", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            cancelAnimator();
            this.mIsFling = false;
            this.mLastFlingY = 0;
        } else if ((action == 1 || action == 3) && !this.mNestedScrollExecute && !this.mGestureExecute) {
            finishSpinner();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public JRefreshHeader getHeader() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1250931858")) {
            return this.mHeader;
        }
        return (JRefreshHeader) ipChange.ipc$dispatch("-1250931858", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1081811507")) {
            ipChange.ipc$dispatch("1081811507", new Object[]{this});
            return;
        }
        int childCount = getChildCount();
        if (childCount <= 2) {
            if (childCount == 1) {
                this.mContentView = getChildAt(0);
            } else if (childCount == 2) {
                if (getChildAt(0) instanceof JRefreshHeader) {
                    JRefreshHeader jRefreshHeader = (JRefreshHeader) getChildAt(0);
                    this.mHeader = jRefreshHeader;
                    this.mHeaderView = (View) jRefreshHeader;
                }
                this.mContentView = getChildAt(1);
            }
            View view = this.mHeaderView;
            if (view != null) {
                view.bringToFront();
            }
            super.onFinishInflate();
            return;
        }
        throw new IllegalStateException("JRefreshLayout111 can only accommodate two elements");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004c, code lost:
        if (r0 != 3) goto L_0x007e;
     */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1027741021")) {
            return ((Boolean) ipChange.ipc$dispatch("-1027741021", new Object[]{this, motionEvent})).booleanValue();
        } else if (!isEnabled() || !this.mRefreshEnable || this.mNestedScrollInProgress || canChildScrollUp()) {
            return false;
        } else {
            if (this.mRefreshing && this.mIsPinContent && this.mKeepHeaderWhenRefresh) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (!this.mIsBeingDragged && motionEvent.getY() - this.mInitialDownY > ((float) this.mTouchSlop)) {
                            this.mIsBeingDragged = true;
                        }
                        if (this.mCurrentOffset > 0 && !this.mIsBeingDragged) {
                            this.mIsBeingDragged = true;
                        }
                    }
                }
                this.mIsBeingDragged = false;
            } else {
                this.mIsBeingDragged = false;
                this.mInitialDownY = motionEvent.getY();
                this.mGesture.onTouchEvent(motionEvent);
            }
            return this.mIsBeingDragged;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        int i5 = 0;
        if (AndroidInstantRuntime.support(ipChange, "2041661979")) {
            ipChange.ipc$dispatch("2041661979", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        if (this.mHeaderView != null && !isInEditMode()) {
            LayoutParams layoutParams = (LayoutParams) this.mHeaderView.getLayoutParams();
            int paddingLeft = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            int paddingTop = ((getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mHeaderView.getMeasuredHeight()) + this.mCurrentOffset + this.mHeaderOffset;
            this.mHeaderView.layout(paddingLeft, paddingTop, this.mHeaderView.getMeasuredWidth() + paddingLeft, this.mHeaderView.getMeasuredHeight() + paddingTop);
        }
        View view = this.mContentView;
        if (view != null) {
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            int paddingLeft2 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
            int paddingTop2 = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
            if (!this.mIsPinContent) {
                i5 = this.mCurrentOffset;
            }
            int i6 = paddingTop2 + i5;
            this.mContentView.layout(paddingLeft2, i6, this.mContentView.getMeasuredWidth() + paddingLeft2, this.mContentView.getMeasuredHeight() + i6);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674643497")) {
            ipChange.ipc$dispatch("674643497", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            measureChildWithMargins(getChildAt(i3), i, 0, i2, 0);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1212859304")) {
            return ((Boolean) ipChange.ipc$dispatch("1212859304", new Object[]{this, view, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})).booleanValue();
        }
        if (this.mRefreshing && f2 < ((float) (-this.mTouchSlop)) && this.mKeepHeaderWhenRefresh) {
            this.mIsFling = true;
            this.mScroller.fling(0, 0, (int) f, (int) f2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            invalidate();
        }
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652827715")) {
            return ((Boolean) ipChange.ipc$dispatch("1652827715", new Object[]{this, view, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
        }
        this.mNestedScrollExecute = true;
        if (this.mCurrentOffset <= 0) {
            return false;
        }
        JRefreshHeader jRefreshHeader = this.mHeader;
        int refreshHeight = jRefreshHeader == null ? this.defaultRefreshHeight : jRefreshHeader.refreshHeight();
        if ((f2 >= 0.0f || (this.mRefreshing && this.mKeepHeaderWhenRefresh && this.mCurrentOffset < refreshHeight)) && Math.abs(f2) > ((float) this.mFlingSlop)) {
            this.mIsFling = true;
            this.mScroller.fling(0, 0, (int) f, (int) f2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            invalidate();
        }
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1630278126")) {
            ipChange.ipc$dispatch("-1630278126", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), iArr});
            return;
        }
        this.mNestedScrollExecute = true;
        int i3 = this.mCurrentOffset;
        if (i3 > 0 && i2 > 0) {
            int i4 = i2 > i3 ? i3 : i2;
            if (i2 > i3) {
                i2 -= i3;
            }
            iArr[1] = i2;
            moveView(-i4);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1938415917")) {
            ipChange.ipc$dispatch("-1938415917", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        JRefreshHeader jRefreshHeader = this.mHeader;
        if (jRefreshHeader == null) {
            i5 = this.defaultMaxOffset;
            if (i5 == -1) {
                i5 = getHeight();
            }
        } else {
            i5 = jRefreshHeader.maxOffsetHeight();
        }
        if (i4 < 0 && !canChildScrollUp() && (i6 = this.mCurrentOffset) < i5) {
            if (i6 - i4 > i5) {
                i4 = i6 - i5;
            }
            moveView(-calculateOffset(i4));
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939452811")) {
            ipChange.ipc$dispatch("939452811", new Object[]{this, view, view2, Integer.valueOf(i)});
            return;
        }
        this.mNestedScrollExecute = false;
        this.mNestedScrollInProgress = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1225193626")) {
            return isEnabled() && this.mRefreshEnable && (!this.mRefreshing || !this.mIsPinContent || !this.mKeepHeaderWhenRefresh) && (i & 2) != 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1225193626", new Object[]{this, view, view2, Integer.valueOf(i)})).booleanValue();
    }

    public void onStopNestedScroll(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1760252469")) {
            ipChange.ipc$dispatch("1760252469", new Object[]{this, view});
            return;
        }
        if (!this.mIsFling && this.mNestedScrollExecute) {
            finishSpinner();
        }
        this.mNestedScrollExecute = false;
        this.mNestedScrollInProgress = false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-225362143")) {
            return ((Boolean) ipChange.ipc$dispatch("-225362143", new Object[]{this, motionEvent})).booleanValue();
        } else if (!isEnabled() || this.mNestedScrollExecute || canChildScrollUp()) {
            return false;
        } else {
            this.mGesture.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == 1) {
                if (!this.mIsFling && this.mGestureExecute) {
                    finishSpinner();
                }
                this.mGestureExecute = false;
            }
            return true;
        }
    }

    public void refreshComplete(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672996448")) {
            ipChange.ipc$dispatch("1672996448", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mRefreshing) {
            JRefreshHeader jRefreshHeader = this.mHeader;
            if (jRefreshHeader != null) {
                jRefreshHeader.onComplete(this, z);
            }
            this.mRefreshing = false;
            if (this.mCurrentOffset == 0) {
                this.mIsReset = true;
                cancelAnimator();
                JRefreshHeader jRefreshHeader2 = this.mHeader;
                if (jRefreshHeader2 != null) {
                    jRefreshHeader2.onReset(this);
                    return;
                }
                return;
            }
            JRefreshHeader jRefreshHeader3 = this.mHeader;
            postDelayed(new Runnable() {
                /* class cn.damai.h5container.refresh.JRefreshLayout.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "843699534")) {
                        ipChange.ipc$dispatch("843699534", new Object[]{this});
                        return;
                    }
                    JRefreshLayout.this.animTo(0);
                }
            }, jRefreshHeader3 == null ? 0 : z ? jRefreshHeader3.succeedRetention() : jRefreshHeader3.failingRetention());
        }
    }

    public void removeHeader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "827828561")) {
            ipChange.ipc$dispatch("827828561", new Object[]{this});
            return;
        }
        View view = this.mHeaderView;
        if (view != null) {
            removeView(view);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917411237")) {
            ipChange.ipc$dispatch("1917411237", new Object[]{this, Boolean.valueOf(z)});
        } else if (Build.VERSION.SDK_INT >= 21 || !(this.mContentView instanceof AbsListView)) {
            View view = this.mContentView;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    public void setChildScrollViewId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1803536488")) {
            ipChange.ipc$dispatch("1803536488", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.childScrollViewId = i;
    }

    public void setDefaultMaxOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-717483213")) {
            ipChange.ipc$dispatch("-717483213", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.defaultMaxOffset = i;
    }

    public void setDefaultRefreshHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1124348798")) {
            ipChange.ipc$dispatch("1124348798", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.defaultRefreshHeight = i;
    }

    public void setDurationOffset(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "349288357")) {
            ipChange.ipc$dispatch("349288357", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mDurationOffset = j;
    }

    public void setFlingSlop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1361835349")) {
            ipChange.ipc$dispatch("1361835349", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mFlingSlop = i;
    }

    public void setHeaderOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1297951395")) {
            ipChange.ipc$dispatch("-1297951395", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mHeaderOffset = i;
    }

    public void setHeaderView(JRefreshHeader jRefreshHeader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431267813")) {
            ipChange.ipc$dispatch("1431267813", new Object[]{this, jRefreshHeader});
            return;
        }
        setHeaderView(jRefreshHeader, -1, -2);
    }

    public void setJRefreshListener(JRefreshListener jRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "822484780")) {
            ipChange.ipc$dispatch("822484780", new Object[]{this, jRefreshListener});
            return;
        }
        this.mRefreshListener = jRefreshListener;
    }

    public void setJScrollListener(JScrollListener jScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-6612932")) {
            ipChange.ipc$dispatch("-6612932", new Object[]{this, jScrollListener});
            return;
        }
        this.mScrollListener = jScrollListener;
    }

    public void setKeepHeaderWhenRefresh(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "602867231")) {
            ipChange.ipc$dispatch("602867231", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mKeepHeaderWhenRefresh = z;
    }

    public void setPinContent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942423186")) {
            ipChange.ipc$dispatch("1942423186", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIsPinContent = z;
    }

    public void setRefreshEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1550432402")) {
            ipChange.ipc$dispatch("-1550432402", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mRefreshEnable = z;
    }

    public void setTouchSlop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2092944328")) {
            ipChange.ipc$dispatch("-2092944328", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mTouchSlop = i;
    }

    public void startRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "507969641")) {
            ipChange.ipc$dispatch("507969641", new Object[]{this});
        } else if (!this.mRefreshing && this.mRefreshEnable) {
            postDelayed(new Runnable() {
                /* class cn.damai.h5container.refresh.JRefreshLayout.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1040213039")) {
                        ipChange.ipc$dispatch("1040213039", new Object[]{this});
                        return;
                    }
                    JRefreshLayout.this.mRefreshing = true;
                    JRefreshLayout.this.mIsReset = false;
                    if (JRefreshLayout.this.mHeader != null) {
                        JRefreshLayout.this.mHeader.onRefresh(JRefreshLayout.this);
                    }
                    if (JRefreshLayout.this.mRefreshListener != null) {
                        JRefreshLayout.this.mRefreshListener.onRefresh(JRefreshLayout.this);
                    }
                    JRefreshLayout.this.mContentView.scrollTo(0, 0);
                    JRefreshLayout jRefreshLayout = JRefreshLayout.this;
                    jRefreshLayout.animTo(jRefreshLayout.mHeader == null ? JRefreshLayout.this.defaultRefreshHeight : JRefreshLayout.this.mHeader.refreshHeight());
                }
            }, 100);
        }
    }

    public JRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1266358038")) {
            return new LayoutParams(-1, -1);
        }
        return (LayoutParams) ipChange.ipc$dispatch("-1266358038", new Object[]{this});
    }

    public void setHeaderView(JRefreshHeader jRefreshHeader, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059775749")) {
            ipChange.ipc$dispatch("1059775749", new Object[]{this, jRefreshHeader, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).width = i;
        ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).height = i2;
        setHeaderView(jRefreshHeader, generateDefaultLayoutParams);
    }

    public JRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRefreshing = false;
        this.mIsReset = true;
        this.mIsBeingDragged = true;
        this.mIsFling = false;
        this.mGestureExecute = false;
        this.mNestedScrollExecute = false;
        this.mNestedScrollInProgress = false;
        this.mDurationOffset = 200;
        this.mKeepHeaderWhenRefresh = true;
        this.mIsPinContent = false;
        this.mRefreshEnable = true;
        this.mFlingSlop = 1000;
        this.mHeaderOffset = 0;
        this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
            /* class cn.damai.h5container.refresh.JRefreshLayout.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1333266649")) {
                    ipChange.ipc$dispatch("-1333266649", new Object[]{this, valueAnimator});
                    return;
                }
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                JRefreshLayout jRefreshLayout = JRefreshLayout.this;
                jRefreshLayout.moveView(intValue - jRefreshLayout.mCurrentOffset);
            }
        };
        this.mScroller = new OverScroller(context);
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(context, new RefreshGestureListener());
        this.mGesture = gestureDetectorCompat;
        gestureDetectorCompat.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.JRefreshLayout);
        this.mIsPinContent = obtainStyledAttributes.getBoolean(R$styleable.JRefreshLayout_j_pin_content, false);
        this.mKeepHeaderWhenRefresh = obtainStyledAttributes.getBoolean(R$styleable.JRefreshLayout_j_keep_header, true);
        this.mDurationOffset = (long) obtainStyledAttributes.getInt(R$styleable.JRefreshLayout_j_duration_offset, 200);
        this.mRefreshEnable = obtainStyledAttributes.getBoolean(R$styleable.JRefreshLayout_j_refresh_enable, true);
        this.defaultRefreshHeight = obtainStyledAttributes.getLayoutDimension(R$styleable.JRefreshLayout_j_def_refresh_height, Integer.MAX_VALUE);
        this.defaultMaxOffset = obtainStyledAttributes.getLayoutDimension(R$styleable.JRefreshLayout_j_def_max_offset, this.defaultMaxOffset);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-14611611")) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (LayoutParams) ipChange.ipc$dispatch("-14611611", new Object[]{this, attributeSet});
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-36928650")) {
            return new LayoutParams(layoutParams);
        }
        return (LayoutParams) ipChange.ipc$dispatch("-36928650", new Object[]{this, layoutParams});
    }

    public void setHeaderView(JRefreshHeader jRefreshHeader, LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1418536933")) {
            ipChange.ipc$dispatch("1418536933", new Object[]{this, jRefreshHeader, layoutParams});
            return;
        }
        removeHeader();
        this.mHeader = jRefreshHeader;
        View view = (View) jRefreshHeader;
        this.mHeaderView = view;
        addView(view, 0, layoutParams);
        this.mHeaderView.bringToFront();
    }
}
