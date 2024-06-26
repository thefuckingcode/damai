package com.alibaba.aliweex.adapter.module.mtop;

import com.taobao.weex.bridge.JSCallback;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a {
    private boolean a = false;
    private JSONObject b = new JSONObject();
    private String c = null;
    private JSCallback d;
    private JSCallback e;
    public String f;
    private String g;

    public a(JSCallback jSCallback, JSCallback jSCallback2) {
        this.d = jSCallback;
        this.e = jSCallback2;
    }

    public void a(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                this.b.put(str, str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b(String str, JSONArray jSONArray) {
        if (str != null && jSONArray != null) {
            try {
                this.b.put(str, jSONArray);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public JSCallback c() {
        return this.d;
    }

    public JSCallback d() {
        return this.e;
    }

    public JSONObject e() {
        return this.b;
    }

    public String f() {
        return this.g;
    }

    public boolean g() {
        return this.a;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.b = jSONObject;
        }
    }

    public void i(String str) {
        this.g = str;
    }

    public void j(boolean z) {
        this.a = z;
    }

    public String toString() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        return this.b.toString();
    }
}
