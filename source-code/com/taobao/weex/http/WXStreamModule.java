package com.taobao.weex.http;

import android.net.Uri;
import android.text.TextUtils;
import anet.channel.request.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.common.WXRequest;
import com.taobao.weex.common.WXResponse;
import com.taobao.weex.http.Options;
import com.taobao.weex.performance.WXStateRecord;
import com.taobao.weex.utils.WXLogUtils;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.jl1;
import tb.jx2;
import tb.le2;

/* compiled from: Taobao */
public class WXStreamModule extends WXModule {
    static final Pattern CHARSET_PATTERN = Pattern.compile("charset=([a-z0-9-]+)");
    public static final String STATUS = "status";
    public static final String STATUS_TEXT = "statusText";
    final IWXHttpAdapter mAdapter;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface ResponseCallback {
        void onResponse(WXResponse wXResponse, Map<String, String> map);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements ResponseCallback {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.taobao.weex.http.WXStreamModule.ResponseCallback
        public void onResponse(WXResponse wXResponse, Map<String, String> map) {
            String str;
            byte[] bArr;
            if (this.a != null && WXStreamModule.this.mWXSDKInstance != null) {
                WXBridgeManager instance = WXBridgeManager.getInstance();
                String instanceId = WXStreamModule.this.mWXSDKInstance.getInstanceId();
                String str2 = this.a;
                if (wXResponse == null || (bArr = wXResponse.originalData) == null) {
                    str = "{}";
                } else {
                    str = WXStreamModule.readAsString(bArr, map != null ? WXStreamModule.getHeader(map, "Content-Type") : "");
                }
                instance.callback(instanceId, str2, str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements ResponseCallback {
        final /* synthetic */ JSCallback a;
        final /* synthetic */ Options b;
        final /* synthetic */ String c;

        b(JSCallback jSCallback, Options options, String str) {
            this.a = jSCallback;
            this.b = options;
            this.c = str;
        }

        @Override // com.taobao.weex.http.WXStreamModule.ResponseCallback
        public void onResponse(WXResponse wXResponse, Map<String, String> map) {
            String str;
            if (this.a != null) {
                HashMap hashMap = new HashMap();
                if (wXResponse == null || "-1".equals(wXResponse.statusCode)) {
                    hashMap.put("status", -1);
                    hashMap.put(WXStreamModule.STATUS_TEXT, le2.ERR_CONNECT_FAILED);
                } else {
                    int parseInt = Integer.parseInt(wXResponse.statusCode);
                    hashMap.put("status", Integer.valueOf(parseInt));
                    hashMap.put("ok", Boolean.valueOf(parseInt >= 200 && parseInt <= 299));
                    byte[] bArr = wXResponse.originalData;
                    if (bArr == null) {
                        hashMap.put("data", null);
                    } else {
                        if (map != null) {
                            str = WXStreamModule.getHeader(map, "Content-Type");
                        } else {
                            str = "";
                        }
                        try {
                            hashMap.put("data", WXStreamModule.this.parseData(WXStreamModule.readAsString(bArr, str), this.b.e()));
                        } catch (JSONException e) {
                            WXLogUtils.e("", e);
                            hashMap.put("ok", Boolean.FALSE);
                            hashMap.put("data", "{'err':'Data parse failed!'}");
                        }
                    }
                    hashMap.put(WXStreamModule.STATUS_TEXT, le2.a(wXResponse.statusCode));
                }
                hashMap.put("headers", map);
                WXStateRecord d2 = WXStateRecord.d();
                String str2 = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("stream response code:");
                sb.append(wXResponse != null ? wXResponse.statusCode : "null");
                d2.i(str2, sb.toString());
                this.a.invoke(hashMap);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c implements IWXHttpAdapter.OnHttpListener {
        private ResponseCallback a;
        private JSCallback b;
        private Map<String, Object> c;
        private Map<String, String> d;

        /* synthetic */ c(ResponseCallback responseCallback, JSCallback jSCallback, a aVar) {
            this(responseCallback, jSCallback);
        }

        @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
        public void onHeadersReceived(int i, Map<String, List<String>> map) {
            this.c.put("readyState", 2);
            this.c.put("status", Integer.valueOf(i));
            HashMap hashMap = new HashMap();
            if (map != null) {
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    if (entry.getValue().size() != 0) {
                        int size = entry.getValue().size();
                        String str = JSMethod.NOT_SET;
                        if (size == 1) {
                            if (entry.getKey() != null) {
                                str = entry.getKey();
                            }
                            hashMap.put(str, entry.getValue().get(0));
                        } else {
                            if (entry.getKey() != null) {
                                str = entry.getKey();
                            }
                            hashMap.put(str, entry.getValue().toString());
                        }
                    }
                }
            }
            this.c.put("headers", hashMap);
            this.d = hashMap;
            JSCallback jSCallback = this.b;
            if (jSCallback != null) {
                jSCallback.invokeAndKeepAlive(new HashMap(this.c));
            }
        }

        @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
        public void onHttpFinish(WXResponse wXResponse) {
            byte[] bArr;
            ResponseCallback responseCallback = this.a;
            if (responseCallback != null) {
                responseCallback.onResponse(wXResponse, this.d);
            }
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("WXStreamModule", (wXResponse == null || (bArr = wXResponse.originalData) == null) ? "response data is NUll!" : new String(bArr));
            }
        }

        @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
        public void onHttpResponseProgress(int i) {
            this.c.put("length", Integer.valueOf(i));
            JSCallback jSCallback = this.b;
            if (jSCallback != null) {
                jSCallback.invokeAndKeepAlive(new HashMap(this.c));
            }
        }

        @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
        public void onHttpStart() {
            if (this.b != null) {
                this.c.put("readyState", 1);
                this.c.put("length", 0);
                this.b.invokeAndKeepAlive(new HashMap(this.c));
            }
        }

        @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
        public void onHttpUploadProgress(int i) {
        }

        private c(ResponseCallback responseCallback, JSCallback jSCallback) {
            this.c = new HashMap();
            this.a = responseCallback;
            this.b = jSCallback;
        }
    }

    public WXStreamModule() {
        this(null);
    }

    private void extractHeaders(JSONObject jSONObject, Options.b bVar) {
        String a2 = jx2.a(WXEnvironment.getApplication(), WXEnvironment.getConfig());
        if (jSONObject != null) {
            for (String str : jSONObject.keySet()) {
                if (str.equals("user-agent")) {
                    a2 = jSONObject.getString(str);
                } else {
                    bVar.b(str, jSONObject.getString(str));
                }
            }
        }
        bVar.b("user-agent", a2);
    }

    static String getHeader(Map<String, String> map, String str) {
        if (map == null || str == null) {
            return null;
        }
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return map.get(str.toLowerCase(Locale.ROOT));
    }

    static String readAsString(byte[] bArr, String str) {
        String str2;
        if (str != null) {
            Matcher matcher = CHARSET_PATTERN.matcher(str.toLowerCase(Locale.ROOT));
            if (matcher.find()) {
                str2 = matcher.group(1);
                return new String(bArr, str2);
            }
        }
        str2 = "utf-8";
        try {
            return new String(bArr, str2);
        } catch (UnsupportedEncodingException e) {
            WXLogUtils.e("", e);
            return new String(bArr);
        }
    }

    private void sendRequest(Options options, ResponseCallback responseCallback, JSCallback jSCallback, String str, String str2) {
        WXRequest wXRequest = new WXRequest();
        wXRequest.method = options.c();
        wXRequest.url = WXSDKManager.v().A().rewrite(str2, "request", Uri.parse(options.f())).toString();
        wXRequest.body = options.a();
        wXRequest.timeoutMs = options.d();
        wXRequest.instanceId = str;
        if (options.b() != null) {
            Map<String, String> map = wXRequest.paramMap;
            if (map == null) {
                wXRequest.paramMap = options.b();
            } else {
                map.putAll(options.b());
            }
        }
        IWXHttpAdapter iWXHttpAdapter = this.mAdapter;
        if (iWXHttpAdapter == null) {
            iWXHttpAdapter = WXSDKManager.v().n();
        }
        if (iWXHttpAdapter != null) {
            iWXHttpAdapter.sendRequest(wXRequest, new c(responseCallback, jSCallback, null));
        } else {
            WXLogUtils.e("WXStreamModule", "No HttpAdapter found,request failed.");
        }
    }

    @JSMethod(uiThread = false)
    public void fetch(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        fetch(jSONObject, jSCallback, jSCallback2, this.mWXSDKInstance.getInstanceId(), this.mWXSDKInstance.getBundleUrl());
    }

    /* access modifiers changed from: package-private */
    public Object parseData(String str, Options.Type type) throws JSONException {
        if (type == Options.Type.json) {
            return JSON.parse(str);
        }
        if (type != Options.Type.jsonp) {
            return str;
        }
        if (str == null || str.isEmpty()) {
            return new JSONObject();
        }
        int indexOf = str.indexOf(jl1.BRACKET_START_STR) + 1;
        int lastIndexOf = str.lastIndexOf(jl1.BRACKET_END_STR);
        if (indexOf == 0 || indexOf >= lastIndexOf || lastIndexOf <= 0) {
            return new JSONObject();
        }
        return JSON.parse(str.substring(indexOf, lastIndexOf));
    }

    @JSMethod(uiThread = false)
    @Deprecated
    public void sendHttp(JSONObject jSONObject, String str) {
        String string = jSONObject.getString("method");
        String string2 = jSONObject.getString("url");
        JSONObject jSONObject2 = jSONObject.getJSONObject("header");
        String string3 = jSONObject.getString("body");
        int intValue = jSONObject.getIntValue("timeout");
        if (string != null) {
            string = string.toUpperCase(Locale.ROOT);
        }
        Options.b bVar = new Options.b();
        if (!"GET".equals(string) && !"POST".equals(string) && !a.c.PUT.equals(string) && !a.c.DELETE.equals(string) && !a.c.HEAD.equals(string) && !"PATCH".equals(string)) {
            string = "GET";
        }
        Options.b e = bVar.d(string).g(string2).c(string3).e(intValue);
        extractHeaders(jSONObject2, e);
        sendRequest(e.a(), new a(str), null, this.mWXSDKInstance.getInstanceId(), this.mWXSDKInstance.getBundleUrl());
    }

    public WXStreamModule(IWXHttpAdapter iWXHttpAdapter) {
        this.mAdapter = iWXHttpAdapter;
    }

    public void fetch(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2, String str, String str2) {
        if (!(jSONObject == null || jSONObject.getString("url") == null)) {
            String string = jSONObject.getString("method");
            String string2 = jSONObject.getString("url");
            JSONObject jSONObject2 = jSONObject.getJSONObject("headers");
            String string3 = jSONObject.getString("body");
            String string4 = jSONObject.getString("type");
            int intValue = jSONObject.getIntValue("timeout");
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (!(y == null || y.getStreamNetworkHandler() == null)) {
                String fetchLocal = y.getStreamNetworkHandler().fetchLocal(string2);
                if (!TextUtils.isEmpty(fetchLocal)) {
                    string2 = fetchLocal;
                }
            }
            if (string != null) {
                string = string.toUpperCase(Locale.ROOT);
            }
            Options.b bVar = new Options.b();
            if (!"GET".equals(string) && !"POST".equals(string) && !a.c.PUT.equals(string) && !a.c.DELETE.equals(string) && !a.c.HEAD.equals(string) && !"PATCH".equals(string)) {
                string = "GET";
            }
            Options.b e = bVar.d(string).g(string2).c(string3).f(string4).e(intValue);
            extractHeaders(jSONObject2, e);
            Options a2 = e.a();
            sendRequest(a2, new b(jSCallback, a2, str), jSCallback2, str, str2);
        } else if (jSCallback != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ok", Boolean.FALSE);
            hashMap.put(STATUS_TEXT, le2.ERR_INVALID_REQUEST);
            jSCallback.invoke(hashMap);
        }
    }
}
