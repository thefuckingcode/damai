package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.e;
import com.alipay.apmobilesecuritysdk.e.f;
import com.alipay.sdk.m.a0.b;
import com.alipay.sdk.m.z.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class c {
    public static Map<String, String> a(Context context) {
        b b = b.b();
        HashMap hashMap = new HashMap();
        f a = e.a(context);
        String a2 = b.a(context);
        String b2 = b.b(context);
        String m = b.m(context);
        if (a != null) {
            if (a.a(a2)) {
                a2 = a.a();
            }
            if (a.a(b2)) {
                b2 = a.b();
            }
            if (a.a(m)) {
                m = a.e();
            }
        }
        f fVar = new f(a2, b2, "", "", m);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", fVar.a());
                jSONObject.put("imsi", fVar.b());
                jSONObject.put("mac", fVar.c());
                jSONObject.put("bluetoothmac", fVar.d());
                jSONObject.put("gsi", fVar.e());
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", jSONObject2);
            } catch (Exception e) {
                com.alipay.apmobilesecuritysdk.c.a.a(e);
            }
        }
        hashMap.put("AD1", a2);
        hashMap.put("AD2", b2);
        hashMap.put("AD3", b.h(context));
        hashMap.put("AD5", b.j(context));
        hashMap.put("AD6", b.k(context));
        hashMap.put("AD7", b.l(context));
        hashMap.put("AD9", b.c(context));
        hashMap.put("AD10", m);
        hashMap.put("AD11", b.e());
        hashMap.put("AD12", b.a());
        hashMap.put("AD13", b.f());
        hashMap.put("AD14", b.h());
        hashMap.put("AD15", b.i());
        hashMap.put("AD16", b.j());
        hashMap.put("AD17", "");
        hashMap.put("AD19", b.n(context));
        hashMap.put("AD20", b.k());
        hashMap.put("AD22", "");
        hashMap.put("AD23", b.o(context));
        hashMap.put("AD24", a.g(b.i(context)));
        hashMap.put("AD26", b.g(context));
        hashMap.put("AD27", b.p());
        hashMap.put("AD28", b.r());
        hashMap.put("AD29", b.t());
        hashMap.put("AD30", b.q());
        hashMap.put("AD31", b.s());
        hashMap.put("AD32", b.n());
        hashMap.put("AD33", b.o());
        hashMap.put("AD34", b.p(context));
        hashMap.put("AD35", b.q(context));
        hashMap.put("AD36", b.d(context));
        hashMap.put("AD37", b.m());
        hashMap.put("AD38", b.l());
        hashMap.put("AD39", b.e(context));
        hashMap.put("AD40", b.f(context));
        hashMap.put("AD41", b.c());
        hashMap.put("AD42", b.d());
        return hashMap;
    }
}
