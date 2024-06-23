package tb;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.dynamicx.customwidget.textview.GradientBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXTextViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;

/* compiled from: Taobao */
public class lt extends DXTextViewWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMGRADUALCOLORTEXTVIEW_COLORNUMBER = -6727572123322173037L;
    public static final long DXDMGRADUALCOLORTEXTVIEW_DMGRADUALCOLORTEXTVIEW = 426282164695844518L;
    private String v;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-628486131")) {
                return new lt();
            }
            return (DXWidgetNode) ipChange.ipc$dispatch("-628486131", new Object[]{this, obj});
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1410977668")) {
            return new lt();
        }
        return (DXWidgetNode) ipChange.ipc$dispatch("1410977668", new Object[]{this, obj});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-626045407")) {
            ipChange.ipc$dispatch("-626045407", new Object[]{this, context, view, Long.valueOf(j)});
            return;
        }
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1423220930")) {
            ipChange.ipc$dispatch("-1423220930", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode != null && (dXWidgetNode instanceof lt)) {
            super.onClone(dXWidgetNode, z);
            this.v = ((lt) dXWidgetNode).v;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-297687433")) {
            return super.onCreateView(context);
        }
        return (View) ipChange.ipc$dispatch("-297687433", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1377084536")) {
            ipChange.ipc$dispatch("1377084536", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1344319075")) {
            ipChange.ipc$dispatch("1344319075", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view != null && (view instanceof TextView)) {
            GradientBean a2 = dg1.c().a(lk1.j(this.v, 0));
            ((TextView) view).getPaint().setShader(new LinearGradient(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), new int[]{a2.startColor, a2.endColor}, (float[]) null, Shader.TileMode.REPEAT));
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034234115")) {
            ipChange.ipc$dispatch("2034234115", new Object[]{this, Long.valueOf(j), str});
        } else if (j == DXDMGRADUALCOLORTEXTVIEW_COLORNUMBER) {
            this.v = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
