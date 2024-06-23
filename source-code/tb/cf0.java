package tb;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;

public final class cf0 {
    private static final jh2 a = new jh2("REMOVED_TASK");
    private static final jh2 b = new jh2("CLOSED_EMPTY");

    public static final long c(long j) {
        return j / 1000000;
    }

    public static final long d(long j) {
        if (j <= 0) {
            return 0;
        }
        return j >= 9223372036854L ? AbsPerformance.LONG_NIL : 1000000 * j;
    }
}
