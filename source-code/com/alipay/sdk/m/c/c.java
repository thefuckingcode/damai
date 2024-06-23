package com.alipay.sdk.m.c;

import android.content.Context;
import com.alipay.sdk.m.b.b;
import com.alipay.sdk.m.d.a;

/* compiled from: Taobao */
public class c implements b {
    public static final int d = 1;
    public com.alipay.sdk.m.r0.b a;
    public boolean b = false;
    public boolean c = false;

    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.b) {
            com.alipay.sdk.m.r0.b bVar = new com.alipay.sdk.m.r0.b();
            this.a = bVar;
            this.c = bVar.a(context, null) == 1;
            this.b = true;
        }
        a.b("getOAID", "isSupported", Boolean.valueOf(this.c));
        if (!this.c || !this.a.e()) {
            return null;
        }
        return this.a.b();
    }
}
