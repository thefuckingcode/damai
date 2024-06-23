package tb;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class gj2 {
    private static gj2 a;
    private static ScheduledExecutorService b;
    private static final AtomicInteger c = new AtomicInteger();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements ThreadFactory {
        a() {
        }

        public Thread newThread(Runnable runnable) {
            int andIncrement = gj2.c.getAndIncrement();
            return new Thread(runnable, "AppMonitor:" + andIncrement);
        }
    }

    private static synchronized ScheduledExecutorService b() {
        ScheduledExecutorService scheduledExecutorService;
        synchronized (gj2.class) {
            if (b == null) {
                b = Executors.newScheduledThreadPool(4, new a());
            }
            scheduledExecutorService = b;
        }
        return scheduledExecutorService;
    }

    public static synchronized gj2 c() {
        gj2 gj2;
        synchronized (gj2.class) {
            if (a == null) {
                a = new gj2();
            }
            gj2 = a;
        }
        return gj2;
    }

    public final ScheduledFuture d(ScheduledFuture scheduledFuture, Runnable runnable, long j) {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(true);
        }
        return b().schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public final ScheduledFuture e(ScheduledFuture scheduledFuture, Runnable runnable, long j) {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }
        return b().scheduleAtFixedRate(runnable, 1000, j, TimeUnit.MILLISECONDS);
    }

    public void f(Runnable runnable) {
        try {
            b().submit(runnable);
        } catch (Throwable unused) {
        }
    }
}
