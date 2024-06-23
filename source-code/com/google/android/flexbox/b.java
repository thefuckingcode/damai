package com.google.android.flexbox;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class b {
    private final FlexContainer a;
    private boolean[] b;
    @Nullable
    int[] c;
    @Nullable
    long[] d;
    @Nullable
    private long[] e;

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.flexbox.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0153b {
        List<a> a;
        int b;

        C0153b() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.a = null;
            this.b = 0;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c implements Comparable<c> {
        int a;
        int b;

        private c() {
        }

        /* renamed from: a */
        public int compareTo(@NonNull c cVar) {
            int i = this.b;
            int i2 = cVar.b;
            if (i != i2) {
                return i - i2;
            }
            return this.a - cVar.a;
        }

        public String toString() {
            return "Order{order=" + this.b + ", index=" + this.a + '}';
        }
    }

    b(FlexContainer flexContainer) {
        this.a = flexContainer;
    }

    private int A(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getMarginBottom();
        }
        return flexItem.getMarginRight();
    }

    private int B(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getMarginRight();
        }
        return flexItem.getMarginBottom();
    }

    private int C(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getMarginTop();
        }
        return flexItem.getMarginLeft();
    }

    private int D(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getMarginLeft();
        }
        return flexItem.getMarginTop();
    }

    private int E(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getHeight();
        }
        return flexItem.getWidth();
    }

    private int F(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getWidth();
        }
        return flexItem.getHeight();
    }

    private int G(boolean z) {
        if (z) {
            return this.a.getPaddingBottom();
        }
        return this.a.getPaddingEnd();
    }

    private int H(boolean z) {
        if (z) {
            return this.a.getPaddingEnd();
        }
        return this.a.getPaddingBottom();
    }

    private int I(boolean z) {
        if (z) {
            return this.a.getPaddingTop();
        }
        return this.a.getPaddingStart();
    }

    private int J(boolean z) {
        if (z) {
            return this.a.getPaddingStart();
        }
        return this.a.getPaddingTop();
    }

    private int K(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int L(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private boolean M(int i, int i2, a aVar) {
        return i == i2 - 1 && aVar.c() != 0;
    }

    private boolean O(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.a.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int decorationLengthMainAxis = this.a.getDecorationLengthMainAxis(view, i5, i6);
        if (decorationLengthMainAxis > 0) {
            i4 += decorationLengthMainAxis;
        }
        if (i2 < i3 + i4) {
            return true;
        }
        return false;
    }

    private void S(int i, int i2, a aVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        int i8 = aVar.e;
        float f = aVar.k;
        float f2 = 0.0f;
        if (f > 0.0f && i3 <= i8) {
            float f3 = ((float) (i8 - i3)) / f;
            aVar.e = i4 + aVar.f;
            if (!z) {
                aVar.g = Integer.MIN_VALUE;
            }
            int i9 = 0;
            boolean z2 = false;
            int i10 = 0;
            float f4 = 0.0f;
            while (i9 < aVar.h) {
                int i11 = aVar.o + i9;
                View reorderedFlexItemAt = this.a.getReorderedFlexItemAt(i11);
                if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                    i6 = i8;
                    i5 = i9;
                } else {
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int flexDirection = this.a.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        i6 = i8;
                        int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                        long[] jArr = this.e;
                        if (jArr != null) {
                            measuredWidth = x(jArr[i11]);
                        }
                        int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                        long[] jArr2 = this.e;
                        if (jArr2 != null) {
                            measuredHeight = w(jArr2[i11]);
                        }
                        if (this.b[i11] || flexItem.getFlexShrink() <= 0.0f) {
                            i5 = i9;
                        } else {
                            float flexShrink = ((float) measuredWidth) - (flexItem.getFlexShrink() * f3);
                            i5 = i9;
                            if (i5 == aVar.h - 1) {
                                flexShrink += f4;
                                f4 = 0.0f;
                            }
                            int round = Math.round(flexShrink);
                            if (round < flexItem.getMinWidth()) {
                                round = flexItem.getMinWidth();
                                this.b[i11] = true;
                                aVar.k -= flexItem.getFlexShrink();
                                z2 = true;
                            } else {
                                f4 += flexShrink - ((float) round);
                                double d2 = (double) f4;
                                if (d2 > 1.0d) {
                                    round++;
                                    f4 -= 1.0f;
                                } else if (d2 < -1.0d) {
                                    round--;
                                    f4 += 1.0f;
                                }
                            }
                            int y = y(i2, flexItem, aVar.m);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                            reorderedFlexItemAt.measure(makeMeasureSpec, y);
                            int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                            int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                            Y(i11, makeMeasureSpec, y, reorderedFlexItemAt);
                            this.a.updateViewCache(i11, reorderedFlexItemAt);
                            measuredWidth = measuredWidth2;
                            measuredHeight = measuredHeight2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                        aVar.e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                        i7 = max;
                    } else {
                        int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                        long[] jArr3 = this.e;
                        if (jArr3 != null) {
                            measuredHeight3 = w(jArr3[i11]);
                        }
                        int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        long[] jArr4 = this.e;
                        if (jArr4 != null) {
                            measuredWidth3 = x(jArr4[i11]);
                        }
                        if (this.b[i11] || flexItem.getFlexShrink() <= f2) {
                            i6 = i8;
                            i5 = i9;
                        } else {
                            float flexShrink2 = ((float) measuredHeight3) - (flexItem.getFlexShrink() * f3);
                            if (i9 == aVar.h - 1) {
                                flexShrink2 += f4;
                                f4 = 0.0f;
                            }
                            int round2 = Math.round(flexShrink2);
                            if (round2 < flexItem.getMinHeight()) {
                                round2 = flexItem.getMinHeight();
                                this.b[i11] = true;
                                aVar.k -= flexItem.getFlexShrink();
                                i6 = i8;
                                i5 = i9;
                                z2 = true;
                            } else {
                                f4 += flexShrink2 - ((float) round2);
                                i6 = i8;
                                i5 = i9;
                                double d3 = (double) f4;
                                if (d3 > 1.0d) {
                                    round2++;
                                    f4 -= 1.0f;
                                } else if (d3 < -1.0d) {
                                    round2--;
                                    f4 += 1.0f;
                                }
                            }
                            int z3 = z(i, flexItem, aVar.m);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            reorderedFlexItemAt.measure(z3, makeMeasureSpec2);
                            measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                            int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                            Y(i11, z3, makeMeasureSpec2, reorderedFlexItemAt);
                            this.a.updateViewCache(i11, reorderedFlexItemAt);
                            measuredHeight3 = measuredHeight4;
                        }
                        i7 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                        aVar.e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    }
                    aVar.g = Math.max(aVar.g, i7);
                    i10 = i7;
                }
                i9 = i5 + 1;
                i8 = i6;
                f2 = 0.0f;
            }
            if (z2 && i8 != aVar.e) {
                S(i, i2, aVar, i3, i4, true);
            }
        }
    }

    private int[] T(int i, List<c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (c cVar : list) {
            int i3 = cVar.a;
            iArr[i2] = i3;
            sparseIntArray.append(i3, cVar.b);
            i2++;
        }
        return iArr;
    }

    private void U(View view, int i, int i2) {
        int i3;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.a.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.e;
        if (jArr != null) {
            i3 = w(jArr[i2]);
        } else {
            i3 = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        Y(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.a.updateViewCache(i2, view);
    }

    private void V(View view, int i, int i2) {
        int i3;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.a.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.e;
        if (jArr != null) {
            i3 = x(jArr[i2]);
        } else {
            i3 = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        Y(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.a.updateViewCache(i2, view);
    }

    private void Y(int i, int i2, int i3, View view) {
        long[] jArr = this.d;
        if (jArr != null) {
            jArr[i] = R(i2, i3);
        }
        long[] jArr2 = this.e;
        if (jArr2 != null) {
            jArr2[i] = R(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void a(List<a> list, a aVar, int i, int i2) {
        aVar.m = i2;
        this.a.onNewFlexLineAdded(aVar);
        aVar.p = i;
        list.add(aVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    private void i(View view, int i) {
        boolean z;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < flexItem.getMinWidth()) {
            measuredWidth = flexItem.getMinWidth();
        } else if (measuredWidth > flexItem.getMaxWidth()) {
            measuredWidth = flexItem.getMaxWidth();
        } else {
            z = false;
            if (measuredHeight >= flexItem.getMinHeight()) {
                measuredHeight = flexItem.getMinHeight();
            } else if (measuredHeight > flexItem.getMaxHeight()) {
                measuredHeight = flexItem.getMaxHeight();
            } else {
                z2 = z;
            }
            if (!z2) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                Y(i, makeMeasureSpec, makeMeasureSpec2, view);
                this.a.updateViewCache(i, view);
                return;
            }
            return;
        }
        z = true;
        if (measuredHeight >= flexItem.getMinHeight()) {
        }
        if (!z2) {
        }
    }

    private List<a> k(List<a> list, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        a aVar = new a();
        aVar.g = (i - i2) / 2;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == 0) {
                arrayList.add(aVar);
            }
            arrayList.add(list.get(i3));
            if (i3 == list.size() - 1) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @NonNull
    private List<c> l(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            c cVar = new c();
            cVar.b = ((FlexItem) this.a.getFlexItemAt(i2).getLayoutParams()).getOrder();
            cVar.a = i2;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private void r(int i) {
        boolean[] zArr = this.b;
        if (zArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.b = new boolean[i];
        } else if (zArr.length < i) {
            int length = zArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.b = new boolean[i];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void v(int i, int i2, a aVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        double d2;
        int i8;
        double d3;
        float f = aVar.j;
        float f2 = 0.0f;
        if (f > 0.0f && i3 >= (i5 = aVar.e)) {
            float f3 = ((float) (i3 - i5)) / f;
            aVar.e = i4 + aVar.f;
            if (!z) {
                aVar.g = Integer.MIN_VALUE;
            }
            int i9 = 0;
            boolean z2 = false;
            int i10 = 0;
            float f4 = 0.0f;
            while (i9 < aVar.h) {
                int i11 = aVar.o + i9;
                View reorderedFlexItemAt = this.a.getReorderedFlexItemAt(i11);
                if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                    i6 = i5;
                } else {
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int flexDirection = this.a.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                        long[] jArr = this.e;
                        if (jArr != null) {
                            measuredWidth = x(jArr[i11]);
                        }
                        int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                        long[] jArr2 = this.e;
                        i6 = i5;
                        if (jArr2 != null) {
                            measuredHeight = w(jArr2[i11]);
                        }
                        if (!this.b[i11] && flexItem.getFlexGrow() > 0.0f) {
                            float flexGrow = ((float) measuredWidth) + (flexItem.getFlexGrow() * f3);
                            if (i9 == aVar.h - 1) {
                                flexGrow += f4;
                                f4 = 0.0f;
                            }
                            int round = Math.round(flexGrow);
                            if (round > flexItem.getMaxWidth()) {
                                round = flexItem.getMaxWidth();
                                this.b[i11] = true;
                                aVar.j -= flexItem.getFlexGrow();
                                z2 = true;
                            } else {
                                f4 += flexGrow - ((float) round);
                                double d4 = (double) f4;
                                if (d4 > 1.0d) {
                                    round++;
                                    d2 = d4 - 1.0d;
                                } else if (d4 < -1.0d) {
                                    round--;
                                    d2 = d4 + 1.0d;
                                }
                                f4 = (float) d2;
                            }
                            int y = y(i2, flexItem, aVar.m);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                            reorderedFlexItemAt.measure(makeMeasureSpec, y);
                            int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                            int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                            Y(i11, makeMeasureSpec, y, reorderedFlexItemAt);
                            this.a.updateViewCache(i11, reorderedFlexItemAt);
                            measuredWidth = measuredWidth2;
                            measuredHeight = measuredHeight2;
                        }
                        int max = Math.max(i10, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                        aVar.e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                        i7 = max;
                    } else {
                        int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                        long[] jArr3 = this.e;
                        if (jArr3 != null) {
                            measuredHeight3 = w(jArr3[i11]);
                        }
                        int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        long[] jArr4 = this.e;
                        if (jArr4 != null) {
                            measuredWidth3 = x(jArr4[i11]);
                        }
                        if (this.b[i11] || flexItem.getFlexGrow() <= f2) {
                            i8 = i5;
                        } else {
                            float flexGrow2 = ((float) measuredHeight3) + (flexItem.getFlexGrow() * f3);
                            if (i9 == aVar.h - 1) {
                                flexGrow2 += f4;
                                f4 = 0.0f;
                            }
                            int round2 = Math.round(flexGrow2);
                            if (round2 > flexItem.getMaxHeight()) {
                                round2 = flexItem.getMaxHeight();
                                this.b[i11] = true;
                                aVar.j -= flexItem.getFlexGrow();
                                i8 = i5;
                                z2 = true;
                            } else {
                                f4 += flexGrow2 - ((float) round2);
                                i8 = i5;
                                double d5 = (double) f4;
                                if (d5 > 1.0d) {
                                    round2++;
                                    d3 = d5 - 1.0d;
                                } else if (d5 < -1.0d) {
                                    round2--;
                                    d3 = d5 + 1.0d;
                                }
                                f4 = (float) d3;
                            }
                            int z3 = z(i, flexItem, aVar.m);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            reorderedFlexItemAt.measure(z3, makeMeasureSpec2);
                            measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                            int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                            Y(i11, z3, makeMeasureSpec2, reorderedFlexItemAt);
                            this.a.updateViewCache(i11, reorderedFlexItemAt);
                            measuredHeight3 = measuredHeight4;
                        }
                        i7 = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                        aVar.e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                        i6 = i8;
                    }
                    aVar.g = Math.max(aVar.g, i7);
                    i10 = i7;
                }
                i9++;
                i5 = i6;
                f2 = 0.0f;
            }
            if (z2 && i5 != aVar.e) {
                v(i, i2, aVar, i3, i4, true);
            }
        }
    }

    private int y(int i, FlexItem flexItem, int i2) {
        FlexContainer flexContainer = this.a;
        int childHeightMeasureSpec = flexContainer.getChildHeightMeasureSpec(i, flexContainer.getPaddingTop() + this.a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec));
        }
        return size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }

    private int z(int i, FlexItem flexItem, int i2) {
        FlexContainer flexContainer = this.a;
        int childWidthMeasureSpec = flexContainer.getChildWidthMeasureSpec(i, flexContainer.getPaddingLeft() + this.a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec));
        }
        return size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    /* access modifiers changed from: package-private */
    public boolean N(SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View flexItemAt = this.a.getFlexItemAt(i);
            if (!(flexItemAt == null || ((FlexItem) flexItemAt.getLayoutParams()).getOrder() == sparseIntArray.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void P(View view, a aVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i5 = aVar.g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                    if (this.a.getFlexWrap() != 2) {
                        int i6 = i2 + measuredHeight;
                        view.layout(i, i6, i3, view.getMeasuredHeight() + i6);
                        return;
                    }
                    int i7 = i2 - measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else if (alignItems != 3) {
                    if (alignItems != 4) {
                        return;
                    }
                } else if (this.a.getFlexWrap() != 2) {
                    int max = Math.max(aVar.l - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(i, i2 + max, i3, i4 + max);
                    return;
                } else {
                    int max2 = Math.max((aVar.l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                    view.layout(i, i2 - max2, i3, i4 - max2);
                    return;
                }
            } else if (this.a.getFlexWrap() != 2) {
                int i8 = i2 + i5;
                view.layout(i, (i8 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i3, i8 - flexItem.getMarginBottom());
                return;
            } else {
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.getMarginTop(), i3, (i4 - i5) + view.getMeasuredHeight() + flexItem.getMarginTop());
                return;
            }
        }
        if (this.a.getFlexWrap() != 2) {
            view.layout(i, i2 + flexItem.getMarginTop(), i3, i4 + flexItem.getMarginTop());
        } else {
            view.layout(i, i2 - flexItem.getMarginBottom(), i3, i4 - flexItem.getMarginBottom());
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(View view, a aVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i5 = aVar.g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int measuredWidth = (((i5 - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                    if (!z) {
                        view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                        return;
                    } else {
                        view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                        return;
                    }
                } else if (!(alignItems == 3 || alignItems == 4)) {
                    return;
                }
            } else if (!z) {
                view.layout(((i + i5) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i2, ((i3 + i5) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i4);
                return;
            } else {
                view.layout((i - i5) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i2, (i3 - i5) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i4);
                return;
            }
        }
        if (!z) {
            view.layout(i + flexItem.getMarginLeft(), i2, i3 + flexItem.getMarginLeft(), i4);
        } else {
            view.layout(i - flexItem.getMarginRight(), i2, i3 - flexItem.getMarginRight(), i4);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public long R(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    /* access modifiers changed from: package-private */
    public void W() {
        X(0);
    }

    /* access modifiers changed from: package-private */
    public void X(int i) {
        View reorderedFlexItemAt;
        if (i < this.a.getFlexItemCount()) {
            int flexDirection = this.a.getFlexDirection();
            if (this.a.getAlignItems() == 4) {
                int[] iArr = this.c;
                List<a> flexLinesInternal = this.a.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                    a aVar = flexLinesInternal.get(i2);
                    int i3 = aVar.h;
                    for (int i4 = 0; i4 < i3; i4++) {
                        int i5 = aVar.o + i4;
                        if (!(i4 >= this.a.getFlexItemCount() || (reorderedFlexItemAt = this.a.getReorderedFlexItemAt(i5)) == null || reorderedFlexItemAt.getVisibility() == 8)) {
                            FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                            if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                                if (flexDirection == 0 || flexDirection == 1) {
                                    V(reorderedFlexItemAt, aVar.g, i5);
                                } else if (flexDirection == 2 || flexDirection == 3) {
                                    U(reorderedFlexItemAt, aVar.g, i5);
                                } else {
                                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                                }
                            }
                        }
                    }
                }
                return;
            }
            for (a aVar2 : this.a.getFlexLinesInternal()) {
                Iterator<Integer> it = aVar2.n.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Integer next = it.next();
                        View reorderedFlexItemAt2 = this.a.getReorderedFlexItemAt(next.intValue());
                        if (flexDirection == 0 || flexDirection == 1) {
                            V(reorderedFlexItemAt2, aVar2.g, next.intValue());
                        } else if (flexDirection == 2 || flexDirection == 3) {
                            U(reorderedFlexItemAt2, aVar2.g, next.intValue());
                        } else {
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(C0153b bVar, int i, int i2, int i3, int i4, int i5, @Nullable List<a> list) {
        int i6;
        C0153b bVar2;
        int i7;
        int i8;
        List<a> list2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        View view;
        int i15;
        int i16;
        int i17;
        a aVar;
        int i18 = i;
        int i19 = i2;
        int i20 = i5;
        boolean isMainAxisDirectionHorizontal = this.a.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        ArrayList arrayList = list == null ? new ArrayList() : list;
        bVar.a = arrayList;
        boolean z = i20 == -1;
        int J = J(isMainAxisDirectionHorizontal);
        int H = H(isMainAxisDirectionHorizontal);
        int I = I(isMainAxisDirectionHorizontal);
        int G = G(isMainAxisDirectionHorizontal);
        a aVar2 = new a();
        int i21 = i4;
        aVar2.o = i21;
        int i22 = H + J;
        aVar2.e = i22;
        int flexItemCount = this.a.getFlexItemCount();
        boolean z2 = z;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = Integer.MIN_VALUE;
        while (true) {
            if (i21 >= flexItemCount) {
                i6 = i24;
                bVar2 = bVar;
                break;
            }
            View reorderedFlexItemAt = this.a.getReorderedFlexItemAt(i21);
            if (reorderedFlexItemAt == null) {
                if (M(i21, flexItemCount, aVar2)) {
                    a(arrayList, aVar2, i21, i23);
                }
            } else if (reorderedFlexItemAt.getVisibility() == 8) {
                aVar2.i++;
                aVar2.h++;
                if (M(i21, flexItemCount, aVar2)) {
                    a(arrayList, aVar2, i21, i23);
                }
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                if (flexItem.getAlignSelf() == 4) {
                    aVar2.n.add(Integer.valueOf(i21));
                }
                int F = F(flexItem, isMainAxisDirectionHorizontal);
                if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                    F = Math.round(((float) size) * flexItem.getFlexBasisPercent());
                }
                if (isMainAxisDirectionHorizontal) {
                    int childWidthMeasureSpec = this.a.getChildWidthMeasureSpec(i18, i22 + D(flexItem, true) + B(flexItem, true), F);
                    i8 = size;
                    i7 = mode;
                    int childHeightMeasureSpec = this.a.getChildHeightMeasureSpec(i19, I + G + C(flexItem, true) + A(flexItem, true) + i23, E(flexItem, true));
                    reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    Y(i21, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                    i13 = childWidthMeasureSpec;
                } else {
                    i8 = size;
                    i7 = mode;
                    int childWidthMeasureSpec2 = this.a.getChildWidthMeasureSpec(i19, I + G + C(flexItem, false) + A(flexItem, false) + i23, E(flexItem, false));
                    int childHeightMeasureSpec2 = this.a.getChildHeightMeasureSpec(i18, D(flexItem, false) + i22 + B(flexItem, false), F);
                    reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                    Y(i21, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                    i13 = childHeightMeasureSpec2;
                }
                this.a.updateViewCache(i21, reorderedFlexItemAt);
                i(reorderedFlexItemAt, i21);
                i24 = View.combineMeasuredStates(i24, reorderedFlexItemAt.getMeasuredState());
                list2 = arrayList;
                if (O(reorderedFlexItemAt, i7, i8, aVar2.e, B(flexItem, isMainAxisDirectionHorizontal) + L(reorderedFlexItemAt, isMainAxisDirectionHorizontal) + D(flexItem, isMainAxisDirectionHorizontal), flexItem, i21, i25, arrayList.size())) {
                    if (aVar2.c() > 0) {
                        if (i21 > 0) {
                            i17 = i21 - 1;
                            aVar = aVar2;
                        } else {
                            aVar = aVar2;
                            i17 = 0;
                        }
                        a(list2, aVar, i17, i23);
                        i23 = aVar.g + i23;
                    } else {
                        i23 = i23;
                    }
                    if (!isMainAxisDirectionHorizontal) {
                        i11 = i2;
                        view = reorderedFlexItemAt;
                        i21 = i21;
                        if (flexItem.getWidth() == -1) {
                            FlexContainer flexContainer = this.a;
                            view.measure(flexContainer.getChildWidthMeasureSpec(i11, flexContainer.getPaddingLeft() + this.a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i23, flexItem.getWidth()), i13);
                            i(view, i21);
                        }
                    } else if (flexItem.getHeight() == -1) {
                        FlexContainer flexContainer2 = this.a;
                        i11 = i2;
                        i21 = i21;
                        view = reorderedFlexItemAt;
                        view.measure(i13, flexContainer2.getChildHeightMeasureSpec(i11, flexContainer2.getPaddingTop() + this.a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i23, flexItem.getHeight()));
                        i(view, i21);
                    } else {
                        i11 = i2;
                        view = reorderedFlexItemAt;
                        i21 = i21;
                    }
                    aVar2 = new a();
                    aVar2.h = 1;
                    i10 = i22;
                    aVar2.e = i10;
                    aVar2.o = i21;
                    i15 = 0;
                    i14 = Integer.MIN_VALUE;
                } else {
                    i11 = i2;
                    view = reorderedFlexItemAt;
                    i21 = i21;
                    aVar2 = aVar2;
                    i10 = i22;
                    aVar2.h++;
                    i15 = i25 + 1;
                    i23 = i23;
                    i14 = i26;
                }
                int[] iArr = this.c;
                if (iArr != null) {
                    iArr[i21] = list2.size();
                }
                aVar2.e += L(view, isMainAxisDirectionHorizontal) + D(flexItem, isMainAxisDirectionHorizontal) + B(flexItem, isMainAxisDirectionHorizontal);
                aVar2.j += flexItem.getFlexGrow();
                aVar2.k += flexItem.getFlexShrink();
                this.a.onNewFlexItemAdded(view, i21, i15, aVar2);
                int max = Math.max(i14, K(view, isMainAxisDirectionHorizontal) + C(flexItem, isMainAxisDirectionHorizontal) + A(flexItem, isMainAxisDirectionHorizontal) + this.a.getDecorationLengthCrossAxis(view));
                aVar2.g = Math.max(aVar2.g, max);
                if (isMainAxisDirectionHorizontal) {
                    if (this.a.getFlexWrap() != 2) {
                        aVar2.l = Math.max(aVar2.l, view.getBaseline() + flexItem.getMarginTop());
                    } else {
                        aVar2.l = Math.max(aVar2.l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.getMarginBottom());
                    }
                }
                i12 = flexItemCount;
                if (M(i21, i12, aVar2)) {
                    a(list2, aVar2, i21, i23);
                    i23 += aVar2.g;
                }
                i9 = i5;
                if (i9 != -1 && list2.size() > 0) {
                    if (list2.get(list2.size() - 1).p >= i9 && i21 >= i9 && !z2) {
                        i23 = -aVar2.a();
                        i16 = i3;
                        z2 = true;
                        if (i23 <= i16 && z2) {
                            bVar2 = bVar;
                            i6 = i24;
                            break;
                        }
                        i25 = i15;
                        i26 = max;
                        i21++;
                        i18 = i;
                        flexItemCount = i12;
                        i19 = i11;
                        i22 = i10;
                        arrayList = list2;
                        mode = i7;
                        i20 = i9;
                        size = i8;
                    }
                }
                i16 = i3;
                if (i23 <= i16) {
                }
                i25 = i15;
                i26 = max;
                i21++;
                i18 = i;
                flexItemCount = i12;
                i19 = i11;
                i22 = i10;
                arrayList = list2;
                mode = i7;
                i20 = i9;
                size = i8;
            }
            i8 = size;
            i7 = mode;
            i11 = i19;
            i9 = i20;
            list2 = arrayList;
            i10 = i22;
            i12 = flexItemCount;
            i21++;
            i18 = i;
            flexItemCount = i12;
            i19 = i11;
            i22 = i10;
            arrayList = list2;
            mode = i7;
            i20 = i9;
            size = i8;
        }
        bVar2.b = i6;
    }

    /* access modifiers changed from: package-private */
    public void c(C0153b bVar, int i, int i2) {
        b(bVar, i, i2, Integer.MAX_VALUE, 0, -1, null);
    }

    /* access modifiers changed from: package-private */
    public void d(C0153b bVar, int i, int i2, int i3, int i4, @Nullable List<a> list) {
        b(bVar, i, i2, i3, i4, -1, list);
    }

    /* access modifiers changed from: package-private */
    public void e(C0153b bVar, int i, int i2, int i3, int i4, List<a> list) {
        b(bVar, i, i2, i3, 0, i4, list);
    }

    /* access modifiers changed from: package-private */
    public void f(C0153b bVar, int i, int i2) {
        b(bVar, i2, i, Integer.MAX_VALUE, 0, -1, null);
    }

    /* access modifiers changed from: package-private */
    public void g(C0153b bVar, int i, int i2, int i3, int i4, @Nullable List<a> list) {
        b(bVar, i2, i, i3, i4, -1, list);
    }

    /* access modifiers changed from: package-private */
    public void h(C0153b bVar, int i, int i2, int i3, int i4, List<a> list) {
        b(bVar, i2, i, i3, 0, i4, list);
    }

    /* access modifiers changed from: package-private */
    public void j(List<a> list, int i) {
        int i2 = this.c[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int[] iArr = this.c;
        int length = iArr.length - 1;
        if (i > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.d;
        int length2 = jArr.length - 1;
        if (i > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i, length2, 0L);
        }
    }

    /* access modifiers changed from: package-private */
    public int[] m(SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        return T(flexItemCount, l(flexItemCount), sparseIntArray);
    }

    /* access modifiers changed from: package-private */
    public int[] n(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        List<c> l = l(flexItemCount);
        c cVar = new c();
        if (view == null || !(layoutParams instanceof FlexItem)) {
            cVar.b = 1;
        } else {
            cVar.b = ((FlexItem) layoutParams).getOrder();
        }
        if (i == -1 || i == flexItemCount) {
            cVar.a = flexItemCount;
        } else if (i < this.a.getFlexItemCount()) {
            cVar.a = i;
            while (i < flexItemCount) {
                l.get(i).a++;
                i++;
            }
        } else {
            cVar.a = flexItemCount;
        }
        l.add(cVar);
        return T(flexItemCount + 1, l, sparseIntArray);
    }

    /* access modifiers changed from: package-private */
    public void o(int i, int i2, int i3) {
        int i4;
        int i5;
        int flexDirection = this.a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            i4 = mode;
            i5 = size;
        } else if (flexDirection == 2 || flexDirection == 3) {
            i4 = View.MeasureSpec.getMode(i);
            i5 = View.MeasureSpec.getSize(i);
        } else {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        }
        List<a> flexLinesInternal = this.a.getFlexLinesInternal();
        if (i4 == 1073741824) {
            int sumOfCrossSize = this.a.getSumOfCrossSize() + i3;
            int i6 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).g = i5 - i3;
            } else if (flexLinesInternal.size() >= 2) {
                int alignContent = this.a.getAlignContent();
                if (alignContent == 1) {
                    int i7 = i5 - sumOfCrossSize;
                    a aVar = new a();
                    aVar.g = i7;
                    flexLinesInternal.add(0, aVar);
                } else if (alignContent == 2) {
                    this.a.setFlexLines(k(flexLinesInternal, i5, sumOfCrossSize));
                } else if (alignContent != 3) {
                    if (alignContent != 4) {
                        if (alignContent == 5 && sumOfCrossSize < i5) {
                            float size2 = ((float) (i5 - sumOfCrossSize)) / ((float) flexLinesInternal.size());
                            int size3 = flexLinesInternal.size();
                            float f = 0.0f;
                            while (i6 < size3) {
                                a aVar2 = flexLinesInternal.get(i6);
                                float f2 = ((float) aVar2.g) + size2;
                                if (i6 == flexLinesInternal.size() - 1) {
                                    f2 += f;
                                    f = 0.0f;
                                }
                                int round = Math.round(f2);
                                f += f2 - ((float) round);
                                if (f > 1.0f) {
                                    round++;
                                    f -= 1.0f;
                                } else if (f < -1.0f) {
                                    round--;
                                    f += 1.0f;
                                }
                                aVar2.g = round;
                                i6++;
                            }
                        }
                    } else if (sumOfCrossSize >= i5) {
                        this.a.setFlexLines(k(flexLinesInternal, i5, sumOfCrossSize));
                    } else {
                        int size4 = (i5 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList = new ArrayList();
                        a aVar3 = new a();
                        aVar3.g = size4;
                        for (a aVar4 : flexLinesInternal) {
                            arrayList.add(aVar3);
                            arrayList.add(aVar4);
                            arrayList.add(aVar3);
                        }
                        this.a.setFlexLines(arrayList);
                    }
                } else if (sumOfCrossSize < i5) {
                    float size5 = ((float) (i5 - sumOfCrossSize)) / ((float) (flexLinesInternal.size() - 1));
                    ArrayList arrayList2 = new ArrayList();
                    int size6 = flexLinesInternal.size();
                    float f3 = 0.0f;
                    while (i6 < size6) {
                        arrayList2.add(flexLinesInternal.get(i6));
                        if (i6 != flexLinesInternal.size() - 1) {
                            a aVar5 = new a();
                            if (i6 == flexLinesInternal.size() - 2) {
                                aVar5.g = Math.round(f3 + size5);
                                f3 = 0.0f;
                            } else {
                                aVar5.g = Math.round(size5);
                            }
                            int i8 = aVar5.g;
                            f3 += size5 - ((float) i8);
                            if (f3 > 1.0f) {
                                aVar5.g = i8 + 1;
                                f3 -= 1.0f;
                            } else if (f3 < -1.0f) {
                                aVar5.g = i8 - 1;
                                f3 += 1.0f;
                            }
                            arrayList2.add(aVar5);
                        }
                        i6++;
                    }
                    this.a.setFlexLines(arrayList2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void p(int i, int i2) {
        q(i, i2, 0);
    }

    /* access modifiers changed from: package-private */
    public void q(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        r(this.a.getFlexItemCount());
        if (i3 < this.a.getFlexItemCount()) {
            int flexDirection = this.a.getFlexDirection();
            int flexDirection2 = this.a.getFlexDirection();
            if (flexDirection2 == 0 || flexDirection2 == 1) {
                int mode = View.MeasureSpec.getMode(i);
                i5 = View.MeasureSpec.getSize(i);
                if (mode != 1073741824) {
                    i5 = this.a.getLargestMainSize();
                }
                i6 = this.a.getPaddingLeft();
                i4 = this.a.getPaddingRight();
            } else if (flexDirection2 == 2 || flexDirection2 == 3) {
                int mode2 = View.MeasureSpec.getMode(i2);
                i5 = View.MeasureSpec.getSize(i2);
                if (mode2 != 1073741824) {
                    i5 = this.a.getLargestMainSize();
                }
                i6 = this.a.getPaddingTop();
                i4 = this.a.getPaddingBottom();
            } else {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i7 = i6 + i4;
            int i8 = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                i8 = iArr[i3];
            }
            List<a> flexLinesInternal = this.a.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i9 = i8; i9 < size; i9++) {
                a aVar = flexLinesInternal.get(i9);
                if (aVar.e < i5) {
                    v(i, i2, aVar, i5, i7, false);
                } else {
                    S(i, i2, aVar, i5, i7, false);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s(int i) {
        int[] iArr = this.c;
        if (iArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.c = new int[i];
        } else if (iArr.length < i) {
            int length = iArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.c = Arrays.copyOf(iArr, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(int i) {
        long[] jArr = this.d;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.d = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.d = Arrays.copyOf(jArr, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void u(int i) {
        long[] jArr = this.e;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.e = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.e = Arrays.copyOf(jArr, i);
        }
    }

    /* access modifiers changed from: package-private */
    public int w(long j) {
        return (int) (j >> 32);
    }

    /* access modifiers changed from: package-private */
    public int x(long j) {
        return (int) j;
    }
}
