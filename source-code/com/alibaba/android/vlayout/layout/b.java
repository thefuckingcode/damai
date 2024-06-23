package com.alibaba.android.vlayout.layout;

import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.c;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Arrays;
import tb.s61;

/* compiled from: Taobao */
public class b extends BaseLayoutHelper {
    private static boolean m;
    private static final int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    private int a;
    private int b;
    private int c;
    private boolean d;
    @NonNull
    private AbstractC0079b e;
    private int f;
    private int g;
    private float[] h;
    private View[] i;
    private int[] j;
    private int[] k;
    private boolean l;

    /* compiled from: Taobao */
    static final class a extends AbstractC0079b {
        a() {
        }

        @Override // com.alibaba.android.vlayout.layout.b.AbstractC0079b
        public int b(int i, int i2) {
            return (i - this.c) % i2;
        }

        @Override // com.alibaba.android.vlayout.layout.b.AbstractC0079b
        public int c(int i) {
            return 1;
        }
    }

    /* renamed from: com.alibaba.android.vlayout.layout.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static abstract class AbstractC0079b {
        final SparseIntArray a = new SparseIntArray();
        private boolean b = false;
        int c = 0;

        /* access modifiers changed from: package-private */
        public int a(int i, int i2) {
            if (!this.b) {
                return b(i, i2);
            }
            int i3 = this.a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int b2 = b(i, i2);
            this.a.put(i, b2);
            return b2;
        }

        public abstract int b(int i, int i2);

        public abstract int c(int i);

        public void d() {
            this.a.clear();
        }

        public void e(boolean z) {
            this.b = z;
        }

