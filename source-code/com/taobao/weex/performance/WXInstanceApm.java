package com.taobao.weex.performance;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXPerformance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.cx2;

/* compiled from: Taobao */
public class WXInstanceApm {
    public static final String KEY_PAGE_ANIM_BACK_NUM = "wxAnimationInBackCount";
    public static final String KEY_PAGE_PROPERTIES_BIZ_ID = "wxBizID";
    public static final String KEY_PAGE_PROPERTIES_BUBDLE_URL = "wxBundleUrl";
    public static final String KEY_PAGE_PROPERTIES_BUNDLE_TYPE = "wxBundleType";
    public static final String KEY_PAGE_PROPERTIES_CACHE_INFO = "wxZCacheInfo";
    public static final String KEY_PAGE_PROPERTIES_CACHE_TYPE = "wxCacheType";
    public static final String KEY_PAGE_PROPERTIES_CONTAINER_NAME = "wxContainerName";
    public static final String KEY_PAGE_PROPERTIES_INSTANCE_TYPE = "wxInstanceType";
    public static final String KEY_PAGE_PROPERTIES_JSLIB_VERSION = "wxJSLibVersion";
    public static final String KEY_PAGE_PROPERTIES_JS_FM_INI = "wxJsFrameworkInit";
    public static final String KEY_PAGE_PROPERTIES_PARENT_PAGE = "wxParentPage";
    public static final String KEY_PAGE_PROPERTIES_RENDER_TYPE = "wxRenderType";
    public static final String KEY_PAGE_PROPERTIES_REQUEST_TYPE = "wxRequestType";
    public static final String KEY_PAGE_PROPERTIES_UIKIT_TYPE = "wxUIKitType";
    public static final String KEY_PAGE_PROPERTIES_WEEX_VERSION = "wxSDKVersion";
    public static final String KEY_PAGE_STAGES_CONTAINER_READY = "wxContainerReady";
    public static final String KEY_PAGE_STAGES_CREATE_FINISH = "wxJSBundleCreateFinish";
    public static final String KEY_PAGE_STAGES_CUSTOM_PREPROCESS_END = "wxCustomPreprocessEnd";
    public static final String KEY_PAGE_STAGES_CUSTOM_PREPROCESS_START = "wxCustomPreprocessStart";
    public static final String KEY_PAGE_STAGES_DESTROY = "wxDestroy";
    public static final String KEY_PAGE_STAGES_DOWN_BUNDLE_END = "wxEndDownLoadBundle";
    public static final String KEY_PAGE_STAGES_DOWN_BUNDLE_START = "wxStartDownLoadBundle";
    public static final String KEY_PAGE_STAGES_END_EXCUTE_BUNDLE = "wxEndExecuteBundle";
    public static final String KEY_PAGE_STAGES_FIRST_INTERACTION_VIEW = "wxFirstInteractionView";
    public static final String KEY_PAGE_STAGES_FSRENDER = "wxFsRender";
    public static final String KEY_PAGE_STAGES_INTERACTION = "wxInteraction";
    public static final String KEY_PAGE_STAGES_LOAD_BUNDLE_END = "wxEndLoadBundle";
    public static final String KEY_PAGE_STAGES_LOAD_BUNDLE_START = "wxStartLoadBundle";
    public static final String KEY_PAGE_STAGES_NEW_FSRENDER = "wxNewFsRender";
    public static final String KEY_PAGE_STAGES_RENDER_ORGIGIN = "wxRenderTimeOrigin";
    public static final String KEY_PAGE_STATS_ACTUAL_DOWNLOAD_TIME = "wxActualNetworkTime";
    public static final String KEY_PAGE_STATS_BODY_RATIO = "wxBodyRatio";
    public static final String KEY_PAGE_STATS_BUNDLE_SIZE = "wxBundleSize";
    public static final String KEY_PAGE_STATS_CELL_DATA_UN_RECYCLE_NUM = "wxCellDataUnRecycleCount";
    public static final String KEY_PAGE_STATS_CELL_EXCEED_NUM = "wxCellExceedNum";
    public static final String KEY_PAGE_STATS_CELL_UN_RE_USE_NUM = "wxCellUnReUseCount";
    public static final String KEY_PAGE_STATS_COMPONENT_CREATE_COST = "wxComponentCost";
    public static final String KEY_PAGE_STATS_EMBED_COUNT = "wxEmbedCount";
    public static final String KEY_PAGE_STATS_EXECUTE_JS_CALLBACK_COST = "wxExecJsCallBack";
    public static final String KEY_PAGE_STATS_FS_CALL_EVENT_NUM = "wxFSCallEventTotalNum";
    public static final String KEY_PAGE_STATS_FS_CALL_JS_NUM = "wxFSCallJsTotalNum";
    public static final String KEY_PAGE_STATS_FS_CALL_JS_TIME = "wxFSCallJsTotalTime";
    public static final String KEY_PAGE_STATS_FS_CALL_NATIVE_NUM = "wxFSCallNativeTotalNum";
    public static final String KEY_PAGE_STATS_FS_CALL_NATIVE_TIME = "wxFSCallNativeTotalTime";
    public static final String KEY_PAGE_STATS_FS_REQUEST_NUM = "wxFSRequestNum";
    public static final String KEY_PAGE_STATS_FS_TIMER_NUM = "wxFSTimerCount";
    public static final String KEY_PAGE_STATS_IMG_LOAD_FAIL_NUM = "wxImgLoadFailCount";
    public static final String KEY_PAGE_STATS_IMG_LOAD_NUM = "wxImgLoadCount";
    public static final String KEY_PAGE_STATS_IMG_LOAD_SUCCESS_NUM = "wxImgLoadSuccessCount";
    public static final String KEY_PAGE_STATS_IMG_UN_RECYCLE_NUM = "wxImgUnRecycleCount";
    public static final String KEY_PAGE_STATS_I_ALL_VIEW_COUNT = "wxInteractionAllViewCount";
    public static final String KEY_PAGE_STATS_I_COMPONENT_CREATE_COUNT = "wxInteractionComponentCreateCount";
    public static final String KEY_PAGE_STATS_I_SCREEN_VIEW_COUNT = "wxInteractionScreenViewCount";
    public static final String KEY_PAGE_STATS_JSLIB_INIT_TIME = "wxJSLibInitTime";
    public static final String KEY_PAGE_STATS_LARGE_IMG_COUNT = "wxLargeImgMaxCount";
    public static final String KEY_PAGE_STATS_LAYOUT_TIME = "wxLayoutTime";
    public static final String KEY_PAGE_STATS_MAX_COMPONENT_NUM = "wxMaxComponentCount";
    public static final String KEY_PAGE_STATS_MAX_DEEP_DOM = "wxMaxDeepVDomLayer";
    public static final String KEY_PAGE_STATS_MAX_DEEP_VIEW = "wxMaxDeepViewLayer";
    public static final String KEY_PAGE_STATS_NET_FAIL_NUM = "wxNetworkRequestFailCount";
    public static final String KEY_PAGE_STATS_NET_NUM = "wxNetworkRequestCount";
    public static final String KEY_PAGE_STATS_NET_SUCCESS_NUM = "wxNetworkRequestSuccessCount";
    public static final String KEY_PAGE_STATS_SCROLLER_NUM = "wxScrollerCount";
    public static final String KEY_PAGE_STATS_VIEW_CREATE_COST = "wxViewCost";
    public static final String KEY_PAGE_STATS_WRONG_IMG_SIZE_COUNT = "wxWrongImgSizeCount";
    public static final String KEY_PAGE_TIMER_BACK_NUM = "wxTimerInBackCount";
    public static final String KEY_PROPERTIES_ERROR_CODE = "wxErrorCode";
    public static final String VALUE_BUNDLE_LOAD_LENGTH = "wxLoadedLength";
    public static final String VALUE_ERROR_CODE_DEFAULT = "0";
    public static final String WEEX_FIRSTSCREENPAINT = "Weex_firstScreenPaint";
    public static final String WEEX_PAGE_TOPIC = "weex_page";
    private Runnable A = new Runnable() {
        /* class com.taobao.weex.performance.WXInstanceApm.AnonymousClass1 */

        public void run() {
            WXInstanceApm.this.v();
        }
    };
    private Runnable B = new Runnable() {
        /* class com.taobao.weex.performance.WXInstanceApm.AnonymousClass2 */

        public void run() {
            WXInstanceApm.this.u();
        }
    };
    private long C = 0;
    private String a;
    private IWXApmMonitorAdapter b;
    private Map<String, Double> c;
    public final Map<String, Long> d;
    private Map<String, Object> e;
    private boolean f;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    public final Map<String, Object> j;
    public boolean k = false;
    public Rect l;
    public String m;
    public boolean n = false;
    public boolean o;
    private Handler p;
    public Set<String> q = new CopyOnWriteArraySet();
    private double r;
    public long s;
    private long t;
    public long u;
    private long v;
    private long w;
    private boolean x = false;
    private boolean y = false;
    public volatile boolean z = true;

