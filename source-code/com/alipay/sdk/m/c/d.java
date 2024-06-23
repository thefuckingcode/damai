package com.alipay.sdk.m.c;

import android.content.Context;
import com.alipay.sdk.m.b.b;
import com.alipay.sdk.m.d.a;

/* compiled from: Taobao */
public class d implements b {
    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a = com.alipay.sdk.m.i0.b.a();
        a.b("getOAID", "isSupported", Boolean.valueOf(a));
        if (!a) {
            return null;
        }
        return com.alipay.sdk.m.i0.b.b(context);
    }
}
