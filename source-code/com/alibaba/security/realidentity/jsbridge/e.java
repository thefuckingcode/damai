package com.alibaba.security.realidentity.jsbridge;

import android.os.Message;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.common.c.a;
import com.alibaba.security.common.d.b;
import com.alibaba.security.common.d.h;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.bean.ClientInfo;
import org.json.JSONException;
import org.json.JSONObject;

@f(a = a.I)
/* compiled from: Taobao */
public class e extends a {
    private static final int as = 10;

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final String a() {
        return a.I;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, h hVar) {
        JSONObject jSONObject;
        a.b("AbsJavaScriptExecuter", "GetDeviceInfoApi input params: ".concat(String.valueOf(str)));
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            WVResult wVResult = new WVResult();
            wVResult.addData("errorMsg", "NO_INFO");
            hVar.a(wVResult);
            return false;
        }
        final String optString = jSONObject.optString(a.d, "");
        if (!TextUtils.isEmpty(optString)) {
            g.a.a.d = optString;
        }
        a.aq.execute(new Runnable() {
            /* class com.alibaba.security.realidentity.jsbridge.e.AnonymousClass1 */

            public final void run() {
                JSONObject jSONObject;
                String a2 = com.alibaba.security.common.d.a.a(ALBiometricsJni.genVersionTag(e.this.ao, optString));
                ClientInfo clientInfo = new ClientInfo();
                clientInfo.setClientType(a.ai);
                clientInfo.setVersionTag(a2);
                try {
                    jSONObject = new JSONObject(h.a(clientInfo));
                } catch (JSONException e) {
                    if (a.a()) {
                        a.c("AbsJavaScriptExecuter", "GetDeviceInfoApi json assemble error");
                    }
                    a.a("GetDeviceInfoApi json assemble error", b.a(e));
                    jSONObject = null;
                }
                Message obtain = Message.obtain();
                obtain.what = 10;
                obtain.obj = jSONObject;
                e.this.a(obtain);
            }
        });
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final void b(Message message) {
        super.b(message);
        if (message.what == 10) {
            JSONObject jSONObject = (JSONObject) message.obj;
            WVResult wVResult = new WVResult();
            if (jSONObject == null || TextUtils.isEmpty(jSONObject.toString())) {
                wVResult.addData("errorMsg", "NO_INFO");
                this.an.a(wVResult);
                return;
            }
            wVResult.setSuccess();
            wVResult.addData(a.f, jSONObject);
            this.an.b(wVResult);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean b() {
        return true;
    }

    private void a(JSONObject jSONObject) {
        WVResult wVResult = new WVResult();
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.toString())) {
            wVResult.addData("errorMsg", "NO_INFO");
            this.an.a(wVResult);
            return;
        }
        wVResult.setSuccess();
        wVResult.addData(a.f, jSONObject);
        this.an.b(wVResult);
    }
}
