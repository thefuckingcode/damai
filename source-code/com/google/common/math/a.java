package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.math.RoundingMode;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class a {

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.common.math.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class C0167a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[RoundingMode.values().length];
            a = iArr;
            iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            a[RoundingMode.FLOOR.ordinal()] = 2;
            a[RoundingMode.CEILING.ordinal()] = 3;
            a[RoundingMode.DOWN.ordinal()] = 4;
            a[RoundingMode.UP.ordinal()] = 5;
            a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            a[RoundingMode.HALF_UP.ordinal()] = 7;
            a[RoundingMode.HALF_DOWN.ordinal()] = 8;
        }
    }

    static {
        Math.log(2.0d);
    }

    @GwtIncompatible
    public static boolean a(double d) {
        return b.c(d) && (d == 0.0d || 52 - Long.numberOfTrailingZeros(b.b(d)) <= Math.getExponent(d));
    }

    @GwtIncompatible
    static double b(double d, RoundingMode roundingMode) {
        if (b.c(d)) {
            switch (C0167a.a[roundingMode.ordinal()]) {
                case 1:
                    e.d(a(d));
                    return d;
                case 2:
                    return (d >= 0.0d || a(d)) ? d : (double) (((long) d) - 1);
                case 3:
                    return (d <= 0.0d || a(d)) ? d : (double) (((long) d) + 1);
                case 4:
                    return d;
                case 5:
                    if (a(d)) {
                        return d;
                    }
                    return (double) (((long) d) + ((long) (d > 0.0d ? 1 : -1)));
                case 6:
                    return Math.rint(d);
                case 7:
                    double rint = Math.rint(d);
                    return Math.abs(d - rint) == 0.5d ? d + Math.copySign(0.5d, d) : rint;
                case 8:
                    double rint2 = Math.rint(d);
                    return Math.abs(d - rint2) == 0.5d ? d : rint2;
                default:
                    throw new AssertionError();
            }
        } else {
            throw new ArithmeticException("input is infinite or NaN");
        }
    }

    @GwtIncompatible
    public static long c(double d, RoundingMode roundingMode) {
        double b = b(d, roundingMode);
        boolean z = true;
        boolean z2 = -9.223372036854776E18d - b < 1.0d;
        if (b >= 9.223372036854776E18d) {
            z = false;
        }
        e.a(z2 & z, d, roundingMode);
        return (long) b;
    }
}
