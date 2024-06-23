package com.alipay.sdk.m.w;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class a {
    public static final String a = "CDT";
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static ConcurrentHashMap<Integer, Pair<Long, ?>> g;
    public static ExecutorService h = Executors.newFixedThreadPool(16);

    /* renamed from: com.alipay.sdk.m.w.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public interface AbstractC0136a<T, R> {
        R a(T t);
    }

    public static synchronized void a(int i, Object obj) {
        synchronized (a.class) {
            if (g == null) {
                g = new ConcurrentHashMap<>();
            }
            g.put(Integer.valueOf(i), new Pair<>(Long.valueOf(SystemClock.elapsedRealtime()), obj));
        }
    }

    public static Pair<Boolean, ?> a(int i, TimeUnit timeUnit, long j) {
        ConcurrentHashMap<Integer, Pair<Long, ?>> concurrentHashMap = g;
        if (concurrentHashMap == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Pair<Long, ?> pair = concurrentHashMap.get(Integer.valueOf(i));
        if (pair == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Long l = (Long) pair.first;
        Object obj = pair.second;
        if (l == null || SystemClock.elapsedRealtime() - l.longValue() > TimeUnit.MILLISECONDS.convert(j, timeUnit)) {
            return new Pair<>(Boolean.FALSE, null);
        }
        return new Pair<>(Boolean.TRUE, obj);
    }

    public static synchronized void a() {
        synchronized (a.class) {
            g = null;
        }
    }

    public static Context a(Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext();
    }

    public static <T> T a(int i, long j, TimeUnit timeUnit, AbstractC0136a<Object, Boolean> aVar, Callable<T> callable, boolean z, long j2, TimeUnit timeUnit2, com.alipay.sdk.m.s.a aVar2, boolean z2) {
        T t;
        try {
            Pair<Boolean, ?> a2 = a(i, timeUnit, j);
            if (!((Boolean) a2.first).booleanValue() || !aVar.a(a2.second).booleanValue()) {
                if (!z2 || !n.h()) {
                    if (z) {
                        t = h.submit(callable).get(j2, timeUnit2);
                    } else {
                        t = callable.call();
                    }
                    a(i, t);
                } else {
                    com.alipay.sdk.m.k.a.b(aVar2, b.l, "ch_get_main", "" + i);
                    e.d("getC", i + " skip");
                    t = null;
                }
                e.d("getC", i + " new " + ((Object) t));
                return t;
            }
            e.d("getC", i + " got " + a2.second);
            return (T) a2.second;
        } catch (Throwable th) {
            e.a(a, "ch_get_e|" + i, th);
            com.alipay.sdk.m.k.a.a(aVar2, b.l, "ch_get_e|" + i, th);
            e.d("getC", i + " err");
            return null;
        }
    }
}
