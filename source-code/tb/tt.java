package tb;

import android.content.Context;
import android.view.View;
import cn.damai.commonbusiness.dynamicx.customwidget.scaleimage.DMDXScaleAnimationImage;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;

/* compiled from: Taobao */
public class tt extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMSCALEANIMATIONVIEW_ANIMATIONDURATION = 7542118000091127575L;
    public static final long DXDMSCALEANIMATIONVIEW_ANIMATIONINVERTAL = -1911798644495483370L;
    public static final long DXDMSCALEANIMATIONVIEW_DMSCALEANIMATIONVIEW = 3754100569737524168L;
    public static final long DXDMSCALEANIMATIONVIEW_IMAGELIST = 8842287391283277224L;
    private long a;
    private long b;
    private JSONArray c;

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-787554841")) {
            return new tt();
        }
        return (DXWidgetNode) ipChange.ipc$dispatch("-787554841", new Object[]{this, obj});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114561566")) {
            ipChange.ipc$dispatch("2114561566", new Object[]{this, context, view, Long.valueOf(j)});
            return;
        }
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931216609")) {
            ipChange.ipc$dispatch("1931216609", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode != null && (dXWidgetNode instanceof tt)) {
            super.onClone(dXWidgetNode, z);
            tt ttVar = (tt) dXWidgetNode;
            this.a = ttVar.a;
            this.b = ttVar.b;
            this.c = ttVar.c;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1871848742")) {
            return new DMDXScaleAnimationImage(context);
        }
        return (View) ipChange.ipc$dispatch("-1871848742", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168283443")) {
            ipChange.ipc$dispatch("-1168283443", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1381917019")) {
            ipChange.ipc$dispatch("1381917019", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-210041248")) {
            ipChange.ipc$dispatch("-210041248", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view != null && (view instanceof DMDXScaleAnimationImage)) {
            DMDXScaleAnimationImage dMDXScaleAnimationImage = (DMDXScaleAnimationImage) view;
            dMDXScaleAnimationImage.setDuration(this.a);
            dMDXScaleAnimationImage.setInterval(this.b);
            g91.b("pcj", "imageUrlSize = " + c31.b(this.c));
            if (c31.b(this.c) > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < c31.b(this.c); i++) {
                    Object obj = this.c.get(i);
                    StringBuilder sb = new StringBuilder();
                    sb.append("urlObj instanceof String = ");
                    boolean z = obj instanceof String;
                    sb.append(z);
                    g91.b("pcj", sb.toString());
                    if (z) {
                        String str = (String) obj;
                        g91.b("pcj", "imageUrl = " + str);
                        if (!xf2.j(str)) {
                            arrayList.add(str);
                        }
                    }
                }
                dMDXScaleAnimationImage.setImageList(arrayList);
                dMDXScaleAnimationImage.startAnimation();
                g91.b("pcj", "startAnimation");
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655640873")) {
            ipChange.ipc$dispatch("-1655640873", new Object[]{this, Long.valueOf(j), jSONArray});
        } else if (j == DXDMSCALEANIMATIONVIEW_IMAGELIST) {
            this.c = jSONArray;
        } else {
            super.onSetListAttribute(j, jSONArray);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetLongAttribute(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-350595501")) {
            ipChange.ipc$dispatch("-350595501", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
        } else if (j == 7542118000091127575L) {
            this.a = j2;
        } else if (j == -1911798644495483370L) {
            this.b = j2;
        } else {
            super.onSetLongAttribute(j, j2);
        }
    }
}
