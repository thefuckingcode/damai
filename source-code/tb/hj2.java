package tb;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class hj2 {
    private static Executor a = new b(1, "slide-pool-");
    private static Executor b = new b(3, "slide-pool-d-");

    /* compiled from: Taobao */
    private static class a implements ThreadFactory {
        private static final AtomicInteger e = new AtomicInteger(1);
        private final ThreadGroup a;
        private final AtomicInteger b = new AtomicInteger(1);
        private final String c;
        private final int d;

        a(int i, String str) {
            this.d = i;
            this.a = Thread.currentThread().getThreadGroup();
            this.c = str + e.getAndIncrement() + "-thread-";
        }

        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.a;
            Thread thread = new Thread(threadGroup, runnable, this.c + this.b.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.d);
            return thread;
        }
    }

    /* compiled from: Taobao */
    static class b extends ThreadPoolExecutor {
        b(int i, String str) {
            super(i, i, 20, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(5, str));
            allowCoreThreadTimeOut(true);
        }
    }

    public static void a(Runnable runnable) {
        try {
            b.execute(runnable);
        } catch (Throwable th) {
            o22.d("TaskExecutor", "dispatch", th, new Object[0]);
        }
    }

    public static void b(Runnable runnable) {
        try {
            a.execute(runnable);
        } catch (Throwable th) {
            o22.d("TaskExecutor", "submit", th, new Object[0]);
        }
    }
}
