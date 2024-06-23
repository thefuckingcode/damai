package com.taobao.android.dinamicx;

import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRenderOptions;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.h;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.monitor.DXPerformBaselineUtil;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.taobao.android.dinamicx.notification.DXNotificationCenter;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.d;
import com.taobao.android.dinamicx.widget.event.IDXControlEventListener;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import tb.at;
import tb.c00;
import tb.et;
import tb.ft;
import tb.jl1;
import tb.jz;
import tb.kz;
import tb.os;
import tb.ry;
import tb.vx;
import tb.w00;
import tb.wz;
import tb.xz;

/* compiled from: Taobao */
public class DXRenderPipeline extends DXRenderPipelineBase implements IDXControlEventListener {
    public static final String DATA_PARSE_TIME = "dataParseTime";
    public static final String FLATTEN_TIME = "flattenTime";
    public static final String LAYOUT_TIME = "layoutTime";
    public static final String LOAD_BINARY_TIME = "loadBinaryTime";
    public static final String MEASURE_TIME = "measureTime";
    public static final String RENDER_TIME = "renderTime";
    DXNotificationCenter f;
    l g = new l();
    g h = new g();
    i i = new i();
    DXTemplateManager j;
    WeakReference<ft> k;
    WeakReference<h> l;

    DXRenderPipeline(d dVar, DXTemplateManager dXTemplateManager) {
        super(dVar);
        DinamicXEngine e = dVar.e();
        if (e != null) {
            this.f = e.l;
            this.j = dXTemplateManager;
            this.k = new WeakReference<>(e.k);
            this.l = new WeakReference<>(e.m);
            o();
        }
    }

    private boolean f(DXRenderOptions dXRenderOptions) {
        return dXRenderOptions.e() == 1 && dXRenderOptions.i();
    }

