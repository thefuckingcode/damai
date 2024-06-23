package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.view.DXNativeGridLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import java.util.Iterator;
import tb.d00;
import tb.ly;

/* compiled from: Taobao */
public class e extends d {
    public static final long DXGRIDLAYOUT_MAXCOLCOUNT = -7092152831124183944L;
    public static final long DXGRIDLAYOUT_MAXROWCOUNT = -8743048525866445678L;
    public static final long DXGRIDLAYOUT_MINCOLCOUNT = -787266499800216458L;
    public static final long DXGRIDLAYOUT_MINROWCOUNT = -2438162194542478192L;
    public static final long DXGRIDLAYOUT_ORIENTATION = -7199229155167727177L;
    public static final int DXGRIDLAYOUT_ORIENTATION_HORIZONTAL = 0;
    public static final int DXGRIDLAYOUT_ORIENTATION_VERTICAL = 1;
    public static final long DX_GRID_LAYOUT = 7789579202915247118L;
    public static final long DX_GRID_LAYOUT_COLUMN_COUNT = 4480460401770252962L;
    public static final long DX_GRID_LAYOUT_COLUMN_SPACING = -7076735627431451296L;
    public static final long DX_GRID_LAYOUT_ITEM_HEIGHT = -889779179579457774L;
    public static final long DX_GRID_LAYOUT_ITEM_WIDTH = -5480582194049152328L;
    public static final long DX_GRID_LAYOUT_LINE_COLOR = -1442755333969665872L;
    public static final long DX_GRID_LAYOUT_LINE_WIDTH = -1442710627541559887L;
    public static final long DX_GRID_LAYOUT_NEED_SEPARATOR = -7975214338005072550L;
    public static final long DX_GRID_LAYOUT_ROW_COUNT = 6173497815537313897L;
    public static final long DX_GRID_LAYOUT_ROW_SPACING = -5965488911581852121L;
    private int c = 0;
    private int d;
    private int e;
    private int f;
    private int g = -8421505;
    private int h = d00.j(DinamicXEngine.i(), "0.5np", 0);
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m;
    private float[] n;
    private int o = 0;
    private int p = -1;
    private int q = -1;
    private int r = -1;
    private int s = -1;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new e();
        }
    }

    private int f() {
        int i2 = 0;
        for (int i3 = 0; i3 < getVirtualChildCount(); i3++) {
            i2 += i(getVirtualChildAt(i3));
        }
        return i2;
    }

    private int g() {
        int i2 = 0;
        for (int i3 = 0; i3 < getVirtualChildCount(); i3++) {
            i2 += h(getVirtualChildAt(i3));
        }
        return i2;
    }

    private int h(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode instanceof ly) {
            return ((ly) dXWidgetNode).f();
        }
        return 1;
    }

    private int i(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode instanceof ly) {
            return ((ly) dXWidgetNode).g();
        }
        return 1;
    }

    private void j(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        if (this.c <= 0 || this.f <= 0 || this.e <= 0) {
            this.n = null;
            return;
        }
        int virtualChildCount = getVirtualChildCount();
        int i13 = 0;
        for (int i14 = 0; i14 < virtualChildCount; i14++) {
            DXWidgetNode virtualChildAt = getVirtualChildAt(i14);
            int i15 = this.c;
            int i16 = i13 / i15;
            int i17 = i13 % i15;
            if (i17 > 0 && h(virtualChildAt) + i17 > (i12 = this.c)) {
                i13 += i12 - i17;
                i16++;
                if (i16 <= this.k) {
                    i17 = 0;
                } else {
                    return;
                }
            }
            i13 += h(virtualChildAt);
            int i18 = (this.e * i16) + (i16 * this.m) + this.paddingTop;
            int i19 = (this.f * i17) + (i17 * this.d) + this.paddingLeft;
            int h2 = h(virtualChildAt);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 2)) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                int i20 = virtualChildAt.layoutGravity;
                if (i20 == 0 && (virtualChildAt.propertyInitFlag & 1) == 0) {
                    i20 = this.childGravity;
                }
                int absoluteGravity = DXWidgetNode.getAbsoluteGravity(i20, getDirection());
                switch (absoluteGravity) {
                    case 3:
                    case 4:
                    case 5:
                        i10 = ((((this.f * h2) + ((h2 - 1) * this.d)) - measuredWidth) / 2) + virtualChildAt.getLeftMarginWithDirection();
                        i11 = virtualChildAt.getRightMarginWithDirection();
                        i6 = i19 + (i10 - i11);
                        break;
                    case 6:
                    case 7:
                    case 8:
                        i10 = ((this.f * h2) + ((h2 - 1) * this.d)) - measuredWidth;
                        i11 = virtualChildAt.getRightMarginWithDirection();
                        i6 = i19 + (i10 - i11);
                        break;
                    default:
                        i6 = i19 + virtualChildAt.getLeftMarginWithDirection();
                        break;
                }
                if (absoluteGravity != 1) {
                    if (absoluteGravity != 2) {
                        if (absoluteGravity != 4) {
                            if (absoluteGravity != 5) {
                                if (absoluteGravity != 7) {
                                    if (absoluteGravity != 8) {
                                        i9 = virtualChildAt.marginTop;
                                        int i21 = i18 + i9;
                                        virtualChildAt.layout(i6, i21, measuredWidth + i6, measuredHeight + i21);
                                    }
                                }
                            }
                        }
                    }
                    i8 = this.e - measuredHeight;
                    i7 = virtualChildAt.marginBottom;
                    i9 = i8 - i7;
                    int i212 = i18 + i9;
                    virtualChildAt.layout(i6, i212, measuredWidth + i6, measuredHeight + i212);
                }
                i8 = ((this.e - measuredHeight) / 2) + virtualChildAt.marginTop;
                i7 = virtualChildAt.marginBottom;
                i9 = i8 - i7;
                int i2122 = i18 + i9;
                virtualChildAt.layout(i6, i2122, measuredWidth + i6, measuredHeight + i2122);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cd  */
    private void k(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (this.j <= 0 || this.f <= 0 || this.e <= 0) {
            this.n = null;
            return;
        }
        int virtualChildCount = getVirtualChildCount();
        int i11 = 0;
        for (int i12 = 0; i12 < virtualChildCount; i12++) {
            DXWidgetNode virtualChildAt = getVirtualChildAt(i12);
            int i13 = this.j;
            int i14 = i11 / i13;
            int i15 = i11 % i13;
            if (i15 > 0 && i(virtualChildAt) + i15 > (i10 = this.j)) {
                i11 += i10 - i15;
                i14++;
                if (i14 <= this.l) {
                    i15 = 0;
                } else {
                    return;
                }
            }
            i11 += i(virtualChildAt);
            int i16 = (this.e * i15) + (i15 * this.m) + this.paddingTop;
            int i17 = (this.f * i14) + (i14 * this.d) + this.paddingLeft;
            int i18 = i(virtualChildAt);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 2)) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                int i19 = virtualChildAt.layoutGravity;
                if (i19 == 0 && (virtualChildAt.propertyInitFlag & 1) == 0) {
                    i19 = this.childGravity;
                }
                int absoluteGravity = DXWidgetNode.getAbsoluteGravity(i19, getDirection());
                if (absoluteGravity != 1) {
                    if (absoluteGravity != 2) {
                        if (absoluteGravity != 4) {
                            if (absoluteGravity != 5) {
                                if (absoluteGravity != 7) {
                                    if (absoluteGravity != 8) {
                                        i6 = i16 + virtualChildAt.getMarginTop();
                                        switch (absoluteGravity) {
                                            case 3:
                                            case 4:
                                            case 5:
                                                i7 = (((this.f - measuredWidth) / 2) + virtualChildAt.marginLeft) - virtualChildAt.marginRight;
                                                i17 += i7;
                                                break;
                                            case 6:
                                            case 7:
                                            case 8:
                                                i6 += (this.f - measuredWidth) - virtualChildAt.getRightMarginWithDirection();
                                                break;
                                            default:
                                                i7 = virtualChildAt.getLeftMarginWithDirection();
                                                i17 += i7;
                                                break;
                                        }
                                        virtualChildAt.layout(i17, i6, measuredWidth + i17, measuredHeight + i6);
                                    }
                                }
                            }
                        }
                    }
                    i8 = (this.e * i18) + ((i18 - 1) * this.m);
                    i9 = virtualChildAt.getMarginBottom();
                    i6 = i16 + (i8 - i9);
                    switch (absoluteGravity) {
                    }
                    virtualChildAt.layout(i17, i6, measuredWidth + i17, measuredHeight + i6);
                }
                i8 = (((this.e * i18) + ((i18 - 1) * this.m)) / 2) + virtualChildAt.getMarginTop();
                i9 = virtualChildAt.getMarginBottom();
                i6 = i16 + (i8 - i9);
                switch (absoluteGravity) {
                }
                virtualChildAt.layout(i17, i6, measuredWidth + i17, measuredHeight + i6);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        return new e();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j2) {
        if (j2 == 4480460401770252962L) {
            return 0;
        }
        if (j2 == DX_GRID_LAYOUT_LINE_COLOR) {
            return -8421505;
        }
        if (j2 == DX_GRID_LAYOUT_NEED_SEPARATOR || j2 == DX_GRID_LAYOUT_ROW_COUNT) {
            return 0;
        }
        if (j2 == DXGRIDLAYOUT_MAXCOLCOUNT || j2 == DXGRIDLAYOUT_MAXROWCOUNT || j2 == DXGRIDLAYOUT_MINCOLCOUNT || j2 == DXGRIDLAYOUT_MINROWCOUNT) {
            return -1;
        }
        return super.getDefaultValueForIntAttr(j2);
    }

    /* access modifiers changed from: protected */
    public void l() {
        if (this.i) {
            int i2 = this.k;
            int i3 = (this.c - 1) + (i2 - 1);
            int i4 = this.o;
            if (i4 == 1) {
                i3 = (this.j - 1) + (this.l - 1);
            }
            float[] fArr = new float[(i3 * 4)];
            int i5 = i2 - 1;
            if (i4 == 1) {
                i5 = this.j - 1;
            }
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i7 < i5) {
                int i9 = i8 + 1;
                fArr[i8] = (float) this.paddingLeft;
                int i10 = i9 + 1;
                int i11 = i7 + 1;
                int i12 = this.m;
                fArr[i9] = (float) ((this.e * i11) + (i7 * i12) + (i12 / 2) + this.paddingTop);
                int i13 = i10 + 1;
                fArr[i10] = (float) (getMeasuredWidth() - this.paddingRight);
                i8 = i13 + 1;
                int i14 = this.m;
                fArr[i13] = (float) ((this.e * i11) + (i7 * i14) + (i14 / 2) + this.paddingTop);
                i7 = i11;
            }
            int i15 = this.c - 1;
            if (this.o == 1) {
                i15 = this.l - 1;
            }
            while (i6 < i15) {
                int i16 = i8 + 1;
                int i17 = i6 + 1;
                int i18 = this.f;
                int i19 = this.d;
                int i20 = this.paddingLeft;
                fArr[i8] = (float) ((i17 * i18) + (i6 * i19) + (i19 / 2) + i20);
                int i21 = i16 + 1;
                fArr[i16] = (float) this.paddingTop;
                int i22 = i21 + 1;
                fArr[i21] = (float) ((i18 * i17) + (i6 * i19) + (i19 / 2) + i20);
                i8 = i22 + 1;
                fArr[i22] = (float) (getMeasuredHeight() - this.paddingBottom);
                i6 = i17;
            }
            this.n = fArr;
            int min = Math.min(this.d, this.m);
            if (this.h > min) {
                this.h = min;
            }
            setDisableFlatten(true);
            return;
        }
        this.n = null;
    }

    @Override // com.taobao.android.dinamicx.widget.f
    public void measureChildWithMargins(DXWidgetNode dXWidgetNode, int i2, int i3, int i4, int i5) {
        dXWidgetNode.measure(f.getChildMeasureSpec(i2, dXWidgetNode.marginLeft + dXWidgetNode.marginRight + i3, dXWidgetNode.layoutWidth), f.getChildMeasureSpec(i4, dXWidgetNode.marginTop + dXWidgetNode.marginBottom + i5, dXWidgetNode.layoutHeight));
    }

    /* access modifiers changed from: protected */
    public void measureHorizontal(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int virtualChildCount = getVirtualChildCount();
        DXWidgetNode.DXMeasureSpec.c(this.f, 1073741824);
        int c2 = DXWidgetNode.DXMeasureSpec.c(this.e, 1073741824);
        int i7 = 0;
        for (int i8 = 0; i8 < virtualChildCount; i8++) {
            DXWidgetNode childAt = getChildAt(i8);
            int h2 = h(childAt);
            measureChildWithMargins(childAt, DXWidgetNode.DXMeasureSpec.c((this.f * h2) + ((h2 - 1) * this.d), 1073741824), 0, c2, 0);
        }
        int a2 = DXWidgetNode.DXMeasureSpec.a(i2);
        int a3 = DXWidgetNode.DXMeasureSpec.a(i3);
        boolean z = a2 != 1073741824;
        boolean z2 = a3 != 1073741824;
        if (this.c > 0 && (i7 = this.j) <= 0) {
            int g2 = g();
            int i9 = this.c;
            if (g2 % i9 == 0) {
                i6 = g2 / i9;
            } else {
                i6 = (g2 / i9) + 1;
            }
            i7 = i6;
            int i10 = this.q;
            int i11 = this.s;
            if (i11 > 0 && ((i10 < 0 || i10 > i11) && i7 < i11)) {
                i7 = i11;
            }
        }
        this.k = i7;
        if (z || z2) {
            if (z) {
                int i12 = this.c;
                if (i12 > 0) {
                    i5 = (this.f * i12) + (this.d * (i12 - 1)) + this.paddingLeft + this.paddingRight;
                } else {
                    i5 = this.paddingLeft + this.paddingRight;
                }
            } else {
                i5 = DXWidgetNode.DXMeasureSpec.b(i2);
            }
            if (!z2) {
                i4 = DXWidgetNode.DXMeasureSpec.b(i3);
            } else if (i7 > 0) {
                i4 = (this.e * i7) + (this.m * (i7 - 1)) + this.paddingTop + this.paddingBottom;
            } else {
                i4 = this.paddingTop + this.paddingBottom;
            }
        } else {
            i5 = DXWidgetNode.DXMeasureSpec.b(i2);
            i4 = DXWidgetNode.DXMeasureSpec.b(i3);
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(i5, i2), DXWidgetNode.resolveSize(i4, i3));
    }

    /* access modifiers changed from: protected */
    public void measureVertical(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int virtualChildCount = getVirtualChildCount();
        int c2 = DXWidgetNode.DXMeasureSpec.c(this.f, 1073741824);
        DXWidgetNode.DXMeasureSpec.c(this.e, 1073741824);
        int i7 = 0;
        for (int i8 = 0; i8 < virtualChildCount; i8++) {
            DXWidgetNode childAt = getChildAt(i8);
            int i9 = i(childAt);
            measureChildWithMargins(childAt, c2, 0, DXWidgetNode.DXMeasureSpec.c((this.e * i9) + ((i9 - 1) * this.m), 1073741824), 0);
        }
        int a2 = DXWidgetNode.DXMeasureSpec.a(i2);
        int a3 = DXWidgetNode.DXMeasureSpec.a(i3);
        boolean z = a2 != 1073741824;
        boolean z2 = a3 != 1073741824;
        if (this.j > 0 && (i7 = this.c) <= 0) {
            int f2 = f();
            int i10 = this.j;
            if (f2 % i10 == 0) {
                i6 = f2 / i10;
            } else {
                i6 = (f2 / i10) + 1;
            }
            i7 = i6;
            int i11 = this.p;
            if (i11 <= 0 || i11 <= this.r || i7 <= i11) {
                int i12 = this.r;
                if (i12 > 0 && ((i11 < 0 || i11 > i12) && i7 < i12)) {
                    i7 = i12;
                }
            } else {
                i7 = i11;
            }
        }
        this.l = i7;
        if (z || z2) {
            if (!z) {
                i5 = DXWidgetNode.DXMeasureSpec.b(i2);
            } else if (i7 > 0) {
                i5 = (this.f * i7) + (this.d * (i7 - 1)) + this.paddingLeft + this.paddingRight;
            } else {
                i5 = this.paddingLeft + this.paddingRight;
            }
            if (z2) {
                int i13 = this.j;
                if (i13 > 0) {
                    i4 = this.paddingTop + this.paddingBottom + (this.e * i13) + (this.m * (i13 - 1));
                } else {
                    i4 = this.paddingTop + this.paddingBottom;
                }
            } else {
                i4 = DXWidgetNode.DXMeasureSpec.b(i3);
            }
        } else {
            i5 = DXWidgetNode.DXMeasureSpec.b(i2);
            i4 = DXWidgetNode.DXMeasureSpec.b(i3);
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(i5, i2), DXWidgetNode.resolveSize(i4, i3));
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        if ((this.propertyInitFlag & 2) != 0) {
            if (getChildren() != null && this.originItems == null) {
                this.originItems = new ArrayList();
                for (DXWidgetNode dXWidgetNode : getChildren()) {
                    this.originItems.add(dXWidgetNode.deepClone(getDXRuntimeContext()));
                }
            }
            JSONArray listData = getListData();
            if (listData == null || listData.isEmpty() || getChildren() == null) {
                removeAllChild();
                return;
            }
            removeAllChild();
            for (DXWidgetNode dXWidgetNode2 : this.originItems) {
                addChild(dXWidgetNode2.deepClone(getDXRuntimeContext()));
            }
            ArrayList arrayList = (ArrayList) getChildren();
            ArrayList arrayList2 = new ArrayList();
            int size = listData.size();
            int i2 = this.j * this.c;
            if (i2 > 0) {
                size = Math.min(i2, size);
            }
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = listData.get(i3);
                if (i3 == 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        bindContext((DXWidgetNode) it.next(), obj, i3);
                    }
                } else {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        DXWidgetNode dXWidgetNode3 = (DXWidgetNode) it2.next();
                        DXRuntimeContext cloneWithWidgetNode = dXWidgetNode3.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode3);
                        cloneWithWidgetNode.setSubData(obj);
                        cloneWithWidgetNode.setSubdataIndex(i3);
                        arrayList2.add(g.b(dXWidgetNode3, cloneWithWidgetNode));
                    }
                }
            }
            for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                addChild((DXWidgetNode) arrayList2.get(i4), false);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode != null && (dXWidgetNode instanceof e)) {
            super.onClone(dXWidgetNode, z);
            e eVar = (e) dXWidgetNode;
            this.c = eVar.c;
            this.d = eVar.d;
            this.e = eVar.e;
            this.f = eVar.f;
            this.g = eVar.g;
            this.h = eVar.h;
            this.i = eVar.i;
            this.j = eVar.j;
            this.m = eVar.m;
            this.n = eVar.n;
            this.k = eVar.k;
            this.o = eVar.o;
            this.p = eVar.p;
            this.r = eVar.r;
            this.q = eVar.q;
            this.s = eVar.s;
        }
    }

    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeGridLayout(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.o == 1) {
            k(z, i2, i3, i4, i5);
        } else {
            j(z, i2, i3, i4, i5);
        }
        l();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i2, int i3) {
        if (this.o == 1) {
            measureVertical(i2, i3);
        } else {
            measureHorizontal(i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        super.onRenderView(context, view);
        ((DXNativeGridLayout) view).setLines(this.i, this.g, this.h, this.n);
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j2, int i2) {
        if (j2 == 4480460401770252962L) {
            this.c = i2;
        } else if (j2 == DX_GRID_LAYOUT_COLUMN_SPACING) {
            this.d = i2;
        } else if (j2 == DX_GRID_LAYOUT_ITEM_HEIGHT) {
            this.e = i2;
        } else if (j2 == -5480582194049152328L) {
            this.f = i2;
        } else if (j2 == DX_GRID_LAYOUT_LINE_COLOR) {
            this.g = i2;
        } else if (j2 == DX_GRID_LAYOUT_LINE_WIDTH) {
            this.h = i2;
        } else if (j2 == DX_GRID_LAYOUT_NEED_SEPARATOR) {
            this.i = i2 != 0;
        } else if (j2 == DX_GRID_LAYOUT_ROW_COUNT) {
            this.j = i2;
        } else if (j2 == DX_GRID_LAYOUT_ROW_SPACING) {
            this.m = i2;
        } else if (j2 == -7199229155167727177L) {
            this.o = i2;
        } else if (j2 == DXGRIDLAYOUT_MAXCOLCOUNT) {
            this.p = i2;
        } else if (j2 == DXGRIDLAYOUT_MAXROWCOUNT) {
            this.q = i2;
        } else if (j2 == DXGRIDLAYOUT_MINCOLCOUNT) {
            this.r = i2;
        } else if (j2 == DXGRIDLAYOUT_MINROWCOUNT) {
            this.s = i2;
        } else {
            super.onSetIntAttribute(j2, i2);
        }
    }
}
