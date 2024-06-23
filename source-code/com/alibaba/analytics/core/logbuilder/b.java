package com.alibaba.analytics.core.logbuilder;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.sdk.m.c.a;
import tb.gl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class b {
    private static String a = "";
    private static boolean b = false;
    private static String c = "";
    private static boolean d;

    b() {
    }

    private static String a(Context context) {
        if (b || context == null) {
            return a;
        }
        try {
            a = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
        }
        b = true;
        return a;
    }

    private static String b() {
        return c(a.b, "");
    }

    private static String c(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable unused) {
            return str2;
        }
    }

    static String d(Context context) {
        if (d || context == null) {
            return c + "," + IRequestConst.OAID + "=" + Variables.n().t();
        }
        synchronized (b.class) {
            if (d) {
                return c;
            }
            if (e()) {
                String b2 = b();
                c = "aid=" + a(context) + "," + "hmos" + "=1" + "," + "hmv" + "=" + b2;
            } else {
                c = "aid=" + a(context) + "," + "hmos" + "=0";
            }
            d = true;
            return c + "," + IRequestConst.OAID + "=" + Variables.n().t();
        }
    }

    private static boolean e() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString());
        } catch (Throwable unused) {
            return false;
        }
    }
}
