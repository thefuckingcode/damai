package tb;

import android.content.Context;
import android.view.View;
import cn.damai.commonbusiness.dynamicx.customwidget.dashview.DMDXDashView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;

/* compiled from: Taobao */
public class jt extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_DMDASHVIEW = -2920712301245872714L;
    public static final long DX_DMDASHVIEW_DASHCOLOR = 2804157159581599144L;
    public static final long DX_DMDASHVIEW_DASHGAP = 4765750247167378239L;
    public static final long DX_DMDASHVIEW_DASHHEIGHT = -7103990330165362173L;
    public static final long DX_DMDASHVIEW_DASHWIDTH = 2804201866009705129L;
    private int a;
    private int b;
    private int c;
    private int d;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1595043806")) {
                return new jt();
            }
            return (DXWidgetNode) ipChange.ipc$dispatch("1595043806", new Object[]{this, obj});
        }
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-226258859")) {
            return new jt();
        }
        return (DXWidgetNode) ipChange.ipc$dispatch("-226258859", new Object[]{this, obj});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1537222000")) {
            ipChange.ipc$dispatch("1537222000", new Object[]{this, context, view, Long.valueOf(j)});
            return;
        }
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213559247")) {
            ipChange.ipc$dispatch("1213559247", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode != null && (dXWidgetNode instanceof jt)) {
            super.onClone(dXWidgetNode, z);
            jt jtVar = (jt) dXWidgetNode;
            this.a = jtVar.a;
            this.b = jtVar.b;
            this.c = jtVar.c;
            this.d = jtVar.d;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1296116040")) {
            return new DMDXDashView(context);
        }
        return (View) ipChange.ipc$dispatch("1296116040", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1128963273")) {
            ipChange.ipc$dispatch("1128963273", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-787380814")) {
            ipChange.ipc$dispatch("-787380814", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view != null && (view instanceof DMDXDashView)) {
            ((DMDXDashView) view).setParams(this.a, this.c, this.b);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "500079159")) {
            ipChange.ipc$dispatch("500079159", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        } else if (j == DX_DMDASHVIEW_DASHCOLOR) {
            this.a = i;
        } else if (j == DX_DMDASHVIEW_DASHGAP) {
            this.b = i;
        } else if (j == DX_DMDASHVIEW_DASHWIDTH) {
            this.c = i;
        } else if (j == DX_DMDASHVIEW_DASHHEIGHT) {
            this.d = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }
}
