package tb;

import android.os.SystemClock;

/* compiled from: Taobao */
public class dm2 {
    public static long a() {
        return SystemClock.uptimeMillis();
    }

    public static long b(long j) {
        return j > 0 ? j - (System.currentTimeMillis() - SystemClock.uptimeMillis()) : j;
    }
}
