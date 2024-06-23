package tb;

import android.os.Handler;
import android.os.Looper;

/* compiled from: Taobao */
public class ab1 {
    private static Handler a;

    public static void execute(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        if (a == null) {
            a = new Handler(Looper.getMainLooper());
        }
        a.post(runnable);
    }
}
