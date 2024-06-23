package com.taobao.mtop.wvplugin;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class b {
    private WVCallBackContext a = null;
    private boolean b = false;
    private JSONObject c = new JSONObject();
    private String d = null;

    public b() {
    }

    public void a(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                this.c.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void b(String str, JSONArray jSONArray) {
        if (str != null && jSONArray != null) {
            try {
                this.c.put(str, jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public WVCallBackContext c() {
        return this.a;
    }

    public boolean d() {
        return this.b;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.c = jSONObject;
        }
    }

    public void f(WVCallBackContext wVCallBackContext) {
        this.a = wVCallBackContext;
    }

    public void g(boolean z) {
        this.b = z;
    }

    public String toString() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        return this.c.toString();
    }

    public b(WVCallBackContext wVCallBackContext) {
        this.a = wVCallBackContext;
    }
}
