package com.alibaba.android.vlayout.layout;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.c;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.android.vlayout.layout.g;
import java.util.HashMap;
import java.util.Map;
import tb.sw1;

/* compiled from: Taobao */
public class g<T extends g> {
    protected BaseLayoutHelper a;
    protected T b;
    private int c = 0;
    private int d = 0;
    protected sw1<Integer> e;
    protected HashMap<sw1<Integer>, T> f = new HashMap<>();
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    protected int n;
    protected Rect o = new Rect();
    private View p;
    private int q;
    private BaseLayoutHelper.LayoutViewUnBindListener r;
    private BaseLayoutHelper.LayoutViewBindListener s;

    private void M(LayoutManagerHelper layoutManagerHelper, g<T> gVar) {
        for (Map.Entry<sw1<Integer>, T> entry : gVar.f.entrySet()) {
            T value = entry.getValue();
            if (!value.O()) {
                M(layoutManagerHelper, value);
            }
            View view = value.p;
            if (view != null) {
                layoutManagerHelper.hideView(view);
            }
        }
    }

    private void N(LayoutManagerHelper layoutManagerHelper) {
        if (S()) {
            M(layoutManagerHelper, this);
            View view = this.p;
            if (view != null) {
                layoutManagerHelper.hideView(view);
            }
        }
    }

    private boolean T(int i2) {
        return (i2 == Integer.MAX_VALUE || i2 == Integer.MIN_VALUE) ? false : true;
    }

    private void W(LayoutManagerHelper layoutManagerHelper, g<T> gVar) {
        if (!gVar.O()) {
            for (Map.Entry<sw1<Integer>, T> entry : gVar.f.entrySet()) {
                W(layoutManagerHelper, entry.getValue());
            }
        }
        View view = gVar.p;
        if (view != null) {
            BaseLayoutHelper.LayoutViewUnBindListener layoutViewUnBindListener = gVar.r;
            if (layoutViewUnBindListener != null) {
                layoutViewUnBindListener.onUnbind(view, y());
            }
            layoutManagerHelper.removeChildView(gVar.p);
            gVar.p = null;
        }
    }

    private boolean X(g<T> gVar) {
        boolean z = (gVar.q == 0 && gVar.s == null) ? false : true;
        for (Map.Entry<sw1<Integer>, T> entry : gVar.f.entrySet()) {
            T value = entry.getValue();
            if (value.O()) {
                return value.Y();
            }
            z |= X(value);
        }
        return z;
    }

    private void e(LayoutManagerHelper layoutManagerHelper, g<T> gVar) {
        View view = gVar.p;
        if (view != null) {
            BaseLayoutHelper.LayoutViewUnBindListener layoutViewUnBindListener = gVar.r;
            if (layoutViewUnBindListener != null) {
                layoutViewUnBindListener.onUnbind(view, y());
            }
            layoutManagerHelper.removeChildView(gVar.p);
            gVar.p = null;
        }
        if (!gVar.f.isEmpty()) {
            for (Map.Entry<sw1<Integer>, T> entry : gVar.f.entrySet()) {
                e(layoutManagerHelper, entry.getValue());
            }
        }
    }

    private void g0(g<T> gVar) {
        if (!gVar.O()) {
            for (Map.Entry<sw1<Integer>, T> entry : gVar.f.entrySet()) {
                T value = entry.getValue();
                g0(value);
                View view = value.p;
                if (view != null) {
                    gVar.o.union(view.getLeft(), value.p.getTop(), value.p.getRight(), value.p.getBottom());
                }
            }
        }
    }

    public int A() {
        return this.k;
    }

    public int B() {
        return this.l;
    }

    public int C() {
        return this.m;
    }

    public int D() {
        return this.d;
    }

    public int E() {
        return this.c;
    }

    public int F() {
        return this.j;
    }

    public int G() {
        return this.g;
    }

    public int H() {
        return this.h;
    }

    public int I() {
        return this.i;
    }

    public sw1<Integer> J() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public int K() {
        return this.m + this.n;
    }

    /* access modifiers changed from: protected */
    public int L() {
        return this.i + this.j;
    }

    public boolean O() {
        return this.f.isEmpty();
    }

    public boolean P(int i2) {
        sw1<Integer> sw1 = this.e;
        return sw1 != null && sw1.d().intValue() == i2;
    }

    public boolean Q(int i2) {
        sw1<Integer> sw1 = this.e;
        return sw1 != null && sw1.e().intValue() == i2;
    }

    public boolean R(int i2) {
        sw1<Integer> sw1 = this.e;
        return sw1 == null || !sw1.a(Integer.valueOf(i2));
    }

    public boolean S() {
        return this.b == null;
    }

