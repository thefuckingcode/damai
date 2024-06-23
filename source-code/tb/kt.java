package tb;

import android.content.Context;
import android.view.View;
import cn.damai.commonbusiness.dynamicx.customwidget.exposureview.DMExposureView;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.d;

/* compiled from: Taobao */
public class kt extends d {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_DMFRAMELAYOUT = -7455913943340684793L;
    public static final long DX_DMFRAMELAYOUT_ARGS = 32709769921L;
    public static final long DX_DMFRAMELAYOUT_FLOATBORDERCOLOR = -5847411237943897469L;
    public static final long DX_DMFRAMELAYOUT_FLOATBORDERWIDTH = -5847329468253125244L;
    public static final long DX_DMFRAMELAYOUT_FLOATCORNERRADIUS = 7080405108067202040L;
    public static final long DX_DMFRAMELAYOUT_OTHER = 18907404528903L;
    public static final long DX_DMFRAMELAYOUT_SPM = 526934763;
    public static final long DX_DMFRAMELAYOUT_TYPE = 38200462374L;
    public static final long USER_DEFINE_PARAM_HASH_CODE = 9999999999L;
    private String c;
    public String d;
    public JSONArray e;
    public JSONArray f;
    public JSONArray g;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "483177313")) {
                return new kt();
            }
            return (DXWidgetNode) ipChange.ipc$dispatch("483177313", new Object[]{this, obj});
        }
    }

    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "17762008")) {
            return new kt();
        }
        return (DXWidgetNode) ipChange.ipc$dispatch("17762008", new Object[]{this, obj});
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1096261257")) {
            return ((Integer) ipChange.ipc$dispatch("1096261257", new Object[]{this, Long.valueOf(j)})).intValue();
        } else if (j == 9999999999L) {
            return -100;
        } else {
            return super.getDefaultValueForIntAttr(j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577100064")) {
            ipChange.ipc$dispatch("-1577100064", new Object[]{this});
            return;
        }
        super.onBeforeBindChildData();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1034213709")) {
            ipChange.ipc$dispatch("1034213709", new Object[]{this, context, view, Long.valueOf(j)});
            return;
        }
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1494795886")) {
            ipChange.ipc$dispatch("-1494795886", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
            return;
        }
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode != null && (dXWidgetNode instanceof kt)) {
            kt ktVar = (kt) dXWidgetNode;
            this.c = ktVar.c;
            this.d = ktVar.d;
            this.e = ktVar.e;
            this.f = ktVar.f;
            this.g = ktVar.g;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2045246005")) {
            return new DMExposureView(context);
        }
        return (View) ipChange.ipc$dispatch("-2045246005", new Object[]{this, context});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-62213684")) {
            ipChange.ipc$dispatch("-62213684", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290389105")) {
            ipChange.ipc$dispatch("-1290389105", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view != null && (view instanceof DMExposureView)) {
            ((DMExposureView) view).updateSPM(this.d, this.e, this.f, this.g);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "190855240")) {
            ipChange.ipc$dispatch("190855240", new Object[]{this, Long.valueOf(j), jSONArray});
        } else if (j == 526934763) {
            this.e = jSONArray;
        } else if (j == DX_DMFRAMELAYOUT_ARGS) {
            this.f = jSONArray;
        } else if (j == DX_DMFRAMELAYOUT_OTHER) {
            this.g = jSONArray;
        } else {
            super.onSetListAttribute(j, jSONArray);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-213419433")) {
            ipChange.ipc$dispatch("-213419433", new Object[]{this, Long.valueOf(j), str});
        } else if (j == 38200462374L) {
            this.d = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
