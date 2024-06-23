package com.alibaba.motu.tbrest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class SendAsyncExecutor {
    public static final AtomicInteger INTEGER = new AtomicInteger();
    public static int prop = 1;
    public static ScheduledExecutorService threadPoolExecutor;
    public Integer corePoolSize = 2;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class SendThreadFactory implements ThreadFactory {
        private int priority;

        public SendThreadFactory(int i) {
            this.priority = i;
        }

        public Thread newThread(Runnable runnable) {
            int andIncrement = SendAsyncExecutor.INTEGER.getAndIncrement();
            Thread thread = new Thread(runnable, "RestSend:" + andIncrement);
            thread.setPriority(this.priority);
            return thread;
        }
    }

    public synchronized void start(Runnable runnable) {
        try {
            if (threadPoolExecutor == null) {
                threadPoolExecutor = Executors.newScheduledThreadPool(this.corePoolSize.intValue(), new SendThreadFactory(prop));
            }
            threadPoolExecutor.submit(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return;
    }
}
