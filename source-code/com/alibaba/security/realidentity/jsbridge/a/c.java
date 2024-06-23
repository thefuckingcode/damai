package com.alibaba.security.realidentity.jsbridge.a;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.activity.RPWebViewActivity;
import com.alibaba.security.realidentity.jsbridge.a;
import com.alibaba.security.realidentity.jsbridge.f;
import com.alibaba.security.realidentity.jsbridge.h;
import org.json.JSONObject;

@f(a = "option")
/* compiled from: Taobao */
public class c extends a {
    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final String a() {
        return "option";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, h hVar) {
        g.a.a.l = System.currentTimeMillis();
        try {
            String optString = new JSONObject(str).optString(a.d);
            if (!TextUtils.isEmpty(optString)) {
                g.a.a.d = optString;
            }
        } catch (Exception e) {
            a.a("option api get token fail", e);
        }
        g.a.a.c();
        WVResult wVResult = new WVResult();
        String str2 = VersionKey.RP_SDK_VERSION;
        if (TextUtils.isEmpty(com.alibaba.security.realidentity.a.a.I) || TextUtils.isEmpty(str2)) {
            a(a.a(hVar, "NO_INFO"), false);
        } else {
            wVResult.addData(a.t, com.alibaba.security.realidentity.a.a.I);
            wVResult.addData(a.u, str2);
            wVResult.addData(a.v, com.alibaba.security.realidentity.a.a.J);
            wVResult.addData(a.w, VersionKey.FL_SDK_VERSION);
            Context context = this.ao;
            if (context == null || !(context instanceof RPWebViewActivity)) {
                wVResult.addData(a.x, "true");
            } else {
                wVResult.addData(a.x, "false");
            }
            wVResult.setSuccess();
            hVar.b(wVResult);
            a(wVResult, true);
        }
        return true;
    }
}
