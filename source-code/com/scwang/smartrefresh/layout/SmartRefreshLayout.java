package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshInitializer;
import com.scwang.smartrefresh.layout.api.RefreshContent;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import tb.cc2;
import tb.gd2;
import tb.jz1;
import tb.n70;

@SuppressLint({"RestrictedApi"})
/* compiled from: Taobao */
public class SmartRefreshLayout extends ViewGroup implements NestedScrollingParent, RefreshLayout {
    protected static ViewGroup.MarginLayoutParams sDefaultMarginLP = new ViewGroup.MarginLayoutParams(-1, -1);
    protected static DefaultRefreshFooterCreator sFooterCreator;
    protected static DefaultRefreshHeaderCreator sHeaderCreator;
    protected static DefaultRefreshInitializer sRefreshInitializer;
    protected Runnable animationRunnable;
    protected boolean mAttachedToWindow;
    protected int mCurrentVelocity;
    protected boolean mDisableContentWhenLoading;
    protected boolean mDisableContentWhenRefresh;
    protected char mDragDirection;
    protected float mDragRate;
    protected boolean mEnableAutoLoadMore;
    protected boolean mEnableClipFooterWhenFixedBehind;
    protected boolean mEnableClipHeaderWhenFixedBehind;
    protected boolean mEnableFooterFollowWhenNoMoreData;
    protected boolean mEnableFooterTranslationContent;
    protected boolean mEnableHeaderTranslationContent;
    protected boolean mEnableLoadMore;
    protected boolean mEnableLoadMoreWhenContentNotFull;
    protected boolean mEnableNestedScrolling;
    protected boolean mEnableOverScrollBounce;
    protected boolean mEnableOverScrollDrag;
    protected boolean mEnablePreviewInEditMode;
    protected boolean mEnablePureScrollMode;
    protected boolean mEnableRefresh;
    protected boolean mEnableScrollContentWhenLoaded;
    protected boolean mEnableScrollContentWhenRefreshed;
    protected MotionEvent mFalsifyEvent;
    protected int mFixedFooterViewId;
    protected int mFixedHeaderViewId;
    protected int mFloorDuration;
    protected int mFooterBackgroundColor;
    protected int mFooterHeight;
    protected n70 mFooterHeightStatus;
    protected int mFooterInsetStart;
    protected boolean mFooterLocked;
    protected float mFooterMaxDragRate;
    protected boolean mFooterNeedTouchEventWhenLoading;
    protected boolean mFooterNoMoreData;
    protected boolean mFooterNoMoreDataEffective;
    protected int mFooterTranslationViewId;
    protected float mFooterTriggerRate;
    protected Handler mHandler;
    protected int mHeaderBackgroundColor;
    protected int mHeaderHeight;
    protected n70 mHeaderHeightStatus;
    protected int mHeaderInsetStart;
    protected float mHeaderMaxDragRate;
    protected boolean mHeaderNeedTouchEventWhenRefreshing;
    protected int mHeaderTranslationViewId;
    protected float mHeaderTriggerRate;
    protected boolean mIsBeingDragged;
    protected RefreshKernel mKernel;
    protected long mLastOpenTime;
    protected int mLastSpinner;
    protected float mLastTouchX;
    protected float mLastTouchY;
    protected OnLoadMoreListener mLoadMoreListener;
    protected boolean mManualFooterTranslationContent;
    protected boolean mManualHeaderTranslationContent;
    protected boolean mManualLoadMore;
    protected int mMaximumVelocity;
    protected int mMinimumVelocity;
    protected NestedScrollingChildHelper mNestedChild;
    protected boolean mNestedInProgress;
    protected NestedScrollingParentHelper mNestedParent;
    protected OnMultiPurposeListener mOnMultiPurposeListener;
    protected Paint mPaint;
    protected int[] mParentOffsetInWindow;
    protected int[] mPrimaryColors;
    protected int mReboundDuration;
    protected Interpolator mReboundInterpolator;
    protected RefreshContent mRefreshContent;
    protected RefreshInternal mRefreshFooter;
    protected RefreshInternal mRefreshHeader;
    protected OnRefreshListener mRefreshListener;
    protected int mScreenHeightPixels;
    protected ScrollBoundaryDecider mScrollBoundaryDecider;
    protected Scroller mScroller;
    protected int mSpinner;
    protected RefreshState mState;
    protected boolean mSuperDispatchTouchEvent;
    protected int mTotalUnconsumed;
    protected int mTouchSlop;
    protected int mTouchSpinner;
    protected float mTouchX;
    protected float mTouchY;
    protected VelocityTracker mVelocityTracker;
    protected boolean mVerticalPermit;
    protected RefreshState mViceState;
    protected ValueAnimator reboundAnimator;

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public class BounceRunnable implements Runnable {
        int mFrame = 0;
        int mFrameDelay = 10;
        long mLastTime;
        float mOffset = 0.0f;
        int mSmoothDistance;
        float mVelocity;

        BounceRunnable(float f, int i) {
            this.mVelocity = f;
            this.mSmoothDistance = i;
            this.mLastTime = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.mHandler.postDelayed(this, (long) this.mFrameDelay);
            if (f > 0.0f) {
                SmartRefreshLayout.this.mKernel.setState(RefreshState.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.mKernel.setState(RefreshState.PullUpToLoad);
            }
        }

        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable == this && !smartRefreshLayout.mState.isFinishing) {
                if (Math.abs(smartRefreshLayout.mSpinner) < Math.abs(this.mSmoothDistance)) {
                    int i = this.mFrame + 1;
                    this.mFrame = i;
                    this.mVelocity = (float) (((double) this.mVelocity) * Math.pow(0.949999988079071d, (double) (i * 2)));
                } else if (this.mSmoothDistance != 0) {
                    int i2 = this.mFrame + 1;
                    this.mFrame = i2;
                    this.mVelocity = (float) (((double) this.mVelocity) * Math.pow(0.44999998807907104d, (double) (i2 * 2)));
                } else {
                    int i3 = this.mFrame + 1;
                    this.mFrame = i3;
                    this.mVelocity = (float) (((double) this.mVelocity) * Math.pow(0.8500000238418579d, (double) (i3 * 2)));
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float f = this.mVelocity * ((((float) (currentAnimationTimeMillis - this.mLastTime)) * 1.0f) / 1000.0f);
                if (Math.abs(f) >= 1.0f) {
                    this.mLastTime = currentAnimationTimeMillis;
                    float f2 = this.mOffset + f;
                    this.mOffset = f2;
                    SmartRefreshLayout.this.moveSpinnerInfinitely(f2);
                    SmartRefreshLayout.this.mHandler.postDelayed(this, (long) this.mFrameDelay);
                    return;
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                RefreshState refreshState = smartRefreshLayout2.mViceState;
                boolean z = refreshState.isDragging;
                if (z && refreshState.isHeader) {
                    smartRefreshLayout2.mKernel.setState(RefreshState.PullDownCanceled);
                } else if (z && refreshState.isFooter) {
                    smartRefreshLayout2.mKernel.setState(RefreshState.PullUpCanceled);
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                smartRefreshLayout3.animationRunnable = null;
                if (Math.abs(smartRefreshLayout3.mSpinner) >= Math.abs(this.mSmoothDistance)) {
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    smartRefreshLayout4.animSpinner(this.mSmoothDistance, 0, smartRefreshLayout4.mReboundInterpolator, Math.min(Math.max((int) cc2.px2dp(Math.abs(SmartRefreshLayout.this.mSpinner - this.mSmoothDistance)), 30), 100) * 10);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public class FlingRunnable implements Runnable {
        float mDamping = 0.98f;
        int mFrame = 0;
        int mFrameDelay = 10;
        long mLastTime = AnimationUtils.currentAnimationTimeMillis();
        int mOffset;
        long mStartTime = 0;
        float mVelocity;

        FlingRunnable(float f) {
            this.mVelocity = f;
            this.mOffset = SmartRefreshLayout.this.mSpinner;
        }

        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable == this && !smartRefreshLayout.mState.isFinishing) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float pow = (float) (((double) this.mVelocity) * Math.pow((double) this.mDamping, (double) (((float) (currentAnimationTimeMillis - this.mStartTime)) / (1000.0f / ((float) this.mFrameDelay)))));
                this.mVelocity = pow;
                float f = pow * ((((float) (currentAnimationTimeMillis - this.mLastTime)) * 1.0f) / 1000.0f);
                if (Math.abs(f) > 1.0f) {
                    this.mLastTime = currentAnimationTimeMillis;
                    int i = (int) (((float) this.mOffset) + f);
                    this.mOffset = i;
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.mSpinner * i > 0) {
                        smartRefreshLayout2.mKernel.moveSpinner(i, true);
                        SmartRefreshLayout.this.mHandler.postDelayed(this, (long) this.mFrameDelay);
                        return;
                    }
                    smartRefreshLayout2.animationRunnable = null;
                    smartRefreshLayout2.mKernel.moveSpinner(0, true);
                    cc2.fling(SmartRefreshLayout.this.mRefreshContent.getScrollableView(), (int) (-this.mVelocity));
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.mFooterLocked && f > 0.0f) {
                        smartRefreshLayout3.mFooterLocked = false;
                        return;
                    }
                    return;
                }
                SmartRefreshLayout.this.animationRunnable = null;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
            if (r0.mSpinner >= (-r0.mFooterHeight)) goto L_0x004b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0057, code lost:
            if (r0.mSpinner > r0.mHeaderHeight) goto L_0x0059;
         */
        public Runnable start() {
            RefreshState refreshState;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            RefreshState refreshState2 = smartRefreshLayout.mState;
            if (refreshState2.isFinishing) {
                return null;
            }
            if (smartRefreshLayout.mSpinner != 0) {
                if (refreshState2.isOpening || (smartRefreshLayout.mFooterNoMoreData && smartRefreshLayout.mEnableFooterFollowWhenNoMoreData && smartRefreshLayout.mFooterNoMoreDataEffective && smartRefreshLayout.isEnableRefreshOrLoadMore(smartRefreshLayout.mEnableLoadMore))) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.mState == RefreshState.Loading || (smartRefreshLayout2.mFooterNoMoreData && smartRefreshLayout2.mEnableFooterFollowWhenNoMoreData && smartRefreshLayout2.mFooterNoMoreDataEffective && smartRefreshLayout2.isEnableRefreshOrLoadMore(smartRefreshLayout2.mEnableLoadMore))) {
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    }
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.mState == RefreshState.Refreshing) {
                    }
                }
                int i = 0;
                int i2 = SmartRefreshLayout.this.mSpinner;
                float f = this.mVelocity;
                int i3 = i2;
                while (true) {
                    if (i2 * i3 <= 0) {
                        break;
                    }
                    i++;
                    f = (float) (((double) f) * Math.pow((double) this.mDamping, (double) (((float) (this.mFrameDelay * i)) / 10.0f)));
                    float f2 = ((((float) this.mFrameDelay) * 1.0f) / 1000.0f) * f;
                    if (Math.abs(f2) < 1.0f) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        RefreshState refreshState3 = smartRefreshLayout5.mState;
                        if (!refreshState3.isOpening || ((refreshState3 == (refreshState = RefreshState.Refreshing) && i3 > smartRefreshLayout5.mHeaderHeight) || (refreshState3 != refreshState && i3 < (-smartRefreshLayout5.mFooterHeight)))) {
                            return null;
                        }
                    } else {
                        i3 = (int) (((float) i3) + f2);
                    }
                }
            }
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.mHandler.postDelayed(this, (long) this.mFrameDelay);
            return this;
        }
    }

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            iArr[RefreshState.None.ordinal()] = 1;
            a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            a[RefreshState.PullUpToLoad.ordinal()] = 3;
            a[RefreshState.PullDownCanceled.ordinal()] = 4;
            a[RefreshState.PullUpCanceled.ordinal()] = 5;
            a[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            a[RefreshState.ReleaseToLoad.ordinal()] = 7;
            a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            a[RefreshState.RefreshReleased.ordinal()] = 9;
            a[RefreshState.LoadReleased.ordinal()] = 10;
            a[RefreshState.Refreshing.ordinal()] = 11;
            a[RefreshState.Loading.ordinal()] = 12;
            a[RefreshState.RefreshFinish.ordinal()] = 13;
            a[RefreshState.LoadFinish.ordinal()] = 14;
            a[RefreshState.TwoLevelReleased.ordinal()] = 15;
            a[RefreshState.TwoLevelFinish.ordinal()] = 16;
            a[RefreshState.TwoLevel.ordinal()] = 17;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.setStateDirectLoading(this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.mLastOpenTime = System.currentTimeMillis();
            SmartRefreshLayout.this.notifyStateChanged(RefreshState.Refreshing);
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            OnRefreshListener onRefreshListener = smartRefreshLayout.mRefreshListener;
            if (onRefreshListener != null) {
                if (this.a) {
                    onRefreshListener.onRefresh(smartRefreshLayout);
                }
            } else if (smartRefreshLayout.mOnMultiPurposeListener == null) {
                smartRefreshLayout.finishRefresh(3000);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            RefreshInternal refreshInternal = smartRefreshLayout2.mRefreshHeader;
            if (refreshInternal != null) {
                int i = smartRefreshLayout2.mHeaderHeight;
                refreshInternal.onStartAnimator(smartRefreshLayout2, i, (int) (smartRefreshLayout2.mHeaderMaxDragRate * ((float) i)));
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout3.mOnMultiPurposeListener;
            if (onMultiPurposeListener != null && (smartRefreshLayout3.mRefreshHeader instanceof RefreshHeader)) {
                if (this.a) {
                    onMultiPurposeListener.onRefresh(smartRefreshLayout3);
                }
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                int i2 = smartRefreshLayout4.mHeaderHeight;
                smartRefreshLayout4.mOnMultiPurposeListener.onHeaderStartAnimator((RefreshHeader) smartRefreshLayout4.mRefreshHeader, i2, (int) (smartRefreshLayout4.mHeaderMaxDragRate * ((float) i2)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        public void onAnimationEnd(Animator animator) {
            RefreshState refreshState;
            RefreshState refreshState2;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.reboundAnimator = null;
            if (smartRefreshLayout.mSpinner != 0 || (refreshState = smartRefreshLayout.mState) == (refreshState2 = RefreshState.None) || refreshState.isOpening || refreshState.isDragging) {
                RefreshState refreshState3 = smartRefreshLayout.mState;
                if (refreshState3 != smartRefreshLayout.mViceState) {
                    smartRefreshLayout.setViceState(refreshState3);
                    return;
                }
                return;
            }
            smartRefreshLayout.notifyStateChanged(refreshState2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
        }
    }

    /* compiled from: Taobao */
    public class f implements RefreshKernel {

        /* compiled from: Taobao */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.mKernel.setState(RefreshState.TwoLevel);
            }
        }

        public f() {
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public ValueAnimator animSpinner(int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.animSpinner(i, 0, smartRefreshLayout.mReboundInterpolator, smartRefreshLayout.mReboundDuration);
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel finishTwoLevel() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mState == RefreshState.TwoLevel) {
                smartRefreshLayout.mKernel.setState(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.mSpinner == 0) {
                    moveSpinner(0, false);
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                } else {
                    animSpinner(0).setDuration((long) SmartRefreshLayout.this.mFloorDuration);
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        @NonNull
        public RefreshContent getRefreshContent() {
            return SmartRefreshLayout.this.mRefreshContent;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        @NonNull
        public RefreshLayout getRefreshLayout() {
            return SmartRefreshLayout.this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:50:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x00af  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5  */
        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel moveSpinner(int i, boolean z) {
            OnMultiPurposeListener onMultiPurposeListener;
            int i2;
            OnMultiPurposeListener onMultiPurposeListener2;
            boolean z2;
            int i3;
            RefreshInternal refreshInternal;
            RefreshInternal refreshInternal2;
            SmartRefreshLayout smartRefreshLayout;
            RefreshInternal refreshInternal3;
            RefreshInternal refreshInternal4;
            RefreshInternal refreshInternal5;
            RefreshInternal refreshInternal6;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            if (smartRefreshLayout2.mSpinner == i && (((refreshInternal5 = smartRefreshLayout2.mRefreshHeader) == null || !refreshInternal5.isSupportHorizontalDrag()) && ((refreshInternal6 = SmartRefreshLayout.this.mRefreshFooter) == null || !refreshInternal6.isSupportHorizontalDrag()))) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int i4 = smartRefreshLayout3.mSpinner;
            smartRefreshLayout3.mSpinner = i;
            if (z) {
                RefreshState refreshState = smartRefreshLayout3.mViceState;
                if (refreshState.isDragging || refreshState.isOpening) {
                    if (((float) i) > ((float) smartRefreshLayout3.mHeaderHeight) * smartRefreshLayout3.mHeaderTriggerRate) {
                        if (smartRefreshLayout3.mState != RefreshState.ReleaseToTwoLevel) {
                            smartRefreshLayout3.mKernel.setState(RefreshState.ReleaseToRefresh);
                        }
                    } else if (((float) (-i)) > ((float) smartRefreshLayout3.mFooterHeight) * smartRefreshLayout3.mFooterTriggerRate && !smartRefreshLayout3.mFooterNoMoreData) {
                        smartRefreshLayout3.mKernel.setState(RefreshState.ReleaseToLoad);
                    } else if (i < 0 && !smartRefreshLayout3.mFooterNoMoreData) {
                        smartRefreshLayout3.mKernel.setState(RefreshState.PullUpToLoad);
                    } else if (i > 0) {
                        smartRefreshLayout3.mKernel.setState(RefreshState.PullDownToRefresh);
                    }
                }
            }
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            int i5 = 1;
            if (smartRefreshLayout4.mRefreshContent != null) {
                if (i >= 0 && (refreshInternal4 = smartRefreshLayout4.mRefreshHeader) != null) {
                    if (smartRefreshLayout4.isEnableTranslationContent(smartRefreshLayout4.mEnableHeaderTranslationContent, refreshInternal4)) {
                        i3 = i;
                    } else if (i4 < 0) {
                        i3 = 0;
                    }
                    z2 = true;
                    if (i <= 0 && (refreshInternal3 = (smartRefreshLayout = SmartRefreshLayout.this).mRefreshFooter) != null) {
                        if (!smartRefreshLayout.isEnableTranslationContent(smartRefreshLayout.mEnableFooterTranslationContent, refreshInternal3)) {
                            i3 = i;
                        } else if (i4 > 0) {
                            i3 = 0;
                        }
                        z2 = true;
                    }
                    if (z2) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        smartRefreshLayout5.mRefreshContent.moveSpinner(i3, smartRefreshLayout5.mHeaderTranslationViewId, smartRefreshLayout5.mFooterTranslationViewId);
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        if (smartRefreshLayout6.mFooterNoMoreData && smartRefreshLayout6.mFooterNoMoreDataEffective && smartRefreshLayout6.mEnableFooterFollowWhenNoMoreData) {
                            RefreshInternal refreshInternal7 = smartRefreshLayout6.mRefreshFooter;
                            if ((refreshInternal7 instanceof RefreshFooter) && refreshInternal7.getSpinnerStyle() == gd2.Translate) {
                                SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                                if (smartRefreshLayout7.isEnableRefreshOrLoadMore(smartRefreshLayout7.mEnableLoadMore)) {
                                    SmartRefreshLayout.this.mRefreshFooter.getView().setTranslationY((float) Math.max(0, i3));
                                }
                            }
                        }
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        boolean z3 = (smartRefreshLayout8.mEnableClipHeaderWhenFixedBehind && (refreshInternal2 = smartRefreshLayout8.mRefreshHeader) != null && refreshInternal2.getSpinnerStyle() == gd2.FixedBehind) || SmartRefreshLayout.this.mHeaderBackgroundColor != 0;
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        boolean z4 = (smartRefreshLayout9.mEnableClipFooterWhenFixedBehind && (refreshInternal = smartRefreshLayout9.mRefreshFooter) != null && refreshInternal.getSpinnerStyle() == gd2.FixedBehind) || SmartRefreshLayout.this.mFooterBackgroundColor != 0;
                        if ((z3 && (i3 >= 0 || i4 > 0)) || (z4 && (i3 <= 0 || i4 < 0))) {
                            smartRefreshLayout3.invalidate();
                        }
                    }
                }
                i3 = 0;
                z2 = false;
                if (!smartRefreshLayout.isEnableTranslationContent(smartRefreshLayout.mEnableFooterTranslationContent, refreshInternal3)) {
                }
                z2 = true;
                if (z2) {
                }
            }
            if ((i >= 0 || i4 > 0) && SmartRefreshLayout.this.mRefreshHeader != null) {
                int max = Math.max(i, 0);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                int i6 = smartRefreshLayout10.mHeaderHeight;
                int i7 = (int) (((float) i6) * smartRefreshLayout10.mHeaderMaxDragRate);
                float f = (((float) max) * 1.0f) / ((float) (i6 == 0 ? 1 : i6));
                if (smartRefreshLayout10.isEnableRefreshOrLoadMore(smartRefreshLayout10.mEnableRefresh) || (SmartRefreshLayout.this.mState == RefreshState.RefreshFinish && !z)) {
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (i4 != smartRefreshLayout11.mSpinner) {
                        if (smartRefreshLayout11.mRefreshHeader.getSpinnerStyle() == gd2.Translate) {
                            SmartRefreshLayout.this.mRefreshHeader.getView().setTranslationY((float) SmartRefreshLayout.this.mSpinner);
                            SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                            if (!(smartRefreshLayout12.mHeaderBackgroundColor == 0 || smartRefreshLayout12.mPaint == null || smartRefreshLayout12.isEnableTranslationContent(smartRefreshLayout12.mEnableHeaderTranslationContent, smartRefreshLayout12.mRefreshHeader))) {
                                smartRefreshLayout3.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.mRefreshHeader.getSpinnerStyle().c) {
                            View view = SmartRefreshLayout.this.mRefreshHeader.getView();
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : SmartRefreshLayout.sDefaultMarginLP;
                            view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((SmartRefreshLayout.this.mSpinner - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                            int i8 = marginLayoutParams.leftMargin;
                            int i9 = marginLayoutParams.topMargin + SmartRefreshLayout.this.mHeaderInsetStart;
                            view.layout(i8, i9, view.getMeasuredWidth() + i8, view.getMeasuredHeight() + i9);
                        }
                        i2 = i7;
                        SmartRefreshLayout.this.mRefreshHeader.onMoving(z, f, max, i6, i7);
                    } else {
                        i2 = i7;
                    }
                    if (z && SmartRefreshLayout.this.mRefreshHeader.isSupportHorizontalDrag()) {
                        int i10 = (int) SmartRefreshLayout.this.mLastTouchX;
                        int width = smartRefreshLayout3.getWidth();
                        SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                        smartRefreshLayout13.mRefreshHeader.onHorizontalDrag(smartRefreshLayout13.mLastTouchX / ((float) (width == 0 ? 1 : width)), i10, width);
                    }
                } else {
                    i2 = i7;
                }
                SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                if (!(i4 == smartRefreshLayout14.mSpinner || (onMultiPurposeListener2 = smartRefreshLayout14.mOnMultiPurposeListener) == null)) {
                    RefreshInternal refreshInternal8 = smartRefreshLayout14.mRefreshHeader;
                    if (refreshInternal8 instanceof RefreshHeader) {
                        onMultiPurposeListener2.onHeaderMoving((RefreshHeader) refreshInternal8, z, f, max, i6, i2);
                    }
                }
            }
            if ((i <= 0 || i4 < 0) && SmartRefreshLayout.this.mRefreshFooter != null) {
                int i11 = -Math.min(i, 0);
                SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                int i12 = smartRefreshLayout15.mFooterHeight;
                int i13 = (int) (((float) i12) * smartRefreshLayout15.mFooterMaxDragRate);
                float f2 = (((float) i11) * 1.0f) / ((float) (i12 == 0 ? 1 : i12));
                if (smartRefreshLayout15.isEnableRefreshOrLoadMore(smartRefreshLayout15.mEnableLoadMore) || (SmartRefreshLayout.this.mState == RefreshState.LoadFinish && !z)) {
                    SmartRefreshLayout smartRefreshLayout16 = SmartRefreshLayout.this;
                    if (i4 != smartRefreshLayout16.mSpinner) {
                        if (smartRefreshLayout16.mRefreshFooter.getSpinnerStyle() == gd2.Translate) {
                            SmartRefreshLayout.this.mRefreshFooter.getView().setTranslationY((float) SmartRefreshLayout.this.mSpinner);
                            SmartRefreshLayout smartRefreshLayout17 = SmartRefreshLayout.this;
                            if (!(smartRefreshLayout17.mFooterBackgroundColor == 0 || smartRefreshLayout17.mPaint == null || smartRefreshLayout17.isEnableTranslationContent(smartRefreshLayout17.mEnableFooterTranslationContent, smartRefreshLayout17.mRefreshFooter))) {
                                smartRefreshLayout3.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.mRefreshFooter.getSpinnerStyle().c) {
                            View view2 = SmartRefreshLayout.this.mRefreshFooter.getView();
                            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : SmartRefreshLayout.sDefaultMarginLP;
                            view2.measure(View.MeasureSpec.makeMeasureSpec(view2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(((-SmartRefreshLayout.this.mSpinner) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0), 1073741824));
                            int i14 = marginLayoutParams2.leftMargin;
                            int measuredHeight = (marginLayoutParams2.topMargin + smartRefreshLayout3.getMeasuredHeight()) - SmartRefreshLayout.this.mFooterInsetStart;
                            view2.layout(i14, measuredHeight - view2.getMeasuredHeight(), view2.getMeasuredWidth() + i14, measuredHeight);
                        }
                        SmartRefreshLayout.this.mRefreshFooter.onMoving(z, f2, i11, i12, i13);
                    }
                    if (z && SmartRefreshLayout.this.mRefreshFooter.isSupportHorizontalDrag()) {
                        int i15 = (int) SmartRefreshLayout.this.mLastTouchX;
                        int width2 = smartRefreshLayout3.getWidth();
                        SmartRefreshLayout smartRefreshLayout18 = SmartRefreshLayout.this;
                        float f3 = smartRefreshLayout18.mLastTouchX;
                        if (width2 != 0) {
                            i5 = width2;
                        }
                        smartRefreshLayout18.mRefreshFooter.onHorizontalDrag(f3 / ((float) i5), i15, width2);
                    }
                }
                SmartRefreshLayout smartRefreshLayout19 = SmartRefreshLayout.this;
                if (!(i4 == smartRefreshLayout19.mSpinner || (onMultiPurposeListener = smartRefreshLayout19.mOnMultiPurposeListener) == null)) {
                    RefreshInternal refreshInternal9 = smartRefreshLayout19.mRefreshFooter;
                    if (refreshInternal9 instanceof RefreshFooter) {
                        onMultiPurposeListener.onFooterMoving((RefreshFooter) refreshInternal9, z, f2, i11, i12, i13);
                    }
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestDefaultTranslationContentFor(@NonNull RefreshInternal refreshInternal, boolean z) {
            if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (!smartRefreshLayout.mManualHeaderTranslationContent) {
                    smartRefreshLayout.mManualHeaderTranslationContent = true;
                    smartRefreshLayout.mEnableHeaderTranslationContent = z;
                }
            } else if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (!smartRefreshLayout2.mManualFooterTranslationContent) {
                    smartRefreshLayout2.mManualFooterTranslationContent = true;
                    smartRefreshLayout2.mEnableFooterTranslationContent = z;
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestDrawBackgroundFor(@NonNull RefreshInternal refreshInternal, int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mPaint == null && i != 0) {
                smartRefreshLayout.mPaint = new Paint();
            }
            if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderBackgroundColor = i;
            } else if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterBackgroundColor = i;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestFloorDuration(int i) {
            SmartRefreshLayout.this.mFloorDuration = i;
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestNeedTouchEventFor(@NonNull RefreshInternal refreshInternal, boolean z) {
            if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderNeedTouchEventWhenRefreshing = z;
            } else if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterNeedTouchEventWhenLoading = z;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestRemeasureHeightFor(@NonNull RefreshInternal refreshInternal) {
            if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                n70 n70 = smartRefreshLayout.mHeaderHeightStatus;
                if (n70.b) {
                    smartRefreshLayout.mHeaderHeightStatus = n70.c();
                }
            } else if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                n70 n702 = smartRefreshLayout2.mFooterHeightStatus;
                if (n702.b) {
                    smartRefreshLayout2.mFooterHeightStatus = n702.c();
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel setState(@NonNull RefreshState refreshState) {
            switch (a.a[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState2 = smartRefreshLayout.mState;
                    RefreshState refreshState3 = RefreshState.None;
                    if (refreshState2 != refreshState3 && smartRefreshLayout.mSpinner == 0) {
                        smartRefreshLayout.notifyStateChanged(refreshState3);
                        return null;
                    } else if (smartRefreshLayout.mSpinner == 0) {
                        return null;
                    } else {
                        animSpinner(0);
                        return null;
                    }
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.mState.isOpening || !smartRefreshLayout2.isEnableRefreshOrLoadMore(smartRefreshLayout2.mEnableRefresh)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownToRefresh);
                    return null;
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.isEnableRefreshOrLoadMore(smartRefreshLayout3.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        RefreshState refreshState4 = smartRefreshLayout4.mState;
                        if (!refreshState4.isOpening && !refreshState4.isFinishing && (!smartRefreshLayout4.mFooterNoMoreData || !smartRefreshLayout4.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout4.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout4.notifyStateChanged(RefreshState.PullUpToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                    return null;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.mState.isOpening || !smartRefreshLayout5.isEnableRefreshOrLoadMore(smartRefreshLayout5.mEnableRefresh)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                        return null;
                    }
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownCanceled);
                    setState(RefreshState.None);
                    return null;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.isEnableRefreshOrLoadMore(smartRefreshLayout6.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.mState.isOpening && (!smartRefreshLayout7.mFooterNoMoreData || !smartRefreshLayout7.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout7.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout7.notifyStateChanged(RefreshState.PullUpCanceled);
                            setState(RefreshState.None);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                    return null;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.mState.isOpening || !smartRefreshLayout8.isEnableRefreshOrLoadMore(smartRefreshLayout8.mEnableRefresh)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToRefresh);
                    return null;
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.isEnableRefreshOrLoadMore(smartRefreshLayout9.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        RefreshState refreshState5 = smartRefreshLayout10.mState;
                        if (!refreshState5.isOpening && !refreshState5.isFinishing && (!smartRefreshLayout10.mFooterNoMoreData || !smartRefreshLayout10.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout10.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout10.notifyStateChanged(RefreshState.ReleaseToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                    return null;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (smartRefreshLayout11.mState.isOpening || !smartRefreshLayout11.isEnableRefreshOrLoadMore(smartRefreshLayout11.mEnableRefresh)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                        return null;
                    }
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (smartRefreshLayout12.mState.isOpening || !smartRefreshLayout12.isEnableRefreshOrLoadMore(smartRefreshLayout12.mEnableRefresh)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (smartRefreshLayout13.mState.isOpening || !smartRefreshLayout13.isEnableRefreshOrLoadMore(smartRefreshLayout13.mEnableLoadMore)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.LoadReleased);
                    return null;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    return null;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    return null;
                case 13:
                    SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                    if (smartRefreshLayout14.mState != RefreshState.Refreshing) {
                        return null;
                    }
                    smartRefreshLayout14.notifyStateChanged(RefreshState.RefreshFinish);
                    return null;
                case 14:
                    SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                    if (smartRefreshLayout15.mState != RefreshState.Loading) {
                        return null;
                    }
                    smartRefreshLayout15.notifyStateChanged(RefreshState.LoadFinish);
                    return null;
                case 15:
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevelReleased);
                    return null;
                case 16:
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevelFinish);
                    return null;
                case 17:
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevel);
                    return null;
                default:
                    return null;
            }
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel startTwoLevel(boolean z) {
            if (z) {
                a aVar = new a();
                ValueAnimator animSpinner = animSpinner(SmartRefreshLayout.this.getMeasuredHeight());
                if (animSpinner != null) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    if (animSpinner == smartRefreshLayout.reboundAnimator) {
                        animSpinner.setDuration((long) smartRefreshLayout.mFloorDuration);
                        animSpinner.addListener(aVar);
                    }
                }
                aVar.onAnimationEnd(null);
            } else if (animSpinner(0) == null) {
                SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
            }
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public static void setDefaultRefreshFooterCreator(@NonNull DefaultRefreshFooterCreator defaultRefreshFooterCreator) {
        sFooterCreator = defaultRefreshFooterCreator;
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull DefaultRefreshHeaderCreator defaultRefreshHeaderCreator) {
        sHeaderCreator = defaultRefreshHeaderCreator;
    }

    public static void setDefaultRefreshInitializer(@NonNull DefaultRefreshInitializer defaultRefreshInitializer) {
        sRefreshInitializer = defaultRefreshInitializer;
    }

    /* access modifiers changed from: protected */
    public ValueAnimator animSpinner(int i, int i2, Interpolator interpolator, int i3) {
        if (this.mSpinner == i) {
            return null;
        }
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animationRunnable = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mSpinner, i);
        this.reboundAnimator = ofInt;
        ofInt.setDuration((long) i3);
        this.reboundAnimator.setInterpolator(interpolator);
        this.reboundAnimator.addListener(new d());
        this.reboundAnimator.addUpdateListener(new e());
        this.reboundAnimator.setStartDelay((long) i2);
        this.reboundAnimator.start();
        return this.reboundAnimator;
    }

    /* access modifiers changed from: protected */
    public void animSpinnerBounce(float f2) {
        RefreshState refreshState;
        if (this.reboundAnimator != null) {
            return;
        }
        if (f2 > 0.0f && ((refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
            this.animationRunnable = new BounceRunnable(f2, this.mHeaderHeight);
        } else if (f2 < 0.0f && (this.mState == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && this.mState != RefreshState.Refreshing)))) {
            this.animationRunnable = new BounceRunnable(f2, -this.mFooterHeight);
        } else if (this.mSpinner == 0 && this.mEnableOverScrollBounce) {
            this.animationRunnable = new BounceRunnable(f2, 0);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoLoadMore() {
        int i = this.mReboundDuration;
        int i2 = this.mFooterHeight;
        float f2 = ((float) i2) * ((this.mFooterMaxDragRate / 2.0f) + 0.5f) * 1.0f;
        if (i2 == 0) {
            i2 = 1;
        }
        return autoLoadMore(0, i, f2 / ((float) i2), false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoLoadMoreAnimationOnly() {
        int i = this.mReboundDuration;
        int i2 = this.mFooterHeight;
        float f2 = ((float) i2) * ((this.mFooterMaxDragRate / 2.0f) + 0.5f) * 1.0f;
        if (i2 == 0) {
            i2 = 1;
        }
        return autoLoadMore(0, i, f2 / ((float) i2), true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoRefresh() {
        int i = this.mAttachedToWindow ? 0 : 400;
        int i2 = this.mReboundDuration;
        int i3 = this.mHeaderHeight;
        float f2 = ((this.mHeaderMaxDragRate / 2.0f) + 0.5f) * ((float) i3) * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoRefresh(i, i2, f2 / ((float) i3), false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoRefreshAnimationOnly() {
        int i = this.mAttachedToWindow ? 0 : 400;
        int i2 = this.mReboundDuration;
        int i3 = this.mHeaderHeight;
        float f2 = ((this.mHeaderMaxDragRate / 2.0f) + 0.5f) * ((float) i3) * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoRefresh(i, i2, f2 / ((float) i3), true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout closeHeaderOrFooter() {
        RefreshState refreshState = this.mState;
        if (refreshState == RefreshState.Refreshing) {
            finishRefresh();
        } else if (refreshState == RefreshState.Loading) {
            finishLoadMore();
        } else if (this.mSpinner != 0) {
            animSpinner(0, 0, this.mReboundInterpolator, this.mReboundDuration);
        }
        return this;
    }

    public void computeScroll() {
        float f2;
        this.mScroller.getCurrY();
        if (this.mScroller.computeScrollOffset()) {
            int finalY = this.mScroller.getFinalY();
            if ((finalY >= 0 || ((!this.mEnableRefresh && !this.mEnableOverScrollDrag) || !this.mRefreshContent.canRefresh())) && (finalY <= 0 || ((!this.mEnableLoadMore && !this.mEnableOverScrollDrag) || !this.mRefreshContent.canLoadMore()))) {
                this.mVerticalPermit = true;
                invalidate();
                return;
            }
            if (this.mVerticalPermit) {
                if (Build.VERSION.SDK_INT >= 14) {
                    f2 = finalY > 0 ? -this.mScroller.getCurrVelocity() : this.mScroller.getCurrVelocity();
                } else {
                    f2 = (((float) (this.mScroller.getCurrY() - finalY)) * 1.0f) / ((float) Math.max(this.mScroller.getDuration() - this.mScroller.timePassed(), 1));
                }
                animSpinnerBounce(f2);
            }
            this.mScroller.forceFinished(true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c6, code lost:
        if (r4.isFinishing == false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ca, code lost:
        if (r4.isHeader == false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00d8, code lost:
        if (r4.isFinishing == false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00dc, code lost:
        if (r4.isFooter == false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0108, code lost:
        if (r6 != 3) goto L_0x0310;
     */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        RefreshState refreshState;
        char c2;
        RefreshInternal refreshInternal;
        RefreshInternal refreshInternal2;
        int actionMasked = motionEvent.getActionMasked();
        int i = 0;
        int i2 = 1;
        boolean z = actionMasked == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                f2 += motionEvent.getX(i3);
                f3 += motionEvent.getY(i3);
            }
        }
        if (z) {
            pointerCount--;
        }
        float f4 = (float) pointerCount;
        float f5 = f2 / f4;
        float f6 = f3 / f4;
        if ((actionMasked == 6 || actionMasked == 5) && this.mIsBeingDragged) {
            this.mTouchY += f6 - this.mLastTouchY;
        }
        this.mLastTouchX = f5;
        this.mLastTouchY = f6;
        if (this.mNestedInProgress) {
            int i4 = this.mTotalUnconsumed;
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (actionMasked == 2 && i4 == this.mTotalUnconsumed) {
                int i5 = (int) this.mLastTouchX;
                int width = getWidth();
                float f7 = this.mLastTouchX;
                if (width != 0) {
                    i2 = width;
                }
                float f8 = f7 / ((float) i2);
                if (isEnableRefreshOrLoadMore(this.mEnableRefresh) && this.mSpinner > 0 && (refreshInternal2 = this.mRefreshHeader) != null && refreshInternal2.isSupportHorizontalDrag()) {
                    this.mRefreshHeader.onHorizontalDrag(f8, i5, width);
                } else if (isEnableRefreshOrLoadMore(this.mEnableLoadMore) && this.mSpinner < 0 && (refreshInternal = this.mRefreshFooter) != null && refreshInternal.isSupportHorizontalDrag()) {
                    this.mRefreshFooter.onHorizontalDrag(f8, i5, width);
                }
            }
            return dispatchTouchEvent;
        }
        if (isEnabled() && (this.mEnableRefresh || this.mEnableLoadMore || this.mEnableOverScrollDrag)) {
            if (this.mHeaderNeedTouchEventWhenRefreshing) {
                RefreshState refreshState2 = this.mState;
                if (!refreshState2.isOpening) {
                }
            }
            if (this.mFooterNeedTouchEventWhenLoading) {
                RefreshState refreshState3 = this.mState;
                if (!refreshState3.isOpening) {
                }
            }
            if (!interceptAnimatorByAction(actionMasked)) {
                RefreshState refreshState4 = this.mState;
                if (!refreshState4.isFinishing && ((refreshState4 != (refreshState = RefreshState.Loading) || !this.mDisableContentWhenLoading) && (refreshState4 != RefreshState.Refreshing || !this.mDisableContentWhenRefresh))) {
                    if (actionMasked != 0) {
                        if (actionMasked != 1) {
                            if (actionMasked == 2) {
                                float f9 = f5 - this.mTouchX;
                                float f10 = f6 - this.mTouchY;
                                this.mVelocityTracker.addMovement(motionEvent);
                                if (!(this.mIsBeingDragged || (c2 = this.mDragDirection) == 'h' || this.mRefreshContent == null)) {
                                    if (c2 == 'v' || (Math.abs(f10) >= ((float) this.mTouchSlop) && Math.abs(f9) < Math.abs(f10))) {
                                        this.mDragDirection = 'v';
                                        if (f10 > 0.0f && (this.mSpinner < 0 || ((this.mEnableOverScrollDrag || this.mEnableRefresh) && this.mRefreshContent.canRefresh()))) {
                                            this.mIsBeingDragged = true;
                                            this.mTouchY = f6 - ((float) this.mTouchSlop);
                                        } else if (f10 < 0.0f && (this.mSpinner > 0 || ((this.mEnableOverScrollDrag || this.mEnableLoadMore) && ((this.mState == refreshState && this.mFooterLocked) || this.mRefreshContent.canLoadMore())))) {
                                            this.mIsBeingDragged = true;
                                            this.mTouchY = ((float) this.mTouchSlop) + f6;
                                        }
                                        if (this.mIsBeingDragged) {
                                            f10 = f6 - this.mTouchY;
                                            if (this.mSuperDispatchTouchEvent) {
                                                motionEvent.setAction(3);
                                                super.dispatchTouchEvent(motionEvent);
                                            }
                                            RefreshKernel refreshKernel = this.mKernel;
                                            int i6 = this.mSpinner;
                                            refreshKernel.setState((i6 > 0 || (i6 == 0 && f10 > 0.0f)) ? RefreshState.PullDownToRefresh : RefreshState.PullUpToLoad);
                                            ViewParent parent = getParent();
                                            if (parent instanceof ViewGroup) {
                                                ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                                            }
                                        }
                                    } else if (Math.abs(f9) >= ((float) this.mTouchSlop) && Math.abs(f9) > Math.abs(f10) && this.mDragDirection != 'v') {
                                        this.mDragDirection = 'h';
                                    }
                                }
                                if (this.mIsBeingDragged) {
                                    int i7 = ((int) f10) + this.mTouchSpinner;
                                    RefreshState refreshState5 = this.mViceState;
                                    if ((refreshState5.isHeader && (i7 < 0 || this.mLastSpinner < 0)) || (refreshState5.isFooter && (i7 > 0 || this.mLastSpinner > 0))) {
                                        this.mLastSpinner = i7;
                                        long eventTime = motionEvent.getEventTime();
                                        if (this.mFalsifyEvent == null) {
                                            MotionEvent obtain = MotionEvent.obtain(eventTime, eventTime, 0, this.mTouchX + f9, this.mTouchY, 0);
                                            this.mFalsifyEvent = obtain;
                                            super.dispatchTouchEvent(obtain);
                                        }
                                        MotionEvent obtain2 = MotionEvent.obtain(eventTime, eventTime, 2, this.mTouchX + f9, this.mTouchY + ((float) i7), 0);
                                        super.dispatchTouchEvent(obtain2);
                                        if (this.mFooterLocked && f10 > ((float) this.mTouchSlop) && this.mSpinner < 0) {
                                            this.mFooterLocked = false;
                                        }
                                        if (i7 > 0 && ((this.mEnableOverScrollDrag || this.mEnableRefresh) && this.mRefreshContent.canRefresh())) {
                                            this.mLastTouchY = f6;
                                            this.mTouchY = f6;
                                            this.mTouchSpinner = 0;
                                            this.mKernel.setState(RefreshState.PullDownToRefresh);
                                        } else if (i7 >= 0 || ((!this.mEnableOverScrollDrag && !this.mEnableLoadMore) || !this.mRefreshContent.canLoadMore())) {
                                            i = i7;
                                        } else {
                                            this.mLastTouchY = f6;
                                            this.mTouchY = f6;
                                            this.mTouchSpinner = 0;
                                            this.mKernel.setState(RefreshState.PullUpToLoad);
                                        }
                                        RefreshState refreshState6 = this.mViceState;
                                        if ((!refreshState6.isHeader || i >= 0) && (!refreshState6.isFooter || i <= 0)) {
                                            if (this.mFalsifyEvent != null) {
                                                this.mFalsifyEvent = null;
                                                obtain2.setAction(3);
                                                super.dispatchTouchEvent(obtain2);
                                            }
                                            obtain2.recycle();
                                            i7 = i;
                                        } else {
                                            if (this.mSpinner != 0) {
                                                moveSpinnerInfinitely(0.0f);
                                            }
                                            return true;
                                        }
                                    }
                                    moveSpinnerInfinitely((float) i7);
                                    return true;
                                } else if (this.mFooterLocked && f10 > ((float) this.mTouchSlop) && this.mSpinner < 0) {
                                    this.mFooterLocked = false;
                                }
                            }
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        this.mVelocityTracker.addMovement(motionEvent);
                        this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                        this.mCurrentVelocity = (int) this.mVelocityTracker.getYVelocity();
                        startFlingIfNeed(0.0f);
                        this.mVelocityTracker.clear();
                        this.mDragDirection = 'n';
                        MotionEvent motionEvent2 = this.mFalsifyEvent;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                            this.mFalsifyEvent = null;
                            long eventTime2 = motionEvent.getEventTime();
                            MotionEvent obtain3 = MotionEvent.obtain(eventTime2, eventTime2, actionMasked, this.mTouchX, f6, 0);
                            super.dispatchTouchEvent(obtain3);
                            obtain3.recycle();
                        }
                        overSpinner();
                        if (this.mIsBeingDragged) {
                            this.mIsBeingDragged = false;
                            return true;
                        }
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    this.mCurrentVelocity = 0;
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mScroller.forceFinished(true);
                    this.mTouchX = f5;
                    this.mTouchY = f6;
                    this.mLastSpinner = 0;
                    this.mTouchSpinner = this.mSpinner;
                    this.mIsBeingDragged = false;
                    this.mSuperDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                    if (this.mState != RefreshState.TwoLevel || this.mTouchY >= ((float) ((getMeasuredHeight() * 5) / 6))) {
                        RefreshContent refreshContent = this.mRefreshContent;
                        if (refreshContent != null) {
                            refreshContent.onActionDown(motionEvent);
                        }
                        return true;
                    }
                    this.mDragDirection = 'h';
                    return this.mSuperDispatchTouchEvent;
                }
            }
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        Paint paint;
        Paint paint2;
        RefreshContent refreshContent = this.mRefreshContent;
        View view2 = refreshContent != null ? refreshContent.getView() : null;
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null && refreshInternal.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableRefresh) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getTop() + view2.getPaddingTop() + this.mSpinner, view.getTop());
                int i = this.mHeaderBackgroundColor;
                if (!(i == 0 || (paint2 = this.mPaint) == null)) {
                    paint2.setColor(i);
                    if (this.mRefreshHeader.getSpinnerStyle().c) {
                        max = view.getBottom();
                    } else if (this.mRefreshHeader.getSpinnerStyle() == gd2.Translate) {
                        max = view.getBottom() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, (float) view.getTop(), (float) getWidth(), (float) max, this.mPaint);
                }
                if (this.mEnableClipHeaderWhenFixedBehind && this.mRefreshHeader.getSpinnerStyle() == gd2.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        RefreshInternal refreshInternal2 = this.mRefreshFooter;
        if (refreshInternal2 != null && refreshInternal2.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableLoadMore) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.mSpinner, view.getBottom());
                int i2 = this.mFooterBackgroundColor;
                if (!(i2 == 0 || (paint = this.mPaint) == null)) {
                    paint.setColor(i2);
                    if (this.mRefreshFooter.getSpinnerStyle().c) {
                        min = view.getTop();
                    } else if (this.mRefreshFooter.getSpinnerStyle() == gd2.Translate) {
                        min = view.getTop() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, (float) min, (float) getWidth(), (float) view.getBottom(), this.mPaint);
                }
                if (this.mEnableClipFooterWhenFixedBehind && this.mRefreshFooter.getSpinnerStyle() == gd2.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMore() {
        return finishLoadMore(true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMoreWithNoMoreData() {
        return finishLoadMore(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefresh() {
        return finishRefresh(true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefreshWithNoMoreData() {
        return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @NonNull
    public ViewGroup getLayout() {
        return this;
    }

    @Override // androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedParent.getNestedScrollAxes();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @Nullable
    public RefreshFooter getRefreshFooter() {
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal instanceof RefreshFooter) {
            return (RefreshFooter) refreshInternal;
        }
        return null;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @Nullable
    public RefreshHeader getRefreshHeader() {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal instanceof RefreshHeader) {
            return (RefreshHeader) refreshInternal;
        }
        return null;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @NonNull
    public RefreshState getState() {
        return this.mState;
    }

    /* access modifiers changed from: protected */
    public boolean interceptAnimatorByAction(int i) {
        if (i == 0) {
            if (this.reboundAnimator != null) {
                RefreshState refreshState = this.mState;
                if (refreshState.isFinishing || refreshState == RefreshState.TwoLevelReleased) {
                    return true;
                }
                if (refreshState == RefreshState.PullDownCanceled) {
                    this.mKernel.setState(RefreshState.PullDownToRefresh);
                } else if (refreshState == RefreshState.PullUpCanceled) {
                    this.mKernel.setState(RefreshState.PullUpToLoad);
                }
                this.reboundAnimator.cancel();
                this.reboundAnimator = null;
            }
            this.animationRunnable = null;
        }
        if (this.reboundAnimator != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isEnableRefreshOrLoadMore(boolean z) {
        return z && !this.mEnablePureScrollMode;
    }

    /* access modifiers changed from: protected */
    public boolean isEnableTranslationContent(boolean z, RefreshInternal refreshInternal) {
        return z || this.mEnablePureScrollMode || refreshInternal == null || refreshInternal.getSpinnerStyle() == gd2.FixedBehind;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mEnableNestedScrolling && (this.mEnableOverScrollDrag || this.mEnableRefresh || this.mEnableLoadMore);
    }

    /* access modifiers changed from: protected */
    public void moveSpinnerInfinitely(float f2) {
        RefreshState refreshState;
        float f3 = (!this.mNestedInProgress || this.mEnableLoadMoreWhenContentNotFull || f2 >= 0.0f || this.mRefreshContent.canLoadMore()) ? f2 : 0.0f;
        if (f3 > ((float) (this.mScreenHeightPixels * 5)) && getTag() == null) {
            Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
            setTag("你这么死拉，臣妾做不到啊！");
        }
        RefreshState refreshState2 = this.mState;
        if (refreshState2 == RefreshState.TwoLevel && f3 > 0.0f) {
            this.mKernel.moveSpinner(Math.min((int) f3, getMeasuredHeight()), true);
        } else if (refreshState2 == RefreshState.Refreshing && f3 >= 0.0f) {
            int i = this.mHeaderHeight;
            if (f3 < ((float) i)) {
                this.mKernel.moveSpinner((int) f3, true);
            } else {
                double d2 = (double) ((this.mHeaderMaxDragRate - 1.0f) * ((float) i));
                int max = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i2 = this.mHeaderHeight;
                double d3 = (double) (max - i2);
                double max2 = (double) Math.max(0.0f, (f3 - ((float) i2)) * this.mDragRate);
                double d4 = -max2;
                if (d3 == 0.0d) {
                    d3 = 1.0d;
                }
                this.mKernel.moveSpinner(((int) Math.min(d2 * (1.0d - Math.pow(100.0d, d4 / d3)), max2)) + this.mHeaderHeight, true);
            }
        } else if (f3 < 0.0f && (refreshState2 == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) {
            int i3 = this.mFooterHeight;
            if (f3 > ((float) (-i3))) {
                this.mKernel.moveSpinner((int) f3, true);
            } else {
                double d5 = (double) ((this.mFooterMaxDragRate - 1.0f) * ((float) i3));
                int max3 = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i4 = this.mFooterHeight;
                double d6 = (double) (max3 - i4);
                double d7 = (double) (-Math.min(0.0f, (((float) i4) + f3) * this.mDragRate));
                double d8 = -d7;
                if (d6 == 0.0d) {
                    d6 = 1.0d;
                }
                this.mKernel.moveSpinner(((int) (-Math.min(d5 * (1.0d - Math.pow(100.0d, d8 / d6)), d7))) - this.mFooterHeight, true);
            }
        } else if (f3 >= 0.0f) {
            double d9 = (double) (this.mHeaderMaxDragRate * ((float) this.mHeaderHeight));
            double max4 = (double) Math.max(this.mScreenHeightPixels / 2, getHeight());
            double max5 = (double) Math.max(0.0f, this.mDragRate * f3);
            double d10 = -max5;
            if (max4 == 0.0d) {
                max4 = 1.0d;
            }
            this.mKernel.moveSpinner((int) Math.min(d9 * (1.0d - Math.pow(100.0d, d10 / max4)), max5), true);
        } else {
            double d11 = (double) (this.mFooterMaxDragRate * ((float) this.mFooterHeight));
            double max6 = (double) Math.max(this.mScreenHeightPixels / 2, getHeight());
            double d12 = (double) (-Math.min(0.0f, this.mDragRate * f3));
            double d13 = -d12;
            if (max6 == 0.0d) {
                max6 = 1.0d;
            }
            this.mKernel.moveSpinner((int) (-Math.min(d11 * (1.0d - Math.pow(100.0d, d13 / max6)), d12)), true);
        }
        if (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && f3 < 0.0f && (refreshState = this.mState) != RefreshState.Refreshing && refreshState != RefreshState.Loading && refreshState != RefreshState.LoadFinish) {
            if (this.mDisableContentWhenLoading) {
                this.animationRunnable = null;
                this.mKernel.animSpinner(-this.mFooterHeight);
            }
            setStateDirectLoading(false);
            this.mHandler.postDelayed(new Runnable() {
                /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass5 */

                public void run() {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    OnLoadMoreListener onLoadMoreListener = smartRefreshLayout.mLoadMoreListener;
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore(smartRefreshLayout);
                    } else if (smartRefreshLayout.mOnMultiPurposeListener == null) {
                        smartRefreshLayout.finishLoadMore(2000);
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout2.mOnMultiPurposeListener;
                    if (onMultiPurposeListener != null) {
                        onMultiPurposeListener.onLoadMore(smartRefreshLayout2);
                    }
                }
            }, (long) this.mReboundDuration);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyStateChanged(RefreshState refreshState) {
        RefreshState refreshState2 = this.mState;
        if (refreshState2 != refreshState) {
            this.mState = refreshState;
            this.mViceState = refreshState;
            RefreshInternal refreshInternal = this.mRefreshHeader;
            RefreshInternal refreshInternal2 = this.mRefreshFooter;
            OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
            if (refreshInternal != null) {
                refreshInternal.onStateChanged(this, refreshState2, refreshState);
            }
            if (refreshInternal2 != null) {
                refreshInternal2.onStateChanged(this, refreshState2, refreshState);
            }
            if (onMultiPurposeListener != null) {
                onMultiPurposeListener.onStateChanged(this, refreshState2, refreshState);
            }
            if (refreshState == RefreshState.LoadFinish) {
                this.mFooterLocked = false;
            }
        } else if (this.mViceState != refreshState2) {
            this.mViceState = refreshState2;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        RefreshInternal refreshInternal;
        super.onAttachedToWindow();
        boolean z = true;
        this.mAttachedToWindow = true;
        if (!isInEditMode()) {
            if (this.mRefreshHeader == null) {
                DefaultRefreshHeaderCreator defaultRefreshHeaderCreator = sHeaderCreator;
                if (defaultRefreshHeaderCreator != null) {
                    setRefreshHeader(defaultRefreshHeaderCreator.createRefreshHeader(getContext(), this));
                } else {
                    setRefreshHeader(new BezierRadarHeader(getContext()));
                }
            }
            if (this.mRefreshFooter == null) {
                DefaultRefreshFooterCreator defaultRefreshFooterCreator = sFooterCreator;
                if (defaultRefreshFooterCreator != null) {
                    setRefreshFooter(defaultRefreshFooterCreator.createRefreshFooter(getContext(), this));
                } else {
                    boolean z2 = this.mEnableLoadMore;
                    setRefreshFooter(new BallPulseFooter(getContext()));
                    this.mEnableLoadMore = z2;
                }
            } else {
                if (!this.mEnableLoadMore && this.mManualLoadMore) {
                    z = false;
                }
                this.mEnableLoadMore = z;
            }
            if (this.mRefreshContent == null) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    RefreshInternal refreshInternal2 = this.mRefreshHeader;
                    if ((refreshInternal2 == null || childAt != refreshInternal2.getView()) && ((refreshInternal = this.mRefreshFooter) == null || childAt != refreshInternal.getView())) {
                        this.mRefreshContent = new jz1(childAt);
                    }
                }
            }
            if (this.mRefreshContent == null) {
                int dp2px = cc2.dp2px(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R$string.srl_content_empty);
                super.addView(textView, 0, new LayoutParams(-1, -1));
                jz1 jz1 = new jz1(textView);
                this.mRefreshContent = jz1;
                jz1.getView().setPadding(dp2px, dp2px, dp2px, dp2px);
            }
            View findViewById = findViewById(this.mFixedHeaderViewId);
            View findViewById2 = findViewById(this.mFixedFooterViewId);
            this.mRefreshContent.setScrollBoundaryDecider(this.mScrollBoundaryDecider);
            this.mRefreshContent.setEnableLoadMoreWhenContentNotFull(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.setUpComponent(this.mKernel, findViewById, findViewById2);
            if (this.mSpinner != 0) {
                notifyStateChanged(RefreshState.None);
                RefreshContent refreshContent = this.mRefreshContent;
                this.mSpinner = 0;
                refreshContent.moveSpinner(0, this.mHeaderTranslationViewId, this.mFooterTranslationViewId);
            }
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null) {
            RefreshInternal refreshInternal3 = this.mRefreshHeader;
            if (refreshInternal3 != null) {
                refreshInternal3.setPrimaryColors(iArr);
            }
            RefreshInternal refreshInternal4 = this.mRefreshFooter;
            if (refreshInternal4 != null) {
                refreshInternal4.setPrimaryColors(this.mPrimaryColors);
            }
        }
        RefreshContent refreshContent2 = this.mRefreshContent;
        if (refreshContent2 != null) {
            super.bringChildToFront(refreshContent2.getView());
        }
        RefreshInternal refreshInternal5 = this.mRefreshHeader;
        if (refreshInternal5 != null && refreshInternal5.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        RefreshInternal refreshInternal6 = this.mRefreshFooter;
        if (refreshInternal6 != null && refreshInternal6.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshFooter.getView());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedToWindow = false;
        this.mKernel.moveSpinner(0, true);
        notifyStateChanged(RefreshState.None);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mManualLoadMore = true;
        this.animationRunnable = null;
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.reboundAnimator.removeAllUpdateListeners();
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        this.mFooterLocked = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0052  */
    public void onFinishInflate() {
        int i;
        int i2;
        int i3;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount <= 3) {
            int i4 = 0;
            int i5 = -1;
            char c2 = 0;
            while (true) {
                i = 2;
                if (i4 >= childCount) {
                    break;
                }
                View childAt = super.getChildAt(i4);
                if (cc2.isContentView(childAt) && (c2 < 2 || i4 == 1)) {
                    i5 = i4;
                    c2 = 2;
                } else if (!(childAt instanceof RefreshInternal) && c2 < 1) {
                    c2 = i4 > 0 ? (char) 1 : 0;
                    i5 = i4;
                }
                i4++;
            }
            if (i5 >= 0) {
                this.mRefreshContent = new jz1(super.getChildAt(i5));
                if (i5 == 1) {
                    if (childCount == 3) {
                        i2 = 0;
                    } else {
                        i2 = 0;
                        i = -1;
                    }
                } else if (childCount == 2) {
                    i2 = -1;
                    i = 1;
                }
                for (i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = super.getChildAt(i3);
                    if (i3 == i2 || (i3 != i && i2 == -1 && this.mRefreshHeader == null && (childAt2 instanceof RefreshHeader))) {
                        this.mRefreshHeader = childAt2 instanceof RefreshHeader ? (RefreshHeader) childAt2 : new RefreshHeaderWrapper(childAt2);
                    } else if (i3 == i || (i == -1 && (childAt2 instanceof RefreshFooter))) {
                        this.mEnableLoadMore = this.mEnableLoadMore || !this.mManualLoadMore;
                        this.mRefreshFooter = childAt2 instanceof RefreshFooter ? (RefreshFooter) childAt2 : new RefreshFooterWrapper(childAt2);
                    }
                }
                return;
            }
            i2 = -1;
            i = -1;
            while (i3 < childCount) {
            }
            return;
        }
        throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = super.getChildAt(i6);
            if (!(childAt.getVisibility() == 8 || childAt.getTag(R$string.srl_component_falsify) == childAt)) {
                RefreshContent refreshContent = this.mRefreshContent;
                boolean z2 = true;
                if (refreshContent != null && refreshContent.getView() == childAt) {
                    boolean z3 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh) && this.mRefreshHeader != null;
                    View view = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int i7 = marginLayoutParams.leftMargin + paddingLeft;
                    int i8 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i7;
                    int measuredHeight = view.getMeasuredHeight() + i8;
                    if (z3 && isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader)) {
                        int i9 = this.mHeaderHeight;
                        i8 += i9;
                        measuredHeight += i9;
                    }
                    view.layout(i7, i8, measuredWidth, measuredHeight);
                }
                RefreshInternal refreshInternal = this.mRefreshHeader;
                if (refreshInternal != null && refreshInternal.getView() == childAt) {
                    boolean z4 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh);
                    View view2 = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : sDefaultMarginLP;
                    int i10 = marginLayoutParams2.leftMargin;
                    int i11 = marginLayoutParams2.topMargin + this.mHeaderInsetStart;
                    int measuredWidth2 = view2.getMeasuredWidth() + i10;
                    int measuredHeight2 = view2.getMeasuredHeight() + i11;
                    if (!z4 && this.mRefreshHeader.getSpinnerStyle() == gd2.Translate) {
                        int i12 = this.mHeaderHeight;
                        i11 -= i12;
                        measuredHeight2 -= i12;
                    }
                    view2.layout(i10, i11, measuredWidth2, measuredHeight2);
                }
                RefreshInternal refreshInternal2 = this.mRefreshFooter;
                if (refreshInternal2 != null && refreshInternal2.getView() == childAt) {
                    if (!isInEditMode() || !this.mEnablePreviewInEditMode || !isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                        z2 = false;
                    }
                    View view3 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : sDefaultMarginLP;
                    gd2 spinnerStyle = this.mRefreshFooter.getSpinnerStyle();
                    int i13 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (marginLayoutParams3.topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                    if (this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && this.mEnableFooterFollowWhenNoMoreData && this.mRefreshContent != null && this.mRefreshFooter.getSpinnerStyle() == gd2.Translate && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                        View view4 = this.mRefreshContent.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == gd2.MatchLayout) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.mFooterInsetStart;
                    } else {
                        if (z2 || spinnerStyle == gd2.FixedFront || spinnerStyle == gd2.FixedBehind) {
                            i5 = this.mFooterHeight;
                        } else if (spinnerStyle.c && this.mSpinner < 0) {
                            i5 = Math.max(isEnableRefreshOrLoadMore(this.mEnableLoadMore) ? -this.mSpinner : 0, 0);
                        }
                        measuredHeight3 -= i5;
                    }
                    view3.layout(i13, measuredHeight3, view3.getMeasuredWidth() + i13, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01ec  */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        n70 n70;
        int i5;
        int i6;
        boolean z = isInEditMode() && this.mEnablePreviewInEditMode;
        int childCount = super.getChildCount();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = super.getChildAt(i8);
            if (childAt.getVisibility() != 8 && childAt.getTag(R$string.srl_component_falsify) != childAt) {
                RefreshInternal refreshInternal = this.mRefreshHeader;
                if (refreshInternal != null && refreshInternal.getView() == childAt) {
                    View view = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, layoutParams.width);
                    int i9 = this.mHeaderHeight;
                    n70 n702 = this.mHeaderHeightStatus;
                    if (n702.a < n70.XmlLayoutUnNotify.a) {
                        int i10 = layoutParams.height;
                        if (i10 > 0) {
                            int i11 = i10 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                            n70 n703 = n70.XmlExactUnNotify;
                            if (n702.a(n703)) {
                                this.mHeaderHeight = layoutParams.height + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                this.mHeaderHeightStatus = n703;
                            }
                            i9 = i11;
                        } else if (i10 == -2 && (this.mRefreshHeader.getSpinnerStyle() != gd2.MatchLayout || !this.mHeaderHeightStatus.b)) {
                            int max = Math.max((View.MeasureSpec.getSize(i2) - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0);
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE));
                            int measuredHeight = view.getMeasuredHeight();
                            if (measuredHeight > 0) {
                                if (measuredHeight != max) {
                                    n70 n704 = this.mHeaderHeightStatus;
                                    n70 n705 = n70.XmlWrapUnNotify;
                                    if (n704.a(n705)) {
                                        this.mHeaderHeight = measuredHeight + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                        this.mHeaderHeightStatus = n705;
                                    }
                                }
                                i9 = -1;
                            }
                        }
                    }
                    if (this.mRefreshHeader.getSpinnerStyle() == gd2.MatchLayout) {
                        i9 = View.MeasureSpec.getSize(i2);
                        i6 = -1;
                        i5 = 0;
                    } else {
                        if (!this.mRefreshHeader.getSpinnerStyle().c || z) {
                            i5 = 0;
                        } else {
                            i5 = 0;
                            i9 = Math.max(0, isEnableRefreshOrLoadMore(this.mEnableRefresh) ? this.mSpinner : 0);
                        }
                        i6 = -1;
                    }
                    if (i9 != i6) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((i9 - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, i5), 1073741824));
                    }
                    n70 n706 = this.mHeaderHeightStatus;
                    if (!n706.b) {
                        this.mHeaderHeightStatus = n706.b();
                        RefreshInternal refreshInternal2 = this.mRefreshHeader;
                        RefreshKernel refreshKernel = this.mKernel;
                        int i12 = this.mHeaderHeight;
                        refreshInternal2.onInitialized(refreshKernel, i12, (int) (this.mHeaderMaxDragRate * ((float) i12)));
                    }
                    if (z && isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
                        i7 += view.getMeasuredHeight();
                    }
                }
                RefreshInternal refreshInternal3 = this.mRefreshFooter;
                if (refreshInternal3 != null && refreshInternal3.getView() == childAt) {
                    View view2 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : sDefaultMarginLP;
                    int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, layoutParams2.width);
                    int i13 = this.mFooterHeight;
                    n70 n707 = this.mFooterHeightStatus;
                    if (n707.a < n70.XmlLayoutUnNotify.a) {
                        int i14 = layoutParams2.height;
                        if (i14 > 0) {
                            i13 = marginLayoutParams2.bottomMargin + i14 + marginLayoutParams2.topMargin;
                            n70 n708 = n70.XmlExactUnNotify;
                            if (n707.a(n708)) {
                                this.mFooterHeight = layoutParams2.height + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                this.mFooterHeightStatus = n708;
                            }
                        } else if (i14 == -2 && (this.mRefreshFooter.getSpinnerStyle() != gd2.MatchLayout || !this.mFooterHeightStatus.b)) {
                            int max2 = Math.max((View.MeasureSpec.getSize(i2) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0);
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(max2, Integer.MIN_VALUE));
                            int measuredHeight2 = view2.getMeasuredHeight();
                            if (measuredHeight2 > 0) {
                                if (measuredHeight2 != max2) {
                                    n70 n709 = this.mFooterHeightStatus;
                                    n70 n7010 = n70.XmlWrapUnNotify;
                                    if (n709.a(n7010)) {
                                        this.mFooterHeight = measuredHeight2 + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                        this.mFooterHeightStatus = n7010;
                                    }
                                }
                                i3 = -1;
                                if (this.mRefreshFooter.getSpinnerStyle() != gd2.MatchLayout) {
                                    i3 = View.MeasureSpec.getSize(i2);
                                } else if (this.mRefreshFooter.getSpinnerStyle().c && !z) {
                                    i4 = 0;
                                    i3 = Math.max(0, isEnableRefreshOrLoadMore(this.mEnableLoadMore) ? -this.mSpinner : 0);
                                    if (i3 != -1) {
                                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((i3 - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, i4), 1073741824));
                                    }
                                    n70 = this.mFooterHeightStatus;
                                    if (!n70.b) {
                                        this.mFooterHeightStatus = n70.b();
                                        RefreshInternal refreshInternal4 = this.mRefreshFooter;
                                        RefreshKernel refreshKernel2 = this.mKernel;
                                        int i15 = this.mFooterHeight;
                                        refreshInternal4.onInitialized(refreshKernel2, i15, (int) (this.mFooterMaxDragRate * ((float) i15)));
                                    }
                                    if (z && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                                        i7 += view2.getMeasuredHeight();
                                    }
                                }
                                i4 = 0;
                                if (i3 != -1) {
                                }
                                n70 = this.mFooterHeightStatus;
                                if (!n70.b) {
                                }
                                i7 += view2.getMeasuredHeight();
                            }
                        }
                    }
                    i3 = i13;
                    if (this.mRefreshFooter.getSpinnerStyle() != gd2.MatchLayout) {
                    }
                    i4 = 0;
                    if (i3 != -1) {
                    }
                    n70 = this.mFooterHeightStatus;
                    if (!n70.b) {
                    }
                    i7 += view2.getMeasuredHeight();
                }
                RefreshContent refreshContent = this.mRefreshContent;
                if (refreshContent != null && refreshContent.getView() == childAt) {
                    View view3 = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : sDefaultMarginLP;
                    view3.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin, layoutParams3.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin + ((!z || !(this.mRefreshHeader != null && isEnableRefreshOrLoadMore(this.mEnableRefresh) && isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader))) ? 0 : this.mHeaderHeight) + ((!z || !(this.mRefreshFooter != null && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && isEnableTranslationContent(this.mEnableFooterTranslationContent, this.mRefreshFooter))) ? 0 : this.mFooterHeight), layoutParams3.height));
                    i7 += view3.getMeasuredHeight();
                }
            }
        }
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), View.resolveSize(i7, i2));
        this.mLastTouchX = ((float) getMeasuredWidth()) / 2.0f;
    }

    @Override // androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f2, float f3, boolean z) {
        return this.mNestedChild.dispatchNestedFling(f2, f3, z);
    }

    @Override // androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f2, float f3) {
        return (this.mFooterLocked && f3 > 0.0f) || startFlingIfNeed(-f3) || this.mNestedChild.dispatchNestedPreFling(f2, f3);
    }

    @Override // androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr) {
        int i3 = this.mTotalUnconsumed;
        int i4 = 0;
        if (i2 * i3 > 0) {
            if (Math.abs(i2) > Math.abs(this.mTotalUnconsumed)) {
                int i5 = this.mTotalUnconsumed;
                this.mTotalUnconsumed = 0;
                i4 = i5;
            } else {
                this.mTotalUnconsumed -= i2;
                i4 = i2;
            }
            moveSpinnerInfinitely((float) this.mTotalUnconsumed);
        } else if (i2 > 0 && this.mFooterLocked) {
            int i6 = i3 - i2;
            this.mTotalUnconsumed = i6;
            moveSpinnerInfinitely((float) i6);
            i4 = i2;
        }
        this.mNestedChild.dispatchNestedPreScroll(i, i2 - i4, iArr, null);
        iArr[1] = iArr[1] + i4;
    }

    @Override // androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4) {
        ScrollBoundaryDecider scrollBoundaryDecider;
        ScrollBoundaryDecider scrollBoundaryDecider2;
        boolean dispatchNestedScroll = this.mNestedChild.dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        int i5 = i4 + this.mParentOffsetInWindow[1];
        if ((i5 < 0 && ((this.mEnableRefresh || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (scrollBoundaryDecider2 = this.mScrollBoundaryDecider) == null || scrollBoundaryDecider2.canRefresh(this.mRefreshContent.getView())))) || (i5 > 0 && ((this.mEnableLoadMore || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (scrollBoundaryDecider = this.mScrollBoundaryDecider) == null || scrollBoundaryDecider.canLoadMore(this.mRefreshContent.getView()))))) {
            RefreshState refreshState = this.mViceState;
            if (refreshState == RefreshState.None || refreshState.isOpening) {
                this.mKernel.setState(i5 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
                if (!dispatchNestedScroll) {
                    ViewParent parent = getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            int i6 = this.mTotalUnconsumed - i5;
            this.mTotalUnconsumed = i6;
            moveSpinnerInfinitely((float) i6);
        }
        if (this.mFooterLocked && i2 < 0) {
            this.mFooterLocked = false;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i) {
        this.mNestedParent.onNestedScrollAccepted(view, view2, i);
        this.mNestedChild.startNestedScroll(i & 2);
        this.mTotalUnconsumed = this.mSpinner;
        this.mNestedInProgress = true;
        interceptAnimatorByAction(0);
    }

    @Override // androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i) {
        if (!(isEnabled() && isNestedScrollingEnabled() && (i & 2) != 0) || (!this.mEnableOverScrollDrag && !this.mEnableRefresh && !this.mEnableLoadMore)) {
            return false;
        }
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.mNestedParent.onStopNestedScroll(view);
        this.mNestedInProgress = false;
        this.mTotalUnconsumed = 0;
        overSpinner();
        this.mNestedChild.stopNestedScroll();
    }

    /* access modifiers changed from: protected */
    public void overSpinner() {
        RefreshState refreshState = this.mState;
        if (refreshState != RefreshState.TwoLevel) {
            RefreshState refreshState2 = RefreshState.Loading;
            if (refreshState == refreshState2 || (this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && this.mSpinner < 0 && isEnableRefreshOrLoadMore(this.mEnableLoadMore))) {
                int i = this.mSpinner;
                int i2 = this.mFooterHeight;
                if (i < (-i2)) {
                    this.mKernel.animSpinner(-i2);
                } else if (i > 0) {
                    this.mKernel.animSpinner(0);
                }
            } else {
                RefreshState refreshState3 = this.mState;
                RefreshState refreshState4 = RefreshState.Refreshing;
                if (refreshState3 == refreshState4) {
                    int i3 = this.mSpinner;
                    int i4 = this.mHeaderHeight;
                    if (i3 > i4) {
                        this.mKernel.animSpinner(i4);
                    } else if (i3 < 0) {
                        this.mKernel.animSpinner(0);
                    }
                } else if (refreshState3 == RefreshState.PullDownToRefresh) {
                    this.mKernel.setState(RefreshState.PullDownCanceled);
                } else if (refreshState3 == RefreshState.PullUpToLoad) {
                    this.mKernel.setState(RefreshState.PullUpCanceled);
                } else if (refreshState3 == RefreshState.ReleaseToRefresh) {
                    this.mKernel.setState(refreshState4);
                } else if (refreshState3 == RefreshState.ReleaseToLoad) {
                    this.mKernel.setState(refreshState2);
                } else if (refreshState3 == RefreshState.ReleaseToTwoLevel) {
                    this.mKernel.setState(RefreshState.TwoLevelReleased);
                } else if (refreshState3 == RefreshState.RefreshReleased) {
                    if (this.reboundAnimator == null) {
                        this.mKernel.animSpinner(this.mHeaderHeight);
                    }
                } else if (refreshState3 == RefreshState.LoadReleased) {
                    if (this.reboundAnimator == null) {
                        this.mKernel.animSpinner(-this.mFooterHeight);
                    }
                } else if (this.mSpinner != 0) {
                    this.mKernel.animSpinner(0);
                }
            }
        } else if (this.mCurrentVelocity > -1000 && this.mSpinner > getMeasuredHeight() / 2) {
            ValueAnimator animSpinner = this.mKernel.animSpinner(getMeasuredHeight());
            if (animSpinner != null) {
                animSpinner.setDuration((long) this.mFloorDuration);
            }
        } else if (this.mIsBeingDragged) {
            this.mKernel.finishTwoLevel();
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout resetNoMoreData() {
        return setNoMoreData(false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setDisableContentWhenLoading(boolean z) {
        this.mDisableContentWhenLoading = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setDisableContentWhenRefresh(boolean z) {
        this.mDisableContentWhenRefresh = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setDragRate(float f2) {
        this.mDragRate = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableAutoLoadMore(boolean z) {
        this.mEnableAutoLoadMore = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableClipFooterWhenFixedBehind(boolean z) {
        this.mEnableClipFooterWhenFixedBehind = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableClipHeaderWhenFixedBehind(boolean z) {
        this.mEnableClipHeaderWhenFixedBehind = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @Deprecated
    public RefreshLayout setEnableFooterFollowWhenLoadFinished(boolean z) {
        this.mEnableFooterFollowWhenNoMoreData = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableFooterFollowWhenNoMoreData(boolean z) {
        this.mEnableFooterFollowWhenNoMoreData = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableFooterTranslationContent(boolean z) {
        this.mEnableFooterTranslationContent = z;
        this.mManualFooterTranslationContent = true;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableHeaderTranslationContent(boolean z) {
        this.mEnableHeaderTranslationContent = z;
        this.mManualHeaderTranslationContent = true;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableLoadMore(boolean z) {
        this.mManualLoadMore = true;
        this.mEnableLoadMore = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableLoadMoreWhenContentNotFull(boolean z) {
        this.mEnableLoadMoreWhenContentNotFull = z;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            refreshContent.setEnableLoadMoreWhenContentNotFull(z);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableNestedScroll(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableOverScrollBounce(boolean z) {
        this.mEnableOverScrollBounce = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableOverScrollDrag(boolean z) {
        this.mEnableOverScrollDrag = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnablePureScrollMode(boolean z) {
        this.mEnablePureScrollMode = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableRefresh(boolean z) {
        this.mEnableRefresh = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableScrollContentWhenLoaded(boolean z) {
        this.mEnableScrollContentWhenLoaded = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableScrollContentWhenRefreshed(boolean z) {
        this.mEnableScrollContentWhenRefreshed = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setFooterHeight(float f2) {
        int dp2px = cc2.dp2px(f2);
        if (dp2px == this.mFooterHeight) {
            return this;
        }
        n70 n70 = this.mFooterHeightStatus;
        n70 n702 = n70.CodeExact;
        if (n70.a(n702)) {
            this.mFooterHeight = dp2px;
            RefreshInternal refreshInternal = this.mRefreshFooter;
            if (refreshInternal == null || !this.mAttachedToWindow || !this.mFooterHeightStatus.b) {
                this.mFooterHeightStatus = n70.CodeExactUnNotify;
            } else {
                gd2 spinnerStyle = refreshInternal.getSpinnerStyle();
                if (spinnerStyle != gd2.MatchLayout && !spinnerStyle.c) {
                    View view = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int i = 0;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.mFooterHeight - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i2 = marginLayoutParams.leftMargin;
                    int measuredHeight = (marginLayoutParams.topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                    if (spinnerStyle != gd2.Translate) {
                        i = this.mFooterHeight;
                    }
                    int i3 = measuredHeight - i;
                    view.layout(i2, i3, view.getMeasuredWidth() + i2, view.getMeasuredHeight() + i3);
                }
                this.mFooterHeightStatus = n702;
                RefreshInternal refreshInternal2 = this.mRefreshFooter;
                RefreshKernel refreshKernel = this.mKernel;
                int i4 = this.mFooterHeight;
                refreshInternal2.onInitialized(refreshKernel, i4, (int) (this.mFooterMaxDragRate * ((float) i4)));
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setFooterInsetStart(float f2) {
        this.mFooterInsetStart = cc2.dp2px(f2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setFooterMaxDragRate(float f2) {
        this.mFooterMaxDragRate = f2;
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal == null || !this.mAttachedToWindow) {
            this.mFooterHeightStatus = this.mFooterHeightStatus.c();
        } else {
            RefreshKernel refreshKernel = this.mKernel;
            int i = this.mFooterHeight;
            refreshInternal.onInitialized(refreshKernel, i, (int) (((float) i) * f2));
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setFooterTriggerRate(float f2) {
        this.mFooterTriggerRate = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setHeaderHeight(float f2) {
        int dp2px = cc2.dp2px(f2);
        if (dp2px == this.mHeaderHeight) {
            return this;
        }
        n70 n70 = this.mHeaderHeightStatus;
        n70 n702 = n70.CodeExact;
        if (n70.a(n702)) {
            this.mHeaderHeight = dp2px;
            RefreshInternal refreshInternal = this.mRefreshHeader;
            if (refreshInternal == null || !this.mAttachedToWindow || !this.mHeaderHeightStatus.b) {
                this.mHeaderHeightStatus = n70.CodeExactUnNotify;
            } else {
                gd2 spinnerStyle = refreshInternal.getSpinnerStyle();
                if (spinnerStyle != gd2.MatchLayout && !spinnerStyle.c) {
                    View view = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int i = 0;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.mHeaderHeight - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i2 = marginLayoutParams.leftMargin;
                    int i3 = marginLayoutParams.topMargin + this.mHeaderInsetStart;
                    if (spinnerStyle == gd2.Translate) {
                        i = this.mHeaderHeight;
                    }
                    int i4 = i3 - i;
                    view.layout(i2, i4, view.getMeasuredWidth() + i2, view.getMeasuredHeight() + i4);
                }
                this.mHeaderHeightStatus = n702;
                RefreshInternal refreshInternal2 = this.mRefreshHeader;
                RefreshKernel refreshKernel = this.mKernel;
                int i5 = this.mHeaderHeight;
                refreshInternal2.onInitialized(refreshKernel, i5, (int) (this.mHeaderMaxDragRate * ((float) i5)));
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setHeaderInsetStart(float f2) {
        this.mHeaderInsetStart = cc2.dp2px(f2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setHeaderMaxDragRate(float f2) {
        this.mHeaderMaxDragRate = f2;
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal == null || !this.mAttachedToWindow) {
            this.mHeaderHeightStatus = this.mHeaderHeightStatus.c();
        } else {
            RefreshKernel refreshKernel = this.mKernel;
            int i = this.mHeaderHeight;
            refreshInternal.onInitialized(refreshKernel, i, (int) (f2 * ((float) i)));
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setHeaderTriggerRate(float f2) {
        this.mHeaderTriggerRate = f2;
        return this;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.mEnableNestedScrolling = z;
        this.mNestedChild.setNestedScrollingEnabled(z);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setNoMoreData(boolean z) {
        if (this.mState != RefreshState.Loading || !z) {
            if (this.mFooterNoMoreData != z) {
                this.mFooterNoMoreData = z;
                RefreshInternal refreshInternal = this.mRefreshFooter;
                if (refreshInternal instanceof RefreshFooter) {
                    if (((RefreshFooter) refreshInternal).setNoMoreData(z)) {
                        this.mFooterNoMoreDataEffective = true;
                        if (this.mFooterNoMoreData && this.mEnableFooterFollowWhenNoMoreData && this.mSpinner > 0 && this.mRefreshFooter.getSpinnerStyle() == gd2.Translate && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && isEnableTranslationContent(this.mEnableRefresh, this.mRefreshHeader)) {
                            this.mRefreshFooter.getView().setTranslationY((float) this.mSpinner);
                        }
                    } else {
                        this.mFooterNoMoreDataEffective = false;
                        new RuntimeException("Footer:" + this.mRefreshFooter + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                    }
                }
            }
            return this;
        }
        finishLoadMoreWithNoMoreData();
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.mLoadMoreListener = onLoadMoreListener;
        this.mEnableLoadMore = this.mEnableLoadMore || (!this.mManualLoadMore && onLoadMoreListener != null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setOnMultiPurposeListener(OnMultiPurposeListener onMultiPurposeListener) {
        this.mOnMultiPurposeListener = onMultiPurposeListener;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setOnRefreshLoadMoreListener(OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
        this.mRefreshListener = onRefreshLoadMoreListener;
        this.mLoadMoreListener = onRefreshLoadMoreListener;
        this.mEnableLoadMore = this.mEnableLoadMore || (!this.mManualLoadMore && onRefreshLoadMoreListener != null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setPrimaryColors(@ColorInt int... iArr) {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null) {
            refreshInternal.setPrimaryColors(iArr);
        }
        RefreshInternal refreshInternal2 = this.mRefreshFooter;
        if (refreshInternal2 != null) {
            refreshInternal2.setPrimaryColors(iArr);
        }
        this.mPrimaryColors = iArr;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setPrimaryColorsId(@ColorRes int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.getColor(getContext(), iArr[i]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setReboundDuration(int i) {
        this.mReboundDuration = i;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setReboundInterpolator(@NonNull Interpolator interpolator) {
        this.mReboundInterpolator = interpolator;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshContent(@NonNull View view) {
        return setRefreshContent(view, -1, -1);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshFooter(@NonNull RefreshFooter refreshFooter) {
        return setRefreshFooter(refreshFooter, -1, -2);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshHeader(@NonNull RefreshHeader refreshHeader) {
        return setRefreshHeader(refreshHeader, -1, -2);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setScrollBoundaryDecider(ScrollBoundaryDecider scrollBoundaryDecider) {
        this.mScrollBoundaryDecider = scrollBoundaryDecider;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            refreshContent.setScrollBoundaryDecider(scrollBoundaryDecider);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void setStateDirectLoading(boolean z) {
        RefreshState refreshState = this.mState;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.mLastOpenTime = System.currentTimeMillis();
            this.mFooterLocked = true;
            notifyStateChanged(refreshState2);
            OnLoadMoreListener onLoadMoreListener = this.mLoadMoreListener;
            if (onLoadMoreListener != null) {
                if (z) {
                    onLoadMoreListener.onLoadMore(this);
                }
            } else if (this.mOnMultiPurposeListener == null) {
                finishLoadMore(2000);
            }
            RefreshInternal refreshInternal = this.mRefreshFooter;
            if (refreshInternal != null) {
                int i = this.mFooterHeight;
                refreshInternal.onStartAnimator(this, i, (int) (this.mFooterMaxDragRate * ((float) i)));
            }
            OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
            if (onMultiPurposeListener != null && (this.mRefreshFooter instanceof RefreshFooter)) {
                if (z) {
                    onMultiPurposeListener.onLoadMore(this);
                }
                int i2 = this.mFooterHeight;
                this.mOnMultiPurposeListener.onFooterStartAnimator((RefreshFooter) this.mRefreshFooter, i2, (int) (this.mFooterMaxDragRate * ((float) i2)));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setStateLoading(boolean z) {
        b bVar = new b(z);
        notifyStateChanged(RefreshState.LoadReleased);
        ValueAnimator animSpinner = this.mKernel.animSpinner(-this.mFooterHeight);
        if (animSpinner != null) {
            animSpinner.addListener(bVar);
        }
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal != null) {
            int i = this.mFooterHeight;
            refreshInternal.onReleased(this, i, (int) (this.mFooterMaxDragRate * ((float) i)));
        }
        OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
        if (onMultiPurposeListener != null) {
            RefreshInternal refreshInternal2 = this.mRefreshFooter;
            if (refreshInternal2 instanceof RefreshFooter) {
                int i2 = this.mFooterHeight;
                onMultiPurposeListener.onFooterReleased((RefreshFooter) refreshInternal2, i2, (int) (this.mFooterMaxDragRate * ((float) i2)));
            }
        }
        if (animSpinner == null) {
            bVar.onAnimationEnd(null);
        }
    }

    /* access modifiers changed from: protected */
    public void setStateRefreshing(boolean z) {
        c cVar = new c(z);
        notifyStateChanged(RefreshState.RefreshReleased);
        ValueAnimator animSpinner = this.mKernel.animSpinner(this.mHeaderHeight);
        if (animSpinner != null) {
            animSpinner.addListener(cVar);
        }
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null) {
            int i = this.mHeaderHeight;
            refreshInternal.onReleased(this, i, (int) (this.mHeaderMaxDragRate * ((float) i)));
        }
        OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
        if (onMultiPurposeListener != null) {
            RefreshInternal refreshInternal2 = this.mRefreshHeader;
            if (refreshInternal2 instanceof RefreshHeader) {
                int i2 = this.mHeaderHeight;
                onMultiPurposeListener.onHeaderReleased((RefreshHeader) refreshInternal2, i2, (int) (this.mHeaderMaxDragRate * ((float) i2)));
            }
        }
        if (animSpinner == null) {
            cVar.onAnimationEnd(null);
        }
    }

    /* access modifiers changed from: protected */
    public void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.mState;
        if (refreshState2.isDragging && refreshState2.isHeader != refreshState.isHeader) {
            notifyStateChanged(RefreshState.None);
        }
        if (this.mViceState != refreshState) {
            this.mViceState = refreshState;
        }
    }

    /* access modifiers changed from: protected */
    public boolean startFlingIfNeed(float f2) {
        if (f2 == 0.0f) {
            f2 = (float) this.mCurrentVelocity;
        }
        if (Build.VERSION.SDK_INT > 27 && this.mRefreshContent != null) {
            getScaleY();
            View view = this.mRefreshContent.getView();
            if (getScaleY() == -1.0f && view.getScaleY() == -1.0f) {
                f2 = -f2;
            }
        }
        if (Math.abs(f2) > ((float) this.mMinimumVelocity)) {
            int i = this.mSpinner;
            if (((float) i) * f2 < 0.0f) {
                RefreshState refreshState = this.mState;
                if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.Loading || (i < 0 && this.mFooterNoMoreData)) {
                    this.animationRunnable = new FlingRunnable(f2).start();
                    return true;
                } else if (refreshState.isReleaseToOpening) {
                    return true;
                }
            }
            if ((f2 < 0.0f && ((this.mEnableOverScrollBounce && (this.mEnableLoadMore || this.mEnableOverScrollDrag)) || ((this.mState == RefreshState.Loading && i >= 0) || (this.mEnableAutoLoadMore && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) || (f2 > 0.0f && ((this.mEnableOverScrollBounce && this.mEnableRefresh) || this.mEnableOverScrollDrag || (this.mState == RefreshState.Refreshing && this.mSpinner <= 0)))) {
                this.mVerticalPermit = false;
                this.mScroller.fling(0, 0, 0, (int) (-f2), 0, 0, StandOutWindow.StandOutLayoutParams.AUTO_POSITION, Integer.MAX_VALUE);
                this.mScroller.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFloorDuration = 300;
        this.mReboundDuration = 300;
        this.mDragRate = 0.5f;
        this.mDragDirection = 'n';
        this.mFixedHeaderViewId = -1;
        this.mFixedFooterViewId = -1;
        this.mHeaderTranslationViewId = -1;
        this.mFooterTranslationViewId = -1;
        this.mEnableRefresh = true;
        this.mEnableLoadMore = false;
        this.mEnableClipHeaderWhenFixedBehind = true;
        this.mEnableClipFooterWhenFixedBehind = true;
        this.mEnableHeaderTranslationContent = true;
        this.mEnableFooterTranslationContent = true;
        this.mEnableFooterFollowWhenNoMoreData = false;
        this.mEnablePreviewInEditMode = true;
        this.mEnableOverScrollBounce = true;
        this.mEnableOverScrollDrag = false;
        this.mEnableAutoLoadMore = true;
        this.mEnablePureScrollMode = false;
        this.mEnableScrollContentWhenLoaded = true;
        this.mEnableScrollContentWhenRefreshed = true;
        this.mEnableLoadMoreWhenContentNotFull = true;
        this.mEnableNestedScrolling = true;
        this.mDisableContentWhenRefresh = false;
        this.mDisableContentWhenLoading = false;
        this.mFooterNoMoreData = false;
        this.mFooterNoMoreDataEffective = false;
        this.mManualLoadMore = false;
        this.mManualHeaderTranslationContent = false;
        this.mManualFooterTranslationContent = false;
        this.mParentOffsetInWindow = new int[2];
        this.mNestedChild = new NestedScrollingChildHelper(this);
        this.mNestedParent = new NestedScrollingParentHelper(this);
        n70 n70 = n70.DefaultUnNotify;
        this.mHeaderHeightStatus = n70;
        this.mFooterHeightStatus = n70;
        this.mHeaderMaxDragRate = 2.5f;
        this.mFooterMaxDragRate = 2.5f;
        this.mHeaderTriggerRate = 1.0f;
        this.mFooterTriggerRate = 1.0f;
        this.mKernel = new f();
        RefreshState refreshState = RefreshState.None;
        this.mState = refreshState;
        this.mViceState = refreshState;
        this.mLastOpenTime = 0;
        this.mHeaderBackgroundColor = 0;
        this.mFooterBackgroundColor = 0;
        this.mFooterLocked = false;
        this.mVerticalPermit = false;
        this.mFalsifyEvent = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mHandler = new Handler();
        this.mScroller = new Scroller(context);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mScreenHeightPixels = DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics());
        this.mReboundInterpolator = new cc2(cc2.INTERPOLATOR_VISCOUS_FLUID);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mFooterHeight = cc2.dp2px(60.0f);
        this.mHeaderHeight = cc2.dp2px(100.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout);
        if (!obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        DefaultRefreshInitializer defaultRefreshInitializer = sRefreshInitializer;
        if (defaultRefreshInitializer != null) {
            defaultRefreshInitializer.initialize(context, this);
        }
        this.mDragRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlDragRate, this.mDragRate);
        this.mHeaderMaxDragRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.mHeaderMaxDragRate);
        this.mFooterMaxDragRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.mFooterMaxDragRate);
        this.mHeaderTriggerRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.mHeaderTriggerRate);
        this.mFooterTriggerRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterTriggerRate, this.mFooterTriggerRate);
        this.mEnableRefresh = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableRefresh, this.mEnableRefresh);
        this.mReboundDuration = obtainStyledAttributes.getInt(R$styleable.SmartRefreshLayout_srlReboundDuration, this.mReboundDuration);
        int i = R$styleable.SmartRefreshLayout_srlEnableLoadMore;
        this.mEnableLoadMore = obtainStyledAttributes.getBoolean(i, this.mEnableLoadMore);
        int i2 = R$styleable.SmartRefreshLayout_srlHeaderHeight;
        this.mHeaderHeight = obtainStyledAttributes.getDimensionPixelOffset(i2, this.mHeaderHeight);
        int i3 = R$styleable.SmartRefreshLayout_srlFooterHeight;
        this.mFooterHeight = obtainStyledAttributes.getDimensionPixelOffset(i3, this.mFooterHeight);
        this.mHeaderInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlHeaderInsetStart, this.mHeaderInsetStart);
        this.mFooterInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlFooterInsetStart, this.mFooterInsetStart);
        this.mDisableContentWhenRefresh = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.mDisableContentWhenRefresh);
        this.mDisableContentWhenLoading = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.mDisableContentWhenLoading);
        int i4 = R$styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.mEnableHeaderTranslationContent = obtainStyledAttributes.getBoolean(i4, this.mEnableHeaderTranslationContent);
        int i5 = R$styleable.SmartRefreshLayout_srlEnableFooterTranslationContent;
        this.mEnableFooterTranslationContent = obtainStyledAttributes.getBoolean(i5, this.mEnableFooterTranslationContent);
        this.mEnablePreviewInEditMode = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.mEnablePreviewInEditMode);
        this.mEnableAutoLoadMore = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.mEnableAutoLoadMore);
        this.mEnableOverScrollBounce = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.mEnableOverScrollBounce);
        this.mEnablePureScrollMode = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.mEnablePureScrollMode);
        this.mEnableScrollContentWhenLoaded = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.mEnableScrollContentWhenLoaded);
        this.mEnableScrollContentWhenRefreshed = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.mEnableScrollContentWhenRefreshed);
        this.mEnableLoadMoreWhenContentNotFull = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.mEnableLoadMoreWhenContentNotFull);
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.mEnableFooterFollowWhenNoMoreData);
        this.mEnableFooterFollowWhenNoMoreData = z;
        this.mEnableFooterFollowWhenNoMoreData = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z);
        this.mEnableClipHeaderWhenFixedBehind = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.mEnableClipHeaderWhenFixedBehind);
        this.mEnableClipFooterWhenFixedBehind = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.mEnableClipFooterWhenFixedBehind);
        this.mEnableOverScrollDrag = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.mEnableOverScrollDrag);
        this.mFixedHeaderViewId = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.mFixedHeaderViewId);
        this.mFixedFooterViewId = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedFooterViewId, this.mFixedFooterViewId);
        this.mHeaderTranslationViewId = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.mHeaderTranslationViewId);
        this.mFooterTranslationViewId = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.mFooterTranslationViewId);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.mEnableNestedScrolling);
        this.mEnableNestedScrolling = z2;
        this.mNestedChild.setNestedScrollingEnabled(z2);
        this.mManualLoadMore = this.mManualLoadMore || obtainStyledAttributes.hasValue(i);
        this.mManualHeaderTranslationContent = this.mManualHeaderTranslationContent || obtainStyledAttributes.hasValue(i4);
        this.mManualFooterTranslationContent = this.mManualFooterTranslationContent || obtainStyledAttributes.hasValue(i5);
        this.mHeaderHeightStatus = obtainStyledAttributes.hasValue(i2) ? n70.XmlLayoutUnNotify : this.mHeaderHeightStatus;
        this.mFooterHeightStatus = obtainStyledAttributes.hasValue(i3) ? n70.XmlLayoutUnNotify : this.mFooterHeightStatus;
        int color = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.mPrimaryColors = new int[]{color2, color};
            } else {
                this.mPrimaryColors = new int[]{color2};
            }
        } else if (color != 0) {
            this.mPrimaryColors = new int[]{0, color};
        }
        if (this.mEnablePureScrollMode && !this.mManualLoadMore && !this.mEnableLoadMore) {
            this.mEnableLoadMore = true;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoLoadMore(int i, final int i2, final float f2, final boolean z) {
        if (this.mState != RefreshState.None || !isEnableRefreshOrLoadMore(this.mEnableLoadMore) || this.mFooterNoMoreData) {
            return false;
        }
        AnonymousClass9 r0 = new Runnable() {
            /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass9 */

            /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$9$a */
            /* compiled from: Taobao */
            class a implements ValueAnimator.AnimatorUpdateListener {
                a() {
                }

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    if (smartRefreshLayout.reboundAnimator != null) {
                        smartRefreshLayout.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                    }
                }
            }

            /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$9$b */
            /* compiled from: Taobao */
            class b extends AnimatorListenerAdapter {
                b() {
                }

                public void onAnimationEnd(Animator animator) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    if (smartRefreshLayout.reboundAnimator != null) {
                        smartRefreshLayout.reboundAnimator = null;
                        RefreshState refreshState = smartRefreshLayout.mState;
                        RefreshState refreshState2 = RefreshState.ReleaseToLoad;
                        if (refreshState != refreshState2) {
                            smartRefreshLayout.mKernel.setState(refreshState2);
                        }
                        AnonymousClass9 r3 = AnonymousClass9.this;
                        SmartRefreshLayout.this.setStateLoading(!z);
                    }
                }
            }

            public void run() {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (smartRefreshLayout.mViceState == RefreshState.Loading) {
                    ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    smartRefreshLayout2.mLastTouchX = ((float) smartRefreshLayout2.getMeasuredWidth()) / 2.0f;
                    SmartRefreshLayout.this.mKernel.setState(RefreshState.PullUpToLoad);
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    smartRefreshLayout3.reboundAnimator = ValueAnimator.ofInt(smartRefreshLayout3.mSpinner, -((int) (((float) smartRefreshLayout3.mFooterHeight) * f2)));
                    SmartRefreshLayout.this.reboundAnimator.setDuration((long) i2);
                    SmartRefreshLayout.this.reboundAnimator.setInterpolator(new cc2(cc2.INTERPOLATOR_VISCOUS_FLUID));
                    SmartRefreshLayout.this.reboundAnimator.addUpdateListener(new a());
                    SmartRefreshLayout.this.reboundAnimator.addListener(new b());
                    SmartRefreshLayout.this.reboundAnimator.start();
                }
            }
        };
        setViceState(RefreshState.Loading);
        if (i > 0) {
            this.mHandler.postDelayed(r0, (long) i);
            return true;
        }
        r0.run();
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @Deprecated
    public boolean autoRefresh(int i) {
        int i2 = this.mReboundDuration;
        int i3 = this.mHeaderHeight;
        float f2 = ((this.mHeaderMaxDragRate / 2.0f) + 0.5f) * ((float) i3) * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoRefresh(i, i2, f2 / ((float) i3), false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMore(int i) {
        return finishLoadMore(i, true, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefresh(int i) {
        return finishRefresh(i, true, Boolean.FALSE);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshContent(@NonNull View view, int i, int i2) {
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            super.removeView(refreshContent.getView());
        }
        super.addView(view, getChildCount(), new LayoutParams(i, i2));
        this.mRefreshContent = new jz1(view);
        if (this.mAttachedToWindow) {
            View findViewById = findViewById(this.mFixedHeaderViewId);
            View findViewById2 = findViewById(this.mFixedFooterViewId);
            this.mRefreshContent.setScrollBoundaryDecider(this.mScrollBoundaryDecider);
            this.mRefreshContent.setEnableLoadMoreWhenContentNotFull(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.setUpComponent(this.mKernel, findViewById, findViewById2);
        }
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null && refreshInternal.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        RefreshInternal refreshInternal2 = this.mRefreshFooter;
        if (refreshInternal2 != null && refreshInternal2.getSpinnerStyle().b) {
            super.bringChildToFront(this.mRefreshFooter.getView());
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshFooter(@NonNull RefreshFooter refreshFooter, int i, int i2) {
        RefreshInternal refreshInternal;
        RefreshInternal refreshInternal2 = this.mRefreshFooter;
        if (refreshInternal2 != null) {
            super.removeView(refreshInternal2.getView());
        }
        this.mRefreshFooter = refreshFooter;
        this.mFooterLocked = false;
        this.mFooterBackgroundColor = 0;
        this.mFooterNoMoreDataEffective = false;
        this.mFooterNeedTouchEventWhenLoading = false;
        this.mFooterHeightStatus = this.mFooterHeightStatus.c();
        this.mEnableLoadMore = !this.mManualLoadMore || this.mEnableLoadMore;
        if (this.mRefreshFooter.getSpinnerStyle().b) {
            super.addView(this.mRefreshFooter.getView(), getChildCount(), new LayoutParams(i, i2));
        } else {
            super.addView(this.mRefreshFooter.getView(), 0, new LayoutParams(i, i2));
        }
        int[] iArr = this.mPrimaryColors;
        if (!(iArr == null || (refreshInternal = this.mRefreshFooter) == null)) {
            refreshInternal.setPrimaryColors(iArr);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshHeader(@NonNull RefreshHeader refreshHeader, int i, int i2) {
        RefreshInternal refreshInternal;
        RefreshInternal refreshInternal2 = this.mRefreshHeader;
        if (refreshInternal2 != null) {
            super.removeView(refreshInternal2.getView());
        }
        this.mRefreshHeader = refreshHeader;
        this.mHeaderBackgroundColor = 0;
        this.mHeaderNeedTouchEventWhenRefreshing = false;
        this.mHeaderHeightStatus = this.mHeaderHeightStatus.c();
        if (this.mRefreshHeader.getSpinnerStyle().b) {
            super.addView(this.mRefreshHeader.getView(), getChildCount(), new LayoutParams(i, i2));
        } else {
            super.addView(this.mRefreshHeader.getView(), 0, new LayoutParams(i, i2));
        }
        int[] iArr = this.mPrimaryColors;
        if (!(iArr == null || (refreshInternal = this.mRefreshHeader) == null)) {
            refreshInternal.setPrimaryColors(iArr);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoRefresh(int i, final int i2, final float f2, final boolean z) {
        if (this.mState != RefreshState.None || !isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
            return false;
        }
        AnonymousClass8 r0 = new Runnable() {
            /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8 */

            /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$8$a */
            /* compiled from: Taobao */
            class a implements ValueAnimator.AnimatorUpdateListener {
                a() {
                }

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    if (smartRefreshLayout.reboundAnimator != null) {
                        smartRefreshLayout.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                    }
                }
            }

            /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$8$b */
            /* compiled from: Taobao */
            class b extends AnimatorListenerAdapter {
                b() {
                }

                public void onAnimationEnd(Animator animator) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    if (smartRefreshLayout.reboundAnimator != null) {
                        smartRefreshLayout.reboundAnimator = null;
                        RefreshState refreshState = smartRefreshLayout.mState;
                        RefreshState refreshState2 = RefreshState.ReleaseToRefresh;
                        if (refreshState != refreshState2) {
                            smartRefreshLayout.mKernel.setState(refreshState2);
                        }
                        AnonymousClass8 r3 = AnonymousClass8.this;
                        SmartRefreshLayout.this.setStateRefreshing(!z);
                    }
                }
            }

            public void run() {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (smartRefreshLayout.mViceState == RefreshState.Refreshing) {
                    ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    smartRefreshLayout2.mLastTouchX = ((float) smartRefreshLayout2.getMeasuredWidth()) / 2.0f;
                    SmartRefreshLayout.this.mKernel.setState(RefreshState.PullDownToRefresh);
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    smartRefreshLayout3.reboundAnimator = ValueAnimator.ofInt(smartRefreshLayout3.mSpinner, (int) (((float) smartRefreshLayout3.mHeaderHeight) * f2));
                    SmartRefreshLayout.this.reboundAnimator.setDuration((long) i2);
                    SmartRefreshLayout.this.reboundAnimator.setInterpolator(new cc2(cc2.INTERPOLATOR_VISCOUS_FLUID));
                    SmartRefreshLayout.this.reboundAnimator.addUpdateListener(new a());
                    SmartRefreshLayout.this.reboundAnimator.addListener(new b());
                    SmartRefreshLayout.this.reboundAnimator.start();
                }
            }
        };
        setViceState(RefreshState.Refreshing);
        if (i > 0) {
            this.mHandler.postDelayed(r0, (long) i);
            return true;
        }
        r0.run();
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMore(boolean z) {
        return finishLoadMore(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16 : 0, z, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefresh(boolean z) {
        if (z) {
            return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.FALSE);
        }
        return finishRefresh(0, false, null);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMore(int i, final boolean z, final boolean z2) {
        final int i2 = i >> 16;
        int i3 = (i << 16) >> 16;
        AnonymousClass7 r1 = new Runnable() {
            /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass7 */
            int count = 0;

            /* JADX WARNING: Code restructure failed: missing block: B:41:0x0095, code lost:
                if (r2.mRefreshContent.canLoadMore() != false) goto L_0x0099;
             */
            public void run() {
                int i = this.count;
                boolean z = true;
                if (i == 0) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState = smartRefreshLayout.mState;
                    RefreshState refreshState2 = RefreshState.None;
                    if (refreshState == refreshState2 && smartRefreshLayout.mViceState == RefreshState.Loading) {
                        smartRefreshLayout.mViceState = refreshState2;
                    } else {
                        ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                        if (valueAnimator != null && ((refreshState.isDragging || refreshState == RefreshState.LoadReleased) && refreshState.isFooter)) {
                            smartRefreshLayout.reboundAnimator = null;
                            valueAnimator.cancel();
                            SmartRefreshLayout.this.mKernel.setState(refreshState2);
                        } else if (!(refreshState != RefreshState.Loading || smartRefreshLayout.mRefreshFooter == null || smartRefreshLayout.mRefreshContent == null)) {
                            this.count = i + 1;
                            smartRefreshLayout.mHandler.postDelayed(this, (long) i2);
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.LoadFinish);
                            return;
                        }
                    }
                    if (z2) {
                        SmartRefreshLayout.this.setNoMoreData(true);
                        return;
                    }
                    return;
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int onFinish = smartRefreshLayout2.mRefreshFooter.onFinish(smartRefreshLayout2, z);
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout3.mOnMultiPurposeListener;
                if (onMultiPurposeListener != null) {
                    RefreshInternal refreshInternal = smartRefreshLayout3.mRefreshFooter;
                    if (refreshInternal instanceof RefreshFooter) {
                        onMultiPurposeListener.onFooterFinish((RefreshFooter) refreshInternal, z);
                    }
                }
                if (onFinish < Integer.MAX_VALUE) {
                    if (z2) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        if (smartRefreshLayout4.mEnableFooterFollowWhenNoMoreData) {
                            if (smartRefreshLayout4.mSpinner < 0) {
                            }
                        }
                    }
                    z = false;
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    int i2 = smartRefreshLayout5.mSpinner;
                    final int max = i2 - (z ? Math.max(i2, -smartRefreshLayout5.mFooterHeight) : 0);
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.mIsBeingDragged || smartRefreshLayout6.mNestedInProgress) {
                        long currentTimeMillis = System.currentTimeMillis();
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (smartRefreshLayout7.mIsBeingDragged) {
                            float f = smartRefreshLayout7.mLastTouchY;
                            smartRefreshLayout7.mTouchY = f;
                            smartRefreshLayout7.mTouchSpinner = smartRefreshLayout7.mSpinner - max;
                            smartRefreshLayout7.mIsBeingDragged = false;
                            float f2 = (float) (smartRefreshLayout7.mEnableFooterTranslationContent ? max : 0);
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout7.mLastTouchX, f + f2 + ((float) (smartRefreshLayout7.mTouchSlop * 2)), 0));
                            SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout8.mLastTouchX, smartRefreshLayout8.mLastTouchY + f2, 0));
                        }
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        if (smartRefreshLayout9.mNestedInProgress) {
                            smartRefreshLayout9.mTotalUnconsumed = 0;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout9.mLastTouchX, smartRefreshLayout9.mLastTouchY, 0));
                            SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                            smartRefreshLayout10.mNestedInProgress = false;
                            smartRefreshLayout10.mTouchSpinner = 0;
                        }
                    }
                    SmartRefreshLayout.this.mHandler.postDelayed(new Runnable() {
                        /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass7.AnonymousClass1 */

                        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$7$1$a */
                        /* compiled from: Taobao */
                        class a extends AnimatorListenerAdapter {
                            a() {
                            }

                            public void onAnimationEnd(Animator animator) {
                                AnonymousClass7 r3 = AnonymousClass7.this;
                                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                                smartRefreshLayout.mFooterLocked = false;
                                if (z2) {
                                    smartRefreshLayout.setNoMoreData(true);
                                }
                                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                                if (smartRefreshLayout2.mState == RefreshState.LoadFinish) {
                                    smartRefreshLayout2.notifyStateChanged(RefreshState.None);
                                }
                            }
                        }

                        public void run() {
                            ValueAnimator valueAnimator;
                            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                            ValueAnimator.AnimatorUpdateListener scrollContentWhenFinished = (!smartRefreshLayout.mEnableScrollContentWhenLoaded || max >= 0) ? null : smartRefreshLayout.mRefreshContent.scrollContentWhenFinished(smartRefreshLayout.mSpinner);
                            if (scrollContentWhenFinished != null) {
                                scrollContentWhenFinished.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                            }
                            a aVar = new a();
                            AnonymousClass7 r3 = AnonymousClass7.this;
                            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                            int i = smartRefreshLayout2.mSpinner;
                            if (i > 0) {
                                valueAnimator = smartRefreshLayout2.mKernel.animSpinner(0);
                            } else {
                                if (scrollContentWhenFinished != null || i == 0) {
                                    ValueAnimator valueAnimator2 = smartRefreshLayout2.reboundAnimator;
                                    if (valueAnimator2 != null) {
                                        valueAnimator2.cancel();
                                        SmartRefreshLayout.this.reboundAnimator = null;
                                    }
                                    SmartRefreshLayout.this.mKernel.moveSpinner(0, false);
                                    SmartRefreshLayout.this.mKernel.setState(RefreshState.None);
                                } else if (!z2 || !smartRefreshLayout2.mEnableFooterFollowWhenNoMoreData) {
                                    valueAnimator = smartRefreshLayout2.mKernel.animSpinner(0);
                                } else {
                                    int i2 = smartRefreshLayout2.mFooterHeight;
                                    if (i >= (-i2)) {
                                        smartRefreshLayout2.notifyStateChanged(RefreshState.None);
                                    } else {
                                        valueAnimator = smartRefreshLayout2.mKernel.animSpinner(-i2);
                                    }
                                }
                                valueAnimator = null;
                            }
                            if (valueAnimator != null) {
                                valueAnimator.addListener(aVar);
                            } else {
                                aVar.onAnimationEnd(null);
                            }
                        }
                    }, SmartRefreshLayout.this.mSpinner < 0 ? (long) onFinish : 0);
                }
            }
        };
        if (i3 > 0) {
            this.mHandler.postDelayed(r1, (long) i3);
        } else {
            r1.run();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefresh(int i, final boolean z, final Boolean bool) {
        final int i2 = i >> 16;
        int i3 = (i << 16) >> 16;
        AnonymousClass6 r1 = new Runnable() {
            /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass6 */
            int count = 0;

            public void run() {
                int i = this.count;
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
                boolean z = false;
                if (i == 0) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState = smartRefreshLayout.mState;
                    RefreshState refreshState2 = RefreshState.None;
                    if (refreshState == refreshState2 && smartRefreshLayout.mViceState == RefreshState.Refreshing) {
                        smartRefreshLayout.mViceState = refreshState2;
                        return;
                    }
                    ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                    if (valueAnimator != null && refreshState.isHeader && (refreshState.isDragging || refreshState == RefreshState.RefreshReleased)) {
                        smartRefreshLayout.reboundAnimator = null;
                        valueAnimator.cancel();
                        SmartRefreshLayout.this.mKernel.setState(refreshState2);
                    } else if (refreshState == RefreshState.Refreshing && smartRefreshLayout.mRefreshHeader != null && smartRefreshLayout.mRefreshContent != null) {
                        this.count = i + 1;
                        smartRefreshLayout.mHandler.postDelayed(this, (long) i2);
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshFinish);
                        Boolean bool = bool;
                        if (bool != null) {
                            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                            if (bool == Boolean.TRUE) {
                                z = true;
                            }
                            smartRefreshLayout2.setNoMoreData(z);
                        }
                    }
                } else {
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    int onFinish = smartRefreshLayout3.mRefreshHeader.onFinish(smartRefreshLayout3, z);
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout4.mOnMultiPurposeListener;
                    if (onMultiPurposeListener != null) {
                        RefreshInternal refreshInternal = smartRefreshLayout4.mRefreshHeader;
                        if (refreshInternal instanceof RefreshHeader) {
                            onMultiPurposeListener.onHeaderFinish((RefreshHeader) refreshInternal, z);
                        }
                    }
                    if (onFinish < Integer.MAX_VALUE) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        if (smartRefreshLayout5.mIsBeingDragged || smartRefreshLayout5.mNestedInProgress) {
                            long currentTimeMillis = System.currentTimeMillis();
                            SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                            if (smartRefreshLayout6.mIsBeingDragged) {
                                float f = smartRefreshLayout6.mLastTouchY;
                                smartRefreshLayout6.mTouchY = f;
                                smartRefreshLayout6.mTouchSpinner = 0;
                                smartRefreshLayout6.mIsBeingDragged = false;
                                SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout6.mLastTouchX, (f + ((float) smartRefreshLayout6.mSpinner)) - ((float) (smartRefreshLayout6.mTouchSlop * 2)), 0));
                                SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                                SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout7.mLastTouchX, smartRefreshLayout7.mLastTouchY + ((float) smartRefreshLayout7.mSpinner), 0));
                            }
                            SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                            if (smartRefreshLayout8.mNestedInProgress) {
                                smartRefreshLayout8.mTotalUnconsumed = 0;
                                SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout8.mLastTouchX, smartRefreshLayout8.mLastTouchY, 0));
                                SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                                smartRefreshLayout9.mNestedInProgress = false;
                                smartRefreshLayout9.mTouchSpinner = 0;
                            }
                        }
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        int i2 = smartRefreshLayout10.mSpinner;
                        if (i2 > 0) {
                            ValueAnimator animSpinner = smartRefreshLayout10.animSpinner(0, onFinish, smartRefreshLayout10.mReboundInterpolator, smartRefreshLayout10.mReboundDuration);
                            SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                            if (smartRefreshLayout11.mEnableScrollContentWhenRefreshed) {
                                animatorUpdateListener = smartRefreshLayout11.mRefreshContent.scrollContentWhenFinished(smartRefreshLayout11.mSpinner);
                            }
                            if (animSpinner != null && animatorUpdateListener != null) {
                                animSpinner.addUpdateListener(animatorUpdateListener);
                            }
                        } else if (i2 < 0) {
                            smartRefreshLayout10.animSpinner(0, onFinish, smartRefreshLayout10.mReboundInterpolator, smartRefreshLayout10.mReboundDuration);
                        } else {
                            smartRefreshLayout10.mKernel.moveSpinner(0, false);
                            SmartRefreshLayout.this.mKernel.setState(RefreshState.None);
                        }
                    }
                }
            }
        };
        if (i3 > 0) {
            this.mHandler.postDelayed(r1, (long) i3);
        } else {
            r1.run();
        }
        return this;
    }

    /* compiled from: Taobao */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int backgroundColor = 0;
        public gd2 spinnerStyle = null;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout_Layout);
            this.backgroundColor = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.backgroundColor);
            int i = R$styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (obtainStyledAttributes.hasValue(i)) {
                this.spinnerStyle = gd2.values[obtainStyledAttributes.getInt(i, gd2.Translate.a)];
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }
}
