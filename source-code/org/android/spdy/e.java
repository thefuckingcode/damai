package org.android.spdy;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
class e {
    private static volatile ScheduledThreadPoolExecutor a;
    private static final AtomicInteger b = new AtomicInteger();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements ThreadFactory {
        private String a;

        a(String str) {
            this.a = str;
        }

        public Thread newThread(Runnable runnable) {
            int andIncrement = e.b.getAndIncrement();
            Thread thread = new Thread(runnable, this.a + andIncrement);
            thread.setPriority(5);
            return thread;
        }
    }

    e() {
    }

    static void b(Runnable runnable) {
        try {
            c().execute(runnable);
        } catch (Throwable th) {
            spduLog.Loge("tnet-jni", "ThreadPoolExecutorFactory execute", th);
        }
    }

    static ScheduledThreadPoolExecutor c() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new ScheduledThreadPoolExecutor(1, new a("TNET"));
                    a.setKeepAliveTime(60, TimeUnit.SECONDS);
                    a.allowCoreThreadTimeOut(true);
                }
            }
        }
        return a;
    }
}
