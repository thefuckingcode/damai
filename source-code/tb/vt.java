package tb;

import android.content.Context;
import android.view.View;
import cn.damai.commonbusiness.dynamicx.customwidget.taplayout.DMDXTapFrameLayout;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.d;

/* compiled from: Taobao */
public class vt extends d {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMTAPFRAMELAYOUT_ISENABLED = -6141556675476878192L;
    public static final long DXDMTAPFRAMELAYOUT_ISEXPOSURE = -8177886521563870911L;
    public static final long DXDMTAPFRAMELAYOUT_JUMPARGS = 3824486456456783697L;
    public static final long DXDMTAPFRAMELAYOUT_SCHEMA = 10147640413355575L;
    public static final long DXDMTAPFRAMELAYOUT_SPM = 526934763;
    public static final long DXDMTAPFRAMELAYOUT_SPMARGS = 5325460942843529700L;
    public static final long DX_DMTAPFRAMELAYOUT = 2053572192652604719L;
    private String c;
    private String d;
    private JSONArray e;
    private String f;
    private JSONArray g;
    private JSONArray h;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-721295099")) {
                return new vt();
            }
            return (DXWidgetNode) ipChange.ipc$dispatch("-721295099", new Object[]{this, obj});
        }
    }

    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2053758852")) {
            return new vt();
        }
        return (DXWidgetNode) ipChange.ipc$dispatch("-2053758852", new Object[]{this, obj});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1192612823")) {
            ipChange.ipc$dispatch("-1192612823", new Object[]{this, context, view, Long.valueOf(j)});
            return;
        }
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806941642")) {
            ipChange.ipc$dispatch("-1806941642", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode != null && (dXWidgetNode instanceof vt)) {
            super.onClone(dXWidgetNode, z);
            vt vtVar = (vt) dXWidgetNode;
            this.c = vtVar.c;
            this.d = vtVar.d;
            this.e = vtVar.e;
            this.f = vtVar.f;
            this.g = vtVar.g;
            this.h = vtVar.h;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-38869137")) {
            return new DMDXTapFrameLayout(context);
        }
        return (View) ipChange.ipc$dispatch("-38869137", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791883870")) {
            ipChange.ipc$dispatch("-791883870", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-374113936")) {
            ipChange.ipc$dispatch("-374113936", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "777751659")) {
            ipChange.ipc$dispatch("777751659", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view != null && (view instanceof DMDXTapFrameLayout)) {
            DMDXTapFrameLayout dMDXTapFrameLayout = (DMDXTapFrameLayout) view;
            dMDXTapFrameLayout.setEnabled("true".equals(this.c));
            dMDXTapFrameLayout.setExposure("true".equals(this.d));
            dMDXTapFrameLayout.setJumpArgs(this.e);
            dMDXTapFrameLayout.setSchema(this.f);
            dMDXTapFrameLayout.setSpm(this.g);
            dMDXTapFrameLayout.setSpmArgs(this.h);
            dMDXTapFrameLayout.registerOnClickListener();
            dMDXTapFrameLayout.updateSPM();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "147950572")) {
            ipChange.ipc$dispatch("147950572", new Object[]{this, Long.valueOf(j), jSONArray});
        } else if (j == DXDMTAPFRAMELAYOUT_JUMPARGS) {
            this.e = jSONArray;
        } else if (j == 526934763) {
            this.g = jSONArray;
        } else if (j == DXDMTAPFRAMELAYOUT_SPMARGS) {
            this.h = jSONArray;
        } else {
            super.onSetListAttribute(j, jSONArray);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-964811781")) {
            ipChange.ipc$dispatch("-964811781", new Object[]{this, Long.valueOf(j), str});
        } else if (j == DXDMTAPFRAMELAYOUT_ISENABLED) {
            this.c = str;
        } else if (j == DXDMTAPFRAMELAYOUT_ISEXPOSURE) {
            this.d = str;
        } else if (j == DXDMTAPFRAMELAYOUT_SCHEMA) {
            this.f = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
