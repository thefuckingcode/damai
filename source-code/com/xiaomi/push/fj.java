package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ff;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.util.Hashtable;

/* compiled from: Taobao */
public class fj {
    private static final int a = ez.PING_RTT.a();

    /* renamed from: a  reason: collision with other field name */
    private static long f360a = 0;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a() {
        if (f360a == 0 || SystemClock.elapsedRealtime() - f360a > 7200000) {
            f360a = SystemClock.elapsedRealtime();
            a(0, a);
        }
    }

    public static void a(int i) {
        fa a2 = fh.m474a().m476a();
        a2.a(ez.CHANNEL_STATS_COUNTER.a());
        a2.c(i);
        fh.m474a().a(a2);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (fj.class) {
            if (i2 < 16777215) {
                a.a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        fa a2 = fh.m474a().m476a();
        a2.a((byte) i);
        a2.a(i2);
        a2.b(i3);
        a2.b(str);
        a2.c(i4);
        fh.m474a().a(a2);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (fj.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                fa a2 = fh.m474a().m476a();
                a2.a(i2);
                a2.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                a2.b(str);
                if (i3 > -1) {
                    a2.c(i3);
                }
                fh.m474a().a(a2);
                a.a.remove(Integer.valueOf(i2));
            } else {
                b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, bg.b bVar) {
        new fc(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        fa a2 = fh.m474a().m476a();
        if (!(fh.a() == null || fh.a().f352a == null)) {
            a2.c(bj.c(fh.a().f352a) ? 1 : 0);
        }
        if (i > 0) {
            a2.a(ez.GSLB_REQUEST_SUCCESS.a());
            a2.b(str);
            a2.b(i);
            fh.m474a().a(a2);
            return;
        }
        try {
            ff.a a3 = ff.a(exc);
            a2.a(a3.a.a());
            a2.c(a3.f349a);
            a2.b(str);
            fh.m474a().a(a2);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            ff.a b = ff.b(exc);
            fa a2 = fh.m474a().m476a();
            a2.a(b.a.a());
            a2.c(b.f349a);
            a2.b(str);
            if (!(fh.a() == null || fh.a().f352a == null)) {
                a2.c(bj.c(fh.a().f352a) ? 1 : 0);
            }
            fh.m474a().a(a2);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m480a() {
        fb a2 = fh.m474a().m477a();
        if (a2 != null) {
            return it.a(a2);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            ff.a d = ff.d(exc);
            fa a2 = fh.m474a().m476a();
            a2.a(d.a.a());
            a2.c(d.f349a);
            a2.b(str);
            if (!(fh.a() == null || fh.a().f352a == null)) {
                a2.c(bj.c(fh.a().f352a) ? 1 : 0);
            }
            fh.m474a().a(a2);
        } catch (NullPointerException unused) {
        }
    }
}
