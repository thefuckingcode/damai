package tb;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class qk2 {
    private static ThreadPoolExecutor a;

    /* compiled from: Taobao */
    private static class a implements ThreadFactory {
        AtomicInteger a = new AtomicInteger(0);
        String b;

        a(String str) {
            this.b = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.b + this.a.incrementAndGet());
            thread.setPriority(5);
            return thread;
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("phenix-stat"));
        a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void a(Runnable runnable) {
        if (ge2.c()) {
            try {
                a.submit(runnable);
            } catch (Throwable unused) {
            }
        } else {
            runnable.run();
        }
    }
}
