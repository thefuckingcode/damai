package com.taobao.android.dinamicx.widget.recycler;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.android.dinamicx.widget.recycler.nested.DXNestedScrollerView;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout;
import com.taobao.android.dinamicx.widget.recycler.view.DXRecyclerView;
import tb.be;
import tb.rz;

/* compiled from: Taobao */
public class WaterfallLayout implements IEleSectionHeightListener, TBSwipeRefreshLayout.OnChildScrollUpCallback {
    private TBAbsRefreshHeader A;
    private DXNestedScrollerView B;
    private boolean C;
    private rz D;
    private int E;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private String[] n;
    private String[] o;
    private TBSwipeRefreshLayout.OnPullRefreshListener p;
    private TBSwipeRefreshLayout.OnPushLoadMoreListener q;
    private RecyclerView.OnScrollListener r;
    private WaterfallLayoutRelativeLayout s;
    private StickyLayout t;
    private StickyItemDecoration u;
    private SpaceItemDecoration v;
    private RecyclerView.LayoutManager w;
    private RecyclerView x;
    private TBSwipeRefreshLayout y;
    public boolean z;

    /* compiled from: Taobao */
    public static class b {
        private int a = 1;
        private int b = -1;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private boolean l;
        private boolean m;
        private String[] n;
        private String[] o;
        private boolean p;
        private TBAbsRefreshHeader q;
        private DXNestedScrollerView r;
        private boolean s;
        private boolean t;
        private int u;

        public WaterfallLayout a() {
            return new WaterfallLayout(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u);
        }

        public b b(int i2) {
            this.a = i2;
            return this;
        }

        public b c(int i2) {
            this.c = i2;
            return this;
        }

        public b d(boolean z) {
            this.p = z;
            return this;
        }

        public b e(DXNestedScrollerView dXNestedScrollerView) {
            this.r = dXNestedScrollerView;
            return this;
        }

        public b f(boolean z) {
            this.s = z;
            return this;
        }

        public b g(boolean z) {
            this.l = z;
            return this;
        }

        public b h(int i2) {
            this.d = i2;
            return this;
        }

        public b i(int i2) {
            this.j = i2;
            return this;
        }

        public b j(int i2) {
            this.k = i2;
            return this;
        }

        public b k(boolean z) {
            this.t = z;
            return this;
        }

        public b l(String[] strArr) {
            this.n = strArr;
            return this;
        }

        public b m(int i2) {
            this.e = i2;
            return this;
        }

        public b n(TBAbsRefreshHeader tBAbsRefreshHeader) {
            this.q = tBAbsRefreshHeader;
            return this;
        }

        public b o(int i2) {
            this.u = i2;
            return this;
        }
    }

    /* compiled from: Taobao */
    public static class c extends be {
        @Override // tb.be
        public boolean g() {
            return super.g() && !"VTR-AL00".equals(Build.getMODEL());
        }
    }

