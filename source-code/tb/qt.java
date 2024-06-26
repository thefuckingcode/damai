package tb;

import android.content.Context;
import android.view.View;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;

/* compiled from: Taobao */
public class qt extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMICONFONTVIEW_POINTSIZE = -2396097246344434994L;
    public static final long DXDMICONFONTVIEW_TEXT = 38178040921L;
    public static final long DXDMICONFONTVIEW_TEXTCOLOR = 5737767606580872653L;
    public static final long DX_DMICONFONTVIEW = 7353588073829721178L;
    private int a;
    private String b;
    private int c;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2118296733")) {
                return new qt();
            }
            return (DXWidgetNode) ipChange.ipc$dispatch("-2118296733", new Object[]{this, obj});
        }
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1629433638")) {
            return new qt();
        }
        return (DXWidgetNode) ipChange.ipc$dispatch("-1629433638", new Object[]{this, obj});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1653377931")) {
            ipChange.ipc$dispatch("1653377931", new Object[]{this, context, view, Long.valueOf(j)});
            return;
        }
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "519425812")) {
            ipChange.ipc$dispatch("519425812", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode != null && (dXWidgetNode instanceof qt)) {
            super.onClone(dXWidgetNode, z);
            qt qtVar = (qt) dXWidgetNode;
            this.a = qtVar.a;
            this.b = qtVar.b;
            this.c = qtVar.c;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "745673677")) {
            return new DMIconFontTextView(context);
        }
        return (View) ipChange.ipc$dispatch("745673677", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "562870990")) {
            ipChange.ipc$dispatch("562870990", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-671224883")) {
            ipChange.ipc$dispatch("-671224883", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view != null && (view instanceof DMIconFontTextView)) {
            DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) view;
            dMIconFontTextView.setText(this.b);
            dMIconFontTextView.setTextColor(this.c);
            dMIconFontTextView.setTextSize((float) this.a);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2073500868")) {
            ipChange.ipc$dispatch("-2073500868", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "-1557017511")) {
            ipChange.ipc$dispatch("-1557017511", new Object[]{this, Long.valueOf(j), str});
        } else if (j == 38178040921L) {
            this.b = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
