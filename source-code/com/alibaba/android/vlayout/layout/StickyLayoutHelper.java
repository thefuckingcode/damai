package com.alibaba.android.vlayout.layout;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.a;
import com.alibaba.android.vlayout.c;
import tb.s61;
import tb.zi0;

/* compiled from: Taobao */
public class StickyLayoutHelper extends FixAreaLayoutHelper {
    private int b;
    private boolean c;
    private int d;
    private View e;
    private boolean f;
    private boolean g;
    private StickyListener h;
    private Stackable i;

    /* compiled from: Taobao */
    public interface Stackable {
        boolean enable();
    }

    /* compiled from: Taobao */
    public interface StickyListener {
        void onSticky(int i, View view);

        void onUnSticky(int i, View view);
    }

    public StickyLayoutHelper() {
        this(true);
    }

    private void b(View view, LayoutManagerHelper layoutManagerHelper) {
        int i2;
        int i3;
        VirtualLayoutManager.LayoutParams layoutParams = (VirtualLayoutManager.LayoutParams) view.getLayoutParams();
        boolean z = layoutManagerHelper.getOrientation() == 1;
        int contentWidth = ((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingLeft()) - layoutManagerHelper.getPaddingRight()) - getHorizontalMargin();
        int contentHeight = ((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingTop()) - layoutManagerHelper.getPaddingBottom()) - getVerticalMargin();
        float f2 = layoutParams.a;
        if (z) {
            int childMeasureSpec = layoutManagerHelper.getChildMeasureSpec(contentWidth, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            if (Float.isNaN(f2) || f2 <= 0.0f) {
                if (!Float.isNaN(this.mAspectRatio)) {
                    float f3 = this.mAspectRatio;
                    if (f3 > 0.0f) {
                        i3 = View.MeasureSpec.makeMeasureSpec((int) (((double) (((float) contentWidth) / f3)) + 0.5d), 1073741824);
                    }
                }
                i3 = layoutManagerHelper.getChildMeasureSpec(contentHeight, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
            } else {
                i3 = View.MeasureSpec.makeMeasureSpec((int) ((((float) contentWidth) / f2) + 0.5f), 1073741824);
            }
            layoutManagerHelper.measureChildWithMargins(view, childMeasureSpec, i3);
            return;
        }
        int childMeasureSpec2 = layoutManagerHelper.getChildMeasureSpec(contentHeight, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
        if (Float.isNaN(f2) || f2 <= 0.0f) {
            if (!Float.isNaN(this.mAspectRatio)) {
                float f4 = this.mAspectRatio;
                if (f4 > 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (((double) (((float) contentHeight) * f4)) + 0.5d), 1073741824);
                }
            }
            i2 = layoutManagerHelper.getChildMeasureSpec(contentWidth, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
        } else {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (((double) (((float) contentHeight) * f2)) + 0.5d), 1073741824);
        }
        layoutManagerHelper.measureChildWithMargins(view, i2, childMeasureSpec2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    private void c(c cVar, RecyclerView.Recycler recycler, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        int paddingTop;
        int paddingBottom;
        if (VirtualLayoutManager.sDebuggable) {
            Log.i("StickyStartLayoutHelper", "abnormal pos: " + this.b + " start: " + i2 + " end: " + i3);
        }
        if (this.e == null) {
            return;
        }
        if (this.c) {
            for (int childCount = layoutManagerHelper.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = layoutManagerHelper.getChildAt(childCount);
                int position = layoutManagerHelper.getPosition(childAt);
                if (position < this.b) {
                    int d2 = cVar.d(childAt);
                    a findLayoutHelperByPosition = layoutManagerHelper.findLayoutHelperByPosition(position);
                    if (findLayoutHelperByPosition instanceof f) {
                        paddingBottom = ((f) findLayoutHelperByPosition).b(layoutManagerHelper);
                    } else {
                        if (findLayoutHelperByPosition instanceof d) {
                            d dVar = (d) findLayoutHelperByPosition;
                            d2 += dVar.getMarginBottom();
                            paddingBottom = dVar.getPaddingBottom();
                        }
                        if (d2 < this.d + this.a.b) {
                            this.f = true;
                            return;
                        }
                        return;
                    }
                    d2 += paddingBottom;
                    if (d2 < this.d + this.a.b) {
                    }
                }
            }
            return;
        }
        for (int i4 = 0; i4 < layoutManagerHelper.getChildCount(); i4++) {
            View childAt2 = layoutManagerHelper.getChildAt(i4);
            int position2 = layoutManagerHelper.getPosition(childAt2);
            if (position2 > this.b) {
                int g2 = cVar.g(childAt2);
                a findLayoutHelperByPosition2 = layoutManagerHelper.findLayoutHelperByPosition(position2);
                if (findLayoutHelperByPosition2 instanceof f) {
                    paddingTop = ((f) findLayoutHelperByPosition2).c(layoutManagerHelper);
                } else {
                    if (findLayoutHelperByPosition2 instanceof d) {
                        d dVar2 = (d) findLayoutHelperByPosition2;
                        g2 -= dVar2.getMarginTop();
                        paddingTop = dVar2.getPaddingTop();
                    }
                    if (g2 < this.d + this.a.d) {
                        this.f = true;
                        return;
                    }
                    return;
                }
                g2 -= paddingTop;
                if (g2 < this.d + this.a.d) {
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0121  */
    private void d(c cVar, RecyclerView.Recycler recycler, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        View view;
        int i12;
        int i13;
        int paddingTop;
        int paddingBottom;
        boolean z = this.c;
        if ((!z || i3 < this.b) && (z || i2 > this.b)) {
            layoutManagerHelper.removeChildView(this.e);
            layoutManagerHelper.recycleView(this.e);
            this.e = null;
            return;
        }
        int e2 = cVar.e(this.e);
        int i14 = 0;
        boolean z2 = layoutManagerHelper.getOrientation() == 1;
        int f2 = z2 ? this.a.b + f(layoutManagerHelper) : this.a.a;
        zi0 zi0 = this.a;
        int i15 = z2 ? zi0.d : zi0.c;
        int i16 = -1;
        if (z2) {
            if (layoutManagerHelper.isDoLayoutRTL()) {
                i10 = layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight();
                i9 = i10 - cVar.f(this.e);
            } else {
                i9 = layoutManagerHelper.getPaddingLeft();
                i10 = cVar.f(this.e) + i9;
            }
            if (this.c) {
                i12 = layoutManagerHelper.getChildCount() - 1;
                view = null;
                while (i12 >= 0) {
                    view = layoutManagerHelper.getChildAt(i12);
                    int position = layoutManagerHelper.getPosition(view);
                    if (position < this.b) {
                        i13 = cVar.d(view);
                        a findLayoutHelperByPosition = layoutManagerHelper.findLayoutHelperByPosition(position);
                        if (findLayoutHelperByPosition instanceof f) {
                            paddingBottom = ((f) findLayoutHelperByPosition).b(layoutManagerHelper);
                        } else {
                            if (findLayoutHelperByPosition instanceof d) {
                                d dVar = (d) findLayoutHelperByPosition;
                                i13 += dVar.getMarginBottom();
                                paddingBottom = dVar.getPaddingBottom();
                            }
                            i11 = i13 + e2;
                            this.f = true;
                        }
                        i13 += paddingBottom;
                        i11 = i13 + e2;
                        this.f = true;
                    } else {
                        i12--;
                    }
                }
                i6 = 0;
                i11 = 0;
                if (view == null || i16 < 0) {
                    this.f = false;
                }
                if (!layoutManagerHelper.getReverseLayout() || !this.c) {
                    if (i11 > (cVar.i() - this.d) - i15) {
                        this.f = false;
                    }
                } else if (i6 < cVar.k() + this.d + f2) {
                    this.f = false;
                }
                if (!this.f) {
                    if (layoutManagerHelper.getReverseLayout() || !this.c) {
                        i11 = (cVar.i() - this.d) - i15;
                        i6 = i11 - e2;
                    } else {
                        i6 = cVar.k() + this.d + f2;
                        i11 = i6 + e2;
                    }
                }
                i5 = i10;
                i7 = i9;
                i4 = i11;
            } else {
                view = null;
                for (int i17 = 0; i17 < layoutManagerHelper.getChildCount(); i17++) {
                    view = layoutManagerHelper.getChildAt(i17);
                    int position2 = layoutManagerHelper.getPosition(view);
                    if (position2 > this.b) {
                        int g2 = cVar.g(view);
                        a findLayoutHelperByPosition2 = layoutManagerHelper.findLayoutHelperByPosition(position2);
                        if (findLayoutHelperByPosition2 instanceof f) {
                            paddingTop = ((f) findLayoutHelperByPosition2).c(layoutManagerHelper);
                        } else {
                            if (findLayoutHelperByPosition2 instanceof d) {
                                d dVar2 = (d) findLayoutHelperByPosition2;
                                g2 -= dVar2.getMarginTop();
                                paddingTop = dVar2.getPaddingTop();
                            }
                            i11 = g2;
                            i13 = i11 - e2;
                            i12 = i17 + 1;
                            this.f = true;
                        }
                        g2 -= paddingTop;
                        i11 = g2;
                        i13 = i11 - e2;
                        i12 = i17 + 1;
                        this.f = true;
                    }
                }
                i6 = 0;
                i11 = 0;
                this.f = false;
                if (!layoutManagerHelper.getReverseLayout()) {
                }
                if (i11 > (cVar.i() - this.d) - i15) {
                }
                if (!this.f) {
                }
                i5 = i10;
                i7 = i9;
                i4 = i11;
            }
            i6 = i13;
            i16 = i12;
            this.f = false;
            if (!layoutManagerHelper.getReverseLayout()) {
            }
            if (i11 > (cVar.i() - this.d) - i15) {
            }
            if (!this.f) {
            }
            i5 = i10;
            i7 = i9;
            i4 = i11;
        } else {
            int paddingTop2 = layoutManagerHelper.getPaddingTop();
            int f3 = cVar.f(this.e) + paddingTop2;
            if (this.f) {
                if (!this.c) {
                    int i18 = 0;
                    while (true) {
                        if (i18 >= layoutManagerHelper.getChildCount()) {
                            break;
                        }
                        View childAt = layoutManagerHelper.getChildAt(i18);
                        if (layoutManagerHelper.getPosition(childAt) > this.b) {
                            int g3 = cVar.g(childAt);
                            i14 = g3 - e2;
                            i8 = g3;
                            break;
                        }
                        i18++;
                    }
                } else {
                    int childCount = layoutManagerHelper.getChildCount() - 1;
                    while (true) {
                        if (childCount < 0) {
                            break;
                        }
                        View childAt2 = layoutManagerHelper.getChildAt(childCount);
                        if (layoutManagerHelper.getPosition(childAt2) < this.b) {
                            i14 = cVar.d(childAt2);
                            i8 = i14 + e2;
                            break;
                        }
                        childCount--;
                    }
                    i6 = paddingTop2;
                    i7 = i14;
                    i4 = f3;
                    i5 = i8;
                }
                i8 = 0;
                i6 = paddingTop2;
                i7 = i14;
                i4 = f3;
                i5 = i8;
            } else if (layoutManagerHelper.getReverseLayout() || !this.c) {
                int i19 = (cVar.i() - this.d) - i15;
                i5 = i19;
                i6 = paddingTop2;
                i4 = f3;
                i7 = i19 - e2;
            } else {
                int k = cVar.k() + this.d + f2;
                i5 = e2 + k;
                i6 = paddingTop2;
                i4 = f3;
                i7 = k;
            }
        }
        layoutChildWithMargin(this.e, i7, i6, i5, i4, layoutManagerHelper);
        if (!this.f) {
            layoutManagerHelper.showView(this.e);
            layoutManagerHelper.addFixedView(this.e);
        } else if (i16 >= 0) {
            if (this.e.getParent() == null) {
                layoutManagerHelper.addChildView(this.e, i16);
            }
            this.e = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092  */
    private void e(c cVar, RecyclerView.Recycler recycler, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        boolean z;
        View view;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z3;
        int i13;
        View view2;
        int i14;
        int paddingTop;
        int paddingBottom;
        View view3 = this.e;
        if (view3 == null) {
            view3 = layoutManagerHelper.findViewByPosition(this.b);
        }
        boolean z4 = layoutManagerHelper.getOrientation() == 1;
        int f2 = z4 ? this.a.b + f(layoutManagerHelper) : this.a.a;
        zi0 zi0 = this.a;
        int i15 = z4 ? zi0.d : zi0.c;
        boolean z5 = this.c;
        if ((z5 && i3 >= this.b) || (!z5 && i2 <= this.b)) {
            if (view3 == null) {
                z = this.d + (z5 ? f2 : i15) >= 0;
                View viewForPosition = recycler.getViewForPosition(this.b);
                this.e = viewForPosition;
                b(viewForPosition, layoutManagerHelper);
            } else {
                if (z5 && cVar.g(view3) >= cVar.k() + this.d + f2) {
                    this.e = view3;
                } else if (this.c || cVar.d(view3) > (cVar.i() - this.d) - i15) {
                    this.e = view3;
                } else {
                    this.e = view3;
                }
                z = true;
            }
            view = this.e;
            if (view != null) {
                if (!((RecyclerView.LayoutParams) view.getLayoutParams()).isItemRemoved()) {
                    int e2 = cVar.e(this.e);
                    int i16 = -1;
                    if (z4) {
                        if (layoutManagerHelper.isDoLayoutRTL()) {
                            i11 = layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight();
                            i10 = i11 - cVar.f(this.e);
                        } else {
                            i10 = layoutManagerHelper.getPaddingLeft();
                            i11 = cVar.f(this.e) + i10;
                        }
                        if (z) {
                            if (!this.c) {
                                view2 = null;
                                int i17 = 0;
                                while (true) {
                                    if (i17 >= layoutManagerHelper.getChildCount()) {
                                        break;
                                    }
                                    view2 = layoutManagerHelper.getChildAt(i17);
                                    int position = layoutManagerHelper.getPosition(view2);
                                    if (position > this.b) {
                                        int g2 = cVar.g(view2);
                                        a findLayoutHelperByPosition = layoutManagerHelper.findLayoutHelperByPosition(position);
                                        if (findLayoutHelperByPosition instanceof f) {
                                            paddingTop = ((f) findLayoutHelperByPosition).c(layoutManagerHelper);
                                        } else {
                                            if (findLayoutHelperByPosition instanceof d) {
                                                d dVar = (d) findLayoutHelperByPosition;
                                                g2 -= dVar.getMarginTop();
                                                paddingTop = dVar.getPaddingTop();
                                            }
                                            i14 = g2 - e2;
                                            i16 = i17;
                                            i13 = g2;
                                        }
                                        g2 -= paddingTop;
                                        i14 = g2 - e2;
                                        i16 = i17;
                                        i13 = g2;
                                    } else {
                                        i17++;
                                    }
                                }
                            } else {
                                int childCount = layoutManagerHelper.getChildCount() - 1;
                                view2 = null;
                                while (true) {
                                    if (childCount < 0) {
                                        break;
                                    }
                                    view2 = layoutManagerHelper.getChildAt(childCount);
                                    int position2 = layoutManagerHelper.getPosition(view2);
                                    if (position2 < this.b) {
                                        i14 = cVar.d(view2);
                                        a findLayoutHelperByPosition2 = layoutManagerHelper.findLayoutHelperByPosition(position2);
                                        if (findLayoutHelperByPosition2 instanceof f) {
                                            paddingBottom = ((f) findLayoutHelperByPosition2).b(layoutManagerHelper);
                                        } else {
                                            if (findLayoutHelperByPosition2 instanceof d) {
                                                d dVar2 = (d) findLayoutHelperByPosition2;
                                                i14 += dVar2.getMarginBottom();
                                                paddingBottom = dVar2.getPaddingBottom();
                                            }
                                            i13 = i14 + e2;
                                            i16 = childCount + 1;
                                        }
                                        i14 += paddingBottom;
                                        i13 = i14 + e2;
                                        i16 = childCount + 1;
                                    } else {
                                        childCount--;
                                    }
                                }
                            }
                            i13 = 0;
                            i14 = 0;
                            if (view2 == null || i16 < 0) {
                                z = false;
                            }
                            if (layoutManagerHelper.getReverseLayout() || !this.c ? i13 <= (cVar.i() - this.d) - i15 : i14 >= cVar.k() + this.d + f2) {
                                i12 = i14;
                                z3 = z;
                            } else {
                                i12 = i14;
                                z3 = false;
                            }
                        } else {
                            z3 = z;
                            i13 = 0;
                            i12 = 0;
                        }
                        if (!z3) {
                            if (layoutManagerHelper.getReverseLayout() || !this.c) {
                                int i18 = (cVar.i() - this.d) - i15;
                                i4 = i18;
                                i6 = i18 - e2;
                            } else {
                                int k = cVar.k() + this.d + f2;
                                i6 = k;
                                i4 = e2 + k;
                            }
                            z2 = z3;
                        } else {
                            i4 = i13;
                            z2 = z3;
                            i6 = i12;
                        }
                        i5 = i11;
                        i7 = i10;
                    } else {
                        int paddingTop2 = layoutManagerHelper.getPaddingTop();
                        int f3 = cVar.f(this.e) + paddingTop2;
                        if (z) {
                            if (!this.c) {
                                int i19 = 0;
                                while (true) {
                                    if (i19 >= layoutManagerHelper.getChildCount()) {
                                        break;
                                    }
                                    View childAt = layoutManagerHelper.getChildAt(i19);
                                    if (layoutManagerHelper.getPosition(childAt) > this.b) {
                                        int g3 = cVar.g(childAt);
                                        i8 = g3;
                                        i9 = g3 - e2;
                                        break;
                                    }
                                    i19++;
                                }
                            } else {
                                int childCount2 = layoutManagerHelper.getChildCount() - 1;
                                while (true) {
                                    if (childCount2 < 0) {
                                        break;
                                    }
                                    View childAt2 = layoutManagerHelper.getChildAt(childCount2);
                                    if (layoutManagerHelper.getPosition(childAt2) < this.b) {
                                        i9 = cVar.d(childAt2);
                                        i8 = i9 + e2;
                                        break;
                                    }
                                    childCount2--;
                                }
                            }
                            i9 = 0;
                            i8 = 0;
                            z2 = z;
                            i6 = paddingTop2;
                            i4 = f3;
                            i5 = i8;
                            i7 = i9;
                        } else if (layoutManagerHelper.getReverseLayout() || !this.c) {
                            int i20 = (cVar.i() - this.d) - i15;
                            int i21 = i20 - e2;
                            z2 = z;
                            i4 = f3;
                            i5 = i20;
                            i6 = paddingTop2;
                            i7 = i21;
                        } else {
                            int k2 = cVar.k() + this.d + f2;
                            i6 = paddingTop2;
                            i4 = f3;
                            i5 = e2 + k2;
                            i7 = k2;
                            z2 = z;
                        }
                    }
                    layoutChildWithMargin(this.e, i7, i6, i5, i4, layoutManagerHelper);
                    if (!z2) {
                        layoutManagerHelper.addFixedView(this.e);
                    } else if (i16 >= 0) {
                        if (this.e.getParent() == null) {
                            layoutManagerHelper.addChildView(this.e, i16);
                        }
                        this.e = null;
                    }
                    z = z2;
                } else {
                    return;
                }
            }
            this.f = z;
        }
        z = false;
        view = this.e;
        if (view != null) {
        }
        this.f = z;
    }

    private int f(LayoutManagerHelper layoutManagerHelper) {
        View fixedView;
        Stackable stackable = this.i;
        int i2 = 0;
        if (stackable != null && stackable.enable() && (layoutManagerHelper instanceof VirtualLayoutManager)) {
            for (a aVar : ((VirtualLayoutManager) layoutManagerHelper).getLayoutHelpers()) {
                if (aVar.isFixLayout() && aVar.getRange().e().intValue() < getRange().d().intValue() && (fixedView = aVar.getFixedView()) != null) {
                    i2 += fixedView.getHeight();
                }
            }
        }
        return i2;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void afterLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, int i3, int i4, LayoutManagerHelper layoutManagerHelper) {
        int i5;
        super.afterLayout(recycler, state, i2, i3, i4, layoutManagerHelper);
        if (this.b >= 0) {
            c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            if (!this.f && (i5 = this.b) >= i2 && i5 <= i3) {
                c(mainOrientationHelper, recycler, i2, i3, layoutManagerHelper);
            }
            if (this.f || state.isPreLayout()) {
                state.isPreLayout();
                View view = this.e;
                if (view != null) {
                    layoutManagerHelper.removeChildView(view);
                } else {
                    return;
                }
            }
            View view2 = this.e;
            if (this.f || view2 == null) {
                e(mainOrientationHelper, recycler, i2, i3, layoutManagerHelper);
            } else if (view2.getParent() == null) {
                layoutManagerHelper.addFixedView(this.e);
            } else {
                d(mainOrientationHelper, recycler, i2, i3, layoutManagerHelper);
            }
            if (this.h == null) {
                return;
            }
            if (this.g && !g()) {
                this.h.onUnSticky(this.b, view2);
                this.g = false;
            } else if (!this.g && g()) {
                this.h.onSticky(this.b, this.e);
                this.g = true;
            }
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void beforeLayout(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutManagerHelper layoutManagerHelper) {
        super.beforeLayout(recycler, state, layoutManagerHelper);
        View view = this.e;
        if (view != null && layoutManagerHelper.isViewHolderUpdated(view)) {
            layoutManagerHelper.removeChildView(this.e);
            recycler.recycleView(this.e);
            this.e = null;
        }
        this.f = false;
    }

    public boolean g() {
        return !this.f && this.e != null;
    }

    @Override // com.alibaba.android.vlayout.a
    @Nullable
    public View getFixedView() {
        return this.e;
    }

    public void h(int i2) {
        this.d = i2;
    }

    public void i(StickyListener stickyListener) {
        this.h = stickyListener;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (!isOutOfRange(dVar.c())) {
            View view = this.e;
            if (view == null) {
                view = dVar.l(recycler);
            } else {
                dVar.n();
            }
            if (view == null) {
                s61.b = true;
                return;
            }
            b(view, layoutManagerHelper);
            boolean z = layoutManagerHelper.getOrientation() == 1;
            c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            s61.a = mainOrientationHelper.e(view);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            this.f = true;
            int b2 = (dVar.b() - s61.a) + dVar.d();
            if (layoutManagerHelper.getOrientation() == 1) {
                if (layoutManagerHelper.isDoLayoutRTL()) {
                    i8 = (layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight()) - this.mMarginRight;
                    i7 = i8 - mainOrientationHelper.f(view);
                } else {
                    i7 = this.mMarginLeft + layoutManagerHelper.getPaddingLeft();
                    i8 = mainOrientationHelper.f(view) + i7;
                }
                if (dVar.f() == -1) {
                    i10 = dVar.g() - this.mMarginBottom;
                    i9 = dVar.g() - s61.a;
                } else if (this.c) {
                    i9 = this.mMarginTop + dVar.g();
                    i10 = dVar.g() + s61.a;
                } else {
                    i10 = ((mainOrientationHelper.i() - this.mMarginBottom) - this.d) - this.a.d;
                    i9 = i10 - s61.a;
                }
                if (layoutManagerHelper.getReverseLayout() || !this.c) {
                    if ((b2 < this.d + this.a.d && dVar.e() == 1) || i10 > this.mMarginBottom + this.d + this.a.d) {
                        this.f = false;
                        this.e = view;
                        int i11 = ((mainOrientationHelper.i() - this.mMarginBottom) - this.d) - this.a.d;
                        i3 = i8;
                        i5 = i7;
                        i2 = i11;
                        i4 = i11 - s61.a;
                    }
                } else if ((b2 < this.d + this.a.b && dVar.e() == -1) || i9 < this.mMarginTop + this.d + this.a.b) {
                    this.f = false;
                    this.e = view;
                    int k = mainOrientationHelper.k() + this.mMarginTop + this.d + this.a.b;
                    i3 = i8;
                    i5 = i7;
                    i4 = k;
                    i2 = s61.a + k;
                } else if (VirtualLayoutManager.sDebuggable) {
                    Log.i("Sticky", "remainingSpace: " + b2 + "    offset: " + this.d);
                }
                i3 = i8;
                i5 = i7;
                i2 = i10;
                i4 = i9;
            } else {
                i4 = layoutManagerHelper.getPaddingTop();
                i2 = mainOrientationHelper.f(view) + i4 + this.mMarginTop;
                if (dVar.f() == -1) {
                    i3 = dVar.g() - this.mMarginRight;
                    i6 = dVar.g() - s61.a;
                } else {
                    i6 = this.mMarginLeft + dVar.g();
                    i3 = dVar.g() + s61.a;
                }
                if (layoutManagerHelper.getReverseLayout() || !this.c) {
                    if (b2 < this.d + this.a.c) {
                        this.f = false;
                        this.e = view;
                        int i12 = (mainOrientationHelper.i() - this.d) - this.a.c;
                        i3 = i12;
                        i5 = i12 - s61.a;
                    }
                } else if (b2 < this.d + this.a.a) {
                    this.f = false;
                    this.e = view;
                    i5 = mainOrientationHelper.k() + this.d + this.a.a;
                    i3 = s61.a;
                }
                i5 = i6;
            }
            layoutChildWithMargin(view, i5, i4, i3, i2, layoutManagerHelper);
            s61.a += z ? getVerticalMargin() : getHorizontalMargin();
            if (state.isPreLayout()) {
                this.f = true;
            }
            if (this.f) {
                layoutManagerHelper.addChildView(dVar, view);
                handleStateOnResult(s61, view);
            }
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
        super.onClear(layoutManagerHelper);
        View view = this.e;
        if (view != null) {
            layoutManagerHelper.recycleView(view);
            layoutManagerHelper.removeChildView(this.e);
            this.e = null;
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRangeChange(int i2, int i3) {
        this.b = i2;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public boolean requireLayoutView() {
        return false;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void setItemCount(int i2) {
        if (i2 > 0) {
            super.setItemCount(1);
        } else {
            super.setItemCount(0);
        }
    }

    public StickyLayoutHelper(boolean z) {
        this.b = -1;
        this.c = true;
        this.d = 0;
        this.e = null;
        this.f = false;
        this.g = false;
        this.c = z;
        setItemCount(1);
    }
}