    public void U(View view, int i2, int i3, int i4, int i5, @NonNull LayoutManagerHelper layoutManagerHelper, boolean z) {
        layoutManagerHelper.layoutChildWithMargins(view, i2, i3, i4, i5);
        f(i2, i3, i4, i5, z);
    }

    public void V(LayoutManagerHelper layoutManagerHelper) {
        e(layoutManagerHelper, this);
    }

    public boolean Y() {
        boolean z = (this.q == 0 && this.s == null) ? false : true;
        return !O() ? z | X(this) : z;
    }

    public void Z(int i2) {
        this.q = i2;
    }

    public void a(int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        if (!O()) {
            for (Map.Entry<sw1<Integer>, T> entry : this.f.entrySet()) {
                entry.getValue().a(i2, i3, layoutManagerHelper);
            }
        }
        if (Y()) {
            Rect rect = new Rect();
            c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            for (int i4 = 0; i4 < layoutManagerHelper.getChildCount(); i4++) {
                View childAt = layoutManagerHelper.getChildAt(i4);
                if (J().a(Integer.valueOf(layoutManagerHelper.getPosition(childAt)))) {
                    if (childAt.getVisibility() == 8) {
                        rect.setEmpty();
                    } else {
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                        if (layoutManagerHelper.getOrientation() == 1) {
                            rect.union(layoutManagerHelper.getDecoratedLeft(childAt) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, mainOrientationHelper.g(childAt), layoutManagerHelper.getDecoratedRight(childAt) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, mainOrientationHelper.d(childAt));
                        } else {
                            rect.union(mainOrientationHelper.g(childAt), layoutManagerHelper.getDecoratedTop(childAt) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, mainOrientationHelper.d(childAt), layoutManagerHelper.getDecoratedBottom(childAt) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        }
                    }
                }
            }
            if (!rect.isEmpty()) {
                this.o.set(rect.left - this.g, rect.top - this.i, rect.right + this.h, rect.bottom + this.j);
            } else {
                this.o.setEmpty();
            }
            View view = this.p;
            if (view != null) {
                Rect rect2 = this.o;
                view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        }
    }

    public void a0(BaseLayoutHelper.LayoutViewBindListener layoutViewBindListener) {
        this.s = layoutViewBindListener;
    }

    public void b(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, int i3, int i4, LayoutManagerHelper layoutManagerHelper) {
        View view;
        if (!O()) {
            for (Map.Entry<sw1<Integer>, T> entry : this.f.entrySet()) {
                entry.getValue().b(recycler, state, i2, i3, i4, layoutManagerHelper);
            }
        }
        if (Y()) {
            if (T(i4) && (view = this.p) != null) {
                this.o.union(view.getLeft(), this.p.getTop(), this.p.getRight(), this.p.getBottom());
            }
            if (!this.o.isEmpty()) {
                if (T(i4)) {
                    if (layoutManagerHelper.getOrientation() == 1) {
                        this.o.offset(0, -i4);
                    } else {
                        this.o.offset(-i4, 0);
                    }
                }
                g0(this);
                int contentWidth = layoutManagerHelper.getContentWidth();
                int contentHeight = layoutManagerHelper.getContentHeight();
                if (layoutManagerHelper.getOrientation() != 1 ? !this.o.intersects((-contentWidth) / 4, 0, contentWidth + (contentWidth / 4), contentHeight) : !this.o.intersects(0, (-contentHeight) / 4, contentWidth, contentHeight + (contentHeight / 4))) {
                    this.o.set(0, 0, 0, 0);
                    View view2 = this.p;
                    if (view2 != null) {
                        view2.layout(0, 0, 0, 0);
                    }
                    N(layoutManagerHelper);
                } else {
                    if (this.p == null) {
                        View generateLayoutView = layoutManagerHelper.generateLayoutView();
                        this.p = generateLayoutView;
                        layoutManagerHelper.addBackgroundView(generateLayoutView, true);
                    }
                    if (layoutManagerHelper.getOrientation() == 1) {
                        this.o.left = layoutManagerHelper.getPaddingLeft() + n() + h();
                        this.o.right = ((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight()) - o()) - i();
                    } else {
                        this.o.top = layoutManagerHelper.getPaddingTop() + p() + j();
                        this.o.bottom = ((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingBottom()) - m()) - g();
                    }
                    d(this.p);
                    N(layoutManagerHelper);
                    return;
                }
            }
        }
        N(layoutManagerHelper);
        if (S()) {
            W(layoutManagerHelper, this);
        }
    }

    public void b0(BaseLayoutHelper.a aVar) {
        this.s = aVar;
        this.r = aVar;
    }

    public void c(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutManagerHelper layoutManagerHelper) {
        View view;
        if (!O()) {
            for (Map.Entry<sw1<Integer>, T> entry : this.f.entrySet()) {
                entry.getValue().c(recycler, state, layoutManagerHelper);
            }
        }
        if (!Y() && (view = this.p) != null) {
            BaseLayoutHelper.LayoutViewUnBindListener layoutViewUnBindListener = this.r;
            if (layoutViewUnBindListener != null) {
                layoutViewUnBindListener.onUnbind(view, y());
            }
            layoutManagerHelper.removeChildView(this.p);
            this.p = null;
        }
    }

    public void c0(BaseLayoutHelper.LayoutViewUnBindListener layoutViewUnBindListener) {
        this.r = layoutViewUnBindListener;
    }

    public void d(@NonNull View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.o), 1073741824), View.MeasureSpec.makeMeasureSpec(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.o), 1073741824));
        Rect rect = this.o;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
        view.setBackgroundColor(this.q);
        BaseLayoutHelper.LayoutViewBindListener layoutViewBindListener = this.s;
        if (layoutViewBindListener != null) {
            layoutViewBindListener.onBind(view, y());
        }
        this.o.set(0, 0, 0, 0);
    }

    public void d0(int i2, int i3, int i4, int i5) {
        this.k = i2;
        this.m = i3;
        this.l = i4;
        this.n = i5;
    }

    public void e0(int i2, int i3, int i4, int i5) {
        this.g = i2;
        this.h = i4;
        this.i = i3;
        this.j = i5;
    }

    /* access modifiers changed from: protected */
    public void f(int i2, int i3, int i4, int i5, boolean z) {
        if (z) {
            this.o.union((i2 - this.g) - this.k, (i3 - this.i) - this.m, this.h + i4 + this.l, this.j + i5 + this.n);
        } else {
            this.o.union(i2 - this.g, i3 - this.i, this.h + i4, this.j + i5);
        }
        T t = this.b;
        if (t != null) {
            int i6 = this.k;
            t.f((i2 - this.g) - i6, (i3 - this.i) - i6, this.h + i4 + this.l, this.j + i5 + this.n, z);
        }
    }

    public void f0(int i2, int i3) {
        this.e = sw1.c(Integer.valueOf(i2), Integer.valueOf(i3));
        if (!this.f.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<sw1<Integer>, T> entry : this.f.entrySet()) {
                T value = entry.getValue();
                int E = value.E() + i2;
                int D = value.D() + i2;
                hashMap.put(sw1.c(Integer.valueOf(E), Integer.valueOf(D)), value);
                value.f0(E, D);
            }
            this.f.clear();
            this.f.putAll(hashMap);
        }
    }

    public int g() {
        T t = this.b;
        if (t != null) {
            return t.g() + this.b.F();
        }
        return 0;
    }

    public int h() {
        T t = this.b;
        if (t != null) {
            return t.h() + this.b.G();
        }
        return 0;
    }

    public int i() {
        T t = this.b;
        if (t != null) {
            return t.i() + this.b.H();
        }
        return 0;
    }

    public int j() {
        T t = this.b;
        if (t != null) {
            return t.j() + this.b.I();
        }
        return 0;
    }

    public int k() {
        T t = this.b;
        return (t != null ? t.k() : 0) + w();
    }

    public int l() {
        T t = this.b;
        return (t != null ? t.l() : 0) + x();
    }

    public int m() {
        T t = this.b;
        return (t != null ? t.m() : 0) + this.n;
    }

    public int n() {
        T t = this.b;
        return (t != null ? t.n() : 0) + this.k;
    }

    public int o() {
        T t = this.b;
        return (t != null ? t.o() : 0) + this.l;
    }

    public int p() {
        T t = this.b;
        return (t != null ? t.p() : 0) + this.m;
    }

    public int q() {
        T t = this.b;
        return (t != null ? t.q() : 0) + this.j;
    }

    public int r() {
        T t = this.b;
        return (t != null ? t.r() : 0) + this.g;
    }

    public int s() {
        T t = this.b;
        return (t != null ? t.s() : 0) + this.h;
    }

    public int t() {
        T t = this.b;
        return (t != null ? t.t() : 0) + this.i;
    }

    public int u() {
        T t = this.b;
        return (t != null ? t.u() : 0) + K();
    }

    public int v() {
        T t = this.b;
        return (t != null ? t.v() : 0) + L();
    }

    /* access modifiers changed from: protected */
    public int w() {
        return this.k + this.l;
    }

    /* access modifiers changed from: protected */
    public int x() {
        return this.g + this.h;
    }

    public BaseLayoutHelper y() {
        BaseLayoutHelper baseLayoutHelper = this.a;
        if (baseLayoutHelper != null) {
            return baseLayoutHelper;
        }
        T t = this.b;
        if (t != null) {
            return t.y();
        }
        return null;
    }

    public int z() {
        return this.n;
    }
}
