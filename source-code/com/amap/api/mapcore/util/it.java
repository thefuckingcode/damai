package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import io.flutter.wpkbridge.WPKFactory;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Random;

/* compiled from: Taobao */
public class it {
    static boolean a = false;
    static int b = 20;
    private static int c = 20;
    private static WeakReference<in> d;

    /* access modifiers changed from: private */
    public static void b(Context context, byte[] bArr) throws IOException {
        in a2 = iu.a(d);
        iu.a(context, a2, hb.h, 1000, 307200, "2");
        if (a2.e == null) {
            a2.e = new hs();
        }
        Random random = new Random();
        try {
            io.a(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, a2);
        } catch (Throwable th) {
            hd.c(th, WPKFactory.CONF_SERVER_TIME, "wts");
        }
    }

    public static synchronized void a(final is isVar, final Context context) {
        synchronized (it.class) {
            hd.d().submit(new Runnable() {
                /* class com.amap.api.mapcore.util.it.AnonymousClass1 */

                public void run() {
                    try {
                        synchronized (it.class) {
                            it.b(context, isVar.a());
                        }
                    } catch (Throwable th) {
                        hd.c(th, WPKFactory.CONF_SERVER_TIME, "as");
                    }
                }
            });
        }
    }

    public static void a(final Context context) {
        hd.d().submit(new Runnable() {
            /* class com.amap.api.mapcore.util.it.AnonymousClass2 */

            public void run() {
                try {
                    in a2 = iu.a(it.d);
                    iu.a(context, a2, hb.h, 1000, 307200, "2");
                    if (a2.g == null) {
                        a2.g = new iv(new iz(context, new iw(new ja(new jc()))));
                    }
                    a2.h = 3600000;
                    if (TextUtils.isEmpty(a2.i)) {
                        a2.i = "cKey";
                    }
                    if (a2.f == null) {
                        Context context = context;
                        a2.f = new jg(context, a2.h, a2.i, new jd(30, a2.a, new je(context, it.a, it.c * 1024, it.b * 1024, "staticUpdate")));
                    }
                    io.a(a2);
                } catch (Throwable th) {
                    hd.c(th, WPKFactory.CONF_SERVER_TIME, "usd");
                }
            }
        });
    }
}
