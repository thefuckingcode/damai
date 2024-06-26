package android.taobao.windvane.utils;

import android.os.SystemClock;

/* compiled from: Taobao */
public class TimeUtils {
    public static long generateUptimeFromCurrentTime(long j) {
        if (j > 0) {
            return (SystemClock.uptimeMillis() - System.currentTimeMillis()) + j;
        }
        return 0;
    }
}
