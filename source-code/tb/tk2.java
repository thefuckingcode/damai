package tb;

import android.os.Handler;
import android.os.Looper;

/* compiled from: Taobao */
public class tk2 {
    private static Handler a;

    private static void a() {
        if (a == null) {
            a = new Handler(Looper.getMainLooper());
        }
    }

    public static boolean b() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void c(Runnable runnable) {
        a();
        a.post(runnable);
    }
}
