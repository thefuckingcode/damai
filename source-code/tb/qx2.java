package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.adapter.module.net.IWXConnection;
import com.alibaba.aliweex.plugin.MtopPreloader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.pictures.dolores.prefetch.PrefetchManager;
import com.huawei.hms.actions.SearchIntents;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.appfram.storage.IWXStorageAdapter;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class qx2 {
    public static final String TAG = "qx2";
    private static volatile long a = 0;
    private static volatile boolean b = true;
    private static volatile long c;
    private static volatile List<String> d = new ArrayList();
    @Nullable
    private static volatile JSONObject e = null;
    private static volatile long f = 0;
    private static volatile boolean g = true;
    private static volatile Class h = null;
    private static volatile Method i = null;
    private static volatile boolean j = true;
    private static volatile Class k = null;
    private static volatile Method l = null;
    private static volatile Method m = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements IWXStorageAdapter.OnResultReceivedListener {
        final /* synthetic */ String a;
        final /* synthetic */ WXSDKInstance b;
        final /* synthetic */ String c;

        a(String str, WXSDKInstance wXSDKInstance, String str2) {
            this.a = str;
            this.b = wXSDKInstance;
            this.c = str2;
        }

        @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
        @SuppressLint({"WrongConstant"})
        public void onReceived(Map<String, Object> map) {
            JSONObject jSONObject;
            IWXConnection a2;
            try {
                jSONObject = (JSONObject) JSON.parse(map.get("data").toString());
            } catch (Exception unused) {
                jSONObject = new JSONObject();
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject.put("status", (Object) -1);
            jSONObject.put("t", (Object) String.valueOf(System.currentTimeMillis()));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("info", (Object) (TextUtils.isEmpty(this.a) ? "UNKOWN" : this.a));
            WXSDKInstance wXSDKInstance = this.b;
            jSONObject2.put("network", (Object) ((wXSDKInstance == null || (a2 = com.alibaba.aliweex.adapter.module.net.a.a(wXSDKInstance.getContext())) == null) ? "" : a2.getNetworkType()));
            jSONObject.put("errorExt", (Object) jSONObject2);
            qx2.s(this.b, this.c, JSON.toJSONString(jSONObject));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b implements IWXStorageAdapter.OnResultReceivedListener {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ WXSDKInstance c;

        b(String str, String str2, WXSDKInstance wXSDKInstance) {
            this.a = str;
            this.b = str2;
            this.c = wXSDKInstance;
        }

        @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
        public void onReceived(Map<String, Object> map) {
            if (map != null) {
                String str = (String) map.get("result");
                if (str == null || !str.equals("success")) {
                    qx2.r(MtopPreloader.h, this.a);
                    String str2 = qx2.TAG;
                    WXLogUtils.d(str2, "saveToStorage failed. onReceived map is " + map);
                    return;
                }
                qx2.d();
                if (WXEnvironment.isApkDebugable()) {
                    String str3 = qx2.TAG;
                    WXLogUtils.d(str3, "saveToStorage result:" + str + " | key:" + this.a + " | val:" + this.b);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("result", "sucess");
                hashMap.put("url", this.a);
                try {
                    WXSDKInstance wXSDKInstance = this.c;
                    if (!(wXSDKInstance == null || wXSDKInstance.getContext() == null)) {
                        this.c.fireGlobalEventCallback("prefetchFinshed", map);
                    }
                } catch (Exception unused) {
                }
                qx2.r(MtopPreloader.g, this.a);
            }
        }
    }

    static boolean a() {
        if (SystemClock.uptimeMillis() - a < DateUtils.MILLIS_PER_MINUTE) {
            return b;
        }
        boolean z = true;
        try {
            IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
            if (c2 != null) {
                z = "true".equalsIgnoreCase(c2.getConfig("weex_adaper_url_intercept", "mtop_prefetch_status", "true"));
            }
        } catch (Throwable unused) {
        }
        a = SystemClock.uptimeMillis();
        b = z;
        return z;
    }

    public static boolean b() {
        IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
        if (c2 == null) {
            return true;
        }
        String config = c2.getConfig("weex_adaper_url_intercept", "weex_prefetch_mtop_switch", "true");
        if (config != null && "true".equalsIgnoreCase(config)) {
            return true;
        }
        c("orange config is close", "preload is disabled");
        return false;
    }

    public static void c(String str, String str2) {
        AppMonitor.Alarm.commitFail("tbweex", PrefetchManager.TAG, str, str2);
        AppMonitor.Alarm.commitFail("PrefetchX", "PrefetchX_JSModule_In_Bundle", str, str2);
    }

    public static void d() {
        AppMonitor.Alarm.commitSuccess("tbweex", PrefetchManager.TAG);
    }

    public static Map<String, Object> e(Context context, Object obj, String str) {
        Throwable th;
        HashMap hashMap = null;
        if (obj == null) {
            return null;
        }
        try {
            if (!j || !v()) {
                return null;
            }
            if (k == null || m == null) {
                synchronized (qx2.class) {
                    if (k == null) {
                        k = WXSDKManager.v().k().getModuleClass("PFJSModuleIntegration", "com.alibaba.android.prefetchx.core.jsmodule.PFJSModuleIntegration", WXEnvironment.getApplication().getApplicationContext());
                    }
                    if (m == null) {
                        m = k.getDeclaredMethod("degenerate", Context.class, String.class, Map.class);
                        m.setAccessible(true);
                    }
                }
            }
            if (k == null || m == null || obj == null) {
                j = false;
                c("-55011", "prefetchx_degenerate_class_error");
                return null;
            }
            Object invoke = m.invoke(obj, context, str, new HashMap());
            if (!(invoke instanceof Pair)) {
                return null;
            }
            Pair pair = (Pair) invoke;
            HashMap hashMap2 = new HashMap();
            try {
                hashMap2.put("fatWeexUrl", pair.first);
                hashMap2.put("fatBundleUrl", pair.second);
                hashMap2.put("mPrefetchXIntegration", obj);
                hashMap2.put("originalThinBundleUrl", str);
                return hashMap2;
            } catch (Throwable th2) {
                th = th2;
                hashMap = hashMap2;
                c("-55012", "prefetchx_degenerate_error" + th.getMessage() + " | " + WXLogUtils.getStackTrace(th));
                return hashMap;
            }
        } catch (Throwable th3) {
            th = th3;
            c("-55012", "prefetchx_degenerate_error" + th.getMessage() + " | " + WXLogUtils.getStackTrace(th));
            return hashMap;
        }
    }

    public static Pair<String, Object> f(Context context, String str, String str2) {
        try {
            if (!j || !v()) {
                return null;
            }
            if (k == null || l == null) {
                synchronized (qx2.class) {
                    if (k == null) {
                        k = WXSDKManager.v().k().getModuleClass("PFJSModuleIntegration", "com.alibaba.android.prefetchx.core.jsmodule.PFJSModuleIntegration", WXEnvironment.getApplication().getApplicationContext());
                    }
                    if (l == null) {
                        l = k.getDeclaredMethod("evolve", Context.class, String.class, String.class);
                        l.setAccessible(true);
                    }
                }
            }
            Object newInstance = k != null ? k.newInstance() : null;
            if (k == null || l == null || newInstance == null) {
                j = false;
                c("-55001", "prefetchx_evolve_class_error");
                return null;
            }
            Object invoke = l.invoke(newInstance, context, str, str2);
            if (invoke instanceof String) {
                return new Pair<>(invoke.toString(), newInstance);
            }
            return null;
        } catch (Throwable th) {
            c("-55002", "prefetchx_evolve_error" + th.getMessage() + " | " + WXLogUtils.getStackTrace(th));
            return null;
        }
    }

    public static List<String> g() {
        JSONArray parseArray;
        if (SystemClock.uptimeMillis() - c < DateUtils.MILLIS_PER_MINUTE) {
            return d;
        }
        ArrayList arrayList = new ArrayList();
        try {
            IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
            if (!(c2 == null || (parseArray = JSON.parseArray(c2.getConfig("weex_adaper_url_intercept", "mtop_prefetch_url_contains_white_list", "[]"))) == null)) {
                for (Object obj : parseArray.toArray()) {
                    arrayList.add(obj.toString());
                }
            }
        } catch (Throwable unused) {
        }
        c = SystemClock.uptimeMillis();
        d = arrayList;
        return arrayList;
    }

    public static String h(WXSDKInstance wXSDKInstance, @NonNull String str) {
        try {
            JSONObject parseObject = JSON.parseObject(str);
            String str2 = TAG;
            WXLogUtils.d(str2, "get mtop api and params");
            if (parseObject == null) {
                return null;
            }
            if (parseObject.get("data") != null) {
                parseObject.put("param", parseObject.get("data"));
                parseObject.remove("data");
            }
            String jSONString = parseObject.toJSONString();
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d(str2, "resolve mtop params success:" + jSONString);
            }
            return jSONString;
        } catch (Exception e2) {
            m(wXSDKInstance, str, "-1", "");
            String str3 = TAG;
            WXLogUtils.e(str3, "mtop params parse to json failed," + e2.getMessage());
            c("mtop params parse failed", e2.getMessage());
            return null;
        }
    }

    public static String i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
        String str2 = "http://h5.m.taobao.com/app/prefetchmap/prefetch.js";
        if (c2 != null) {
            str2 = c2.getConfig("weex_adaper_url_intercept", "weex_prefetch_map_url", str2);
        }
        int i2 = 20;
        try {
            i2 = Integer.parseInt(c2.getConfig("weex_adaper_url_intercept", "weex_prefech_map_memery_refresh", "20"));
        } catch (Exception e2) {
            WXLogUtils.w("error in weex_prefech_map_memery_refresh", e2);
        }
        JSONObject k2 = k(str2, i2);
        if (k2 == null) {
            return null;
        }
        try {
            if (k2.get(str) == null) {
                return null;
            }
            return JSON.toJSONString(k2.get(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Map<String, String> j(String str) {
        HashMap hashMap = new HashMap();
        String t = t(str);
        if (t == null) {
            return hashMap;
        }
        for (String str2 : t.split("[&]")) {
            String[] split = str2.split("[=]");
            if (split.length > 1) {
                hashMap.put(split[0], split[1]);
            } else if (split.length == 1 && !TextUtils.isEmpty(split[0])) {
                hashMap.put(split[0], "");
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        r5 = android.taobao.windvane.packageapp.zipapp.utils.ZipAppUtils.getStreamByUrl(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (com.taobao.weex.WXEnvironment.isApkDebugable() == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        r6 = tb.qx2.TAG;
        com.taobao.weex.utils.WXLogUtils.d(r6, "zcahe中的parmas" + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        r6 = com.alibaba.fastjson.JSON.parseObject(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        monitor-enter(tb.qx2.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        if (r6 == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        tb.qx2.e = r6;
        tb.qx2.f = android.os.SystemClock.elapsedRealtime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        monitor-exit(tb.qx2.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        return r6;
     */
    private static JSONObject k(String str, int i2) {
        synchronized (qx2.class) {
            if (SystemClock.elapsedRealtime() - f < ((long) (i2 * 60 * 1000)) && e != null) {
                return e;
            }
        }
    }

    public static String l(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return str;
        }
        return parse.getHost() + parse.getPath();
    }

    @Deprecated
    public static void m(WXSDKInstance wXSDKInstance, String str, String str2, String str3) {
        if ("-1".equals(str2)) {
            p(wXSDKInstance, str, str3);
        }
    }

    public static void n(WXSDKInstance wXSDKInstance, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("data", JSON.toJSONString(JSON.parseObject(str2)));
            hashMap.put("t", String.valueOf(System.currentTimeMillis()));
            String jSONString = JSON.toJSONString((Object) hashMap, true);
            if (WXEnvironment.isApkDebugable()) {
                String str3 = TAG;
                WXLogUtils.d(str3, "received mtop result:" + jSONString);
            }
            s(wXSDKInstance, str, jSONString);
        } catch (Exception e2) {
            WXLogUtils.e(e2.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x009d A[SYNTHETIC, Splitter:B:40:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    public static String o(WXSDKInstance wXSDKInstance, String str) {
        String str2;
        String str3;
        if (str != null && str.contains("data_prefetch=false")) {
            return str;
        }
        boolean z = false;
        try {
            if (g && u()) {
                boolean z2 = true;
                if (h == null || i == null) {
                    synchronized (qx2.class) {
                        if (h == null || i == null) {
                            h = WXSDKManager.v().k().getModuleClass("PrefetchXData", "com.alibaba.android.prefetchx.core.data.SupportWeex", WXEnvironment.getApplication().getApplicationContext());
                            i = h.getDeclaredMethod("prefetchData", WXSDKInstance.class, String.class);
                            i.setAccessible(true);
                        }
                    }
                }
                if (i == null || h == null) {
                    g = false;
                    c("prefetchx_class_error", "no class or method");
                } else {
                    Object invoke = i.invoke(h, wXSDKInstance, str);
                    if (invoke instanceof String) {
                        str3 = invoke.toString();
                    } else {
                        str3 = str;
                        z2 = false;
                    }
                    str2 = str3;
                    z = z2;
                    if (!z) {
                        return str2;
                    }
                    try {
                        return MtopPreloader.f(str, wXSDKInstance);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        c("mtop_preload_error", th.getMessage());
                        return str2;
                    }
                }
            }
        } catch (Throwable th2) {
            c("prefetchx_error", th2.getMessage());
        }
        str2 = str;
        if (!z) {
        }
    }

    @Deprecated
    static void p(WXSDKInstance wXSDKInstance, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String str3 = TAG;
            WXLogUtils.e(str3, "mtop预加载 mtop请求错误,尝试读取storage数据 " + str2);
            try {
                IWXStorageAdapter iWXStorageAdapter = WXSDKEngine.getIWXStorageAdapter();
                if (iWXStorageAdapter != null) {
                    iWXStorageAdapter.getItem(str, new a(str2, wXSDKInstance, str));
                }
            } catch (Exception e2) {
                WXLogUtils.e("mtop预加载 mtop失败场景下，读取storage出错", e2);
            }
        }
    }

    public static String q(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        try {
            int indexOf = str.indexOf(str2 + "=");
            String encode = URLEncoder.encode(str3);
            if (indexOf != -1) {
                sb.append(str.substring(0, indexOf));
                sb.append(str2 + "=");
                sb.append(encode);
                int indexOf2 = str.indexOf("&", indexOf);
                if (indexOf2 != -1) {
                    sb.append(str.substring(indexOf2));
                }
                return sb.toString();
            } else if (str.indexOf("?", indexOf) != -1) {
                sb.append(str);
                sb.append("&" + str2 + "=" + encode);
                return sb.toString();
            } else {
                sb.append(str);
                sb.append("?" + str2 + "=" + encode);
                return sb.toString();
            }
        } catch (Exception e2) {
            c("replace url error", "replace url error " + e2);
            return str;
        }
    }

    public static void r(String str, String str2) {
        if (!a()) {
            String str3 = TAG;
            WXLogUtils.d(str3, "MtopPrefetchStatus is off by orange. " + str);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", (Object) str);
        jSONObject.put("t", (Object) Long.valueOf(new Date().getTime()));
        jSONObject.put(SearchIntents.EXTRA_QUERY, (Object) str2);
        try {
            IWXStorageAdapter iWXStorageAdapter = WXSDKEngine.getIWXStorageAdapter();
            if (iWXStorageAdapter != null) {
                iWXStorageAdapter.setItem(MtopPreloader.b, jSONObject.toJSONString(), null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c("save statue to storage error", e2.getMessage());
        }
    }

    public static void s(WXSDKInstance wXSDKInstance, String str, String str2) {
        try {
            IWXStorageAdapter iWXStorageAdapter = WXSDKEngine.getIWXStorageAdapter();
            if (iWXStorageAdapter != null) {
                iWXStorageAdapter.setItem(str, str2, new b(str, str2, wXSDKInstance));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c("save to storage error", e2.getMessage());
            r(MtopPreloader.h, str);
        }
    }

    private static String t(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("[?]");
        if (str.length() <= 1 || split.length <= 1 || split[1] == null) {
            return null;
        }
        return split[1];
    }

    public static boolean u() {
        String config;
        IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
        if (c2 == null || (config = c2.getConfig("weex_adaper_url_intercept", "use_prefetchx", "true")) == null || !"true".equalsIgnoreCase(config)) {
            return false;
        }
        return true;
    }

    public static boolean v() {
        String config;
        IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
        if (c2 == null || (config = c2.getConfig("weex_adaper_url_intercept", "use_prefetchx_embed_jsmodule", "false")) == null || !"true".equalsIgnoreCase(config)) {
            return false;
        }
        return true;
    }
}
