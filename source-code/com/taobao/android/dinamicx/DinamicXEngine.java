package com.taobao.android.dinamicx;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.android.dinamicx.DXRenderOptions;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback;
import com.taobao.android.dinamicx.asyncrender.a;
import com.taobao.android.dinamicx.config.IDXConfigInterface;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.eventchain.b;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import com.taobao.android.dinamicx.log.IDXRemoteDebugLog;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.monitor.DXPerformBaselineUtil;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.taobao.android.dinamicx.monitor.IDXAppMonitor;
import com.taobao.android.dinamicx.notification.DXNotificationCenter;
import com.taobao.android.dinamicx.notification.IDXNotificationListener;
import com.taobao.android.dinamicx.script.IDXJSEngine;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.IDXDownloader;
import com.taobao.android.dinamicx.timer.DXTimerListener;
import com.taobao.android.dinamicx.videoc.DXVideoControlConfig;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXAbTestInterface;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.IDXRichTextImageInterface;
import com.taobao.android.dinamicx.widget.IDXWebImageInterface;
import com.taobao.android.dinamicx.widget.IDXWebImageUrlInterface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.a10;
import tb.at;
import tb.d00;
import tb.dz;
import tb.f91;
import tb.ft;
import tb.gl1;
import tb.hy;
import tb.jx;
import tb.k10;
import tb.os;
import tb.ry;
import tb.ty;
import tb.v00;
import tb.vx;
import tb.wz;
import tb.xs;
import tb.xz;
import tb.yx;
import tb.zx;

/* compiled from: Taobao */
public final class DinamicXEngine extends b {
    public static final String ENGINE_INIT_ERROR_LOG_KEY = "DinamicXInitError";
    public static final String OPEN_TRACE_KEY_RENDER_TMPL = "renderForTemplate";
    public static final int REFRESH_TYPE_LAYOUT = 1;
    public static final int REFRESH_TYPE_PARSE = 0;
    public static final String RENDER_TEMPLATE = "renderTemplateTime";
    public static final String URL_SKIP_VERSION_KEY = "skipV";
    private static boolean w;
    private static boolean x;
    private static Context y;
    private static Class<? extends IDXJSEngine> z;
    private a10 d;
    private a e;
    private DXLongSparseArray<IDXDataParser> f;
    private DXLongSparseArray<IDXEventHandler> g;
    private DXLongSparseArray<IDXBuilderWidgetNode> h;
    DXRenderPipeline i;
    DXTemplateManager j;
    ft k;
    protected DXNotificationCenter l;
    h m;
    os n;
    private DXRemoteTimeInterface o;
    private yx p;
    private HashMap<String, IDXFunction> q;
    private zx r;
    private IDXJSEngine s;
    private Map<String, DXRemoteChildTemplateManager> t;
    b u;
    private k10 v;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface DXRefreshType {
    }

    public DinamicXEngine(@NonNull DXEngineConfig dXEngineConfig) {
        super(new d(dXEngineConfig));
        if (dXEngineConfig != null || !x()) {
            String str = null;
            if (!w || i() == null) {
                if (!x()) {
                    e eVar = new e(this.b);
                    e.a aVar = new e.a("Engine", "Engine_Init", e.DXError_EngineInitContextNUll);
                    String str2 = !w ? "没有初始化" : "context == null";
                    aVar.e = str2;
                    eVar.c.add(aVar);
                    DXAppMonitor.n(eVar);
                    y(eVar);
                    str = str2;
                } else {
                    throw new RuntimeException("DinamicX not initialize");
                }
            }
            try {
                this.c.n(this);
                this.f = new DXLongSparseArray<>(DXGlobalCenter.a);
                this.g = new DXLongSparseArray<>(DXGlobalCenter.b);
                this.h = new DXLongSparseArray<>(DXGlobalCenter.c);
                this.k = new ft();
                this.l = new DXNotificationCenter(this.a);
                DXTemplateManager s2 = s();
                this.j = s2;
                s2.m(this.a.d);
                this.m = new h(this.c);
                this.i = new DXRenderPipeline(this.c, this.j);
            } catch (Throwable th) {
                e eVar2 = new e(this.b);
                e.a aVar2 = new e.a("Engine", "Engine_Init", e.DXError_EngineInitException);
                aVar2.e = "30011reason=" + str + "-" + vx.a(th);
                eVar2.c.add(aVar2);
                DXAppMonitor.n(eVar2);
                vx.b(th);
                y(eVar2);
            }
            G(false);
            q();
            p();
            v(dXEngineConfig);
            u();
            r(dXEngineConfig);
            at.Z();
            t(dXEngineConfig);
            return;
        }
        throw new RuntimeException("DXEngineConfig cannot be null");
    }

