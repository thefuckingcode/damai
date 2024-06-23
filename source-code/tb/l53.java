package tb;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
public class l53 {
    private static final ExecutorService a = Executors.newSingleThreadExecutor();
    private static Handler b = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        b.post(runnable);
    }
}
