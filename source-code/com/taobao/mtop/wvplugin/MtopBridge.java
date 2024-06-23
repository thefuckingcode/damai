package com.taobao.mtop.wvplugin;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.alibaba.fastjson.JSON;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.uc.webview.export.extension.UCCore;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.stat.IUploadStats;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.network.domain.NetworkStats;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.gl1;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class MtopBridge {
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static ScheduledExecutorService d = Executors.newScheduledThreadPool(1);
    private WeakReference<MtopWVPlugin> a = null;
    private Handler b = new a(Looper.getMainLooper());

    /* compiled from: Taobao */
    private class MtopBridgeListener implements IRemoteBaseListener {
        private Map<String, Object> jsParamMap;
        private WVCallBackContext wvCallBackContext;

        public MtopBridgeListener(WVCallBackContext wVCallBackContext, Map<String, Object> map) {
            this.wvCallBackContext = wVCallBackContext;
            this.jsParamMap = map;
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public void onError(int i, MtopResponse mtopResponse, Object obj) {
            MtopBridge mtopBridge = MtopBridge.this;
            mtopBridge.f(mtopBridge.h(this.wvCallBackContext, mtopResponse, this.jsParamMap));
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
            MtopBridge mtopBridge = MtopBridge.this;
            mtopBridge.f(mtopBridge.h(this.wvCallBackContext, mtopResponse, this.jsParamMap));
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
        public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
            MtopBridge mtopBridge = MtopBridge.this;
            mtopBridge.f(mtopBridge.h(this.wvCallBackContext, mtopResponse, this.jsParamMap));
        }
    }

    /* compiled from: Taobao */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 500 && (message.obj instanceof b)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d("mtopsdk.MtopBridge", "call result, retString: " + ((b) message.obj).toString());
                }
                MtopWVPlugin mtopWVPlugin = (MtopWVPlugin) MtopBridge.this.a.get();
                if (mtopWVPlugin != null) {
                    try {
                        mtopWVPlugin.wvCallback((b) message.obj);
                    } catch (Exception e) {
                        TBSdkLog.e("mtopsdk.MtopBridge", "execute  plugin.wvCallback error.", e);
                    }
                }
            }
        }
    }

    public MtopBridge(MtopWVPlugin mtopWVPlugin) {
        this.a = new WeakReference<>(mtopWVPlugin);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(b bVar) {
        if (bVar != null) {
            this.b.obtainMessage(500, bVar).sendToTarget();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Map<String, Object> g(a aVar) {
        HashMap hashMap;
        Throwable th;
        boolean z;
        String str;
        int i;
        int i2;
        if (aVar == null || StringUtils.isBlank(aVar.a)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(aVar.a);
            hashMap = new HashMap();
            try {
                hashMap.put("api", jSONObject.getString("api"));
                hashMap.put("v", jSONObject.optString("v", jl1.MUL));
                hashMap.put("data", jSONObject.optJSONObject("param"));
                hashMap.put("instanceid", jSONObject.optString("instanceid", ""));
                if (!jSONObject.isNull(MtopJSBridge.MtopJSParam.NEED_LOGIN)) {
                    z = jSONObject.optBoolean(MtopJSBridge.MtopJSParam.NEED_LOGIN);
                } else {
                    z = jSONObject.optInt("ecode", 0) != 0;
                }
                String optString = jSONObject.optString(MtopJSBridge.MtopJSParam.SESSION_OPTION);
                hashMap.put(MtopJSBridge.MtopJSParam.NEED_LOGIN, Boolean.valueOf(z));
                hashMap.put(MtopJSBridge.MtopJSParam.SESSION_OPTION, optString);
                String str2 = "GET";
                if (!jSONObject.isNull("method")) {
                    str2 = jSONObject.optString("method");
                } else if (jSONObject.optInt(gl1.TYPE_OPEN_URL_METHOD_POST, 0) != 0) {
                    str2 = "POST";
                }
                hashMap.put("method", str2);
                if (!jSONObject.isNull(MtopJSBridge.MtopJSParam.DATA_TYPE)) {
                    str = jSONObject.optString(MtopJSBridge.MtopJSParam.DATA_TYPE);
                } else {
                    str = jSONObject.optString("type");
                }
                hashMap.put(MtopJSBridge.MtopJSParam.DATA_TYPE, str);
                if (!jSONObject.isNull(MtopJSBridge.MtopJSParam.SEC_TYPE)) {
                    i = jSONObject.optInt(MtopJSBridge.MtopJSParam.SEC_TYPE);
                } else {
                    i = jSONObject.optInt("isSec", 0);
                }
                hashMap.put(MtopJSBridge.MtopJSParam.SEC_TYPE, Integer.valueOf(i));
                int i3 = 20000;
                if (!jSONObject.isNull("timeout")) {
                    i2 = jSONObject.optInt("timeout", 20000);
                } else {
                    i2 = jSONObject.optInt("timer", 20000);
                }
                if (i2 >= 0) {
                    i3 = i2 > 60000 ? 60000 : i2;
                }
                hashMap.put("timeout", Integer.valueOf(i3));
                hashMap.put(MtopJSBridge.MtopJSParam.EXT_HEADERS, jSONObject.optJSONObject(MtopJSBridge.MtopJSParam.EXT_HEADERS));
                hashMap.put("user-agent", aVar.b);
                hashMap.put("ttid", jSONObject.optString("ttid"));
                hashMap.put(MtopJSBridge.MtopJSParam.PAGE_URL, aVar.c);
                hashMap.put(MtopJSBridge.MtopJSParam.EXT_QUERYS, jSONObject.optJSONObject(MtopJSBridge.MtopJSParam.EXT_QUERYS));
                hashMap.put(MtopJSBridge.MtopJSParam.MP_HOST, jSONObject.optString(MtopJSBridge.MtopJSParam.MP_HOST));
                hashMap.put("x-ua", aVar.b);
            } catch (Throwable th2) {
                th = th2;
                TBSdkLog.e("mtopsdk.MtopBridge", "parseJSParams error.params =" + aVar.a, th);
                return hashMap;
            }
        } catch (Throwable th3) {
            th = th3;
            hashMap = null;
            TBSdkLog.e("mtopsdk.MtopBridge", "parseJSParams error.params =" + aVar.a, th);
            return hashMap;
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private b h(WVCallBackContext wVCallBackContext, MtopResponse mtopResponse, Map<String, Object> map) {
        if (wVCallBackContext == null) {
            TBSdkLog.e("mtopsdk.MtopBridge", "[parseResult]WVCallBackContext is null, webview may be destroyed , mtopJsParamsMap:" + map);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        String str2 = map != null ? (String) map.get("api") : str;
        if (map != null) {
            str = (String) map.get("v");
        }
        b bVar = new b(wVCallBackContext);
        if (mtopResponse == null) {
            TBSdkLog.e("mtopsdk.MtopBridge", "[parseResult]MP_TIME_OUT. mtopJsParamsMap:" + map);
            e(str2, str, "-1", MtopWVPlugin.TIME_OUT, null);
            bVar.a("code", "-1");
            bVar.b("ret", new JSONArray().put(MtopWVPlugin.TIME_OUT));
            return bVar;
        }
        String valueOf = String.valueOf(mtopResponse.getResponseCode());
        bVar.a("code", valueOf);
        if (mtopResponse.isSessionInvalid()) {
            e(str2, str, valueOf, "ERR_SID_INVALID", mtopResponse.getRetCode());
            bVar.b("ret", new JSONArray().put("ERR_SID_INVALID"));
            return bVar;
        }
        bVar.b("ret", new JSONArray().put("HY_FAILED"));
        try {
            if (mtopResponse.getBytedata() != null) {
                JSONObject jSONObject = new JSONObject(new String(mtopResponse.getBytedata(), "utf-8"));
                bVar.e(jSONObject);
                jSONObject.put("headers", JSON.toJSONString(mtopResponse.getHeaderFields()));
                jSONObject.put("code", valueOf);
                jSONObject.put("isFromCache", mtopResponse.getSource() != MtopResponse.ResponseSource.NETWORK_REQUEST ? "1" : "0");
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put(UCCore.EVENT_STAT, jSONObject2);
                    MtopStatistics mtopStat = mtopResponse.getMtopStat();
                    if (mtopStat == null || mtopStat.getNetworkStats() == null) {
                        jSONObject2.put("oneWayTime", 0);
                        jSONObject2.put("recDataSize", 0);
                    } else {
                        NetworkStats networkStats = mtopStat.getNetworkStats();
                        jSONObject2.put("oneWayTime", networkStats.oneWayTime_ANet);
                        jSONObject2.put("recDataSize", networkStats.recvSize);
                    }
                } catch (Exception e) {
                    TBSdkLog.e("mtopsdk.MtopBridge", "[parseResult] parse network stats error" + e.toString());
                }
                e(str2, str, valueOf, mtopResponse.getRetCode(), mtopResponse.getRetCode());
            } else {
                bVar.a("retCode", mtopResponse.getRetCode());
                e(str2, str, valueOf, "HY_FAILED", mtopResponse.getRetCode());
            }
            if (mtopResponse.isApiSuccess()) {
                bVar.g(true);
            }
        } catch (Exception unused) {
            if (TBSdkLog.isPrintLog()) {
                TBSdkLog.e("mtopsdk.MtopBridge", "[parseResult] mtop response parse fail, content: " + mtopResponse);
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d("mtopsdk.MtopBridge", "parseResult cost time(ms):" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return bVar;
    }

    public void e(String str, String str2, String str3, String str4, String str5) {
        try {
            IUploadStats iUploadStats = Mtop.instance(Mtop.Id.INNER, (Context) null).getMtopConfig().uploadStats;
            if (iUploadStats != null) {
                if (c.compareAndSet(false, true)) {
                    HashSet hashSet = new HashSet();
                    hashSet.add("api");
                    hashSet.add("v");
                    hashSet.add("ret");
                    hashSet.add("code");
                    hashSet.add("retCode");
                    iUploadStats.onRegister("mtopsdk", "jsStats", hashSet, null, false);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("api", str);
                hashMap.put("v", str2);
                hashMap.put("ret", str4);
                hashMap.put("code", str3);
                hashMap.put("retCode", str5);
                iUploadStats.onCommit("mtopsdk", "jsStats", hashMap, null);
            }
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.MtopBridge", "commitMtopJSStat error.", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(final WVCallBackContext wVCallBackContext, final String str) {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d("mtopsdk.MtopBridge", "MtopBridge JSParams: " + str);
        }
        final a aVar = new a(str);
        MtopWVPlugin mtopWVPlugin = this.a.get();
        if (mtopWVPlugin != null) {
            aVar.b = mtopWVPlugin.getUserAgent();
            aVar.c = mtopWVPlugin.getCurrentUrl();
        }
        d.submit(new Runnable() {
            /* class com.taobao.mtop.wvplugin.MtopBridge.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:13:0x007c  */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0086  */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x0089  */
            public void run() {
                Exception e;
                Map map;
                String str = null;
                try {
                    map = MtopBridge.this.g(aVar);
                    if (map == null) {
                        try {
                            TBSdkLog.e("mtopsdk.MtopBridge", "MtopBridge parseJSParams failed. params:" + str);
                            MtopBridge.this.e(null, null, "MtopBridge parseJSParams failed.", "HY_PARAM_ERR", null);
                            b bVar = new b(wVCallBackContext);
                            bVar.b("ret", new JSONArray().put("HY_PARAM_ERR"));
                            bVar.a("code", "MtopBridge parseJSParams failed.");
                            MtopBridge.this.f(bVar);
                        } catch (Exception e2) {
                            e = e2;
                            TBSdkLog.e("mtopsdk.MtopBridge", "MtopJSBridge sendMtopRequest failed.params:" + str, e);
                            if (map == null) {
                            }
                            if (map != null) {
                            }
                            MtopBridge.this.e(r6, str, "MtopJSBridge sendMtopRequest failed.", "HY_FAILED", null);
                            b bVar2 = new b(wVCallBackContext);
                            bVar2.b("ret", new JSONArray().put("HY_FAILED"));
                            bVar2.a("code", "MtopJSBridge sendMtopRequest failed.");
                            MtopBridge.this.f(bVar2);
                        }
                    } else {
                        MtopJSBridge.sendMtopRequest(map, new MtopBridgeListener(wVCallBackContext, map));
                    }
                } catch (Exception e3) {
                    e = e3;
                    map = null;
                    TBSdkLog.e("mtopsdk.MtopBridge", "MtopJSBridge sendMtopRequest failed.params:" + str, e);
                    String str2 = map == null ? (String) map.get("api") : null;
                    if (map != null) {
                        str = (String) map.get("v");
                    }
                    MtopBridge.this.e(str2, str, "MtopJSBridge sendMtopRequest failed.", "HY_FAILED", null);
                    b bVar22 = new b(wVCallBackContext);
                    bVar22.b("ret", new JSONArray().put("HY_FAILED"));
                    bVar22.a("code", "MtopJSBridge sendMtopRequest failed.");
                    MtopBridge.this.f(bVar22);
                }
            }
        });
    }
}
