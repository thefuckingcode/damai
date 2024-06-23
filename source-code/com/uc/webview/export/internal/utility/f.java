package com.uc.webview.export.internal.utility;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public final class f {
    private ScheduledThreadPoolExecutor a;

    /* compiled from: Taobao */
    static class a implements ThreadFactory {
        String a;
        int b = 1;

        a(String str) {
            this.a = str;
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.a);
            thread.setPriority(this.b);
            return thread;
        }
    }

    public f(String str) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new a(str));
        this.a = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(10000, TimeUnit.MILLISECONDS);
        this.a.allowCoreThreadTimeOut(true);
    }

    public final void a(Runnable runnable) {
        this.a.execute(runnable);
    }

    public final void a(Runnable runnable, long j) {
        this.a.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }
}
