package com.alibaba.android.vlayout.layout;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.c;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.android.vlayout.layout.b;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Arrays;
import java.util.Map;
import tb.jl1;
import tb.s61;
import tb.sw1;

/* compiled from: Taobao */
public class f extends BaseLayoutHelper {
    private static boolean d;
    private static final int e = View.MeasureSpec.makeMeasureSpec(0, 0);
    private a a;
    private int b;
    private boolean c;

    /* compiled from: Taobao */
    public static class a extends g<a> {
        private float[] A;
        private View[] B;
        private int[] C;
        private int[] D;
        private float t = Float.NaN;
        private int u = 4;
        private int v = 0;
        private boolean w = true;
        @NonNull
        private b.AbstractC0079b x;
        private int y;
        private int z;

        public a() {
            b.a aVar = new b.a();
            this.x = aVar;
            this.y = 0;
            this.z = 0;
            this.A = new float[0];
            aVar.e(true);
        }

        public static int u0(a aVar, boolean z2) {
            int i;
            int i2;
            int i3;
            int i4;
            if (z2) {
                i2 = aVar.n;
                i = aVar.j;
            } else {
                i2 = aVar.l;
                i = aVar.h;
            }
            int i5 = i2 + i;
            int intValue = aVar.J().e().intValue();
            for (Map.Entry<sw1<Integer>, T> entry : aVar.f.entrySet()) {
                a aVar2 = (a) entry.getValue();
                if (!aVar2.O()) {
                    i5 += u0(aVar2, z2);
                } else if (aVar2.e.e().intValue() == intValue) {
                    if (z2) {
                        i4 = aVar2.n;
                        i3 = aVar2.j;
                    } else {
                        i4 = aVar2.l;
                        i3 = aVar2.h;
                    }
                    return i5 + i4 + i3;
                }
            }
            return i5;
        }

        public static int v0(a aVar, boolean z2) {
            int i;
            int i2;
            int i3;
            int i4;
            if (z2) {
                i2 = -aVar.m;
                i = aVar.i;
            } else {
                i2 = -aVar.k;
                i = aVar.g;
            }
            int i5 = i2 - i;
            int intValue = aVar.J().d().intValue();
            for (Map.Entry<sw1<Integer>, T> entry : aVar.f.entrySet()) {
                a aVar2 = (a) entry.getValue();
                if (!aVar2.O()) {
                    i5 += v0(aVar2, z2);
                } else if (aVar2.e.d().intValue() == intValue) {
                    if (z2) {
                        i4 = -aVar2.m;
                        i3 = aVar2.i;
                    } else {
                        i4 = -aVar2.k;
                        i3 = aVar2.g;
                    }
                    return i5 + (i4 - i3);
                }
            }
            return i5;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void w0() {
            View[] viewArr = this.B;
            if (viewArr == null || viewArr.length != this.u) {
                this.B = new View[this.u];
            }
            int[] iArr = this.C;
            if (iArr == null || iArr.length != this.u) {
                this.C = new int[this.u];
            }
            int[] iArr2 = this.D;
            if (iArr2 == null || iArr2.length != this.u) {
                this.D = new int[this.u];
            }
        }

        private a x0(a aVar, int i) {
            for (Map.Entry<sw1<Integer>, T> entry : aVar.f.entrySet()) {
                a aVar2 = (a) entry.getValue();
                sw1<Integer> key = entry.getKey();
                if (!aVar2.O()) {
                    return x0(aVar2, i);
                }
                if (key.a(Integer.valueOf(i))) {
                    return aVar2;
                }
            }
            return aVar;
        }

        public void A0() {
            this.x.d();
            for (Map.Entry<sw1<Integer>, T> entry : this.f.entrySet()) {
                ((a) entry.getValue()).A0();
            }
        }

        public void B0(float f) {
            this.t = f;
        }

        @Override // com.alibaba.android.vlayout.layout.g
        public void f0(int i, int i2) {
            super.f0(i, i2);
            this.x.f(i);
            this.x.d();
        }

        public a y0(int i) {
            return x0(this, i);
        }

        public float z0() {
            return this.t;
        }
    }

