package com.amap.api.mapcore.util;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class ip {
    static WeakReference<in> a;

    public static void a(final String str, final Context context) {
        hd.d().submit(new Runnable() {
            /* class com.amap.api.mapcore.util.ip.AnonymousClass1 */

            public void run() {
                synchronized (ip.class) {
                    try {
                        String a2 = gk.a(gn.a(str));
                        in a3 = iu.a(ip.a);
                        iu.a(context, a3, hb.j, 50, 102400, "10");
                        if (a3.e == null) {
                            a3.e = new hu(new hx(new hw()));
                        }
                        String a4 = gn.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss");
                        io.a(a2, gn.a(" \"timestamp\":\"" + a4 + "\",\"details\":" + str), a3);
                    } catch (Throwable th) {
                        hd.c(th, "mam", "ap");
                    }
                }
            }
        });
    }
}
