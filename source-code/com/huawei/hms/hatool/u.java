package com.huawei.hms.hatool;

import android.taobao.windvane.connect.HttpRequest;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class u {
    public String a;
    public String b;
    public String c;
    public List<q> d;
    public String e;

    public u(String str, String str2, String str3, List<q> list, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = str4;
    }

    public final String a(String str, String str2) {
        String str3;
        String f = c.f(str, str2);
        if (TextUtils.isEmpty(f)) {
            y.a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else if (!"diffprivacy".equals(str2)) {
            return "";
        } else {
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", f);
    }

    public void a() {
        o0 o0Var;
        n0 n0Var;
        String str;
        String a2 = a(this.a, this.b);
        if (!TextUtils.isEmpty(a2) || "preins".equals(this.b)) {
            if (!"_hms_config_tag".equals(this.a) && !"_openness_config_tag".equals(this.a)) {
                b();
            }
            C0314r d2 = d();
            if (d2 != null) {
                byte[] a3 = a(d2);
                if (a3.length == 0) {
                    str = "request body is empty";
                } else {
                    n0Var = new i0(a3, a2, this.a, this.b, this.e, this.d);
                    o0Var = o0.b();
                }
            } else {
                n0Var = new l0(this.d, this.a, this.e, this.b);
                o0Var = o0.c();
            }
            o0Var.a(n0Var);
            return;
        }
        str = "collectUrl is empty";
        y.e("hmsSdk", str);
    }

    public final byte[] a(C0314r rVar) {
        String str;
        try {
            JSONObject a2 = rVar.a();
            if (a2 != null) {
                return t0.a(a2.toString().getBytes("UTF-8"));
            }
            y.e("hmsSdk", "uploadEvents is null");
            return new byte[0];
        } catch (JSONException unused) {
            str = "uploadEvents to json error";
            y.e("hmsSdk", str);
            return new byte[0];
        } catch (UnsupportedEncodingException unused2) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            y.e("hmsSdk", str);
            return new byte[0];
        }
    }

    public final void b() {
        if (q0.a(b.i(), "backup_event", (int) HttpRequest.DEFAULT_MAX_LENGTH)) {
            y.d("hmsSdk", "backup file reach max limited size, discard new event ");
            return;
        }
        JSONArray c2 = c();
        String a2 = u0.a(this.a, this.b, this.e);
        y.c("hmsSdk", "Update data cached into backup,spKey: " + a2);
        g0.b(b.i(), "backup_event", a2, c2.toString());
    }

    public final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (q qVar : this.d) {
            try {
                jSONArray.put(qVar.d());
            } catch (JSONException unused) {
                y.c("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    public final C0314r d() {
        return d1.a(this.d, this.a, this.b, this.e, this.c);
    }
}
