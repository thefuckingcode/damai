package com.ta.audid.utils;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a {
    private static final AtomicInteger b = new AtomicInteger();
    private ScheduledThreadPoolExecutor a = null;

    /* renamed from: com.ta.audid.utils.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    static class ThreadFactoryC0196a implements ThreadFactory {
        ThreadFactoryC0196a() {
        }

        public Thread newThread(Runnable runnable) {
            int andIncrement = a.b.getAndIncrement();
            return new Thread(runnable, "UtdidHandlerThread:" + andIncrement);
        }
    }

    public a() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC0196a());
        this.a = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(3000, TimeUnit.MILLISECONDS);
        this.a.allowCoreThreadTimeOut(true);
    }

    public ScheduledFuture b(Runnable runnable, long j) {
        return this.a.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }
}
