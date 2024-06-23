package cn.damai.uikit.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import cn.damai.uikit.R$styleable;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PullToRefreshListView extends PullToRefreshAdapterViewBase<ListView> {
    private static transient /* synthetic */ IpChange $ipChange;
    private LoadingLayout mFooterLoadingView;
    private LoadingLayout mHeaderLoadingView;
    private boolean mListViewExtrasEnabled;
    private FrameLayout mLvFooterLoadingFrame;

    /* compiled from: Taobao */
    public class InternalListView extends ListView implements EmptyViewMethodAccessor {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean mAddedLvFooter = false;

        public InternalListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1576664912")) {
                ipChange.ipc$dispatch("1576664912", new Object[]{this, canvas});
                return;
            }
            try {
                super.dispatchDraw(canvas);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1545212777")) {
                return ((Boolean) ipChange.ipc$dispatch("-1545212777", new Object[]{this, motionEvent})).booleanValue();
            }
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyView(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-944166929")) {
                ipChange.ipc$dispatch("-944166929", new Object[]{this, view});
                return;
            }
            PullToRefreshListView.this.setEmptyView(view);
        }

        @Override // cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-156349172")) {
                ipChange.ipc$dispatch("-156349172", new Object[]{this, view});
                return;
            }
            super.setEmptyView(view);
        }

        @Override // android.widget.AbsListView, android.widget.ListView
        public void setAdapter(ListAdapter listAdapter) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1137979279")) {
                ipChange.ipc$dispatch("1137979279", new Object[]{this, listAdapter});
                return;
            }
            if (PullToRefreshListView.this.mLvFooterLoadingFrame != null && !this.mAddedLvFooter) {
                addFooterView(PullToRefreshListView.this.mLvFooterLoadingFrame, null, false);
                this.mAddedLvFooter = true;
            }
            super.setAdapter(listAdapter);
        }
    }

    @TargetApi(9)
    /* compiled from: Taobao */
    public final class InternalListViewSDK9 extends InternalListView {
        private static transient /* synthetic */ IpChange $ipChange;

        public InternalListViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "236636318")) {
                return ((Boolean) ipChange.ipc$dispatch("236636318", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)})).booleanValue();
            }
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            b.d(PullToRefreshListView.this, i, i3, i2, i4, z);
            return overScrollBy;
        }
    }

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            a = iArr;
            iArr[PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY.ordinal()] = 1;
            a[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 2;
            try {
                a[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public PullToRefreshListView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public ListView createListView(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-480213363")) {
            return (ListView) ipChange.ipc$dispatch("-480213363", new Object[]{this, context, attributeSet});
        } else if (Build.VERSION.SDK_INT >= 9) {
            return new InternalListViewSDK9(context, attributeSet);
        } else {
            return new InternalListView(context, attributeSet);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public a createLoadingLayoutProxy(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245772312")) {
            return (a) ipChange.ipc$dispatch("1245772312", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        a createLoadingLayoutProxy = super.createLoadingLayoutProxy(z, z2);
        if (this.mListViewExtrasEnabled) {
            PullToRefreshBase.Mode mode = getMode();
            if (z && mode.showHeaderLoadingLayout()) {
                createLoadingLayoutProxy.a(this.mHeaderLoadingView);
            }
            if (z2 && mode.showFooterLoadingLayout()) {
                createLoadingLayoutProxy.a(this.mFooterLoadingView);
            }
        }
        return createLoadingLayoutProxy;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1339559965")) {
            return PullToRefreshBase.Orientation.VERTICAL;
        }
        return (PullToRefreshBase.Orientation) ipChange.ipc$dispatch("-1339559965", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshAdapterViewBase, cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void handleStyledAttributes(TypedArray typedArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1816250028")) {
            ipChange.ipc$dispatch("1816250028", new Object[]{this, typedArray});
            return;
        }
        super.handleStyledAttributes(typedArray);
        boolean z = typedArray.getBoolean(R$styleable.PullToRefresh_ptrListViewExtrasEnabled, true);
        this.mListViewExtrasEnabled = z;
        if (z) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
            FrameLayout frameLayout = new FrameLayout(getContext());
            LoadingLayout createLoadingLayout = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START, typedArray);
            this.mHeaderLoadingView = createLoadingLayout;
            createLoadingLayout.setVisibility(8);
            frameLayout.addView(this.mHeaderLoadingView, layoutParams);
            ((ListView) this.mRefreshableView).addHeaderView(frameLayout, null, false);
            this.mLvFooterLoadingFrame = new FrameLayout(getContext());
            LoadingLayout createLoadingLayout2 = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END, typedArray);
            this.mFooterLoadingView = createLoadingLayout2;
            createLoadingLayout2.setVisibility(8);
            this.mLvFooterLoadingFrame.addView(this.mFooterLoadingView, layoutParams);
            if (!typedArray.hasValue(R$styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled)) {
                setScrollingWhileRefreshingEnabled(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshAdapterViewBase, cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void onRefreshing(boolean z) {
        int i;
        int i2;
        LoadingLayout loadingLayout;
        LoadingLayout loadingLayout2;
        LoadingLayout loadingLayout3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1407705705")) {
            ipChange.ipc$dispatch("-1407705705", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ListAdapter adapter = ((ListView) this.mRefreshableView).getAdapter();
        if (!this.mListViewExtrasEnabled || !getShowViewWhileRefreshing() || adapter == null || adapter.isEmpty()) {
            super.onRefreshing(z);
            return;
        }
        super.onRefreshing(false);
        int i3 = a.a[getCurrentMode().ordinal()];
        if (i3 == 1 || i3 == 2) {
            loadingLayout3 = getFooterLayout();
            loadingLayout2 = this.mFooterLoadingView;
            loadingLayout = this.mHeaderLoadingView;
            int scrollY = getScrollY() - getFooterSize();
            i = ((ListView) this.mRefreshableView).getCount() - 1;
            i2 = scrollY;
        } else {
            loadingLayout3 = getHeaderLayout();
            loadingLayout2 = this.mHeaderLoadingView;
            loadingLayout = this.mFooterLoadingView;
            i2 = getScrollY() + getHeaderSize();
            i = 0;
        }
        loadingLayout3.reset();
        loadingLayout3.hideAllViews();
        loadingLayout.setVisibility(8);
        loadingLayout2.setVisibility(0);
        loadingLayout2.refreshing();
        if (z) {
            disableLoadingLayoutVisibilityChanges();
            setHeaderScroll(i2);
            ((ListView) this.mRefreshableView).setSelection(i);
            smoothScrollTo(0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshAdapterViewBase, cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void onReset() {
        int i;
        LoadingLayout loadingLayout;
        LoadingLayout loadingLayout2;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        int i3 = 1;
        if (AndroidInstantRuntime.support(ipChange, "375881847")) {
            ipChange.ipc$dispatch("375881847", new Object[]{this});
        } else if (!this.mListViewExtrasEnabled) {
            super.onReset();
        } else {
            int i4 = a.a[getCurrentMode().ordinal()];
            if (i4 == 1 || i4 == 2) {
                loadingLayout2 = getFooterLayout();
                loadingLayout = this.mFooterLoadingView;
                int count = ((ListView) this.mRefreshableView).getCount() - 1;
                int footerSize = getFooterSize();
                if (Math.abs(((ListView) this.mRefreshableView).getLastVisiblePosition() - count) <= 1) {
                    i2 = 1;
                }
                i3 = i2;
                i2 = count;
                i = footerSize;
            } else {
                loadingLayout2 = getHeaderLayout();
                loadingLayout = this.mHeaderLoadingView;
                i = -getHeaderSize();
                if (Math.abs(((ListView) this.mRefreshableView).getFirstVisiblePosition() - 0) > 1) {
                    i3 = 0;
                }
            }
            if (loadingLayout.getVisibility() == 0) {
                loadingLayout2.showInvisibleViews();
                loadingLayout.setVisibility(8);
                if (!(i3 == 0 || getState() == PullToRefreshBase.State.MANUAL_REFRESHING)) {
                    ((ListView) this.mRefreshableView).setSelection(i2);
                    setHeaderScroll(i);
                }
            }
            super.onReset();
        }
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public ListView createRefreshableView(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897540594")) {
            return (ListView) ipChange.ipc$dispatch("897540594", new Object[]{this, context, attributeSet});
        }
        ListView createListView = createListView(context, attributeSet);
        createListView.setId(16908298);
        return createListView;
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }
}
