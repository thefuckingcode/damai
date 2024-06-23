package com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
public class StackLayoutManager extends RecyclerView.LayoutManager {
    private final ScrollOrientation a;
    private final b b;
    private final a c;
    private final int d;
    private int e;
    private boolean f;
    private final boolean g;
    private ScrollOrientation h;
    private final boolean i;
    private int j;
    private ItemChangedListener k;

    /* compiled from: Taobao */
    public interface ItemChangedListener {
        void onItemChanged(int i);
    }

    /* compiled from: Taobao */
    public enum ScrollOrientation {
        RIGHT,
        LEFT,
        BOTTOM,
        TOP,
        NONE
    }

    /* compiled from: Taobao */
    class a extends RecyclerView.OnFlingListener {
        final /* synthetic */ RecyclerView a;

        a(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
        public boolean onFling(int i, int i2) {
            if (StackLayoutManager.this.g) {
                int i3 = c.a[StackLayoutManager.this.a.ordinal()];
                if (i3 == 1 || i3 == 3) {
                    if (i > 0) {
                        StackLayoutManager.this.h = ScrollOrientation.LEFT;
                    } else if (i < 0) {
                        StackLayoutManager.this.h = ScrollOrientation.RIGHT;
                    } else {
                        StackLayoutManager.this.h = ScrollOrientation.NONE;
                    }
                    if (StackLayoutManager.this.e >= 1 && StackLayoutManager.this.e < StackLayoutManager.this.getWidth() * (StackLayoutManager.this.getItemCount() - 1)) {
                        StackLayoutManager.this.f = true;
                    }
                } else {
                    if (i2 > 0) {
                        StackLayoutManager.this.h = ScrollOrientation.TOP;
                    } else if (i2 < 0) {
                        StackLayoutManager.this.h = ScrollOrientation.BOTTOM;
                    } else {
                        StackLayoutManager.this.h = ScrollOrientation.NONE;
                    }
                    if (StackLayoutManager.this.e >= 1 && StackLayoutManager.this.e < StackLayoutManager.this.getHeight() * (StackLayoutManager.this.getItemCount() - 1)) {
                        StackLayoutManager.this.f = true;
                    }
                }
                StackLayoutManager.this.j(this.a);
            }
            return StackLayoutManager.this.g;
        }
    }

    /* compiled from: Taobao */
    class b extends RecyclerView.OnScrollListener {
        final /* synthetic */ RecyclerView a;