    public WXInstanceApm(String str) {
        this.a = str;
        this.j = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.p = new Handler(Looper.getMainLooper());
        this.c = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        IApmGenerator j2 = WXSDKManager.v().j();
        if (j2 != null) {
            this.b = j2.generateApmInstance(WEEX_PAGE_TOPIC);
        }
    }

    private void f(String str, String str2, Map<String, Object> map) {
        Object obj = map.get(str);
        if (obj instanceof String) {
            e(str2, obj);
        }
    }

    private void t() {
        Long l2 = this.d.get(KEY_PAGE_STAGES_DOWN_BUNDLE_START);
        Long l3 = this.d.get(KEY_PAGE_STAGES_DOWN_BUNDLE_END);
        Long l4 = this.d.get(KEY_PAGE_STAGES_INTERACTION);
        Long l5 = this.d.get(KEY_PAGE_STAGES_CONTAINER_READY);
        if (!(l3 == null || l2 == null)) {
            WXLogUtils.d("test->", "downLoadTime: " + (l3.longValue() - l2.longValue()));
        }
        if (!(l3 == null || l4 == null)) {
            WXLogUtils.d("test->", "renderTime: " + (l4.longValue() - l3.longValue()));
        }
        if (l5 != null && l4 != null) {
            WXLogUtils.d("test->", "showTime: " + (l4.longValue() - l5.longValue()));
        }
    }

