package com.alipay.sdk.m.n0;

import android.content.Context;
import com.alipay.sdk.m.l0.f;
import com.ta.audid.Constants;

/* compiled from: Taobao */
public class a {
    public static String a(Context context) {
        b b = c.b(context);
        return (b == null || f.m180a(b.c())) ? Constants.UTDID_INVALID : b.c();
    }

    public static String b(Context context) {
        String a = d.a(context).a();
        return (a == null || f.m180a(a)) ? Constants.UTDID_INVALID : a;
    }

    @Deprecated
    public static String c(Context context) {
        return a(context);
    }

    @Deprecated
    public static String d(Context context) {
        return b(context);
    }
}
