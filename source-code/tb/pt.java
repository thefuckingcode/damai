package tb;

import android.content.Context;
import android.view.View;
import cn.damai.homepage.ui.dynamicx.tagview.DMDXHomeTagView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;

/* compiled from: Taobao */
public class pt extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_DMHOMETAGVIEW = 9102343767700308190L;
    public static final long DX_DMHOMETAGVIEW_POINTSIZE = -2396097246344434994L;
    public static final long DX_DMHOMETAGVIEW_TEXT = 38178040921L;
    public static final long DX_DMHOMETAGVIEW_TEXTCOLOR = 5737767606580872653L;
    private int a;
    private String b;
    private int c;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "519126923")) {
                return new pt();
            }
            return (DXWidgetNode) ipChange.ipc$dispatch("519126923", new Object[]{this, obj});
        }
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1387224322")) {
            return new pt();
        }
        return (DXWidgetNode) ipChange.ipc$dispatch("1387224322", new Object[]{this, obj});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2106340451")) {
            ipChange.ipc$dispatch("2106340451", new Object[]{this, context, view, Long.valueOf(j)});
            return;
        }
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1676362044")) {
            ipChange.ipc$dispatch("1676362044", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode != null && (dXWidgetNode instanceof pt)) {
            super.onClone(dXWidgetNode, z);
            pt ptVar = (pt) dXWidgetNode;
            this.a = ptVar.a;
            this.b = ptVar.b;
            this.c = ptVar.c;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1595019275")) {
            return new DMDXHomeTagView(context);
        }
        return (View) ipChange.ipc$dispatch("-1595019275", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-963690584")) {
            ipChange.ipc$dispatch("-963690584", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "389952246")) {
            ipChange.ipc$dispatch("389952246", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-218262363")) {
            ipChange.ipc$dispatch("-218262363", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view != null && (view instanceof DMDXHomeTagView)) {
            ((DMDXHomeTagView) view).setTagName(this.b);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2010362724")) {
            ipChange.ipc$dispatch("2010362724", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        } else if (j == -2396097246344434994L) {
            this.a = i;
        } else if (j == 5737767606580872653L) {
            this.c = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-50661247")) {
            ipChange.ipc$dispatch("-50661247", new Object[]{this, Long.valueOf(j), str});
        } else if (j == 38178040921L) {
            this.b = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
