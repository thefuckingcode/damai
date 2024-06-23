package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.google.android.flexbox.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider, FlexContainer {
    private static final Rect A = new Rect();
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private List<a> h;
    private final b i;
    private RecyclerView.Recycler j;
    private RecyclerView.State k;
    private c l;
    private b m;
    private OrientationHelper n;
    private OrientationHelper o;
    private SavedState p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private SparseArray<View> v;
    private final Context w;
    private View x;
    private int y;
    private b.C0153b z;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class b {
        private int a;
        private int b;
        private int c;
        private int d;
        private boolean e;
        private boolean f;
        private boolean g;

        private b() {
            this.d = 0;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void q() {
            int i;
            int i2;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.f) {
                if (this.e) {
                    i = FlexboxLayoutManager.this.n.getEndAfterPadding();
                } else {
                    i = FlexboxLayoutManager.this.n.getStartAfterPadding();
                }
                this.c = i;
                return;
            }
            if (this.e) {
                i2 = FlexboxLayoutManager.this.n.getEndAfterPadding();
            } else {
                i2 = FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.n.getStartAfterPadding();
            }
            this.c = i2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void r(View view) {
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.f) {
                if (this.e) {
                    this.c = FlexboxLayoutManager.this.n.getDecoratedEnd(view) + FlexboxLayoutManager.this.n.getTotalSpaceChange();
                } else {
                    this.c = FlexboxLayoutManager.this.n.getDecoratedStart(view);
                }
            } else if (this.e) {
                this.c = FlexboxLayoutManager.this.n.getDecoratedStart(view) + FlexboxLayoutManager.this.n.getTotalSpaceChange();
            } else {
                this.c = FlexboxLayoutManager.this.n.getDecoratedEnd(view);
            }
            this.a = FlexboxLayoutManager.this.getPosition(view);
            int i = 0;
            this.g = false;
            int[] iArr = FlexboxLayoutManager.this.i.c;
            int i2 = this.a;
            if (i2 == -1) {
                i2 = 0;
            }
            int i3 = iArr[i2];
            if (i3 != -1) {
                i = i3;
            }
            this.b = i;
            if (FlexboxLayoutManager.this.h.size() > this.b) {
                this.a = ((a) FlexboxLayoutManager.this.h.get(this.b)).o;
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void s() {
            this.a = -1;
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            boolean z = false;
            this.f = false;
            this.g = false;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                if (FlexboxLayoutManager.this.b == 0) {
                    if (FlexboxLayoutManager.this.a == 1) {
                        z = true;
                    }
                    this.e = z;
                    return;
                }
                if (FlexboxLayoutManager.this.b == 2) {
                    z = true;
                }
                this.e = z;
            } else if (FlexboxLayoutManager.this.b == 0) {
                if (FlexboxLayoutManager.this.a == 3) {
                    z = true;
                }
                this.e = z;
            } else {
                if (FlexboxLayoutManager.this.b == 2) {
                    z = true;
                }
                this.e = z;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.a + ", mFlexLinePosition=" + this.b + ", mCoordinate=" + this.c + ", mPerpendicularCoordinate=" + this.d + ", mLayoutFromEnd=" + this.e + ", mValid=" + this.f + ", mAssignedFromSavedState=" + this.g + '}';
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c {
        private int a;
        private boolean b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private boolean j;

        private c() {
            this.h = 1;
            this.i = 1;
        }

        static /* synthetic */ int i(c cVar) {
            int i2 = cVar.c;
            cVar.c = i2 + 1;
            return i2;
        }

        static /* synthetic */ int j(c cVar) {
            int i2 = cVar.c;
            cVar.c = i2 - 1;
            return i2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean w(RecyclerView.State state, List<a> list) {
            int i2;
            int i3 = this.d;
            return i3 >= 0 && i3 < state.getItemCount() && (i2 = this.c) >= 0 && i2 < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.a + ", mFlexLinePosition=" + this.c + ", mPosition=" + this.d + ", mOffset=" + this.e + ", mScrollingOffset=" + this.f + ", mLastScrollDelta=" + this.g + ", mItemDirection=" + this.h + ", mLayoutDirection=" + this.i + '}';
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    private int A(a aVar, c cVar) {
        if (isMainAxisDirectionHorizontal()) {
            return B(aVar, cVar);
        }
        return C(aVar, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ce  */
    private int B(a aVar, c cVar) {
        float f2;
        float f3;
        float f4;
        int b2;
        int i2;
        LayoutParams layoutParams;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int width = getWidth();
        int i3 = cVar.e;
        if (cVar.i == -1) {
            i3 -= aVar.g;
        }
        int i4 = cVar.d;
        int i5 = this.c;
        int i6 = 1;
        if (i5 != 0) {
            if (i5 == 1) {
                int i7 = aVar.e;
                f2 = 0.0f;
                f3 = (float) (i7 - paddingLeft);
                f4 = (float) ((width - i7) + paddingRight);
            } else if (i5 == 2) {
                int i8 = aVar.e;
                f4 = ((float) paddingLeft) + (((float) (width - i8)) / 2.0f);
                f3 = ((float) (width - paddingRight)) - (((float) (width - i8)) / 2.0f);
            } else if (i5 == 3) {
                f4 = (float) paddingLeft;
                int i9 = aVar.h;
                f2 = ((float) (width - aVar.e)) / (i9 != 1 ? (float) (i9 - 1) : 1.0f);
                f3 = (float) (width - paddingRight);
            } else if (i5 == 4) {
                int i10 = aVar.h;
                f2 = i10 != 0 ? ((float) (width - aVar.e)) / ((float) i10) : 0.0f;
                float f5 = f2 / 2.0f;
                f4 = ((float) paddingLeft) + f5;
                f3 = ((float) (width - paddingRight)) - f5;
            } else if (i5 == 5) {
                int i11 = aVar.h;
                f2 = i11 != 0 ? ((float) (width - aVar.e)) / ((float) (i11 + 1)) : 0.0f;
                f4 = ((float) paddingLeft) + f2;
                f3 = ((float) (width - paddingRight)) - f2;
            } else {
                throw new IllegalStateException("Invalid justifyContent is set: " + this.c);
            }
            float f6 = f4 - ((float) this.m.d);
            float f7 = f3 - ((float) this.m.d);
            float max = Math.max(f2, 0.0f);
            int i12 = 0;
            b2 = aVar.b();
            i2 = i4;
            while (i2 < i4 + b2) {
                View flexItemAt = getFlexItemAt(i2);
                if (flexItemAt != null) {
                    if (cVar.i == i6) {
                        calculateItemDecorationsForChild(flexItemAt, A);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, A);
                        addView(flexItemAt, i12);
                        i12++;
                    }
                    b bVar = this.i;
                    long j2 = bVar.d[i2];
                    int x2 = bVar.x(j2);
                    int w2 = this.i.w(j2);
                    LayoutParams layoutParams2 = (LayoutParams) flexItemAt.getLayoutParams();
                    if (shouldMeasureChild(flexItemAt, x2, w2, layoutParams2)) {
                        flexItemAt.measure(x2, w2);
                    }
                    float leftDecorationWidth = f6 + ((float) (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + getLeftDecorationWidth(flexItemAt)));
                    float rightDecorationWidth = f7 - ((float) (((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + getRightDecorationWidth(flexItemAt)));
                    int topDecorationHeight = i3 + getTopDecorationHeight(flexItemAt);
                    if (this.f) {
                        layoutParams = layoutParams2;
                        this.i.P(flexItemAt, aVar, Math.round(rightDecorationWidth) - flexItemAt.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + flexItemAt.getMeasuredHeight());
                    } else {
                        layoutParams = layoutParams2;
                        this.i.P(flexItemAt, aVar, Math.round(leftDecorationWidth), topDecorationHeight, Math.round(leftDecorationWidth) + flexItemAt.getMeasuredWidth(), topDecorationHeight + flexItemAt.getMeasuredHeight());
                    }
                    i12 = i12;
                    f6 = leftDecorationWidth + ((float) (flexItemAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(flexItemAt))) + max;
                    f7 = rightDecorationWidth - (((float) ((flexItemAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + getLeftDecorationWidth(flexItemAt))) + max);
                }
                i2++;
                i6 = 1;
            }
            cVar.c += this.l.i;
            return aVar.a();
        }
        f4 = (float) paddingLeft;
        f3 = (float) (width - paddingRight);
        f2 = 0.0f;
        float f62 = f4 - ((float) this.m.d);
        float f72 = f3 - ((float) this.m.d);
        float max2 = Math.max(f2, 0.0f);
        int i122 = 0;
        b2 = aVar.b();
        i2 = i4;
        while (i2 < i4 + b2) {
        }
        cVar.c += this.l.i;
        return aVar.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d4  */
    private int C(a aVar, c cVar) {
        float f2;
        float f3;
        float f4;
        int b2;
        int i2;
        int i3;
        float f5;
        View view;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i4 = cVar.e;
        int i5 = cVar.e;
        if (cVar.i == -1) {
            int i6 = aVar.g;
            i4 -= i6;
            i5 += i6;
        }
        int i7 = cVar.d;
        int i8 = this.c;
        if (i8 != 0) {
            if (i8 == 1) {
                int i9 = aVar.e;
                f2 = 0.0f;
                f3 = (float) (i9 - paddingTop);
                f4 = (float) ((height - i9) + paddingBottom);
            } else if (i8 == 2) {
                int i10 = aVar.e;
                f4 = ((float) paddingTop) + (((float) (height - i10)) / 2.0f);
                f3 = ((float) (height - paddingBottom)) - (((float) (height - i10)) / 2.0f);
            } else if (i8 == 3) {
                f4 = (float) paddingTop;
                int i11 = aVar.h;
                f2 = ((float) (height - aVar.e)) / (i11 != 1 ? (float) (i11 - 1) : 1.0f);
                f3 = (float) (height - paddingBottom);
            } else if (i8 == 4) {
                int i12 = aVar.h;
                f2 = i12 != 0 ? ((float) (height - aVar.e)) / ((float) i12) : 0.0f;
                float f6 = f2 / 2.0f;
                f4 = ((float) paddingTop) + f6;
                f3 = ((float) (height - paddingBottom)) - f6;
            } else if (i8 == 5) {
                int i13 = aVar.h;
                f2 = i13 != 0 ? ((float) (height - aVar.e)) / ((float) (i13 + 1)) : 0.0f;
                f4 = ((float) paddingTop) + f2;
                f3 = ((float) (height - paddingBottom)) - f2;
            } else {
                throw new IllegalStateException("Invalid justifyContent is set: " + this.c);
            }
            float f7 = f4 - ((float) this.m.d);
            float f8 = f3 - ((float) this.m.d);
            float max = Math.max(f2, 0.0f);
            int i14 = 0;
            b2 = aVar.b();
            i2 = i7;
            while (i2 < i7 + b2) {
                View flexItemAt = getFlexItemAt(i2);
                if (flexItemAt == null) {
                    i3 = i2;
                    f5 = max;
                } else {
                    b bVar = this.i;
                    f5 = max;
                    long j2 = bVar.d[i2];
                    int x2 = bVar.x(j2);
                    int w2 = this.i.w(j2);
                    LayoutParams layoutParams = (LayoutParams) flexItemAt.getLayoutParams();
                    if (shouldMeasureChild(flexItemAt, x2, w2, layoutParams)) {
                        flexItemAt.measure(x2, w2);
                    }
                    float topDecorationHeight = f7 + ((float) (((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getTopDecorationHeight(flexItemAt)));
                    float bottomDecorationHeight = f8 - ((float) (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getBottomDecorationHeight(flexItemAt)));
                    if (cVar.i == 1) {
                        calculateItemDecorationsForChild(flexItemAt, A);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, A);
                        addView(flexItemAt, i14);
                        i14++;
                    }
                    int leftDecorationWidth = i4 + getLeftDecorationWidth(flexItemAt);
                    int rightDecorationWidth = i5 - getRightDecorationWidth(flexItemAt);
                    boolean z2 = this.f;
                    if (!z2) {
                        view = flexItemAt;
                        i3 = i2;
                        if (this.g) {
                            this.i.Q(view, aVar, z2, leftDecorationWidth, Math.round(bottomDecorationHeight) - view.getMeasuredHeight(), leftDecorationWidth + view.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                        } else {
                            this.i.Q(view, aVar, z2, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + view.getMeasuredWidth(), Math.round(topDecorationHeight) + view.getMeasuredHeight());
                        }
                    } else if (this.g) {
                        view = flexItemAt;
                        i3 = i2;
                        this.i.Q(flexItemAt, aVar, z2, rightDecorationWidth - flexItemAt.getMeasuredWidth(), Math.round(bottomDecorationHeight) - flexItemAt.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                    } else {
                        view = flexItemAt;
                        i3 = i2;
                        this.i.Q(view, aVar, z2, rightDecorationWidth - view.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Math.round(topDecorationHeight) + view.getMeasuredHeight());
                    }
                    f7 = topDecorationHeight + ((float) (view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getBottomDecorationHeight(view))) + f5;
                    i14 = i14;
                    f8 = bottomDecorationHeight - (((float) ((view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + getTopDecorationHeight(view))) + f5);
                }
                i2 = i3 + 1;
                max = f5;
            }
            cVar.c += this.l.i;
            return aVar.a();
        }
        f4 = (float) paddingTop;
        f3 = (float) (height - paddingBottom);
        f2 = 0.0f;
        float f72 = f4 - ((float) this.m.d);
        float f82 = f3 - ((float) this.m.d);
        float max2 = Math.max(f2, 0.0f);
        int i142 = 0;
        b2 = aVar.b();
        i2 = i7;
        while (i2 < i7 + b2) {
        }
        cVar.c += this.l.i;
        return aVar.a();
    }

    private void D(RecyclerView.Recycler recycler, c cVar) {
        if (cVar.j) {
            if (cVar.i == -1) {
                E(recycler, cVar);
            } else {
                F(recycler, cVar);
            }
        }
    }

    private void E(RecyclerView.Recycler recycler, c cVar) {
        if (cVar.f >= 0) {
            this.n.getEnd();
            int unused = cVar.f;
            int childCount = getChildCount();
            if (childCount != 0) {
                int i2 = childCount - 1;
                int i3 = this.i.c[getPosition(getChildAt(i2))];
                if (i3 != -1) {
                    a aVar = this.h.get(i3);
                    int i4 = i2;
                    while (true) {
                        if (i4 < 0) {
                            break;
                        }
                        View childAt = getChildAt(i4);
                        if (!g(childAt, cVar.f)) {
                            break;
                        }
                        if (aVar.o == getPosition(childAt)) {
                            if (i3 <= 0) {
                                childCount = i4;
                                break;
                            }
                            i3 += cVar.i;
                            aVar = this.h.get(i3);
                            childCount = i4;
                        }
                        i4--;
                    }
                    recycleChildren(recycler, childCount, i2);
                }
            }
        }
    }

    private void F(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        if (cVar.f >= 0 && (childCount = getChildCount()) != 0) {
            int i2 = this.i.c[getPosition(getChildAt(0))];
            int i3 = -1;
            if (i2 != -1) {
                a aVar = this.h.get(i2);
                int i4 = 0;
                while (true) {
                    if (i4 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i4);
                    if (!h(childAt, cVar.f)) {
                        break;
                    }
                    if (aVar.p == getPosition(childAt)) {
                        if (i2 >= this.h.size() - 1) {
                            i3 = i4;
                            break;
                        }
                        i2 += cVar.i;
                        aVar = this.h.get(i2);
                        i3 = i4;
                    }
                    i4++;
                }
                recycleChildren(recycler, 0, i3);
            }
        }
    }

    private void G() {
        int i2;
        if (isMainAxisDirectionHorizontal()) {
            i2 = getHeightMode();
        } else {
            i2 = getWidthMode();
        }
        this.l.b = i2 == 0 || i2 == Integer.MIN_VALUE;
    }

    private void H() {
        int layoutDirection = getLayoutDirection();
        int i2 = this.a;
        boolean z2 = false;
        if (i2 == 0) {
            this.f = layoutDirection == 1;
            if (this.b == 2) {
                z2 = true;
            }
            this.g = z2;
        } else if (i2 == 1) {
            this.f = layoutDirection != 1;
            if (this.b == 2) {
                z2 = true;
            }
            this.g = z2;
        } else if (i2 == 2) {
            boolean z3 = layoutDirection == 1;
            this.f = z3;
            if (this.b == 2) {
                this.f = !z3;
            }
            this.g = false;
        } else if (i2 != 3) {
            this.f = false;
            this.g = false;
        } else {
            if (layoutDirection == 1) {
                z2 = true;
            }
            this.f = z2;
            if (this.b == 2) {
                this.f = !z2;
            }
            this.g = true;
        }
    }

    private boolean I(RecyclerView.State state, b bVar) {
        View view;
        int i2;
        boolean z2 = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (bVar.e) {
            view = n(state.getItemCount());
        } else {
            view = l(state.getItemCount());
        }
        if (view == null) {
            return false;
        }
        bVar.r(view);
        if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
            if (this.n.getDecoratedStart(view) >= this.n.getEndAfterPadding() || this.n.getDecoratedEnd(view) < this.n.getStartAfterPadding()) {
                z2 = true;
            }
            if (z2) {
                if (bVar.e) {
                    i2 = this.n.getEndAfterPadding();
                } else {
                    i2 = this.n.getStartAfterPadding();
                }
                bVar.c = i2;
            }
        }
        return true;
    }

    private boolean J(RecyclerView.State state, b bVar, SavedState savedState) {
        int i2;
        int i3;
        boolean z2 = false;
        if (!state.isPreLayout() && (i2 = this.q) != -1) {
            if (i2 < 0 || i2 >= state.getItemCount()) {
                this.q = -1;
                this.r = Integer.MIN_VALUE;
            } else {
                bVar.a = this.q;
                bVar.b = this.i.c[bVar.a];
                SavedState savedState2 = this.p;
                if (savedState2 != null && savedState2.hasValidAnchor(state.getItemCount())) {
                    bVar.c = this.n.getStartAfterPadding() + savedState.mAnchorOffset;
                    bVar.g = true;
                    bVar.b = -1;
                    return true;
                } else if (this.r == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.q);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if (this.q < getPosition(getChildAt(0))) {
                                z2 = true;
                            }
                            bVar.e = z2;
                        }
                        bVar.q();
                    } else if (this.n.getDecoratedMeasurement(findViewByPosition) > this.n.getTotalSpace()) {
                        bVar.q();
                        return true;
                    } else if (this.n.getDecoratedStart(findViewByPosition) - this.n.getStartAfterPadding() < 0) {
                        bVar.c = this.n.getStartAfterPadding();
                        bVar.e = false;
                        return true;
                    } else if (this.n.getEndAfterPadding() - this.n.getDecoratedEnd(findViewByPosition) < 0) {
                        bVar.c = this.n.getEndAfterPadding();
                        bVar.e = true;
                        return true;
                    } else {
                        if (bVar.e) {
                            i3 = this.n.getDecoratedEnd(findViewByPosition) + this.n.getTotalSpaceChange();
                        } else {
                            i3 = this.n.getDecoratedStart(findViewByPosition);
                        }
                        bVar.c = i3;
                    }
                    return true;
                } else {
                    if (isMainAxisDirectionHorizontal() || !this.f) {
                        bVar.c = this.n.getStartAfterPadding() + this.r;
                    } else {
                        bVar.c = this.r - this.n.getEndPadding();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void K(RecyclerView.State state, b bVar) {
        if (!J(state, bVar, this.p) && !I(state, bVar)) {
            bVar.q();
            bVar.a = 0;
            bVar.b = 0;
        }
    }

    private void L(int i2) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i2 < findLastVisibleItemPosition) {
            int childCount = getChildCount();
            this.i.t(childCount);
            this.i.u(childCount);
            this.i.s(childCount);
            if (i2 < this.i.c.length) {
                this.y = i2;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    if (findFirstVisibleItemPosition > i2 || i2 > findLastVisibleItemPosition) {
                        this.q = getPosition(childClosestToStart);
                        if (isMainAxisDirectionHorizontal() || !this.f) {
                            this.r = this.n.getDecoratedStart(childClosestToStart) - this.n.getStartAfterPadding();
                        } else {
                            this.r = this.n.getDecoratedEnd(childClosestToStart) + this.n.getEndPadding();
                        }
                    }
                }
            }
        }
    }

    private void M(int i2) {
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        boolean z2 = true;
        if (isMainAxisDirectionHorizontal()) {
            int i4 = this.s;
            if (i4 == Integer.MIN_VALUE || i4 == width) {
                z2 = false;
            }
            if (this.l.b) {
                i3 = DisplayMetrics.getheightPixels(this.w.getResources().getDisplayMetrics());
            } else {
                i3 = this.l.a;
            }
        } else {
            int i5 = this.t;
            if (i5 == Integer.MIN_VALUE || i5 == height) {
                z2 = false;
            }
            if (this.l.b) {
                i3 = DisplayMetrics.getwidthPixels(this.w.getResources().getDisplayMetrics());
            } else {
                i3 = this.l.a;
            }
        }
        this.s = width;
        this.t = height;
        int i6 = this.y;
        if (i6 != -1 || (this.q == -1 && !z2)) {
            int min = i6 != -1 ? Math.min(i6, this.m.a) : this.m.a;
            this.z.a();
            if (isMainAxisDirectionHorizontal()) {
                if (this.h.size() > 0) {
                    this.i.j(this.h, min);
                    this.i.b(this.z, makeMeasureSpec, makeMeasureSpec2, i3, min, this.m.a, this.h);
                } else {
                    this.i.s(i2);
                    this.i.d(this.z, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.h);
                }
            } else if (this.h.size() > 0) {
                this.i.j(this.h, min);
                this.i.b(this.z, makeMeasureSpec2, makeMeasureSpec, i3, min, this.m.a, this.h);
            } else {
                this.i.s(i2);
                this.i.g(this.z, makeMeasureSpec, makeMeasureSpec2, i3, 0, this.h);
            }
            this.h = this.z.a;
            this.i.q(makeMeasureSpec, makeMeasureSpec2, min);
            this.i.X(min);
        } else if (!this.m.e) {
            this.h.clear();
            this.z.a();
            if (isMainAxisDirectionHorizontal()) {
                this.i.e(this.z, makeMeasureSpec, makeMeasureSpec2, i3, this.m.a, this.h);
            } else {
                this.i.h(this.z, makeMeasureSpec, makeMeasureSpec2, i3, this.m.a, this.h);
            }
            this.h = this.z.a;
            this.i.p(makeMeasureSpec, makeMeasureSpec2);
            this.i.W();
            b bVar = this.m;
            bVar.b = this.i.c[bVar.a];
            this.l.c = this.m.b;
        }
    }

    private void N(int i2, int i3) {
        this.l.i = i2;
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int i4 = 0;
        boolean z2 = !isMainAxisDirectionHorizontal && this.f;
        if (i2 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.l.e = this.n.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View o2 = o(childAt, this.h.get(this.i.c[position]));
            this.l.h = 1;
            c cVar = this.l;
            cVar.d = position + cVar.h;
            if (this.i.c.length <= this.l.d) {
                this.l.c = -1;
            } else {
                c cVar2 = this.l;
                cVar2.c = this.i.c[cVar2.d];
            }
            if (z2) {
                this.l.e = this.n.getDecoratedStart(o2);
                this.l.f = (-this.n.getDecoratedStart(o2)) + this.n.getStartAfterPadding();
                c cVar3 = this.l;
                if (cVar3.f >= 0) {
                    i4 = this.l.f;
                }
                cVar3.f = i4;
            } else {
                this.l.e = this.n.getDecoratedEnd(o2);
                this.l.f = this.n.getDecoratedEnd(o2) - this.n.getEndAfterPadding();
            }
            if ((this.l.c == -1 || this.l.c > this.h.size() - 1) && this.l.d <= getFlexItemCount()) {
                int i5 = i3 - this.l.f;
                this.z.a();
                if (i5 > 0) {
                    if (isMainAxisDirectionHorizontal) {
                        this.i.d(this.z, makeMeasureSpec, makeMeasureSpec2, i5, this.l.d, this.h);
                    } else {
                        this.i.g(this.z, makeMeasureSpec, makeMeasureSpec2, i5, this.l.d, this.h);
                    }
                    this.i.q(makeMeasureSpec, makeMeasureSpec2, this.l.d);
                    this.i.X(this.l.d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.l.e = this.n.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View m2 = m(childAt2, this.h.get(this.i.c[position2]));
            this.l.h = 1;
            int i6 = this.i.c[position2];
            if (i6 == -1) {
                i6 = 0;
            }
            if (i6 > 0) {
                this.l.d = position2 - this.h.get(i6 - 1).b();
            } else {
                this.l.d = -1;
            }
            this.l.c = i6 > 0 ? i6 - 1 : 0;
            if (z2) {
                this.l.e = this.n.getDecoratedEnd(m2);
                this.l.f = this.n.getDecoratedEnd(m2) - this.n.getEndAfterPadding();
                c cVar4 = this.l;
                if (cVar4.f >= 0) {
                    i4 = this.l.f;
                }
                cVar4.f = i4;
            } else {
                this.l.e = this.n.getDecoratedStart(m2);
                this.l.f = (-this.n.getDecoratedStart(m2)) + this.n.getStartAfterPadding();
            }
        }
        c cVar5 = this.l;
        cVar5.a = i3 - cVar5.f;
    }

    private void O(b bVar, boolean z2, boolean z3) {
        if (z3) {
            G();
        } else {
            this.l.b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.f) {
            this.l.a = this.n.getEndAfterPadding() - bVar.c;
        } else {
            this.l.a = bVar.c - getPaddingRight();
        }
        this.l.d = bVar.a;
        this.l.h = 1;
        this.l.i = 1;
        this.l.e = bVar.c;
        this.l.f = Integer.MIN_VALUE;
        this.l.c = bVar.b;
        if (z2 && this.h.size() > 1 && bVar.b >= 0 && bVar.b < this.h.size() - 1) {
            c.i(this.l);
            this.l.d += this.h.get(bVar.b).b();
        }
    }

    private void P(b bVar, boolean z2, boolean z3) {
        if (z3) {
            G();
        } else {
            this.l.b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.f) {
            this.l.a = bVar.c - this.n.getStartAfterPadding();
        } else {
            this.l.a = (this.x.getWidth() - bVar.c) - this.n.getStartAfterPadding();
        }
        this.l.d = bVar.a;
        this.l.h = 1;
        this.l.i = -1;
        this.l.e = bVar.c;
        this.l.f = Integer.MIN_VALUE;
        this.l.c = bVar.b;
        if (z2 && bVar.b > 0 && this.h.size() > bVar.b) {
            c.j(this.l);
            this.l.d -= this.h.get(bVar.b).b();
        }
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        j();
        View l2 = l(itemCount);
        View n2 = n(itemCount);
        if (state.getItemCount() == 0 || l2 == null || n2 == null) {
            return 0;
        }
        return Math.min(this.n.getTotalSpace(), this.n.getDecoratedEnd(n2) - this.n.getDecoratedStart(l2));
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View l2 = l(itemCount);
        View n2 = n(itemCount);
        if (!(state.getItemCount() == 0 || l2 == null || n2 == null)) {
            int position = getPosition(l2);
            int position2 = getPosition(n2);
            int abs = Math.abs(this.n.getDecoratedEnd(n2) - this.n.getDecoratedStart(l2));
            int[] iArr = this.i.c;
            int i2 = iArr[position];
            if (!(i2 == 0 || i2 == -1)) {
                return Math.round((((float) i2) * (((float) abs) / ((float) ((iArr[position2] - i2) + 1)))) + ((float) (this.n.getStartAfterPadding() - this.n.getDecoratedStart(l2))));
            }
        }
        return 0;
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View l2 = l(itemCount);
        View n2 = n(itemCount);
        if (state.getItemCount() == 0 || l2 == null || n2 == null) {
            return 0;
        }
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((((float) Math.abs(this.n.getDecoratedEnd(n2) - this.n.getDecoratedStart(l2))) / ((float) ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1))) * ((float) state.getItemCount()));
    }

    private void ensureLayoutState() {
        if (this.l == null) {
            this.l = new c();
        }
    }

    private int fixLayoutEndGap(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int i3;
        int endAfterPadding;
        if (!isMainAxisDirectionHorizontal() && this.f) {
            int startAfterPadding = i2 - this.n.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            i3 = w(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.n.getEndAfterPadding() - i2;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            i3 = -w(-endAfterPadding2, recycler, state);
        }
        int i4 = i2 + i3;
        if (!z2 || (endAfterPadding = this.n.getEndAfterPadding() - i4) <= 0) {
            return i3;
        }
        this.n.offsetChildren(endAfterPadding);
        return endAfterPadding + i3;
    }

    private int fixLayoutStartGap(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int i3;
        int startAfterPadding;
        if (isMainAxisDirectionHorizontal() || !this.f) {
            int startAfterPadding2 = i2 - this.n.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            i3 = -w(startAfterPadding2, recycler, state);
        } else {
            int endAfterPadding = this.n.getEndAfterPadding() - i2;
            if (endAfterPadding <= 0) {
                return 0;
            }
            i3 = w(-endAfterPadding, recycler, state);
        }
        int i4 = i2 + i3;
        if (!z2 || (startAfterPadding = i4 - this.n.getStartAfterPadding()) <= 0) {
            return i3;
        }
        this.n.offsetChildren(-startAfterPadding);
        return i3 - startAfterPadding;
    }

    private boolean g(View view, int i2) {
        if (isMainAxisDirectionHorizontal() || !this.f) {
            if (this.n.getDecoratedStart(view) >= this.n.getEnd() - i2) {
                return true;
            }
            return false;
        } else if (this.n.getDecoratedEnd(view) <= i2) {
            return true;
        } else {
            return false;
        }
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    private boolean h(View view, int i2) {
        if (isMainAxisDirectionHorizontal() || !this.f) {
            if (this.n.getDecoratedEnd(view) <= i2) {
                return true;
            }
            return false;
        } else if (this.n.getEnd() - this.n.getDecoratedStart(view) <= i2) {
            return true;
        } else {
            return false;
        }
    }

    private void i() {
        this.h.clear();
        this.m.s();
        this.m.d = 0;
    }

    private static boolean isMeasurementUpToDate(int i2, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (i4 > 0 && i2 != i4) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i2;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i2;
        }
        return true;
    }

    private void j() {
        if (this.n == null) {
            if (isMainAxisDirectionHorizontal()) {
                if (this.b == 0) {
                    this.n = OrientationHelper.createHorizontalHelper(this);
                    this.o = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.n = OrientationHelper.createVerticalHelper(this);
                this.o = OrientationHelper.createHorizontalHelper(this);
            } else if (this.b == 0) {
                this.n = OrientationHelper.createVerticalHelper(this);
                this.o = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.n = OrientationHelper.createHorizontalHelper(this);
                this.o = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private int k(RecyclerView.Recycler recycler, RecyclerView.State state, c cVar) {
        if (cVar.f != Integer.MIN_VALUE) {
            if (cVar.a < 0) {
                cVar.f += cVar.a;
            }
            D(recycler, cVar);
        }
        int i2 = cVar.a;
        int i3 = cVar.a;
        int i4 = 0;
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        while (true) {
            if ((i3 > 0 || this.l.b) && cVar.w(state, this.h)) {
                a aVar = this.h.get(cVar.c);
                cVar.d = aVar.o;
                i4 += A(aVar, cVar);
                if (isMainAxisDirectionHorizontal || !this.f) {
                    cVar.e += aVar.a() * cVar.i;
                } else {
                    cVar.e -= aVar.a() * cVar.i;
                }
                i3 -= aVar.a();
            }
        }
        cVar.a -= i4;
        if (cVar.f != Integer.MIN_VALUE) {
            cVar.f += i4;
            if (cVar.a < 0) {
                cVar.f += cVar.a;
            }
            D(recycler, cVar);
        }
        return i2 - cVar.a;
    }

    private View l(int i2) {
        int i3;
        View q2 = q(0, getChildCount(), i2);
        if (q2 == null || (i3 = this.i.c[getPosition(q2)]) == -1) {
            return null;
        }
        return m(q2, this.h.get(i3));
    }

    private View m(View view, a aVar) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i2 = aVar.h;
        for (int i3 = 1; i3 < i2; i3++) {
            View childAt = getChildAt(i3);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.f || isMainAxisDirectionHorizontal) {
                    if (this.n.getDecoratedStart(view) <= this.n.getDecoratedStart(childAt)) {
                    }
                } else if (this.n.getDecoratedEnd(view) >= this.n.getDecoratedEnd(childAt)) {
                }
                view = childAt;
            }
        }
        return view;
    }

    private View n(int i2) {
        View q2 = q(getChildCount() - 1, -1, i2);
        if (q2 == null) {
            return null;
        }
        return o(q2, this.h.get(this.i.c[getPosition(q2)]));
    }

    private View o(View view, a aVar) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int childCount = (getChildCount() - aVar.h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.f || isMainAxisDirectionHorizontal) {
                    if (this.n.getDecoratedEnd(view) >= this.n.getDecoratedEnd(childAt)) {
                    }
                } else if (this.n.getDecoratedStart(view) <= this.n.getDecoratedStart(childAt)) {
                }
                view = childAt;
            }
        }
        return view;
    }

    private View p(int i2, int i3, boolean z2) {
        int i4 = i3 > i2 ? 1 : -1;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (z(childAt, z2)) {
                return childAt;
            }
            i2 += i4;
        }
        return null;
    }

    private View q(int i2, int i3, int i4) {
        j();
        ensureLayoutState();
        int startAfterPadding = this.n.getStartAfterPadding();
        int endAfterPadding = this.n.getEndAfterPadding();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < i4) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.n.getDecoratedStart(childAt) >= startAfterPadding && this.n.getDecoratedEnd(childAt) <= endAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    private int r(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i2, int i3) {
        while (i3 >= i2) {
            removeAndRecycleViewAt(i3, recycler);
            i3--;
        }
    }

    private int s(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    private boolean shouldMeasureChild(View view, int i2, int i3, RecyclerView.LayoutParams layoutParams) {
        return view.isLayoutRequested() || !isMeasurementCacheEnabled() || !isMeasurementUpToDate(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).width) || !isMeasurementUpToDate(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).height);
    }

    private int t(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    private int u(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    private int w(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        j();
        int i3 = 1;
        this.l.j = true;
        boolean z2 = !isMainAxisDirectionHorizontal() && this.f;
        if (!z2 ? i2 <= 0 : i2 >= 0) {
            i3 = -1;
        }
        int abs = Math.abs(i2);
        N(i3, abs);
        int k2 = this.l.f + k(recycler, state, this.l);
        if (k2 < 0) {
            return 0;
        }
        if (z2) {
            if (abs > k2) {
                i2 = (-i3) * k2;
            }
        } else if (abs > k2) {
            i2 = i3 * k2;
        }
        this.n.offsetChildren(-i2);
        this.l.g = i2;
        return i2;
    }

    private int x(int i2) {
        int i3;
        boolean z2 = false;
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        j();
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        View view = this.x;
        int width = isMainAxisDirectionHorizontal ? view.getWidth() : view.getHeight();
        int width2 = isMainAxisDirectionHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            z2 = true;
        }
        if (z2) {
            int abs = Math.abs(i2);
            if (i2 < 0) {
                i3 = Math.min((width2 + this.m.d) - width, abs);
            } else if (this.m.d + i2 <= 0) {
                return i2;
            } else {
                i3 = this.m.d;
            }
        } else if (i2 > 0) {
            return Math.min((width2 - this.m.d) - width, i2);
        } else {
            if (this.m.d + i2 >= 0) {
                return i2;
            }
            i3 = this.m.d;
        }
        return -i3;
    }

    private boolean z(View view, boolean z2) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int s2 = s(view);
        int u2 = u(view);
        int t2 = t(view);
        int r2 = r(view);
        return z2 ? (paddingLeft <= s2 && width >= t2) && (paddingTop <= u2 && height >= r2) : (s2 >= width || t2 >= paddingLeft) && (u2 >= height || r2 >= paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return !isMainAxisDirectionHorizontal() || getWidth() > this.x.getWidth();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return isMainAxisDirectionHorizontal() || getHeight() > this.x.getHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        computeScrollOffset(state);
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i2) {
        if (getChildCount() == 0) {
            return null;
        }
        int i3 = i2 < getPosition(getChildAt(0)) ? -1 : 1;
        if (isMainAxisDirectionHorizontal()) {
            return new PointF(0.0f, (float) i3);
        }
        return new PointF((float) i3, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public int findFirstVisibleItemPosition() {
        View p2 = p(0, getChildCount(), false);
        if (p2 == null) {
            return -1;
        }
        return getPosition(p2);
    }

    public int findLastVisibleItemPosition() {
        View p2 = p(getChildCount() - 1, -1, false);
        if (p2 == null) {
            return -1;
        }
        return getPosition(p2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.d;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildHeightMeasureSpec(int i2, int i3, int i4) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i3, i4, canScrollVertically());
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildWidthMeasureSpec(int i2, int i3, int i4) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i3, i4, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthCrossAxis(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (isMainAxisDirectionHorizontal()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthMainAxis(View view, int i2, int i3) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (isMainAxisDirectionHorizontal()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.a;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getFlexItemAt(int i2) {
        View view = this.v.get(i2);
        if (view != null) {
            return view;
        }
        return this.j.getViewForPosition(i2);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return this.k.getItemCount();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<a> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.h.size());
        int size = this.h.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.h.get(i2);
            if (aVar.b() != 0) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<a> getFlexLinesInternal() {
        return this.h;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexWrap() {
        return this.b;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getJustifyContent() {
        return this.c;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getLargestMainSize() {
        if (this.h.size() == 0) {
            return 0;
        }
        int i2 = Integer.MIN_VALUE;
        int size = this.h.size();
        for (int i3 = 0; i3 < size; i3++) {
            i2 = Math.max(i2, this.h.get(i3).e);
        }
        return i2;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.e;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getReorderedFlexItemAt(int i2) {
        return getFlexItemAt(i2);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int size = this.h.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.h.get(i3).g;
        }
        return i2;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean isMainAxisDirectionHorizontal() {
        int i2 = this.a;
        return i2 == 0 || i2 == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.x = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.u) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        super.onItemsAdded(recyclerView, i2, i3);
        L(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        super.onItemsMoved(recyclerView, i2, i3, i4);
        L(Math.min(i2, i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        super.onItemsRemoved(recyclerView, i2, i3);
        L(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        super.onItemsUpdated(recyclerView, i2, i3, obj);
        L(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        int i3;
        this.j = recycler;
        this.k = state;
        int itemCount = state.getItemCount();
        if (itemCount != 0 || !state.isPreLayout()) {
            H();
            j();
            ensureLayoutState();
            this.i.t(itemCount);
            this.i.u(itemCount);
            this.i.s(itemCount);
            this.l.j = false;
            SavedState savedState = this.p;
            if (savedState != null && savedState.hasValidAnchor(itemCount)) {
                this.q = this.p.mAnchorPosition;
            }
            if (!(this.m.f && this.q == -1 && this.p == null)) {
                this.m.s();
                K(state, this.m);
                this.m.f = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.m.e) {
                P(this.m, false, true);
            } else {
                O(this.m, false, true);
            }
            M(itemCount);
            if (this.m.e) {
                k(recycler, state, this.l);
                i3 = this.l.e;
                O(this.m, true, false);
                k(recycler, state, this.l);
                i2 = this.l.e;
            } else {
                k(recycler, state, this.l);
                i2 = this.l.e;
                P(this.m, true, false);
                k(recycler, state, this.l);
                i3 = this.l.e;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.m.e) {
                fixLayoutStartGap(i3 + fixLayoutEndGap(i2, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i2 + fixLayoutStartGap(i3, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.p = null;
        this.q = -1;
        this.r = Integer.MIN_VALUE;
        this.y = -1;
        this.m.s();
        this.v.clear();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexItemAdded(View view, int i2, int i3, a aVar) {
        calculateItemDecorationsForChild(view, A);
        if (isMainAxisDirectionHorizontal()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            aVar.e += leftDecorationWidth;
            aVar.f += leftDecorationWidth;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        aVar.e += topDecorationHeight;
        aVar.f += topDecorationHeight;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexLineAdded(a aVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.p = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.p != null) {
            return new SavedState(this.p);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            savedState.mAnchorPosition = getPosition(childClosestToStart);
            savedState.mAnchorOffset = this.n.getDecoratedStart(childClosestToStart) - this.n.getStartAfterPadding();
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!isMainAxisDirectionHorizontal()) {
            int w2 = w(i2, recycler, state);
            this.v.clear();
            return w2;
        }
        int x2 = x(i2);
        this.m.d += x2;
        this.o.offsetChildren(-x2);
        return x2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i2) {
        this.q = i2;
        this.r = Integer.MIN_VALUE;
        SavedState savedState = this.p;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (isMainAxisDirectionHorizontal()) {
            int w2 = w(i2, recycler, state);
            this.v.clear();
            return w2;
        }
        int x2 = x(i2);
        this.m.d += x2;
        this.o.offsetChildren(-x2);
        return x2;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignContent(int i2) {
        throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignItems(int i2) {
        int i3 = this.d;
        if (i3 != i2) {
            if (i3 == 4 || i2 == 4) {
                removeAllViews();
                i();
            }
            this.d = i2;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexDirection(int i2) {
        if (this.a != i2) {
            removeAllViews();
            this.a = i2;
            this.n = null;
            this.o = null;
            i();
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(List<a> list) {
        this.h = list;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexWrap(int i2) {
        if (i2 != 2) {
            int i3 = this.b;
            if (i3 != i2) {
                if (i3 == 0 || i2 == 0) {
                    removeAllViews();
                    i();
                }
                this.b = i2;
                this.n = null;
                this.o = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setJustifyContent(int i2) {
        if (this.c != i2) {
            this.c = i2;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setMaxLine(int i2) {
        if (this.e != i2) {
            this.e = i2;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i2);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void updateViewCache(int i2, View view) {
        this.v.put(i2, view);
    }

    /* access modifiers changed from: package-private */
    public int v(int i2) {
        return this.i.c[i2];
    }

    /* access modifiers changed from: package-private */
    public boolean y() {
        return this.f;
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private int mAnchorOffset;
        private int mAnchorPosition;

        /* compiled from: Taobao */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean hasValidAnchor(int i) {
            int i2 = this.mAnchorPosition;
            return i2 >= 0 && i2 < i;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
        }

        SavedState() {
        }

        private SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
        }

        private SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }
    }

    public FlexboxLayoutManager(Context context, int i2, int i3) {
        this.e = -1;
        this.h = new ArrayList();
        this.i = new b(this);
        this.m = new b();
        this.q = -1;
        this.r = Integer.MIN_VALUE;
        this.s = Integer.MIN_VALUE;
        this.t = Integer.MIN_VALUE;
        this.v = new SparseArray<>();
        this.y = -1;
        this.z = new b.C0153b();
        setFlexDirection(i2);
        setFlexWrap(i3);
        setAlignItems(4);
        setAutoMeasureEnabled(true);
        this.w = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3) {
        super.onItemsUpdated(recyclerView, i2, i3);
        L(i2);
    }

    /* compiled from: Taobao */
    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int mAlignSelf = -1;
        private float mFlexBasisPercent = -1.0f;
        private float mFlexGrow = 0.0f;
        private float mFlexShrink = 1.0f;
        private int mMaxHeight = 16777215;
        private int mMaxWidth = 16777215;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mWrapBefore;

        /* compiled from: Taobao */
        static class a implements Parcelable.Creator<LayoutParams> {
            a() {
            }

            /* renamed from: a */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* renamed from: b */
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int i) {
            this.mAlignSelf = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float f) {
            this.mFlexBasisPercent = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float f) {
            this.mFlexGrow = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float f) {
            this.mFlexShrink = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int i) {
            ((ViewGroup.MarginLayoutParams) this).height = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int i) {
            this.mMaxHeight = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int i) {
            this.mMaxWidth = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i) {
            this.mMinHeight = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i) {
            this.mMinWidth = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int i) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int i) {
            ((ViewGroup.MarginLayoutParams) this).width = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean z) {
            this.mWrapBefore = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
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

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RecyclerView.LayoutParams) layoutParams);
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        protected LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.e = -1;
        this.h = new ArrayList();
        this.i = new b(this);
        this.m = new b();
        this.q = -1;
        this.r = Integer.MIN_VALUE;
        this.s = Integer.MIN_VALUE;
        this.t = Integer.MIN_VALUE;
        this.v = new SparseArray<>();
        this.y = -1;
        this.z = new b.C0153b();
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i2, i3);
        int i4 = properties.orientation;
        if (i4 != 0) {
            if (i4 == 1) {
                if (properties.reverseLayout) {
                    setFlexDirection(3);
                } else {
                    setFlexDirection(2);
                }
            }
        } else if (properties.reverseLayout) {
            setFlexDirection(1);
        } else {
            setFlexDirection(0);
        }
        setFlexWrap(1);
        setAlignItems(4);
        setAutoMeasureEnabled(true);
        this.w = context;
    }
}
