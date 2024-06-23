package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$styleable;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.handmark.pulltorefresh.library.internal.IndicatorLayout;

/* compiled from: Taobao */
public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T> implements AbsListView.OnScrollListener {
    private View mEmptyView;
    private IndicatorLayout mIndicatorIvBottom;
    private IndicatorLayout mIndicatorIvTop;
    private PullToRefreshBase.OnLastItemVisibleListener mOnLastItemVisibleListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mSavedLastVisibleIndex = -1;
    private boolean mScrollEmptyView = true;
    private boolean mShowIndicator;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            a = iArr;
            iArr[PullToRefreshBase.Mode.PULL_UP_TO_REFRESH.ordinal()] = 1;
            a[PullToRefreshBase.Mode.PULL_DOWN_TO_REFRESH.ordinal()] = 2;
        }
    }

    public PullToRefreshAdapterViewBase(Context context) {
        super(context);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    private void addIndicatorViews() {
        IndicatorLayout indicatorLayout;
        IndicatorLayout indicatorLayout2;
        PullToRefreshBase.Mode mode = getMode();
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (mode.canPullDown() && this.mIndicatorIvTop == null) {
            this.mIndicatorIvTop = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_DOWN_TO_REFRESH);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R$dimen.indicator_right_padding);
            layoutParams.gravity = 53;
            refreshableViewWrapper.addView(this.mIndicatorIvTop, layoutParams);
        } else if (!mode.canPullDown() && (indicatorLayout2 = this.mIndicatorIvTop) != null) {
            refreshableViewWrapper.removeView(indicatorLayout2);
            this.mIndicatorIvTop = null;
        }
        if (mode.canPullUp() && this.mIndicatorIvBottom == null) {
            this.mIndicatorIvBottom = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_UP_TO_REFRESH);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = getResources().getDimensionPixelSize(R$dimen.indicator_right_padding);
            layoutParams2.gravity = 85;
            refreshableViewWrapper.addView(this.mIndicatorIvBottom, layoutParams2);
        } else if (!mode.canPullUp() && (indicatorLayout = this.mIndicatorIvBottom) != null) {
            refreshableViewWrapper.removeView(indicatorLayout);
            this.mIndicatorIvBottom = null;
        }
    }

    private boolean getShowIndicatorInternal() {
        return this.mShowIndicator && isPullToRefreshEnabled();
    }

    private boolean isFirstItemVisible() {
        View childAt;
        Adapter adapter = ((AbsListView) this.mRefreshableView).getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        if (((AbsListView) this.mRefreshableView).getFirstVisiblePosition() != 0 || (childAt = ((AbsListView) this.mRefreshableView).getChildAt(0)) == null || childAt.getTop() < ((AbsListView) this.mRefreshableView).getTop()) {
            return false;
        }
        return true;
    }

    private boolean isLastItemVisible() {
        View childAt;
        Adapter adapter = ((AbsListView) this.mRefreshableView).getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = ((AbsListView) this.mRefreshableView).getLastVisiblePosition();
        if (lastVisiblePosition < (((AbsListView) this.mRefreshableView).getCount() - 1) - 1 || (childAt = ((AbsListView) this.mRefreshableView).getChildAt(lastVisiblePosition - ((AbsListView) this.mRefreshableView).getFirstVisiblePosition())) == null || childAt.getBottom() > ((AbsListView) this.mRefreshableView).getBottom()) {
            return false;
        }
        return true;
    }

    private void removeIndicatorViews() {
        if (this.mIndicatorIvTop != null) {
            getRefreshableViewWrapper().removeView(this.mIndicatorIvTop);
            this.mIndicatorIvTop = null;
        }
        if (this.mIndicatorIvBottom != null) {
            getRefreshableViewWrapper().removeView(this.mIndicatorIvBottom);
            this.mIndicatorIvBottom = null;
        }
    }

    private void updateIndicatorViewsVisibility() {
        if (this.mIndicatorIvTop != null) {
            if (isRefreshing() || !isReadyForPullDown()) {
                if (this.mIndicatorIvTop.isVisible()) {
                    this.mIndicatorIvTop.hide();
                }
            } else if (!this.mIndicatorIvTop.isVisible()) {
                this.mIndicatorIvTop.show();
            }
        }
        if (this.mIndicatorIvBottom == null) {
            return;
        }
        if (isRefreshing() || !isReadyForPullUp()) {
            if (this.mIndicatorIvBottom.isVisible()) {
                this.mIndicatorIvBottom.hide();
            }
        } else if (!this.mIndicatorIvBottom.isVisible()) {
            this.mIndicatorIvBottom.show();
        }
    }

    public abstract ContextMenu.ContextMenuInfo getContextMenuInfo();

    public boolean getShowIndicator() {
        return this.mShowIndicator;
    }

    /* access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void handleStyledAttributes(TypedArray typedArray) {
        this.mShowIndicator = typedArray.getBoolean(R$styleable.PullToRefresh_ptrShowIndicator, !isPullToRefreshOverScrollEnabled());
    }

    /* access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public boolean isReadyForPullDown() {
        return isFirstItemVisible();
    }

    /* access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public boolean isReadyForPullUp() {
        return isLastItemVisible();
    }

    /* access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void onPullToRefresh() {
        super.onPullToRefresh();
        if (getShowIndicatorInternal()) {
            int i = a.a[getCurrentMode().ordinal()];
            if (i == 1) {
                this.mIndicatorIvBottom.pullToRefresh();
            } else if (i == 2) {
                this.mIndicatorIvTop.pullToRefresh();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void onReleaseToRefresh() {
        super.onReleaseToRefresh();
        if (getShowIndicatorInternal()) {
            int i = a.a[getCurrentMode().ordinal()];
            if (i == 1) {
                this.mIndicatorIvBottom.releaseToRefresh();
            } else if (i == 2) {
                this.mIndicatorIvTop.releaseToRefresh();
            }
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener = this.mOnLastItemVisibleListener;
        if (onLastItemVisibleListener != null) {
            int i4 = i + i2;
            if (i2 > 0 && i4 + 1 == i3 && i4 != this.mSavedLastVisibleIndex) {
                this.mSavedLastVisibleIndex = i4;
                onLastItemVisibleListener.onLastItemVisible();
            }
        }
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        View view = this.mEmptyView;
        if (view != null && !this.mScrollEmptyView) {
            view.scrollTo(-i, -i2);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void resetHeader() {
        super.resetHeader();
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        ((AbsListView) this.mRefreshableView).setAdapter(listAdapter);
    }

    public final void setEmptyView(View view) {
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        View view2 = this.mEmptyView;
        if (view2 != null) {
            refreshableViewWrapper.removeView(view2);
        }
        if (view != null) {
            view.setClickable(true);
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            refreshableViewWrapper.addView(view, -1, -1);
            T t = this.mRefreshableView;
            if (t instanceof EmptyViewMethodAccessor) {
                ((EmptyViewMethodAccessor) t).setEmptyViewInternal(view);
            } else {
                ((AbsListView) t).setEmptyView(view);
            }
            this.mEmptyView = view;
        }
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        ((AbsListView) this.mRefreshableView).setOnItemClickListener(onItemClickListener);
    }

    public final void setOnLastItemVisibleListener(PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener) {
        this.mOnLastItemVisibleListener = onLastItemVisibleListener;
    }

    public final void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    /* access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void setRefreshingInternal(boolean z) {
        super.setRefreshingInternal(z);
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
    }

    public final void setScrollEmptyView(boolean z) {
        this.mScrollEmptyView = z;
    }

    public void setShowIndicator(boolean z) {
        this.mShowIndicator = z;
        if (getShowIndicatorInternal()) {
            addIndicatorViews();
        } else {
            removeIndicatorViews();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void updateUIForMode() {
        super.updateUIForMode();
        if (getShowIndicatorInternal()) {
            addIndicatorViews();
        } else {
            removeIndicatorViews();
        }
    }

    public PullToRefreshAdapterViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }
}
