package com.taobao.slide.request;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.taobao.slide.api.SlideConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.as1;
import tb.gv0;
import tb.if1;
import tb.o22;
import tb.uk;

/* compiled from: Taobao */
public abstract class a<T> extends b<T> {
    private SlideConfig e;
    private String f;
    private long g = ((System.currentTimeMillis() / 1000) + this.h);
    private long h;

    protected a(Context context, SlideConfig slideConfig, String str, String str2, String str3) {
        super(context, str2, str3);
        this.e = slideConfig;
        this.f = str;
    }

    private void f(IConnection iConnection) throws Throwable {
        o22.g("BaseRequest", "AuthRequest", "URL", this.b);
        iConnection.setParams(b());
        iConnection.openConnection(this.b);
        iConnection.addHeader("S-APP-KEY", uk.e(this.e.getAppKey()));
        iConnection.addHeader("S-APP-VERSION", uk.e(this.e.getAppVersion()));
        iConnection.addHeader("S-DEVICE-ID", uk.e(this.f));
        iConnection.addHeader("S-TIMESTAMP", uk.e(String.valueOf(this.g)));
        iConnection.addHeader("S-SDK-VERSION", uk.e("1.0.0"));
        String c = c();
        iConnection.addHeader("S-SIGN", uk.e(g(c)));
        iConnection.addHeader("S-SIGN-VERSION", uk.e("1.0"));
        if (b.d) {
            iConnection.addHeader(HttpHeaderConstant.F_REFER, if1.MODULE_NAME);
        }
        if (!TextUtils.isEmpty(c)) {
            iConnection.setMethod("POST");
            iConnection.setBody(c.getBytes());
        } else {
            iConnection.setMethod("GET");
        }
        iConnection.connect();
    }

    private String g(String str) throws Throwable {
        StringBuilder sb = new StringBuilder(this.b);
        sb.append("&");
        sb.append(this.e.getAppKey());
        sb.append("&");
        sb.append(this.e.getAppVersion());
        sb.append("&");
        sb.append(this.f);
        sb.append("&");
        sb.append(this.g);
        sb.append("&");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        if (!TextUtils.isEmpty(this.e.getAppSecret())) {
            return gv0.b(sb.toString(), this.e.getAppSecret());
        }
        SecurityGuardManager instance = SecurityGuardManager.getInstance(this.a);
        as1.e(instance, "SecurityGuardManager is null");
        ISecureSignatureComponent secureSignatureComp = instance.getSecureSignatureComp();
        HashMap hashMap = new HashMap();
        hashMap.put("INPUT", sb.toString());
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = this.e.getAppKey();
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 3;
        return secureSignatureComp.signRequest(securityGuardParamContext, this.e.getAuthCode());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e5, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e8, code lost:
        throw r0;
     */
    @Override // com.taobao.slide.request.b
    public String a() throws Throwable {
        IConnection iConnection;
        if (b.d) {
            iConnection = new e(this.a);
        } else {
            iConnection = new d();
        }
        f(iConnection);
        int responseCode = iConnection.getResponseCode();
        if (responseCode < 200 || responseCode > 299) {
            throw new RuntimeException("get response code:" + responseCode);
        }
        Map<String, List<String>> headFields = iConnection.getHeadFields();
        if (headFields != null && !headFields.isEmpty()) {
            List<String> list = headFields.get("S-CODE");
            if (list == null || list.isEmpty()) {
                o22.k("BaseRequest", "get response lack o-code", new Object[0]);
                String response = iConnection.getResponse();
                iConnection.disconnect();
                return response;
            }
            String d = uk.d(list.get(0));
            if ("10008".equals(d)) {
                o22.k("BaseRequest", "get expired, correct timestamp", new Object[0]);
                List<String> list2 = headFields.get("S-SERVER-TIMESTAMP");
                if (list2 == null || list2.isEmpty()) {
                    o22.k("BaseRequest", "get expired, lack o-server-timestamp", new Object[0]);
                } else {
                    long j = uk.j(uk.d(headFields.get("S-SERVER-TIMESTAMP").get(0)));
                    if (j != 0) {
                        long j2 = this.g;
                        if (j2 != 0) {
                            this.h = j - j2;
                        }
                    }
                }
            }
            if (!"10000".equals(d)) {
                throw new IllegalArgumentException("get illegal ocode:" + d);
            }
        }
        String response2 = iConnection.getResponse();
        iConnection.disconnect();
        return response2;
    }
}
