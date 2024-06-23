package com.youku.network;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class e {
    private static int a = 5;
    private static volatile ThreadPoolExecutor b;
    private static volatile ThreadPoolExecutor c;
    private static ScheduledExecutorService d = new ScheduledThreadPoolExecutor(1, new a(a));

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a implements ThreadFactory {
        private int a;
        private final AtomicInteger b = new AtomicInteger();

        public a(int i) {
            this.a = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "NetWork Pool" + "Thread:" + this.b.getAndIncrement());
            thread.setPriority(this.a);
            return thread;
        }
    }

    public static ThreadPoolExecutor a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = a(5, 30, 60, 0, new a(a));
                }
            }
        }
        return b;
    }

    public static ThreadPoolExecutor a(int i, int i2, int i3, int i4, ThreadFactory threadFactory) {
        LinkedBlockingQueue linkedBlockingQueue;
        if (i4 <= 0) {
            linkedBlockingQueue = new LinkedBlockingQueue();
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, (long) i3, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        if (i3 > 0) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return threadPoolExecutor;
    }

    public static ThreadPoolExecutor b() {
        if (c == null) {
            synchronized (e.class) {
                if (c == null) {
                    c = a(5, 5, 60, 0, new a(a));
                }
            }
        }
        return c;
    }

    public static ScheduledExecutorService c() {
        return d;
    }
}