    private void w(String str, Object obj) {
        if (cx2.a) {
            cx2.d(this.a, "properties", str, obj);
        }
        IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
        if (iWXApmMonitorAdapter != null) {
            iWXApmMonitorAdapter.addProperty(str, obj);
        }
    }

    private void x(String str, long j2) {
        if (cx2.a) {
            cx2.d(this.a, TLogEventConst.PARAM_UPLOAD_STAGE, str, Long.valueOf(j2));
        }
        if (KEY_PAGE_STAGES_RENDER_ORGIGIN.equalsIgnoreCase(str)) {
            this.p.postDelayed(this.A, DanmakuFactory.DEFAULT_DANMAKU_DURATION);
        }
        IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
        if (iWXApmMonitorAdapter != null) {
            iWXApmMonitorAdapter.onStage(str, j2);
        }
    }

    private void y(String str, double d2) {
        if (cx2.a) {
            cx2.d(this.a, "stats", str, Double.valueOf(d2));
        }
        IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
        if (iWXApmMonitorAdapter != null) {
            iWXApmMonitorAdapter.addStats(str, d2);
        }
    }

    public String A() {
        Long l2 = this.d.get(KEY_PAGE_STAGES_RENDER_ORGIGIN);
        Long l3 = this.d.get(KEY_PAGE_STAGES_INTERACTION);
        Long l4 = this.d.get(KEY_PAGE_STAGES_NEW_FSRENDER);
        StringBuilder sb = new StringBuilder();
        if (!(l2 == null || l3 == null)) {
            sb.append("interactiveTime " + (l3.longValue() - l2.longValue()) + "ms");
        }
        if (l4 != null) {
            sb.append(" wxNewFsRender " + l4 + "ms");
        }
        return sb.toString();
    }

