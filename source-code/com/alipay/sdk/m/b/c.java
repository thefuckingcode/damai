package com.alipay.sdk.m.b;

import android.content.Context;
import android.os.Looper;
import com.alipay.sdk.m.c.a;

/* compiled from: Taobao */
public class c {
    public static b a;
    public static boolean b;

    public static synchronized String a(Context context) {
        synchronized (c.class) {
            if (context == null) {
                throw new RuntimeException("Context is null");
            } else if (Looper.myLooper() != Looper.getMainLooper()) {
                b(context);
                b bVar = a;
                if (bVar != null) {
                    try {
                        return bVar.a(context);
                    } catch (Exception unused) {
                    }
                }
                return null;
            } else {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
        }
    }

    public static void b(Context context) {
        if (a == null && !b) {
            synchronized (c.class) {
                if (a == null && !b) {
                    a = a.a(context);
                    b = true;
                }
            }
        }
    }
}
