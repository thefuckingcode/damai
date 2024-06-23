package tb;

import androidx.annotation.NonNull;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public final class u33 {
    private static ThreadPoolExecutor a = new ThreadPoolExecutor(2, 2, 10, TimeUnit.MINUTES, new LinkedBlockingQueue(Integer.MAX_VALUE), new ThreadPoolExecutor.DiscardOldestPolicy());

    public static Future<?> a(@NonNull Runnable runnable) {
        try {
            return a.submit(runnable);
        } catch (Throwable th) {
            t43.c("efs.util.concurrent", "submit task error!", th);
            return null;
        }
    }
}
