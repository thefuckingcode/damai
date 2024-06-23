package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.view.DXNativeBouncePageIndicator;
import com.taobao.android.dinamicx.view.DXNativePageIndicator;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.d00;
import tb.fz;
import tb.lx;

/* compiled from: Taobao */
public class h extends DXWidgetNode {
    public static final int DEFAULT_OFF_COLOR = 14606046;
    public static final int DEFAULT_ON_COLOR = 16742144;
    public static final long DXPAGEINDICATOR_ITEMMARGIN = -884050990290307049L;
    public static final long DXPAGEINDICATOR_ITEMROUNDDIAMETER = -8559743205145630989L;
    public static final long DXPAGEINDICATOR_ITEMSELECTEDBORDERCOLOR = 956057309702335052L;
    public static final long DXPAGEINDICATOR_ITEMSELECTEDBORDERWIDTH = 1687099697943502157L;
    public static final long DXPAGEINDICATOR_ITEMUNSELECTEDBORDERCOLOR = -2071489811568019695L;
    public static final long DXPAGEINDICATOR_ITEMUNSELECTEDBORDERWIDTH = 852679479955548690L;
    public static final long DXPAGEINDICATOR_MAXDISPLAYCOUNT = -3284462966979738828L;
    public static final long DX_PAGE_INDICATOR = -4649639459667590873L;
    public static final long DX_PAGE_INDICATOR_HIDES_FOR_SINGLE_PAGE = 5486881853309576485L;
    public static final long DX_PAGE_INDICATOR_OFF_COLOR = 5279668588453924930L;
    public static final long DX_PAGE_INDICATOR_ON_COLOR = 5176469557014791523L;
    public static final long DX_PAGE_INDICATOR_PAGE_COUNT = 7816476278377541039L;
    private int a = DEFAULT_ON_COLOR;
    private int b = DEFAULT_OFF_COLOR;
    private int c;
    private int d;
    private boolean e;
    private int f = d00.j(DinamicXEngine.i(), "8ap", 16);
    private int g = d00.j(DinamicXEngine.i(), "3ap", 9);
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new h();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        return new h();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j2) {
        if (j2 == DX_PAGE_INDICATOR_ON_COLOR) {
            return DEFAULT_ON_COLOR;
        }
        if (j2 == DX_PAGE_INDICATOR_OFF_COLOR) {
            return DEFAULT_OFF_COLOR;
        }
        if (j2 == DXPAGEINDICATOR_ITEMUNSELECTEDBORDERWIDTH || DXPAGEINDICATOR_ITEMSELECTEDBORDERCOLOR == j2 || DXPAGEINDICATOR_ITEMSELECTEDBORDERWIDTH == j2 || DXPAGEINDICATOR_ITEMUNSELECTEDBORDERCOLOR == j2) {
            return 0;
        }
        if (j2 == DXPAGEINDICATOR_ITEMMARGIN) {
            return d00.j(DinamicXEngine.i(), "3ap", 9);
        }
        if (j2 == DXPAGEINDICATOR_ITEMROUNDDIAMETER) {
            return d00.j(DinamicXEngine.i(), "8ap", 16);
        }
        if (j2 == DXPAGEINDICATOR_MAXDISPLAYCOUNT) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j2);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        int i2;
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof h) {
            h hVar = (h) dXWidgetNode;
            this.e = hVar.e;
            this.d = hVar.d;
            this.c = hVar.c;
            this.b = hVar.b;
            this.a = hVar.a;
            this.g = hVar.g;
            this.f = hVar.f;
            this.i = hVar.i;
            this.j = hVar.j;
            this.k = hVar.k;
            this.l = hVar.l;
            if (getDefaultValueForIntAttr(DXPAGEINDICATOR_MAXDISPLAYCOUNT) == 1 && (i2 = hVar.h) != 0) {
                this.h = i2;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        if (getDefaultValueForIntAttr(DXPAGEINDICATOR_MAXDISPLAYCOUNT) != 1 || this.h == 0) {
            return new DXNativePageIndicator(context);
        }
        return new DXNativeBouncePageIndicator(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public boolean onEvent(lx lxVar) {
        if (super.onEvent(lxVar)) {
            return true;
        }
        if (lxVar.b() != -8975195222378757716L) {
            return false;
        }
        if (this.d <= 0) {
            return true;
        }
        fz fzVar = (fz) lxVar;
        if (getDefaultValueForIntAttr(DXPAGEINDICATOR_MAXDISPLAYCOUNT) != 1 || this.h == 0) {
            DXNativePageIndicator dXNativePageIndicator = (DXNativePageIndicator) getDXRuntimeContext().getNativeView();
            if (dXNativePageIndicator != null) {
                dXNativePageIndicator.setSelectedView(fzVar.d);
            }
        } else {
            DXNativeBouncePageIndicator dXNativeBouncePageIndicator = (DXNativeBouncePageIndicator) getDXRuntimeContext().getNativeView();
            if (dXNativeBouncePageIndicator != null) {
                dXNativeBouncePageIndicator.setSelectedView(fzVar.d);
            }
        }
        this.c = fzVar.d;
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int a2 = DXWidgetNode.DXMeasureSpec.a(i2);
        int a3 = DXWidgetNode.DXMeasureSpec.a(i3);
        int i8 = 0;
        boolean z = a2 != 1073741824;
        boolean z2 = a3 != 1073741824;
        if (z || z2) {
            if (z) {
                if (getDefaultValueForIntAttr(DXPAGEINDICATOR_MAXDISPLAYCOUNT) != 1 || (i7 = this.h) == 0) {
                    i6 = this.d;
                } else {
                    i6 = Math.min(i7, this.d);
                }
                if (i6 > 0) {
                    int i9 = 0;
                    while (i8 < i6) {
                        i9 += this.f;
                        if (i8 != i6 - 1) {
                            i9 += this.g;
                        }
                        i8++;
                    }
                    i8 = i9;
                }
                i5 = i8;
            } else {
                i5 = DXWidgetNode.DXMeasureSpec.b(i2);
            }
            if (z2) {
                i4 = this.f;
            } else {
                i4 = DXWidgetNode.DXMeasureSpec.b(i3);
            }
        } else {
            i5 = DXWidgetNode.DXMeasureSpec.b(i2);
            i4 = DXWidgetNode.DXMeasureSpec.b(i3);
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(i5, i2), DXWidgetNode.resolveSize(i4, i3));
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        int i2;
        int i3;
        super.onRenderView(context, view);
        h hVar = (h) getDXRuntimeContext().getWidgetNode();
        if (getDefaultValueForIntAttr(DXPAGEINDICATOR_MAXDISPLAYCOUNT) != 1 || this.h == 0) {
            DXNativePageIndicator dXNativePageIndicator = (DXNativePageIndicator) view;
            dXNativePageIndicator.setItemRoundDiameter(hVar.f);
            dXNativePageIndicator.setItemMargin(hVar.g);
            dXNativePageIndicator.setItemSelectedBorderWidth(hVar.j);
            dXNativePageIndicator.setItemSelectedBorderColor(hVar.i);
            dXNativePageIndicator.setItemUnSelectedBorderWidth(hVar.l);
            dXNativePageIndicator.setItemUnSelectedBorderColor(hVar.k);
            int tryFetchDarkModeColor = tryFetchDarkModeColor("onColor", 1, hVar.a);
            int tryFetchDarkModeColor2 = tryFetchDarkModeColor("offColor", 1, hVar.b);
            dXNativePageIndicator.setSelectedDrawable(tryFetchDarkModeColor);
            dXNativePageIndicator.setUnselectedDrawable(tryFetchDarkModeColor2);
            if ((!hVar.e || hVar.d != 1) && (i2 = hVar.d) > 0) {
                this.c = hVar.c;
                dXNativePageIndicator.addChildViews(i2, hVar.c);
                return;
            }
            dXNativePageIndicator.addChildViews(0, 0);
            return;
        }
        DXNativeBouncePageIndicator dXNativeBouncePageIndicator = (DXNativeBouncePageIndicator) view;
        dXNativeBouncePageIndicator.setItemRoundDiameter(hVar.f);
        dXNativeBouncePageIndicator.setItemMargin(hVar.g);
        dXNativeBouncePageIndicator.setItemSelectedBorderWidth(hVar.j);
        dXNativeBouncePageIndicator.setItemSelectedBorderColor(hVar.i);
        dXNativeBouncePageIndicator.setItemUnSelectedBorderWidth(hVar.l);
        dXNativeBouncePageIndicator.setItemUnSelectedBorderColor(hVar.k);
        int tryFetchDarkModeColor3 = tryFetchDarkModeColor("onColor", 1, hVar.a);
        int tryFetchDarkModeColor4 = tryFetchDarkModeColor("offColor", 1, hVar.b);
        dXNativeBouncePageIndicator.setSelectedDrawable(tryFetchDarkModeColor3);
        dXNativeBouncePageIndicator.setUnselectedDrawable(tryFetchDarkModeColor4);
        dXNativeBouncePageIndicator.setMaxDisplayCount(hVar.h);
        if ((!hVar.e || hVar.d != 1) && (i3 = hVar.d) > 0) {
            this.c = hVar.c;
            dXNativeBouncePageIndicator.addChildViews(i3, hVar.c);
            return;
        }
        dXNativeBouncePageIndicator.addChildViews(0, 0);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j2, int i2) {
        if (j2 == DX_PAGE_INDICATOR_ON_COLOR) {
            this.a = i2;
        } else if (j2 == DX_PAGE_INDICATOR_OFF_COLOR) {
            this.b = i2;
        } else if (j2 == DX_PAGE_INDICATOR_PAGE_COUNT) {
            this.d = i2;
        } else if (j2 == DX_PAGE_INDICATOR_HIDES_FOR_SINGLE_PAGE) {
            this.e = i2 != 0;
        } else if (j2 == DXPAGEINDICATOR_ITEMMARGIN) {
            this.g = i2;
        } else if (j2 == DXPAGEINDICATOR_ITEMROUNDDIAMETER) {
            this.f = i2;
        } else if (j2 == DXPAGEINDICATOR_ITEMSELECTEDBORDERCOLOR) {
            this.i = i2;
        } else if (j2 == DXPAGEINDICATOR_ITEMSELECTEDBORDERWIDTH) {
            this.j = i2;
        } else if (j2 == DXPAGEINDICATOR_ITEMUNSELECTEDBORDERCOLOR) {
            this.k = i2;
        } else if (j2 == DXPAGEINDICATOR_ITEMUNSELECTEDBORDERWIDTH) {
            this.l = i2;
        } else if (j2 == DXPAGEINDICATOR_MAXDISPLAYCOUNT) {
            this.h = i2;
        } else {
            super.onSetIntAttribute(j2, i2);
        }
    }
}
