package com.alibaba.aliweex.interceptor.network;

import android.os.SystemClock;
import android.text.TextUtils;
import anetwork.channel.Header;
import anetwork.channel.NetworkEvent$ProgressEvent;
import anetwork.channel.Param;
import anetwork.channel.Request;
import com.alibaba.aliweex.interceptor.IWeexAnalyzerInspector;
import com.alibaba.aliweex.interceptor.a;
import com.alibaba.poplayer.trigger.c;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXPerformance;
import com.taobao.weex.utils.WXLogUtils;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import mtopsdk.network.util.Constants;
import tb.gn2;
import tb.j11;
import tb.k11;
import tb.le2;
import tb.th1;
import tb.zz1;

/* compiled from: Taobao */
public class NetworkTracker {
    private static boolean i = true;
    private th1 a;
    private boolean b = false;
    private double c = (((double) SystemClock.elapsedRealtime()) / 1000.0d);
    private String d;
    private k11 e;
    private IWeexAnalyzerInspector f;
    private final int g = gn2.a();
    @Nullable
    private String h;

    private NetworkTracker() {
        if (WXEnvironment.isApkDebugable()) {
            this.a = th1.d();
            this.f = a.a();
            WXLogUtils.d("NetworkTracker", "Create new instance " + toString());
        }
    }

