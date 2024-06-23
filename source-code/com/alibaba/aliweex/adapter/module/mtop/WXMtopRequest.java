package com.alibaba.aliweex.adapter.module.mtop;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import anetwork.channel.statist.StatisticData;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.adapter.module.mtop.WXMtopModule;
import com.alibaba.aliweex.interceptor.mtop.MtopTracker;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.RemoteBusiness;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.performance.WXStateRecord;
import com.taobao.weex.utils.WXLogUtils;
import com.uc.webview.export.extension.UCCore;
import com.youku.live.livesdk.preloader.Preloader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.util.XStateConstants;
import org.json.JSONArray;
import tb.gl1;
import tb.jl1;
import tb.jx2;
import tb.kx2;
import tb.uf1;

/* compiled from: Taobao */
public class WXMtopRequest {
    public static final String MSG_FAILED = "WX_FAILED";
    public static final String MSG_PARAM_ERR = "MSG_PARAM_ERR";
    public static final String MSG_SUCCESS = "WX_SUCCESS";
    private static ScheduledExecutorService e = Executors.newScheduledThreadPool(1);
    private MtopTracker a;
    private WXMtopModule.MTOP_VERSION b;
    public String c;
    private Handler d = new a(Looper.getMainLooper());

    /* compiled from: Taobao */
    private class RbListener implements IRemoteCacheListener, IRemoteListener {
        private MtopResponse cachedResponse;
        private JSCallback callback;
        private JSCallback failure;
        public String instanceId;
        private boolean isFinish = false;
        private boolean isTimeout = false;
        private MtopTracker mtopTracker;
        private WeakReference<RemoteBusiness> rbWeakRef;
        public String requestAi;
        private long timer;

        public RbListener(MtopTracker mtopTracker2, JSCallback jSCallback, JSCallback jSCallback2, RemoteBusiness remoteBusiness, long j) {
            this.mtopTracker = mtopTracker2;
            this.callback = jSCallback;
            this.failure = jSCallback2;
            this.timer = j;
            this.rbWeakRef = new WeakReference<>(remoteBusiness);
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteCacheListener
        public synchronized void onCached(MtopCacheEvent mtopCacheEvent, BaseOutDo baseOutDo, Object obj) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d("WXMtopRequest", "RemoteBusiness callback onCached");
            }
            if (mtopCacheEvent != null) {
                this.cachedResponse = mtopCacheEvent.getMtopResponse();
                WXMtopRequest.e.schedule(new Runnable() {
                    /* class com.alibaba.aliweex.adapter.module.mtop.WXMtopRequest.RbListener.AnonymousClass3 */

                    public void run() {
                        RbListener.this.onTimeOut();
                    }
                }, this.timer, TimeUnit.MILLISECONDS);
            }
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public synchronized void onError(int i, final MtopResponse mtopResponse, Object obj) {
            if (mtopResponse != null) {
                if (!this.isTimeout) {
                    WXSDKInstance y = WXSDKManager.v().y(this.instanceId);
                    if (y != null) {
                        y.getApmForInstance().d(false, null);
                    }
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                        TBSdkLog.d("WXMtopRequest", "RemoteBusiness callback onError");
                    }
                    this.isFinish = true;
                    WXMtopRequest.e.submit(new Runnable() {
                        /* class com.alibaba.aliweex.adapter.module.mtop.WXMtopRequest.RbListener.AnonymousClass2 */

                        public void run() {
                            RbListener rbListener = RbListener.this;
                            a n = WXMtopRequest.this.n(rbListener.callback, RbListener.this.failure, mtopResponse);
                            if (RbListener.this.mtopTracker != null) {
                                RbListener.this.mtopTracker.n(mtopResponse.getApi(), n.toString());
                            }
                            WXMtopRequest.this.l(n);
                        }
                    });
                }
            }
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public synchronized void onSuccess(int i, final MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
            if (mtopResponse != null) {
                if (!this.isTimeout) {
                    WXSDKInstance y = WXSDKManager.v().y(this.instanceId);
                    if (y != null) {
                        y.getApmForInstance().d(true, null);
                    }
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                        TBSdkLog.d("WXMtopRequest", "RemoteBusiness callback onSuccess");
                    }
                    this.isFinish = true;
                    WXMtopRequest.e.submit(new Runnable() {
                        /* class com.alibaba.aliweex.adapter.module.mtop.WXMtopRequest.RbListener.AnonymousClass1 */

                        public void run() {
                            if (RbListener.this.mtopTracker != null) {
                                RbListener.this.mtopTracker.p(mtopResponse);
                            }
                            RbListener rbListener = RbListener.this;
                            WXMtopRequest wXMtopRequest = WXMtopRequest.this;
                            wXMtopRequest.l(wXMtopRequest.n(rbListener.callback, RbListener.this.failure, mtopResponse));
                        }
                    });
                }
            }
        }

