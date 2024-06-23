package com.alipay.sdk.m.u;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.h.c;
import com.alipay.sdk.m.h.f;
import com.alipay.sdk.m.k.a;
import com.alipay.sdk.m.s.b;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class a {
    public static final String a = "ap_req";
    public static final String b = "ap_args";
    public static final String c = "ap_resp";

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        return com.alipay.sdk.m.h.a.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0030, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x002b */
    public static com.alipay.sdk.m.g.a a() {
        return com.alipay.sdk.m.h.a.a("NP", System.currentTimeMillis(), new c(b.d().c()), (short) ((int) a.c.a(b.d().b())), new f());
    }

    public static HashMap<String, String> a(com.alipay.sdk.m.s.a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            com.alipay.sdk.m.g.a a2 = a();
            JSONObject jSONObject = new JSONObject();
            Context a3 = aVar != null ? aVar.a() : null;
            if (a3 == null) {
                a3 = b.d().b().getApplicationContext();
            }
            String a4 = n.a(aVar, a3);
            String b2 = com.alipay.sdk.m.w.b.b(aVar, a3);
            String str = "";
            jSONObject.put("ap_q", a2 != null ? a2.a() : str);
            jSONObject.put(com.alipay.sdk.m.s.a.z, aVar != null ? aVar.d : str);
            jSONObject.put("u_pd", String.valueOf(n.g()));
            jSONObject.put("u_lk", String.valueOf(n.e(n.b())));
            jSONObject.put("u_pi", String.valueOf(aVar != null ? aVar.g : JSMethod.NOT_SET));
            jSONObject.put("u_fu", a4);
            jSONObject.put("u_oi", b2);
            hashMap.put(a, jSONObject.toString());
            StringBuilder sb = new StringBuilder();
            if (a2 != null) {
                str = a2.a();
            }
            sb.append(str);
            sb.append("|");
            sb.append(a4);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ap_q", sb.toString());
        } catch (Exception e) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "APMEx1", e);
        }
        return hashMap;
    }

    public static JSONObject a(com.alipay.sdk.m.s.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(c);
        try {
            if (!TextUtils.isEmpty(optString)) {
                return new JSONObject(optString);
            }
            return null;
        } catch (JSONException e) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "APMEx2", e);
            return null;
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                jSONObject.putOpt(b, jSONObject2);
            } catch (JSONException e) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "APMEx2", e);
            }
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, HashMap<String, String> hashMap) {
        JSONObject a2 = com.alipay.sdk.m.m.a.D().a();
        if (hashMap != null && a2 != null) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ap_r", a2.optString("ap_r"));
            hashMap.putAll(n.a(a2));
        }
    }
}