    private boolean j() {
        th1 th1;
        return i && WXEnvironment.isApkDebugable() && (th1 = this.a) != null && th1.g();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String k() {
        if (this.h == null) {
            this.h = String.valueOf(this.g);
        }
        return this.h;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(final byte[] bArr, final k11 k11) {
        if (j()) {
            this.a.c(new Runnable() {
                /* class com.alibaba.aliweex.interceptor.network.NetworkTracker.AnonymousClass5 */

                public void run() {
                    if (bArr != null) {
                        NetworkTracker.this.a.f(NetworkTracker.this.k(), k11.d(), k11.b(), new ByteArrayInputStream(bArr), false);
                    }
                    NetworkTracker.this.a.k(NetworkTracker.this.k());
                }
            });
        }
    }

    public static NetworkTracker m() {
        return new NetworkTracker();
    }

    private void t(String str, Throwable th) {
        try {
            i = false;
            WXLogUtils.w("Disable NetworkTracker");
            IWXUserTrackAdapter t = WXSDKManager.v().t();
            if (t != null && WXEnvironment.getApplication() != null) {
                WXPerformance wXPerformance = new WXPerformance("useless");
                wXPerformance.args = "message: " + str + ";" + "requestId: " + this.g + ";" + "isApkDebugable: " + WXEnvironment.isApkDebugable() + ";" + "canReport: " + j() + ";" + "exception: " + WXLogUtils.getStackTrace(th);
                WXErrorCode wXErrorCode = WXErrorCode.WX_ERR_INVOKE_NATIVE;
                wXPerformance.errCode = wXErrorCode.getErrorCode();
                wXPerformance.appendErrMsg(wXErrorCode.getErrorMsg());
                t.commit(WXEnvironment.getApplication(), null, IWXUserTrackAdapter.STREAM_MODULE, wXPerformance, null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void n(final NetworkEvent$ProgressEvent networkEvent$ProgressEvent) {
        try {
            if (j()) {
                this.a.c(new Runnable() {
                    /* class com.alibaba.aliweex.interceptor.network.NetworkTracker.AnonymousClass3 */

                    public void run() {
                        int length = networkEvent$ProgressEvent.getBytedata() == null ? 0 : networkEvent$ProgressEvent.getBytedata().length;
                        WXLogUtils.d("NetworkTracker", NetworkTracker.this.k() + " onDataReceived -> " + length + " bytes");
                        NetworkTracker.this.a.a(NetworkTracker.this.k(), length, 0);
                    }
                });
            }
        } catch (Throwable th) {
            t("Exception on onDataReceived()", th);
        }
    }

    public void o(String str) {
        try {
            if (j()) {
                WXLogUtils.d("NetworkTracker", k() + " onFailed: " + str);
                this.a.e(k(), str);
            }
        } catch (Throwable th) {
            t("Exception on onFailed()", th);
        }
    }

    public void p(final byte[] bArr) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        k11 k11;
        try {
            if (j()) {
                this.a.c(new Runnable() {
                    /* class com.alibaba.aliweex.interceptor.network.NetworkTracker.AnonymousClass4 */

                    public void run() {
                        WXLogUtils.d("NetworkTracker", NetworkTracker.this.k() + " onFinished -> " + bArr.length + " bytes");
                        NetworkTracker networkTracker = NetworkTracker.this;
                        networkTracker.l(bArr, networkTracker.e);
                    }
                });
            }
            if (WXEnvironment.isApkDebugable() && (iWeexAnalyzerInspector = this.f) != null && iWeexAnalyzerInspector.isEnabled() && (k11 = this.e) != null && bArr != null) {
                IWeexAnalyzerInspector iWeexAnalyzerInspector2 = this.f;
                String str = TextUtils.isEmpty((CharSequence) k11.f().get("url")) ? "unknown" : (String) this.e.f().get("url");
                String str2 = new String(bArr);
                int intValue = ((Integer) this.e.f().get(HiAnalyticsConstant.HaKey.BI_KEY_RESULT)).intValue();
                iWeexAnalyzerInspector2.onResponse("http", new IWeexAnalyzerInspector.b(str, str2, intValue, Collections.singletonMap(Constants.Protocol.CONTENT_LENGTH, Collections.singletonList(bArr.length + ""))));
            }
        } catch (Throwable th) {
            t("Exception on onFinished()", th);
        }
    }

    public void q(final int i2, final Map<String, List<String>> map) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        try {
            if (j() && !this.b) {
                this.a.c(new Runnable() {
                    /* class com.alibaba.aliweex.interceptor.network.NetworkTracker.AnonymousClass2 */

                    public void run() {
                        WXLogUtils.d("NetworkTracker", NetworkTracker.this.k() + " onResponseCode -> " + i2 + AVFSCacheConstants.COMMA_SEP + map.toString());
                        NetworkTracker.this.e = new k11();
                        NetworkTracker.this.e.m(i2);
                        NetworkTracker.this.e.h(NetworkTracker.this.k());
                        NetworkTracker.this.e.i(NetworkTracker.this.d);
                        NetworkTracker.this.e.l(le2.a(String.valueOf(i2)));
                        String str = "";
                        for (Map.Entry entry : map.entrySet()) {
                            String str2 = (String) entry.getKey();
                            String obj = ((List) entry.getValue()).toString();
                            if (str2 != null) {
                                NetworkTracker.this.e.a(str2, obj);
                            } else {
                                str = str + obj + ";";
                            }
                        }
                        NetworkTracker.this.e.a("NULL", str);
                        NetworkTracker.this.a.i(NetworkTracker.this.e);
                        NetworkTracker.this.b = true;
                    }
                });
            }
            if (WXEnvironment.isApkDebugable() && (iWeexAnalyzerInspector = this.f) != null && iWeexAnalyzerInspector.isEnabled()) {
                k11 k11 = new k11();
                this.e = k11;
                k11.m(i2);
                this.e.i(this.d);
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String obj = entry.getValue().toString();
                    if (key != null) {
                        this.e.a(key, obj);
                    }
                }
            }
        } catch (Throwable th) {
            t("Exception on onResponseCode()", th);
        }
    }

    public void r(final Map<String, Object> map) {
        if (this.e != null && !map.isEmpty()) {
            this.a.c(new Runnable() {
                /* class com.alibaba.aliweex.interceptor.network.NetworkTracker.AnonymousClass6 */

                public void run() {
                    map.put("requestTime", Double.valueOf(NetworkTracker.this.c));
                    NetworkTracker.this.e.n(map);
                }
            });
        }
    }

    public void s(final Request request) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        try {
            if (j()) {
                this.a.c(new Runnable() {
                    /* class com.alibaba.aliweex.interceptor.network.NetworkTracker.AnonymousClass1 */

                    /* JADX INFO: finally extract failed */
                    public void run() {
                        WXLogUtils.d("NetworkTracker", NetworkTracker.this.k() + " preRequest -> " + request.getURL());
                        j11 j11 = new j11();
                        for (Header header : request.getHeaders()) {
                            j11.a(header.getName(), header.getValue());
                        }
                        if (!(request.getBodyEntry() == null || request.getBodyEntry().getContentType() == null)) {
                            j11.a("Content-Type", request.getBodyEntry().getContentType());
                        }
                        if (request.getParams() != null) {
                            for (Param param : request.getParams()) {
                                j11.a(param.getKey(), param.getValue());
                            }
                        }
                        j11.a("charset", request.getCharset());
                        j11.a("connectTimeout", String.valueOf(request.getConnectTimeout()));
                        j11.a("readTimeout", String.valueOf(request.getReadTimeout()));
                        j11.a(c.KEY_RETRY_TIME, String.valueOf(request.getRetryTime()));
                        NetworkTracker.this.d = request.getURL().toString();
                        j11.i(NetworkTracker.this.d);
                        j11.h(NetworkTracker.this.k());
                        j11.l("ANet");
                        j11.m(TextUtils.isEmpty(request.getMethod()) ? "GET" : request.getMethod());
                        if (request.getBodyEntry() != null) {
                            try {
                                zz1 zz1 = new zz1(NetworkTracker.this.a, NetworkTracker.this.k());
                                OutputStream a = zz1.a(j11.d());
                                try {
                                    request.getBodyEntry().writeTo(a);
                                    a.close();
                                    j11.k(zz1.b());
                                } catch (Throwable th) {
                                    a.close();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                        NetworkTracker.this.a.h(j11);
                        NetworkTracker.this.a.b(NetworkTracker.this.k(), j11.c(), 0);
                    }
                });
            }
            if (WXEnvironment.isApkDebugable() && (iWeexAnalyzerInspector = this.f) != null && iWeexAnalyzerInspector.isEnabled()) {
                this.d = request.getUrlString();
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("charset", request.getCharset());
                    hashMap.put("connectTimeout", String.valueOf(request.getConnectTimeout()));
                    hashMap.put("readTimeout", String.valueOf(request.getReadTimeout()));
                    hashMap.put(c.KEY_RETRY_TIME, String.valueOf(request.getRetryTime()));
                    if (request.getHeaders() != null) {
                        for (Header header : request.getHeaders()) {
                            hashMap.put(header.getName(), header.getValue());
                        }
                    }
                    this.f.onRequest("http", new IWeexAnalyzerInspector.a(TextUtils.isEmpty(this.d) ? "unknown" : this.d, "GET", hashMap));
                } catch (Exception e2) {
                    WXLogUtils.e("NetworkTracker", e2.getMessage());
                }
            }
        } catch (Throwable th) {
            t("Exception on preRequest()", th);
        }
    }
}
