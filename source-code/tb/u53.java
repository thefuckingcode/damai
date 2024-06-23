package tb;

import java.util.Calendar;
import java.util.Date;

/* compiled from: Taobao */
public final class u53 {
    private static long a(long j) {
        return j - d(j);
    }

    private static long b(long j, long j2) {
        long d = d(j2) + a(j);
        long abs = Math.abs(d - j2);
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(d));
        int i = instance.get(11);
        if (i == 23 && abs >= 82800000) {
            d -= 86400000;
        }
        return (i != 0 || abs < 82800000) ? d : d + 86400000;
    }

    public static long c(long j, long j2, int i) {
        if (i <= 0) {
            return j;
        }
        try {
            return Math.abs(j - j2) > ((long) i) * 31536000000L ? b(j, j2) : j;
        } catch (Throwable unused) {
            return j;
        }
    }

    private static long d(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j));
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }
}
