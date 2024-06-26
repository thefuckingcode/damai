package com.alibaba.ha.bizerrorreporter.send;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class BizErrorThreadPool {
    public static final AtomicInteger INTEGER = new AtomicInteger();
    public static int prop = 1;
    public static ScheduledExecutorService threadPoolExecutor;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class TbThreadFactory implements ThreadFactory {
        private int priority;

        public TbThreadFactory(int i) {
            this.priority = i;
        }

        public Thread newThread(Runnable runnable) {
            int andIncrement = BizErrorThreadPool.INTEGER.getAndIncrement();
            Thread thread = new Thread(runnable, "CrashReporterAdapter:" + andIncrement);
            thread.setPriority(this.priority);
            return thread;
        }
    }

    public synchronized void submit(Runnable runnable) {
        try {
            if (threadPoolExecutor == null) {
                threadPoolExecutor = Executors.newScheduledThreadPool(3, new TbThreadFactory(prop));
            }
            threadPoolExecutor.submit(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return;
    }
}
