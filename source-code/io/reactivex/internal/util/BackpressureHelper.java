package io.reactivex.internal.util;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.concurrent.atomic.AtomicLong;
import tb.k22;

/* compiled from: Taobao */
public final class BackpressureHelper {
    private BackpressureHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static long add(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == AbsPerformance.LONG_NIL) {
                return AbsPerformance.LONG_NIL;
            }
        } while (!atomicLong.compareAndSet(j2, addCap(j2, j)));
        return j2;
    }

    public static long addCancel(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j2 == AbsPerformance.LONG_NIL) {
                return AbsPerformance.LONG_NIL;
            }
        } while (!atomicLong.compareAndSet(j2, addCap(j2, j)));
        return j2;
    }

    public static long addCap(long j, long j2) {
        long j3 = j + j2;
        return j3 < 0 ? AbsPerformance.LONG_NIL : j3;
    }

    public static long multiplyCap(long j, long j2) {
        long j3 = j * j2;
        return (((j | j2) >>> 31) == 0 || j3 / j == j2) ? j3 : AbsPerformance.LONG_NIL;
    }

    public static long produced(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == AbsPerformance.LONG_NIL) {
                return AbsPerformance.LONG_NIL;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                k22.u(new IllegalStateException("More produced than requested: " + j3));
                j3 = 0;
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }

    public static long producedCancel(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j2 == AbsPerformance.LONG_NIL) {
                return AbsPerformance.LONG_NIL;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                k22.u(new IllegalStateException("More produced than requested: " + j3));
                j3 = 0;
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }
}
