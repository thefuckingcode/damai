package com.taobao.android.dinamicx.monitor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.thread.DXMonitorRunnable;
import com.youku.arch.v3.data.Constants;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.c00;
import tb.jl1;
import tb.ry;
import tb.vx;
import tb.wz;

/* compiled from: Taobao */
public class DXAppMonitor {
    private static IDXAppMonitor a;
    private static int b;

    /* access modifiers changed from: private */
    public static String e(String str, String str2, DXTemplateItem dXTemplateItem, Map<String, String> map, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(jl1.ARRAY_START_STR);
        sb.append(str);
        sb.append("]:");
        sb.append(str2);
        sb.append("|");
        JSONObject jSONObject = new JSONObject();
        if (dXTemplateItem != null) {
            jSONObject.put(Constants.TEMPLATE, (Object) dXTemplateItem.name);
            jSONObject.put("version", (Object) Long.valueOf(dXTemplateItem.version));
        }
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), (Object) entry.getValue());
            }
        }
        if (str3 != null) {
            jSONObject.put("error", (Object) str3);
        }
        sb.append(jSONObject.toJSONString());
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static JSONObject f(String str, String str2, @NonNull String str3, DXTemplateItem dXTemplateItem, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bizName", (Object) ry.TAG);
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("sceneName", (Object) str);
        }
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("serviceId", (Object) str3);
        } else {
            jSONObject.put("serviceId", (Object) "DX_Default_Service_Id");
        }
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("featureType", (Object) str2);
        }
        jSONObject.put("version", (Object) i());
        jSONObject.put("samplingRate", (Object) "1.0");
        if (dXTemplateItem != null) {
            if (!TextUtils.isEmpty(dXTemplateItem.name)) {
                jSONObject.put("templateName", (Object) dXTemplateItem.name);
            }
            jSONObject.put("templateVersion", (Object) (dXTemplateItem.version + ""));
            if (!TextUtils.isEmpty(dXTemplateItem.templateUrl)) {
                jSONObject.put("templateUrl", (Object) dXTemplateItem.templateUrl);
            }
            jSONObject.put("templateType", (Object) Integer.valueOf(dXTemplateItem.getTemplateType()));
        }
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!(entry == null || entry.getKey() == null || entry.getValue() == null)) {
                    jSONObject.put(entry.getKey(), (Object) entry.getValue());
                }
            }
        }
        return jSONObject;
    }

    public static Map g(float f) {
        return new HashMap<String, String>(f) {
            /* class com.taobao.android.dinamicx.monitor.DXAppMonitor.AnonymousClass4 */
            final /* synthetic */ float val$consumingTime;

            {
                this.val$consumingTime = r2;
                put("ConsumingTime", String.valueOf(r2 / 1000000.0f));
            }
        };
    }

    public static boolean h() {
        return 0.001d > Math.random();
    }

    private static String i() {
        return LiveFullInfo.VER;
    }

    public static void j(IDXAppMonitor iDXAppMonitor) {
        a = iDXAppMonitor;
    }

    private static void k(@NonNull final e eVar, final boolean z) {
        List<e.a> list;
        try {
            if (a != null && eVar != null && eVar.a != null && (list = eVar.c) != null) {
                if (list.size() > 0) {
                    c00.g(new DXMonitorRunnable() {
                        /* class com.taobao.android.dinamicx.monitor.DXAppMonitor.AnonymousClass3 */

                        public void run() {
                            e eVar = eVar;
                            String str = eVar.a;
                            List<e.a> list = eVar.c;
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                e.a aVar = list.get(i);
                                if (aVar != null && !TextUtils.isEmpty(aVar.b)) {
                                    if (aVar.f == null) {
                                        aVar.f = new HashMap();
                                    }
                                    aVar.f.put("eventId", eVar.a());
                                    if (z) {
                                        aVar.c = "SimplePipeline" + aVar.c;
                                    }
                                    DXAppMonitor.r(str, eVar.b, aVar.c, aVar.b, aVar.f, aVar.d, aVar.e, aVar.a);
                                }
                            }
                        }
                    });
                }
            }
        } catch (Throwable th) {
            vx.b(th);
        }
    }

    private static void l(int i, @NonNull final String str, final String str2, @NonNull final String str3, final DXTemplateItem dXTemplateItem, final Map<String, String> map, final double d, final boolean z) {
        try {
            if (b == i || 2 == i) {
                c00.g(new DXMonitorRunnable() {
                    /* class com.taobao.android.dinamicx.monitor.DXAppMonitor.AnonymousClass1 */

                    public void run() {
                        String str;
                        if (str3 != null) {
                            if (dXTemplateItem == null) {
                                str = "";
                            } else {
                                str = dXTemplateItem.name + "_:" + dXTemplateItem.version;
                            }
                            if ("Detail_RenderWidget_CreateView_Once".equals(str3) || "Detail_RenderWidget_RenderView_Once".equals(str3)) {
                                Map map = map;
                                if (map != null && map.containsKey("ViewSimpleName")) {
                                    ry.r(str2, jl1.ARRAY_START_STR + str + "]：" + str2 + "性能埋点: " + str3 + ": [" + ((String) map.get("ViewSimpleName")) + "]:" + (d / 1000000.0d) + "ms templateinfo: " + str);
                                }
                            } else {
                                ry.r(str2, jl1.ARRAY_START_STR + str + "]：" + str2 + "性能埋点: " + str3 + ": " + (d / 1000000.0d) + "ms templateinfo: " + str);
                            }
                            if (DXAppMonitor.a != null) {
                                if (DXAppMonitor.h() && !DinamicXEngine.x()) {
                                    JSONObject f = DXAppMonitor.f(str, str2, str3, dXTemplateItem, map);
                                    DXAppMonitor.a.alarm_commitSuccess("Page_Umbrella_Govern", ry.TAG, f.toString());
                                    if (d > 0.0d) {
                                        DXAppMonitor.a.counter_commit("Page_Umbrella_Govern", ry.TAG, f.toString(), d / 1000000.0d);
                                    }
                                }
                                if (z) {
                                    wz.f(ry.TAG, ry.TAG, DXAppMonitor.e(str, str3, dXTemplateItem, map, ""));
                                }
                            }
                        }
                    }
                });
            }
        } catch (Throwable th) {
            vx.b(th);
        }
    }

    public static void m(int i, @NonNull final String str, final String str2, @NonNull final String str3, final Map<String, String> map) {
        try {
            if (b == i) {
                c00.g(new DXMonitorRunnable() {
                    /* class com.taobao.android.dinamicx.monitor.DXAppMonitor.AnonymousClass2 */

                    public void run() {
                        if (DXAppMonitor.h() && !DinamicXEngine.x()) {
                            DXAppMonitor.f(str, str2, str3, null, map);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            vx.b(th);
        }
    }

    public static void n(@NonNull e eVar) {
        o(eVar, false);
    }

    public static void o(@NonNull e eVar, boolean z) {
        k(eVar, z);
        u(eVar, z);
        RuntimeProfilingInfoCollector.c().a(eVar, z);
    }

    public static void p(DXRuntimeContext dXRuntimeContext, String str, String str2, int i, String str3) {
        try {
            e eVar = new e(dXRuntimeContext.getBizType());
            if (dXRuntimeContext.getDxError() != null) {
                eVar.b(dXRuntimeContext.getDxError().a());
            }
            eVar.b = dXRuntimeContext.getDxTemplateItem();
            e.a aVar = new e.a(str, str2, i);
            aVar.e = str3;
            eVar.c.add(aVar);
            n(eVar);
        } catch (Throwable th) {
            vx.b(th);
        }
    }

    public static void q(String str, DXTemplateItem dXTemplateItem, String str2, String str3, int i, String str4) {
        try {
            e eVar = new e(str);
            eVar.b = dXTemplateItem;
            e.a aVar = new e.a(str2, str3, i);
            aVar.e = str4;
            eVar.c.add(aVar);
            n(eVar);
        } catch (Throwable th) {
            vx.b(th);
        }
    }

    /* access modifiers changed from: private */
    public static void r(@NonNull String str, DXTemplateItem dXTemplateItem, String str2, @NonNull String str3, Map<String, String> map, int i, String str4, long j) {
        JSONObject f = f(str, str2, str3, dXTemplateItem, map);
        if (f != null) {
            f.put("timeStamp", (Object) Long.valueOf(j));
            if (str4 != null) {
                f.put("errorMsg", (Object) str4);
            }
        }
        if (!DinamicXEngine.x()) {
            IDXAppMonitor iDXAppMonitor = a;
            String jSONString = f.toJSONString();
            iDXAppMonitor.alarm_commitFail("Page_Umbrella_Govern", ry.TAG, jSONString, i + "", str4);
        }
        wz.d(ry.TAG, ry.TAG, e(str, str3, dXTemplateItem, map, "errorCode:" + i + "_errorMsg:" + str4));
    }

    public static void s(int i, @NonNull String str, String str2, @NonNull String str3, DXTemplateItem dXTemplateItem, Map<String, String> map, double d, boolean z) {
        l(i, str, str2, str3, dXTemplateItem, map, d, z);
        t(i, str, str2, str3, dXTemplateItem, map, d);
        RuntimeProfilingInfoCollector.c().b(i, str, str2, str3, dXTemplateItem, d);
    }

    private static void t(int i, @NonNull String str, String str2, @NonNull String str3, DXTemplateItem dXTemplateItem, Map<String, String> map, double d) {
        DXUmbrellaUtil.k(i, str, str2, str3, dXTemplateItem, map, d);
    }

    private static void u(@NonNull e eVar, boolean z) {
        DXUmbrellaUtil.i(eVar, z);
    }
}
