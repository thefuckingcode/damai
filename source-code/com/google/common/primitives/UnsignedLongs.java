package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Comparator;
import tb.ds1;

@Beta
@GwtCompatible
/* compiled from: Taobao */
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    /* compiled from: Taobao */
    enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i = 0; i < min; i++) {
                if (jArr[i] != jArr2[i]) {
                    return UnsignedLongs.a(jArr[i], jArr2[i]);
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    /* compiled from: Taobao */
    private static final class a {
        static final long[] a = new long[37];
        static final int[] b = new int[37];
        static final int[] c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i = 2; i <= 36; i++) {
                long j = (long) i;
                a[i] = UnsignedLongs.b(-1, j);
                b[i] = (int) UnsignedLongs.e(-1, j);
                c[i] = bigInteger.toString(i).length() - 1;
            }
        }

        static boolean a(long j, int i, int i2) {
            if (j < 0) {
                return true;
            }
            long[] jArr = a;
            if (j < jArr[i2]) {
                return false;
            }
            if (j <= jArr[i2] && i <= b[i2]) {
                return false;
            }
            return true;
        }
    }

    public static int a(long j, long j2) {
        return Longs.c(c(j), c(j2));
    }

    public static long b(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? 0 : 1;
        }
        if (j >= 0) {
            return j / j2;
        }
        int i = 1;
        long j3 = ((j >>> 1) / j2) << 1;
        if (a(j - (j3 * j2), j2) < 0) {
            i = 0;
        }
        return j3 + ((long) i);
    }

    private static long c(long j) {
        return j ^ Long.MIN_VALUE;
    }

    @CanIgnoreReturnValue
    public static long d(String str, int i) {
        ds1.p(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        } else if (i < 2 || i > 36) {
            throw new NumberFormatException("illegal radix: " + i);
        } else {
            int i2 = a.c[i] - 1;
            long j = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                int digit = Character.digit(str.charAt(i3), i);
                if (digit == -1) {
                    throw new NumberFormatException(str);
                } else if (i3 <= i2 || !a.a(j, digit, i)) {
                    j = (j * ((long) i)) + ((long) digit);
                } else {
                    throw new NumberFormatException("Too large for unsigned long: " + str);
                }
            }
            return j;
        }
    }

    public static long e(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? j : j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (a(j3, j2) < 0) {
            j2 = 0;
        }
        return j3 - j2;
    }

    public static String f(long j) {
        return g(j, 10);
    }

    public static String g(long j, int i) {
        long j2;
        ds1.f(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 == 0) {
            return "0";
        }
        if (i2 > 0) {
            return Long.toString(j, i);
        }
        int i3 = 64;
        char[] cArr = new char[64];
        int i4 = i - 1;
        if ((i & i4) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i3--;
                cArr[i3] = Character.forDigit(((int) j) & i4, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            if ((i & 1) == 0) {
                j2 = (j >>> 1) / ((long) (i >>> 1));
            } else {
                j2 = b(j, (long) i);
            }
            long j3 = (long) i;
            cArr[63] = Character.forDigit((int) (j - (j2 * j3)), i);
            i3 = 63;
            while (j2 > 0) {
                i3--;
                cArr[i3] = Character.forDigit((int) (j2 % j3), i);
                j2 /= j3;
            }
        }
        return new String(cArr, i3, 64 - i3);
    }
}
