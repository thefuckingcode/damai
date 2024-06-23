package tb;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class kz0 {
    private static volatile kz0 d;
    private final ExecutorService a = Executors.newSingleThreadExecutor();
    private final Handler b = new Handler(Looper.getMainLooper());
    private final ThreadPoolExecutor c;

    /* compiled from: Taobao */
    private static class b implements ThreadFactory {
        private final AtomicInteger a;

        private b() {
            this.a = new AtomicInteger();
        }

        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "ARanger  Thread:" + this.a.getAndIncrement());
        }
    }

    private kz0() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b());
        this.c = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private static kz0 a() {
        if (d == null) {
            synchronized (kz0.class) {
                if (d == null) {
                    d = new kz0();
                }
            }
        }
        return d;
    }

    public static void b(boolean z, boolean z2, Runnable runnable) {
        if (z) {
            a().b.post(runnable);
        } else if (z2) {
            a().a.execute(runnable);
        } else {
            a().c.execute(runnable);
        }
    }
}