    public View a(Context context) {
        WaterfallLayoutRelativeLayout waterfallLayoutRelativeLayout = new WaterfallLayoutRelativeLayout(context);
        this.s = waterfallLayoutRelativeLayout;
        waterfallLayoutRelativeLayout.setTranslationY(-1.0f);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        marginLayoutParams.leftMargin = this.i;
        marginLayoutParams.rightMargin = this.j;
        this.s.setLayoutParams(marginLayoutParams);
        this.s.setPadding(this.e, this.g, this.f, this.h);
        TBSwipeRefreshLayout tBSwipeRefreshLayout = new TBSwipeRefreshLayout(context);
        this.y = tBSwipeRefreshLayout;
        tBSwipeRefreshLayout.setOnChildScrollUpCallback(this);
        TBAbsRefreshHeader tBAbsRefreshHeader = this.A;
        if (tBAbsRefreshHeader != null) {
            this.y.setHeaderView(tBAbsRefreshHeader);
        }
        if (this.k) {
            this.y.enablePullRefresh(true);
        }
        if (this.l) {
            this.y.enableLoadMore(true);
        }
        TBSwipeRefreshLayout.OnPushLoadMoreListener onPushLoadMoreListener = this.q;
        if (onPushLoadMoreListener != null) {
            this.y.setOnPushLoadMoreListener(onPushLoadMoreListener);
        }
        TBSwipeRefreshLayout.OnPullRefreshListener onPullRefreshListener = this.p;
        if (onPullRefreshListener != null) {
            this.y.setOnPullRefreshListener(onPullRefreshListener);
        }
        this.y.setLoadMoreTips(this.o);
        this.y.setRefreshTips(this.n);
        RecyclerView dXRecyclerView = new DXRecyclerView(context);
        StickyItemDecoration stickyItemDecoration = new StickyItemDecoration();
        this.u = stickyItemDecoration;
        dXRecyclerView.addItemDecoration(stickyItemDecoration);
        SpaceItemDecoration spaceItemDecoration = new SpaceItemDecoration(this.b, this.c, this.d, this.a, this.C);
        this.v = spaceItemDecoration;
        dXRecyclerView.addItemDecoration(spaceItemDecoration);
        this.x = dXRecyclerView;
        RecyclerView.OnScrollListener onScrollListener = this.r;
        if (onScrollListener != null) {
            dXRecyclerView.addOnScrollListener(onScrollListener);
        }
        g(dXRecyclerView, context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(dXRecyclerView);
        this.y.addView(frameLayout);
        this.s.addView(this.y, -1, -1);
        StickyLayout stickyLayout = new StickyLayout(context);
        this.t = stickyLayout;
        stickyLayout.setRecyclerView(this.x);
        frameLayout.addView(this.t, -1, -1);
        this.u.l(this.t);
        this.t.setHeightUpdateListener(this);
        DXNestedScrollerView dXNestedScrollerView = this.B;
        if (dXNestedScrollerView == null || dXNestedScrollerView.getmRootList() == null) {
            this.B.addView(this.s);
            this.B.setRoot(dXRecyclerView);
            return this.B;
        }
        DXNestedScrollerView dXNestedScrollerView2 = this.B;
        if (dXNestedScrollerView2 != null && dXNestedScrollerView2.getmChildList() == null) {
            this.B.setCurrentChild(dXRecyclerView);
        }
        return this.s;
    }

    public be b() {
        WaterfallLayoutRelativeLayout waterfallLayoutRelativeLayout = this.s;
        if (waterfallLayoutRelativeLayout != null) {
            return waterfallLayoutRelativeLayout.getCLipRadiusHandler();
        }
        return null;
    }

    public RecyclerView.OnScrollListener c() {
        return this.r;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout.OnChildScrollUpCallback
    public boolean canChildScrollUp(TBSwipeRefreshLayout tBSwipeRefreshLayout) {
        return !this.z;
    }

    public rz d() {
        return this.D;
    }

    public RecyclerView e() {
        return this.x;
    }

    public RecyclerView.LayoutManager f() {
        if (this.E == 0) {
            return new ScrollStaggeredGridLayoutManager(this.a, 0, this);
        }
        return new ScrollStaggeredGridLayoutManager(this.a, 1, this);
    }

    public void g(RecyclerView recyclerView, Context context) {
        this.x = recyclerView;
        recyclerView.setItemAnimator(null);
        recyclerView.setHasFixedSize(true);
        if (this.m) {
            recyclerView.setOverScrollMode(2);
        }
        this.w = f();
        recyclerView.setDescendantFocusability(131072);
        recyclerView.setLayoutManager(this.w);
        recyclerView.setClipToPadding(false);
        recyclerView.setSaveEnabled(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d0  */
    public void h(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z2, boolean z3, String[] strArr, String[] strArr2, boolean z4, boolean z5) {
        boolean z6;
        int i13;
        if (this.s != null) {
            if (!(this.i == i11 && this.j == i12)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
                marginLayoutParams.leftMargin = i11;
                marginLayoutParams.rightMargin = i12;
                this.s.setLayoutParams(marginLayoutParams);
            }
            if (!(this.e == i7 && this.h == i10 && this.f == i8 && this.g == i9)) {
                this.s.setPadding(i7, i9, i8, i10);
            }
        }
        TBSwipeRefreshLayout tBSwipeRefreshLayout = this.y;
        if (tBSwipeRefreshLayout != null) {
            if (z2) {
                tBSwipeRefreshLayout.enablePullRefresh(true);
            } else {
                tBSwipeRefreshLayout.enablePullRefresh(false);
            }
            if (z3) {
                this.y.enableLoadMore(true);
            } else {
                this.y.enableLoadMore(false);
            }
            this.y.setLoadMoreTips(strArr2);
            this.y.setRefreshTips(strArr);
        }
        if (this.x != null) {
            StickyItemDecoration stickyItemDecoration = this.u;
            if (stickyItemDecoration != null) {
                stickyItemDecoration.a();
            }
            if (this.b == i4 && this.c == i5 && this.d == i6) {
                i13 = i2;
                if (this.a == i13) {
                    z6 = z4;
                    if (!z6) {
                        this.x.setOverScrollMode(2);
                    } else {
                        this.x.setOverScrollMode(0);
                    }
                    if (this.a != i13) {
                        this.a = i13;
                        RecyclerView.LayoutManager f2 = f();
                        this.w = f2;
                        this.x.setLayoutManager(f2);
                    }
                }
            } else {
                i13 = i2;
            }
            this.x.removeItemDecoration(this.v);
            z6 = z4;
            SpaceItemDecoration spaceItemDecoration = new SpaceItemDecoration(i4, i5, i6, i2, z5);
            this.v = spaceItemDecoration;
            this.x.addItemDecoration(spaceItemDecoration);
            if (!z6) {
            }
            if (this.a != i13) {
            }
        } else {
            i13 = i2;
            z6 = z4;
        }
        this.a = i13;
        this.b = i4;
        this.c = i5;
        this.d = i6;
        this.e = i7;
        this.f = i8;
        this.g = i9;
        this.h = i10;
        this.i = i11;
        this.j = i12;
        this.k = z2;
        this.l = z3;
        this.n = strArr;
        this.o = strArr2;
        this.m = z6;
    }

    public void i(BaseStickyAdapter baseStickyAdapter) {
        this.x.setAdapter(baseStickyAdapter);
        this.u.k(baseStickyAdapter);
    }

    public void j(c cVar) {
        WaterfallLayoutRelativeLayout waterfallLayoutRelativeLayout = this.s;
        if (waterfallLayoutRelativeLayout != null) {
            waterfallLayoutRelativeLayout.setClipRadiusHandler(cVar);
        }
    }

    public void k(TBSwipeRefreshLayout.OnPullRefreshListener onPullRefreshListener) {
        this.p = onPullRefreshListener;
        TBSwipeRefreshLayout tBSwipeRefreshLayout = this.y;
        if (tBSwipeRefreshLayout != null) {
            tBSwipeRefreshLayout.setOnPullRefreshListener(onPullRefreshListener);
        }
    }

    public void l(RecyclerView.OnScrollListener onScrollListener) {
        this.r = onScrollListener;
        RecyclerView recyclerView = this.x;
        if (recyclerView != null) {
            recyclerView.clearOnScrollListeners();
            this.x.addOnScrollListener(onScrollListener);
        }
    }

    public void m(rz rzVar) {
        this.D = rzVar;
        RecyclerView recyclerView = this.x;
        if (recyclerView != null) {
            recyclerView.setOnTouchListener(rzVar);
        }
    }

    public void n(boolean z2) {
    }

    public void o(boolean z2) {
        this.z = z2;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.IEleSectionHeightListener
    public void onSectionHeightUpdated() {
        this.x.removeItemDecoration(this.u);
        this.x.addItemDecoration(this.u);
    }

    public void p() {
        TBSwipeRefreshLayout tBSwipeRefreshLayout = this.y;
        if (tBSwipeRefreshLayout != null) {
            tBSwipeRefreshLayout.setAutoRefreshing(true);
        }
    }

    public void q() {
        TBSwipeRefreshLayout tBSwipeRefreshLayout = this.y;
        if (tBSwipeRefreshLayout != null) {
            tBSwipeRefreshLayout.setRefreshing(false);
        }
    }

    /* compiled from: Taobao */
    public class WaterfallLayoutRelativeLayout extends RelativeLayout {
        private be cLipRadiusHandler;

        public WaterfallLayoutRelativeLayout(Context context) {
            super(context);
        }

        public void dispatchDraw(Canvas canvas) {
            be beVar = this.cLipRadiusHandler;
            if (beVar == null) {
                super.dispatchDraw(canvas);
            } else if (beVar.h()) {
                super.dispatchDraw(canvas);
            } else {
                this.cLipRadiusHandler.b(this, canvas);
                super.dispatchDraw(canvas);
                this.cLipRadiusHandler.a(this, canvas);
            }
        }

        public be getCLipRadiusHandler() {
            return this.cLipRadiusHandler;
        }

        public void setClipRadiusHandler(be beVar) {
            this.cLipRadiusHandler = beVar;
        }

        public WaterfallLayoutRelativeLayout(Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public WaterfallLayoutRelativeLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    private WaterfallLayout(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z2, boolean z3, String[] strArr, String[] strArr2, boolean z4, TBAbsRefreshHeader tBAbsRefreshHeader, DXNestedScrollerView dXNestedScrollerView, boolean z5, boolean z6, int i13) {
        this.a = 1;
        this.z = true;
        this.a = i2;
        this.b = i4;
        this.c = i5;
        this.d = i6;
        this.e = i7;
        this.f = i8;
        this.g = i9;
        this.h = i10;
        this.i = i11;
        this.j = i12;
        this.k = z2;
        this.l = z3;
        this.n = strArr;
        this.o = strArr2;
        this.m = z4;
        this.A = tBAbsRefreshHeader;
        this.B = dXNestedScrollerView;
        this.C = z5;
        this.E = i13;
    }
}
