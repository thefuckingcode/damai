package com.alipay.sdk.m.j0;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class b {
    public static final String a = "IdentifierManager";
    public static Object b;
    public static Class<?> c;
    public static Method d = c.getMethod("getUDID", Context.class);
    public static Method e = c.getMethod("getOAID", Context.class);
    public static Method f = c.getMethod("getVAID", Context.class);
    public static Method g = c.getMethod("getAAID", Context.class);

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            c = cls;
            b = cls.newInstance();
        } catch (Exception e2) {
            Log.e(a, "reflect exception!", e2);
        }
    }

    public static boolean a() {
        return (c == null || b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, e);
    }

    public static String c(Context context) {
        return a(context, d);
    }

    public static String d(Context context) {
        return a(context, f);
    }

    public static String a(Context context) {
        return a(context, g);
    }

    public static String a(Context context, Method method) {
        Object obj = b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            Log.e(a, "invoke exception!", e2);
            return null;
        }
    }
}