    private void D(@NonNull DXTemplateItem dXTemplateItem) {
        int i2;
        dXTemplateItem.skipVersions = new ArrayList();
        if (!TextUtils.isEmpty(dXTemplateItem.templateUrl)) {
            char[] charArray = dXTemplateItem.templateUrl.toCharArray();
            int length = charArray.length;
            while (true) {
                length--;
                if (length < 0) {
                    i2 = 0;
                    break;
                } else if (charArray[length] == '?') {
                    i2 = length + 1;
                    break;
                }
            }
            if (i2 > 0) {
                StringBuilder sb = new StringBuilder();
                while (i2 < charArray.length) {
                    if (charArray[i2] != '=') {
                        sb.append(charArray[i2]);
                    } else if (sb.toString().equalsIgnoreCase(URL_SKIP_VERSION_KEY)) {
                        StringBuilder sb2 = new StringBuilder();
                        int i3 = i2 + 1;
                        while (true) {
                            if (i3 < charArray.length) {
                                if (charArray[i3] == '&') {
                                    sb.setLength(0);
                                    i2 = i3;
                                    break;
                                }
                                sb2.append(charArray[i3]);
                                i3++;
                            } else {
                                break;
                            }
                        }
                        dXTemplateItem.skipVersions.add(sb2.toString());
                    } else {
                        sb.setLength(0);
                    }
                    i2++;
                }
            }
        }
    }

    public static void G(boolean z2) {
        try {
            ry.b(ry.TAG, "DinamicX processWindowChanged forceChange" + z2);
            d00.d(z2);
        } catch (Exception e2) {
            vx.b(e2);
        }
    }

    private void S(DXTemplateItem dXTemplateItem, String str, long j2, Map<String, String> map) {
        DXAppMonitor.s(0, this.b, "Engine", str, dXTemplateItem, map, (double) j2, true);
    }

    public static Context i() {
        return y;
    }

    private void p() {
        try {
            this.e = new a(this.c);
        } catch (Throwable th) {
            DXAppMonitor.q(this.b, null, "AsyncRender", "Async_Render_3.0_init_Crash", e.V3_ASYNC_RENDER_INIT_CRASH, vx.a(th));
        }
    }

    private void q() {
        try {
            this.n = new os(this.c);
            if (x()) {
                f91.a = false;
            }
        } catch (Throwable th) {
            vx.b(th);
            DXAppMonitor.q(this.b, null, "DX_BindingX", "DX_BindingX_Crash", e.BINDINGX_INIT_CRASH, vx.a(th));
        }
    }

