package tb;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import cn.damai.commonbusiness.dynamicx.customwidget.colorlayout.DMDXColorFrameLayout;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.d;

/* compiled from: Taobao */
public class ht extends d {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMCOLORFRAMELAYOUT_GRADIENT = 2937554514589711958L;
    public static final long DXDMCOLORFRAMELAYOUT_IMAGEURL = 3520785955321526846L;
    public static final long DX_DMCOLORFRAMELAYOUT = -3453172820799319797L;
    public static final long DX_DMCOLORFRAMELAYOUT_GRADIENTENDPOINTX = -3703964337255701544L;
    public static final long DX_DMCOLORFRAMELAYOUT_GRADIENTENDPOINTY = -3703964337255570471L;
    public static final long DX_DMCOLORFRAMELAYOUT_GRADIENTLOCATIONS = -2180576229883493877L;
    public static final long DX_DMCOLORFRAMELAYOUT_GRADIENTSTARTPOINTX = 967009270229382865L;
    public static final long DX_DMCOLORFRAMELAYOUT_GRADIENTSTARTPOINTY = 967009270229907154L;
    public static final long DX_DMCOLORFRAMELAYOUT_GTCOLORS = 2939712638768169045L;
    public static final long DX_DMCOLORFRAMELAYOUT_SHADOWCOLOR = -7272671779511765872L;
    public static final long DX_DMCOLORFRAMELAYOUT_SHADOWOFFSETX = 1186471842813171794L;
    public static final long DX_DMCOLORFRAMELAYOUT_SHADOWOFFSETY = 1186471842813179987L;
    public static final long DX_DMCOLORFRAMELAYOUT_SHADOWOPACITY = 1187712257266486892L;
    public static final long DX_DMCOLORFRAMELAYOUT_SHADOWRADIUS = -946376925464026374L;
    private JSONArray c;
    private double d;
    private double e;
    private JSONArray f;
    private double g;
    private double h;
    private JSONArray i;
    private int j;
    private String k;
    private int l;
    private int m;
    private double n;
    private int o;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1069098811")) {
                return new ht();
            }
            return (DXWidgetNode) ipChange.ipc$dispatch("-1069098811", new Object[]{this, obj});
        }
    }

    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2052665284")) {
            return new ht();
        }
        return (DXWidgetNode) ipChange.ipc$dispatch("-2052665284", new Object[]{this, obj});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1257769879")) {
            ipChange.ipc$dispatch("-1257769879", new Object[]{this, context, view, Long.valueOf(j2)});
            return;
        }
        super.onBindEvent(context, view, j2);
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468156918")) {
            ipChange.ipc$dispatch("468156918", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode != null && (dXWidgetNode instanceof ht)) {
            super.onClone(dXWidgetNode, z);
            ht htVar = (ht) dXWidgetNode;
            this.c = htVar.c;
            this.d = htVar.d;
            this.e = htVar.e;
            this.f = htVar.f;
            this.g = htVar.g;
            this.h = htVar.h;
            this.i = htVar.i;
            this.k = htVar.k;
            this.j = htVar.j;
            this.l = htVar.l;
            this.m = htVar.m;
            this.n = htVar.n;
            this.o = htVar.o;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "513218351")) {
            return new DMDXColorFrameLayout(context);
        }
        return (View) ipChange.ipc$dispatch("513218351", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756502686")) {
            ipChange.ipc$dispatch("-756502686", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
            return;
        }
        super.onLayout(z, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824803120")) {
            ipChange.ipc$dispatch("1824803120", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "712594603")) {
            ipChange.ipc$dispatch("712594603", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view != null && (view instanceof DMDXColorFrameLayout)) {
            DMDXColorFrameLayout dMDXColorFrameLayout = (DMDXColorFrameLayout) view;
            float[] fArr = getCornerRadius() > 0 ? new float[]{(float) getCornerRadius(), (float) getCornerRadius(), (float) getCornerRadius(), (float) getCornerRadius(), (float) getCornerRadius(), (float) getCornerRadius(), (float) getCornerRadius(), (float) getCornerRadius()} : new float[]{(float) getCornerRadiusLeftTop(), (float) getCornerRadiusLeftTop(), (float) getCornerRadiusRightTop(), (float) getCornerRadiusRightTop(), (float) getCornerRadiusRightBottom(), (float) getCornerRadiusRightBottom(), (float) getCornerRadiusLeftBottom(), (float) getCornerRadiusLeftBottom()};
            int[] iArr = null;
            float[] fArr2 = null;
            iArr = null;
            iArr = null;
            if (c31.b(this.c) > 0) {
                int b = c31.b(this.c);
                if (b > 0) {
                    if (b == 1) {
                        fArr2 = new float[]{this.c.getFloatValue(0), this.c.getFloatValue(0)};
                    } else {
                        fArr2 = new float[b];
                        while (i2 < b) {
                            fArr2[i2] = this.c.getFloatValue(i2);
                            i2++;
                        }
                    }
                }
                dMDXColorFrameLayout.setImageUrl(this.k, fArr2, fArr);
                return;
            }
            JSONArray jSONArray = this.i;
            if (jSONArray != null && jSONArray.size() > 0) {
                try {
                    iArr = new int[this.i.size()];
                    while (i2 < this.i.size()) {
                        iArr[i2] = Color.parseColor(this.i.getString(i2));
                        i2++;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (xp.b(iArr) > 0 && this.j != 0) {
                dMDXColorFrameLayout.setShadow(iArr, getCornerRadius(), this.j, this.o, this.l, this.m);
            } else if (xp.b(iArr) > 0 && this.j == 0) {
                dMDXColorFrameLayout.setGradientParams(fArr, iArr);
            } else if (xp.b(iArr) <= 0 && this.j != 0) {
                dMDXColorFrameLayout.setShadow(getCornerRadius(), this.j, this.o, this.l, this.m);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j2, double d2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1406434797")) {
            ipChange.ipc$dispatch("1406434797", new Object[]{this, Long.valueOf(j2), Double.valueOf(d2)});
        } else if (j2 == DX_DMCOLORFRAMELAYOUT_GRADIENTENDPOINTX) {
            this.d = d2;
        } else if (j2 == DX_DMCOLORFRAMELAYOUT_GRADIENTENDPOINTY) {
            this.e = d2;
        } else if (j2 == DX_DMCOLORFRAMELAYOUT_GRADIENTSTARTPOINTX) {
            this.g = d2;
        } else if (j2 == DX_DMCOLORFRAMELAYOUT_GRADIENTSTARTPOINTY) {
            this.h = d2;
        } else if (j2 == DX_DMCOLORFRAMELAYOUT_SHADOWOPACITY) {
            this.n = d2;
        } else {
            super.onSetDoubleAttribute(j2, d2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1617227678")) {
            ipChange.ipc$dispatch("1617227678", new Object[]{this, Long.valueOf(j2), Integer.valueOf(i2)});
        } else if (j2 == -7272671779511765872L) {
            this.j = i2;
        } else if (j2 == DX_DMCOLORFRAMELAYOUT_SHADOWOFFSETX) {
            this.l = i2;
        } else if (j2 == DX_DMCOLORFRAMELAYOUT_SHADOWOFFSETY) {
            this.m = i2;
        } else if (j2 == -946376925464026374L) {
            this.o = i2;
        } else {
            super.onSetIntAttribute(j2, i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j2, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "919051180")) {
            ipChange.ipc$dispatch("919051180", new Object[]{this, Long.valueOf(j2), jSONArray});
        } else if (j2 == DXDMCOLORFRAMELAYOUT_GRADIENT) {
            this.c = jSONArray;
        } else if (j2 == DX_DMCOLORFRAMELAYOUT_GRADIENTLOCATIONS) {
            this.f = jSONArray;
        } else if (j2 == DX_DMCOLORFRAMELAYOUT_GTCOLORS) {
            this.i = jSONArray;
        } else {
            super.onSetListAttribute(j2, jSONArray);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1489120325")) {
            ipChange.ipc$dispatch("-1489120325", new Object[]{this, Long.valueOf(j2), str});
        } else if (j2 == DXDMCOLORFRAMELAYOUT_IMAGEURL) {
            this.k = str;
        } else {
            super.onSetStringAttribute(j2, str);
        }
    }
}
