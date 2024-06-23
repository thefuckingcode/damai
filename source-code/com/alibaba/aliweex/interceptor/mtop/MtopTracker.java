package com.alibaba.aliweex.interceptor.mtop;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.aliweex.interceptor.IWeexAnalyzerInspector;
import com.alibaba.aliweex.interceptor.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.tao.remotebusiness.RemoteBusiness;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import tb.gn2;
import tb.j11;
import tb.k11;
import tb.th1;
import tb.zz1;

/* compiled from: Taobao */
public class MtopTracker {
    private static boolean g = true;
    private th1 a;
    private IWeexAnalyzerInspector b;
    private final int c = gn2.a();
    @Nullable
    private String d;
    private String e;
    private zz1 f;

    private MtopTracker() {
        if (WXEnvironment.isApkDebugable()) {
            this.a = th1.d();
            this.b = a.a();
            WXLogUtils.d("MtopTracker", "Create new instance " + toString());
        }
    }

    private boolean i() {
        th1 th1;
        return g && WXEnvironment.isApkDebugable() && (th1 = this.a) != null && th1.g();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String j() {
        if (this.d == null) {
            this.d = String.valueOf(this.c);
        }
        return this.d;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String k(String str) {
        if (i()) {
            this.a.f(j(), "application/json", null, new ByteArrayInputStream(str.getBytes()), false);
            this.a.k(j());
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private MtopResponse l(MtopResponse mtopResponse, k11 k11) {
        if (!(!i() || mtopResponse == null || mtopResponse.getBytedata() == null)) {
            this.a.f(j(), k11.d(), k11.b(), new ByteArrayInputStream(mtopResponse.getBytedata()), false);
            this.a.k(j());
        }
        return mtopResponse;
    }

    public static MtopTracker m() {
        return new MtopTracker();
    }

    public void n(String str, final String str2) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (i()) {
            this.a.c(new Runnable() {
                /* class com.alibaba.aliweex.interceptor.mtop.MtopTracker.AnonymousClass3 */

                public void run() {
                    WXLogUtils.d("MtopTracker", "onFailed -> " + str2);
                    MtopTracker.this.a.e(MtopTracker.this.j(), str2);
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                this.b.onResponse("mtop", new IWeexAnalyzerInspector.b(str, str2, 200, null));
            } catch (Exception e2) {
                WXLogUtils.e("MtopTracker", e2.getMessage());
            }
        }
    }

    public void o(final String str) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (i()) {
            this.a.c(new Runnable() {
                /* class com.alibaba.aliweex.interceptor.mtop.MtopTracker.AnonymousClass5 */

                public void run() {
                    k11 k11 = new k11();
                    k11.h(MtopTracker.this.j());
                    JSONObject parseObject = JSON.parseObject(str);
                    k11.a("Content-Type", "application/json");
                    for (String str : parseObject.keySet()) {
                        if (!"data".equals(str)) {
                            k11.a(str, parseObject.getString(str));
                        }
                    }
                    k11.i(parseObject.getString("api"));
                    k11.m(parseObject.getIntValue("code"));
                    k11.l(parseObject.getString("ret"));
                    k11.k(!"0".equals(parseObject.getString("isFromCache")));
                    MtopTracker.this.a.i(k11);
                    MtopTracker.this.k(JSON.parseObject(str).getString("data"));
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                JSONObject parseObject = JSON.parseObject(str);
                this.b.onResponse("mtop", new IWeexAnalyzerInspector.b(parseObject.getString("api"), str, parseObject.getIntValue("code"), null));
            } catch (Exception e2) {
                WXLogUtils.e("MtopTracker", e2.getMessage());
            }
        }
    }

    public void p(final MtopResponse mtopResponse) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (i()) {
            this.a.c(new Runnable() {
                /* class com.alibaba.aliweex.interceptor.mtop.MtopTracker.AnonymousClass2 */

                public void run() {
                    WXLogUtils.d("MtopTracker", "onResponse -> " + mtopResponse.getApi());
                    if (MtopTracker.this.f.c()) {
                        MtopTracker.this.f.d();
                    }
                    k11 k11 = new k11();
                    k11.h(MtopTracker.this.j());
                    k11.i(MtopTracker.this.e);
                    k11.m(mtopResponse.getResponseCode());
                    k11.l(mtopResponse.getRetCode());
                    k11.k(mtopResponse.getSource() != MtopResponse.ResponseSource.NETWORK_REQUEST);
                    Map<String, List<String>> headerFields = mtopResponse.getHeaderFields();
                    if (headerFields != null) {
                        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                            if (entry.getValue() != null) {
                                for (String str : entry.getValue()) {
                                    k11.a(entry.getKey(), str);
                                }
                            } else {
                                k11.a(entry.getKey(), null);
                            }
                        }
                        if (k11.e("Content-Type") == null) {
                            k11.a("Content-Type", "application/json");
                        }
                        MtopTracker.this.a.i(k11);
                        MtopTracker.this.l(mtopResponse, k11);
                    }
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                this.b.onResponse("mtop", new IWeexAnalyzerInspector.b(mtopResponse.getApi(), new String(mtopResponse.getBytedata()), mtopResponse.getResponseCode(), mtopResponse.getHeaderFields()));
            } catch (Exception e2) {
                WXLogUtils.e("MtopTracker", e2.getMessage());
            }
        }
    }

    public void q(final JSONObject jSONObject) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (i()) {
            this.a.c(new Runnable() {
                /* class com.alibaba.aliweex.interceptor.mtop.MtopTracker.AnonymousClass4 */

                /* renamed from: com.alibaba.aliweex.interceptor.mtop.MtopTracker$4$a */
                /* compiled from: Taobao */
                class a extends j11 {
                    a(AnonymousClass4 r1) {
                    }

                    @Override // tb.i11
                    public String d() {
                        String e = e("Content-Type");
                        return e == null ? "application/json" : e;
                    }
                }

                public void run() {
                    a aVar = new a(this);
                    aVar.h(MtopTracker.this.j());
                    for (String str : jSONObject.keySet()) {
                        Object obj = jSONObject.get(str);
                        if (!"param".equals(str)) {
                            aVar.a(str, String.valueOf(obj));
                        } else {
                            Object obj2 = jSONObject.get("param");
                            if (obj2 != null && (obj2 instanceof JSONObject)) {
                                JSONObject jSONObject = (JSONObject) obj2;
                                for (String str2 : jSONObject.keySet()) {
                                    aVar.a(str2, String.valueOf(jSONObject.get(str2)));
                                }
                            }
                        }
                    }
                    aVar.a("Content-Type", "application/json");
                    aVar.i(jSONObject.getString("api"));
                    aVar.l("WindVane");
                    aVar.m(TextUtils.isEmpty(jSONObject.getString("type")) ? "GET" : jSONObject.getString("type").toUpperCase());
                    MtopTracker.this.a.h(aVar);
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                String upperCase = TextUtils.isEmpty(jSONObject.getString("type")) ? "GET" : jSONObject.getString("type").toUpperCase();
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                String string = jSONObject.getString("api");
                IWeexAnalyzerInspector iWeexAnalyzerInspector2 = this.b;
                if (jSONObject2 == null || jSONObject2.isEmpty()) {
                    jSONObject2 = null;
                }
                iWeexAnalyzerInspector2.onRequest("mtop", new IWeexAnalyzerInspector.a(string, upperCase, jSONObject2));
            } catch (Exception e2) {
                WXLogUtils.e("MtopTracker", e2.getMessage());
            }
        }
    }

    public void r(@NonNull final RemoteBusiness remoteBusiness) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (i()) {
            this.a.c(new Runnable() {
                /* class com.alibaba.aliweex.interceptor.mtop.MtopTracker.AnonymousClass1 */

                public void run() {
                    WXLogUtils.d("MtopTracker", "preRequest -> " + remoteBusiness.request.getApiName());
                    MtopTracker mtopTracker = MtopTracker.this;
                    mtopTracker.f = new zz1(mtopTracker.a, MtopTracker.this.j());
                    j11 j11 = new j11();
                    MtopRequest mtopRequest = remoteBusiness.request;
                    j11.a("api-name", mtopRequest.getApiName());
                    j11.a("api-version", mtopRequest.getVersion());
                    j11.a("api-key", mtopRequest.getKey());
                    j11.a("need-ecode", mtopRequest.isNeedEcode() + "");
                    j11.a("need-session", mtopRequest.isNeedSession() + "");
                    j11.a("legal-request", mtopRequest.isLegalRequest() + "");
                    for (Map.Entry<String, String> entry : mtopRequest.dataParams.entrySet()) {
                        j11.a(entry.getKey(), entry.getValue());
                    }
                    for (Map.Entry<String, String> entry2 : remoteBusiness.mtopProp.getRequestHeaders().entrySet()) {
                        j11.a(entry2.getKey(), entry2.getValue());
                    }
                    if (j11.e("Content-Type") == null) {
                        j11.a("Content-Type", "application/json");
                    }
                    j11.h(MtopTracker.this.j());
                    j11.l("MTOP");
                    j11.i(remoteBusiness.request.getApiName() + ":" + remoteBusiness.request.getVersion());
                    byte[] bytes = remoteBusiness.request.getData().getBytes();
                    if (bytes != null) {
                        try {
                            OutputStream a = MtopTracker.this.f.a(j11.b());
                            a.write(bytes);
                            a.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        j11.k(MtopTracker.this.f.b());
                    }
                    j11.m(remoteBusiness.mtopProp.getMethod().getMethod());
                    MtopTracker.this.a.h(j11);
                    MtopTracker.this.e = (String) j11.f().get("url");
                    MtopTracker.this.a.b(MtopTracker.this.j(), j11.c(), 0);
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                this.b.onRequest("mtop", new IWeexAnalyzerInspector.a(remoteBusiness.request.getApiName(), remoteBusiness.mtopProp.getMethod().getMethod(), remoteBusiness.mtopProp.getRequestHeaders()));
            } catch (Exception e2) {
                WXLogUtils.e("MtopTracker", e2.getMessage());
            }
        }
    }
}
