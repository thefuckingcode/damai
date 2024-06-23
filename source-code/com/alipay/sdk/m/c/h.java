package com.alipay.sdk.m.c;

import android.content.Context;
import com.alipay.sdk.m.b.b;
import com.alipay.sdk.m.d.a;
import com.alipay.sdk.m.p0.e;

/* compiled from: Taobao */
public class h implements b {
    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean c = e.c(context);
        a.b("getOAID", "isSupported", Boolean.valueOf(c));
        if (!c) {
            return null;
        }
        return e.a(context);
    }
}
