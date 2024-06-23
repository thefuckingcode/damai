package org.apache.commons.lang3;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.Random;

/* compiled from: Taobao */
public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }

    public static byte[] nextBytes(int i) {
        Validate.isTrue(i >= 0, "Count cannot be negative.", new Object[0]);
        byte[] bArr = new byte[i];
        RANDOM.nextBytes(bArr);
        return bArr;
    }

    public static double nextDouble(double d, double d2) {
        boolean z = true;
        Validate.isTrue(d2 >= d, "Start value must be smaller or equal to end value.", new Object[0]);
        if (d < 0.0d) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        if (d == d2) {
            return d;
        }
        return d + ((d2 - d) * RANDOM.nextDouble());
    }

    public static float nextFloat(float f, float f2) {
        boolean z = true;
        Validate.isTrue(f2 >= f, "Start value must be smaller or equal to end value.", new Object[0]);
        if (f < 0.0f) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        if (f == f2) {
            return f;
        }
        return f + ((f2 - f) * RANDOM.nextFloat());
    }

    public static int nextInt(int i, int i2) {
        boolean z = true;
        Validate.isTrue(i2 >= i, "Start value must be smaller or equal to end value.", new Object[0]);
        if (i < 0) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        if (i == i2) {
            return i;
        }
        return i + RANDOM.nextInt(i2 - i);
    }

    public static long nextLong(long j, long j2) {
        boolean z = true;
        Validate.isTrue(j2 >= j, "Start value must be smaller or equal to end value.", new Object[0]);
        if (j < 0) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        if (j == j2) {
            return j;
        }
        return (long) nextDouble((double) j, (double) j2);
    }

    public static double nextDouble() {
        return nextDouble(0.0d, Double.MAX_VALUE);
    }

    public static float nextFloat() {
        return nextFloat(0.0f, Float.MAX_VALUE);
    }

    public static int nextInt() {
        return nextInt(0, Integer.MAX_VALUE);
    }

    public static long nextLong() {
        return nextLong(0, AbsPerformance.LONG_NIL);
    }
}
