package tb;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class nt2 {
    private static final AtomicInteger b = new AtomicInteger();
    private ScheduledThreadPoolExecutor a = null;

    /* compiled from: Taobao */
    static class a implements ThreadFactory {
        a() {
        }

        public Thread newThread(Runnable runnable) {
            int andIncrement = nt2.b.getAndIncrement();
            return new Thread(runnable, "UtHandlerThread:" + andIncrement);
        }
    }

    public nt2() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new a());
        this.a = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(3000, TimeUnit.MILLISECONDS);
        this.a.allowCoreThreadTimeOut(true);
    }

    public void b(Runnable runnable) {
        this.a.submit(runnable);
    }
}
