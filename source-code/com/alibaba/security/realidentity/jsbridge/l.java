package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.common.c.a;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.RPVerify;
import org.json.JSONException;
import org.json.JSONObject;

@f(a = "startVerifyByNative")
/* compiled from: Taobao */
public class l extends a {
    private static final String as = "NativeVerifyJSApi";

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final String a() {
        return "startVerifyByNative";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, final h hVar) {
        a.a(as, "NativeVerifyApi execute params: ".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(a.d);
            jSONObject.optString(a.E, "");
            RPVerify.startByNative(this.ao, string, new RPEventListener() {
                /* class com.alibaba.security.realidentity.jsbridge.l.AnonymousClass1 */

                @Override // com.alibaba.security.realidentity.RPEventListener
                public final void onFinish(RPResult rPResult, String str, String str2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(a.F, rPResult.code);
                    } catch (JSONException unused) {
                        a.b();
                    }
                    WVResult wVResult = new WVResult();
                    wVResult.setData(jSONObject);
                    hVar.b(wVResult);
                    l.this.a(wVResult, true);
                }
            });
            return true;
        } catch (JSONException e) {
            a.c(as, "NativeVerifyApi parse params error");
            a.a("NativeVerifyApi parse params error", e);
            a.a(hVar);
            return false;
        }
    }
}