    private void g(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext != null) {
            try {
                if (dXRuntimeContext.getOpenTracerSpan() != null) {
                    dXRuntimeContext.getOpenTracerSpan().dataParseStart(Long.valueOf(System.currentTimeMillis()));
                }
            } catch (Throwable th) {
                vx.b(th);
            }
        }
    }

    private void h(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext != null) {
            try {
                DXTemplateItem dxTemplateItem = dXRuntimeContext.getDxTemplateItem();
                DXEngineConfig dXEngineConfig = this.a;
                if (dXEngineConfig != null && !dXEngineConfig.e && k() != null && dxTemplateItem != null) {
                    k().e(dxTemplateItem);
                    n(dXRuntimeContext, 1000);
                }
            } catch (Exception e) {
                if (DinamicXEngine.x()) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean l(e eVar) {
        List<e.a> list;
        if (at.x0(this.b) && eVar != null && (list = eVar.c) != null && !list.isEmpty()) {
            for (e.a aVar : eVar.c) {
                if (aVar.d == 80001) {
                    return true;
                }
            }
        }
        return false;
    }

    private String m(DXLongSparseArray<IDXBuilderWidgetNode> dXLongSparseArray) {
        if (dXLongSparseArray == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (int i2 = 0; i2 < dXLongSparseArray.size(); i2++) {
            jSONObject.put(String.valueOf(dXLongSparseArray.keyAt(i2)), (Object) dXLongSparseArray.valueAt(i2).getClass().getName());
        }
        return jSONObject.toJSONString();
    }

    private void n(DXRuntimeContext dXRuntimeContext, int i2) {
        if (this.f != null && dXRuntimeContext != null) {
            w00 w00 = new w00();
            w00.a = dXRuntimeContext.dxTemplateItem;
            w00.d = dXRuntimeContext.getDxUserContext();
            w00.b = dXRuntimeContext.getData();
            w00.c = i2;
            this.f.f(w00);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void p(et etVar) {
        DXWidgetNode dXWidgetNode;
        DXRuntimeContext dXRuntimeContext;
        DXRootView rootView;
        if (etVar != null && (etVar instanceof jz)) {
            jz jzVar = (jz) etVar;
            Object obj = etVar.a;
            if ((obj instanceof DXWidgetNode) && (dXWidgetNode = (DXWidgetNode) obj) != null && (dXRuntimeContext = dXWidgetNode.getDXRuntimeContext()) != null && dXRuntimeContext.renderType == 0 && (rootView = dXRuntimeContext.getRootView()) != null && dXRuntimeContext.dxTemplateItem.equals(rootView.dxTemplateItem) && dXRuntimeContext.getData() == rootView.data) {
                DXRuntimeContext cloneWithWidgetNode = dXWidgetNode.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode);
                cloneWithWidgetNode.refreshType = jzVar.e;
                DXRenderOptions k2 = new DXRenderOptions.b().o(true).l(jzVar.d).u(dXRuntimeContext.getRootWidthSpec()).m(dXRuntimeContext.getRootHeightSpec()).s(8).k();
                if (cloneWithWidgetNode.isRefreshPart()) {
                    dXWidgetNode.updateRefreshType(1);
                }
                r(dXWidgetNode, rootView.getFlattenWidgetNode(), rootView, cloneWithWidgetNode, k2);
            }
        }
    }

    private void s(DXRootView dXRootView) {
        try {
            os bindingXManager = dXRootView.getBindingXManager();
            if (bindingXManager != null) {
                bindingXManager.t(dXRootView);
            }
        } catch (Exception e) {
            vx.b(e);
            e eVar = new e(a());
            eVar.c.add(new e.a("Pipeline", "Pipeline_Stage_Reset_Bindingx", e.RESET_ANIMATION_CRASH, vx.a(e)));
            DXAppMonitor.n(eVar);
        }
    }

    private void t(DXRuntimeContext dXRuntimeContext, String str, long j2) {
        if (dXRuntimeContext != null) {
            try {
                if (dXRuntimeContext.getOpenTracerSpan() != null) {
                    dXRuntimeContext.getOpenTracerSpan().setTag(str, Float.valueOf(((float) (System.nanoTime() - j2)) / 1000000.0f));
                }
            } catch (Throwable th) {
                vx.b(th);
            }
        }
    }

    private void u(e eVar, String str, int i2, String str2, Map<String, String> map, boolean z) {
        if (eVar != null && eVar.c != null) {
            e.a aVar = new e.a("Pipeline", str, i2);
            aVar.e = str2;
            aVar.f = map;
            eVar.c.add(aVar);
            if (z) {
                DXAppMonitor.n(eVar);
            }
        }
    }

    private void w(DXRuntimeContext dXRuntimeContext, DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2, DXWidgetNode dXWidgetNode3) {
        if (dXRuntimeContext != null && l(dXRuntimeContext.getDxError())) {
            String name = Thread.currentThread().getName();
            if (dXWidgetNode != null) {
                String treeInfo = dXWidgetNode.toTreeInfo();
                wz.b(jl1.L + this.b + "|" + name + "> originTree: " + treeInfo);
                if (DinamicXEngine.x()) {
                    ry.i("ReportMeasureFlattenError", "originTree: " + treeInfo);
                }
            }
            if (dXWidgetNode2 != null) {
                String treeInfo2 = dXWidgetNode2.toTreeInfo();
                wz.b(jl1.L + this.b + "|" + name + "> deepCloneOriginTree: " + treeInfo2);
                if (DinamicXEngine.x()) {
                    ry.i("ReportMeasureFlattenError", "deepCloneOriginTree: " + treeInfo2);
                }
            }
            if (dXWidgetNode3 != null) {
                String treeInfo3 = dXWidgetNode3.toTreeInfo();
                wz.b(jl1.L + this.b + "|" + name + "> parsedTree: " + treeInfo3);
                if (DinamicXEngine.x()) {
                    ry.i("ReportMeasureFlattenError", "parsedTree: " + treeInfo3);
                }
            }
            String m = m(dXRuntimeContext.widgetNodeMap);
            if (!TextUtils.isEmpty(m)) {
                wz.b(jl1.L + this.b + "|" + name + "> widgetNodeMapInfo: " + m);
                if (DinamicXEngine.x()) {
                    ry.i("ReportMeasureFlattenError", "widgetNodeMapInfo: " + m);
                }
            }
        }
    }

    private void x(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext != null) {
            try {
                if (dXRuntimeContext.getOpenTracerSpan() != null) {
                    dXRuntimeContext.getOpenTracerSpan().viewRenderEnd(Long.valueOf(System.currentTimeMillis()));
                }
            } catch (Throwable th) {
                vx.b(th);
            }
        }
    }

    private void y(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext != null) {
            try {
                if (dXRuntimeContext.getOpenTracerSpan() != null) {
                    dXRuntimeContext.getOpenTracerSpan().viewRenderStart(Long.valueOf(System.currentTimeMillis()));
                }
            } catch (Throwable th) {
                vx.b(th);
            }
        }
    }

    public ft i() {
        return this.k.get();
    }

    public h j() {
        return this.l.get();
    }

    public DXTemplateManager k() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public void o() {
        ft i2 = i();
        if (i2 != null) {
            i2.c(this, jz.DX_EVENT_PIPELINE_SCHEDULE);
        }
    }

    public xz<DXRootView> q(DXRootView dXRootView, DXRuntimeContext dXRuntimeContext, int i2, DXRenderOptions dXRenderOptions) {
        if (dXRootView == null) {
            return null;
        }
        wz.b("开始渲染 tpl: " + dXRuntimeContext.getTemplateId() + " renderType: " + dXRenderOptions.e() + " isControlEvent: " + dXRenderOptions.j());
        s(dXRootView);
        dXRootView.data = dXRuntimeContext.getData();
        dXRootView.setPosition(i2);
        dXRootView.parentWidthSpec = dXRenderOptions.h();
        dXRootView.parentHeightSpec = dXRenderOptions.b();
        dXRootView.dxTemplateItem = dXRuntimeContext.getDxTemplateItem();
        View r = r(null, dXRootView.getFlattenWidgetNode(), dXRootView, dXRuntimeContext, dXRenderOptions);
        xz<DXRootView> xzVar = new xz<>();
        if (r != null && (r instanceof DXRootView)) {
            xzVar.f((DXRootView) r);
        }
        xzVar.d(dXRuntimeContext.getDxError());
        return xzVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:228:0x07cc A[SYNTHETIC, Splitter:B:228:0x07cc] */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x098e  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0a3c  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0a9c  */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x0b44  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x0c1b A[SYNTHETIC, Splitter:B:367:0x0c1b] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e6 A[SYNTHETIC, Splitter:B:43:0x00e6] */
    public View r(DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2, View view, DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions) {
        View view2;
        String str;
        String str2;
        String str3;
        DXWidgetNode dXWidgetNode3;
        String str4;
        String str5;
        String str6;
        DXWidgetNode dXWidgetNode4;
        DXWidgetNode dXWidgetNode5;
        Throwable th;
        String str7;
        DXWidgetNode dXWidgetNode6;
        DXWidgetNode dXWidgetNode7;
        DXWidgetNode dXWidgetNode8;
        String str8;
        String str9;
        String str10;
        Throwable th2;
        h j2;
        DXWidgetNode dXWidgetNode9;
        h.a aVar;
        DXWidgetNode dXWidgetNode10;
        DXWidgetNode dXWidgetNode11;
        DXWidgetNode dXWidgetNode12;
        String str11;
        String str12;
        boolean z;
        d dVar;
        View view3;
        int i2;
        String str13;
        String str14;
        String str15;
        String str16;
        int i3;
        String str17;
        String str18;
        String str19;
        String str20;
        int i4;
        String str21;
        String str22;
        String str23;
        String str24;
        View view4;
        String str25;
        int i5;
        h.a aVar2;
        String str26;
        String str27;
        DXWidgetNode dXWidgetNode13;
        String str28;
        DXWidgetNode dXWidgetNode14;
        View view5;
        DXWidgetNode dXWidgetNode15;
        DXWidgetNode dXWidgetNode16;
        String str29;
        DXWidgetNode dXWidgetNode17;
        DXWidgetNode dXWidgetNode18;
        DXWidgetNode dXWidgetNode19;
        DXWidgetNode deepClone;
        long nanoTime;
        String str30;
        String str31;
        DXWidgetNode dXWidgetNode20;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        int i6;
        String str37;
        e eVar;
        DXRenderOptions dXRenderOptions2 = dXRenderOptions;
        String str38 = "DX-Pipeline-RenderWt";
        String str39 = "DX-Pipeline-Flatten";
        String str40 = "DX-Pipeline-Layout";
        String str41 = "DX-Pipeline-Measure";
        String str42 = "Pipeline_Stage_Render_Error_Downgrade";
        String str43 = " tpl ";
        String str44 = "hasError";
        Object obj = "null";
        String str45 = "渲染结束 rootView";
        String str46 = "Pipeline";
        if (f(dXRenderOptions2)) {
            return null;
        }
        String str47 = "其他线程渲染结束 renderType";
        try {
            int a = dXRenderOptions.a();
            int f2 = dXRenderOptions.f();
            String str48 = str42;
            try {
                int h2 = dXRenderOptions.h();
                String str49 = "DX-Pipeline-Load";
                int b = dXRenderOptions.b();
                String str50 = "DX-Pipeline-Parser";
                j2 = j();
                int i7 = b;
                if (j2 != null) {
                    try {
                        if (j2.g(dXWidgetNode, dXRenderOptions2)) {
                            DXTraceUtil.b("DX-Pipeline-ReadCache");
                            view3 = view;
                            try {
                                DXWidgetNode i8 = j2.i(dXRuntimeContext, view3);
                                DXTraceUtil.c();
                                if (i8 != null) {
                                    if (DinamicXEngine.x()) {
                                        str12 = " ";
                                        try {
                                            str11 = "  tpl ";
                                            try {
                                                dXRuntimeContext.getDxPerformInfo().j = true;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                str4 = str45;
                                                str5 = str44;
                                                view2 = view3;
                                                str2 = str46;
                                                str3 = str47;
                                                dXWidgetNode5 = null;
                                                dXWidgetNode4 = null;
                                                dXWidgetNode3 = null;
                                                str42 = str48;
                                                str6 = str12;
                                                str = str11;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            str4 = str45;
                                            str5 = str44;
                                            view2 = view3;
                                            str2 = str46;
                                            str3 = str47;
                                            dXWidgetNode4 = null;
                                            dXWidgetNode3 = null;
                                            str42 = str48;
                                            str6 = str12;
                                            str = "  tpl ";
                                            dXWidgetNode5 = dXWidgetNode3;
                                            try {
                                                vx.b(th);
                                                str7 = str4;
                                                try {
                                                    u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                    DXTraceUtil.c();
                                                    if (view2 instanceof DXRootView) {
                                                    }
                                                    wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                    if (dXRuntimeContext.hasError()) {
                                                    }
                                                    return view2;
                                                } catch (Throwable th5) {
                                                    th2 = th5;
                                                    dXWidgetNode7 = dXWidgetNode3;
                                                    dXWidgetNode6 = dXWidgetNode5;
                                                    dXWidgetNode8 = dXWidgetNode4;
                                                    str10 = str6;
                                                    str8 = str43;
                                                    str9 = str5;
                                                    if (view2 instanceof DXRootView) {
                                                    }
                                                    wz.b(str3 + dXRenderOptions.e() + str10 + view2 + str + dXRuntimeContext.getTemplateId());
                                                    if (dXRuntimeContext.hasError()) {
                                                    }
                                                    throw th2;
                                                }
                                            } catch (Throwable th6) {
                                                th2 = th6;
                                                str10 = str6;
                                                dXWidgetNode8 = dXWidgetNode4;
                                                str8 = str43;
                                                dXWidgetNode7 = dXWidgetNode3;
                                                str7 = str4;
                                                dXWidgetNode6 = dXWidgetNode5;
                                                str9 = str5;
                                                if ((view2 instanceof DXRootView) || dXRenderOptions.e() != 0) {
                                                    wz.b(str3 + dXRenderOptions.e() + str10 + view2 + str + dXRuntimeContext.getTemplateId());
                                                } else {
                                                    DXRootView dXRootView = (DXRootView) view2;
                                                    if (dXRootView == null || dXRootView.getChildCount() != 0 || !dXRuntimeContext.hasError()) {
                                                        StringBuilder sb = new StringBuilder();
                                                        sb.append(str7);
                                                        if (dXRootView != null) {
                                                            obj = Integer.valueOf(dXRootView.getChildCount());
                                                        }
                                                        sb.append(obj);
                                                        sb.append(str9);
                                                        sb.append(dXRuntimeContext.hasError());
                                                        sb.append(str8);
                                                        sb.append(dXRuntimeContext.getTemplateId());
                                                        wz.b(sb.toString());
                                                    } else {
                                                        e eVar2 = new e(this.b);
                                                        eVar2.b = dXRuntimeContext.getDxTemplateItem();
                                                        e.a aVar3 = new e.a(str2, str42, e.DXERROR_RENDER_DOWNGRADE);
                                                        aVar3.e = dXRuntimeContext.getDxError().toString();
                                                        eVar2.c.add(aVar3);
                                                        DXAppMonitor.n(eVar2);
                                                        h(dXRuntimeContext);
                                                    }
                                                }
                                                if (dXRuntimeContext.hasError()) {
                                                    try {
                                                        w(dXRuntimeContext, dXWidgetNode7, dXWidgetNode8, dXWidgetNode6);
                                                    } catch (Throwable th7) {
                                                        vx.b(th7);
                                                    }
                                                    DXAppMonitor.n(dXRuntimeContext.getDxError());
                                                }
                                                throw th2;
                                            }
                                        }
                                    } else {
                                        str12 = " ";
                                        str11 = "  tpl ";
                                    }
                                    dVar = dXWidgetNode2;
                                    aVar = null;
                                    dXWidgetNode12 = null;
                                    dXWidgetNode11 = null;
                                    dXWidgetNode10 = null;
                                    dXWidgetNode9 = i8;
                                    i2 = 5;
                                    z = true;
                                    while (i2 <= f2) {
                                        try {
                                            if (f(dXRenderOptions2)) {
                                                break;
                                            }
                                            if (i2 == 0) {
                                                i4 = i2;
                                                str19 = str45;
                                                str18 = str44;
                                                str22 = str43;
                                                str23 = str39;
                                                str21 = str40;
                                                view4 = view3;
                                                i3 = h2;
                                                str20 = str46;
                                                str17 = str47;
                                                str29 = str50;
                                                dXWidgetNode13 = dXWidgetNode9;
                                                i5 = f2;
                                            } else if (i2 != 1) {
                                                if (i2 == 2) {
                                                    i4 = i2;
                                                    str19 = str45;
                                                    str18 = str44;
                                                    str22 = str43;
                                                    str21 = str40;
                                                    view4 = view3;
                                                    i3 = h2;
                                                    str20 = str46;
                                                    str17 = str47;
                                                    i5 = f2;
                                                    dXWidgetNode13 = dXWidgetNode9;
                                                    if (dXWidgetNode13 != null) {
                                                        DXTraceUtil.b(str50);
                                                        long nanoTime2 = System.nanoTime();
                                                        g(dXRuntimeContext);
                                                        dXWidgetNode10 = this.g.b(dXWidgetNode13, dXRuntimeContext);
                                                        long nanoTime3 = System.nanoTime() - nanoTime2;
                                                        if (DinamicXEngine.x()) {
                                                            dXRuntimeContext.getDxPerformInfo().b = ((float) nanoTime3) / 1000000.0f;
                                                        }
                                                        str23 = str39;
                                                        i7 = i7;
                                                        v(dXRuntimeContext, "Pipeline_Stage_Parse_Widget", nanoTime3, null);
                                                        t(dXRuntimeContext, DATA_PARSE_TIME, nanoTime2);
                                                        dXRuntimeContext.putPerformTrackerData(DATA_PARSE_TIME, String.valueOf(((float) nanoTime3) / 1000000.0f));
                                                        DXPerformBaselineUtil.a(str50, nanoTime3, dXRuntimeContext.getDxTemplateItem());
                                                        DXTraceUtil.c();
                                                        aVar2 = aVar;
                                                        str25 = str38;
                                                        str50 = str50;
                                                        str13 = str48;
                                                        str28 = str49;
                                                        str16 = str12;
                                                        str26 = str11;
                                                        dXWidgetNode13 = dXWidgetNode10;
                                                        str15 = str19;
                                                        str14 = str18;
                                                    } else {
                                                        str23 = str39;
                                                        i7 = i7;
                                                        str25 = str38;
                                                        view5 = view4;
                                                        str13 = str48;
                                                        str28 = str49;
                                                        str16 = str12;
                                                        str26 = str11;
                                                        dXWidgetNode14 = dXWidgetNode12;
                                                        dXWidgetNode16 = dXWidgetNode11;
                                                        dXWidgetNode15 = dXWidgetNode10;
                                                        str15 = str19;
                                                        str14 = str18;
                                                        str24 = str41;
                                                        str27 = str17;
                                                        aVar2 = aVar;
                                                        dXWidgetNode11 = dXWidgetNode16;
                                                        dXWidgetNode10 = dXWidgetNode15;
                                                        view4 = view5;
                                                        dXWidgetNode12 = dXWidgetNode14;
                                                        i2 = i4 + 1;
                                                        dXRenderOptions2 = dXRenderOptions;
                                                        str49 = str28;
                                                        dXWidgetNode9 = dXWidgetNode13;
                                                        str11 = str26;
                                                        aVar = aVar2;
                                                        f2 = i5;
                                                        str38 = str25;
                                                        view3 = view4;
                                                        str39 = str23;
                                                        str43 = str22;
                                                        str40 = str21;
                                                        str46 = str20;
                                                        h2 = i3;
                                                        str12 = str16;
                                                        str45 = str15;
                                                        str44 = str14;
                                                        str47 = str27;
                                                        str41 = str24;
                                                        str48 = str13;
                                                    }
                                                } else if (i2 != 3) {
                                                    if (i2 == 4) {
                                                        i4 = i2;
                                                        str19 = str45;
                                                        str18 = str44;
                                                        str22 = str43;
                                                        view4 = view3;
                                                        str20 = str46;
                                                        str17 = str47;
                                                        i5 = f2;
                                                        str37 = str39;
                                                        i6 = h2;
                                                        dXWidgetNode13 = dXWidgetNode9;
                                                        if (dXWidgetNode13 != null) {
                                                            DXTraceUtil.b(str40);
                                                            long nanoTime4 = System.nanoTime();
                                                            this.h.c(dXWidgetNode13, dXRuntimeContext);
                                                            if (dXRuntimeContext.hasError()) {
                                                                eVar = new e(dXRuntimeContext.getBizType());
                                                                eVar.b = dXRuntimeContext.getDxTemplateItem();
                                                                eVar.c.addAll(dXRuntimeContext.getDxError().c);
                                                            } else {
                                                                eVar = null;
                                                            }
                                                            aVar2 = j2 != null ? j2.c(dXWidgetNode13, eVar) : aVar;
                                                            long nanoTime5 = System.nanoTime() - nanoTime4;
                                                            if (DinamicXEngine.x()) {
                                                                dXRuntimeContext.getDxPerformInfo().d = ((float) nanoTime5) / 1000000.0f;
                                                            }
                                                            v(dXRuntimeContext, "Pipeline_Stage_Layout_Widget", nanoTime5, null);
                                                            t(dXRuntimeContext, LAYOUT_TIME, nanoTime4);
                                                            dXRuntimeContext.putPerformTrackerData(LAYOUT_TIME, String.valueOf(((float) nanoTime5) / 1000000.0f));
                                                            DXPerformBaselineUtil.a(str40, nanoTime5, dXRuntimeContext.getDxTemplateItem());
                                                            DXTraceUtil.c();
                                                            str21 = str40;
                                                        } else {
                                                            str21 = str40;
                                                            str23 = str37;
                                                            i3 = i6;
                                                            view5 = view4;
                                                            str13 = str48;
                                                            str28 = str49;
                                                            str16 = str12;
                                                            str26 = str11;
                                                            dXWidgetNode14 = dXWidgetNode12;
                                                            dXWidgetNode16 = dXWidgetNode11;
                                                            dXWidgetNode15 = dXWidgetNode10;
                                                            str15 = str19;
                                                            str14 = str18;
                                                            str25 = str38;
                                                            str24 = str41;
                                                            str27 = str17;
                                                            aVar2 = aVar;
                                                            dXWidgetNode11 = dXWidgetNode16;
                                                            dXWidgetNode10 = dXWidgetNode15;
                                                            view4 = view5;
                                                            dXWidgetNode12 = dXWidgetNode14;
                                                            i2 = i4 + 1;
                                                            dXRenderOptions2 = dXRenderOptions;
                                                            str49 = str28;
                                                            dXWidgetNode9 = dXWidgetNode13;
                                                            str11 = str26;
                                                            aVar = aVar2;
                                                            f2 = i5;
                                                            str38 = str25;
                                                            view3 = view4;
                                                            str39 = str23;
                                                            str43 = str22;
                                                            str40 = str21;
                                                            str46 = str20;
                                                            h2 = i3;
                                                            str12 = str16;
                                                            str45 = str15;
                                                            str44 = str14;
                                                            str47 = str27;
                                                            str41 = str24;
                                                            str48 = str13;
                                                        }
                                                    } else if (i2 == 5) {
                                                        i4 = i2;
                                                        str19 = str45;
                                                        str18 = str44;
                                                        str22 = str43;
                                                        str23 = str39;
                                                        view4 = view3;
                                                        str20 = str46;
                                                        str17 = str47;
                                                        i5 = f2;
                                                        dXWidgetNode13 = dXWidgetNode9;
                                                        i6 = h2;
                                                        if (dXWidgetNode13 != null) {
                                                            DXTraceUtil.b(str23);
                                                            long nanoTime6 = System.nanoTime();
                                                            DXEngineConfig dXEngineConfig = this.a;
                                                            dVar = this.h.b(dXWidgetNode13, dXRuntimeContext, dXEngineConfig != null ? dXEngineConfig.m() : false);
                                                            long nanoTime7 = System.nanoTime() - nanoTime6;
                                                            if (DinamicXEngine.x()) {
                                                                dXRuntimeContext.getDxPerformInfo().e = ((float) nanoTime7) / 1000000.0f;
                                                            }
                                                            v(dXRuntimeContext, "Pipeline_Stage_FLatten_Widget", nanoTime7, null);
                                                            t(dXRuntimeContext, FLATTEN_TIME, nanoTime6);
                                                            dXRuntimeContext.putPerformTrackerData(FLATTEN_TIME, String.valueOf(((float) nanoTime7) / 1000000.0f));
                                                            str37 = str23;
                                                            DXPerformBaselineUtil.a(str37, nanoTime7, dXRuntimeContext.getDxTemplateItem());
                                                            DXTraceUtil.c();
                                                            aVar2 = aVar;
                                                            str21 = str40;
                                                        } else {
                                                            str21 = str40;
                                                            i3 = i6;
                                                            view5 = view4;
                                                            str13 = str48;
                                                            str28 = str49;
                                                            str16 = str12;
                                                            str26 = str11;
                                                            dXWidgetNode14 = dXWidgetNode12;
                                                            dXWidgetNode16 = dXWidgetNode11;
                                                            dXWidgetNode15 = dXWidgetNode10;
                                                            str15 = str19;
                                                            str14 = str18;
                                                            str25 = str38;
                                                            str24 = str41;
                                                            str27 = str17;
                                                            aVar2 = aVar;
                                                            dXWidgetNode11 = dXWidgetNode16;
                                                            dXWidgetNode10 = dXWidgetNode15;
                                                            view4 = view5;
                                                            dXWidgetNode12 = dXWidgetNode14;
                                                            i2 = i4 + 1;
                                                            dXRenderOptions2 = dXRenderOptions;
                                                            str49 = str28;
                                                            dXWidgetNode9 = dXWidgetNode13;
                                                            str11 = str26;
                                                            aVar = aVar2;
                                                            f2 = i5;
                                                            str38 = str25;
                                                            view3 = view4;
                                                            str39 = str23;
                                                            str43 = str22;
                                                            str40 = str21;
                                                            str46 = str20;
                                                            h2 = i3;
                                                            str12 = str16;
                                                            str45 = str15;
                                                            str44 = str14;
                                                            str47 = str27;
                                                            str41 = str24;
                                                            str48 = str13;
                                                        }
                                                    } else if (i2 != 7) {
                                                        i4 = i2;
                                                        str15 = str45;
                                                        str14 = str44;
                                                        str22 = str43;
                                                        str23 = str39;
                                                        str21 = str40;
                                                        view5 = view3;
                                                        i3 = h2;
                                                        str20 = str46;
                                                        str13 = str48;
                                                        str28 = str49;
                                                        str16 = str12;
                                                        str26 = str11;
                                                        dXWidgetNode14 = dXWidgetNode12;
                                                        dXWidgetNode16 = dXWidgetNode11;
                                                        dXWidgetNode15 = dXWidgetNode10;
                                                        i5 = f2;
                                                        dXWidgetNode13 = dXWidgetNode9;
                                                        str24 = str41;
                                                        str27 = str47;
                                                        str25 = str38;
                                                        aVar2 = aVar;
                                                        dXWidgetNode11 = dXWidgetNode16;
                                                        dXWidgetNode10 = dXWidgetNode15;
                                                        view4 = view5;
                                                        dXWidgetNode12 = dXWidgetNode14;
                                                        i2 = i4 + 1;
                                                        dXRenderOptions2 = dXRenderOptions;
                                                        str49 = str28;
                                                        dXWidgetNode9 = dXWidgetNode13;
                                                        str11 = str26;
                                                        aVar = aVar2;
                                                        f2 = i5;
                                                        str38 = str25;
                                                        view3 = view4;
                                                        str39 = str23;
                                                        str43 = str22;
                                                        str40 = str21;
                                                        str46 = str20;
                                                        h2 = i3;
                                                        str12 = str16;
                                                        str45 = str15;
                                                        str44 = str14;
                                                        str47 = str27;
                                                        str41 = str24;
                                                        str48 = str13;
                                                    } else if (dVar != null) {
                                                        try {
                                                            DXTraceUtil.b(str38);
                                                            str23 = str39;
                                                            long nanoTime8 = System.nanoTime();
                                                            y(dXRuntimeContext);
                                                            i4 = i2;
                                                            str19 = str45;
                                                            str18 = str44;
                                                            str22 = str43;
                                                            view4 = view3;
                                                            str17 = str47;
                                                            dXWidgetNode13 = dXWidgetNode9;
                                                            i6 = h2;
                                                            str20 = str46;
                                                            i5 = f2;
                                                            view4 = this.i.d(dXWidgetNode9, dVar, view, dXRuntimeContext, 0);
                                                            long nanoTime9 = System.nanoTime() - nanoTime8;
                                                            if (DinamicXEngine.x()) {
                                                                dXRuntimeContext.getDxPerformInfo().f = ((float) nanoTime9) / 1000000.0f;
                                                            }
                                                            v(dXRuntimeContext, "Pipeline_Stage_Render_Widget", nanoTime9, null);
                                                            t(dXRuntimeContext, RENDER_TIME, nanoTime8);
                                                            dXRuntimeContext.putPerformTrackerData(RENDER_TIME, String.valueOf(((float) nanoTime9) / 1000000.0f));
                                                            x(dXRuntimeContext);
                                                            DXPerformBaselineUtil.a(str38, nanoTime9, dXRuntimeContext.getDxTemplateItem());
                                                            DXTraceUtil.c();
                                                            aVar2 = aVar;
                                                            str21 = str40;
                                                            i3 = i6;
                                                            str13 = str48;
                                                            str28 = str49;
                                                            str16 = str12;
                                                            str26 = str11;
                                                            str15 = str19;
                                                            str14 = str18;
                                                            str25 = str38;
                                                        } catch (Throwable th8) {
                                                            th = th8;
                                                            view2 = view4;
                                                            str42 = str48;
                                                            str43 = str22;
                                                            str6 = str12;
                                                            str = str11;
                                                            dXWidgetNode3 = dXWidgetNode12;
                                                            dXWidgetNode4 = dXWidgetNode11;
                                                            dXWidgetNode5 = dXWidgetNode10;
                                                            str2 = str20;
                                                            str4 = str19;
                                                            str5 = str18;
                                                            str3 = str17;
                                                            vx.b(th);
                                                            str7 = str4;
                                                            u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                            DXTraceUtil.c();
                                                            if (view2 instanceof DXRootView) {
                                                            }
                                                            wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                            if (dXRuntimeContext.hasError()) {
                                                            }
                                                            return view2;
                                                        }
                                                    } else {
                                                        i4 = i2;
                                                        str23 = str39;
                                                        str20 = str46;
                                                        str17 = str47;
                                                        i5 = f2;
                                                        dXWidgetNode13 = dXWidgetNode9;
                                                        str25 = str38;
                                                        str15 = str45;
                                                        str14 = str44;
                                                        str22 = str43;
                                                        str21 = str40;
                                                        view5 = view3;
                                                        i3 = h2;
                                                        str13 = str48;
                                                        str28 = str49;
                                                        str16 = str12;
                                                        str26 = str11;
                                                        dXWidgetNode14 = dXWidgetNode12;
                                                        dXWidgetNode16 = dXWidgetNode11;
                                                        dXWidgetNode15 = dXWidgetNode10;
                                                        str24 = str41;
                                                        str27 = str17;
                                                        aVar2 = aVar;
                                                        dXWidgetNode11 = dXWidgetNode16;
                                                        dXWidgetNode10 = dXWidgetNode15;
                                                        view4 = view5;
                                                        dXWidgetNode12 = dXWidgetNode14;
                                                        i2 = i4 + 1;
                                                        dXRenderOptions2 = dXRenderOptions;
                                                        str49 = str28;
                                                        dXWidgetNode9 = dXWidgetNode13;
                                                        str11 = str26;
                                                        aVar = aVar2;
                                                        f2 = i5;
                                                        str38 = str25;
                                                        view3 = view4;
                                                        str39 = str23;
                                                        str43 = str22;
                                                        str40 = str21;
                                                        str46 = str20;
                                                        h2 = i3;
                                                        str12 = str16;
                                                        str45 = str15;
                                                        str44 = str14;
                                                        str47 = str27;
                                                        str41 = str24;
                                                        str48 = str13;
                                                    }
                                                    str23 = str37;
                                                    i3 = i6;
                                                    str13 = str48;
                                                    str28 = str49;
                                                    str16 = str12;
                                                    str26 = str11;
                                                    str15 = str19;
                                                    str14 = str18;
                                                    str25 = str38;
                                                } else {
                                                    i4 = i2;
                                                    str19 = str45;
                                                    str18 = str44;
                                                    str22 = str43;
                                                    view4 = view3;
                                                    str20 = str46;
                                                    str17 = str47;
                                                    i5 = f2;
                                                    dXWidgetNode13 = dXWidgetNode9;
                                                    if (dXWidgetNode13 != null) {
                                                        DXTraceUtil.b(str41);
                                                        long nanoTime10 = System.nanoTime();
                                                        long nanoTime11 = System.nanoTime() - nanoTime10;
                                                        this.h.d(dXWidgetNode13, h2, i7, dXRuntimeContext);
                                                        if (DinamicXEngine.x()) {
                                                            dXRuntimeContext.getDxPerformInfo().c = ((float) nanoTime11) / 1000000.0f;
                                                        }
                                                        str21 = str40;
                                                        i3 = h2;
                                                        v(dXRuntimeContext, "Pipeline_Stage_Measure_Widget", nanoTime11, null);
                                                        t(dXRuntimeContext, MEASURE_TIME, nanoTime10);
                                                        dXRuntimeContext.putPerformTrackerData(MEASURE_TIME, String.valueOf(((float) nanoTime11) / 1000000.0f));
                                                        DXPerformBaselineUtil.a(str41, nanoTime11, dXRuntimeContext.getDxTemplateItem());
                                                        DXTraceUtil.c();
                                                        str25 = str38;
                                                        str23 = str39;
                                                        i7 = i7;
                                                    } else {
                                                        str21 = str40;
                                                        i3 = h2;
                                                        str25 = str38;
                                                        str23 = str39;
                                                    }
                                                    view5 = view4;
                                                    str13 = str48;
                                                    str28 = str49;
                                                    str16 = str12;
                                                    str26 = str11;
                                                    dXWidgetNode14 = dXWidgetNode12;
                                                    dXWidgetNode16 = dXWidgetNode11;
                                                    dXWidgetNode15 = dXWidgetNode10;
                                                    str15 = str19;
                                                    str14 = str18;
                                                    str24 = str41;
                                                    str27 = str17;
                                                    aVar2 = aVar;
                                                    dXWidgetNode11 = dXWidgetNode16;
                                                    dXWidgetNode10 = dXWidgetNode15;
                                                    view4 = view5;
                                                    dXWidgetNode12 = dXWidgetNode14;
                                                    i2 = i4 + 1;
                                                    dXRenderOptions2 = dXRenderOptions;
                                                    str49 = str28;
                                                    dXWidgetNode9 = dXWidgetNode13;
                                                    str11 = str26;
                                                    aVar = aVar2;
                                                    f2 = i5;
                                                    str38 = str25;
                                                    view3 = view4;
                                                    str39 = str23;
                                                    str43 = str22;
                                                    str40 = str21;
                                                    str46 = str20;
                                                    h2 = i3;
                                                    str12 = str16;
                                                    str45 = str15;
                                                    str44 = str14;
                                                    str47 = str27;
                                                    str41 = str24;
                                                    str48 = str13;
                                                }
                                                str24 = str41;
                                                str27 = str17;
                                                i2 = i4 + 1;
                                                dXRenderOptions2 = dXRenderOptions;
                                                str49 = str28;
                                                dXWidgetNode9 = dXWidgetNode13;
                                                str11 = str26;
                                                aVar = aVar2;
                                                f2 = i5;
                                                str38 = str25;
                                                view3 = view4;
                                                str39 = str23;
                                                str43 = str22;
                                                str40 = str21;
                                                str46 = str20;
                                                h2 = i3;
                                                str12 = str16;
                                                str45 = str15;
                                                str44 = str14;
                                                str47 = str27;
                                                str41 = str24;
                                                str48 = str13;
                                            } else {
                                                i4 = i2;
                                                str19 = str45;
                                                str18 = str44;
                                                str22 = str43;
                                                str23 = str39;
                                                str21 = str40;
                                                view4 = view3;
                                                i3 = h2;
                                                str20 = str46;
                                                str17 = str47;
                                                str29 = str50;
                                                i5 = f2;
                                                dXWidgetNode13 = dXWidgetNode9;
                                            }
                                            if (dXWidgetNode13 == null) {
                                                try {
                                                    DXTraceUtil.b(str49);
                                                    long nanoTime12 = System.nanoTime();
                                                    DXTemplateManager k2 = k();
                                                    if (k2 == null) {
                                                        try {
                                                            DXTraceUtil.c();
                                                            if (!(view4 instanceof DXRootView) || dXRenderOptions.e() != 0) {
                                                                wz.b(str17 + dXRenderOptions.e() + str12 + view4 + str11 + dXRuntimeContext.getTemplateId());
                                                            } else {
                                                                DXRootView dXRootView2 = (DXRootView) view4;
                                                                if (dXRootView2 == null || dXRootView2.getChildCount() != 0 || !dXRuntimeContext.hasError()) {
                                                                    StringBuilder sb2 = new StringBuilder();
                                                                    sb2.append(str19);
                                                                    if (dXRootView2 != null) {
                                                                        obj = Integer.valueOf(dXRootView2.getChildCount());
                                                                    }
                                                                    sb2.append(obj);
                                                                    sb2.append(str18);
                                                                    sb2.append(dXRuntimeContext.hasError());
                                                                    sb2.append(str22);
                                                                    sb2.append(dXRuntimeContext.getTemplateId());
                                                                    wz.b(sb2.toString());
                                                                } else {
                                                                    e eVar3 = new e(this.b);
                                                                    eVar3.b = dXRuntimeContext.getDxTemplateItem();
                                                                    e.a aVar4 = new e.a(str20, str48, e.DXERROR_RENDER_DOWNGRADE);
                                                                    aVar4.e = dXRuntimeContext.getDxError().toString();
                                                                    eVar3.c.add(aVar4);
                                                                    DXAppMonitor.n(eVar3);
                                                                    h(dXRuntimeContext);
                                                                }
                                                            }
                                                            if (dXRuntimeContext.hasError()) {
                                                                try {
                                                                    w(dXRuntimeContext, dXWidgetNode12, dXWidgetNode11, dXWidgetNode10);
                                                                } catch (Throwable th9) {
                                                                    vx.b(th9);
                                                                }
                                                                DXAppMonitor.n(dXRuntimeContext.getDxError());
                                                            }
                                                            return null;
                                                        } catch (Throwable th10) {
                                                            th = th10;
                                                            view2 = view4;
                                                            dXWidgetNode3 = dXWidgetNode12;
                                                            dXWidgetNode4 = dXWidgetNode11;
                                                            dXWidgetNode5 = dXWidgetNode10;
                                                            str42 = str48;
                                                            str43 = str22;
                                                            str6 = str12;
                                                            str = str11;
                                                            str2 = str20;
                                                            str4 = str19;
                                                            str5 = str18;
                                                            str3 = str17;
                                                            vx.b(th);
                                                            str7 = str4;
                                                            u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                            DXTraceUtil.c();
                                                            if (view2 instanceof DXRootView) {
                                                            }
                                                            wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                            if (dXRuntimeContext.hasError()) {
                                                            }
                                                            return view2;
                                                        }
                                                    } else {
                                                        view2 = view4;
                                                        try {
                                                            DXWidgetNode j3 = k2.j(dXRuntimeContext);
                                                            if (j3 == null) {
                                                                try {
                                                                    if (dXRenderOptions.e() == 0) {
                                                                        try {
                                                                            dXWidgetNode20 = j3;
                                                                            str31 = str17;
                                                                            str30 = str22;
                                                                            str36 = str18;
                                                                            str35 = str19;
                                                                            str34 = str48;
                                                                            str33 = str20;
                                                                            str32 = str12;
                                                                            try {
                                                                                u(dXRuntimeContext.getDxError(), "Pipeline_Render", 40002, "获取原型树失败", null, false);
                                                                            } catch (Throwable th11) {
                                                                                th = th11;
                                                                                str5 = str36;
                                                                                str4 = str35;
                                                                                str42 = str34;
                                                                                str2 = str33;
                                                                                str6 = str32;
                                                                                dXWidgetNode4 = dXWidgetNode11;
                                                                                dXWidgetNode5 = dXWidgetNode10;
                                                                                str = str11;
                                                                                dXWidgetNode3 = dXWidgetNode20;
                                                                                str3 = str31;
                                                                            }
                                                                        } catch (Throwable th12) {
                                                                            th = th12;
                                                                            str3 = str17;
                                                                            str42 = str48;
                                                                            str2 = str20;
                                                                            dXWidgetNode5 = dXWidgetNode10;
                                                                            str = str11;
                                                                            dXWidgetNode3 = j3;
                                                                            str5 = str18;
                                                                            str4 = str19;
                                                                            str6 = str12;
                                                                            str43 = str22;
                                                                            dXWidgetNode4 = dXWidgetNode11;
                                                                            vx.b(th);
                                                                            str7 = str4;
                                                                            u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                                            DXTraceUtil.c();
                                                                            if (view2 instanceof DXRootView) {
                                                                            }
                                                                            wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                                            if (dXRuntimeContext.hasError()) {
                                                                            }
                                                                            return view2;
                                                                        }
                                                                    } else {
                                                                        dXWidgetNode20 = j3;
                                                                        str31 = str17;
                                                                        str30 = str22;
                                                                        str36 = str18;
                                                                        str35 = str19;
                                                                        str34 = str48;
                                                                        str33 = str20;
                                                                        str32 = str12;
                                                                        try {
                                                                            u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_GET_ORIGIN_TREE_FAIL_ASYNC, "异步获取原型树失败", null, false);
                                                                        } catch (Throwable th13) {
                                                                            th = th13;
                                                                            dXWidgetNode4 = dXWidgetNode11;
                                                                            dXWidgetNode5 = dXWidgetNode10;
                                                                            str5 = str36;
                                                                            str4 = str35;
                                                                            str42 = str34;
                                                                            str2 = str33;
                                                                            str6 = str32;
                                                                            str = str11;
                                                                            str3 = str31;
                                                                            dXWidgetNode3 = dXWidgetNode20;
                                                                            str43 = str30;
                                                                            vx.b(th);
                                                                            str7 = str4;
                                                                            u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                                            DXTraceUtil.c();
                                                                            if (view2 instanceof DXRootView) {
                                                                            }
                                                                            wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                                            if (dXRuntimeContext.hasError()) {
                                                                            }
                                                                            return view2;
                                                                        }
                                                                    }
                                                                    DXTraceUtil.c();
                                                                    if (!(view2 instanceof DXRootView) || dXRenderOptions.e() != 0) {
                                                                        wz.b(str31 + dXRenderOptions.e() + str32 + view2 + str11 + dXRuntimeContext.getTemplateId());
                                                                    } else {
                                                                        DXRootView dXRootView3 = (DXRootView) view2;
                                                                        if (dXRootView3 == null || dXRootView3.getChildCount() != 0 || !dXRuntimeContext.hasError()) {
                                                                            StringBuilder sb3 = new StringBuilder();
                                                                            sb3.append(str35);
                                                                            if (dXRootView3 != null) {
                                                                                obj = Integer.valueOf(dXRootView3.getChildCount());
                                                                            }
                                                                            sb3.append(obj);
                                                                            sb3.append(str36);
                                                                            sb3.append(dXRuntimeContext.hasError());
                                                                            sb3.append(str30);
                                                                            sb3.append(dXRuntimeContext.getTemplateId());
                                                                            wz.b(sb3.toString());
                                                                        } else {
                                                                            e eVar4 = new e(this.b);
                                                                            eVar4.b = dXRuntimeContext.getDxTemplateItem();
                                                                            e.a aVar5 = new e.a(str33, str34, e.DXERROR_RENDER_DOWNGRADE);
                                                                            aVar5.e = dXRuntimeContext.getDxError().toString();
                                                                            eVar4.c.add(aVar5);
                                                                            DXAppMonitor.n(eVar4);
                                                                            h(dXRuntimeContext);
                                                                        }
                                                                    }
                                                                    if (dXRuntimeContext.hasError()) {
                                                                        try {
                                                                            w(dXRuntimeContext, dXWidgetNode20, dXWidgetNode11, dXWidgetNode10);
                                                                        } catch (Throwable th14) {
                                                                            vx.b(th14);
                                                                        }
                                                                        DXAppMonitor.n(dXRuntimeContext.getDxError());
                                                                    }
                                                                    return null;
                                                                } catch (Throwable th15) {
                                                                    th = th15;
                                                                    dXWidgetNode4 = dXWidgetNode11;
                                                                    str2 = str20;
                                                                    str4 = str19;
                                                                    str = str11;
                                                                    str3 = str17;
                                                                    dXWidgetNode5 = dXWidgetNode10;
                                                                    str6 = str12;
                                                                    dXWidgetNode3 = j3;
                                                                    str43 = str22;
                                                                    str42 = str48;
                                                                    str5 = str18;
                                                                    vx.b(th);
                                                                    str7 = str4;
                                                                    u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                                    DXTraceUtil.c();
                                                                    if (view2 instanceof DXRootView) {
                                                                    }
                                                                    wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                                    if (dXRuntimeContext.hasError()) {
                                                                    }
                                                                    return view2;
                                                                }
                                                            } else {
                                                                str14 = str18;
                                                                str15 = str19;
                                                                str13 = str48;
                                                                str16 = str12;
                                                                dXWidgetNode4 = dXWidgetNode11;
                                                                try {
                                                                    if (j3.getDXRuntimeContext() != null) {
                                                                        try {
                                                                            if (j3.getDXRuntimeContext().hasError()) {
                                                                                str25 = str38;
                                                                                dXWidgetNode19 = dXWidgetNode10;
                                                                                try {
                                                                                    dXRuntimeContext.dxError.c.addAll(j3.getDXRuntimeContext().dxError.c);
                                                                                    deepClone = j3.deepClone(dXRuntimeContext);
                                                                                    try {
                                                                                        str17 = str17;
                                                                                        nanoTime = System.nanoTime() - nanoTime12;
                                                                                        if (DinamicXEngine.x()) {
                                                                                            try {
                                                                                                dXRuntimeContext.getDxPerformInfo().a = ((float) nanoTime) / 1000000.0f;
                                                                                            } catch (Throwable th16) {
                                                                                                th = th16;
                                                                                                dXWidgetNode4 = deepClone;
                                                                                                dXWidgetNode3 = j3;
                                                                                                str2 = str20;
                                                                                                str43 = str22;
                                                                                                str = str11;
                                                                                                str3 = str17;
                                                                                                dXWidgetNode5 = dXWidgetNode19;
                                                                                            }
                                                                                        }
                                                                                        str20 = str20;
                                                                                        str22 = str22;
                                                                                        str50 = str29;
                                                                                        str24 = str41;
                                                                                        try {
                                                                                            v(dXRuntimeContext, "Pipeline_Stage_Get_Template_Widget", nanoTime, null);
                                                                                            t(dXRuntimeContext, LOAD_BINARY_TIME, nanoTime12);
                                                                                            dXRuntimeContext.putPerformTrackerData(LOAD_BINARY_TIME, String.valueOf(((float) (System.nanoTime() - nanoTime12)) / 1000000.0f));
                                                                                            if (view2 != null && at.F0()) {
                                                                                                view2.setTag(kz.a, deepClone);
                                                                                            }
                                                                                            str28 = str49;
                                                                                            DXPerformBaselineUtil.a(str28, nanoTime, dXRuntimeContext.getDxTemplateItem());
                                                                                            DXTraceUtil.c();
                                                                                            aVar2 = aVar;
                                                                                            str26 = str11;
                                                                                            dXWidgetNode10 = dXWidgetNode19;
                                                                                            dXWidgetNode13 = deepClone;
                                                                                            dXWidgetNode11 = dXWidgetNode13;
                                                                                            dXWidgetNode12 = j3;
                                                                                            str27 = str17;
                                                                                            view4 = view2;
                                                                                            i2 = i4 + 1;
                                                                                            dXRenderOptions2 = dXRenderOptions;
                                                                                            str49 = str28;
                                                                                            dXWidgetNode9 = dXWidgetNode13;
                                                                                            str11 = str26;
                                                                                            aVar = aVar2;
                                                                                            f2 = i5;
                                                                                            str38 = str25;
                                                                                            view3 = view4;
                                                                                            str39 = str23;
                                                                                            str43 = str22;
                                                                                            str40 = str21;
                                                                                            str46 = str20;
                                                                                            h2 = i3;
                                                                                            str12 = str16;
                                                                                            str45 = str15;
                                                                                            str44 = str14;
                                                                                            str47 = str27;
                                                                                            str41 = str24;
                                                                                            str48 = str13;
                                                                                        } catch (Throwable th17) {
                                                                                            th = th17;
                                                                                            str = str11;
                                                                                            dXWidgetNode5 = dXWidgetNode19;
                                                                                            dXWidgetNode4 = deepClone;
                                                                                            dXWidgetNode3 = j3;
                                                                                            str43 = str22;
                                                                                            str2 = str20;
                                                                                            str3 = str17;
                                                                                            str6 = str16;
                                                                                            str4 = str15;
                                                                                            str5 = str14;
                                                                                            str42 = str13;
                                                                                            vx.b(th);
                                                                                            str7 = str4;
                                                                                            u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                                                            DXTraceUtil.c();
                                                                                            if (view2 instanceof DXRootView) {
                                                                                            }
                                                                                            wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                                                            if (dXRuntimeContext.hasError()) {
                                                                                            }
                                                                                            return view2;
                                                                                        }
                                                                                    } catch (Throwable th18) {
                                                                                        th = th18;
                                                                                        dXWidgetNode5 = dXWidgetNode19;
                                                                                        dXWidgetNode4 = deepClone;
                                                                                        str2 = str20;
                                                                                        str43 = str22;
                                                                                        dXWidgetNode3 = j3;
                                                                                        str6 = str16;
                                                                                        str42 = str13;
                                                                                        str = str11;
                                                                                        str3 = str17;
                                                                                        str4 = str15;
                                                                                        str5 = str14;
                                                                                        vx.b(th);
                                                                                        str7 = str4;
                                                                                        u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                                                        DXTraceUtil.c();
                                                                                        if (view2 instanceof DXRootView) {
                                                                                        }
                                                                                        wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                                                        if (dXRuntimeContext.hasError()) {
                                                                                        }
                                                                                        return view2;
                                                                                    }
                                                                                } catch (Throwable th19) {
                                                                                    th = th19;
                                                                                }
                                                                            }
                                                                        } catch (Throwable th20) {
                                                                            th = th20;
                                                                            dXWidgetNode19 = dXWidgetNode10;
                                                                            dXWidgetNode3 = j3;
                                                                            str3 = str17;
                                                                            str2 = str20;
                                                                            str43 = str22;
                                                                            dXWidgetNode5 = dXWidgetNode19;
                                                                            str6 = str16;
                                                                            str4 = str15;
                                                                            str42 = str13;
                                                                            str = str11;
                                                                            str5 = str14;
                                                                            vx.b(th);
                                                                            str7 = str4;
                                                                            u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                                            DXTraceUtil.c();
                                                                            if (view2 instanceof DXRootView) {
                                                                            }
                                                                            wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                                            if (dXRuntimeContext.hasError()) {
                                                                            }
                                                                            return view2;
                                                                        }
                                                                    }
                                                                    str25 = str38;
                                                                    dXWidgetNode19 = dXWidgetNode10;
                                                                    try {
                                                                        deepClone = j3.deepClone(dXRuntimeContext);
                                                                        str17 = str17;
                                                                        nanoTime = System.nanoTime() - nanoTime12;
                                                                    } catch (Throwable th21) {
                                                                        th = th21;
                                                                        dXWidgetNode17 = j3;
                                                                        dXWidgetNode18 = dXWidgetNode19;
                                                                        str3 = str17;
                                                                        dXWidgetNode5 = dXWidgetNode18;
                                                                        str2 = str20;
                                                                        str43 = str22;
                                                                        dXWidgetNode3 = dXWidgetNode17;
                                                                        str6 = str16;
                                                                        str4 = str15;
                                                                        str42 = str13;
                                                                        str = str11;
                                                                        str5 = str14;
                                                                        vx.b(th);
                                                                        str7 = str4;
                                                                        u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                                        DXTraceUtil.c();
                                                                        if (view2 instanceof DXRootView) {
                                                                        }
                                                                        wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                                        if (dXRuntimeContext.hasError()) {
                                                                        }
                                                                        return view2;
                                                                    }
                                                                    try {
                                                                        if (DinamicXEngine.x()) {
                                                                        }
                                                                        str20 = str20;
                                                                        str22 = str22;
                                                                        str50 = str29;
                                                                        str24 = str41;
                                                                        v(dXRuntimeContext, "Pipeline_Stage_Get_Template_Widget", nanoTime, null);
                                                                        t(dXRuntimeContext, LOAD_BINARY_TIME, nanoTime12);
                                                                        dXRuntimeContext.putPerformTrackerData(LOAD_BINARY_TIME, String.valueOf(((float) (System.nanoTime() - nanoTime12)) / 1000000.0f));
                                                                        view2.setTag(kz.a, deepClone);
                                                                        str28 = str49;
                                                                        DXPerformBaselineUtil.a(str28, nanoTime, dXRuntimeContext.getDxTemplateItem());
                                                                        DXTraceUtil.c();
                                                                        aVar2 = aVar;
                                                                        str26 = str11;
                                                                        dXWidgetNode10 = dXWidgetNode19;
                                                                        dXWidgetNode13 = deepClone;
                                                                        dXWidgetNode11 = dXWidgetNode13;
                                                                        dXWidgetNode12 = j3;
                                                                        str27 = str17;
                                                                        view4 = view2;
                                                                        i2 = i4 + 1;
                                                                        dXRenderOptions2 = dXRenderOptions;
                                                                        str49 = str28;
                                                                        dXWidgetNode9 = dXWidgetNode13;
                                                                        str11 = str26;
                                                                        aVar = aVar2;
                                                                        f2 = i5;
                                                                        str38 = str25;
                                                                        view3 = view4;
                                                                        str39 = str23;
                                                                        str43 = str22;
                                                                        str40 = str21;
                                                                        str46 = str20;
                                                                        h2 = i3;
                                                                        str12 = str16;
                                                                        str45 = str15;
                                                                        str44 = str14;
                                                                        str47 = str27;
                                                                        str41 = str24;
                                                                        str48 = str13;
                                                                    } catch (Throwable th22) {
                                                                        th = th22;
                                                                        dXWidgetNode5 = dXWidgetNode19;
                                                                        dXWidgetNode4 = deepClone;
                                                                        str2 = str20;
                                                                        str43 = str22;
                                                                        dXWidgetNode3 = j3;
                                                                        str = str11;
                                                                        str3 = str17;
                                                                        str6 = str16;
                                                                        str4 = str15;
                                                                        str5 = str14;
                                                                        str42 = str13;
                                                                        vx.b(th);
                                                                        str7 = str4;
                                                                        u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                                        DXTraceUtil.c();
                                                                        if (view2 instanceof DXRootView) {
                                                                        }
                                                                        wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                                        if (dXRuntimeContext.hasError()) {
                                                                        }
                                                                        return view2;
                                                                    }
                                                                } catch (Throwable th23) {
                                                                    th = th23;
                                                                    dXWidgetNode18 = dXWidgetNode10;
                                                                    dXWidgetNode17 = j3;
                                                                    str3 = str17;
                                                                    dXWidgetNode5 = dXWidgetNode18;
                                                                    str2 = str20;
                                                                    str43 = str22;
                                                                    dXWidgetNode3 = dXWidgetNode17;
                                                                    str6 = str16;
                                                                    str4 = str15;
                                                                    str42 = str13;
                                                                    str = str11;
                                                                    str5 = str14;
                                                                    vx.b(th);
                                                                    str7 = str4;
                                                                    u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                                    DXTraceUtil.c();
                                                                    if (view2 instanceof DXRootView) {
                                                                    }
                                                                    wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                                    if (dXRuntimeContext.hasError()) {
                                                                    }
                                                                    return view2;
                                                                }
                                                            }
                                                        } catch (Throwable th24) {
                                                            th = th24;
                                                            dXWidgetNode4 = dXWidgetNode11;
                                                            str3 = str17;
                                                            str42 = str48;
                                                            str2 = str20;
                                                            dXWidgetNode5 = dXWidgetNode10;
                                                            dXWidgetNode3 = dXWidgetNode12;
                                                            str = str11;
                                                            str5 = str18;
                                                            str4 = str19;
                                                            str6 = str12;
                                                            str43 = str22;
                                                            vx.b(th);
                                                            str7 = str4;
                                                            u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                            DXTraceUtil.c();
                                                            if (view2 instanceof DXRootView) {
                                                            }
                                                            wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                            if (dXRuntimeContext.hasError()) {
                                                            }
                                                            return view2;
                                                        }
                                                    }
                                                } catch (Throwable th25) {
                                                    th = th25;
                                                    view2 = view4;
                                                    dXWidgetNode4 = dXWidgetNode11;
                                                    dXWidgetNode5 = dXWidgetNode10;
                                                    str42 = str48;
                                                    str43 = str22;
                                                    str6 = str12;
                                                    str = str11;
                                                    str2 = str20;
                                                    str4 = str19;
                                                    str5 = str18;
                                                    str3 = str17;
                                                    dXWidgetNode3 = dXWidgetNode12;
                                                    vx.b(th);
                                                    str7 = str4;
                                                    u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                                    DXTraceUtil.c();
                                                    if (view2 instanceof DXRootView) {
                                                    }
                                                    wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                                    if (dXRuntimeContext.hasError()) {
                                                    }
                                                    return view2;
                                                }
                                            } else {
                                                str25 = str38;
                                                str50 = str29;
                                                view5 = view4;
                                                str13 = str48;
                                                str28 = str49;
                                                str16 = str12;
                                                str26 = str11;
                                                dXWidgetNode14 = dXWidgetNode12;
                                                dXWidgetNode16 = dXWidgetNode11;
                                                dXWidgetNode15 = dXWidgetNode10;
                                                str15 = str19;
                                                str14 = str18;
                                                str24 = str41;
                                                str27 = str17;
                                                aVar2 = aVar;
                                                dXWidgetNode11 = dXWidgetNode16;
                                                dXWidgetNode10 = dXWidgetNode15;
                                                view4 = view5;
                                                dXWidgetNode12 = dXWidgetNode14;
                                                i2 = i4 + 1;
                                                dXRenderOptions2 = dXRenderOptions;
                                                str49 = str28;
                                                dXWidgetNode9 = dXWidgetNode13;
                                                str11 = str26;
                                                aVar = aVar2;
                                                f2 = i5;
                                                str38 = str25;
                                                view3 = view4;
                                                str39 = str23;
                                                str43 = str22;
                                                str40 = str21;
                                                str46 = str20;
                                                h2 = i3;
                                                str12 = str16;
                                                str45 = str15;
                                                str44 = str14;
                                                str47 = str27;
                                                str41 = str24;
                                                str48 = str13;
                                            }
                                        } catch (Throwable th26) {
                                            th = th26;
                                            view2 = view3;
                                            str3 = str47;
                                            str = str11;
                                            dXWidgetNode4 = dXWidgetNode11;
                                            str5 = str44;
                                            dXWidgetNode5 = dXWidgetNode10;
                                            str2 = str46;
                                            str42 = str48;
                                            str6 = str12;
                                            dXWidgetNode3 = dXWidgetNode12;
                                            str4 = str45;
                                            vx.b(th);
                                            str7 = str4;
                                            u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                            DXTraceUtil.c();
                                            if (view2 instanceof DXRootView) {
                                            }
                                            wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                            if (dXRuntimeContext.hasError()) {
                                            }
                                            return view2;
                                        }
                                    }
                                    str15 = str45;
                                    str14 = str44;
                                    view2 = view3;
                                    str3 = str47;
                                    str13 = str48;
                                    str16 = str12;
                                    str = str11;
                                    dXWidgetNode4 = dXWidgetNode11;
                                    if (!(j2 == null || z || dXWidgetNode9 == null)) {
                                        if (this.a.s() && i2 >= 4 && aVar != null) {
                                            j2.h(dXRuntimeContext, aVar);
                                        }
                                    }
                                    if (dXRuntimeContext != null && dXRuntimeContext.isRefreshPart() && dXRenderOptions.j() && dXWidgetNode9 != null) {
                                        dXWidgetNode9.updateRefreshType(0);
                                    }
                                    if ((view2 instanceof DXRootView) || dXRenderOptions.e() != 0) {
                                        wz.b(str3 + dXRenderOptions.e() + str16 + view2 + str + dXRuntimeContext.getTemplateId());
                                    } else {
                                        DXRootView dXRootView4 = (DXRootView) view2;
                                        if (dXRootView4 == null || dXRootView4.getChildCount() != 0 || !dXRuntimeContext.hasError()) {
                                            StringBuilder sb4 = new StringBuilder();
                                            sb4.append(str15);
                                            if (dXRootView4 != null) {
                                                obj = Integer.valueOf(dXRootView4.getChildCount());
                                            }
                                            sb4.append(obj);
                                            sb4.append(str14);
                                            sb4.append(dXRuntimeContext.hasError());
                                            sb4.append(str43);
                                            sb4.append(dXRuntimeContext.getTemplateId());
                                            wz.b(sb4.toString());
                                        } else {
                                            e eVar5 = new e(this.b);
                                            eVar5.b = dXRuntimeContext.getDxTemplateItem();
                                            e.a aVar6 = new e.a(str46, str13, e.DXERROR_RENDER_DOWNGRADE);
                                            aVar6.e = dXRuntimeContext.getDxError().toString();
                                            eVar5.c.add(aVar6);
                                            DXAppMonitor.n(eVar5);
                                            h(dXRuntimeContext);
                                        }
                                    }
                                    if (dXRuntimeContext.hasError()) {
                                        try {
                                            w(dXRuntimeContext, dXWidgetNode12, dXWidgetNode4, dXWidgetNode10);
                                        } catch (Throwable th27) {
                                            vx.b(th27);
                                        }
                                        DXAppMonitor.n(dXRuntimeContext.getDxError());
                                    }
                                    return view2;
                                }
                                str12 = " ";
                                str11 = "  tpl ";
                                dXWidgetNode12 = null;
                                dXWidgetNode11 = null;
                                dXWidgetNode10 = null;
                                i2 = a;
                                z = false;
                                dVar = dXWidgetNode2;
                                dXWidgetNode9 = dXWidgetNode;
                                aVar = null;
                                while (i2 <= f2) {
                                }
                                str15 = str45;
                                str14 = str44;
                                view2 = view3;
                                str3 = str47;
                                str13 = str48;
                                str16 = str12;
                                str = str11;
                                dXWidgetNode4 = dXWidgetNode11;
                                j2.h(dXRuntimeContext, aVar);
                                dXWidgetNode9.updateRefreshType(0);
                                if (view2 instanceof DXRootView) {
                                }
                                wz.b(str3 + dXRenderOptions.e() + str16 + view2 + str + dXRuntimeContext.getTemplateId());
                                if (dXRuntimeContext.hasError()) {
                                }
                            } catch (Throwable th28) {
                                th = th28;
                                str4 = str45;
                                str5 = str44;
                                view2 = view3;
                                str2 = str46;
                                str3 = str47;
                                dXWidgetNode4 = null;
                                dXWidgetNode3 = null;
                                str42 = str48;
                                str6 = " ";
                                str = "  tpl ";
                                dXWidgetNode5 = dXWidgetNode3;
                                vx.b(th);
                                str7 = str4;
                                u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                                DXTraceUtil.c();
                                if (view2 instanceof DXRootView) {
                                }
                                wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                                if (dXRuntimeContext.hasError()) {
                                }
                                return view2;
                            }
                            return view2;
                        }
                    } catch (Throwable th29) {
                        th = th29;
                        view3 = view;
                        str4 = str45;
                        str5 = str44;
                        view2 = view3;
                        str2 = str46;
                        str3 = str47;
                        dXWidgetNode4 = null;
                        dXWidgetNode3 = null;
                        str42 = str48;
                        str6 = " ";
                        str = "  tpl ";
                        dXWidgetNode5 = dXWidgetNode3;
                        vx.b(th);
                        str7 = str4;
                        u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                        DXTraceUtil.c();
                        if (view2 instanceof DXRootView) {
                        }
                        wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                        if (dXRuntimeContext.hasError()) {
                        }
                        return view2;
                    }
                }
                view3 = view;
                str12 = " ";
                str11 = "  tpl ";
                dXWidgetNode12 = null;
                dXWidgetNode11 = null;
                dXWidgetNode10 = null;
                i2 = a;
                z = false;
                dVar = dXWidgetNode2;
                dXWidgetNode9 = dXWidgetNode;
                aVar = null;
                while (i2 <= f2) {
                }
                str15 = str45;
                str14 = str44;
                view2 = view3;
                str3 = str47;
                str13 = str48;
                str16 = str12;
                str = str11;
                dXWidgetNode4 = dXWidgetNode11;
            } catch (Throwable th30) {
                th = th30;
                str = "  tpl ";
                str4 = str45;
                str5 = str44;
                str2 = str46;
                str3 = str47;
                str42 = str48;
                str6 = " ";
                view2 = view;
                dXWidgetNode5 = null;
                dXWidgetNode4 = null;
                dXWidgetNode3 = null;
                vx.b(th);
                str7 = str4;
                u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                DXTraceUtil.c();
                if (view2 instanceof DXRootView) {
                }
                wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                if (dXRuntimeContext.hasError()) {
                }
                return view2;
            }
            try {
                j2.h(dXRuntimeContext, aVar);
                dXWidgetNode9.updateRefreshType(0);
                if (view2 instanceof DXRootView) {
                }
                wz.b(str3 + dXRenderOptions.e() + str16 + view2 + str + dXRuntimeContext.getTemplateId());
                if (dXRuntimeContext.hasError()) {
                }
            } catch (Throwable th31) {
                th = th31;
                dXWidgetNode5 = dXWidgetNode10;
                str43 = str43;
                str2 = str46;
                dXWidgetNode3 = dXWidgetNode12;
                str6 = str16;
                str4 = str15;
                str5 = str14;
                str42 = str13;
                vx.b(th);
                str7 = str4;
                u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
                DXTraceUtil.c();
                if (view2 instanceof DXRootView) {
                }
                wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
                if (dXRuntimeContext.hasError()) {
                }
                return view2;
            }
        } catch (Throwable th32) {
            th = th32;
            str = "  tpl ";
            str4 = str45;
            str5 = str44;
            str2 = str46;
            str3 = str47;
            str6 = " ";
            view2 = view;
            dXWidgetNode5 = null;
            dXWidgetNode4 = null;
            dXWidgetNode3 = null;
            vx.b(th);
            str7 = str4;
            u(dXRuntimeContext.getDxError(), "Pipeline_Render", e.DXERROR_PIPELINE_CATCH, vx.a(th), null, false);
            DXTraceUtil.c();
            if (view2 instanceof DXRootView) {
            }
            wz.b(str3 + dXRenderOptions.e() + str6 + view2 + str + dXRuntimeContext.getTemplateId());
            if (dXRuntimeContext.hasError()) {
            }
            return view2;
        }
        return view2;
    }

    @Override // com.taobao.android.dinamicx.widget.event.IDXControlEventListener
    public void receivedControlEvent(final et etVar) {
        if (!(etVar instanceof jz ? ((jz) etVar).f : false) || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            c00.d();
            c00.m(new Runnable() {
                /* class com.taobao.android.dinamicx.DXRenderPipeline.AnonymousClass1 */

                public void run() {
                    DXRenderPipeline.this.p(etVar);
                }
            });
            return;
        }
        p(etVar);
    }

    /* access modifiers changed from: protected */
    public void v(DXRuntimeContext dXRuntimeContext, String str, long j2, Map<String, String> map) {
        if (map != null) {
            try {
                map.putAll(DXAppMonitor.g((float) j2));
            } catch (Exception e) {
                if (DinamicXEngine.x()) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        } else {
            map = DXAppMonitor.g((float) j2);
        }
        DXAppMonitor.s(1, dXRuntimeContext.bizType, "Pipeline", str, dXRuntimeContext.getDxTemplateItem(), map, (double) j2, true);
    }
}
