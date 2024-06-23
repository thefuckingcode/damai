package com.meizu.cloud.pushsdk.b.c;

import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
public final class d {
    private String a = null;
    private Boolean b = null;
    private Integer c = null;
    private Thread.UncaughtExceptionHandler d = null;
    private ThreadFactory e = null;

    private static ThreadFactory a(d dVar) {
        final String str = dVar.a;
        final Boolean bool = dVar.b;
        final Integer num = dVar.c;
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = dVar.d;
        final ThreadFactory threadFactory = dVar.e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        final AtomicLong atomicLong = str != null ? new AtomicLong(0) : null;
        return new ThreadFactory() {
            /* class com.meizu.cloud.pushsdk.b.c.d.AnonymousClass1 */

            public Thread newThread(Runnable runnable) {
                Thread newThread = threadFactory.newThread(runnable);
                String str = str;
                if (str != null) {
                    newThread.setName(String.format(str, Long.valueOf(atomicLong.getAndIncrement())));
                }
                Boolean bool = bool;
                if (bool != null) {
                    newThread.setDaemon(bool.booleanValue());
                }
                Integer num = num;
                if (num != null) {
                    newThread.setPriority(num.intValue());
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = uncaughtExceptionHandler;
                if (uncaughtExceptionHandler != null) {
                    newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
                return newThread;
            }
        };
    }

    public d a(Integer num) {
        this.c = num;
        return this;
    }

    public d a(String str) {
        String.format(str, 0);
        this.a = str;
        return this;
    }

    public ThreadFactory a() {
        return a(this);
    }
}
