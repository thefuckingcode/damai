package cn.damai.uikit.irecycler;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$styleable;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.nu2;
import tb.ya2;

/* compiled from: Taobao */
public class IRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final boolean DEBUG = false;
    private static final int STATUS_DEFAULT = 0;
    private static final int STATUS_REFRESHING = 3;
    private static final int STATUS_RELEASE_TO_REFRESH = 2;
    private static final int STATUS_SWIPING_TO_REFRESH = 1;
    private static final String TAG = IRecyclerView.class.getSimpleName();
    private boolean intercept;
    @LayoutRes
    int loadMoreFooterLayoutRes;
    private int mActivePointerId;
    Animator.AnimatorListener mAnimationListener;
    ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    private LinearLayout mFooterViewContainer;
    private LinearLayout mHeaderViewContainer;
    private boolean mIsAutoRefreshing;
    private boolean mIsAutoToDefault;
    private int mLastTouchX;
    private int mLastTouchY;
    private boolean mLoadMoreEnabled;
    private FrameLayout mLoadMoreFooterContainer;
    private View mLoadMoreFooterView;
    private int mMaxDownHeight;
    private OnLoadMoreListener mOnLoadMoreListener;
    private OnLoadMoreScrollListener mOnLoadMoreScrollListener;
    private OnRefreshListener mOnRefreshListener;
    private boolean mRefreshEnabled;
    private int mRefreshFinalMoveOffset;
    private RefreshHeaderLayout mRefreshHeaderContainer;
    private View mRefreshHeaderView;
    RefreshTrigger mRefreshTrigger;
    ValueAnimator mScrollAnimator;
    private int mStatus;
    @LayoutRes
    int refreshHeaderLayoutRes;

    /* compiled from: Taobao */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1458772185")) {
                ipChange.ipc$dispatch("1458772185", new Object[]{this, valueAnimator});
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            IRecyclerView.this.setRefreshHeaderContainerHeight(intValue);
            int i = IRecyclerView.this.mStatus;
            if (i == 1) {
                IRecyclerView.this.mRefreshTrigger.onMove(false, true, intValue);
            } else if (i == 2) {
                IRecyclerView.this.mRefreshTrigger.onMove(false, true, intValue);
            } else if (i == 3) {
                IRecyclerView.this.mRefreshTrigger.onMove(true, true, intValue);
            }
        }
    }

    /* compiled from: Taobao */
    public class b extends ya2 {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "581731849")) {
                ipChange.ipc$dispatch("581731849", new Object[]{this, animator});
                return;
            }
            int unused = IRecyclerView.this.mStatus;
            int i = IRecyclerView.this.mStatus;
            if (i != 1) {
                if (i == 2) {
                    if (!IRecyclerView.this.mIsAutoToDefault) {
                        IRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = IRecyclerView.this.mRefreshHeaderView.getMeasuredHeight();
                        IRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                        IRecyclerView.this.setStatus(3);
                    } else {
                        IRecyclerView.this.setStatus(0);
                    }
                    if (IRecyclerView.this.mOnRefreshListener != null) {
                        IRecyclerView.this.mOnRefreshListener.onRefresh();
                        IRecyclerView.this.mRefreshTrigger.onRefresh();
                    }
                } else if (i == 3) {
                    IRecyclerView.this.mIsAutoRefreshing = false;
                    IRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = 0;
                    IRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                    IRecyclerView.this.setStatus(0);
                    IRecyclerView.this.mRefreshTrigger.onReset();
                }
            } else if (IRecyclerView.this.mIsAutoRefreshing) {
                IRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = IRecyclerView.this.mRefreshHeaderView.getMeasuredHeight();
                IRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                IRecyclerView.this.setStatus(3);
                if (IRecyclerView.this.mOnRefreshListener != null) {
                    IRecyclerView.this.mOnRefreshListener.onRefresh();
                    IRecyclerView.this.mRefreshTrigger.onRefresh();
                }
            } else {
                IRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = 0;
                IRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                IRecyclerView.this.setStatus(0);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements RefreshTrigger {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onComplete() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-212607189")) {
                ipChange.ipc$dispatch("-212607189", new Object[]{this});
            } else if (IRecyclerView.this.mRefreshHeaderView != null && (IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onComplete();
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onMove(boolean z, boolean z2, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "53354128")) {
                ipChange.ipc$dispatch("53354128", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)});
            } else if (IRecyclerView.this.mRefreshHeaderView != null && (IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onMove(z, z2, i);
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1727201973")) {
                ipChange.ipc$dispatch("-1727201973", new Object[]{this});
            } else if (IRecyclerView.this.mRefreshHeaderView != null && (IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onRefresh();
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onRelease() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1372473503")) {
                ipChange.ipc$dispatch("1372473503", new Object[]{this});
            } else if (IRecyclerView.this.mRefreshHeaderView != null && (IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onRelease();
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onReset() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1690590871")) {
                ipChange.ipc$dispatch("1690590871", new Object[]{this});
            } else if (IRecyclerView.this.mRefreshHeaderView != null && (IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onReset();
            }
        }

        @Override // cn.damai.uikit.irecycler.RefreshTrigger
        public void onStart(boolean z, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "557515024")) {
                ipChange.ipc$dispatch("557515024", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
            } else if (IRecyclerView.this.mRefreshHeaderView != null && (IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onStart(z, i, i2);
            }
        }
    }

    public IRecyclerView(Context context) {
        this(context, null);
    }

    private void ensureFooterViewContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1493980268")) {
            ipChange.ipc$dispatch("-1493980268", new Object[]{this});
        } else if (this.mFooterViewContainer == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mFooterViewContainer = linearLayout;
            linearLayout.setOrientation(1);
            this.mFooterViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureHeaderViewContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1333414778")) {
            ipChange.ipc$dispatch("-1333414778", new Object[]{this});
        } else if (this.mHeaderViewContainer == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mHeaderViewContainer = linearLayout;
            linearLayout.setOrientation(1);
            this.mHeaderViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureLoadMoreFooterContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "256781962")) {
            ipChange.ipc$dispatch("256781962", new Object[]{this});
        } else if (this.mLoadMoreFooterContainer == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.mLoadMoreFooterContainer = frameLayout;
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureRefreshHeaderContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440569724")) {
            ipChange.ipc$dispatch("440569724", new Object[]{this});
        } else if (this.mRefreshHeaderContainer == null) {
            RefreshHeaderLayout refreshHeaderLayout = new RefreshHeaderLayout(getContext());
            this.mRefreshHeaderContainer = refreshHeaderLayout;
            refreshHeaderLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        }
    }

    private void fingerMove(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-55311638")) {
            ipChange.ipc$dispatch("-55311638", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = (int) (((double) (((float) i) * 0.5f)) + 0.5d);
        int measuredHeight = this.mRefreshHeaderContainer.getMeasuredHeight();
        int i3 = this.mRefreshFinalMoveOffset;
        int i4 = measuredHeight + i2;
        if (i3 > 0 && i4 > i3) {
            i2 = i3 - measuredHeight;
        }
        if (i4 < 0) {
            i2 = -measuredHeight;
        }
        move(i2);
    }

    private int getMotionEventX(MotionEvent motionEvent, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1123917548")) {
            return (int) (MotionEventCompat.getX(motionEvent, i) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("-1123917548", new Object[]{this, motionEvent, Integer.valueOf(i)})).intValue();
    }

    private int getMotionEventY(MotionEvent motionEvent, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-773117611")) {
            return (int) (MotionEventCompat.getY(motionEvent, i) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("-773117611", new Object[]{this, motionEvent, Integer.valueOf(i)})).intValue();
    }

    private String getStatusLog(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-551723948")) {
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "status_illegal!" : "status_refreshing" : "status_release_to_refresh" : "status_swiping_to_refresh" : "status_default";
        }
        return (String) ipChange.ipc$dispatch("-551723948", new Object[]{this, Integer.valueOf(i)});
    }

    private boolean isFingerDragging() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1824433909")) {
            return getScrollState() == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("1824433909", new Object[]{this})).booleanValue();
    }

    private boolean isRefreshTrigger(View view) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2122157302")) {
            return view instanceof RefreshTrigger;
        }
        return ((Boolean) ipChange.ipc$dispatch("-2122157302", new Object[]{this, view})).booleanValue();
    }

    private void move(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "962979297")) {
            ipChange.ipc$dispatch("962979297", new Object[]{this, Integer.valueOf(i)});
        } else if (i != 0) {
            int measuredHeight = this.mRefreshHeaderContainer.getMeasuredHeight() + i;
            int i2 = this.mMaxDownHeight;
            if (i2 > 0 && measuredHeight > i2) {
                measuredHeight = i2;
            }
            setRefreshHeaderContainerHeight(measuredHeight);
            this.mRefreshTrigger.onMove(false, false, measuredHeight);
        }
    }

    private void onFingerUpStartAnimating() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1383246700")) {
            ipChange.ipc$dispatch("-1383246700", new Object[]{this});
            return;
        }
        int i = this.mStatus;
        if (i == 2 && !this.mIsAutoToDefault) {
            startScrollReleaseStatusToRefreshingStatus();
        } else if (i == 1 || this.mIsAutoToDefault) {
            startScrollSwipingToRefreshStatusToDefaultStatus();
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "307663283")) {
            ipChange.ipc$dispatch("307663283", new Object[]{this, motionEvent});
            return;
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            if (actionIndex != 0) {
                i = 0;
            }
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
            this.mLastTouchX = getMotionEventX(motionEvent, i);
            this.mLastTouchY = getMotionEventY(motionEvent, i);
        }
    }

    private void printStatusLog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "346424686")) {
            ipChange.ipc$dispatch("346424686", new Object[]{this});
            return;
        }
        nu2.d(TAG, getStatusLog(this.mStatus));
    }

    private void removeLoadMoreFooterView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-229054156")) {
            ipChange.ipc$dispatch("-229054156", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mLoadMoreFooterContainer;
        if (frameLayout != null) {
            frameLayout.removeView(this.mLoadMoreFooterView);
        }
    }

    private void removeRefreshHeaderView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1278637362")) {
            ipChange.ipc$dispatch("-1278637362", new Object[]{this});
            return;
        }
        RefreshHeaderLayout refreshHeaderLayout = this.mRefreshHeaderContainer;
        if (refreshHeaderLayout != null) {
            refreshHeaderLayout.removeView(this.mRefreshHeaderView);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRefreshHeaderContainerHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1231265874")) {
            ipChange.ipc$dispatch("-1231265874", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRefreshHeaderContainer.getLayoutParams().height = i;
        this.mRefreshHeaderContainer.requestLayout();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831826432")) {
            ipChange.ipc$dispatch("-1831826432", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mStatus = i;
    }

    private void startScrollAnimation(int i, Interpolator interpolator, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1424776736")) {
            ipChange.ipc$dispatch("1424776736", new Object[]{this, Integer.valueOf(i), interpolator, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        if (this.mScrollAnimator == null) {
            this.mScrollAnimator = new ValueAnimator();
        }
        this.mScrollAnimator.removeAllUpdateListeners();
        this.mScrollAnimator.removeAllListeners();
        this.mScrollAnimator.cancel();
        this.mScrollAnimator.setIntValues(i2, i3);
        this.mScrollAnimator.setDuration((long) i);
        this.mScrollAnimator.setInterpolator(interpolator);
        this.mScrollAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mScrollAnimator.addListener(this.mAnimationListener);
        this.mScrollAnimator.start();
    }

    private void startScrollDefaultStatusToRefreshingStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1349543013")) {
            ipChange.ipc$dispatch("-1349543013", new Object[]{this});
            return;
        }
        this.mRefreshTrigger.onStart(true, this.mRefreshHeaderView.getMeasuredHeight(), this.mRefreshFinalMoveOffset);
        int measuredHeight = this.mRefreshHeaderView.getMeasuredHeight();
        startScrollAnimation(400, new AccelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), measuredHeight);
    }

    private void startScrollRefreshingStatusToDefaultStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1458496131")) {
            ipChange.ipc$dispatch("1458496131", new Object[]{this});
            return;
        }
        this.mRefreshTrigger.onComplete();
        startScrollAnimation(400, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), 0);
    }

    private void startScrollReleaseStatusToRefreshingStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088542699")) {
            ipChange.ipc$dispatch("-2088542699", new Object[]{this});
            return;
        }
        this.mRefreshTrigger.onRelease();
        int measuredHeight = this.mRefreshHeaderView.getMeasuredHeight();
        startScrollAnimation(300, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), measuredHeight);
    }

    private void startScrollSwipingToRefreshStatusToDefaultStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1746712517")) {
            ipChange.ipc$dispatch("1746712517", new Object[]{this});
            return;
        }
        startScrollAnimation(300, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), 0);
    }

    public void addFooterView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "271664444")) {
            ipChange.ipc$dispatch("271664444", new Object[]{this, view});
            return;
        }
        ensureFooterViewContainer();
        this.mFooterViewContainer.addView(view);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(adapter.getItemCount() - 2);
        }
    }

    public void addHeaderView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1324726354")) {
            ipChange.ipc$dispatch("-1324726354", new Object[]{this, view});
            return;
        }
        ensureHeaderViewContainer();
        this.mHeaderViewContainer.addView(view);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(1);
        }
    }

    public boolean canLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "616452400")) {
            return ((Boolean) ipChange.ipc$dispatch("616452400", new Object[]{this})).booleanValue();
        }
        View view = this.mLoadMoreFooterView;
        if (view == null || !(view instanceof LoadMoreFooterView)) {
            return false;
        }
        return ((LoadMoreFooterView) view).canLoadMore();
    }

    public boolean canTriggerRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "150359560")) {
            return ((Boolean) ipChange.ipc$dispatch("150359560", new Object[]{this})).booleanValue();
        }
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null || adapter.getItemCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return getChildLayoutPosition(childAt) == 0 && childAt.getTop() == this.mRefreshHeaderContainer.getTop();
    }

    public LinearLayout getFooterContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "96213050")) {
            return (LinearLayout) ipChange.ipc$dispatch("96213050", new Object[]{this});
        }
        ensureFooterViewContainer();
        return this.mFooterViewContainer;
    }

    public LinearLayout getHeaderContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1902045996")) {
            return (LinearLayout) ipChange.ipc$dispatch("1902045996", new Object[]{this});
        }
        ensureHeaderViewContainer();
        return this.mHeaderViewContainer;
    }

    public RecyclerView.Adapter getIAdapter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-592408329")) {
            return ((WrapperAdapter) getAdapter()).a();
        }
        return (RecyclerView.Adapter) ipChange.ipc$dispatch("-592408329", new Object[]{this});
    }

    public View getLoadMoreFooterView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "343586920")) {
            return this.mLoadMoreFooterView;
        }
        return (View) ipChange.ipc$dispatch("343586920", new Object[]{this});
    }

    public View getRefreshHeaderView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1011378526")) {
            return this.mRefreshHeaderView;
        }
        return (View) ipChange.ipc$dispatch("1011378526", new Object[]{this});
    }

    public WrapperAdapter getWrapAdapter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "419425642")) {
            return (WrapperAdapter) getAdapter();
        }
        return (WrapperAdapter) ipChange.ipc$dispatch("419425642", new Object[]{this});
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1597269842")) {
            return ((Boolean) ipChange.ipc$dispatch("1597269842", new Object[]{this, motionEvent})).booleanValue();
        } else if (this.intercept) {
            return true;
        } else {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (actionMasked == 0) {
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                this.mLastTouchX = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                this.mLastTouchY = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
            } else if (actionMasked == 5) {
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastTouchX = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                this.mLastTouchY = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
            } else if (actionMasked == 6) {
                onPointerUp(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-351213992")) {
            ipChange.ipc$dispatch("-351213992", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        View view = this.mRefreshHeaderView;
        if (view != null && view.getMeasuredHeight() > this.mRefreshFinalMoveOffset) {
            this.mRefreshFinalMoveOffset = 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d7, code lost:
        if (r8.mStatus == 0) goto L_0x0107;
     */
    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1699876462")) {
            return ((Boolean) ipChange.ipc$dispatch("-1699876462", new Object[]{this, motionEvent})).booleanValue();
        } else if (this.intercept) {
            return true;
        } else {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 0) {
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                this.mLastTouchX = getMotionEventX(motionEvent, actionIndex);
                this.mLastTouchY = getMotionEventY(motionEvent, actionIndex);
            } else if (actionMasked == 1) {
                onFingerUpStartAnimating();
            } else if (actionMasked == 2) {
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                if (findPointerIndex < 0) {
                    String str = TAG;
                    nu2.b(str, "Error processing scroll; pointer index for id " + findPointerIndex + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int motionEventX = getMotionEventX(motionEvent, findPointerIndex);
                int motionEventY = getMotionEventY(motionEvent, findPointerIndex);
                int i = motionEventY - this.mLastTouchY;
                this.mLastTouchX = motionEventX;
                this.mLastTouchY = motionEventY;
                if (isEnabled() && this.mRefreshEnabled && this.mRefreshHeaderView != null && isFingerDragging() && canTriggerRefresh()) {
                    int measuredHeight = this.mRefreshHeaderContainer.getMeasuredHeight();
                    int measuredHeight2 = this.mRefreshHeaderView.getMeasuredHeight();
                    if (i > 0 && this.mStatus == 0) {
                        setStatus(1);
                        this.mRefreshTrigger.onStart(false, measuredHeight2, this.mRefreshFinalMoveOffset);
                    } else if (i < 0) {
                        if (this.mStatus == 1 && measuredHeight <= 0) {
                            setStatus(0);
                        }
                    }
                    int i2 = this.mStatus;
                    if (i2 == 1 || i2 == 2) {
                        if (measuredHeight >= measuredHeight2) {
                            setStatus(2);
                        } else {
                            setStatus(1);
                        }
                        fingerMove(i);
                        return true;
                    }
                }
            } else if (actionMasked == 3) {
                onFingerUpStartAnimating();
            } else if (actionMasked == 5) {
                int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex2);
                this.mLastTouchX = getMotionEventX(motionEvent, actionIndex2);
                this.mLastTouchY = getMotionEventY(motionEvent, actionIndex2);
            } else if (actionMasked == 6) {
                onPointerUp(motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1021469862")) {
            ipChange.ipc$dispatch("1021469862", new Object[]{this, adapter});
            return;
        }
        ensureRefreshHeaderContainer();
        ensureHeaderViewContainer();
        ensureFooterViewContainer();
        ensureLoadMoreFooterContainer();
        super.setAdapter(new WrapperAdapter(adapter, this.mRefreshHeaderContainer, this.mHeaderViewContainer, this.mFooterViewContainer, this.mLoadMoreFooterContainer));
    }

    public void setInterceptOnTouchEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2068447013")) {
            ipChange.ipc$dispatch("-2068447013", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.intercept = z;
    }

    public void setIsAutoToDefault(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1639436780")) {
            ipChange.ipc$dispatch("1639436780", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIsAutoToDefault = z;
    }

    public void setLoadMoreEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1911437947")) {
            ipChange.ipc$dispatch("-1911437947", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mLoadMoreEnabled = z;
        if (z) {
            OnLoadMoreScrollListener onLoadMoreScrollListener = this.mOnLoadMoreScrollListener;
            if (onLoadMoreScrollListener == null) {
                this.mOnLoadMoreScrollListener = new OnLoadMoreScrollListener() {
                    /* class cn.damai.uikit.irecycler.IRecyclerView.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.uikit.irecycler.OnLoadMoreScrollListener
                    public void b(RecyclerView recyclerView) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "828197617")) {
                            ipChange.ipc$dispatch("828197617", new Object[]{this, recyclerView});
                        } else if (IRecyclerView.this.mOnLoadMoreListener != null && IRecyclerView.this.mStatus == 0) {
                            IRecyclerView.this.mOnLoadMoreListener.onLoadMore(IRecyclerView.this.mLoadMoreFooterView);
                        }
                    }
                };
            } else {
                removeOnScrollListener(onLoadMoreScrollListener);
            }
            addOnScrollListener(this.mOnLoadMoreScrollListener);
            return;
        }
        if (this.mLoadMoreFooterView != null) {
            removeLoadMoreFooterView();
        }
        OnLoadMoreScrollListener onLoadMoreScrollListener2 = this.mOnLoadMoreScrollListener;
        if (onLoadMoreScrollListener2 != null) {
            removeOnScrollListener(onLoadMoreScrollListener2);
        }
    }

    public void setLoadMoreFooterView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1135096200")) {
            ipChange.ipc$dispatch("-1135096200", new Object[]{this, view});
            return;
        }
        if (this.mLoadMoreFooterView != null) {
            removeLoadMoreFooterView();
        }
        if (this.mLoadMoreFooterView != view) {
            this.mLoadMoreFooterView = view;
            ensureLoadMoreFooterContainer();
            this.mLoadMoreFooterContainer.addView(view);
        }
    }

    public void setLoadMoreStatus(LoadMoreFooterView.Status status) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-556751558")) {
            ipChange.ipc$dispatch("-556751558", new Object[]{this, status});
            return;
        }
        View view = this.mLoadMoreFooterView;
        if (view != null && (view instanceof LoadMoreFooterView)) {
            ((LoadMoreFooterView) view).setStatus(status);
        }
    }

    public void setMaxDownHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1622146629")) {
            ipChange.ipc$dispatch("-1622146629", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mMaxDownHeight = i;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1002325693")) {
            ipChange.ipc$dispatch("1002325693", new Object[]{this, onLoadMoreListener});
            return;
        }
        this.mOnLoadMoreListener = onLoadMoreListener;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1868754323")) {
            ipChange.ipc$dispatch("1868754323", new Object[]{this, onRefreshListener});
            return;
        }
        this.mOnRefreshListener = onRefreshListener;
    }

    public void setRefreshEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-568740411")) {
            ipChange.ipc$dispatch("-568740411", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mRefreshEnabled = z;
    }

    public void setRefreshFinalMoveOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1878421747")) {
            ipChange.ipc$dispatch("-1878421747", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRefreshFinalMoveOffset = i;
    }

    public void setRefreshHeaderView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "669878442")) {
            ipChange.ipc$dispatch("669878442", new Object[]{this, view});
        } else if (isRefreshTrigger(view)) {
            if (this.mRefreshHeaderView != null) {
                removeRefreshHeaderView();
            }
            if (this.mRefreshHeaderView != view) {
                this.mRefreshHeaderView = view;
                ensureRefreshHeaderContainer();
                this.mRefreshHeaderContainer.addView(view);
            }
        } else {
            throw new ClassCastException("Refresh header view must be an implement of RefreshTrigger");
        }
    }

    public void setRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1208695942")) {
            ipChange.ipc$dispatch("1208695942", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        int i = this.mStatus;
        if (i == 0 && z) {
            this.mIsAutoRefreshing = true;
            setStatus(1);
            startScrollDefaultStatusToRefreshingStatus();
        } else if (i != 3 || z) {
            this.mIsAutoRefreshing = false;
            String str = TAG;
            nu2.b(str, "isRefresh = " + z + " current status = " + this.mStatus);
        } else {
            this.mIsAutoRefreshing = false;
            startScrollRefreshingStatusToDefaultStatus();
        }
    }

    public IRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public IRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.refreshHeaderLayoutRes = -1;
        this.loadMoreFooterLayoutRes = -1;
        this.mActivePointerId = -1;
        this.mLastTouchX = 0;
        this.mLastTouchY = 0;
        this.mMaxDownHeight = 0;
        this.mAnimatorUpdateListener = new a();
        this.mAnimationListener = new b();
        this.mRefreshTrigger = new c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.IRecyclerView, i, 0);
        try {
            boolean z = obtainStyledAttributes.getBoolean(R$styleable.IRecyclerView_refreshEnabled, false);
            boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.IRecyclerView_loadMoreEnabled, false);
            this.refreshHeaderLayoutRes = obtainStyledAttributes.getResourceId(R$styleable.IRecyclerView_refreshHeaderLayout, -1);
            this.loadMoreFooterLayoutRes = obtainStyledAttributes.getResourceId(R$styleable.IRecyclerView_loadMoreFooterLayout, -1);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.IRecyclerView_refreshFinalMoveOffset, -1);
            obtainStyledAttributes.recycle();
            setRefreshEnabled(z);
            setLoadMoreEnabled(z2);
            int i2 = this.refreshHeaderLayoutRes;
            if (i2 != -1) {
                setRefreshHeaderView(i2);
            } else {
                int i3 = R$layout.layout_irecyclerview_classic_refresh_header;
                this.refreshHeaderLayoutRes = i3;
                setRefreshHeaderView(i3);
            }
            int i4 = this.loadMoreFooterLayoutRes;
            if (i4 != -1) {
                setLoadMoreFooterView(i4);
            } else {
                int i5 = R$layout.layout_irecyclerview_load_more_footer;
                this.loadMoreFooterLayoutRes = i5;
                setLoadMoreFooterView(i5);
            }
            if (dimensionPixelOffset != -1) {
                setRefreshFinalMoveOffset(dimensionPixelOffset);
            }
            setStatus(0);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setLoadMoreFooterView(@LayoutRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "719177257")) {
            ipChange.ipc$dispatch("719177257", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ensureLoadMoreFooterContainer();
        View inflate = LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.mLoadMoreFooterContainer, false);
        if (inflate != null) {
            setLoadMoreFooterView(inflate);
        }
    }

    public void setRefreshHeaderView(@LayoutRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "793250011")) {
            ipChange.ipc$dispatch("793250011", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ensureRefreshHeaderContainer();
        View inflate = LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.mRefreshHeaderContainer, false);
        if (inflate != null) {
            setRefreshHeaderView(inflate);
        }
    }
}
