package com.uploader.implement.e;

import android.os.Build;
import android.os.Process;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class b {
    private static int a = 10;
    private static volatile ThreadPoolExecutor b;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a implements ThreadFactory {
        private int a = 10;
        private final AtomicInteger b = new AtomicInteger();

        public a(int i) {
            this.a = i;
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "aus work thread:" + this.b.getAndIncrement()) {
                /* class com.uploader.implement.e.b.a.AnonymousClass1 */

                public void run() {
                    Process.setThreadPriority(a.this.a);
                    super.run();
                }
            };
        }
    }

    public static Future<?> a(Runnable runnable) {
        try {
            return b().submit(runnable);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static ThreadPoolExecutor b() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = c(2, 4, 30, 128, new a(a));
                    if (Build.VERSION.SDK_INT > 8) {
                        b.allowCoreThreadTimeOut(true);
                    }
                }
            }
        }
        return b;
    }

    public static ThreadPoolExecutor c(int i, int i2, int i3, int i4, ThreadFactory threadFactory) {
        LinkedBlockingQueue linkedBlockingQueue;
        if (i4 > 0) {
            linkedBlockingQueue = new LinkedBlockingQueue(i4);
        } else {
            linkedBlockingQueue = new LinkedBlockingQueue();
        }
        return new ThreadPoolExecutor(i, i2, (long) i3, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
    }
}