        b(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                StackLayoutManager stackLayoutManager = StackLayoutManager.this;
                stackLayoutManager.x(stackLayoutManager.getItemCount() > 0 ? StackLayoutManager.this.m() % StackLayoutManager.this.getItemCount() : StackLayoutManager.this.m());
                if (!StackLayoutManager.this.f) {
                    StackLayoutManager.this.f = true;
                    StackLayoutManager.this.j(this.a);
                    return;
                }
                StackLayoutManager.this.f = false;
            } else if (i == 1) {
                StackLayoutManager.this.f = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[ScrollOrientation.values().length];
            a = iArr;
            iArr[ScrollOrientation.LEFT.ordinal()] = 1;
            a[ScrollOrientation.TOP.ordinal()] = 2;
            a[ScrollOrientation.RIGHT.ordinal()] = 3;
            try {
                a[ScrollOrientation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public StackLayoutManager(c cVar) {
        this(cVar.a, cVar.b, cVar.c, cVar.d, cVar.e, cVar.f, cVar.g);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(RecyclerView recyclerView) {
        if (this.g && l() != 0.0f) {
            this.f = true;
            v(k(m()), recyclerView, Boolean.TRUE);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r1 != 4) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0035  */
    private int k(int i2) {
        ScrollOrientation scrollOrientation = this.h;
        int i3 = c.a[this.a.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                }
            }
            if (scrollOrientation != ScrollOrientation.TOP) {
                return i2 + 1;
            }
            if (scrollOrientation == ScrollOrientation.BOTTOM) {
                return i2;
            }
            if (scrollOrientation == ScrollOrientation.BOTTOM) {
                return i2 + 1;
            }
            if (scrollOrientation == ScrollOrientation.TOP) {
                return i2;
            }
            return ((double) l()) < 0.5d ? i2 : i2 + 1;
        } else if (scrollOrientation == ScrollOrientation.LEFT) {
            return i2 + 1;
        } else {
            if (scrollOrientation == ScrollOrientation.RIGHT) {
                return i2;
            }
        }
        if (scrollOrientation == ScrollOrientation.RIGHT) {
            return i2 + 1;
        }
        if (scrollOrientation == ScrollOrientation.LEFT) {
            return i2;
        }
        if (scrollOrientation != ScrollOrientation.TOP) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int m() {
        double floor;
        double itemCount;
        double ceil;
        if (getWidth() == 0 || getHeight() == 0) {
            return 0;
        }
        int i2 = c.a[this.a.ordinal()];
        if (i2 == 1) {
            floor = Math.floor((((double) this.e) * 1.0d) / ((double) getWidth()));
        } else if (i2 != 2) {
            if (i2 != 3) {
                itemCount = (double) (getItemCount() - 1);
                ceil = Math.ceil((((double) this.e) * 1.0d) / ((double) getHeight()));
            } else {
                itemCount = (double) (getItemCount() - 1);
                ceil = Math.ceil((((double) this.e) * 1.0d) / ((double) getWidth()));
            }
            floor = itemCount - ceil;
        } else {
            floor = Math.floor((((double) this.e) * 1.0d) / ((double) getHeight()));
        }
        return (int) floor;
    }

    private int n() {
        int m = m();
        if (this.i) {
            return m + this.d;
        }
        return Math.min(m + this.d, getItemCount() - 1);
    }

    private int o(int i2) {
        int width;
        int itemCount;
        int width2;
        int i3 = c.a[this.a.ordinal()];
        if (i3 == 1) {
            width = getWidth();
        } else if (i3 != 2) {
            if (i3 != 3) {
                itemCount = (getItemCount() - 1) - i2;
                width2 = getHeight();
            } else {
                itemCount = (getItemCount() - 1) - i2;
                width2 = getWidth();
            }
            return itemCount * width2;
        } else {
            width = getHeight();
        }
        return i2 * width;
    }

    private int p(int i2) {
        int i3 = c.a[this.a.ordinal()];
        int i4 = 500;
        if (i3 == 1 || i3 == 3) {
            int width = getWidth() * (getItemCount() - 1);
            if (!this.i) {
                i4 = 1;
            }
            return Math.max(Math.min(width * i4, i2), 0);
        }
        int height = getHeight() * (getItemCount() - 1);
        if (!this.i) {
            i4 = 1;
        }
        return Math.max(Math.min(height * i4, i2), 0);
    }

    private int q(int i2, RecyclerView.Recycler recycler) {
        int i3 = this.e + i2;
        int p = p(i3);
        this.e = p;
        int i4 = (p - i3) + i2;
        if (i4 == 0) {
            return 0;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.i) {
            s(recycler);
        } else {
            r(recycler);
        }
        return i4;
    }

    private void r(RecyclerView.Recycler recycler) {
        int m = m();
        int min = Math.min(n(), getItemCount() - 1);
        float l = l();
        for (int i2 = min; i2 >= m; i2--) {
            View viewForPosition = recycler.getViewForPosition(i2);
            if (viewForPosition != null) {
                addView(viewForPosition);
                measureChild(viewForPosition, 0, 0);
                int i3 = i2 - m;
                this.b.a(this, this.e, l, viewForPosition, i3, this.c);
                this.c.a(l, viewForPosition, i3);
            }
        }
        int i4 = m - 1;
        if (i4 >= 0) {
            t(recycler, recycler.getViewForPosition(i4));
        }
        int i5 = min + 1;
        if (i5 < getItemCount()) {
            t(recycler, recycler.getViewForPosition(i5));
        }
    }

    private void s(RecyclerView.Recycler recycler) {
        int m = m();
        int n = n();
        float l = l();
        for (int i2 = n; i2 >= m; i2--) {
            View viewForPosition = recycler.getViewForPosition(i2 % getItemCount());
            if (viewForPosition != null) {
                addView(viewForPosition);
                measureChild(viewForPosition, 0, 0);
                int i3 = i2 - m;
                this.b.a(this, this.e, l, viewForPosition, i3, this.c);
                this.c.a(l, viewForPosition, i3);
            }
        }
        int i4 = m - 1;
        if (i4 >= 0) {
            t(recycler, recycler.getViewForPosition(i4 % getItemCount()));
        }
        int i5 = n + 1;
        if (i5 < getItemCount()) {
            t(recycler, recycler.getViewForPosition(i5 % getItemCount()));
        }
    }

    private void t(RecyclerView.Recycler recycler, View view) {
        if (view != null) {
            u(view);
            removeAndRecycleView(view, recycler);
        }
    }

    private void u(View view) {
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
    }

    private void v(int i2, RecyclerView recyclerView, Boolean bool) {
        int o = o(i2);
        int i3 = c.a[this.a.ordinal()];
        if (i3 == 1 || i3 == 3) {
            if (bool.booleanValue()) {
                recyclerView.smoothScrollBy(o - this.e, 0);
            } else {
                recyclerView.scrollBy(o - this.e, 0);
            }
        } else if (bool.booleanValue()) {
            recyclerView.smoothScrollBy(0, o - this.e);
        } else {
            recyclerView.scrollBy(0, o - this.e);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void x(int i2) {
        ItemChangedListener itemChangedListener = this.k;
        if (itemChangedListener != null && this.g && i2 != this.j) {
            this.j = i2;
            itemChangedListener.onItemChanged(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        ScrollOrientation scrollOrientation = this.a;
        return scrollOrientation == ScrollOrientation.RIGHT || scrollOrientation == ScrollOrientation.LEFT;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        ScrollOrientation scrollOrientation = this.a;
        return scrollOrientation == ScrollOrientation.BOTTOM || scrollOrientation == ScrollOrientation.TOP;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public float l() {
        float width;
        int width2;
        if (getWidth() == 0 || getHeight() == 0) {
            return 0.0f;
        }
        int i2 = c.a[this.a.ordinal()];
        if (i2 == 1) {
            width = ((float) (this.e % getWidth())) * 1.0f;
            width2 = getWidth();
        } else if (i2 == 2) {
            width = ((float) (this.e % getHeight())) * 1.0f;
            width2 = getHeight();
        } else if (i2 != 3) {
            float height = 1.0f - ((((float) (this.e % getHeight())) * 1.0f) / ((float) getHeight()));
            if (height == 1.0f) {
                return 0.0f;
            }
            return height;
        } else {
            float width3 = 1.0f - ((((float) (this.e % getWidth())) * 1.0f) / ((float) getWidth()));
            if (width3 == 1.0f) {
                return 0.0f;
            }
            return width3;
        }
        return width / ((float) width2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        recyclerView.setOnFlingListener(new a(recyclerView));
        recyclerView.addOnScrollListener(new b(recyclerView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.g();
            removeAndRecycleAllViews(recycler);
            if (getItemCount() > 0) {
                this.e = p(this.e);
                if (this.i) {
                    s(recycler);
                } else {
                    r(recycler);
                }
            }
            x(getItemCount() > 0 ? m() % getItemCount() : m());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void requestLayout() {
        super.requestLayout();
        b bVar = this.b;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return q(i2, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i2) {
        if (i2 < 0 || i2 >= getItemCount()) {
            throw new ArrayIndexOutOfBoundsException("$position is out of bound [0..$itemCount-1]");
        }
        this.f = true;
        this.e = o(i2);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return q(i2, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        super.smoothScrollToPosition(recyclerView, state, i2);
        if (i2 < 0 || i2 >= getItemCount()) {
            throw new ArrayIndexOutOfBoundsException("$position is out of bound [0..$itemCount-1]");
        }
        this.f = true;
        v(i2, recyclerView, Boolean.TRUE);
    }

    public void w(ItemChangedListener itemChangedListener) {
        this.k = itemChangedListener;
    }

    public StackLayoutManager(ScrollOrientation scrollOrientation, int i2, float f2, boolean z, boolean z2, float f3, float f4) {
        this.f = false;
        this.j = -1;
        this.a = scrollOrientation;
        this.d = i2;
        this.i = z2 && (scrollOrientation == ScrollOrientation.LEFT || scrollOrientation == ScrollOrientation.TOP);
        this.g = z;
        this.b = new b(scrollOrientation, i2, f2);
        this.c = new a(scrollOrientation, i2, f3, f4);
        int i3 = c.a[scrollOrientation.ordinal()];
        if (i3 == 1 || i3 == 2) {
            this.e = 0;
        } else {
            this.e = Integer.MAX_VALUE;
        }
    }
}