    private void r(DXEngineConfig dXEngineConfig) {
        try {
            yx yxVar = new yx();
            this.p = yxVar;
            this.c.l(yxVar);
            this.q = new HashMap<>();
            Class<? extends IDXJSEngine> cls = z;
            if (cls != null) {
                this.s = (IDXJSEngine) cls.newInstance();
            }
            zx zxVar = new zx(this.q, this.s);
            this.r = zxVar;
            this.c.m(zxVar);
        } catch (Throwable th) {
            vx.b(th);
            DXAppMonitor.q(this.b, null, "DX_SCRIPT", "DX_SCRIPT_ERROR", e.DXSCRIPT_INIT_ERROR, vx.a(th));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    private DXTemplateManager s() {
        hy hyVar;
        DXTemplateManager dXTemplateManager = new DXTemplateManager(this.c, y);
        if (!x()) {
            return dXTemplateManager;
        }
        Class<?> cls = Class.forName("com.taobao.android.dinamicx.DXDevTemplateManager");
        Method method = cls.getMethod("getDXDevFileManager", new Class[0]);
        DXTemplateManager dXTemplateManager2 = null;
        if (method != null) {
            method.setAccessible(true);
            hyVar = (hy) method.invoke(null, new Object[0]);
        } else {
            hyVar = null;
        }
        Method method2 = cls.getMethod("newDXDevTemplateManager", d.class, Context.class);
        if (method2 != null) {
            method2.setAccessible(true);
            dXTemplateManager2 = (DXTemplateManager) method2.invoke(null, this.c, y);
        }
        if (dXTemplateManager2 == null || hyVar == null) {
            return dXTemplateManager;
        }
        hy.h(hyVar);
        return dXTemplateManager2;
    }

    private void t(DXEngineConfig dXEngineConfig) {
        try {
            this.v = new k10(dXEngineConfig.l() != null ? dXEngineConfig.l() : DXVideoControlConfig.j());
            if (at.C0() && dXEngineConfig.q()) {
                this.v.a();
            }
        } catch (Throwable th) {
            DXAppMonitor.q(this.b, null, "DX_Video_Control", "DX_Video_Control_Init_Crash", e.DX_VIDEO_CONTROL_INIT_CRASH, vx.a(th));
        }
    }

    private void u() {
        try {
            this.u = new b(this.c);
        } catch (Throwable th) {
            vx.b(th);
            DXAppMonitor.q(this.b, null, "DX_EventChain", "DX_EventChain_Crash", e.EVENTCHAIN_INIT_CRASH, vx.a(th));
        }
    }

    private void v(@NonNull DXEngineConfig dXEngineConfig) {
        try {
            this.d = new a10(dXEngineConfig.k());
        } catch (Throwable th) {
            vx.b(th);
            DXAppMonitor.q(this.b, null, "Engine", "Engine_Init", e.DXERROR_ENGINE_INIT_EXCEPTION_TIMER_ERROR, vx.a(th));
        }
    }

    public static void w(@NonNull Context context, @Nullable f fVar) {
        try {
            long nanoTime = System.nanoTime();
            if (!w) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    y = applicationContext;
                } else {
                    y = context;
                }
                w = true;
                if (fVar != null) {
                    x = fVar.m;
                    IDXRemoteDebugLog iDXRemoteDebugLog = fVar.f;
                    if (iDXRemoteDebugLog != null) {
                        wz.g(iDXRemoteDebugLog);
                    }
                    IDXAppMonitor iDXAppMonitor = fVar.e;
                    if (iDXAppMonitor != null) {
                        DXAppMonitor.j(iDXAppMonitor);
                    }
                    DXLongSparseArray<IDXDataParser> dXLongSparseArray = fVar.b;
                    if (dXLongSparseArray != null) {
                        DXGlobalCenter.a.putAll(dXLongSparseArray);
                    }
                    if (y == null) {
                        e eVar = new e("initialize");
                        e.a aVar = new e.a("Engine", "SDK_InitEnv", e.DXError_SDKInitException);
                        String str = "";
                        if (applicationContext == null) {
                            str = str + "applicationContext == null";
                        }
                        aVar.e = str;
                        eVar.c.add(aVar);
                        DXAppMonitor.n(eVar);
                        y(eVar);
                    }
                    for (int i2 = 0; i2 < DXGlobalCenter.a.size(); i2++) {
                        IDXDataParser valueAt = DXGlobalCenter.a.valueAt(i2);
                        if ((valueAt instanceof com.taobao.android.dinamicx.expression.parser.a) && !TextUtils.isEmpty(((com.taobao.android.dinamicx.expression.parser.a) valueAt).getDxFunctionName())) {
                            yx.d(((com.taobao.android.dinamicx.expression.parser.a) valueAt).getDxFunctionName(), (com.taobao.android.dinamicx.expression.parser.a) valueAt);
                        }
                    }
                    DXLongSparseArray<IDXEventHandler> dXLongSparseArray2 = fVar.a;
                    if (dXLongSparseArray2 != null) {
                        DXGlobalCenter.b.putAll(dXLongSparseArray2);
                    }
                    for (int i3 = 0; i3 < DXGlobalCenter.b.size(); i3++) {
                        IDXEventHandler valueAt2 = DXGlobalCenter.b.valueAt(i3);
                        if ((valueAt2 instanceof a) && !TextUtils.isEmpty(((a) valueAt2).getDxFunctionName())) {
                            yx.d(((a) valueAt2).getDxFunctionName(), (a) valueAt2);
                        }
                    }
                    DXLongSparseArray<IDXBuilderWidgetNode> dXLongSparseArray3 = fVar.c;
                    if (dXLongSparseArray3 != null) {
                        DXGlobalCenter.c.putAll(dXLongSparseArray3);
                    }
                    IDXDownloader iDXDownloader = fVar.d;
                    if (iDXDownloader != null) {
                        DXGlobalCenter.d = iDXDownloader;
                    }
                    IDXWebImageInterface iDXWebImageInterface = fVar.g;
                    if (iDXWebImageInterface != null) {
                        DXGlobalCenter.e = iDXWebImageInterface;
                    }
                    IDXRichTextImageInterface iDXRichTextImageInterface = fVar.i;
                    if (iDXRichTextImageInterface != null) {
                        DXGlobalCenter.f = iDXRichTextImageInterface;
                    }
                    IDXAbTestInterface iDXAbTestInterface = fVar.q;
                    if (iDXAbTestInterface != null) {
                        DXGlobalCenter.g = iDXAbTestInterface;
                    }
                    IDXConfigInterface iDXConfigInterface = fVar.j;
                    if (iDXConfigInterface != null) {
                        DXGlobalCenter.j = iDXConfigInterface;
                    }
                    IDXWebImageInterface iDXWebImageInterface2 = fVar.h;
                    if (iDXWebImageInterface2 != null) {
                        DXGlobalCenter.i = iDXWebImageInterface2;
                    }
                    IDXHardwareInterface iDXHardwareInterface = fVar.r;
                    if (iDXHardwareInterface != null) {
                        DXGlobalCenter.h = iDXHardwareInterface;
                    }
                    at.K0();
                    int i4 = fVar.o;
                    if (i4 != 0) {
                        d00.a(i4);
                    }
                    IDXDarkModeInterface iDXDarkModeInterface = fVar.k;
                    if (iDXDarkModeInterface != null) {
                        DXDarkModeCenter.b = iDXDarkModeInterface;
                    }
                    Class<? extends IDXJSEngine> cls = fVar.p;
                    if (cls != null) {
                        z = cls;
                    }
                    IDXElderInterface iDXElderInterface = fVar.s;
                    if (iDXElderInterface != null) {
                        c.a = iDXElderInterface;
                    }
                    IDXElderTextSizeStrategy iDXElderTextSizeStrategy = fVar.t;
                    if (iDXElderTextSizeStrategy != null) {
                        c.b = new jx(iDXElderTextSizeStrategy);
                    }
                    IDXWebImageUrlInterface iDXWebImageUrlInterface = fVar.u;
                    if (iDXWebImageUrlInterface != null) {
                        DXGlobalCenter.k = iDXWebImageUrlInterface;
                    }
                    DXDarkModeCenter.a = fVar.n;
                    Log.e(ry.TAG, "DX初始化完成，时间为：" + (System.nanoTime() - nanoTime));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean x() {
        return x;
    }

    private static void y(e eVar) {
        Log.e(ENGINE_INIT_ERROR_LOG_KEY, eVar.toString());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private DXRuntimeContext z(Context context, DXRootView dXRootView, DXTemplateItem dXTemplateItem, JSONObject jSONObject, DXRenderPipeline dXRenderPipeline, DXRenderOptions dXRenderOptions) {
        DXRuntimeContext dXRuntimeContext = new DXRuntimeContext(this.c);
        dXRuntimeContext.contextWeakReference = new WeakReference<>(context);
        dXRuntimeContext.parserMap = this.f;
        dXRuntimeContext.eventHandlerMapWeakReference = new WeakReference<>(this.g);
        dXRuntimeContext.widgetNodeMap = this.h;
        dXRuntimeContext.dxControlEventCenterWeakReference = new WeakReference<>(this.k);
        dXRuntimeContext.dxRenderPipelineWeakReference = new WeakReference<>(dXRenderPipeline);
        dXRuntimeContext.dxNotificationCenterWeakReference = new WeakReference<>(this.l);
        dXRuntimeContext.dxTemplateItem = dXTemplateItem;
        dXRuntimeContext.rootViewWeakReference = new WeakReference<>(dXRootView);
        dXRuntimeContext.setData(jSONObject);
        e eVar = new e(this.b);
        dXRuntimeContext.dxError = eVar;
        eVar.b = dXTemplateItem;
        dXRuntimeContext.refreshType = 0;
        if (dXRenderOptions != null) {
            dXRuntimeContext.dxUserContext = dXRenderOptions.c();
            dXRenderOptions.g();
            dXRuntimeContext.renderType = dXRenderOptions.e();
            dXRuntimeContext.rootWidthSpec = dXRenderOptions.h();
            dXRuntimeContext.rootHeightSpec = dXRenderOptions.b();
        }
        return dXRuntimeContext;
    }

    public void A() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.r();
        }
        os osVar = this.n;
        if (!(osVar == null || osVar.g() == null)) {
            this.n.g().d();
        }
        a10 a10 = this.d;
        if (a10 != null) {
            a10.d();
        }
        k10 k10 = this.v;
        if (k10 != null) {
            k10.destroy();
        }
        e();
        IDXJSEngine iDXJSEngine = this.s;
        if (iDXJSEngine != null) {
            try {
                iDXJSEngine.destroy();
            } catch (Throwable th) {
                vx.b(th);
            }
        }
    }

    public void B(DXRootView dXRootView) {
        if (dXRootView != null) {
            dXRootView.onRootViewAppear(-1);
        }
    }

    public void C(DXRootView dXRootView) {
        if (dXRootView != null) {
            dXRootView.onRootViewDisappear(-1);
        }
    }

    public void E(DXRootView dXRootView, Object obj) {
        DXWidgetNode expandWidgetNode;
        JSONObject jSONObject;
        DXWidgetNode expandWidgetNode2;
        JSONObject jSONObject2;
        os osVar;
        try {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject3 = (JSONObject) obj;
                String string = jSONObject3.getString("type");
                if ("BNDX".equalsIgnoreCase(string) && (osVar = this.n) != null) {
                    osVar.m(dXRootView, jSONObject3);
                } else if ("General".equalsIgnoreCase(string)) {
                    if (dXRootView != null && (expandWidgetNode2 = dXRootView.getExpandWidgetNode()) != null && (jSONObject2 = jSONObject3.getJSONObject("params")) != null) {
                        String string2 = jSONObject2.getString("targetId");
                        if (TextUtils.isEmpty(string2) && jSONObject2.containsKey("target")) {
                            string2 = jSONObject2.getString("target");
                        }
                        String string3 = jSONObject2.getString("method");
                        ty tyVar = new ty(-1747756056147111305L);
                        tyVar.j(jSONObject2);
                        tyVar.k(string2);
                        tyVar.l(string);
                        tyVar.i(string3);
                        DXWidgetNode queryWidgetNodeByUserId = expandWidgetNode2.queryWidgetNodeByUserId(string2);
                        if (queryWidgetNodeByUserId == null || queryWidgetNodeByUserId.getReferenceNode() == null) {
                            expandWidgetNode2.sendBroadcastEvent(tyVar);
                        } else {
                            queryWidgetNodeByUserId.postEvent(tyVar);
                        }
                    }
                } else if (dXRootView != null && (expandWidgetNode = dXRootView.getExpandWidgetNode()) != null && (jSONObject = jSONObject3.getJSONObject("params")) != null) {
                    String string4 = jSONObject.getString("targetId");
                    ty tyVar2 = new ty(-1747756056147111305L);
                    tyVar2.j(jSONObject);
                    tyVar2.k(string4);
                    tyVar2.l(string);
                    DXWidgetNode queryWidgetNodeByUserId2 = expandWidgetNode.queryWidgetNodeByUserId(string4);
                    if (queryWidgetNodeByUserId2 == null) {
                        expandWidgetNode.sendBroadcastEvent(tyVar2);
                    } else {
                        queryWidgetNodeByUserId2.postEvent(tyVar2);
                    }
                }
            }
        } catch (Throwable th) {
            vx.b(th);
            String a = a();
            if (TextUtils.isEmpty(a)) {
                a = v00.DB_NAME;
            }
            DXAppMonitor.q(a, null, "Engine", "Engine_Post_Message", e.ENGINE_POST_MSG_CRASH, vx.a(th));
        }
    }

    public void F(DXRuntimeContext dXRuntimeContext, final DXRenderOptions dXRenderOptions, final View view, @Nullable final DXAsyncRenderCallback<DXRuntimeContext> dXAsyncRenderCallback) {
        if (this.e != null) {
            final DXWidgetNode a = xs.a(dXRuntimeContext, dXRuntimeContext.widgetNode);
            if (at.r0()) {
                a.setParentWidget(dXRuntimeContext.widgetNode.getParentWidget());
            }
            this.e.F(new Runnable() {
                /* class com.taobao.android.dinamicx.DinamicXEngine.AnonymousClass2 */

                public void run() {
                    DXRenderOptions dXRenderOptions;
                    try {
                        if (dXRenderOptions != null) {
                            dXRenderOptions = new DXRenderOptions.b().r(1).s(dXRenderOptions.f()).l(dXRenderOptions.a()).u(dXRenderOptions.h()).m(dXRenderOptions.b()).t(dXRenderOptions.g()).n(dXRenderOptions.i()).o(dXRenderOptions.j()).k();
                        } else {
                            dXRenderOptions = new DXRenderOptions.b().r(1).s(4).k();
                        }
                        DinamicXEngine.this.e.v(a.getDXRuntimeContext(), dXRenderOptions, null, view, dXAsyncRenderCallback);
                    } catch (Throwable th) {
                        vx.b(th);
                    }
                }
            });
        }
    }

    public void H(String str, IDXFunction iDXFunction) {
        if (!TextUtils.isEmpty(str) && iDXFunction != null) {
            this.q.put(str, iDXFunction);
        }
    }

    public void I(DXRootView dXRootView, DXRootView.a aVar) {
        if (dXRootView != null) {
            dXRootView.registerDXRootViewLifeCycle(aVar);
        }
    }

    public boolean J(long j2, IDXDataParser iDXDataParser) {
        DXLongSparseArray<IDXDataParser> dXLongSparseArray;
        if (j2 == 0 || iDXDataParser == null || (dXLongSparseArray = this.f) == null) {
            return false;
        }
        dXLongSparseArray.put(j2, iDXDataParser);
        if (!(iDXDataParser instanceof com.taobao.android.dinamicx.expression.parser.a)) {
            return true;
        }
        com.taobao.android.dinamicx.expression.parser.a aVar = (com.taobao.android.dinamicx.expression.parser.a) iDXDataParser;
        if (TextUtils.isEmpty(aVar.getDxFunctionName())) {
            return true;
        }
        H(aVar.getDxFunctionName(), aVar);
        return true;
    }

    public boolean K(long j2, IDXEventHandler iDXEventHandler) {
        DXLongSparseArray<IDXEventHandler> dXLongSparseArray;
        if (j2 == 0 || (dXLongSparseArray = this.g) == null || iDXEventHandler == null) {
            return false;
        }
        dXLongSparseArray.put(j2, iDXEventHandler);
        return true;
    }

    public void L(IDXNotificationListener iDXNotificationListener) {
        if (iDXNotificationListener != null) {
            try {
                DXNotificationCenter dXNotificationCenter = this.l;
                if (dXNotificationCenter != null) {
                    dXNotificationCenter.g(iDXNotificationListener);
                }
            } catch (Throwable th) {
                e eVar = new e(this.a.a);
                e.a aVar = new e.a("Engine", "Engine_Register_Notification", e.DXERROR_REGISTER_NOTIFICATION_CRASH);
                aVar.e = vx.a(th);
                eVar.c.add(aVar);
                DXAppMonitor.n(eVar);
            }
        }
    }

    public void M(DXTimerListener dXTimerListener, long j2) {
        this.d.f(dXTimerListener, j2);
    }

    public boolean N(long j2, IDXBuilderWidgetNode iDXBuilderWidgetNode) {
        DXLongSparseArray<IDXBuilderWidgetNode> dXLongSparseArray;
        if (j2 == 0 || iDXBuilderWidgetNode == null || (dXLongSparseArray = this.h) == null) {
            return false;
        }
        dXLongSparseArray.put(j2, iDXBuilderWidgetNode);
        return true;
    }

    public xz<DXRootView> O(Context context, JSONObject jSONObject, @NonNull DXRootView dXRootView, int i2, int i3, Object obj) {
        Throwable th;
        DXTemplateItem dXTemplateItem;
        try {
            dXTemplateItem = dXRootView.dxTemplateItem;
            try {
                return P(context, dXRootView, dXTemplateItem, jSONObject, -1, new DXRenderOptions.b().u(i2).m(i3).p(obj).k());
            } catch (Throwable th2) {
                th = th2;
                vx.b(th);
                e eVar = new e(this.b);
                eVar.b = dXTemplateItem;
                e.a aVar = new e.a("Engine", "Engine_Render", e.DXError_EngineRenderException);
                aVar.e = vx.a(th);
                eVar.c.add(aVar);
                DXAppMonitor.n(eVar);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            dXTemplateItem = null;
            vx.b(th);
            e eVar2 = new e(this.b);
            eVar2.b = dXTemplateItem;
            e.a aVar2 = new e.a("Engine", "Engine_Render", e.DXError_EngineRenderException);
            aVar2.e = vx.a(th);
            eVar2.c.add(aVar2);
            DXAppMonitor.n(eVar2);
            return null;
        }
    }

    public xz<DXRootView> P(Context context, DXRootView dXRootView, DXTemplateItem dXTemplateItem, JSONObject jSONObject, int i2, DXRenderOptions dXRenderOptions) {
        String str;
        String str2;
        Throwable th;
        FalcoContainerSpan falcoContainerSpan;
        String str3 = "data is not null";
        if (dXTemplateItem == null) {
            try {
                String str4 = this.b;
                wz.c(str4, "renderTemplate", null, null, "DXTemplate 为空 + positon=" + i2);
                xz<DXRootView> xzVar = new xz<>();
                xzVar.f(null);
                e eVar = new e(this.b);
                e.a aVar = new e.a("Engine", "Engine_Render", e.DXERROR_ENGINERENDER_TEMPLATE_NULL);
                StringBuilder sb = new StringBuilder();
                sb.append("position=");
                sb.append(i2);
                sb.append(gl1.KEY_H5_DATA_PREFIX);
                if (jSONObject == null) {
                    str3 = "data is null";
                }
                sb.append(str3);
                aVar.e = sb.toString();
                eVar.c.add(aVar);
                xzVar.d(eVar);
                return xzVar;
            } catch (Throwable th2) {
                th = th2;
                str2 = "Engine_Render";
                str = "Engine";
                vx.b(th);
                e eVar2 = new e(this.b);
                eVar2.b = dXTemplateItem;
                e.a aVar2 = new e.a(str, str2, e.DXError_EngineRenderException);
                aVar2.e = vx.a(th);
                eVar2.c.add(aVar2);
                DXAppMonitor.n(eVar2);
                DXTraceUtil.c();
                return null;
            }
        } else if (!dXTemplateItem.checkValid()) {
            xz<DXRootView> xzVar2 = new xz<>();
            xzVar2.f(null);
            e eVar3 = new e(this.b);
            e.a aVar3 = new e.a("Engine", "Engine_Render", e.DXERROR_ENGINERENDER_INVALID_PARAMS);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("参数校验不合法 position=");
            sb2.append(i2);
            sb2.append(gl1.KEY_H5_DATA_PREFIX);
            if (jSONObject == null) {
                str3 = "data is null";
            }
            sb2.append(str3);
            aVar3.e = sb2.toString();
            eVar3.c.add(aVar3);
            xzVar2.d(eVar3);
            DXAppMonitor.n(eVar3);
            return xzVar2;
        } else {
            DXTraceUtil.b("DX-RenderTemplate", " : ", dXTemplateItem.getIdentifier());
            long nanoTime = System.nanoTime();
            DXRenderOptions dXRenderOptions2 = dXRenderOptions == null ? DXRenderOptions.DEFAULT_RENDER_OPTIONS : dXRenderOptions;
            DXRuntimeContext z2 = z(context, dXRootView, dXTemplateItem, jSONObject, this.i, dXRenderOptions2);
            if (dXRenderOptions2.d() == null || !this.a.n()) {
                falcoContainerSpan = null;
            } else {
                FalcoContainerSpan e2 = dz.e(dXRenderOptions2.d(), "DX", RENDER_TEMPLATE);
                dz.q(e2, OPEN_TRACE_KEY_RENDER_TMPL, String.format("templateInfo:name:%s,version:%s", dXTemplateItem.name, Long.valueOf(dXTemplateItem.version)));
                z2.setOpenTracerSpan(e2);
                falcoContainerSpan = e2;
            }
            a aVar4 = this.e;
            if (aVar4 != null) {
                aVar4.i(z2);
            }
            xz<DXRootView> q2 = this.i.q(dXRootView, z2, i2, dXRenderOptions2);
            if (x() && q2 != null && q2.c()) {
                ry.g(ry.TAG, q2.a().toString());
            }
            long nanoTime2 = System.nanoTime() - nanoTime;
            if (x()) {
                q2.e(z2.getDxPerformInfo());
                q2.b().g = ((float) nanoTime2) / 1000000.0f;
            }
            z2.putPerformTrackerData(RENDER_TEMPLATE, String.valueOf(((float) nanoTime2) / 1000000.0f));
            str2 = "Engine_Render";
            str = "Engine";
            try {
                S(dXTemplateItem, "Engine_Render", nanoTime2, z2.getDxPerformTrackerData());
                dz.l(falcoContainerSpan);
                DXTraceUtil.c();
                DXPerformBaselineUtil.a("DX-RenderTemplate", nanoTime2, dXTemplateItem);
                return q2;
            } catch (Throwable th3) {
                th = th3;
                vx.b(th);
                e eVar22 = new e(this.b);
                eVar22.b = dXTemplateItem;
                e.a aVar22 = new e.a(str, str2, e.DXError_EngineRenderException);
                aVar22.e = vx.a(th);
                eVar22.c.add(aVar22);
                DXAppMonitor.n(eVar22);
                DXTraceUtil.c();
                return null;
            }
        }
    }

    public xz<DXRootView> Q(DXRootView dXRootView, JSONObject jSONObject) {
        if (dXRootView != null) {
            try {
                if (!(dXRootView.getContext() == null || dXRootView.dxTemplateItem == null)) {
                    return O(dXRootView.getContext(), jSONObject, dXRootView, d00.f(), d00.e(), null);
                }
            } catch (Throwable th) {
                if (x()) {
                    th.printStackTrace();
                }
                e eVar = new e(this.b);
                if (dXRootView != null) {
                    eVar.b = dXRootView.dxTemplateItem;
                }
                e.a aVar = new e.a("Engine", "Engine_Render", e.DXError_EngineRenderException);
                aVar.e = vx.a(th);
                eVar.c.add(aVar);
                DXAppMonitor.n(eVar);
                return new xz<>(eVar);
            }
        }
        e eVar2 = new e(this.b);
        e.a aVar2 = new e.a("Engine", "Engine_Render", e.DXError_EngineRenderException);
        aVar2.e = "dxRootView == null || dxRootView.getContext() == null || dxRootView.dxTemplateItem == null";
        eVar2.c.add(aVar2);
        DXAppMonitor.n(eVar2);
        return new xz<>(eVar2);
    }

    public void R() {
        h hVar = this.m;
        if (hVar != null) {
            hVar.d();
        }
        a aVar = this.e;
        if (aVar != null) {
            aVar.w();
        }
        b o2 = o();
        if (o2 != null) {
            o2.l();
        }
    }

    public void T(DXTimerListener dXTimerListener) {
        this.d.h(dXTimerListener);
    }

    public void e() {
        b bVar = this.u;
        if (bVar != null) {
            bVar.c();
        }
    }

    public xz<DXRootView> f(Context context, DXTemplateItem dXTemplateItem) {
        DXRootView dXRootView = new DXRootView(context);
        dXRootView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        dXRootView.dxTemplateItem = dXTemplateItem;
        dXRootView.setBindingXManagerWeakReference(this.n);
        return new xz<>(dXRootView);
    }

    public void g(List<DXTemplateItem> list) {
        try {
            this.j.f(list);
        } catch (Throwable th) {
            if (x()) {
                th.printStackTrace();
            }
            e eVar = new e(this.b);
            e.a aVar = new e.a("Engine", "Engine_Download", e.DXError_EngineDownloadException);
            aVar.e = "downLoadTemplates error " + vx.a(th);
            eVar.c.add(aVar);
            DXAppMonitor.n(eVar);
        }
    }

    public DXTemplateItem h(DXTemplateItem dXTemplateItem) {
        if (dXTemplateItem == null) {
            return null;
        }
        try {
            if (at.B0()) {
                try {
                    D(dXTemplateItem);
                } catch (Throwable th) {
                    vx.b(th);
                    e eVar = new e(this.b);
                    e.a aVar = new e.a("Engine", "Engine_Fetch", e.DXError_EngineFetchException);
                    eVar.b = dXTemplateItem;
                    aVar.e = vx.a(th);
                    eVar.c.add(aVar);
                    DXAppMonitor.n(eVar);
                    dXTemplateItem.skipVersions = null;
                }
            }
            long nanoTime = System.nanoTime();
            DXTemplateItem h2 = this.j.h(dXTemplateItem);
            long nanoTime2 = System.nanoTime() - nanoTime;
            S(dXTemplateItem, "Engine_Fetch", nanoTime2, DXAppMonitor.g((float) nanoTime2));
            return h2;
        } catch (Throwable th2) {
            if (x()) {
                th2.printStackTrace();
            }
            e eVar2 = new e(this.b);
            e.a aVar2 = new e.a("Engine", "Engine_Fetch", e.DXError_EngineFetchException);
            eVar2.b = dXTemplateItem;
            aVar2.e = vx.a(th2);
            eVar2.c.add(aVar2);
            DXAppMonitor.n(eVar2);
            return null;
        }
    }

    public IDXJSEngine j() {
        return this.s;
    }

    @Nullable
    public a k() {
        return this.e;
    }

    public Map<String, DXRemoteChildTemplateManager> l() {
        if (this.t == null) {
            this.t = new ConcurrentHashMap();
        }
        return this.t;
    }

    /* access modifiers changed from: protected */
    public DXRemoteTimeInterface m() {
        return this.o;
    }

    @Nullable
    public k10 n() {
        return this.v;
    }

    public b o() {
        return this.u;
    }
}