    private void a(a aVar, RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, boolean z, LayoutManagerHelper layoutManagerHelper) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        if (z) {
            i3 = i;
            i4 = 0;
            i5 = 1;
        } else {
            i4 = i - 1;
            i3 = -1;
            i5 = -1;
        }
        if (layoutManagerHelper.getOrientation() != 1 || !layoutManagerHelper.isDoLayoutRTL()) {
            i6 = 1;
        } else {
            i7 = i2 - 1;
            i6 = -1;
        }
        while (i4 != i3) {
            int f = f(aVar.x, recycler, state, layoutManagerHelper.getPosition(aVar.B[i4]));
            if (i6 != -1 || f <= 1) {
                aVar.C[i4] = i7;
            } else {
                aVar.C[i4] = i7 - (f - 1);
            }
            i7 += f * i6;
            i4 += i5;
        }
    }

    private int d(a aVar, int i, int i2, int i3, float f) {
        if (!Float.isNaN(f) && f > 0.0f && i3 > 0) {
            return View.MeasureSpec.makeMeasureSpec((int) ((((float) i3) / f) + 0.5f), 1073741824);
        }
        if (!Float.isNaN(aVar.t) && aVar.t > 0.0f) {
            return View.MeasureSpec.makeMeasureSpec((int) ((((float) i2) / aVar.t) + 0.5f), 1073741824);
        }
        if (i < 0) {
            return e;
        }
        return View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    private int e(b.AbstractC0079b bVar, int i, RecyclerView.Recycler recycler, RecyclerView.State state, int i2) {
        if (!state.isPreLayout()) {
            return bVar.a(i2, i);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i2);
        if (convertPreLayoutPositionToPostLayout == -1) {
            return 0;
        }
        return bVar.a(convertPreLayoutPositionToPostLayout, i);
    }

    private int f(b.AbstractC0079b bVar, RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return bVar.c(i);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            return 0;
        }
        return bVar.c(convertPreLayoutPositionToPostLayout);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void adjustLayout(int i, int i2, LayoutManagerHelper layoutManagerHelper) {
        this.a.a(i, i2, layoutManagerHelper);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void afterLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        this.a.b(recycler, state, i, i2, i3, layoutManagerHelper);
    }

    public int b(LayoutManagerHelper layoutManagerHelper) {
        int o;
        int s;
        a y0 = this.a.y0(getRange().e().intValue());
        if (layoutManagerHelper.getOrientation() == 1) {
            o = y0.m();
            s = y0.q();
        } else {
            o = y0.o();
            s = y0.s();
        }
        return o + s;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void beforeLayout(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutManagerHelper layoutManagerHelper) {
        this.a.c(recycler, state, layoutManagerHelper);
    }

    public int c(LayoutManagerHelper layoutManagerHelper) {
        int n;
        int r;
        a y0 = this.a.y0(getRange().d().intValue());
        if (layoutManagerHelper.getOrientation() == 1) {
            n = y0.p();
            r = y0.t();
        } else {
            n = y0.n();
            r = y0.r();
        }
        return n + r;
    }

    @Override // com.alibaba.android.vlayout.a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        if (state.getItemCount() > 0) {
            a y0 = this.a.y0(cVar.a);
            int a2 = y0.x.a(cVar.a, y0.u);
            if (!cVar.c) {
                while (a2 > 0) {
                    int i = cVar.a;
                    if (i <= 0) {
                        break;
                    }
                    cVar.a = i - 1;
                    a2 = y0.x.a(cVar.a, y0.u);
                }
            } else {
                while (a2 < y0.u - 1 && cVar.a < getRange().e().intValue()) {
                    cVar.a++;
                    a2 = y0.x.a(cVar.a, y0.u);
                }
            }
            this.c = true;
        }
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        boolean z3 = layoutManagerHelper.getOrientation() == 1;
        if (z) {
            if (i == getItemCount() - 1) {
                return a.u0(this.a, z3);
            }
        } else if (i == 0) {
            return a.v0(this.a, z3);
        }
        return super.computeAlignOffset(i, z, z2, layoutManagerHelper);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public float getAspectRatio() {
        return this.a.z0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03c3, code lost:
        r27 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x03c5, code lost:
        r28 = r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0380 A[LOOP:2: B:63:0x0208->B:124:0x0380, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x03cf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0815  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x081d  */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x08b9  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x0912  */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x091a  */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x093a  */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x095a  */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x022c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x03c7 A[EDGE_INSN: B:396:0x03c7->B:129:0x03c7 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x024d  */
    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper) {
        c cVar;
        boolean z;
        boolean z2;
        String str;
        String str2;
        int i;
        boolean z3;
        int i2;
        boolean z4;
        boolean z5;
        int i3;
        int i4;
        boolean z6;
        boolean z7;
        int i5;
        int i6;
        boolean z8;
        String str3;
        int i7;
        int i8;
        int i9;
        boolean z9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z10;
        int i23;
        int i24;
        c cVar2;
        int i25;
        s61 s612;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        int i41;
        boolean z11;
        boolean z12;
        boolean z13;
        int i42;
        View view;
        int i43;
        int i44;
        int i45;
        int c2;
        int f;
        View l;
        boolean z14;
        boolean z15;
        RecyclerView.State state2 = state;
        VirtualLayoutManager.d dVar2 = dVar;
        if (!isOutOfRange(dVar.c())) {
            int c3 = dVar.c();
            a y0 = this.a.y0(c3);
            int e2 = dVar.e();
            boolean z16 = e2 == 1;
            c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            boolean z17 = layoutManagerHelper.getOrientation() == 1;
            if (z17) {
                int contentWidth = (((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight()) - layoutManagerHelper.getPaddingLeft()) - y0.k()) - y0.l();
                this.b = contentWidth;
                y0.v = (int) (((((float) (contentWidth - ((y0.u - 1) * y0.z))) * 1.0f) / ((float) y0.u)) + 0.5f);
            } else {
                int contentHeight = (((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingBottom()) - layoutManagerHelper.getPaddingTop()) - y0.u()) - y0.v();
                this.b = contentHeight;
                y0.v = (int) (((((float) (contentHeight - ((y0.u - 1) * y0.y))) * 1.0f) / ((float) y0.u)) + 0.5f);
            }
            int i46 = y0.u;
            y0.w0();
            if (!z16) {
                str2 = " requires ";
                str = " spans.";
                z = z17;
                cVar = mainOrientationHelper;
                int e3 = e(y0.x, y0.u, recycler, state, c3);
                int f2 = f(y0.x, recycler, state2, c3) + e3;
                if (e3 != y0.u - 1) {
                    int c4 = dVar.c();
                    int i47 = y0.u - f2;
                    boolean z18 = false;
                    i2 = 0;
                    int i48 = 0;
                    z2 = false;
                    while (true) {
                        if (i48 >= y0.u || i47 <= 0) {
                            break;
                        }
                        c4 -= e2;
                        if (y0.R(c4)) {
                            break;
                        }
                        int f3 = f(y0.x, recycler, state2, c4);
                        if (f3 <= y0.u) {
                            View m = dVar2.m(recycler, c4);
                            if (m == null) {
                                break;
                            }
                            if (!z18) {
                                z18 = layoutManagerHelper.getReverseLayout() ? false : false;
                                z18 = true;
                            }
                            if (!z2) {
                                boolean reverseLayout = layoutManagerHelper.getReverseLayout();
                                z15 = z18;
                                a aVar = this.a;
                                z2 = !reverseLayout ? c4 == aVar.J().e().intValue() : c4 == aVar.J().d().intValue();
                            } else {
                                z15 = z18;
                            }
                            i47 -= f3;
                            if (i47 < 0) {
                                break;
                            }
                            i2 += f3;
                            y0.B[i48] = m;
                            i48++;
                            e2 = e2;
                            z18 = z15;
                        } else {
                            throw new IllegalArgumentException("Item at position " + c4 + str2 + f3 + " spans but RangeGridLayoutHelper has only " + y0.u + str);
                        }
                    }
                    z15 = z18;
                    if (i48 > 0) {
                        int i49 = 0;
                        for (int i50 = i48 - 1; i49 < i50; i50--) {
                            View view2 = y0.B[i49];
                            y0.B[i49] = y0.B[i50];
                            y0.B[i50] = view2;
                            i49++;
                        }
                    }
                    i = i48;
                    i46 = f2;
                    z3 = z15;
                    z5 = false;
                    z4 = false;
                    while (true) {
                        if (i >= y0.u || !dVar2.h(state2) || i46 <= 0) {
                            break;
                        }
                        c2 = dVar.c();
                        if (y0.R(c2)) {
                            i4 = i;
                            f = f(y0.x, recycler, state2, c2);
                            if (f <= y0.u) {
                                i46 -= f;
                                if (i46 < 0) {
                                    break;
                                }
                                if (!z3) {
                                    z3 = layoutManagerHelper.getReverseLayout() ? false : false;
                                    z3 = true;
                                }
                                if (!z5 && !y0.equals(this.a)) {
                                    z5 = layoutManagerHelper.getReverseLayout() ? false : false;
                                    z5 = true;
                                }
                                if (!z2) {
                                    if (layoutManagerHelper.getReverseLayout()) {
                                        z14 = false;
                                        z2 = z14;
                                    } else {
                                        z14 = false;
                                        z2 = z14;
                                    }
                                    z14 = true;
                                    z2 = z14;
                                }
                                if (!z4 && !y0.equals(this.a)) {
                                    if (layoutManagerHelper.getReverseLayout()) {
                                        z4 = false;
                                        if (d) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("isSecondEndLineLogic:");
                                            sb.append(z4);
                                            i3 = i46;
                                            sb.append("  helper.getReverseLayout()=");
                                            sb.append(layoutManagerHelper.getReverseLayout());
                                            sb.append(" pos=");
                                            sb.append(c2);
                                            sb.append(" rangeStyle.getRange().getLower()=");
                                            sb.append(y0.J().d());
                                            sb.append(" rangeStyle.getRange().getUpper()=");
                                            sb.append(y0.J().e());
                                            Log.d("RGLayoutHelper", sb.toString());
                                            l = dVar2.l(recycler);
                                            if (l != null) {
                                                break;
                                            }
                                            i2 += f;
                                            y0.B[i4] = l;
                                            i = i4 + 1;
                                            state2 = state;
                                            c3 = c3;
                                            str = str;
                                            str2 = str2;
                                            i46 = i3;
                                        }
                                    } else {
                                        z4 = false;
                                        if (d) {
                                        }
                                    }
                                    z4 = true;
                                    if (d) {
                                    }
                                }
                                i3 = i46;
                                l = dVar2.l(recycler);
                                if (l != null) {
                                }
                            } else {
                                throw new IllegalArgumentException("Item at position " + c2 + str2 + f + " spans but GridLayoutManager has only " + y0.u + str);
                            }
                        } else if (d) {
                            StringBuilder sb2 = new StringBuilder();
                            i4 = i;
                            sb2.append("pos [");
                            sb2.append(c2);
                            sb2.append("] is out of range");
                            Log.d("RGLayoutHelper", sb2.toString());
                        }
                    }
                    boolean z19 = z5;
                    if (i4 == 0) {
                        a(y0, recycler, state, i4, i2, z16, layoutManagerHelper);
                        if (i3 <= 0 || i4 != i2 || !y0.w) {
                            z6 = z;
                            if (!z16 && i3 == 0 && i4 == i2 && y0.w) {
                                if (z6) {
                                    y0.v = (this.b - ((i4 - 1) * y0.z)) / i4;
                                } else {
                                    y0.v = (this.b - ((i4 - 1) * y0.y)) / i4;
                                }
                            }
                        } else {
                            z6 = z;
                            if (z6) {
                                y0.v = (this.b - ((i4 - 1) * y0.z)) / i4;
                            } else {
                                y0.v = (this.b - ((i4 - 1) * y0.y)) / i4;
                            }
                        }
                        if (y0.A == null || y0.A.length <= 0) {
                            z7 = false;
                        } else {
                            if (z6) {
                                i45 = this.b;
                                i44 = i4 - 1;
                                i43 = y0.z;
                            } else {
                                i45 = this.b;
                                i44 = i4 - 1;
                                i43 = y0.y;
                            }
                            int i51 = i45 - (i44 * i43);
                            int i52 = (i3 <= 0 || !y0.w) ? y0.u : i4;
                            int i53 = i51;
                            int i54 = 0;
                            for (int i55 = 0; i55 < i52; i55++) {
                                if (i55 >= y0.A.length || Float.isNaN(y0.A[i55]) || y0.A[i55] < 0.0f) {
                                    i54++;
                                    y0.D[i55] = -1;
                                } else {
                                    y0.D[i55] = (int) ((((y0.A[i55] * 1.0f) / 100.0f) * ((float) i51)) + 0.5f);
                                    i53 -= y0.D[i55];
                                }
                            }
                            if (i54 > 0) {
                                int i56 = i53 / i54;
                                for (int i57 = 0; i57 < i52; i57++) {
                                    if (y0.D[i57] < 0) {
                                        y0.D[i57] = i56;
                                    }
                                }
                            }
                            z7 = true;
                        }
                        int i58 = 0;
                        int i59 = 0;
                        while (i59 < i4) {
                            View view3 = y0.B[i59];
                            layoutManagerHelper.addChildView(dVar2, view3, z16 ? -1 : 0);
                            int f4 = f(y0.x, recycler, state, layoutManagerHelper.getPosition(view3));
                            if (z7) {
                                int i60 = y0.C[i59];
                                int i61 = 0;
                                for (int i62 = 0; i62 < f4; i62++) {
                                    i61 += y0.D[i62 + i60];
                                }
                                i41 = View.MeasureSpec.makeMeasureSpec(Math.max(0, i61), 1073741824);
                            } else {
                                i41 = View.MeasureSpec.makeMeasureSpec((y0.v * f4) + (Math.max(0, f4 - 1) * (z6 ? y0.z : y0.y)), 1073741824);
                            }
                            VirtualLayoutManager.LayoutParams layoutParams = (VirtualLayoutManager.LayoutParams) view3.getLayoutParams();
                            if (layoutManagerHelper.getOrientation() == 1) {
                                z11 = z19;
                                z12 = z6;
                                view = view3;
                                z13 = z7;
                                i42 = i58;
                                layoutManagerHelper.measureChildWithMargins(view, i41, d(y0, ((ViewGroup.MarginLayoutParams) layoutParams).height, this.b, View.MeasureSpec.getSize(i41), layoutParams.a));
                            } else {
                                z12 = z6;
                                z11 = z19;
                                z13 = z7;
                                view = view3;
                                i42 = i58;
                                layoutManagerHelper.measureChildWithMargins(view, d(y0, ((ViewGroup.MarginLayoutParams) layoutParams).width, this.b, View.MeasureSpec.getSize(i41), layoutParams.a), View.MeasureSpec.getSize(i41));
                            }
                            int e4 = cVar.e(view);
                            i58 = e4 > i42 ? e4 : i42;
                            i59++;
                            dVar2 = dVar;
                            cVar = cVar;
                            z7 = z13;
                            z6 = z12;
                            z19 = z11;
                        }
                        int d2 = d(y0, i58, this.b, 0, Float.NaN);
                        for (int i63 = 0; i63 < i4; i63++) {
                            View view4 = y0.B[i63];
                            if (cVar.e(view4) != i58) {
                                int f5 = f(y0.x, recycler, state, layoutManagerHelper.getPosition(view4));
                                if (z7) {
                                    int i64 = y0.C[i63];
                                    int i65 = 0;
                                    for (int i66 = 0; i66 < f5; i66++) {
                                        i65 += y0.D[i66 + i64];
                                    }
                                    i40 = View.MeasureSpec.makeMeasureSpec(Math.max(0, i65), 1073741824);
                                } else {
                                    i40 = View.MeasureSpec.makeMeasureSpec((y0.v * f5) + (Math.max(0, f5 - 1) * (z6 ? y0.z : y0.y)), 1073741824);
                                }
                                if (layoutManagerHelper.getOrientation() == 1) {
                                    layoutManagerHelper.measureChildWithMargins(view4, i40, d2);
                                } else {
                                    layoutManagerHelper.measureChildWithMargins(view4, d2, i40);
                                }
                            }
                        }
                        boolean z20 = z6;
                        int computeStartSpace = z3 ? computeStartSpace(layoutManagerHelper, z20, dVar.f() == 1, layoutManagerHelper.isEnableMarginOverLap()) : 0;
                        if (z19) {
                            if (z20) {
                                i39 = y0.C();
                                i38 = y0.I();
                            } else {
                                i39 = y0.A();
                                i38 = y0.G();
                            }
                            i5 = i39 + i38;
                        } else {
                            i5 = 0;
                        }
                        if (z2) {
                            a aVar2 = this.a;
                            if (z20) {
                                i37 = aVar2.z();
                                i36 = this.a.F();
                            } else {
                                i37 = aVar2.B();
                                i36 = this.a.H();
                            }
                            i6 = i37 + i36;
                            z8 = z4;
                        } else {
                            z8 = z4;
                            i6 = 0;
                        }
                        if (z8) {
                            if (z20) {
                                i35 = y0.z();
                                i34 = y0.F();
                            } else {
                                i35 = y0.B();
                                i34 = y0.H();
                            }
                            i8 = i35 + i34;
                            if (d) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("isSecondEndLineLogic:");
                                sb3.append(z8);
                                sb3.append(" pos=");
                                i7 = c3;
                                sb3.append(i7);
                                sb3.append(" secondEndSpace=");
                                sb3.append(i8);
                                str3 = "RGLayoutHelper";
                                Log.d(str3, sb3.toString());
                            } else {
                                i7 = c3;
                                str3 = "RGLayoutHelper";
                            }
                        } else {
                            i7 = c3;
                            str3 = "RGLayoutHelper";
                            i8 = 0;
                        }
                        s61.a = i58 + computeStartSpace + i6 + i5 + i8;
                        boolean z21 = dVar.f() == -1;
                        c cVar3 = cVar;
                        String str4 = "⬆ ";
                        if (!this.c) {
                            if (z21) {
                                i10 = i6;
                                i9 = i5;
                                if (!z2) {
                                    if (z8) {
                                        a aVar3 = (a) y0.b;
                                        i33 = z20 ? aVar3.y : aVar3.z;
                                        if (d) {
                                            StringBuilder sb4 = new StringBuilder();
                                            sb4.append(str4);
                                            sb4.append(i7);
                                            z9 = z8;
                                            sb4.append(" 3 ");
                                            sb4.append(i33);
                                            sb4.append(" gap");
                                            Log.d(str3, sb4.toString());
                                        }
                                    } else {
                                        z9 = z8;
                                        i33 = z20 ? y0.y : y0.z;
                                        if (d) {
                                            Log.d(str3, str4 + i7 + " 4 " + i33 + " gap");
                                        }
                                    }
                                    i11 = i33;
                                    i12 = s61.a + i11;
                                    s61.a = i12;
                                    if (i12 <= 0) {
                                    }
                                    if (!dVar.k()) {
                                    }
                                    i13 = 0;
                                    if (d) {
                                    }
                                    if (!z20) {
                                    }
                                    i22 = 0;
                                    while (i22 < i21) {
                                    }
                                    this.c = false;
                                    Arrays.fill(y0.B, (Object) null);
                                    Arrays.fill(y0.C, 0);
                                    Arrays.fill(y0.D, 0);
                                    return;
                                }
                                z9 = z8;
                            } else if (z3) {
                                i10 = i6;
                                i9 = i5;
                                z9 = z8;
                            } else if (z19) {
                                i9 = i5;
                                a aVar4 = (a) y0.b;
                                int i67 = z20 ? aVar4.y : aVar4.z;
                                if (d) {
                                    i10 = i6;
                                    Log.d(str3, "⬇ " + i7 + " 1 " + i67 + " gap");
                                } else {
                                    i10 = i6;
                                }
                                z9 = z8;
                                i11 = i67;
                                i12 = s61.a + i11;
                                s61.a = i12;
                                if (i12 <= 0) {
                                    s61.a = 0;
                                }
                                if (!dVar.k()) {
                                    if (z21) {
                                        int i68 = i7 + 1;
                                        if (!isOutOfRange(i68)) {
                                            a y02 = this.a.y0(i68);
                                            if (y02.P(i68)) {
                                                if (z20) {
                                                    i32 = y02.C();
                                                    i31 = y02.I();
                                                } else {
                                                    i32 = y02.A();
                                                    i31 = y02.G();
                                                }
                                                i30 = i32 + i31;
                                                if (d) {
                                                    Log.d(str3, str4 + i7 + " 1 " + i30 + " last");
                                                }
                                            }
                                        }
                                        i30 = 0;
                                    } else {
                                        int i69 = i7 - 1;
                                        if (!isOutOfRange(i69)) {
                                            a y03 = this.a.y0(i69);
                                            if (y03.Q(i69)) {
                                                if (z20) {
                                                    i29 = y03.z();
                                                    i28 = y03.F();
                                                } else {
                                                    i29 = y03.B();
                                                    i28 = y03.H();
                                                }
                                                i30 = i29 + i28;
                                                if (d) {
                                                    Log.d(str3, "⬇ " + i7 + " 2 " + i30 + " last");
                                                }
                                            }
                                        }
                                    }
                                    i13 = i30;
                                    if (d) {
                                        StringBuilder sb5 = new StringBuilder();
                                        if (!z21) {
                                            str4 = "⬇ ";
                                        }
                                        sb5.append(str4);
                                        sb5.append(i7);
                                        sb5.append(" consumed ");
                                        sb5.append(s61.a);
                                        sb5.append(" startSpace ");
                                        sb5.append(computeStartSpace);
                                        sb5.append(" endSpace ");
                                        i16 = i10;
                                        sb5.append(i16);
                                        sb5.append(" secondStartSpace ");
                                        i14 = i9;
                                        sb5.append(i14);
                                        sb5.append(" secondEndSpace ");
                                        i15 = i8;
                                        sb5.append(i15);
                                        sb5.append(" lastUnconsumedSpace ");
                                        sb5.append(i13);
                                        sb5.append(" isSecondEndLine=");
                                        sb5.append(z9);
                                        Log.d(str3, sb5.toString());
                                    } else {
                                        i15 = i8;
                                        i14 = i9;
                                        i16 = i10;
                                    }
                                    if (!z20) {
                                        if (z21) {
                                            i20 = ((dVar.g() - i16) - i11) - i13;
                                            i17 = i20 - i58;
                                        } else {
                                            int g = dVar.g() + computeStartSpace + i11 + i13;
                                            i17 = g;
                                            i20 = g + i58;
                                        }
                                        i19 = 0;
                                        i18 = 0;
                                    } else if (z21) {
                                        int g2 = (((dVar.g() - i16) - i15) - i11) - i13;
                                        i19 = g2 - i58;
                                        i18 = g2;
                                        i20 = 0;
                                        i17 = 0;
                                    } else {
                                        int g3 = dVar.g() + computeStartSpace + i14 + i11 + i13;
                                        i18 = g3 + i58;
                                        i17 = 0;
                                        i19 = g3;
                                        i20 = 0;
                                    }
                                    i22 = 0;
                                    for (i21 = i4; i22 < i21; i21 = i21) {
                                        View view5 = y0.B[i22];
                                        int i70 = y0.C[i22];
                                        VirtualLayoutManager.LayoutParams layoutParams2 = (VirtualLayoutManager.LayoutParams) view5.getLayoutParams();
                                        if (z20) {
                                            if (z7) {
                                                i27 = layoutManagerHelper.getPaddingLeft() + y0.n() + y0.r();
                                                for (int i71 = 0; i71 < i70; i71++) {
                                                    i27 += y0.D[i71] + y0.z;
                                                }
                                            } else {
                                                i27 = layoutManagerHelper.getPaddingLeft() + y0.n() + y0.r() + (y0.v * i70) + (y0.z * i70);
                                            }
                                            int f6 = i27 + cVar3.f(view5);
                                            z10 = z20;
                                            i23 = i27;
                                            i25 = i18;
                                            cVar2 = cVar3;
                                            i24 = f6;
                                        } else {
                                            cVar2 = cVar3;
                                            if (z7) {
                                                i19 = layoutManagerHelper.getPaddingTop() + y0.p() + y0.t();
                                                i26 = i20;
                                                for (int i72 = 0; i72 < i70; i72++) {
                                                    i19 += y0.D[i72] + y0.y;
                                                }
                                            } else {
                                                i26 = i20;
                                                i19 = (y0.y * i70) + layoutManagerHelper.getPaddingTop() + y0.p() + y0.t() + (y0.v * i70);
                                            }
                                            i25 = cVar2.f(view5) + i19;
                                            z10 = z20;
                                            i23 = i17;
                                            i24 = i26;
                                        }
                                        cVar3 = cVar2;
                                        if (d) {
                                            Log.d(str3, "layout item in position: " + layoutParams2.getViewPosition() + " with text with SpanIndex: " + i70 + " into (" + i23 + AVFSCacheConstants.COMMA_SEP + i19 + AVFSCacheConstants.COMMA_SEP + i24 + AVFSCacheConstants.COMMA_SEP + i25 + "), topInfo=[layoutState.getOffset()=" + dVar.g() + " startSpace=" + computeStartSpace + " secondStartSpace=" + i14 + " consumedGap=" + i11 + " lastUnconsumedSpace=" + i13 + jl1.ARRAY_END_STR);
                                        }
                                        y0.U(view5, i23, i19, i24, i25, layoutManagerHelper, false);
                                        if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                                            s612 = s61;
                                            s612.c = true;
                                        } else {
                                            s612 = s61;
                                        }
                                        s612.d |= view5.isFocusable();
                                        i22++;
                                        i17 = i23;
                                        i18 = i25;
                                        i19 = i19;
                                        z20 = z10;
                                        str3 = str3;
                                        i20 = i24;
                                        i14 = i14;
                                    }
                                    this.c = false;
                                    Arrays.fill(y0.B, (Object) null);
                                    Arrays.fill(y0.C, 0);
                                    Arrays.fill(y0.D, 0);
                                    return;
                                }
                                i13 = 0;
                                if (d) {
                                }
                                if (!z20) {
                                }
                                i22 = 0;
                                while (i22 < i21) {
                                }
                                this.c = false;
                                Arrays.fill(y0.B, (Object) null);
                                Arrays.fill(y0.C, 0);
                                Arrays.fill(y0.D, 0);
                                return;
                            } else {
                                i10 = i6;
                                i9 = i5;
                                i33 = z20 ? y0.y : y0.z;
                                if (d) {
                                    Log.d(str3, "⬇ " + i7 + " 2 " + i33 + " gap");
                                }
                            }
                            z9 = z8;
                            i11 = i33;
                            i12 = s61.a + i11;
                            s61.a = i12;
                            if (i12 <= 0) {
                            }
                            if (!dVar.k()) {
                            }
                            i13 = 0;
                            if (d) {
                            }
                            if (!z20) {
                            }
                            i22 = 0;
                            while (i22 < i21) {
                            }
                            this.c = false;
                            Arrays.fill(y0.B, (Object) null);
                            Arrays.fill(y0.C, 0);
                            Arrays.fill(y0.D, 0);
                            return;
                        }
                        z9 = z8;
                        i10 = i6;
                        i9 = i5;
                        i11 = 0;
                        i12 = s61.a + i11;
                        s61.a = i12;
                        if (i12 <= 0) {
                        }
                        if (!dVar.k()) {
                        }
                        i13 = 0;
                        if (d) {
                        }
                        if (!z20) {
                        }
                        i22 = 0;
                        while (i22 < i21) {
                        }
                        this.c = false;
                        Arrays.fill(y0.B, (Object) null);
                        Arrays.fill(y0.C, 0);
                        Arrays.fill(y0.D, 0);
                        return;
                    }
                    return;
                }
                i46 = f2;
            } else {
                str2 = " requires ";
                str = " spans.";
                z = z17;
                cVar = mainOrientationHelper;
            }
            z5 = false;
            z4 = false;
            i2 = 0;
            z3 = false;
            i = 0;
            z2 = false;
            while (true) {
                c2 = dVar.c();
                if (y0.R(c2)) {
                }
                i2 += f;
                y0.B[i4] = l;
                i = i4 + 1;
                state2 = state;
                c3 = c3;
                str = str;
                str2 = str2;
                i46 = i3;
            }
            boolean z192 = z5;
            if (i4 == 0) {
            }
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
        super.onClear(layoutManagerHelper);
        this.a.V(layoutManagerHelper);
        this.a.A0();
    }

    @Override // com.alibaba.android.vlayout.a
    public void onItemsChanged(LayoutManagerHelper layoutManagerHelper) {
        super.onItemsChanged(layoutManagerHelper);
        this.a.A0();
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRangeChange(int i, int i2) {
        this.a.f0(i, i2);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public boolean requireLayoutView() {
        return this.a.Y();
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setAspectRatio(float f) {
        this.a.B0(f);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setBgColor(int i) {
        this.a.Z(i);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setLayoutViewBindListener(BaseLayoutHelper.LayoutViewBindListener layoutViewBindListener) {
        this.a.a0(layoutViewBindListener);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setLayoutViewHelper(BaseLayoutHelper.a aVar) {
        this.a.b0(aVar);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setLayoutViewUnBindListener(BaseLayoutHelper.LayoutViewUnBindListener layoutViewUnBindListener) {
        this.a.c0(layoutViewUnBindListener);
    }

    @Override // com.alibaba.android.vlayout.layout.d
    public void setMargin(int i, int i2, int i3, int i4) {
        super.setMargin(i, i2, i3, i4);
        this.a.d0(i, i2, i3, i4);
    }

    @Override // com.alibaba.android.vlayout.layout.d
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        this.a.e0(i, i2, i3, i4);
    }
}
