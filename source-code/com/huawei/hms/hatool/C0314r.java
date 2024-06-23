package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.r  reason: case insensitive filesystem */
/* compiled from: Taobao */
public class C0314r implements s {
    public List<q> a;
    public o b;
    public p c;
    public s d;
    public String e = "";
    public String f;

    public C0314r(String str) {
        this.f = str;
    }

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() {
        String str;
        List<q> list = this.a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.b == null || this.c == null || this.d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.b.a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a2 = this.d.a();
            a2.put("properties", this.c.a());
            try {
                a2.put("events_global_properties", new JSONObject(this.e));
            } catch (JSONException unused) {
                a2.put("events_global_properties", this.e);
            }
            jSONObject2.put("events_common", a2);
            JSONArray jSONArray = new JSONArray();
            for (q qVar : this.a) {
                JSONObject a3 = qVar.a();
                if (a3 != null) {
                    jSONArray.put(a3);
                } else {
                    y.e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put("events", jSONArray);
            try {
                String a4 = d.a(t0.a(jSONObject2.toString().getBytes("UTF-8")), this.f);
                if (TextUtils.isEmpty(a4)) {
                    y.e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", a4);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        y.e("hmsSdk", str);
        return null;
    }

    public void a(e1 e1Var) {
        this.d = e1Var;
    }

    public void a(o oVar) {
        this.b = oVar;
    }

    public void a(p pVar) {
        this.c = pVar;
    }

    public void a(String str) {
        if (str != null) {
            this.e = str;
        }
    }

    public void a(List<q> list) {
        this.a = list;
    }
}
