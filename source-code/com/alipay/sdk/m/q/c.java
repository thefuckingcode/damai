package com.alipay.sdk.m.q;

import com.alipay.sdk.m.p.e;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class c extends e {
    @Override // com.alipay.sdk.m.p.e
    public JSONObject a() throws JSONException {
        return e.a("cashier", "gentid");
    }

    @Override // com.alipay.sdk.m.p.e
    public String b() {
        return "5.0.0";
    }

    @Override // com.alipay.sdk.m.p.e
    public boolean c() {
        return true;
    }
}