        public synchronized void onTimeOut() {
            if (!this.isFinish) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d("WXMtopRequest", "callback onTimeOut");
                }
                this.isTimeout = true;
                RemoteBusiness remoteBusiness = this.rbWeakRef.get();
                if (remoteBusiness != null) {
                    remoteBusiness.cancelRequest();
                }
                MtopTracker mtopTracker2 = this.mtopTracker;
                if (mtopTracker2 != null) {
                    mtopTracker2.p(this.cachedResponse);
                }
                WXMtopRequest wXMtopRequest = WXMtopRequest.this;
                wXMtopRequest.l(wXMtopRequest.n(this.callback, this.failure, this.cachedResponse));
                WXSDKInstance y = WXSDKManager.v().y(this.instanceId);
                if (y != null) {
                    y.getApmForInstance().d(false, "onTimeOut");
                }
            }
        }
    }

    /* compiled from: Taobao */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            JSCallback jSCallback;
            if (message.what == 500 && (message.obj instanceof a)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d("WXMtopRequest", "call result, retString: " + ((a) message.obj).toString());
                }
                try {
                    a aVar = (a) message.obj;
                    if (aVar.c() != null && aVar.e() != null) {
                        JSONObject jSONObject = new JSONObject();
                        if (WXMtopRequest.this.b == WXMtopModule.MTOP_VERSION.V1) {
                            jSONObject.put("result", (Object) (aVar.g() ? "WX_SUCCESS" : "WX_FAILED"));
                            jSONObject.put("data", (Object) JSON.parseObject(aVar.toString()));
                            jSCallback = aVar.c();
                        } else {
                            jSONObject = JSON.parseObject(aVar.toString());
                            if (aVar.g()) {
                                jSCallback = aVar.c();
                            } else {
                                if (!jSONObject.containsKey("result")) {
                                    jSONObject.put("result", (Object) aVar.f());
                                }
                                jSCallback = aVar.d();
                            }
                        }
                        WXMtopRequest.this.o("weex-mtop-end", null, null, null, aVar);
                        if (jSCallback != null) {
                            jSCallback.invoke(jSONObject);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public WXMtopRequest(WXMtopModule.MTOP_VERSION mtop_version) {
        if (WXEnvironment.isApkDebugable()) {
            this.a = MtopTracker.m();
        }
        this.b = mtop_version;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(1:2)(1:3)|4|(1:6)(1:7)|8|(1:10)|11|(1:13)|14|(1:16)(1:17)|18|(1:20)|21|(1:23)|24|(1:30)|31|32|(1:34)|35|36|(1:38)|39) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00b5 */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bd A[Catch:{ all -> 0x00c2 }] */
    private RemoteBusiness j(MtopRequest mtopRequest, uf1 uf1, String str) {
        RemoteBusiness build = RemoteBusiness.build(mtopRequest, StringUtils.isBlank(uf1.e) ? SDKConfig.getInstance().getGlobalTtid() : uf1.e);
        build.showLoginUI(!uf1.i.equals("AutoLoginOnly"));
        if (uf1.k) {
            build.protocol(ProtocolEnum.HTTPSECURE);
        } else {
            build.protocol(ProtocolEnum.HTTP);
        }
        if ("true".equals(kx2.j().h(kx2.j().m))) {
            build.useCache();
        }
        if (uf1.d > 0) {
            build.useWua();
        }
        build.reqMethod(uf1.h ? MethodEnum.POST : MethodEnum.GET);
        if (uf1.d() != null) {
            build.headers(uf1.d());
        }
        if (StringUtils.isNotBlank(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("x-ua", str);
            build.headers((Map<String, String>) hashMap);
        }
        if (!StringUtils.isBlank(uf1.g) && (Preloader.KEY_JSON.equals(uf1.g) || "originaljson".equals(uf1.g))) {
            build.setJsonType(JsonTypeEnum.valueOf(uf1.g.toUpperCase()));
        }
        if (!TextUtils.isEmpty(uf1.l)) {
            build.setPageUrl(uf1.l);
        }
        if (!TextUtils.isEmpty(uf1.m)) {
            build.setPageName(uf1.m);
        }
        return build;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private MtopRequest k(uf1 uf1) {
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(uf1.a);
        mtopRequest.setVersion(uf1.b);
        mtopRequest.setNeedEcode(uf1.c);
        mtopRequest.setNeedSession(true);
        if (StringUtils.isNotBlank(uf1.j)) {
            mtopRequest.setData(uf1.j);
        }
        mtopRequest.dataParams = uf1.c();
        return mtopRequest;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(a aVar) {
        this.d.obtainMessage(500, aVar).sendToTarget();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private uf1 m(org.json.JSONObject jSONObject) {
        boolean z;
        String str = "data";
        String str2 = MtopJSBridge.MtopJSParam.SEC_TYPE;
        try {
            uf1 uf1 = new uf1();
            uf1.a = jSONObject.getString("api");
            uf1.b = jSONObject.optString("v", jl1.MUL);
            String optString = jSONObject.optString("type");
            boolean z2 = true;
            if ("GET".equalsIgnoreCase(optString) || "POST".equalsIgnoreCase(optString)) {
                uf1.h = "POST".equalsIgnoreCase(jSONObject.optString("type", "GET"));
            } else {
                Object opt = jSONObject.opt(gl1.TYPE_OPEN_URL_METHOD_POST);
                if (opt instanceof Boolean) {
                    uf1.h = ((Boolean) opt).booleanValue();
                } else {
                    uf1.h = jSONObject.optInt(gl1.TYPE_OPEN_URL_METHOD_POST, 0) != 0;
                }
            }
            uf1.g = jSONObject.optString(MtopJSBridge.MtopJSParam.DATA_TYPE, "originaljson");
            uf1.k = "1".equals(jSONObject.optString("isHttps"));
            uf1.m = jSONObject.optString("wxpageName");
            uf1.l = jSONObject.optString("wxpageUrl");
            if (jSONObject.has(MtopJSBridge.MtopJSParam.NEED_LOGIN)) {
                z = jSONObject.optBoolean(MtopJSBridge.MtopJSParam.NEED_LOGIN, false);
            } else if (jSONObject.has("loginRequest")) {
                z = jSONObject.optBoolean("loginRequest", false);
            } else {
                if (jSONObject.optInt("ecode", 0) == 0) {
                    z2 = false;
                }
                z = z2;
            }
            uf1.c = z;
            if (!jSONObject.has(str2)) {
                str2 = "isSec";
            }
            uf1.d = jSONObject.optInt(str2, 0);
            uf1.e = jSONObject.optString("ttid");
            uf1.f = (long) (!jSONObject.has("timeout") ? jSONObject.optInt("timer", 500) : jSONObject.optInt("timeout", 20000));
            uf1.i = jSONObject.optString(MtopJSBridge.MtopJSParam.SESSION_OPTION, "AutoLoginAndManualLogin");
            if (jSONObject.optJSONObject(str) == null) {
                str = "param";
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = optJSONObject.get(next);
                    uf1.a(next, obj.toString());
                    if (!(obj instanceof JSONArray) && !(obj instanceof org.json.JSONObject)) {
                        optJSONObject.put(next, obj.toString());
                    }
                }
                uf1.j = optJSONObject.toString();
            }
            org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject(MtopJSBridge.MtopJSParam.EXT_HEADERS);
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    String string = optJSONObject2.getString(next2);
                    if (!TextUtils.isEmpty(next2) && !TextUtils.isEmpty(string)) {
                        uf1.b(next2, string);
                    }
                }
            }
            return uf1;
        } catch (org.json.JSONException unused) {
            TBSdkLog.e("WXMtopRequest", "parseParams error, param=" + jSONObject.toString());
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private a n(JSCallback jSCallback, JSCallback jSCallback2, MtopResponse mtopResponse) {
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a(jSCallback, jSCallback2);
        if (mtopResponse != null) {
            aVar.f = mtopResponse.getApi();
        }
        aVar.b("ret", new JSONArray().put("HY_FAILED"));
        if (mtopResponse == null) {
            aVar.a("code", "-1");
            TBSdkLog.d("WXMtopRequest", "parseResult: time out");
            return aVar;
        }
        aVar.a("code", String.valueOf(mtopResponse.getResponseCode()));
        if (mtopResponse.isSessionInvalid()) {
            aVar.b("ret", new JSONArray().put("ERR_SID_INVALID"));
            return aVar;
        }
        try {
            if (mtopResponse.getBytedata() != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(new String(mtopResponse.getBytedata(), "utf-8"));
                jSONObject.put("code", String.valueOf(mtopResponse.getResponseCode()));
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                if (mtopResponse.getMtopStat() == null || mtopResponse.getMtopStat().getNetStat() == null) {
                    jSONObject2.put("oneWayTime", 0);
                    jSONObject2.put("recDataSize", 0);
                } else {
                    StatisticData netStat = mtopResponse.getMtopStat().getNetStat();
                    jSONObject2.put("oneWayTime", netStat.oneWayTime_AEngine);
                    jSONObject2.put("recDataSize", netStat.totalSize);
                }
                jSONObject.put(UCCore.EVENT_STAT, jSONObject2);
                aVar.h(jSONObject);
            }
            if (mtopResponse.isApiSuccess()) {
                aVar.j(true);
            } else {
                aVar.i(mtopResponse.getRetCode());
            }
        } catch (Exception unused) {
            if (TBSdkLog.isPrintLog()) {
                TBSdkLog.e("WXMtopRequest", "parseResult mtop response parse fail, content: " + mtopResponse.toString());
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d("WXMtopRequest", "parseResult cost time(ms):" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o(String str, String str2, String str3, String str4, a aVar) {
        IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
        if ((c2 == null || Boolean.valueOf(c2.getConfig(kx2.WXAPM_CONFIG_GROUP, "recordMtopState", "true")).booleanValue()) && com.alibaba.aliweex.a.l().h() != null) {
            HashMap hashMap = new HashMap();
            if (str3 != null) {
                hashMap.put("url", str3);
                WXStateRecord d2 = WXStateRecord.d();
                d2.i("", "sendMtop:" + str3);
            }
            if (str2 != null) {
                hashMap.put("pageName", str2);
            }
            if (str4 != null) {
                hashMap.put("msg", str4);
            }
            if (aVar != null) {
                String str5 = aVar.f;
                if (str5 == null) {
                    str5 = "";
                }
                hashMap.put("callApi", str5);
                hashMap.put("success", Boolean.valueOf(aVar.g()));
                hashMap.put("retCode", aVar.f());
                if (!aVar.g()) {
                    hashMap.put("result", aVar.e().toString());
                }
                WXStateRecord d3 = WXStateRecord.d();
                d3.i("", "receiveMtop:" + str5 + ",result" + aVar.e().toString());
            }
        }
    }

    public void p(Context context, JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        q(context, jSONObject.toString(), jSCallback, jSCallback2);
    }

    public void q(final Context context, final String str, final JSCallback jSCallback, final JSCallback jSCallback2) {
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("mtop send >>> " + str);
        }
        WXSDKInstance y = WXSDKManager.v().y(this.c);
        if (y != null) {
            y.getApmForInstance().c();
        }
        e.submit(new Runnable() {
            /* class com.alibaba.aliweex.adapter.module.mtop.WXMtopRequest.AnonymousClass2 */

            public void run() {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                    uf1 m = WXMtopRequest.this.m(jSONObject);
                    if (m == null) {
                        a aVar = new a(jSCallback, jSCallback2);
                        aVar.b("ret", new JSONArray().put("HY_PARAM_ERR"));
                        WXMtopRequest.this.l(aVar);
                        return;
                    }
                    WXSDKInstance y = WXSDKManager.v().y(WXMtopRequest.this.c);
                    if ((TextUtils.isEmpty(m.m) || TextUtils.isEmpty(m.l)) && y != null) {
                        try {
                            XState.setValue(XStateConstants.KEY_CURRENT_PAGE_NAME, y.getApmForInstance().m);
                            XState.setValue(XStateConstants.KEY_CURRENT_PAGE_URL, y.getBundleUrl());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    MtopRequest k = WXMtopRequest.this.k(m);
                    WXMtopRequest.this.o("weex-send-mtop", y == null ? "" : y.getWXPerformance().pageName, k.getApiName(), k.getVersion(), null);
                    String optString = jSONObject.optString("userAgent");
                    if (TextUtils.isEmpty(optString)) {
                        optString = jx2.a(context, WXEnvironment.getConfig());
                    }
                    RemoteBusiness j = WXMtopRequest.this.j(k, m, optString);
                    if (WXMtopRequest.this.a != null) {
                        WXMtopRequest.this.a.r(j);
                    }
                    WXMtopRequest wXMtopRequest = WXMtopRequest.this;
                    RbListener rbListener = new RbListener(wXMtopRequest.a, jSCallback, jSCallback2, j, m.f);
                    rbListener.instanceId = WXMtopRequest.this.c;
                    rbListener.requestAi = k.getApiName();
                    j.registeListener((IRemoteListener) rbListener);
                    j.startRequest();
                } catch (Exception e) {
                    TBSdkLog.e("WXMtopRequest", "send Request failed" + e);
                    a aVar2 = new a(jSCallback, jSCallback2);
                    aVar2.b("ret", new JSONArray().put("HY_FAILED"));
                    WXMtopRequest.this.l(aVar2);
                }
            }
        });
    }

    public WXMtopRequest r(String str) {
        this.c = str;
        return this;
    }
}
