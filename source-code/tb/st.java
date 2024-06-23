package tb;

import android.content.Context;
import android.view.View;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMLabelView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
public class st extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMPROJECTSTATUSTAGVIEW_DMPROJECTSTATUSTAGVIEW = 8804219908927188409L;
    public static final long DXDMPROJECTSTATUSTAGVIEW_TAGTYPE = 5360457821407559013L;
    private String a;

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-413878680")) {
            return new st();
        }
        return (DXWidgetNode) ipChange.ipc$dispatch("-413878680", new Object[]{this, obj});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-330826819")) {
            ipChange.ipc$dispatch("-330826819", new Object[]{this, context, view, Long.valueOf(j)});
            return;
        }
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-861379294")) {
            ipChange.ipc$dispatch("-861379294", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode != null && (dXWidgetNode instanceof st)) {
            super.onClone(dXWidgetNode, z);
            this.a = ((st) dXWidgetNode).a;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-565258917")) {
            return new DMLabelView(context);
        }
        return (View) ipChange.ipc$dispatch("-565258917", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "420649308")) {
            ipChange.ipc$dispatch("420649308", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1639537663")) {
            ipChange.ipc$dispatch("1639537663", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view != null && (view instanceof DMLabelView)) {
            DMLabelView dMLabelView = (DMLabelView) view;
            if (!xf2.j(this.a)) {
                if ("1".endsWith(this.a)) {
                    dMLabelView.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_BUY);
                } else if ("2".endsWith(this.a)) {
                    dMLabelView.setLabelType(DMLabelType.LABEL_TYPE_BUYING);
                } else if ("5".endsWith(this.a)) {
                    dMLabelView.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_PERFORMANCE);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "61827559")) {
            ipChange.ipc$dispatch("61827559", new Object[]{this, Long.valueOf(j), str});
        } else if (j == DXDMPROJECTSTATUSTAGVIEW_TAGTYPE) {
            this.a = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
