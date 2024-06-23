package tb;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class uz1 {
    private static final ExecutorService[] a = new ExecutorService[2];
    private static AtomicInteger b = new AtomicInteger(0);

    /* compiled from: Taobao */
    static class a implements ThreadFactory {
        a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("RepeaterThread:%d", Integer.valueOf(uz1.b.getAndIncrement())));
        }
    }

    static {
        for (int i = 0; i < 2; i++) {
            a[i] = Executors.newSingleThreadExecutor(new a());
        }
    }

    public static void b(int i, Runnable runnable) {
        a[Math.abs(i % 2)].submit(runnable);
    }
}