    public void B(String str, double d2) {
        if (this.b != null) {
            Double valueOf = Double.valueOf(this.c.containsKey(str) ? this.c.get(str).doubleValue() : 0.0d);
            if (valueOf == null) {
                WXErrorCode wXErrorCode = WXErrorCode.WX_ERR_HASH_MAP_TMP;
                WXExceptionUtils.commitCriticalExceptionRT("", wXErrorCode, "updateDiffStats", "key : " + str, null);
                return;
            }
            g(str, valueOf.doubleValue() + d2);
        }
    }

    public void C(String str, double d2) {
        if (this.b != null && !this.f) {
            B(str, d2);
        }
    }

    public void D(String str, double d2) {
        if (this.b != null) {
            Double valueOf = Double.valueOf(this.c.containsKey(str) ? this.c.get(str).doubleValue() : 0.0d);
            if (valueOf == null) {
                WXErrorCode wXErrorCode = WXErrorCode.WX_ERR_HASH_MAP_TMP;
                WXExceptionUtils.commitCriticalExceptionRT("", wXErrorCode, "updateMaxStats", "key : " + str, null);
            } else if (valueOf.doubleValue() < d2) {
                g(str, Double.valueOf(d2).doubleValue());
            }
        }
    }

    public void E(Map<String, String> map) {
        double d2;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    d2 = Double.valueOf(entry.getValue()).doubleValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    d2 = -1.0d;
                }
                if (d2 != -1.0d) {
                    this.c.put(entry.getKey(), Double.valueOf(d2));
                }
            }
        }
    }

    public void F(Map<String, Object> map) {
        if (this.b != null && map != null) {
            f(KEY_PAGE_PROPERTIES_REQUEST_TYPE, KEY_PAGE_PROPERTIES_REQUEST_TYPE, map);
            f(WXPerformance.CACHE_TYPE, KEY_PAGE_PROPERTIES_CACHE_TYPE, map);
            f("zCacheInfo", KEY_PAGE_PROPERTIES_CACHE_INFO, map);
            g(KEY_PAGE_STATS_JSLIB_INIT_TIME, (double) WXEnvironment.sJSLibInitTime);
            e(KEY_PAGE_PROPERTIES_JS_FM_INI, Boolean.valueOf(WXEnvironment.JsFrameworkInit));
            Object obj = map.get("actualNetworkTime");
            if (obj instanceof Long) {
                B(KEY_PAGE_STATS_ACTUAL_DOWNLOAD_TIME, ((Long) obj).doubleValue());
            }
        }
    }

    public void a() {
        B(KEY_PAGE_STATS_IMG_LOAD_NUM, 1.0d);
    }

    public void b(boolean z2, String str) {
        if (z2) {
            B(KEY_PAGE_STATS_IMG_LOAD_SUCCESS_NUM, 1.0d);
        } else {
            B(KEY_PAGE_STATS_IMG_LOAD_FAIL_NUM, 1.0d);
        }
    }

    public void c() {
        if (!this.f) {
            C(KEY_PAGE_STATS_FS_REQUEST_NUM, 1.0d);
        }
        B(KEY_PAGE_STATS_NET_NUM, 1.0d);
    }

    public void d(boolean z2, String str) {
        if (z2) {
            B(KEY_PAGE_STATS_NET_SUCCESS_NUM, 1.0d);
        } else {
            B(KEY_PAGE_STATS_NET_FAIL_NUM, 1.0d);
        }
    }

    public void e(String str, Object obj) {
        if (!this.h && str != null && obj != null) {
            this.e.put(str, obj);
            if (this.z) {
                w(str, obj);
            }
        }
    }

    public void g(String str, double d2) {
        if (!this.h && str != null) {
            this.c.put(str, Double.valueOf(d2));
            if (this.z) {
                y(str, d2);
            }
        }
    }

    public void h() {
        if (this.b != null) {
            this.f = true;
            r(KEY_PAGE_STAGES_FSRENDER);
        }
    }

    public void i(WXComponent wXComponent) {
        WXPerformance wXPerformance;
        double d2;
        if (this.b != null && wXComponent != null && wXComponent.getInstance() != null) {
            if (cx2.a) {
                cx2.c(wXComponent);
            }
            if (this.b != null && (wXPerformance = wXComponent.getInstance().getWXPerformance()) != null) {
                long fixUnixTime = WXUtils.getFixUnixTime();
                if (cx2.a()) {
                    Log.d(cx2.INTERACTION_TAG, "[client][wxinteraction]" + wXComponent.getInstance().getInstanceId() + "," + wXComponent.getComponentType() + "," + wXComponent.getRef() + "," + wXComponent.getStyles() + "," + wXComponent.getAttrs());
                }
                if (!this.i) {
                    r(KEY_PAGE_STAGES_FIRST_INTERACTION_VIEW);
                    this.i = true;
                }
                if (!this.k) {
                    long fixUnixTime2 = WXUtils.getFixUnixTime();
                    if (fixUnixTime2 - this.C > 50) {
                        WXBridgeManager.getInstance().onInteractionTimeUpdate(this.a);
                        this.C = fixUnixTime2;
                    }
                    this.t = this.s;
                    this.v = this.u;
                    Double d3 = this.c.get(KEY_PAGE_STATS_LAYOUT_TIME);
                    if (d3 == null) {
                        d2 = 0.0d;
                    } else {
                        d2 = d3.doubleValue();
                    }
                    this.r = d2;
                    wXPerformance.interactionTime = fixUnixTime - wXPerformance.renderUnixTimeOrigin;
                    wXPerformance.interactionRealUnixTime = System.currentTimeMillis();
                    s(KEY_PAGE_STAGES_INTERACTION, fixUnixTime);
                    B(KEY_PAGE_STATS_I_SCREEN_VIEW_COUNT, 1.0d);
                    D(KEY_PAGE_STATS_I_ALL_VIEW_COUNT, (double) wXPerformance.localInteractionViewAddCount);
                    WXSDKInstance y2 = WXSDKManager.v().y(this.a);
                    if (y2 != null) {
                        D(KEY_PAGE_STATS_I_COMPONENT_CREATE_COUNT, (double) y2.getWXPerformance().componentCount);
                    }
                }
            }
        }
    }

    public void j() {
        if (this.b != null) {
            r(KEY_PAGE_STAGES_NEW_FSRENDER);
            r(WEEX_FIRSTSCREENPAINT);
        }
    }

    public void k() {
        new Handler(Looper.getMainLooper()).postDelayed(this.B, DanmakuFactory.DEFAULT_DANMAKU_DURATION);
    }

    public void l() {
        String str;
        if (this.z && !this.g) {
            this.g = true;
            IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
            if (iWXApmMonitorAdapter != null) {
                iWXApmMonitorAdapter.onStart(this.a);
                WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(this.a);
                if (wXSDKInstance == null) {
                    str = "unKnowUrl";
                } else {
                    str = wXSDKInstance.getBundleUrl();
                }
                e(KEY_PAGE_PROPERTIES_BUBDLE_URL, str);
                e(KEY_PROPERTIES_ERROR_CODE, "0");
                e(KEY_PAGE_PROPERTIES_JSLIB_VERSION, WXEnvironment.JS_LIB_SDK_VERSION);
                e(KEY_PAGE_PROPERTIES_WEEX_VERSION, WXEnvironment.WXSDK_VERSION);
                e(KEY_PAGE_PROPERTIES_WEEX_VERSION, WXEnvironment.WXSDK_VERSION);
                g("wxReInitCount", (double) WXBridgeManager.reInitCount);
                if (wXSDKInstance != null) {
                    e(KEY_PAGE_PROPERTIES_UIKIT_TYPE, wXSDKInstance.getRenderType());
                }
                e("wxUseRuntimeApi", Boolean.valueOf(WXEnvironment.sUseRunTimeApi));
                if (wXSDKInstance != null && (wXSDKInstance.isUsingEaglePlugin() || wXSDKInstance.getRenderStrategy() == WXRenderStrategy.DATA_RENDER_BINARY || wXSDKInstance.getRenderStrategy() == WXRenderStrategy.DATA_RENDER)) {
                    e(KEY_PAGE_PROPERTIES_RENDER_TYPE, WXEnvironment.EAGLE);
                }
                if (wXSDKInstance != null) {
                    for (Map.Entry<String, String> entry : wXSDKInstance.getContainerInfo().entrySet()) {
                        e(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }

    public boolean m() {
        return this.g;
    }

    public void n() {
        IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
        if (iWXApmMonitorAdapter != null) {
            iWXApmMonitorAdapter.onAppear();
        }
    }

    public void o() {
        IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
        if (iWXApmMonitorAdapter != null) {
            iWXApmMonitorAdapter.onDisappear();
        }
    }

    public void p() {
        IWXApmMonitorAdapter iWXApmMonitorAdapter;
        if (this.b != null && !this.h) {
            new Handler(Looper.getMainLooper()).removeCallbacks(this.B);
            u();
            this.q.clear();
            this.p.removeCallbacks(this.A);
            r(KEY_PAGE_STAGES_DESTROY);
            if (this.g && (iWXApmMonitorAdapter = this.b) != null) {
                iWXApmMonitorAdapter.onEnd();
            }
            this.h = true;
            if (WXEnvironment.isApkDebugable()) {
                t();
            }
        }
    }

    public void q(boolean z2) {
        this.z = true;
        if (z2) {
            r(KEY_PAGE_STAGES_DOWN_BUNDLE_START);
        }
        l();
        for (Map.Entry<String, Long> entry : this.d.entrySet()) {
            x(entry.getKey(), entry.getValue().longValue());
        }
        for (Map.Entry<String, Double> entry2 : this.c.entrySet()) {
            y(entry2.getKey(), entry2.getValue().doubleValue());
        }
        for (Map.Entry<String, Object> entry3 : this.e.entrySet()) {
            w(entry3.getKey(), entry3.getValue());
        }
    }

    public void r(String str) {
        s(str, WXUtils.getFixUnixTime());
    }

    public void s(String str, long j2) {
        if (!this.h && str != null) {
            this.d.put(str, Long.valueOf(j2));
            if (this.z) {
                x(str, j2);
            }
        }
    }

    public void u() {
        if (!this.x) {
            this.x = true;
            g(KEY_PAGE_STATS_VIEW_CREATE_COST, (double) this.v);
            g(KEY_PAGE_STATS_COMPONENT_CREATE_COST, (double) this.t);
            g(KEY_PAGE_STATS_EXECUTE_JS_CALLBACK_COST, (double) this.w);
            g(KEY_PAGE_STATS_LAYOUT_TIME, this.r);
        }
    }

    public void v() {
        if (!this.y) {
            this.y = true;
            WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(this.a);
            if (wXSDKInstance != null) {
                HashMap hashMap = new HashMap(2);
                hashMap.put(KEY_PAGE_PROPERTIES_BIZ_ID, this.m);
                hashMap.put(KEY_PAGE_PROPERTIES_BUBDLE_URL, wXSDKInstance.getBundleUrl());
                HashMap hashMap2 = new HashMap(1);
                hashMap2.put(KEY_PAGE_STAGES_INTERACTION, Long.valueOf(wXSDKInstance.getWXPerformance().interactionRealUnixTime));
                HashMap hashMap3 = new HashMap(2);
                hashMap3.put(TLogEventConst.PARAM_UPLOAD_STAGE, hashMap2);
                hashMap3.put("properties", hashMap);
                wXSDKInstance.fireGlobalEventCallback("wx_apm", hashMap3);
            }
        }
    }

    public void z(String str) {
        WXSDKInstance wXSDKInstance;
        if (TextUtils.isEmpty(str) && (wXSDKInstance = WXSDKManager.v().i().get(this.a)) != null) {
            str = wXSDKInstance.getContainerInfo().get(KEY_PAGE_PROPERTIES_CONTAINER_NAME);
        }
        IWXApmMonitorAdapter iWXApmMonitorAdapter = this.b;
        if (iWXApmMonitorAdapter != null) {
            str = iWXApmMonitorAdapter.parseReportUrl(str);
        }
        this.m = str;
        String str2 = TextUtils.isEmpty(str) ? "emptyPageName" : this.m;
        this.m = str2;
        e(KEY_PAGE_PROPERTIES_BIZ_ID, str2);
    }
}
