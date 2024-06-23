package com.youku.cmsui;

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
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
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
import com.scwang.smartrefresh.layout.util.DelayedRunnable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.scwang.smartrefresh.layout.util.ScrollBoundaryUtil;
import com.scwang.smartrefresh.layout.util.ViscousFluidInterpolator;
import com.youku.resource.R;
import com.youku.resource.widget.YKPageRefreshHeader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.cc2;
import tb.gd2;
import tb.n52;
import tb.n70;

@SuppressLint({"RestrictedApi"})
/* compiled from: Taobao */
public class YKSmartRefreshLayout extends ViewGroup implements NestedScrollingParent, RefreshLayout {
    protected static DefaultRefreshFooterCreator sFooterCreator = new DefaultRefreshFooterCreator() {
        /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass1 */

        @Override // com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator
        @NonNull
        public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout refreshLayout) {
            return new BallPulseFooter(context);
        }
    };
    protected static DefaultRefreshHeaderCreator sHeaderCreator = new DefaultRefreshHeaderCreator() {
        /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass2 */

        @Override // com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator
        @NonNull
        public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout refreshLayout) {
            return new BezierRadarHeader(context);
        }
    };
    protected static boolean sManualFooterCreator;
    protected Runnable animationRunnable;
    protected boolean isAutoRefresh;
    protected boolean mAblePullingDownWhenRefreshing;
    protected boolean mDisableContentWhenLoading;
    protected boolean mDisableContentWhenRefresh;
    protected char mDragDirection;
    protected float mDragRate;
    protected boolean mEnableAutoLoadMore;
    protected boolean mEnableClipFooterWhenFixedBehind;
    protected boolean mEnableClipHeaderWhenFixedBehind;
    protected boolean mEnableFooterFollowWhenLoadFinished;
    protected boolean mEnableFooterTranslationContent;
    protected boolean mEnableHeaderTranslationContent;
    protected boolean mEnableLoadMore;
    protected boolean mEnableLoadMoreWhenContentNotFull;
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
    protected float mFooterTriggerRate;
    protected Handler mHandler;
    protected int mHeaderBackgroundColor;
    protected int mHeaderHeight;
    protected n70 mHeaderHeightStatus;
    protected int mHeaderInsetStart;
    protected float mHeaderMaxDragRate;
    protected boolean mHeaderNeedTouchEventWhenRefreshing;
    protected float mHeaderTriggerRate;
    protected boolean mInterceptEventWhenStatueChanged;
    protected boolean mIsBeingDragged;
    protected RefreshKernel mKernel;
    protected long mLastOpenTime;
    protected int mLastSpinner;
    protected float mLastTouchX;
    protected float mLastTouchY;
    protected List<DelayedRunnable> mListDelayedRunnable;
    protected OnLoadMoreListener mLoadMoreListener;
    protected boolean mManualFooterTranslationContent;
    protected boolean mManualHeaderTranslationContent;
    protected boolean mManualLoadMore;
    protected boolean mManualNestedScrolling;
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
    protected boolean mSupportDragHDirection;
    protected boolean mSupportNestedHScroll;
    protected int mTotalUnconsumed;
    protected int mTouchSlop;
    protected int mTouchSpinner;
    protected float mTouchX;
    protected float mTouchY;
    protected VelocityTracker mVelocityTracker;
    protected boolean mVerticalPermit;
    protected RefreshState mViceState;
    protected ValueAnimator reboundAnimator;

    /* renamed from: com.youku.cmsui.YKSmartRefreshLayout$13  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass13 {
        static final /* synthetic */ int[] $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState;

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
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState = iArr;
            iArr[RefreshState.None.ordinal()] = 1;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullDownToRefresh.ordinal()] = 2;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullUpToLoad.ordinal()] = 3;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullDownCanceled.ordinal()] = 4;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullUpCanceled.ordinal()] = 5;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.ReleaseToLoad.ordinal()] = 7;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.RefreshReleased.ordinal()] = 9;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.LoadReleased.ordinal()] = 10;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.Refreshing.ordinal()] = 11;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.Loading.ordinal()] = 12;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.RefreshFinish.ordinal()] = 13;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.LoadFinish.ordinal()] = 14;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.TwoLevelReleased.ordinal()] = 15;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.TwoLevelFinish.ordinal()] = 16;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.TwoLevel.ordinal()] = 17;
        }
    }

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
            YKSmartRefreshLayout.this.postDelayed(this, (long) this.mFrameDelay);
        }

        public void run() {
            YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
            if (yKSmartRefreshLayout.animationRunnable == this && !yKSmartRefreshLayout.mState.isFinishing) {
                if (Math.abs(yKSmartRefreshLayout.mSpinner) < Math.abs(this.mSmoothDistance)) {
                    int i = this.mFrame + 1;
                    this.mFrame = i;
                    this.mVelocity = (float) (((double) this.mVelocity) * Math.pow(0.949999988079071d, (double) i));
                } else if (this.mSmoothDistance != 0) {
                    int i2 = this.mFrame + 1;
                    this.mFrame = i2;
                    this.mVelocity = (float) (((double) this.mVelocity) * Math.pow(0.44999998807907104d, (double) i2));
                } else {
                    int i3 = this.mFrame + 1;
                    this.mFrame = i3;
                    this.mVelocity = (float) (((double) this.mVelocity) * Math.pow(0.8500000238418579d, (double) i3));
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float f = this.mVelocity * ((((float) (currentAnimationTimeMillis - this.mLastTime)) * 1.0f) / 1000.0f);
                if (Math.abs(f) >= 1.0f) {
                    this.mLastTime = currentAnimationTimeMillis;
                    float f2 = this.mOffset + f;
                    this.mOffset = f2;
                    YKSmartRefreshLayout.this.moveSpinnerInfinitely(f2);
                    YKSmartRefreshLayout.this.postDelayed(this, (long) this.mFrameDelay);
                    return;
                }
                YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                yKSmartRefreshLayout2.animationRunnable = null;
                if (Math.abs(yKSmartRefreshLayout2.mSpinner) >= Math.abs(this.mSmoothDistance)) {
                    YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                    yKSmartRefreshLayout3.animSpinner(this.mSmoothDistance, 0, yKSmartRefreshLayout3.mReboundInterpolator, Math.min(Math.max((int) DensityUtil.px2dp(Math.abs(YKSmartRefreshLayout.this.mSpinner - this.mSmoothDistance)), 30), 100) * 10);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public class FlingRunnable implements Runnable {
        float mDamping = 0.95f;
        int mFrame = 0;
        int mFrameDelay = 10;
        long mLastTime = AnimationUtils.currentAnimationTimeMillis();
        int mOffset;
        float mVelocity;

        FlingRunnable(float f) {
            this.mVelocity = f;
            this.mOffset = YKSmartRefreshLayout.this.mSpinner;
        }

        public void run() {
            YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
            if (yKSmartRefreshLayout.animationRunnable == this && !yKSmartRefreshLayout.mState.isFinishing) {
                int i = this.mFrame + 1;
                this.mFrame = i;
                this.mVelocity = (float) (((double) this.mVelocity) * Math.pow((double) this.mDamping, (double) i));
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float f = this.mVelocity * ((((float) (currentAnimationTimeMillis - this.mLastTime)) * 1.0f) / 1000.0f);
                if (Math.abs(f) > 1.0f) {
                    this.mLastTime = currentAnimationTimeMillis;
                    int i2 = (int) (((float) this.mOffset) + f);
                    this.mOffset = i2;
                    YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout2.mSpinner * i2 > 0) {
                        yKSmartRefreshLayout2.mKernel.moveSpinner(i2, true);
                        YKSmartRefreshLayout.this.postDelayed(this, (long) this.mFrameDelay);
                        return;
                    }
                    yKSmartRefreshLayout2.animationRunnable = null;
                    yKSmartRefreshLayout2.mKernel.moveSpinner(0, true);
                    cc2.fling(YKSmartRefreshLayout.this.mRefreshContent.getScrollableView(), (int) (-this.mVelocity));
                    YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout3.mFooterLocked && f > 0.0f) {
                        yKSmartRefreshLayout3.mFooterLocked = false;
                        return;
                    }
                    return;
                }
                YKSmartRefreshLayout.this.animationRunnable = null;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
            if (r0.mSpinner >= (-r0.mFooterHeight)) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
            if (r0.mSpinner > r0.mHeaderHeight) goto L_0x004d;
         */
        public Runnable start() {
            RefreshState refreshState;
            YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
            RefreshState refreshState2 = yKSmartRefreshLayout.mState;
            if (refreshState2.isFinishing) {
                return null;
            }
            if (yKSmartRefreshLayout.mSpinner != 0) {
                if (refreshState2.isOpening || (yKSmartRefreshLayout.mFooterNoMoreData && yKSmartRefreshLayout.mEnableFooterFollowWhenLoadFinished && yKSmartRefreshLayout.isEnableLoadMore())) {
                    YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout2.mState == RefreshState.Loading || (yKSmartRefreshLayout2.mFooterNoMoreData && yKSmartRefreshLayout2.mEnableFooterFollowWhenLoadFinished && yKSmartRefreshLayout2.isEnableLoadMore())) {
                        YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                    }
                    YKSmartRefreshLayout yKSmartRefreshLayout4 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout4.mState == RefreshState.Refreshing) {
                    }
                }
                int i = 0;
                int i2 = YKSmartRefreshLayout.this.mSpinner;
                float f = this.mVelocity;
                int i3 = i2;
                while (true) {
                    if (i2 * i3 <= 0) {
                        break;
                    }
                    i++;
                    f = (float) (((double) f) * Math.pow((double) this.mDamping, (double) i));
                    float f2 = ((((float) this.mFrameDelay) * 1.0f) / 1000.0f) * f;
                    if (Math.abs(f2) < 1.0f) {
                        YKSmartRefreshLayout yKSmartRefreshLayout5 = YKSmartRefreshLayout.this;
                        RefreshState refreshState3 = yKSmartRefreshLayout5.mState;
                        if (!refreshState3.isOpening || ((refreshState3 == (refreshState = RefreshState.Refreshing) && i3 > yKSmartRefreshLayout5.mHeaderHeight) || (refreshState3 != refreshState && i3 < (-yKSmartRefreshLayout5.mFooterHeight)))) {
                            return null;
                        }
                    } else {
                        i3 = (int) (((float) i3) + f2);
                    }
                }
            }
            YKSmartRefreshLayout.this.postDelayed(this, (long) this.mFrameDelay);
            return this;
        }
    }

    /* compiled from: Taobao */
    class MyScrollBoundaryDecider extends n52 {
        MyScrollBoundaryDecider() {
        }

        @Override // tb.n52, com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider
        public boolean canLoadMore(View view) {
            return ScrollBoundaryUtil.canLoadMore(view, this.mActionEvent, this.mEnableLoadMoreWhenContentNotFull);
        }
    }

    /* compiled from: Taobao */
    public class RefreshKernelImpl implements RefreshKernel {
        public RefreshKernelImpl() {
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public ValueAnimator animSpinner(int i) {
            YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
            return yKSmartRefreshLayout.animSpinner(i, 0, yKSmartRefreshLayout.mReboundInterpolator, yKSmartRefreshLayout.mReboundDuration);
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel finishTwoLevel() {
            YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
            if (yKSmartRefreshLayout.mState == RefreshState.TwoLevel) {
                yKSmartRefreshLayout.mKernel.setState(RefreshState.TwoLevelFinish);
                if (YKSmartRefreshLayout.this.mSpinner == 0) {
                    moveSpinner(0, false);
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                } else {
                    animSpinner(0).setDuration((long) YKSmartRefreshLayout.this.mFloorDuration);
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        @NonNull
        public RefreshContent getRefreshContent() {
            return YKSmartRefreshLayout.this.mRefreshContent;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        @NonNull
        public RefreshLayout getRefreshLayout() {
            return YKSmartRefreshLayout.this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:109:0x01a4  */
        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel moveSpinner(int i, boolean z) {
            OnMultiPurposeListener onMultiPurposeListener;
            int i2;
            OnMultiPurposeListener onMultiPurposeListener2;
            YKSmartRefreshLayout yKSmartRefreshLayout;
            RefreshInternal refreshInternal;
            RefreshInternal refreshInternal2;
            RefreshInternal refreshInternal3;
            RefreshInternal refreshInternal4;
            YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
            if (yKSmartRefreshLayout2.mSpinner == i && (((refreshInternal3 = yKSmartRefreshLayout2.mRefreshHeader) == null || !refreshInternal3.isSupportHorizontalDrag()) && ((refreshInternal4 = YKSmartRefreshLayout.this.mRefreshFooter) == null || !refreshInternal4.isSupportHorizontalDrag()))) {
                return this;
            }
            YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
            int i3 = yKSmartRefreshLayout3.mSpinner;
            yKSmartRefreshLayout3.mSpinner = i;
            if (z && yKSmartRefreshLayout3.mViceState.isDragging) {
                if (((float) i) > ((float) yKSmartRefreshLayout3.mHeaderHeight) * yKSmartRefreshLayout3.mHeaderTriggerRate) {
                    if (yKSmartRefreshLayout3.mState != RefreshState.ReleaseToTwoLevel) {
                        yKSmartRefreshLayout3.mKernel.setState(RefreshState.ReleaseToRefresh);
                    }
                } else if (((float) (-i)) > ((float) yKSmartRefreshLayout3.mFooterHeight) * yKSmartRefreshLayout3.mFooterTriggerRate && !yKSmartRefreshLayout3.mFooterNoMoreData) {
                    yKSmartRefreshLayout3.mKernel.setState(RefreshState.ReleaseToLoad);
                } else if (i < 0 && !yKSmartRefreshLayout3.mFooterNoMoreData) {
                    yKSmartRefreshLayout3.mKernel.setState(RefreshState.PullUpToLoad);
                } else if (i > 0) {
                    yKSmartRefreshLayout3.mKernel.setState(RefreshState.PullDownToRefresh);
                }
            }
            YKSmartRefreshLayout yKSmartRefreshLayout4 = YKSmartRefreshLayout.this;
            int i4 = 1;
            if (yKSmartRefreshLayout4.mRefreshContent != null) {
                Integer num = null;
                if (i >= 0 && (refreshInternal2 = yKSmartRefreshLayout4.mRefreshHeader) != null) {
                    if (yKSmartRefreshLayout4.mEnableHeaderTranslationContent || refreshInternal2.getSpinnerStyle() == gd2.FixedBehind) {
                        num = Integer.valueOf(i);
                    } else if (i3 < 0) {
                        num = 0;
                    }
                }
                if (i <= 0 && (refreshInternal = (yKSmartRefreshLayout = YKSmartRefreshLayout.this).mRefreshFooter) != null) {
                    if (yKSmartRefreshLayout.mEnableFooterTranslationContent || refreshInternal.getSpinnerStyle() == gd2.FixedBehind) {
                        num = Integer.valueOf(i);
                    } else if (i3 > 0) {
                        num = 0;
                    }
                }
                if (num != null) {
                    YKSmartRefreshLayout.this.mRefreshContent.moveSpinner(num.intValue());
                    YKSmartRefreshLayout yKSmartRefreshLayout5 = YKSmartRefreshLayout.this;
                    boolean z2 = (yKSmartRefreshLayout5.mEnableClipHeaderWhenFixedBehind && yKSmartRefreshLayout5.mRefreshHeader.getSpinnerStyle() == gd2.FixedBehind) || YKSmartRefreshLayout.this.mHeaderBackgroundColor != 0;
                    YKSmartRefreshLayout yKSmartRefreshLayout6 = YKSmartRefreshLayout.this;
                    boolean z3 = (yKSmartRefreshLayout6.mEnableClipFooterWhenFixedBehind && yKSmartRefreshLayout6.mRefreshFooter.getSpinnerStyle() == gd2.FixedBehind) || YKSmartRefreshLayout.this.mFooterBackgroundColor != 0;
                    if ((z2 && (num.intValue() >= 0 || i3 > 0)) || (z3 && (num.intValue() <= 0 || i3 < 0))) {
                        yKSmartRefreshLayout3.invalidate();
                    }
                }
            }
            if ((i >= 0 || i3 > 0) && YKSmartRefreshLayout.this.mRefreshHeader != null) {
                int max = Math.max(i, 0);
                YKSmartRefreshLayout yKSmartRefreshLayout7 = YKSmartRefreshLayout.this;
                int i5 = yKSmartRefreshLayout7.mHeaderHeight;
                int i6 = (int) (((float) i5) * yKSmartRefreshLayout7.mHeaderMaxDragRate);
                float f = (((float) max) * 1.0f) / ((float) i5);
                if (yKSmartRefreshLayout7.isEnableRefresh() || (YKSmartRefreshLayout.this.mState == RefreshState.RefreshFinish && !z)) {
                    YKSmartRefreshLayout yKSmartRefreshLayout8 = YKSmartRefreshLayout.this;
                    if (i3 != yKSmartRefreshLayout8.mSpinner) {
                        if (yKSmartRefreshLayout8.mRefreshHeader.getSpinnerStyle() == gd2.Translate) {
                            YKSmartRefreshLayout.this.mRefreshHeader.getView().setTranslationY((float) YKSmartRefreshLayout.this.mSpinner);
                        } else if (YKSmartRefreshLayout.this.mRefreshHeader.getSpinnerStyle() == gd2.Scale) {
                            YKSmartRefreshLayout.this.mRefreshHeader.getView().requestLayout();
                        }
                        if (!z) {
                            i2 = i6;
                            YKSmartRefreshLayout.this.mRefreshHeader.onMoving(false, f, max, i5, i6);
                            if (z) {
                                if (YKSmartRefreshLayout.this.mRefreshHeader.isSupportHorizontalDrag()) {
                                    int i7 = (int) YKSmartRefreshLayout.this.mLastTouchX;
                                    int width = yKSmartRefreshLayout3.getWidth();
                                    YKSmartRefreshLayout yKSmartRefreshLayout9 = YKSmartRefreshLayout.this;
                                    yKSmartRefreshLayout9.mRefreshHeader.onHorizontalDrag(yKSmartRefreshLayout9.mLastTouchX / ((float) (width == 0 ? 1 : width)), i7, width);
                                    YKSmartRefreshLayout.this.mRefreshHeader.onMoving(true, f, max, i5, i2);
                                } else {
                                    YKSmartRefreshLayout yKSmartRefreshLayout10 = YKSmartRefreshLayout.this;
                                    if (i3 != yKSmartRefreshLayout10.mSpinner) {
                                        yKSmartRefreshLayout10.mRefreshHeader.onMoving(true, f, max, i5, i2);
                                    }
                                }
                            }
                        }
                    }
                    i2 = i6;
                    if (z) {
                    }
                } else {
                    i2 = i6;
                }
                YKSmartRefreshLayout yKSmartRefreshLayout11 = YKSmartRefreshLayout.this;
                if (!(i3 == yKSmartRefreshLayout11.mSpinner || (onMultiPurposeListener2 = yKSmartRefreshLayout11.mOnMultiPurposeListener) == null)) {
                    RefreshInternal refreshInternal5 = yKSmartRefreshLayout11.mRefreshHeader;
                    if (refreshInternal5 instanceof RefreshHeader) {
                        onMultiPurposeListener2.onHeaderMoving((RefreshHeader) refreshInternal5, z, f, max, i5, i2);
                    }
                }
            }
            if ((i <= 0 || i3 < 0) && YKSmartRefreshLayout.this.mRefreshFooter != null) {
                int i8 = -Math.min(i, 0);
                YKSmartRefreshLayout yKSmartRefreshLayout12 = YKSmartRefreshLayout.this;
                int i9 = yKSmartRefreshLayout12.mFooterHeight;
                int i10 = (int) (((float) i9) * yKSmartRefreshLayout12.mFooterMaxDragRate);
                float f2 = (((float) i8) * 1.0f) / ((float) (i9 == 0 ? 1 : i9));
                if (yKSmartRefreshLayout12.isEnableLoadMore() || (YKSmartRefreshLayout.this.mState == RefreshState.LoadFinish && !z)) {
                    YKSmartRefreshLayout yKSmartRefreshLayout13 = YKSmartRefreshLayout.this;
                    if (i3 != yKSmartRefreshLayout13.mSpinner) {
                        if (yKSmartRefreshLayout13.mRefreshFooter.getSpinnerStyle() == gd2.Translate) {
                            YKSmartRefreshLayout.this.mRefreshFooter.getView().setTranslationY((float) YKSmartRefreshLayout.this.mSpinner);
                        } else if (YKSmartRefreshLayout.this.mRefreshFooter.getSpinnerStyle() == gd2.Scale) {
                            YKSmartRefreshLayout.this.mRefreshFooter.getView().requestLayout();
                        }
                        if (!z) {
                            YKSmartRefreshLayout.this.mRefreshFooter.onMoving(false, f2, i8, i9, i10);
                        }
                    }
                    if (z) {
                        if (YKSmartRefreshLayout.this.mRefreshFooter.isSupportHorizontalDrag()) {
                            int i11 = (int) YKSmartRefreshLayout.this.mLastTouchX;
                            int width2 = yKSmartRefreshLayout3.getWidth();
                            YKSmartRefreshLayout yKSmartRefreshLayout14 = YKSmartRefreshLayout.this;
                            float f3 = yKSmartRefreshLayout14.mLastTouchX;
                            if (width2 != 0) {
                                i4 = width2;
                            }
                            yKSmartRefreshLayout14.mRefreshFooter.onHorizontalDrag(f3 / ((float) i4), i11, width2);
                            YKSmartRefreshLayout.this.mRefreshFooter.onMoving(true, f2, i8, i9, i10);
                        } else {
                            YKSmartRefreshLayout yKSmartRefreshLayout15 = YKSmartRefreshLayout.this;
                            if (i3 != yKSmartRefreshLayout15.mSpinner) {
                                yKSmartRefreshLayout15.mRefreshFooter.onMoving(true, f2, i8, i9, i10);
                            }
                        }
                    }
                }
                YKSmartRefreshLayout yKSmartRefreshLayout16 = YKSmartRefreshLayout.this;
                if (!(i3 == yKSmartRefreshLayout16.mSpinner || (onMultiPurposeListener = yKSmartRefreshLayout16.mOnMultiPurposeListener) == null)) {
                    RefreshInternal refreshInternal6 = yKSmartRefreshLayout16.mRefreshFooter;
                    if (refreshInternal6 instanceof RefreshFooter) {
                        onMultiPurposeListener.onFooterMoving((RefreshFooter) refreshInternal6, z, f2, i8, i9, i10);
                    }
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestDefaultTranslationContentFor(@NonNull RefreshInternal refreshInternal, boolean z) {
            RefreshInternal refreshInternal2 = YKSmartRefreshLayout.this.mRefreshHeader;
            if (refreshInternal2 == null || refreshInternal2.getView() != refreshInternal.getView()) {
                RefreshInternal refreshInternal3 = YKSmartRefreshLayout.this.mRefreshFooter;
                if (refreshInternal3 != null && refreshInternal3.getView() == refreshInternal.getView()) {
                    YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                    if (!yKSmartRefreshLayout.mManualFooterTranslationContent) {
                        yKSmartRefreshLayout.mManualFooterTranslationContent = true;
                        yKSmartRefreshLayout.mEnableFooterTranslationContent = z;
                    }
                }
            } else {
                YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                if (!yKSmartRefreshLayout2.mManualHeaderTranslationContent) {
                    yKSmartRefreshLayout2.mManualHeaderTranslationContent = true;
                    yKSmartRefreshLayout2.mEnableHeaderTranslationContent = z;
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestDrawBackgroundFor(RefreshInternal refreshInternal, int i) {
            YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
            if (yKSmartRefreshLayout.mPaint == null && i != 0) {
                yKSmartRefreshLayout.mPaint = new Paint();
            }
            RefreshInternal refreshInternal2 = YKSmartRefreshLayout.this.mRefreshHeader;
            if (refreshInternal2 == null || refreshInternal2.getView() != refreshInternal.getView()) {
                RefreshInternal refreshInternal3 = YKSmartRefreshLayout.this.mRefreshFooter;
                if (refreshInternal3 != null && refreshInternal3.getView() == refreshInternal.getView()) {
                    YKSmartRefreshLayout.this.mFooterBackgroundColor = i;
                }
            } else {
                YKSmartRefreshLayout.this.mHeaderBackgroundColor = i;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestFloorDuration(int i) {
            YKSmartRefreshLayout.this.mFloorDuration = i;
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestNeedTouchEventFor(@NonNull RefreshInternal refreshInternal, boolean z) {
            RefreshInternal refreshInternal2 = YKSmartRefreshLayout.this.mRefreshHeader;
            if (refreshInternal2 == null || refreshInternal2.getView() != refreshInternal.getView()) {
                RefreshInternal refreshInternal3 = YKSmartRefreshLayout.this.mRefreshFooter;
                if (refreshInternal3 != null && refreshInternal3.getView() == refreshInternal.getView()) {
                    YKSmartRefreshLayout.this.mFooterNeedTouchEventWhenLoading = z;
                }
            } else {
                YKSmartRefreshLayout.this.mHeaderNeedTouchEventWhenRefreshing = z;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel requestRemeasureHeightFor(@NonNull RefreshInternal refreshInternal) {
            RefreshInternal refreshInternal2 = YKSmartRefreshLayout.this.mRefreshHeader;
            if (refreshInternal2 == null || refreshInternal2.getView() != refreshInternal.getView()) {
                RefreshInternal refreshInternal3 = YKSmartRefreshLayout.this.mRefreshFooter;
                if (refreshInternal3 != null && refreshInternal3.getView() == refreshInternal.getView()) {
                    YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                    n70 n70 = yKSmartRefreshLayout.mFooterHeightStatus;
                    if (n70.b) {
                        yKSmartRefreshLayout.mFooterHeightStatus = n70.c();
                    }
                }
            } else {
                YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                n70 n702 = yKSmartRefreshLayout2.mHeaderHeightStatus;
                if (n702.b) {
                    yKSmartRefreshLayout2.mHeaderHeightStatus = n702.c();
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel setState(@NonNull RefreshState refreshState) {
            Log.d("RefreshKernelImpl", "setState " + refreshState);
            switch (AnonymousClass13.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState.ordinal()]) {
                case 1:
                    YKSmartRefreshLayout.this.resetStatus();
                    return null;
                case 2:
                    YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout.mState.isOpening || !yKSmartRefreshLayout.isEnableRefresh()) {
                        YKSmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                        return null;
                    }
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownToRefresh);
                    return null;
                case 3:
                    if (YKSmartRefreshLayout.this.isEnableLoadMore()) {
                        YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                        RefreshState refreshState2 = yKSmartRefreshLayout2.mState;
                        if (!refreshState2.isOpening && !refreshState2.isFinishing && (!yKSmartRefreshLayout2.mFooterNoMoreData || !yKSmartRefreshLayout2.mEnableFooterFollowWhenLoadFinished)) {
                            yKSmartRefreshLayout2.notifyStateChanged(RefreshState.PullUpToLoad);
                            return null;
                        }
                    }
                    YKSmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                    return null;
                case 4:
                    YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout3.mState.isOpening || !yKSmartRefreshLayout3.isEnableRefresh()) {
                        YKSmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                        return null;
                    }
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownCanceled);
                    YKSmartRefreshLayout.this.resetStatus();
                    return null;
                case 5:
                    if (YKSmartRefreshLayout.this.isEnableLoadMore()) {
                        YKSmartRefreshLayout yKSmartRefreshLayout4 = YKSmartRefreshLayout.this;
                        if (!yKSmartRefreshLayout4.mState.isOpening && (!yKSmartRefreshLayout4.mFooterNoMoreData || !yKSmartRefreshLayout4.mEnableFooterFollowWhenLoadFinished)) {
                            yKSmartRefreshLayout4.notifyStateChanged(RefreshState.PullUpCanceled);
                            YKSmartRefreshLayout.this.resetStatus();
                            return null;
                        }
                    }
                    YKSmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                    return null;
                case 6:
                    YKSmartRefreshLayout yKSmartRefreshLayout5 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout5.mState.isOpening || !yKSmartRefreshLayout5.isEnableRefresh()) {
                        YKSmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                        return null;
                    }
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToRefresh);
                    return null;
                case 7:
                    if (YKSmartRefreshLayout.this.isEnableLoadMore()) {
                        YKSmartRefreshLayout yKSmartRefreshLayout6 = YKSmartRefreshLayout.this;
                        RefreshState refreshState3 = yKSmartRefreshLayout6.mState;
                        if (!refreshState3.isOpening && !refreshState3.isFinishing && (!yKSmartRefreshLayout6.mFooterNoMoreData || !yKSmartRefreshLayout6.mEnableFooterFollowWhenLoadFinished)) {
                            yKSmartRefreshLayout6.notifyStateChanged(RefreshState.ReleaseToLoad);
                            return null;
                        }
                    }
                    YKSmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                    return null;
                case 8:
                    YKSmartRefreshLayout yKSmartRefreshLayout7 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout7.mState.isOpening || !yKSmartRefreshLayout7.isEnableRefresh()) {
                        YKSmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                        return null;
                    }
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    YKSmartRefreshLayout yKSmartRefreshLayout8 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout8.mState.isOpening || !yKSmartRefreshLayout8.isEnableRefresh()) {
                        YKSmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                        return null;
                    }
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    YKSmartRefreshLayout yKSmartRefreshLayout9 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout9.mState.isOpening || !yKSmartRefreshLayout9.isEnableLoadMore()) {
                        YKSmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                        return null;
                    }
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.LoadReleased);
                    return null;
                case 11:
                    YKSmartRefreshLayout.this.setStateRefreshing();
                    return null;
                case 12:
                    YKSmartRefreshLayout.this.setStateLoading();
                    return null;
                case 13:
                    YKSmartRefreshLayout yKSmartRefreshLayout10 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout10.mState != RefreshState.Refreshing) {
                        return null;
                    }
                    yKSmartRefreshLayout10.notifyStateChanged(RefreshState.RefreshFinish);
                    return null;
                case 14:
                    YKSmartRefreshLayout yKSmartRefreshLayout11 = YKSmartRefreshLayout.this;
                    if (yKSmartRefreshLayout11.mState != RefreshState.Loading) {
                        return null;
                    }
                    yKSmartRefreshLayout11.notifyStateChanged(RefreshState.LoadFinish);
                    return null;
                case 15:
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevelReleased);
                    return null;
                case 16:
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevelFinish);
                    return null;
                case 17:
                    YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevel);
                    return null;
                default:
                    return null;
            }
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel startTwoLevel(boolean z) {
            if (z) {
                AnonymousClass1 r4 = new AnimatorListenerAdapter() {
                    /* class com.youku.cmsui.YKSmartRefreshLayout.RefreshKernelImpl.AnonymousClass1 */

                    public void onAnimationCancel(Animator animator) {
                        YKSmartRefreshLayout.this.mKernel.setState(RefreshState.TwoLevel);
                        YKSmartRefreshLayout.this.postDelayed(new Runnable() {
                            /* class com.youku.cmsui.YKSmartRefreshLayout.RefreshKernelImpl.AnonymousClass1.AnonymousClass2 */

                            public void run() {
                                RefreshKernelImpl.this.finishTwoLevel();
                            }
                        }, (long) YKSmartRefreshLayout.this.mFloorDuration);
                    }

                    public void onAnimationEnd(Animator animator) {
                        YKSmartRefreshLayout.this.mKernel.setState(RefreshState.TwoLevel);
                        YKSmartRefreshLayout.this.postDelayed(new Runnable() {
                            /* class com.youku.cmsui.YKSmartRefreshLayout.RefreshKernelImpl.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                RefreshKernelImpl.this.finishTwoLevel();
                            }
                        }, (long) YKSmartRefreshLayout.this.mFloorDuration);
                    }
                };
                ValueAnimator animSpinner = animSpinner(YKSmartRefreshLayout.this.getMeasuredHeight());
                if (animSpinner != null) {
                    YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                    if (animSpinner == yKSmartRefreshLayout.reboundAnimator) {
                        animSpinner.setDuration((long) yKSmartRefreshLayout.mFloorDuration);
                        animSpinner.addListener(r4);
                    }
                }
                r4.onAnimationEnd(null);
            } else if (animSpinner(0) == null) {
                YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
            }
            return this;
        }
    }

    public YKSmartRefreshLayout(Context context) {
        this(context, null);
    }

    public static void setDefaultRefreshFooterCreator(@NonNull DefaultRefreshFooterCreator defaultRefreshFooterCreator) {
        sFooterCreator = defaultRefreshFooterCreator;
        sManualFooterCreator = true;
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull DefaultRefreshHeaderCreator defaultRefreshHeaderCreator) {
        sHeaderCreator = defaultRefreshHeaderCreator;
    }

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
        this.reboundAnimator.addListener(new AnimatorListenerAdapter() {
            /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass6 */

            public void onAnimationCancel(Animator animator) {
                super.onAnimationEnd(animator);
            }

            public void onAnimationEnd(Animator animator) {
                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                yKSmartRefreshLayout.reboundAnimator = null;
                if (yKSmartRefreshLayout.mSpinner == 0) {
                    RefreshState refreshState = yKSmartRefreshLayout.mState;
                    RefreshState refreshState2 = RefreshState.None;
                    if (refreshState != refreshState2 && !refreshState.isOpening) {
                        yKSmartRefreshLayout.notifyStateChanged(refreshState2);
                        return;
                    }
                    return;
                }
                RefreshState refreshState3 = yKSmartRefreshLayout.mState;
                if (refreshState3 != yKSmartRefreshLayout.mViceState) {
                    yKSmartRefreshLayout.setViceState(refreshState3);
                }
            }
        });
        this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass7 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                YKSmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        });
        this.reboundAnimator.setStartDelay((long) i2);
        this.reboundAnimator.start();
        return this.reboundAnimator;
    }

    /* access modifiers changed from: protected */
    public void animSpinnerBounce(float f) {
        RefreshState refreshState;
        if (this.reboundAnimator != null) {
            return;
        }
        if (f > 0.0f && ((refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
            this.animationRunnable = new BounceRunnable(f, this.mHeaderHeight);
        } else if (f < 0.0f && (this.mState == RefreshState.Loading || ((this.mEnableFooterFollowWhenLoadFinished && this.mFooterNoMoreData && isEnableLoadMore()) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableLoadMore() && this.mState != RefreshState.Refreshing)))) {
            this.animationRunnable = new BounceRunnable(f, -this.mFooterHeight);
        } else if (this.mSpinner == 0 && this.mEnableOverScrollBounce) {
            this.animationRunnable = new BounceRunnable(f, 0);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoLoadMore() {
        int i = this.mReboundDuration;
        int i2 = this.mFooterHeight;
        float f = ((float) i2) * ((this.mFooterMaxDragRate / 2.0f) + 0.5f) * 1.0f;
        if (i2 == 0) {
            i2 = 1;
        }
        return autoLoadMore(0, i, f / ((float) i2));
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoRefresh() {
        int i = this.mHandler == null ? 400 : 0;
        int i2 = this.mReboundDuration;
        int i3 = this.mHeaderHeight;
        float f = ((this.mHeaderMaxDragRate / 2.0f) + 0.5f) * ((float) i3) * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoRefresh(i, i2, f / ((float) i3));
    }

    public boolean autoRefreshNoLoad(int i) {
        int i2 = this.mHeaderHeight;
        float f = ((this.mHeaderMaxDragRate / 2.0f) + 0.5f) * ((float) i2) * 1.0f;
        if (i2 == 0) {
            i2 = 1;
        }
        return autoRefreshNoLoad(0, i, f / ((float) i2));
    }

    public boolean canScrollVertically(int i) {
        View scrollableView = this.mRefreshContent.getScrollableView();
        if (i < 0) {
            if (this.mEnableOverScrollDrag || isEnableRefresh() || ScrollBoundaryUtil.canScrollUp(scrollableView)) {
                return true;
            }
            return false;
        } else if (i <= 0 || this.mEnableOverScrollDrag || isEnableLoadMore() || ScrollBoundaryUtil.canScrollDown(scrollableView)) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void computeScroll() {
        float f;
        this.mScroller.getCurrY();
        if (this.mScroller.computeScrollOffset()) {
            int finalY = this.mScroller.getFinalY();
            if ((finalY >= 0 || ((!this.mEnableOverScrollDrag && !isEnableRefresh()) || !this.mRefreshContent.canRefresh())) && (finalY <= 0 || ((!this.mEnableOverScrollDrag && !isEnableLoadMore()) || !this.mRefreshContent.canLoadMore()))) {
                this.mVerticalPermit = true;
                invalidate();
                return;
            }
            if (this.mVerticalPermit) {
                if (Build.VERSION.SDK_INT >= 14) {
                    f = finalY > 0 ? -this.mScroller.getCurrVelocity() : this.mScroller.getCurrVelocity();
                } else {
                    f = (((float) (this.mScroller.getCurrY() - finalY)) * 1.0f) / ((float) Math.max(this.mScroller.getDuration() - this.mScroller.timePassed(), 1));
                }
                animSpinnerBounce(f);
            }
            this.mScroller.forceFinished(true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0147, code lost:
        if (r6 != 3) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ca, code lost:
        if (r4.isFinishing == false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ce, code lost:
        if (r4.isHeader == false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00dc, code lost:
        if (r4.isFinishing == false) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00e0, code lost:
        if (r4.isFooter == false) goto L_0x00e4;
     */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        RefreshState refreshState;
        char c;
        RefreshInternal refreshInternal;
        RefreshInternal refreshInternal2;
        int actionMasked = motionEvent.getActionMasked();
        int i = 0;
        int i2 = 1;
        boolean z = actionMasked == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                f += motionEvent.getX(i3);
                f2 += motionEvent.getY(i3);
            }
        }
        if (z) {
            pointerCount--;
        }
        float f3 = (float) pointerCount;
        float f4 = f / f3;
        float f5 = f2 / f3;
        if ((actionMasked == 6 || actionMasked == 5) && this.mIsBeingDragged) {
            this.mTouchY += f5 - this.mLastTouchY;
        }
        this.mLastTouchX = f4;
        this.mLastTouchY = f5;
        if (!this.mNestedInProgress || !this.mSupportNestedHScroll) {
            if (isEnabled() && (isEnableRefresh() || isEnableLoadMore() || this.mEnableOverScrollDrag)) {
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
                if (!interceptByAnimator(actionMasked)) {
                    RefreshState refreshState4 = this.mState;
                    if (!refreshState4.isFinishing && ((refreshState4 != (refreshState = RefreshState.Loading) || !this.mDisableContentWhenLoading) && (refreshState4 != RefreshState.Refreshing || !this.mDisableContentWhenRefresh))) {
                        if (this.mRefreshContent != null) {
                            if (actionMasked == 0) {
                                this.mVelocityTracker.clear();
                                this.mVelocityTracker.addMovement(motionEvent);
                                this.mRefreshContent.onActionDown(motionEvent);
                                this.mScroller.forceFinished(true);
                            } else if (actionMasked != 1) {
                                if (actionMasked == 2 && !this.mNestedInProgress) {
                                    this.mVelocityTracker.addMovement(motionEvent);
                                }
                            } else if (!this.mNestedInProgress) {
                                this.mVelocityTracker.addMovement(motionEvent);
                                this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                            }
                        }
                        if (actionMasked != 0) {
                            if (actionMasked != 1) {
                                if (actionMasked == 2) {
                                    float f6 = f4 - this.mTouchX;
                                    float f7 = f5 - this.mTouchY;
                                    if (!(this.mIsBeingDragged || (c = this.mDragDirection) == 'h' || this.mRefreshContent == null)) {
                                        if (c == 'v' || (Math.abs(f7) >= ((float) this.mTouchSlop) && Math.abs(f6) < Math.abs(f7))) {
                                            this.mDragDirection = 'v';
                                            if (f7 > 0.0f && (this.mSpinner < 0 || ((this.mEnableOverScrollDrag || isEnableRefresh()) && this.mRefreshContent.canRefresh()))) {
                                                this.mIsBeingDragged = true;
                                                this.mTouchY = f5 - ((float) this.mTouchSlop);
                                            } else if (f7 < 0.0f && (this.mSpinner > 0 || ((this.mEnableOverScrollDrag || isEnableLoadMore()) && ((this.mState == refreshState && this.mFooterLocked) || this.mRefreshContent.canLoadMore())))) {
                                                this.mIsBeingDragged = true;
                                                this.mTouchY = ((float) this.mTouchSlop) + f5;
                                            }
                                            if (this.mIsBeingDragged) {
                                                f7 = f5 - this.mTouchY;
                                                if (this.mSuperDispatchTouchEvent) {
                                                    motionEvent.setAction(3);
                                                    super.dispatchTouchEvent(motionEvent);
                                                }
                                                int i4 = this.mSpinner;
                                                if (i4 > 0 || (i4 == 0 && f7 > 0.0f)) {
                                                    this.mKernel.setState(RefreshState.PullDownToRefresh);
                                                } else {
                                                    this.mKernel.setState(RefreshState.PullUpToLoad);
                                                }
                                                getParent().requestDisallowInterceptTouchEvent(true);
                                            }
                                        } else if (Math.abs(f6) >= ((float) this.mTouchSlop) && Math.abs(f6) > Math.abs(f7) && this.mDragDirection != 'v') {
                                            this.mDragDirection = tryDragDirectionToH();
                                        }
                                    }
                                    if (this.mIsBeingDragged) {
                                        int i5 = ((int) f7) + this.mTouchSpinner;
                                        RefreshState refreshState5 = this.mViceState;
                                        if ((refreshState5.isHeader && (i5 < 0 || this.mLastSpinner < 0)) || (refreshState5.isFooter && (i5 > 0 || this.mLastSpinner > 0))) {
                                            this.mLastSpinner = i5;
                                            long eventTime = motionEvent.getEventTime();
                                            if (this.mFalsifyEvent == null) {
                                                MotionEvent obtain = MotionEvent.obtain(eventTime, eventTime, 0, this.mTouchX + f6, this.mTouchY, 0);
                                                this.mFalsifyEvent = obtain;
                                                super.dispatchTouchEvent(obtain);
                                            }
                                            MotionEvent obtain2 = MotionEvent.obtain(eventTime, eventTime, 2, this.mTouchX + f6, this.mTouchY + ((float) i5), 0);
                                            super.dispatchTouchEvent(obtain2);
                                            if (this.mFooterLocked && f7 > ((float) this.mTouchSlop) && this.mSpinner < 0) {
                                                this.mFooterLocked = false;
                                            }
                                            if (i5 > 0 && ((this.mEnableOverScrollDrag || isEnableRefresh()) && this.mRefreshContent.canRefresh())) {
                                                this.mLastTouchY = f5;
                                                this.mTouchY = f5;
                                                this.mTouchSpinner = 0;
                                                this.mKernel.setState(RefreshState.PullDownToRefresh);
                                            } else if (i5 >= 0 || ((!this.mEnableOverScrollDrag && !isEnableLoadMore()) || !this.mRefreshContent.canLoadMore())) {
                                                i = i5;
                                            } else {
                                                this.mLastTouchY = f5;
                                                this.mTouchY = f5;
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
                                                i5 = i;
                                            } else {
                                                if (this.mSpinner != 0) {
                                                    moveSpinnerInfinitely(0.0f);
                                                }
                                                return true;
                                            }
                                        }
                                        moveSpinnerInfinitely((float) i5);
                                        return true;
                                    } else if (this.mFooterLocked && f7 > ((float) this.mTouchSlop) && this.mSpinner < 0) {
                                        this.mFooterLocked = false;
                                    }
                                }
                                return super.dispatchTouchEvent(motionEvent);
                            }
                            startFlingIfNeed(null);
                            this.mDragDirection = 'n';
                            MotionEvent motionEvent2 = this.mFalsifyEvent;
                            if (motionEvent2 != null) {
                                motionEvent2.recycle();
                                this.mFalsifyEvent = null;
                                long eventTime2 = motionEvent.getEventTime();
                                MotionEvent obtain3 = MotionEvent.obtain(eventTime2, eventTime2, actionMasked, this.mTouchX, f5, 0);
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
                        this.mTouchX = f4;
                        this.mTouchY = f5;
                        this.mLastSpinner = 0;
                        this.mTouchSpinner = this.mSpinner;
                        this.mIsBeingDragged = false;
                        this.mSuperDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                        if (this.mState != RefreshState.TwoLevel || this.mTouchY >= ((float) ((getMeasuredHeight() * 5) / 6))) {
                            return true;
                        }
                        this.mDragDirection = tryDragDirectionToH();
                        return this.mSuperDispatchTouchEvent;
                    }
                }
                if (this.mInterceptEventWhenStatueChanged) {
                    return false;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        int i6 = this.mTotalUnconsumed;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (actionMasked == 2 && i6 == this.mTotalUnconsumed) {
            int i7 = (int) this.mLastTouchX;
            int width = getWidth();
            float f8 = this.mLastTouchX;
            if (width != 0) {
                i2 = width;
            }
            float f9 = f8 / ((float) i2);
            if (isEnableRefresh() && this.mSpinner > 0 && (refreshInternal2 = this.mRefreshHeader) != null && refreshInternal2.isSupportHorizontalDrag()) {
                this.mRefreshHeader.onHorizontalDrag(f9, i7, width);
            } else if (isEnableLoadMore() && this.mSpinner < 0 && (refreshInternal = this.mRefreshFooter) != null && refreshInternal.isSupportHorizontalDrag()) {
                this.mRefreshFooter.onHorizontalDrag(f9, i7, width);
            }
        }
        return dispatchTouchEvent;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        Paint paint;
        Paint paint2;
        RefreshContent refreshContent = this.mRefreshContent;
        View view2 = refreshContent != null ? refreshContent.getView() : null;
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null && refreshInternal.getView() == view) {
            if (!isEnableRefresh() || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getTop() + view2.getPaddingTop() + this.mSpinner, view.getTop());
                int i = this.mHeaderBackgroundColor;
                if (!(i == 0 || (paint2 = this.mPaint) == null)) {
                    paint2.setColor(i);
                    if (this.mRefreshHeader.getSpinnerStyle() == gd2.Scale) {
                        max = view.getBottom();
                    } else if (this.mRefreshHeader.getSpinnerStyle() == gd2.Translate) {
                        max = view.getBottom() + this.mSpinner;
                    }
                    canvas.drawRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) max, this.mPaint);
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
            if (!isEnableLoadMore() || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.mSpinner, view.getBottom());
                int i2 = this.mFooterBackgroundColor;
                if (!(i2 == 0 || (paint = this.mPaint) == null)) {
                    paint.setColor(i2);
                    if (this.mRefreshFooter.getSpinnerStyle() == gd2.Scale) {
                        min = view.getTop();
                    } else if (this.mRefreshFooter.getSpinnerStyle() == gd2.Translate) {
                        min = view.getTop() + this.mSpinner;
                    }
                    canvas.drawRect((float) view.getLeft(), (float) min, (float) view.getRight(), (float) view.getBottom(), this.mPaint);
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
    public YKSmartRefreshLayout getLayout() {
        return this;
    }

    @Override // androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedParent.getNestedScrollAxes();
    }

    public Interpolator getReboundInterpolator() {
        return this.mReboundInterpolator;
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
    public RefreshState getState() {
        return this.mState;
    }

    public YKSmartRefreshLayout hideLoadingMoreFooterWhenNoMoreData(boolean z) {
        if (!(this.mRefreshFooter == null || this.mRefreshContent == null)) {
            notifyStateChanged(RefreshState.LoadFinish);
            boolean z2 = true;
            int onFinish = this.mRefreshFooter.onFinish(this, true);
            OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
            if (onMultiPurposeListener != null) {
                RefreshInternal refreshInternal = this.mRefreshFooter;
                if (refreshInternal instanceof RefreshFooter) {
                    onMultiPurposeListener.onFooterFinish((RefreshFooter) refreshInternal, true);
                }
            }
            if (onFinish < Integer.MAX_VALUE) {
                if (!this.mEnableFooterFollowWhenLoadFinished || this.mSpinner >= 0 || !this.mRefreshContent.canLoadMore()) {
                    z2 = false;
                }
                int i = this.mSpinner;
                int max = i - (z2 ? Math.max(i, -this.mFooterHeight) : 0);
                if (this.mIsBeingDragged) {
                    this.mTouchSpinner = this.mSpinner - max;
                    this.mTouchY = this.mLastTouchY;
                    this.mIsBeingDragged = false;
                    long currentTimeMillis = System.currentTimeMillis();
                    float f = (float) max;
                    super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, this.mLastTouchX, this.mTouchY + f + ((float) (this.mTouchSlop * 2)), 0));
                    super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, this.mLastTouchX, this.mTouchY + f, 0));
                } else if (this.mTotalUnconsumed != 0) {
                    this.mDragDirection = tryDragDirectionToH();
                    this.mTotalUnconsumed = 0;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis2, currentTimeMillis2, 3, this.mLastTouchX, this.mTouchY + ((float) max), 0));
                }
                this.mRefreshContent.getScrollableView().scrollBy(0, z ? this.mSpinner : -this.mSpinner);
                this.mKernel.moveSpinner(0, false);
                resetStatus();
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean interceptByAnimator(int i) {
        if (i == 0) {
            this.animationRunnable = null;
            if (this.reboundAnimator != null) {
                RefreshState refreshState = this.mState;
                if (refreshState.isFinishing) {
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
        }
        if (this.reboundAnimator != null) {
            return true;
        }
        return false;
    }

    public boolean isAutoRefresh() {
        return this.isAutoRefresh;
    }

    public boolean isDispatchEventWhenStatueChanged() {
        return this.mInterceptEventWhenStatueChanged;
    }

    public boolean isEnableLoadMore() {
        return this.mEnableLoadMore && !this.mEnablePureScrollMode;
    }

    public boolean isEnableRefresh() {
        return this.mEnableRefresh && !this.mEnablePureScrollMode;
    }

    public boolean isIdle() {
        return this.mState == RefreshState.None;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mNestedChild.isNestedScrollingEnabled();
    }

    public boolean isSupportDragHDirection() {
        return this.mSupportDragHDirection;
    }

    public boolean isSupportNestedHScroll() {
        return this.mSupportNestedHScroll;
    }

    /* access modifiers changed from: protected */
    public void moveSpinnerInfinitely(float f) {
        RefreshState refreshState;
        RefreshState refreshState2 = this.mState;
        if (refreshState2 == RefreshState.TwoLevel && f > 0.0f) {
            this.mKernel.moveSpinner(Math.min((int) f, getMeasuredHeight()), true);
        } else if (refreshState2 != RefreshState.Refreshing || f < 0.0f) {
            if (f < 0.0f && (refreshState2 == RefreshState.Loading || ((this.mEnableFooterFollowWhenLoadFinished && this.mFooterNoMoreData && isEnableLoadMore()) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableLoadMore())))) {
                int i = this.mFooterHeight;
                if (f > ((float) (-i))) {
                    this.mKernel.moveSpinner((int) f, true);
                } else {
                    double d = (double) ((this.mFooterMaxDragRate - 1.0f) * ((float) i));
                    int max = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                    int i2 = this.mFooterHeight;
                    double d2 = (double) (max - i2);
                    double d3 = (double) (-Math.min(0.0f, (((float) i2) + f) * this.mDragRate));
                    double d4 = -d3;
                    if (d2 == 0.0d) {
                        d2 = 1.0d;
                    }
                    this.mKernel.moveSpinner(((int) (-Math.min(d * (1.0d - Math.pow(100.0d, d4 / d2)), d3))) - this.mFooterHeight, true);
                }
            } else if (f >= 0.0f) {
                double d5 = (double) (this.mHeaderMaxDragRate * ((float) this.mHeaderHeight));
                double max2 = (double) Math.max(this.mScreenHeightPixels / 2, getHeight());
                double max3 = (double) Math.max(0.0f, this.mDragRate * f);
                double d6 = -max3;
                if (max2 == 0.0d) {
                    max2 = 1.0d;
                }
                this.mKernel.moveSpinner((int) Math.min(d5 * (1.0d - Math.pow(100.0d, d6 / max2)), max3), true);
            } else {
                double d7 = (double) (this.mFooterMaxDragRate * ((float) this.mFooterHeight));
                double max4 = (double) Math.max(this.mScreenHeightPixels / 2, getHeight());
                double d8 = (double) (-Math.min(0.0f, this.mDragRate * f));
                double d9 = -d8;
                if (max4 == 0.0d) {
                    max4 = 1.0d;
                }
                this.mKernel.moveSpinner((int) (-Math.min(d7 * (1.0d - Math.pow(100.0d, d9 / max4)), d8)), true);
            }
        } else if (this.mAblePullingDownWhenRefreshing) {
            int i3 = this.mHeaderHeight;
            if (f < ((float) i3)) {
                this.mKernel.moveSpinner((int) f, true);
            } else {
                double d10 = (double) ((this.mHeaderMaxDragRate - 1.0f) * ((float) i3));
                int max5 = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i4 = this.mHeaderHeight;
                double d11 = (double) (max5 - i4);
                double max6 = (double) Math.max(0.0f, (f - ((float) i4)) * this.mDragRate);
                double d12 = -max6;
                if (d11 == 0.0d) {
                    d11 = 1.0d;
                }
                this.mKernel.moveSpinner(((int) Math.min(d10 * (1.0d - Math.pow(100.0d, d12 / d11)), max6)) + this.mHeaderHeight, true);
            }
        }
        if (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableLoadMore() && f < 0.0f && (refreshState = this.mState) != RefreshState.Refreshing && refreshState != RefreshState.Loading && refreshState != RefreshState.LoadFinish) {
            setStateDirectLoading();
            if (this.mDisableContentWhenLoading) {
                this.animationRunnable = null;
                this.mKernel.animSpinner(-this.mFooterHeight);
            }
        }
    }

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
            if (this.mState == RefreshState.None && this.isAutoRefresh) {
                this.isAutoRefresh = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        RefreshInternal refreshInternal;
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            List<DelayedRunnable> list = this.mListDelayedRunnable;
            View view = null;
            if (list != null) {
                Iterator<DelayedRunnable> it = list.iterator();
                while (it.hasNext()) {
                    Runnable runnable = (DelayedRunnable) it.next();
                    this.mHandler.postDelayed(runnable, ((DelayedRunnable) runnable).delayMillis);
                }
                this.mListDelayedRunnable.clear();
                this.mListDelayedRunnable = null;
            }
            if (this.mRefreshHeader == null) {
                setRefreshHeader(sHeaderCreator.createRefreshHeader(getContext(), this));
            }
            if (this.mRefreshFooter == null) {
                setRefreshFooter(sFooterCreator.createRefreshFooter(getContext(), this));
            } else {
                this.mEnableLoadMore = this.mEnableLoadMore || !this.mManualLoadMore;
            }
            if (this.mRefreshContent == null) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    RefreshInternal refreshInternal2 = this.mRefreshHeader;
                    if ((refreshInternal2 == null || childAt != refreshInternal2.getView()) && ((refreshInternal = this.mRefreshFooter) == null || childAt != refreshInternal.getView())) {
                        this.mRefreshContent = new RefreshContentWrapper(childAt);
                    }
                }
            }
            if (this.mRefreshContent == null) {
                int dp2px = DensityUtil.dp2px(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.srl_content_empty);
                super.addView(textView, -1, -1);
                RefreshContentWrapper refreshContentWrapper = new RefreshContentWrapper(textView);
                this.mRefreshContent = refreshContentWrapper;
                refreshContentWrapper.getView().setPadding(dp2px, dp2px, dp2px, dp2px);
            }
            int i2 = this.mFixedHeaderViewId;
            View findViewById = i2 > 0 ? findViewById(i2) : null;
            int i3 = this.mFixedFooterViewId;
            if (i3 > 0) {
                view = findViewById(i3);
            }
            this.mRefreshContent.setScrollBoundaryDecider(this.mScrollBoundaryDecider);
            this.mRefreshContent.setEnableLoadMoreWhenContentNotFull(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.setUpComponent(this.mKernel, findViewById, view);
            if (this.mSpinner != 0) {
                notifyStateChanged(RefreshState.None);
                RefreshContent refreshContent = this.mRefreshContent;
                this.mSpinner = 0;
                refreshContent.moveSpinner(0);
            }
            if (!this.mManualNestedScrolling && !isNestedScrollingEnabled()) {
                post(new Runnable() {
                    /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass3 */

                    public void run() {
                        for (ViewParent parent = YKSmartRefreshLayout.this.getParent(); parent != null; parent = parent.getParent()) {
                            if (parent instanceof NestedScrollingParent) {
                                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                                if (((NestedScrollingParent) parent).onStartNestedScroll(yKSmartRefreshLayout, yKSmartRefreshLayout, 2)) {
                                    YKSmartRefreshLayout.this.setNestedScrollingEnabled(true);
                                    YKSmartRefreshLayout.this.mManualNestedScrolling = false;
                                    return;
                                }
                            }
                        }
                    }
                });
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
        if (!(refreshInternal5 == null || refreshInternal5.getSpinnerStyle() == gd2.FixedBehind)) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        RefreshInternal refreshInternal6 = this.mRefreshFooter;
        if (!(refreshInternal6 == null || refreshInternal6.getSpinnerStyle() == gd2.FixedBehind)) {
            super.bringChildToFront(this.mRefreshFooter.getView());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mKernel.moveSpinner(0, true);
        notifyStateChanged(RefreshState.None);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        this.mManualLoadMore = true;
        this.mManualNestedScrolling = true;
        this.animationRunnable = null;
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.reboundAnimator.removeAllUpdateListeners();
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
    }

    /* access modifiers changed from: protected */
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
            char c = 0;
            while (true) {
                i = 2;
                if (i4 >= childCount) {
                    break;
                }
                View childAt = super.getChildAt(i4);
                if (YKSmartUtil.isContentView(childAt) && (c < 2 || i4 == 1)) {
                    i5 = i4;
                    c = 2;
                } else if (!(childAt instanceof RefreshInternal) && c < 1) {
                    c = i4 > 0 ? (char) 1 : 0;
                    i5 = i4;
                }
                i4++;
            }
            if (i5 >= 0) {
                this.mRefreshContent = new RefreshContentWrapper(super.getChildAt(i5));
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
            RefreshContent refreshContent = this.mRefreshContent;
            boolean z2 = true;
            if (refreshContent != null && refreshContent.getView() == childAt) {
                boolean z3 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefresh() && this.mRefreshHeader != null;
                View view = this.mRefreshContent.getView();
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int max = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop + Math.max(this.mRefreshHeader.getView().getBottom(), this.mHeaderInsetStart);
                int measuredWidth = view.getMeasuredWidth() + i7;
                int measuredHeight = (view.getMeasuredHeight() + max) - Math.max(this.mRefreshHeader.getView().getBottom(), this.mHeaderInsetStart);
                if (z3 && (this.mEnableHeaderTranslationContent || this.mRefreshHeader.getSpinnerStyle() == gd2.FixedBehind)) {
                    int i8 = this.mHeaderHeight;
                    max += i8;
                    measuredHeight += i8;
                }
                view.layout(i7, max, measuredWidth, measuredHeight);
            }
            RefreshInternal refreshInternal = this.mRefreshHeader;
            if (refreshInternal != null && refreshInternal.getView() == childAt) {
                boolean z4 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefresh();
                View view2 = this.mRefreshHeader.getView();
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                int i9 = ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                int i10 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                int measuredWidth2 = view2.getMeasuredWidth() + i9;
                int measuredHeight2 = view2.getMeasuredHeight() + i10;
                if (!z4 && this.mRefreshHeader.getSpinnerStyle() == gd2.Translate) {
                    int i11 = i10 - measuredHeight2;
                    measuredHeight2 = this.mHeaderInsetStart;
                    i10 = i11 + measuredHeight2;
                }
                view2.layout(i9, i10, measuredWidth2, measuredHeight2);
            }
            RefreshInternal refreshInternal2 = this.mRefreshFooter;
            if (refreshInternal2 != null && refreshInternal2.getView() == childAt) {
                if (!isInEditMode() || !this.mEnablePreviewInEditMode || !isEnableLoadMore()) {
                    z2 = false;
                }
                View view3 = this.mRefreshFooter.getView();
                LayoutParams layoutParams3 = (LayoutParams) view3.getLayoutParams();
                gd2 spinnerStyle = this.mRefreshFooter.getSpinnerStyle();
                int i12 = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin;
                int measuredHeight3 = (((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                if (z2 || spinnerStyle == gd2.FixedFront || spinnerStyle == gd2.FixedBehind) {
                    i5 = this.mFooterHeight;
                } else {
                    if (spinnerStyle == gd2.Scale && this.mSpinner < 0) {
                        i5 = Math.max(isEnableLoadMore() ? -this.mSpinner : 0, 0);
                    }
                    view3.layout(i12, measuredHeight3, view3.getMeasuredWidth() + i12, view3.getMeasuredHeight() + measuredHeight3);
                }
                measuredHeight3 -= i5;
                view3.layout(i12, measuredHeight3, view3.getMeasuredWidth() + i12, view3.getMeasuredHeight() + measuredHeight3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        RefreshInternal refreshInternal;
        RefreshInternal refreshInternal2;
        int i3;
        int i4;
        boolean z = isInEditMode() && this.mEnablePreviewInEditMode;
        int childCount = super.getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = super.getChildAt(i6);
            RefreshInternal refreshInternal3 = this.mRefreshHeader;
            if (refreshInternal3 != null && refreshInternal3.getView() == childAt) {
                View view = this.mRefreshHeader.getView();
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width);
                if (this.mHeaderHeightStatus.gteReplaceWith(n70.XmlLayoutUnNotify)) {
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((this.mHeaderHeight - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), 1073741824));
                } else if (this.mRefreshHeader.getSpinnerStyle() == gd2.MatchLayout) {
                    if (!this.mHeaderHeightStatus.b) {
                        super.measureChild(view, childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), Integer.MIN_VALUE));
                        i4 = view.getMeasuredHeight();
                    } else {
                        i4 = 0;
                    }
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), 1073741824));
                    if (i4 > 0 && i4 != view.getMeasuredHeight()) {
                        this.mHeaderHeight = i4 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    }
                } else {
                    int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    if (i7 > 0) {
                        n70 n70 = this.mHeaderHeightStatus;
                        n70 n702 = n70.XmlExactUnNotify;
                        if (n70.a(n702)) {
                            this.mHeaderHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            this.mHeaderHeightStatus = n702;
                        }
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams).height, 1073741824));
                    } else if (i7 == -2) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), Integer.MIN_VALUE));
                        int measuredHeight = view.getMeasuredHeight();
                        if (measuredHeight > 0) {
                            n70 n703 = this.mHeaderHeightStatus;
                            n70 n704 = n70.XmlWrapUnNotify;
                            if (n703.a(n704)) {
                                this.mHeaderHeightStatus = n704;
                                this.mHeaderHeight = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            }
                        }
                        if (measuredHeight <= 0) {
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((this.mHeaderHeight - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), 1073741824));
                        }
                    } else if (i7 == -1) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((this.mHeaderHeight - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), 1073741824));
                    } else {
                        view.measure(childMeasureSpec, i2);
                    }
                }
                if (this.mRefreshHeader.getSpinnerStyle() == gd2.Scale && !z) {
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((Math.max(0, isEnableRefresh() ? this.mSpinner : 0) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, 0), 1073741824));
                }
                n70 n705 = this.mHeaderHeightStatus;
                if (!n705.b) {
                    this.mHeaderHeightStatus = n705.b();
                    RefreshInternal refreshInternal4 = this.mRefreshHeader;
                    RefreshKernel refreshKernel = this.mKernel;
                    int i8 = this.mHeaderHeight;
                    refreshInternal4.onInitialized(refreshKernel, i8, (int) (this.mHeaderMaxDragRate * ((float) i8)));
                }
                if (z && isEnableRefresh()) {
                    i5 += view.getMeasuredHeight();
                }
            }
            RefreshInternal refreshInternal5 = this.mRefreshFooter;
            if (refreshInternal5 != null && refreshInternal5.getView() == childAt) {
                View view2 = this.mRefreshFooter.getView();
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams2).width);
                if (this.mFooterHeightStatus.gteReplaceWith(n70.XmlLayoutUnNotify)) {
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((this.mFooterHeight - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 0), 1073741824));
                } else if (this.mRefreshFooter.getSpinnerStyle() == gd2.MatchLayout) {
                    if (!this.mFooterHeightStatus.b) {
                        super.measureChild(view2, childMeasureSpec2, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, Integer.MIN_VALUE));
                        i3 = view2.getMeasuredHeight();
                    } else {
                        i3 = 0;
                    }
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 1073741824));
                    if (i3 > 0 && i3 != view2.getMeasuredHeight()) {
                        this.mHeaderHeight = i3 + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                    }
                } else {
                    int i9 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                    if (i9 > 0) {
                        n70 n706 = this.mFooterHeightStatus;
                        n70 n707 = n70.XmlExactUnNotify;
                        if (n706.a(n707)) {
                            this.mFooterHeight = ((ViewGroup.MarginLayoutParams) layoutParams2).height + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                            this.mFooterHeightStatus = n707;
                        }
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams2).height, 1073741824));
                    } else if (i9 == -2) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 0), Integer.MIN_VALUE));
                        int measuredHeight2 = view2.getMeasuredHeight();
                        if (measuredHeight2 > 0) {
                            n70 n708 = this.mFooterHeightStatus;
                            n70 n709 = n70.XmlWrapUnNotify;
                            if (n708.a(n709)) {
                                this.mFooterHeightStatus = n709;
                                this.mFooterHeight = view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                            }
                        }
                        if (measuredHeight2 <= 0) {
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((this.mFooterHeight - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 0), 1073741824));
                        }
                    } else if (i9 == -1) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((this.mFooterHeight - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 0), 1073741824));
                    } else {
                        view2.measure(childMeasureSpec2, i2);
                    }
                }
                if (this.mRefreshFooter.getSpinnerStyle() == gd2.Scale && !z) {
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((Math.max(0, this.mEnableLoadMore ? -this.mSpinner : 0) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 0), 1073741824));
                }
                n70 n7010 = this.mFooterHeightStatus;
                if (!n7010.b) {
                    this.mFooterHeightStatus = n7010.b();
                    RefreshInternal refreshInternal6 = this.mRefreshFooter;
                    RefreshKernel refreshKernel2 = this.mKernel;
                    int i10 = this.mFooterHeight;
                    refreshInternal6.onInitialized(refreshKernel2, i10, (int) (this.mFooterMaxDragRate * ((float) i10)));
                }
                if (z && isEnableLoadMore()) {
                    i5 += view2.getMeasuredHeight();
                }
            }
            RefreshContent refreshContent = this.mRefreshContent;
            if (refreshContent != null && refreshContent.getView() == childAt) {
                View view3 = this.mRefreshContent.getView();
                LayoutParams layoutParams3 = (LayoutParams) view3.getLayoutParams();
                view3.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams3).width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + ((!z || !isEnableRefresh() || (refreshInternal2 = this.mRefreshHeader) == null || (!this.mEnableHeaderTranslationContent && refreshInternal2.getSpinnerStyle() != gd2.FixedBehind)) ? 0 : this.mHeaderHeight) + ((!z || !isEnableLoadMore() || (refreshInternal = this.mRefreshFooter) == null || (!this.mEnableFooterTranslationContent && refreshInternal.getSpinnerStyle() != gd2.FixedBehind)) ? 0 : this.mFooterHeight), ((ViewGroup.MarginLayoutParams) layoutParams3).height));
                i5 += view3.getMeasuredHeight();
            }
        }
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), View.resolveSize(i5, i2));
        this.mLastTouchX = (float) (getMeasuredWidth() / 2);
    }

    @Override // androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f, float f2, boolean z) {
        return this.mNestedChild.dispatchNestedFling(f, f2, z);
    }

    @Override // androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f, float f2) {
        return (this.mFooterLocked && f2 > 0.0f) || startFlingIfNeed(Float.valueOf(-f2)) || this.mNestedChild.dispatchNestedPreFling(f, f2);
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
            RefreshState refreshState = this.mViceState;
            if (refreshState.isOpening || refreshState == RefreshState.None) {
                if (this.mSpinner > 0) {
                    this.mKernel.setState(RefreshState.PullDownToRefresh);
                } else {
                    this.mKernel.setState(RefreshState.PullUpToLoad);
                }
            }
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
        this.mNestedChild.dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        int i5 = i4 + this.mParentOffsetInWindow[1];
        if (i5 == 0) {
            return;
        }
        if (this.mEnableOverScrollDrag || ((i5 < 0 && isEnableRefresh()) || (i5 > 0 && isEnableLoadMore()))) {
            if (this.mViceState == RefreshState.None) {
                this.mKernel.setState(i5 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
            }
            int i6 = this.mTotalUnconsumed - i5;
            this.mTotalUnconsumed = i6;
            moveSpinnerInfinitely((float) i6);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i) {
        this.mNestedParent.onNestedScrollAccepted(view, view2, i);
        this.mNestedChild.startNestedScroll(i & 2);
        this.mTotalUnconsumed = this.mSpinner;
        this.mNestedInProgress = true;
    }

    @Override // androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i) {
        if (!(isEnabled() && isNestedScrollingEnabled() && (i & 2) != 0) || (!this.mEnableOverScrollDrag && !isEnableRefresh() && !isEnableLoadMore())) {
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
        if (refreshState == RefreshState.TwoLevel) {
            if (this.mVelocityTracker.getYVelocity() > -1000.0f && this.mSpinner > getMeasuredHeight() / 2) {
                ValueAnimator animSpinner = this.mKernel.animSpinner(getMeasuredHeight());
                if (animSpinner != null) {
                    animSpinner.setDuration((long) this.mFloorDuration);
                }
            } else if (this.mIsBeingDragged) {
                this.mKernel.finishTwoLevel();
            }
        } else if (refreshState == RefreshState.Loading || (this.mEnableFooterFollowWhenLoadFinished && this.mFooterNoMoreData && this.mSpinner < 0 && isEnableLoadMore())) {
            int i = this.mSpinner;
            int i2 = this.mFooterHeight;
            if (i < (-i2)) {
                this.mKernel.animSpinner(-i2);
            } else if (i > 0) {
                this.mKernel.animSpinner(0);
            }
        } else {
            RefreshState refreshState2 = this.mState;
            if (refreshState2 == RefreshState.Refreshing) {
                if (!(getRefreshHeader() instanceof YKPageRefreshHeader)) {
                    int i3 = this.mSpinner;
                    int i4 = this.mHeaderHeight;
                    if (i3 > i4) {
                        this.mKernel.animSpinner(i4);
                    } else if (i3 < 0) {
                        this.mKernel.animSpinner(0);
                    }
                } else if (this.mSpinner > ((YKPageRefreshHeader) getRefreshHeader()).mRefreshingHeight) {
                    this.mKernel.animSpinner(((YKPageRefreshHeader) getRefreshHeader()).mRefreshingHeight);
                } else if (this.mSpinner < 0) {
                    this.mKernel.animSpinner(0);
                }
            } else if (refreshState2 == RefreshState.PullDownToRefresh) {
                this.mKernel.setState(RefreshState.PullDownCanceled);
            } else if (refreshState2 == RefreshState.PullUpToLoad) {
                this.mKernel.setState(RefreshState.PullUpCanceled);
            } else if (refreshState2 == RefreshState.ReleaseToRefresh) {
                setStateRefreshing();
            } else if (refreshState2 == RefreshState.ReleaseToLoad) {
                setStateLoading();
            } else if (refreshState2 == RefreshState.ReleaseToTwoLevel) {
                this.mKernel.setState(RefreshState.TwoLevelReleased);
            } else if (this.mSpinner != 0) {
                this.mKernel.animSpinner(0);
            }
        }
    }

    public boolean post(@NonNull Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler.post(new DelayedRunnable(runnable, 0));
        }
        List<DelayedRunnable> list = this.mListDelayedRunnable;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mListDelayedRunnable = list;
        list.add(new DelayedRunnable(runnable, 0));
        return false;
    }

    public boolean postDelayed(@NonNull Runnable runnable, long j) {
        if (j == 0) {
            new DelayedRunnable(runnable, 0).run();
            return true;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler.postDelayed(new DelayedRunnable(runnable, 0), j);
        }
        List<DelayedRunnable> list = this.mListDelayedRunnable;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mListDelayedRunnable = list;
        list.add(new DelayedRunnable(runnable, j));
        return false;
    }

    /* access modifiers changed from: protected */
    public void resetStatus() {
        RefreshState refreshState = this.mState;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2 && this.mSpinner == 0) {
            notifyStateChanged(refreshState2);
        }
        if (this.mSpinner != 0) {
            this.mKernel.animSpinner(0);
        }
    }

    public YKSmartRefreshLayout setAblePullingDownWhenRefreshing(boolean z) {
        this.mAblePullingDownWhenRefreshing = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableNestedScroll(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    public YKSmartRefreshLayout setInterceptEventWhenStatueChanged(boolean z) {
        this.mInterceptEventWhenStatueChanged = z;
        return this;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.mManualNestedScrolling = true;
        this.mNestedChild.setNestedScrollingEnabled(z);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshContent(@NonNull View view) {
        return setRefreshContent(view, -1, -1);
    }

    /* access modifiers changed from: protected */
    public void setStateDirectLoading() {
        RefreshState refreshState = this.mState;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.mLastOpenTime = System.currentTimeMillis();
            this.mFooterLocked = true;
            notifyStateChanged(refreshState2);
            OnLoadMoreListener onLoadMoreListener = this.mLoadMoreListener;
            if (onLoadMoreListener != null) {
                onLoadMoreListener.onLoadMore(this);
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
                onMultiPurposeListener.onLoadMore(this);
                int i2 = this.mFooterHeight;
                this.mOnMultiPurposeListener.onFooterStartAnimator((RefreshFooter) this.mRefreshFooter, i2, (int) (this.mFooterMaxDragRate * ((float) i2)));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setStateLoading() {
        AnonymousClass4 r0 = new AnimatorListenerAdapter() {
            /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass4 */

            public void onAnimationEnd(Animator animator) {
                YKSmartRefreshLayout.this.setStateDirectLoading();
            }
        };
        notifyStateChanged(RefreshState.LoadReleased);
        ValueAnimator animSpinner = this.mKernel.animSpinner(-this.mFooterHeight);
        if (animSpinner != null) {
            animSpinner.addListener(r0);
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
            r0.onAnimationEnd(null);
        }
    }

    /* access modifiers changed from: protected */
    public void setStateRefreshing() {
        ValueAnimator valueAnimator;
        AnonymousClass5 r0 = new AnimatorListenerAdapter() {
            /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass5 */

            public void onAnimationEnd(Animator animator) {
                YKSmartRefreshLayout.this.mLastOpenTime = System.currentTimeMillis();
                YKSmartRefreshLayout.this.notifyStateChanged(RefreshState.Refreshing);
                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                OnRefreshListener onRefreshListener = yKSmartRefreshLayout.mRefreshListener;
                if (onRefreshListener != null) {
                    onRefreshListener.onRefresh(yKSmartRefreshLayout);
                } else if (yKSmartRefreshLayout.mOnMultiPurposeListener == null) {
                    yKSmartRefreshLayout.finishRefresh(3000);
                }
                YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                RefreshInternal refreshInternal = yKSmartRefreshLayout2.mRefreshHeader;
                if (refreshInternal != null) {
                    int i = yKSmartRefreshLayout2.mHeaderHeight;
                    refreshInternal.onStartAnimator(yKSmartRefreshLayout2, i, (int) (yKSmartRefreshLayout2.mHeaderMaxDragRate * ((float) i)));
                }
                YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                OnMultiPurposeListener onMultiPurposeListener = yKSmartRefreshLayout3.mOnMultiPurposeListener;
                if (onMultiPurposeListener != null && (yKSmartRefreshLayout3.mRefreshHeader instanceof RefreshHeader)) {
                    onMultiPurposeListener.onRefresh(yKSmartRefreshLayout3);
                    YKSmartRefreshLayout yKSmartRefreshLayout4 = YKSmartRefreshLayout.this;
                    int i2 = yKSmartRefreshLayout4.mHeaderHeight;
                    yKSmartRefreshLayout4.mOnMultiPurposeListener.onHeaderStartAnimator((RefreshHeader) yKSmartRefreshLayout4.mRefreshHeader, i2, (int) (yKSmartRefreshLayout4.mHeaderMaxDragRate * ((float) i2)));
                }
            }
        };
        notifyStateChanged(RefreshState.RefreshReleased);
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal instanceof YKPageRefreshHeader) {
            valueAnimator = this.mKernel.animSpinner(Math.min(this.mSpinner, Math.min(((YKPageRefreshHeader) refreshInternal).mRefreshingHeight, this.mHeaderHeight)));
        } else {
            valueAnimator = this.mKernel.animSpinner(this.mHeaderHeight);
        }
        if (valueAnimator != null) {
            valueAnimator.addListener(r0);
        }
        RefreshInternal refreshInternal2 = this.mRefreshHeader;
        if (refreshInternal2 != null) {
            int i = this.mHeaderHeight;
            refreshInternal2.onReleased(this, i, (int) (this.mHeaderMaxDragRate * ((float) i)));
        }
        OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
        if (onMultiPurposeListener != null) {
            RefreshInternal refreshInternal3 = this.mRefreshHeader;
            if (refreshInternal3 instanceof RefreshHeader) {
                int i2 = this.mHeaderHeight;
                onMultiPurposeListener.onHeaderReleased((RefreshHeader) refreshInternal3, i2, (int) (this.mHeaderMaxDragRate * ((float) i2)));
            }
        }
        if (valueAnimator == null) {
            r0.onAnimationEnd(null);
        }
    }

    public YKSmartRefreshLayout setSupportDragHDirection(boolean z) {
        this.mSupportDragHDirection = z;
        return this;
    }

    public YKSmartRefreshLayout setSupportNestedHScroll(boolean z) {
        this.mSupportNestedHScroll = z;
        return this;
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
    public boolean startFlingIfNeed(Float f) {
        RefreshState refreshState;
        float yVelocity = f == null ? this.mVelocityTracker.getYVelocity() : f.floatValue();
        if (Math.abs(yVelocity) > ((float) this.mMinimumVelocity)) {
            if ((yVelocity < 0.0f && ((this.mEnableOverScrollBounce && (this.mEnableOverScrollDrag || isEnableLoadMore())) || ((this.mState == RefreshState.Loading && this.mSpinner >= 0) || (this.mEnableAutoLoadMore && isEnableLoadMore())))) || (yVelocity > 0.0f && ((this.mEnableOverScrollBounce && (this.mEnableOverScrollDrag || isEnableRefresh())) || (this.mState == RefreshState.Refreshing && this.mSpinner <= 0)))) {
                this.mVerticalPermit = false;
                this.mScroller.fling(0, 0, 0, (int) (-yVelocity), 0, 0, StandOutWindow.StandOutLayoutParams.AUTO_POSITION, Integer.MAX_VALUE);
                this.mScroller.computeScrollOffset();
                invalidate();
            }
            if (!(((float) this.mSpinner) * yVelocity >= 0.0f || (refreshState = this.mState) == RefreshState.TwoLevel || refreshState == this.mViceState)) {
                this.animationRunnable = new FlingRunnable(yVelocity).start();
                return true;
            }
        }
        return false;
    }

    public char tryDragDirectionToH() {
        if (this.mSupportDragHDirection) {
            return 'h';
        }
        return this.mDragDirection;
    }

    public YKSmartRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean autoRefreshNoLoad(int i, final int i2, final float f) {
        if (this.mState != RefreshState.None || !isEnableRefresh()) {
            return false;
        }
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        AnonymousClass11 r0 = new Runnable() {
            /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass11 */

            public void run() {
                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                RefreshInternal refreshInternal = yKSmartRefreshLayout.mRefreshHeader;
                if (refreshInternal instanceof YKPageRefreshHeader) {
                    yKSmartRefreshLayout.reboundAnimator = ValueAnimator.ofInt(0, Math.min(((YKPageRefreshHeader) refreshInternal).mRefreshingHeight, yKSmartRefreshLayout.mHeaderHeight));
                } else {
                    yKSmartRefreshLayout.reboundAnimator = ValueAnimator.ofInt(yKSmartRefreshLayout.mSpinner, (int) (((float) yKSmartRefreshLayout.mHeaderHeight) * f));
                }
                YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                yKSmartRefreshLayout2.reboundAnimator.setDuration((long) yKSmartRefreshLayout2.mReboundDuration);
                YKSmartRefreshLayout.this.reboundAnimator.setInterpolator(new DecelerateInterpolator());
                YKSmartRefreshLayout.this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass11.AnonymousClass1 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        YKSmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
                    }
                });
                YKSmartRefreshLayout.this.reboundAnimator.addListener(new AnimatorListenerAdapter() {
                    /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass11.AnonymousClass2 */

                    public void onAnimationEnd(Animator animator) {
                        YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                        yKSmartRefreshLayout.reboundAnimator = null;
                        yKSmartRefreshLayout.postDelayed(new Runnable() {
                            /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass11.AnonymousClass2.AnonymousClass1 */

                            public void run() {
                                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                                if (yKSmartRefreshLayout.mState == RefreshState.None) {
                                    yKSmartRefreshLayout.mKernel.animSpinner(0);
                                }
                            }
                        }, (long) i2);
                    }

                    public void onAnimationStart(Animator animator) {
                        YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                        yKSmartRefreshLayout.mLastTouchX = (float) (yKSmartRefreshLayout.getMeasuredWidth() / 2);
                    }
                });
                YKSmartRefreshLayout.this.reboundAnimator.start();
            }
        };
        if (i > 0) {
            this.reboundAnimator = new ValueAnimator();
            postDelayed(r0, (long) i);
        } else {
            r0.run();
        }
        this.isAutoRefresh = true;
        return true;
    }

    public boolean autoLoadMore(int i, final int i2, final float f) {
        if (this.mState != RefreshState.None || !isEnableLoadMore() || this.mFooterNoMoreData) {
            return false;
        }
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        AnonymousClass12 r0 = new Runnable() {
            /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass12 */

            public void run() {
                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                yKSmartRefreshLayout.reboundAnimator = ValueAnimator.ofInt(yKSmartRefreshLayout.mSpinner, -((int) (((float) yKSmartRefreshLayout.mFooterHeight) * f)));
                YKSmartRefreshLayout.this.reboundAnimator.setDuration((long) i2);
                YKSmartRefreshLayout.this.reboundAnimator.setInterpolator(new DecelerateInterpolator());
                YKSmartRefreshLayout.this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass12.AnonymousClass1 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        YKSmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                    }
                });
                YKSmartRefreshLayout.this.reboundAnimator.addListener(new AnimatorListenerAdapter() {
                    /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass12.AnonymousClass2 */

                    public void onAnimationEnd(Animator animator) {
                        YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                        yKSmartRefreshLayout.reboundAnimator = null;
                        RefreshState refreshState = yKSmartRefreshLayout.mState;
                        RefreshState refreshState2 = RefreshState.ReleaseToLoad;
                        if (refreshState != refreshState2) {
                            yKSmartRefreshLayout.mKernel.setState(refreshState2);
                        }
                        YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                        if (yKSmartRefreshLayout2.mEnableAutoLoadMore) {
                            yKSmartRefreshLayout2.mEnableAutoLoadMore = false;
                            yKSmartRefreshLayout2.overSpinner();
                            YKSmartRefreshLayout.this.mEnableAutoLoadMore = true;
                            return;
                        }
                        yKSmartRefreshLayout2.overSpinner();
                    }

                    public void onAnimationStart(Animator animator) {
                        YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                        yKSmartRefreshLayout.mLastTouchX = (float) (yKSmartRefreshLayout.getMeasuredWidth() / 2);
                        YKSmartRefreshLayout.this.mKernel.setState(RefreshState.PullUpToLoad);
                    }
                });
                YKSmartRefreshLayout.this.reboundAnimator.start();
            }
        };
        if (i > 0) {
            this.reboundAnimator = new ValueAnimator();
            postDelayed(r0, (long) i);
            return true;
        }
        r0.run();
        return true;
    }

    public boolean autoRefresh(int i, final int i2, final float f) {
        if (this.mState != RefreshState.None || !isEnableRefresh()) {
            return false;
        }
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        AnonymousClass10 r0 = new Runnable() {
            /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass10 */

            public void run() {
                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                RefreshInternal refreshInternal = yKSmartRefreshLayout.mRefreshHeader;
                if (refreshInternal instanceof YKPageRefreshHeader) {
                    yKSmartRefreshLayout.reboundAnimator = ValueAnimator.ofInt(0, Math.min(((YKPageRefreshHeader) refreshInternal).mRefreshingHeight, yKSmartRefreshLayout.mHeaderHeight));
                } else {
                    yKSmartRefreshLayout.reboundAnimator = ValueAnimator.ofInt(yKSmartRefreshLayout.mSpinner, (int) (((float) yKSmartRefreshLayout.mHeaderHeight) * f));
                }
                YKSmartRefreshLayout.this.reboundAnimator.setDuration((long) i2);
                YKSmartRefreshLayout.this.reboundAnimator.setInterpolator(new DecelerateInterpolator());
                YKSmartRefreshLayout.this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass10.AnonymousClass1 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        YKSmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                    }
                });
                YKSmartRefreshLayout.this.reboundAnimator.addListener(new AnimatorListenerAdapter() {
                    /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass10.AnonymousClass2 */

                    public void onAnimationEnd(Animator animator) {
                        YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                        yKSmartRefreshLayout.reboundAnimator = null;
                        RefreshState refreshState = yKSmartRefreshLayout.mState;
                        RefreshState refreshState2 = RefreshState.ReleaseToRefresh;
                        if (refreshState != refreshState2) {
                            yKSmartRefreshLayout.mKernel.setState(refreshState2);
                        }
                        YKSmartRefreshLayout.this.overSpinner();
                    }

                    public void onAnimationStart(Animator animator) {
                        YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                        yKSmartRefreshLayout.mLastTouchX = (float) (yKSmartRefreshLayout.getMeasuredWidth() / 2);
                        YKSmartRefreshLayout.this.mKernel.setState(RefreshState.PullDownToRefresh);
                    }
                });
                YKSmartRefreshLayout.this.reboundAnimator.start();
            }
        };
        this.isAutoRefresh = true;
        if (i > 0) {
            this.reboundAnimator = new ValueAnimator();
            postDelayed(r0, (long) i);
        } else {
            r0.run();
        }
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishLoadMoreWithNoMoreData() {
        return finishLoadMore(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), true, true);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setDisableContentWhenLoading(boolean z) {
        this.mDisableContentWhenLoading = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setDisableContentWhenRefresh(boolean z) {
        this.mDisableContentWhenRefresh = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setDragRate(float f) {
        this.mDragRate = f;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableAutoLoadMore(boolean z) {
        this.mEnableAutoLoadMore = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableClipFooterWhenFixedBehind(boolean z) {
        this.mEnableClipFooterWhenFixedBehind = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableClipHeaderWhenFixedBehind(boolean z) {
        this.mEnableClipHeaderWhenFixedBehind = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableFooterFollowWhenLoadFinished(boolean z) {
        this.mEnableFooterFollowWhenLoadFinished = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableFooterTranslationContent(boolean z) {
        this.mEnableFooterTranslationContent = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableHeaderTranslationContent(boolean z) {
        this.mEnableHeaderTranslationContent = z;
        this.mManualHeaderTranslationContent = true;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableLoadMore(boolean z) {
        this.mManualLoadMore = true;
        this.mEnableLoadMore = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableLoadMoreWhenContentNotFull(boolean z) {
        this.mEnableLoadMoreWhenContentNotFull = z;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            refreshContent.setEnableLoadMoreWhenContentNotFull(z);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableOverScrollBounce(boolean z) {
        this.mEnableOverScrollBounce = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableOverScrollDrag(boolean z) {
        this.mEnableOverScrollDrag = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnablePureScrollMode(boolean z) {
        this.mEnablePureScrollMode = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableRefresh(boolean z) {
        this.mEnableRefresh = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableScrollContentWhenLoaded(boolean z) {
        this.mEnableScrollContentWhenLoaded = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setEnableScrollContentWhenRefreshed(boolean z) {
        this.mEnableScrollContentWhenRefreshed = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setFooterHeight(float f) {
        int dp2px;
        if (this.mFooterHeightStatus.a(n70.CodeExact) && (dp2px = DensityUtil.dp2px(f)) != this.mFooterHeight) {
            this.mFooterHeight = dp2px;
            this.mFooterHeightStatus = n70.CodeExactUnNotify;
            RefreshInternal refreshInternal = this.mRefreshFooter;
            if (refreshInternal != null) {
                refreshInternal.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setFooterInsetStart(float f) {
        this.mFooterInsetStart = DensityUtil.dp2px(f);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setFooterMaxDragRate(float f) {
        this.mFooterMaxDragRate = f;
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal == null || this.mHandler == null) {
            this.mFooterHeightStatus = this.mFooterHeightStatus.c();
        } else {
            RefreshKernel refreshKernel = this.mKernel;
            int i = this.mFooterHeight;
            refreshInternal.onInitialized(refreshKernel, i, (int) (((float) i) * f));
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setFooterTriggerRate(float f) {
        this.mFooterTriggerRate = f;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setHeaderHeight(float f) {
        if (this.mHeaderHeightStatus.a(n70.CodeExact)) {
            this.mHeaderHeight = DensityUtil.dp2px(f);
            this.mHeaderHeightStatus = n70.CodeExactUnNotify;
            RefreshInternal refreshInternal = this.mRefreshHeader;
            if (refreshInternal != null) {
                refreshInternal.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setHeaderInsetStart(float f) {
        this.mHeaderInsetStart = DensityUtil.dp2px(f);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setHeaderMaxDragRate(float f) {
        this.mHeaderMaxDragRate = f;
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal == null || this.mHandler == null) {
            this.mHeaderHeightStatus = this.mHeaderHeightStatus.c();
        } else {
            RefreshKernel refreshKernel = this.mKernel;
            int i = this.mHeaderHeight;
            refreshInternal.onInitialized(refreshKernel, i, (int) (f * ((float) i)));
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setHeaderTriggerRate(float f) {
        this.mHeaderTriggerRate = f;
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal instanceof YKPageRefreshHeader) {
            ((YKPageRefreshHeader) refreshInternal).mHeaderTriggerRate = f;
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setNoMoreData(boolean z) {
        this.mFooterNoMoreData = z;
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if ((refreshInternal instanceof RefreshFooter) && !((RefreshFooter) refreshInternal).setNoMoreData(z)) {
            PrintStream printStream = System.out;
            printStream.println("Footer:" + this.mRefreshFooter + " Prompt completion is not supported.(不支持提示完成)");
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.mLoadMoreListener = onLoadMoreListener;
        this.mEnableLoadMore = this.mEnableLoadMore || (!this.mManualLoadMore && onLoadMoreListener != null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setOnMultiPurposeListener(OnMultiPurposeListener onMultiPurposeListener) {
        this.mOnMultiPurposeListener = onMultiPurposeListener;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setOnRefreshLoadMoreListener(OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
        this.mRefreshListener = onRefreshLoadMoreListener;
        this.mLoadMoreListener = onRefreshLoadMoreListener;
        this.mEnableLoadMore = this.mEnableLoadMore || (!this.mManualLoadMore && onRefreshLoadMoreListener != null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setPrimaryColors(@ColorInt int... iArr) {
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
    public YKSmartRefreshLayout setPrimaryColorsId(@ColorRes int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = cc2.getColor(getContext(), iArr[i]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setReboundDuration(int i) {
        this.mReboundDuration = i;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setReboundInterpolator(@NonNull Interpolator interpolator) {
        this.mReboundInterpolator = interpolator;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshContent(@NonNull View view, int i, int i2) {
        gd2 gd2;
        gd2 gd22;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            super.removeView(refreshContent.getView());
        }
        super.addView(view, 0, new LayoutParams(i, i2));
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal == null || refreshInternal.getSpinnerStyle() != (gd22 = gd2.FixedBehind)) {
            RefreshInternal refreshInternal2 = this.mRefreshFooter;
            if (refreshInternal2 != null && refreshInternal2.getSpinnerStyle() == (gd2 = gd2.FixedBehind)) {
                super.bringChildToFront(view);
                RefreshInternal refreshInternal3 = this.mRefreshHeader;
                if (refreshInternal3 != null && refreshInternal3.getSpinnerStyle() == gd2) {
                    super.bringChildToFront(this.mRefreshHeader.getView());
                }
            }
        } else {
            super.bringChildToFront(view);
            RefreshInternal refreshInternal4 = this.mRefreshFooter;
            if (!(refreshInternal4 == null || refreshInternal4.getSpinnerStyle() == gd22)) {
                super.bringChildToFront(this.mRefreshFooter.getView());
            }
        }
        this.mRefreshContent = new RefreshContentWrapper(view);
        if (this.mHandler != null) {
            int i3 = this.mFixedHeaderViewId;
            View view2 = null;
            View findViewById = i3 > 0 ? findViewById(i3) : null;
            int i4 = this.mFixedFooterViewId;
            if (i4 > 0) {
                view2 = findViewById(i4);
            }
            this.mRefreshContent.setScrollBoundaryDecider(this.mScrollBoundaryDecider);
            this.mRefreshContent.setEnableLoadMoreWhenContentNotFull(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.setUpComponent(this.mKernel, findViewById, view2);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setScrollBoundaryDecider(ScrollBoundaryDecider scrollBoundaryDecider) {
        this.mScrollBoundaryDecider = scrollBoundaryDecider;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            refreshContent.setScrollBoundaryDecider(scrollBoundaryDecider);
        }
        return this;
    }

    public YKSmartRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFloorDuration = 250;
        this.mReboundDuration = 250;
        this.mDragRate = 0.5f;
        this.mDragDirection = 'n';
        this.mEnableRefresh = true;
        this.mEnableLoadMore = false;
        this.mEnableClipHeaderWhenFixedBehind = true;
        this.mEnableClipFooterWhenFixedBehind = true;
        this.mEnableHeaderTranslationContent = true;
        this.mEnableFooterTranslationContent = true;
        this.mEnableFooterFollowWhenLoadFinished = false;
        this.mEnablePreviewInEditMode = true;
        this.mEnableOverScrollBounce = true;
        this.mEnableOverScrollDrag = false;
        this.mEnableAutoLoadMore = true;
        this.mEnablePureScrollMode = false;
        this.mEnableScrollContentWhenLoaded = true;
        this.mEnableScrollContentWhenRefreshed = true;
        this.mEnableLoadMoreWhenContentNotFull = true;
        this.mDisableContentWhenRefresh = false;
        this.mDisableContentWhenLoading = false;
        this.mFooterNoMoreData = false;
        this.mManualLoadMore = false;
        this.mManualNestedScrolling = false;
        this.mManualHeaderTranslationContent = false;
        this.mManualFooterTranslationContent = false;
        this.mScrollBoundaryDecider = new MyScrollBoundaryDecider();
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
        this.mSupportDragHDirection = true;
        this.mInterceptEventWhenStatueChanged = true;
        this.mSupportNestedHScroll = true;
        this.mKernel = new RefreshKernelImpl();
        RefreshState refreshState = RefreshState.None;
        this.mState = refreshState;
        this.mViceState = refreshState;
        this.mLastOpenTime = 0;
        this.mHeaderBackgroundColor = 0;
        this.mFooterBackgroundColor = 0;
        this.mFooterLocked = false;
        this.mAblePullingDownWhenRefreshing = true;
        this.isAutoRefresh = false;
        this.mVerticalPermit = false;
        this.mFalsifyEvent = null;
        super.setClipToPadding(false);
        DensityUtil densityUtil = new DensityUtil();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mScroller = new Scroller(context);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mScreenHeightPixels = DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics());
        this.mReboundInterpolator = new ViscousFluidInterpolator();
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        NestedScrollingChildHelper nestedScrollingChildHelper = this.mNestedChild;
        int i2 = R.styleable.SmartRefreshLayout_srlEnableNestedScrolling;
        nestedScrollingChildHelper.setNestedScrollingEnabled(obtainStyledAttributes.getBoolean(i2, nestedScrollingChildHelper.isNestedScrollingEnabled()));
        this.mDragRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.mDragRate);
        this.mHeaderMaxDragRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.mHeaderMaxDragRate);
        this.mFooterMaxDragRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.mFooterMaxDragRate);
        this.mHeaderTriggerRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.mHeaderTriggerRate);
        this.mFooterTriggerRate = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.mFooterTriggerRate);
        this.mEnableRefresh = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.mEnableRefresh);
        this.mReboundDuration = obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.mReboundDuration);
        int i3 = R.styleable.SmartRefreshLayout_srlEnableLoadMore;
        this.mEnableLoadMore = obtainStyledAttributes.getBoolean(i3, this.mEnableLoadMore);
        int i4 = R.styleable.SmartRefreshLayout_srlHeaderHeight;
        this.mHeaderHeight = obtainStyledAttributes.getDimensionPixelOffset(i4, densityUtil.dip2px(100.0f));
        int i5 = R.styleable.SmartRefreshLayout_srlFooterHeight;
        this.mFooterHeight = obtainStyledAttributes.getDimensionPixelOffset(i5, densityUtil.dip2px(60.0f));
        this.mHeaderInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, 0);
        this.mFooterInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, 0);
        this.mDisableContentWhenRefresh = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.mDisableContentWhenRefresh);
        this.mDisableContentWhenLoading = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.mDisableContentWhenLoading);
        int i6 = R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.mEnableHeaderTranslationContent = obtainStyledAttributes.getBoolean(i6, this.mEnableHeaderTranslationContent);
        this.mEnableFooterTranslationContent = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.mEnableFooterTranslationContent);
        this.mEnablePreviewInEditMode = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.mEnablePreviewInEditMode);
        this.mEnableAutoLoadMore = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.mEnableAutoLoadMore);
        this.mEnableOverScrollBounce = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.mEnableOverScrollBounce);
        this.mEnablePureScrollMode = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.mEnablePureScrollMode);
        this.mEnableScrollContentWhenLoaded = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.mEnableScrollContentWhenLoaded);
        this.mEnableScrollContentWhenRefreshed = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.mEnableScrollContentWhenRefreshed);
        this.mEnableLoadMoreWhenContentNotFull = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.mEnableLoadMoreWhenContentNotFull);
        this.mEnableFooterFollowWhenLoadFinished = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.mEnableFooterFollowWhenLoadFinished);
        this.mEnableClipHeaderWhenFixedBehind = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.mEnableClipHeaderWhenFixedBehind);
        this.mEnableClipFooterWhenFixedBehind = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.mEnableClipFooterWhenFixedBehind);
        int i7 = R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag;
        this.mEnableOverScrollDrag = obtainStyledAttributes.getBoolean(i7, this.mEnableOverScrollDrag);
        this.mFixedHeaderViewId = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, -1);
        this.mFixedFooterViewId = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, -1);
        if (this.mEnablePureScrollMode && !obtainStyledAttributes.hasValue(i7)) {
            this.mEnableOverScrollDrag = true;
        }
        this.mManualLoadMore = obtainStyledAttributes.hasValue(i3);
        this.mManualNestedScrolling = this.mManualNestedScrolling || obtainStyledAttributes.hasValue(i2);
        this.mManualHeaderTranslationContent = obtainStyledAttributes.hasValue(i6);
        this.mHeaderHeightStatus = obtainStyledAttributes.hasValue(i4) ? n70.XmlLayoutUnNotify : this.mHeaderHeightStatus;
        this.mFooterHeightStatus = obtainStyledAttributes.hasValue(i5) ? n70.XmlLayoutUnNotify : this.mFooterHeightStatus;
        int color = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.mPrimaryColors = new int[]{color2, color};
            } else {
                this.mPrimaryColors = new int[]{color2};
            }
        } else if (color != 0) {
            this.mPrimaryColors = new int[]{0, color};
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setRefreshFooter(@NonNull RefreshFooter refreshFooter) {
        return setRefreshFooter(refreshFooter, -1, -2);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setRefreshHeader(@NonNull RefreshHeader refreshHeader) {
        return setRefreshHeader(refreshHeader, -1, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setRefreshFooter(@NonNull RefreshFooter refreshFooter, int i, int i2) {
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal != null) {
            super.removeView(refreshInternal.getView());
        }
        this.mRefreshFooter = refreshFooter;
        this.mFooterBackgroundColor = 0;
        this.mFooterNeedTouchEventWhenLoading = false;
        this.mFooterHeightStatus = this.mFooterHeightStatus.c();
        this.mEnableLoadMore = !this.mManualLoadMore || this.mEnableLoadMore;
        if (this.mRefreshFooter.getSpinnerStyle() == gd2.FixedBehind) {
            super.addView(this.mRefreshFooter.getView(), 0, new LayoutParams(i, i2));
        } else {
            super.addView(this.mRefreshFooter.getView(), i, i2);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout setRefreshHeader(@NonNull RefreshHeader refreshHeader, int i, int i2) {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null) {
            super.removeView(refreshInternal.getView());
        }
        this.mRefreshHeader = refreshHeader;
        this.mHeaderBackgroundColor = 0;
        this.mHeaderNeedTouchEventWhenRefreshing = false;
        this.mHeaderHeightStatus = this.mHeaderHeightStatus.c();
        if (refreshHeader.getSpinnerStyle() == gd2.FixedBehind) {
            super.addView(this.mRefreshHeader.getView(), 0, new LayoutParams(i, i2));
        } else {
            super.addView(this.mRefreshHeader.getView(), i, i2);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishLoadMore() {
        return finishLoadMore(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))));
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishRefresh() {
        return finishRefresh(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))));
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishLoadMore(int i) {
        return finishLoadMore(i, true, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishRefresh(int i) {
        return finishRefresh(i, true);
    }

    /* compiled from: Taobao */
    public static class LayoutParams extends SmartRefreshLayout.LayoutParams {
        public int backgroundColor = 0;
        public gd2 spinnerStyle = null;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.backgroundColor = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.backgroundColor);
            int i = R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (obtainStyledAttributes.hasValue(i)) {
                this.spinnerStyle = gd2.values()[obtainStyledAttributes.getInt(i, gd2.Translate.ordinal())];
            }
            obtainStyledAttributes.recycle();
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

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishLoadMore(boolean z) {
        return finishLoadMore(z ? Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))) : 0, z, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishRefresh(boolean z) {
        long currentTimeMillis = System.currentTimeMillis() - this.mLastOpenTime;
        int i = 0;
        if (z) {
            i = Math.max(0, 300 - ((int) currentTimeMillis));
        }
        return finishRefresh(i, z);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public YKSmartRefreshLayout finishLoadMore(int i, final boolean z, final boolean z2) {
        postDelayed(new Runnable() {
            /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass9 */

            /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
                if (r1.mRefreshContent.canLoadMore() != false) goto L_0x0051;
             */
            public void run() {
                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                boolean z = true;
                if (yKSmartRefreshLayout.mState == RefreshState.Loading && yKSmartRefreshLayout.mRefreshFooter != null && yKSmartRefreshLayout.mRefreshContent != null) {
                    yKSmartRefreshLayout.notifyStateChanged(RefreshState.LoadFinish);
                    YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                    int onFinish = yKSmartRefreshLayout2.mRefreshFooter.onFinish(yKSmartRefreshLayout2, z);
                    YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                    OnMultiPurposeListener onMultiPurposeListener = yKSmartRefreshLayout3.mOnMultiPurposeListener;
                    if (onMultiPurposeListener != null) {
                        RefreshInternal refreshInternal = yKSmartRefreshLayout3.mRefreshFooter;
                        if (refreshInternal instanceof RefreshFooter) {
                            onMultiPurposeListener.onFooterFinish((RefreshFooter) refreshInternal, z);
                        }
                    }
                    if (onFinish < Integer.MAX_VALUE) {
                        if (z2) {
                            YKSmartRefreshLayout yKSmartRefreshLayout4 = YKSmartRefreshLayout.this;
                            if (yKSmartRefreshLayout4.mEnableFooterFollowWhenLoadFinished) {
                                if (yKSmartRefreshLayout4.mSpinner < 0) {
                                }
                            }
                        }
                        z = false;
                        YKSmartRefreshLayout yKSmartRefreshLayout5 = YKSmartRefreshLayout.this;
                        int i = yKSmartRefreshLayout5.mSpinner;
                        final int max = i - (z ? Math.max(i, -yKSmartRefreshLayout5.mFooterHeight) : 0);
                        YKSmartRefreshLayout yKSmartRefreshLayout6 = YKSmartRefreshLayout.this;
                        if (yKSmartRefreshLayout6.mIsBeingDragged) {
                            yKSmartRefreshLayout6.mTouchSpinner = yKSmartRefreshLayout6.mSpinner - max;
                            yKSmartRefreshLayout6.mTouchY = yKSmartRefreshLayout6.mLastTouchY;
                            yKSmartRefreshLayout6.mIsBeingDragged = false;
                            long currentTimeMillis = System.currentTimeMillis();
                            YKSmartRefreshLayout yKSmartRefreshLayout7 = YKSmartRefreshLayout.this;
                            float f = (float) max;
                            YKSmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, yKSmartRefreshLayout7.mLastTouchX, yKSmartRefreshLayout7.mTouchY + f + ((float) (yKSmartRefreshLayout7.mTouchSlop * 2)), 0));
                            YKSmartRefreshLayout yKSmartRefreshLayout8 = YKSmartRefreshLayout.this;
                            YKSmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, yKSmartRefreshLayout8.mLastTouchX, yKSmartRefreshLayout8.mTouchY + f, 0));
                        } else if (yKSmartRefreshLayout6.mTotalUnconsumed != 0) {
                            yKSmartRefreshLayout6.mDragDirection = yKSmartRefreshLayout6.tryDragDirectionToH();
                            YKSmartRefreshLayout.this.mTotalUnconsumed = 0;
                            long currentTimeMillis2 = System.currentTimeMillis();
                            YKSmartRefreshLayout yKSmartRefreshLayout9 = YKSmartRefreshLayout.this;
                            YKSmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis2, currentTimeMillis2, 3, yKSmartRefreshLayout9.mLastTouchX, yKSmartRefreshLayout9.mTouchY + ((float) max), 0));
                        }
                        YKSmartRefreshLayout.this.postDelayed(new Runnable() {
                            /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass9.AnonymousClass1 */

                            public void run() {
                                ValueAnimator valueAnimator;
                                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                                ValueAnimator.AnimatorUpdateListener scrollContentWhenFinished = (!yKSmartRefreshLayout.mEnableScrollContentWhenLoaded || max >= 0) ? null : yKSmartRefreshLayout.mRefreshContent.scrollContentWhenFinished(yKSmartRefreshLayout.mSpinner);
                                if (scrollContentWhenFinished != null) {
                                    scrollContentWhenFinished.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                                }
                                AnonymousClass1 r1 = new AnimatorListenerAdapter() {
                                    /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass9.AnonymousClass1.AnonymousClass1 */

                                    public void onAnimationCancel(Animator animator) {
                                        super.onAnimationEnd(animator);
                                    }

                                    public void onAnimationEnd(Animator animator) {
                                        AnonymousClass9 r3 = AnonymousClass9.this;
                                        YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                                        yKSmartRefreshLayout.mFooterLocked = false;
                                        if (z2) {
                                            yKSmartRefreshLayout.setNoMoreData(true);
                                        }
                                        YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                                        if (yKSmartRefreshLayout2.mState == RefreshState.LoadFinish) {
                                            yKSmartRefreshLayout2.notifyStateChanged(RefreshState.None);
                                        }
                                    }
                                };
                                AnonymousClass9 r3 = AnonymousClass9.this;
                                YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                                int i = yKSmartRefreshLayout2.mSpinner;
                                if (i > 0) {
                                    valueAnimator = yKSmartRefreshLayout2.mKernel.animSpinner(0);
                                } else {
                                    if (scrollContentWhenFinished != null || i == 0) {
                                        ValueAnimator valueAnimator2 = yKSmartRefreshLayout2.reboundAnimator;
                                        if (valueAnimator2 != null) {
                                            valueAnimator2.cancel();
                                            YKSmartRefreshLayout.this.reboundAnimator = null;
                                        }
                                        YKSmartRefreshLayout.this.mKernel.moveSpinner(0, false);
                                        YKSmartRefreshLayout.this.resetStatus();
                                    } else if (!z2 || !yKSmartRefreshLayout2.mEnableFooterFollowWhenLoadFinished) {
                                        valueAnimator = yKSmartRefreshLayout2.mKernel.animSpinner(0);
                                    } else {
                                        int i2 = yKSmartRefreshLayout2.mFooterHeight;
                                        if (i >= (-i2)) {
                                            yKSmartRefreshLayout2.notifyStateChanged(RefreshState.None);
                                        } else {
                                            valueAnimator = yKSmartRefreshLayout2.mKernel.animSpinner(-i2);
                                        }
                                    }
                                    valueAnimator = null;
                                }
                                if (valueAnimator != null) {
                                    valueAnimator.addListener(r1);
                                } else {
                                    r1.onAnimationEnd(null);
                                }
                            }
                        }, YKSmartRefreshLayout.this.mSpinner < 0 ? (long) onFinish : 0);
                    }
                } else if (z2) {
                    yKSmartRefreshLayout.setNoMoreData(true);
                }
            }
        }, i <= 0 ? 1 : (long) i);
        return this;
    }

    public YKSmartRefreshLayout finishRefresh(int i, final boolean z) {
        postDelayed(new Runnable() {
            /* class com.youku.cmsui.YKSmartRefreshLayout.AnonymousClass8 */

            public void run() {
                YKSmartRefreshLayout yKSmartRefreshLayout = YKSmartRefreshLayout.this;
                if (yKSmartRefreshLayout.mState == RefreshState.Refreshing && yKSmartRefreshLayout.mRefreshHeader != null && yKSmartRefreshLayout.mRefreshContent != null) {
                    yKSmartRefreshLayout.notifyStateChanged(RefreshState.RefreshFinish);
                    YKSmartRefreshLayout yKSmartRefreshLayout2 = YKSmartRefreshLayout.this;
                    int onFinish = yKSmartRefreshLayout2.mRefreshHeader.onFinish(yKSmartRefreshLayout2, z);
                    YKSmartRefreshLayout yKSmartRefreshLayout3 = YKSmartRefreshLayout.this;
                    OnMultiPurposeListener onMultiPurposeListener = yKSmartRefreshLayout3.mOnMultiPurposeListener;
                    if (onMultiPurposeListener != null) {
                        RefreshInternal refreshInternal = yKSmartRefreshLayout3.mRefreshHeader;
                        if (refreshInternal instanceof RefreshHeader) {
                            onMultiPurposeListener.onHeaderFinish((RefreshHeader) refreshInternal, z);
                        }
                    }
                    if (onFinish < Integer.MAX_VALUE) {
                        YKSmartRefreshLayout yKSmartRefreshLayout4 = YKSmartRefreshLayout.this;
                        if (yKSmartRefreshLayout4.mIsBeingDragged) {
                            yKSmartRefreshLayout4.mTouchSpinner = 0;
                            yKSmartRefreshLayout4.mTouchY = yKSmartRefreshLayout4.mLastTouchY;
                            yKSmartRefreshLayout4.mIsBeingDragged = false;
                            long currentTimeMillis = System.currentTimeMillis();
                            YKSmartRefreshLayout yKSmartRefreshLayout5 = YKSmartRefreshLayout.this;
                            YKSmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, yKSmartRefreshLayout5.mLastTouchX, (yKSmartRefreshLayout5.mTouchY + ((float) yKSmartRefreshLayout5.mSpinner)) - ((float) (yKSmartRefreshLayout5.mTouchSlop * 2)), 0));
                            YKSmartRefreshLayout yKSmartRefreshLayout6 = YKSmartRefreshLayout.this;
                            YKSmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, yKSmartRefreshLayout6.mLastTouchX, yKSmartRefreshLayout6.mTouchY + ((float) yKSmartRefreshLayout6.mSpinner), 0));
                        }
                        YKSmartRefreshLayout yKSmartRefreshLayout7 = YKSmartRefreshLayout.this;
                        int i = yKSmartRefreshLayout7.mSpinner;
                        if (i > 0) {
                            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
                            ValueAnimator animSpinner = yKSmartRefreshLayout7.animSpinner(0, onFinish, yKSmartRefreshLayout7.mReboundInterpolator, yKSmartRefreshLayout7.mReboundDuration);
                            YKSmartRefreshLayout yKSmartRefreshLayout8 = YKSmartRefreshLayout.this;
                            if (yKSmartRefreshLayout8.mEnableScrollContentWhenRefreshed) {
                                animatorUpdateListener = yKSmartRefreshLayout8.mRefreshContent.scrollContentWhenFinished(yKSmartRefreshLayout8.mSpinner);
                            }
                            if (animSpinner != null && animatorUpdateListener != null) {
                                animSpinner.addUpdateListener(animatorUpdateListener);
                            }
                        } else if (i < 0) {
                            yKSmartRefreshLayout7.animSpinner(0, onFinish, yKSmartRefreshLayout7.mReboundInterpolator, yKSmartRefreshLayout7.mReboundDuration);
                        } else {
                            yKSmartRefreshLayout7.mKernel.moveSpinner(0, false);
                            YKSmartRefreshLayout.this.resetStatus();
                        }
                    }
                }
            }
        }, i <= 0 ? 1 : (long) i);
        return this;
    }
}
