package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baseproject.ui.R$styleable;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;

/* compiled from: Taobao */
public class PullToRefreshListView extends PullToRefreshAdapterViewBase<ListView> {
    public static final String TAG = "PullToRefreshListView";
    private LoadingLayout mFooterLoadingView;
    private LoadingLayout mHeaderLoadingView;
    private FrameLayout mLvFooterLoadingFrame;

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public class InternalListView extends ListView implements EmptyViewMethodAccessor {
        private boolean mAddedLvFooter = false;

        public InternalListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void draw(Canvas canvas) {
            try {
                super.draw(canvas);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public ContextMenu.ContextMenuInfo getContextMenuInfo() {
            return super.getContextMenuInfo();
        }

        /* access modifiers changed from: protected */
        public void layoutChildren() {
            try {
                super.layoutChildren();
            } catch (IllegalStateException unused) {
            } catch (Exception unused2) {
                for (int i = 0; i < getAdapter().getCount(); i++) {
                }
            }
        }

        @Override // com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyView(View view) {
            PullToRefreshListView.this.setEmptyView(view);
        }

        @Override // com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }

        @Override // android.widget.AbsListView, android.widget.ListView
        public void setAdapter(ListAdapter listAdapter) {
            if (!this.mAddedLvFooter) {
                addFooterView(PullToRefreshListView.this.mLvFooterLoadingFrame, null, false);
                this.mAddedLvFooter = true;
            }
            super.setAdapter(listAdapter);
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(9)
    /* compiled from: Taobao */
    public final class InternalListViewSDK9 extends InternalListView {
        public InternalListViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            a.d(PullToRefreshListView.this, i2, i4, z);
            return overScrollBy;
        }
    }

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

    public PullToRefreshListView(Context context) {
        super(context);
        setDisableScrollingWhileRefreshing(false);
    }

    /* access modifiers changed from: protected */
    public ListView createListView(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 9) {
            return new InternalListViewSDK9(context, attributeSet);
        }
        return new InternalListView(context, attributeSet);
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return ((InternalListView) getRefreshableView()).getContextMenuInfo();
    }

    /* access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase, com.handmark.pulltorefresh.library.PullToRefreshBase
    public void resetHeader() {
        int i;
        int i2;
        LoadingLayout loadingLayout;
        LoadingLayout loadingLayout2;
        ListAdapter adapter = ((ListView) this.mRefreshableView).getAdapter();
        if (!getShowViewWhileRefreshing() || adapter == null || adapter.isEmpty()) {
            super.resetHeader();
            return;
        }
        boolean z = true;
        if (a.a[getCurrentMode().ordinal()] != 1) {
            loadingLayout2 = getHeaderLayout();
            loadingLayout = this.mHeaderLoadingView;
            int i3 = -getHeaderHeight();
            if (Math.abs(((ListView) this.mRefreshableView).getFirstVisiblePosition() - 0) > 1) {
                z = false;
            }
            i = i3;
            i2 = 0;
        } else {
            loadingLayout2 = getFooterLayout();
            loadingLayout = this.mFooterLoadingView;
            i2 = ((ListView) this.mRefreshableView).getCount() - 1;
            i = getFooterHeight();
            if (Math.abs(((ListView) this.mRefreshableView).getLastVisiblePosition() - i2) > 1) {
                z = false;
            }
        }
        loadingLayout2.setVisibility(0);
        if (z && getState() != 9 && loadingLayout.getVisibility() == 0) {
            ((ListView) this.mRefreshableView).setSelection(i2);
            setHeaderScroll(i);
        }
        loadingLayout.setVisibility(8);
        super.resetHeader();
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh, com.handmark.pulltorefresh.library.PullToRefreshBase
    public void setLastUpdatedLabel(CharSequence charSequence) {
        super.setLastUpdatedLabel(charSequence);
        LoadingLayout loadingLayout = this.mHeaderLoadingView;
        if (loadingLayout != null) {
            loadingLayout.setSubHeaderText(charSequence);
        }
        LoadingLayout loadingLayout2 = this.mFooterLoadingView;
        if (loadingLayout2 != null) {
            loadingLayout2.setSubHeaderText(charSequence);
        }
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh, com.handmark.pulltorefresh.library.PullToRefreshBase
    public void setLoadingDrawable(Drawable drawable, PullToRefreshBase.Mode mode) {
        super.setLoadingDrawable(drawable, mode);
        if (this.mHeaderLoadingView != null && mode.canPullDown()) {
            this.mHeaderLoadingView.setLoadingDrawable(drawable);
        }
        if (this.mFooterLoadingView != null && mode.canPullUp()) {
            this.mFooterLoadingView.setLoadingDrawable(drawable);
        }
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh, com.handmark.pulltorefresh.library.PullToRefreshBase
    public void setPullLabel(CharSequence charSequence, PullToRefreshBase.Mode mode) {
        super.setPullLabel(charSequence, mode);
        if (this.mHeaderLoadingView != null && mode.canPullDown()) {
            this.mHeaderLoadingView.setPullLabel(charSequence);
        }
        if (this.mFooterLoadingView != null && mode.canPullUp()) {
            this.mFooterLoadingView.setPullLabel(charSequence);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase, com.handmark.pulltorefresh.library.PullToRefreshBase
    public void setRefreshingInternal(boolean z) {
        int i;
        int i2;
        LoadingLayout loadingLayout;
        LoadingLayout loadingLayout2;
        ListAdapter adapter = ((ListView) this.mRefreshableView).getAdapter();
        if (!getShowViewWhileRefreshing() || adapter == null || adapter.isEmpty()) {
            super.setRefreshingInternal(z);
            return;
        }
        super.setRefreshingInternal(false);
        if (a.a[getCurrentMode().ordinal()] != 1) {
            loadingLayout2 = getHeaderLayout();
            loadingLayout = this.mHeaderLoadingView;
            i2 = getScrollY() + getFooterHeight();
            i = 0;
        } else {
            loadingLayout2 = getFooterLayout();
            LoadingLayout loadingLayout3 = this.mFooterLoadingView;
            i = ((ListView) this.mRefreshableView).getCount() - 1;
            i2 = getScrollY() - getHeaderHeight();
            loadingLayout = loadingLayout3;
        }
        if (z) {
            setHeaderScroll(i2);
        }
        loadingLayout2.setVisibility(4);
        loadingLayout.setVisibility(0);
        loadingLayout.refreshing();
        if (z) {
            ((ListView) this.mRefreshableView).setSelection(i);
            smoothScrollTo(0);
        }
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh, com.handmark.pulltorefresh.library.PullToRefreshBase
    public void setRefreshingLabel(CharSequence charSequence, PullToRefreshBase.Mode mode) {
        super.setRefreshingLabel(charSequence, mode);
        if (this.mHeaderLoadingView != null && mode.canPullDown()) {
            this.mHeaderLoadingView.setRefreshingLabel(charSequence);
        }
        if (this.mFooterLoadingView != null && mode.canPullUp()) {
            this.mFooterLoadingView.setRefreshingLabel(charSequence);
        }
    }

    @Override // com.handmark.pulltorefresh.library.IPullToRefresh, com.handmark.pulltorefresh.library.PullToRefreshBase
    public void setReleaseLabel(CharSequence charSequence, PullToRefreshBase.Mode mode) {
        super.setReleaseLabel(charSequence, mode);
        if (this.mHeaderLoadingView != null && mode.canPullDown()) {
            this.mHeaderLoadingView.setReleaseLabel(charSequence);
        }
        if (this.mFooterLoadingView != null && mode.canPullUp()) {
            this.mFooterLoadingView.setReleaseLabel(charSequence);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public final ListView createRefreshableView(Context context, AttributeSet attributeSet) {
        ListView createListView = createListView(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PullToRefresh);
        FrameLayout frameLayout = new FrameLayout(context);
        LoadingLayout createLoadingLayout = createLoadingLayout(context, PullToRefreshBase.Mode.PULL_DOWN_TO_REFRESH, obtainStyledAttributes);
        this.mHeaderLoadingView = createLoadingLayout;
        frameLayout.addView(createLoadingLayout, -1, -2);
        this.mHeaderLoadingView.setVisibility(8);
        createListView.addHeaderView(frameLayout, null, false);
        this.mLvFooterLoadingFrame = new FrameLayout(context);
        LoadingLayout createLoadingLayout2 = createLoadingLayout(context, PullToRefreshBase.Mode.PULL_UP_TO_REFRESH, obtainStyledAttributes);
        this.mFooterLoadingView = createLoadingLayout2;
        this.mLvFooterLoadingFrame.addView(createLoadingLayout2, -1, -2);
        this.mFooterLoadingView.setVisibility(8);
        obtainStyledAttributes.recycle();
        createListView.setId(16908298);
        return createListView;
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDisableScrollingWhileRefreshing(false);
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
        setDisableScrollingWhileRefreshing(false);
    }
}