        public void f(int i) {
            this.c = i;
        }
    }

    public b(int i2) {
        this(i2, -1, -1);
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, int i3, boolean z, LayoutManagerHelper layoutManagerHelper) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        if (z) {
            i4 = i2;
            i5 = 0;
            i6 = 1;
        } else {
            i5 = i2 - 1;
            i4 = -1;
            i6 = -1;
        }
        if (layoutManagerHelper.getOrientation() != 1 || !layoutManagerHelper.isDoLayoutRTL()) {
            i7 = 1;
        } else {
            i8 = i3 - 1;
            i7 = -1;
        }
        while (i5 != i4) {
            int spanSize = getSpanSize(recycler, state, layoutManagerHelper.getPosition(this.i[i5]));
            if (i7 != -1 || spanSize <= 1) {
                this.j[i5] = i8;
            } else {
                this.j[i5] = i8 - (spanSize - 1);
            }
            i8 += spanSize * i7;
            i5 += i6;
        }
    }

    private void ensureSpanCount() {
        View[] viewArr = this.i;
        if (viewArr == null || viewArr.length != this.a) {
            this.i = new View[this.a];
        }
        int[] iArr = this.j;
        if (iArr == null || iArr.length != this.a) {
            this.j = new int[this.a];
        }
        int[] iArr2 = this.k;
        if (iArr2 == null || iArr2.length != this.a) {
            this.k = new int[this.a];
        }
    }

    private int getMainDirSpec(int i2, int i3, int i4, float f2) {
        if (!Float.isNaN(f2) && f2 > 0.0f && i4 > 0) {
            return View.MeasureSpec.makeMeasureSpec((int) ((((float) i4) / f2) + 0.5f), 1073741824);
        }
        if (!Float.isNaN(this.mAspectRatio)) {
            float f3 = this.mAspectRatio;
            if (f3 > 0.0f) {
                return View.MeasureSpec.makeMeasureSpec((int) ((((float) i3) / f3) + 0.5f), 1073741824);
            }
        }
        if (i2 < 0) {
            return n;
        }
        return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i2) {
        if (!state.isPreLayout()) {
            return this.e.a(i2, this.a);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i2);
        if (convertPreLayoutPositionToPostLayout == -1) {
            return 0;
        }
        return this.e.a(convertPreLayoutPositionToPostLayout, this.a);
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i2) {
        if (!state.isPreLayout()) {
            return this.e.c(i2);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i2);
        if (convertPreLayoutPositionToPostLayout == -1) {
            return 0;
        }
        return this.e.c(convertPreLayoutPositionToPostLayout);
    }

    @Override // com.alibaba.android.vlayout.a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            int a2 = this.e.a(cVar.a, this.a);
            if (!cVar.c) {
                while (a2 > 0) {
                    int i2 = cVar.a;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    cVar.a = i3;
                    a2 = this.e.a(i3, this.a);
                }
            } else {
                while (a2 < this.a - 1 && cVar.a < getRange().e().intValue()) {
                    int i4 = cVar.a + 1;
                    cVar.a = i4;
                    a2 = this.e.a(i4, this.a);
                }
            }
            this.l = true;
        }
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computeAlignOffset(int i2, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z3 = layoutManagerHelper.getOrientation() == 1;
        if (z) {
            if (i2 == getItemCount() - 1) {
                if (z3) {
                    i6 = this.mMarginBottom;
                    i5 = this.mPaddingBottom;
                } else {
                    i6 = this.mMarginRight;
                    i5 = this.mPaddingRight;
                }
                return i6 + i5;
            }
        } else if (i2 == 0) {
            if (z3) {
                i4 = -this.mMarginTop;
                i3 = this.mPaddingTop;
            } else {
                i4 = -this.mMarginLeft;
                i3 = this.mPaddingLeft;
            }
            return i4 - i3;
        }
        return super.computeAlignOffset(i2, z, z2, layoutManagerHelper);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x021b, code lost:
        if (r0 == getRange().e().intValue()) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x022e, code lost:
        if (r0 == getRange().d().intValue()) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0232, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x024e, code lost:
        if (r0 == getRange().d().intValue()) goto L_0x0261;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x025f, code lost:
        if (r0 == getRange().e().intValue()) goto L_0x0261;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0263, code lost:
        r0 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x029a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01ed  */
    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper) {
        boolean z;
        boolean z2;
        c cVar;
        boolean z3;
        int i2;
        int i3;
        String str;
        boolean z4;
        boolean z5;
        boolean z6;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        String str2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int c2;
        View l2;
        int i20;
        boolean z7;
        boolean z8;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        if (!isOutOfRange(dVar.c())) {
            dVar.c();
            boolean isEnableMarginOverLap = layoutManagerHelper.isEnableMarginOverLap();
            int e2 = dVar.e();
            boolean z9 = e2 == 1;
            c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            boolean z10 = layoutManagerHelper.getOrientation() == 1;
            if (z10) {
                int contentWidth = (((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight()) - layoutManagerHelper.getPaddingLeft()) - getHorizontalMargin()) - getHorizontalPadding();
                this.c = contentWidth;
                int i21 = this.a;
                this.b = (int) (((((float) (contentWidth - ((i21 - 1) * this.g))) * 1.0f) / ((float) i21)) + 0.5f);
            } else {
                int contentHeight = (((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingBottom()) - layoutManagerHelper.getPaddingTop()) - getVerticalMargin()) - getVerticalPadding();
                this.c = contentHeight;
                int i22 = this.a;
                this.b = (int) (((((float) (contentHeight - ((i22 - 1) * this.f))) * 1.0f) / ((float) i22)) + 0.5f);
            }
            int i23 = this.a;
            ensureSpanCount();
            if (!z9) {
                int spanIndex = getSpanIndex(recycler2, state2, dVar.c());
                int spanSize = getSpanSize(recycler2, state2, dVar.c()) + spanIndex;
                z3 = z10;
                if (spanIndex != this.a - 1) {
                    int c3 = dVar.c();
                    int i24 = this.a - spanSize;
                    cVar = mainOrientationHelper;
                    i20 = spanSize;
                    int i25 = 0;
                    z2 = false;
                    int i26 = 0;
                    z = false;
                    while (i25 < this.a && i24 > 0) {
                        c3 -= e2;
                        if (isOutOfRange(c3)) {
                            break;
                        }
                        int spanSize2 = getSpanSize(recycler2, state2, c3);
                        if (spanSize2 <= this.a) {
                            View m2 = dVar.m(recycler2, c3);
                            if (m2 == null) {
                                break;
                            }
                            if (!z2) {
                                if (layoutManagerHelper.getReverseLayout()) {
                                    z8 = false;
                                    z2 = z8;
                                } else {
                                    z8 = false;
                                    z2 = z8;
                                }
                                z8 = true;
                                z2 = z8;
                            }
                            if (!z) {
                                if (layoutManagerHelper.getReverseLayout()) {
                                    z7 = false;
                                    z = z7;
                                } else {
                                    z7 = false;
                                    z = z7;
                                }
                                z7 = true;
                                z = z7;
                            }
                            i24 -= spanSize2;
                            if (i24 < 0) {
                                break;
                            }
                            i26 += spanSize2;
                            this.i[i25] = m2;
                            i25++;
                            e2 = e2;
                        } else {
                            throw new IllegalArgumentException("Item at position " + c3 + " requires " + spanSize2 + " spans but GridLayoutManager has only " + this.a + " spans.");
                        }
                    }
                    if (i25 > 0) {
                        int i27 = 0;
                        for (int i28 = i25 - 1; i27 < i28; i28--) {
                            View[] viewArr = this.i;
                            View view = viewArr[i27];
                            viewArr[i27] = viewArr[i28];
                            viewArr[i28] = view;
                            i27++;
                        }
                    }
                    i3 = i25;
                    i2 = i26;
                } else {
                    cVar = mainOrientationHelper;
                    i23 = spanSize;
                    i3 = 0;
                    i2 = 0;
                    z2 = false;
                    z = false;
                    if (i3 < this.a && dVar.h(state2) && i23 > 0) {
                        c2 = dVar.c();
                        if (!isOutOfRange(c2)) {
                            int spanSize3 = getSpanSize(recycler2, state2, c2);
                            str = "GridLayoutHelper";
                            if (spanSize3 <= this.a) {
                                i23 -= spanSize3;
                                if (i23 >= 0 && (l2 = dVar.l(recycler2)) != null) {
                                    if (z2) {
                                        i20 = i23;
                                    } else {
                                        if (layoutManagerHelper.getReverseLayout()) {
                                            i20 = i23;
                                        } else {
                                            i20 = i23;
                                        }
                                        boolean z11 = true;
                                        z2 = z11;
                                    }
                                    if (!z) {
                                        if (!layoutManagerHelper.getReverseLayout()) {
                                        }
                                        boolean z12 = true;
                                        z = z12;
                                    }
                                    i2 += spanSize3;
                                    this.i[i3] = l2;
                                    i3++;
                                }
                                if (i3 == 0) {
                                    String str3 = str;
                                    assignSpans(recycler, state, i3, i2, z9, layoutManagerHelper);
                                    if (i23 <= 0 || i3 != i2 || !this.d) {
                                        if (!z9 && i23 == 0 && i3 == i2 && this.d) {
                                            if (z3) {
                                                this.b = (this.c - ((i3 - 1) * this.g)) / i3;
                                            } else {
                                                this.b = (this.c - ((i3 - 1) * this.f)) / i3;
                                            }
                                        }
                                    } else if (z3) {
                                        this.b = (this.c - ((i3 - 1) * this.g)) / i3;
                                    } else {
                                        this.b = (this.c - ((i3 - 1) * this.f)) / i3;
                                    }
                                    float[] fArr = this.h;
                                    if (fArr == null || fArr.length <= 0) {
                                        z4 = false;
                                    } else {
                                        if (z3) {
                                            i19 = this.c;
                                            i18 = i3 - 1;
                                            i17 = this.g;
                                        } else {
                                            i19 = this.c;
                                            i18 = i3 - 1;
                                            i17 = this.f;
                                        }
                                        int i29 = i19 - (i18 * i17);
                                        int i30 = (i23 <= 0 || !this.d) ? this.a : i3;
                                        int i31 = i29;
                                        int i32 = 0;
                                        for (int i33 = 0; i33 < i30; i33++) {
                                            float[] fArr2 = this.h;
                                            if (i33 < fArr2.length && !Float.isNaN(fArr2[i33])) {
                                                float[] fArr3 = this.h;
                                                if (fArr3[i33] >= 0.0f) {
                                                    float f2 = fArr3[i33];
                                                    int[] iArr = this.k;
                                                    iArr[i33] = (int) ((((f2 * 1.0f) / 100.0f) * ((float) i29)) + 0.5f);
                                                    i31 -= iArr[i33];
                                                }
                                            }
                                            i32++;
                                            this.k[i33] = -1;
                                        }
                                        if (i32 > 0) {
                                            int i34 = i31 / i32;
                                            for (int i35 = 0; i35 < i30; i35++) {
                                                int[] iArr2 = this.k;
                                                if (iArr2[i35] < 0) {
                                                    iArr2[i35] = i34;
                                                }
                                            }
                                        }
                                        z4 = true;
                                    }
                                    int i36 = 0;
                                    int i37 = 0;
                                    while (i36 < i3) {
                                        View view2 = this.i[i36];
                                        layoutManagerHelper.addChildView(dVar, view2, z9 ? -1 : 0);
                                        int spanSize4 = getSpanSize(recycler2, state2, layoutManagerHelper.getPosition(view2));
                                        if (z4) {
                                            int i38 = this.j[i36];
                                            int i39 = 0;
                                            for (int i40 = 0; i40 < spanSize4; i40++) {
                                                i39 += this.k[i40 + i38];
                                            }
                                            i16 = View.MeasureSpec.makeMeasureSpec(Math.max(0, i39), 1073741824);
                                        } else {
                                            i16 = View.MeasureSpec.makeMeasureSpec((this.b * spanSize4) + (Math.max(0, spanSize4 - 1) * (z3 ? this.g : this.f)), 1073741824);
                                        }
                                        VirtualLayoutManager.LayoutParams layoutParams = (VirtualLayoutManager.LayoutParams) view2.getLayoutParams();
                                        if (layoutManagerHelper.getOrientation() == 1) {
                                            layoutManagerHelper.measureChildWithMargins(view2, i16, getMainDirSpec(((ViewGroup.MarginLayoutParams) layoutParams).height, this.c, View.MeasureSpec.getSize(i16), layoutParams.a));
                                        } else {
                                            layoutManagerHelper.measureChildWithMargins(view2, getMainDirSpec(((ViewGroup.MarginLayoutParams) layoutParams).width, this.c, View.MeasureSpec.getSize(i16), layoutParams.a), View.MeasureSpec.getSize(i16));
                                        }
                                        int e3 = cVar.e(view2);
                                        if (e3 > i37) {
                                            i37 = e3;
                                        }
                                        i36++;
                                        cVar = cVar;
                                    }
                                    int mainDirSpec = getMainDirSpec(i37, this.c, 0, Float.NaN);
                                    int i41 = 0;
                                    while (i41 < i3) {
                                        View view3 = this.i[i41];
                                        if (cVar.e(view3) != i37) {
                                            int spanSize5 = getSpanSize(recycler2, state2, layoutManagerHelper.getPosition(view3));
                                            if (z4) {
                                                int i42 = this.j[i41];
                                                int i43 = 0;
                                                for (int i44 = 0; i44 < spanSize5; i44++) {
                                                    i43 += this.k[i44 + i42];
                                                }
                                                i15 = View.MeasureSpec.makeMeasureSpec(Math.max(0, i43), 1073741824);
                                            } else {
                                                i15 = View.MeasureSpec.makeMeasureSpec((this.b * spanSize5) + (Math.max(0, spanSize5 - 1) * (z3 ? this.g : this.f)), 1073741824);
                                            }
                                            if (layoutManagerHelper.getOrientation() == 1) {
                                                layoutManagerHelper.measureChildWithMargins(view3, i15, mainDirSpec);
                                            } else {
                                                layoutManagerHelper.measureChildWithMargins(view3, mainDirSpec, i15);
                                            }
                                        }
                                        i41++;
                                        recycler2 = recycler;
                                        state2 = state;
                                    }
                                    if (z2) {
                                        z6 = true;
                                        z5 = isEnableMarginOverLap;
                                        i4 = computeStartSpace(layoutManagerHelper, z3, !layoutManagerHelper.getReverseLayout(), z5);
                                    } else {
                                        z5 = isEnableMarginOverLap;
                                        z6 = true;
                                        i4 = 0;
                                    }
                                    int computeEndSpace = z ? computeEndSpace(layoutManagerHelper, z3, layoutManagerHelper.getReverseLayout() ^ z6, z5) : 0;
                                    s61.a = i37 + i4 + computeEndSpace;
                                    boolean z13 = dVar.f() == -1;
                                    if (!this.l && ((!z || !z13) && (!z2 || z13))) {
                                        s61.a += z3 ? this.f : this.g;
                                    }
                                    if (z3) {
                                        if (dVar.f() == -1) {
                                            int g2 = (dVar.g() - computeEndSpace) - ((this.l || z) ? 0 : this.f);
                                            i7 = g2 - i37;
                                            i6 = g2;
                                        } else {
                                            int g3 = ((this.l || z2) ? 0 : this.f) + dVar.g() + i4;
                                            i6 = g3 + i37;
                                            i7 = g3;
                                        }
                                        i8 = 0;
                                        i5 = 0;
                                    } else if (dVar.f() == -1) {
                                        int g4 = (dVar.g() - computeEndSpace) - ((this.l || z) ? 0 : this.g);
                                        int i45 = g4 - i37;
                                        i7 = 0;
                                        i6 = 0;
                                        i5 = i45;
                                        i8 = g4;
                                    } else {
                                        i5 = ((this.l || z2) ? 0 : this.g) + dVar.g() + i4;
                                        i8 = i5 + i37;
                                        i7 = 0;
                                        i6 = 0;
                                    }
                                    int i46 = 0;
                                    while (i46 < i3) {
                                        View view4 = this.i[i46];
                                        int i47 = this.j[i46];
                                        VirtualLayoutManager.LayoutParams layoutParams2 = (VirtualLayoutManager.LayoutParams) view4.getLayoutParams();
                                        if (z3) {
                                            if (z4) {
                                                i14 = layoutManagerHelper.getPaddingLeft() + this.mMarginLeft + this.mPaddingLeft;
                                                for (int i48 = 0; i48 < i47; i48++) {
                                                    i14 += this.k[i48] + this.g;
                                                }
                                            } else {
                                                i14 = layoutManagerHelper.getPaddingLeft() + this.mMarginLeft + this.mPaddingLeft + (this.b * i47) + (this.g * i47);
                                            }
                                            i10 = i7;
                                            i9 = cVar.f(view4) + i14;
                                            i11 = i6;
                                            i12 = i14;
                                        } else {
                                            if (z4) {
                                                i13 = layoutManagerHelper.getPaddingTop() + this.mMarginTop + this.mPaddingTop;
                                                for (int i49 = 0; i49 < i47; i49++) {
                                                    i13 += this.k[i49] + this.f;
                                                }
                                            } else {
                                                i13 = layoutManagerHelper.getPaddingTop() + this.mMarginTop + this.mPaddingTop + (this.b * i47) + (this.f * i47);
                                            }
                                            i9 = i8;
                                            i10 = i13;
                                            i11 = cVar.f(view4) + i13;
                                            i12 = i5;
                                        }
                                        if (m) {
                                            str2 = str3;
                                            Log.d(str2, "layout item in position: " + layoutParams2.getViewPosition() + " with text " + ((Object) ((TextView) view4).getText()) + " with SpanIndex: " + i47 + " into (" + i12 + AVFSCacheConstants.COMMA_SEP + i10 + AVFSCacheConstants.COMMA_SEP + i9 + AVFSCacheConstants.COMMA_SEP + i11 + " )");
                                        } else {
                                            str2 = str3;
                                        }
                                        layoutChildWithMargin(view4, i12, i10, i9, i11, layoutManagerHelper);
                                        if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                                            s61.c = true;
                                        }
                                        s61.d |= view4.isFocusable();
                                        i46++;
                                        i5 = i12;
                                        i6 = i11;
                                        str3 = str2;
                                        i7 = i10;
                                        i8 = i9;
                                    }
                                    this.l = false;
                                    Arrays.fill(this.i, (Object) null);
                                    Arrays.fill(this.j, 0);
                                    Arrays.fill(this.k, 0);
                                    return;
                                }
                                return;
                            }
                            throw new IllegalArgumentException("Item at position " + c2 + " requires " + spanSize3 + " spans but GridLayoutManager has only " + this.a + " spans.");
                        }
                        if (m) {
                            Log.d("GridLayoutHelper", "pos [" + c2 + "] is out of range");
                        }
                    }
                    str = "GridLayoutHelper";
                    if (i3 == 0) {
                    }
                }
            } else {
                z3 = z10;
                cVar = mainOrientationHelper;
                i3 = 0;
                i2 = 0;
                z2 = false;
                z = false;
                c2 = dVar.c();
                if (!isOutOfRange(c2)) {
                }
                if (m) {
                }
                str = "GridLayoutHelper";
                if (i3 == 0) {
                }
            }
            i23 = i20;
            c2 = dVar.c();
            if (!isOutOfRange(c2)) {
            }
            if (m) {
            }
            str = "GridLayoutHelper";
            if (i3 == 0) {
            }
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
        super.onClear(layoutManagerHelper);
        this.e.d();
    }

    @Override // com.alibaba.android.vlayout.a
    public void onItemsChanged(LayoutManagerHelper layoutManagerHelper) {
        super.onItemsChanged(layoutManagerHelper);
        this.e.d();
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRangeChange(int i2, int i3) {
        this.e.f(i2);
        this.e.d();
    }

    public void setAutoExpand(boolean z) {
        this.d = z;
    }

    public void setHGap(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.g = i2;
    }

    public void setSpanCount(int i2) {
        if (i2 != this.a) {
            if (i2 >= 1) {
                this.a = i2;
                this.e.d();
                ensureSpanCount();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i2);
        }
    }

    public void setVGap(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f = i2;
    }

    public b(int i2, int i3, int i4) {
        this(i2, i3, i4, i4);
    }

    public b(int i2, int i3, int i4, int i5) {
        this.a = 4;
        this.b = 0;
        this.c = 0;
        this.d = true;
        this.e = new a();
        this.f = 0;
        this.g = 0;
        this.h = new float[0];
        this.l = false;
        setSpanCount(i2);
        this.e.e(true);
        setItemCount(i3);
        setVGap(i4);
        setHGap(i5);
    }
}
