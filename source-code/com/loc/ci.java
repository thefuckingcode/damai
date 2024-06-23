package com.loc;

import android.text.TextUtils;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
public final class ci implements ThreadFactory {
    private static final int k;
    private static final int l;
    private static final int m;
    private final AtomicLong a;
    private final ThreadFactory b;
    private final Thread.UncaughtExceptionHandler c;
    private final String d;
    private final Integer e;
    private final Boolean f;
    private final int g;
    private final int h;
    private final BlockingQueue<Runnable> i;
    private final int j;

    /* compiled from: Taobao */
    public static class a {
        private ThreadFactory a;
        private Thread.UncaughtExceptionHandler b;
        private String c;
        private Integer d;
        private Boolean e;
        private int f = ci.l;
        private int g;
        private BlockingQueue<Runnable> h;

        public a() {
            int unused = ci.m;
            this.g = 30;
        }

        private void e() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }

        public final a a(String str) {
            this.c = str;
            return this;
        }

        public final ci b() {
            ci ciVar = new ci(this, (byte) 0);
            e();
            return ciVar;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        k = availableProcessors;
        l = Math.max(2, Math.min(availableProcessors - 1, 4));
        m = (availableProcessors * 2) + 1;
    }

    private ci(a aVar) {
        this.b = aVar.a == null ? Executors.defaultThreadFactory() : aVar.a;
        int i2 = aVar.f;
        this.g = i2;
        int i3 = m;
        this.h = i3;
        if (i3 >= i2) {
            this.j = aVar.g;
            this.i = aVar.h == null ? new LinkedBlockingQueue<>(256) : aVar.h;
            this.d = TextUtils.isEmpty(aVar.c) ? "amap-threadpool" : aVar.c;
            this.e = aVar.d;
            this.f = aVar.e;
            this.c = aVar.b;
            this.a = new AtomicLong();
            return;
        }
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    }

    /* synthetic */ ci(a aVar, byte b2) {
        this(aVar);
    }

    private ThreadFactory g() {
        return this.b;
    }

    private String h() {
        return this.d;
    }

    private Boolean i() {
        return this.f;
    }

    private Integer j() {
        return this.e;
    }

    private Thread.UncaughtExceptionHandler k() {
        return this.c;
    }

    public final int a() {
        return this.g;
    }

    public final int b() {
        return this.h;
    }

    public final BlockingQueue<Runnable> c() {
        return this.i;
    }

    public final int d() {
        return this.j;
    }

    public final Thread newThread(final Runnable runnable) {
        new Runnable() {
            /* class com.loc.ci.AnonymousClass1 */

            public final void run() {
                try {
                    runnable.run();
                } catch (Throwable unused) {
                }
            }
        };
        Thread newThread = g().newThread(runnable);
        if (h() != null) {
            Long valueOf = Long.valueOf(this.a.incrementAndGet());
            newThread.setName(String.format(h() + "-%d", valueOf));
        }
        if (k() != null) {
            newThread.setUncaughtExceptionHandler(k());
        }
        if (j() != null) {
            newThread.setPriority(j().intValue());
        }
        if (i() != null) {
            newThread.setDaemon(i().booleanValue());
        }
        return newThread;
    }
}
