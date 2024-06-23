package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import tb.ds1;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* compiled from: Taobao */
public final class b {
    static double a(double d) {
        ds1.d(!Double.isNaN(d));
        if (d > 0.0d) {
            return d;
        }
        return 0.0d;
    }

    static long b(double d) {
        ds1.e(c(d), "not a normal value");
        int exponent = Math.getExponent(d);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d) & 4503599627370495L;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L;
    }

    static boolean c(double d) {
        return Math.getExponent(d) <= 1023;
    }
}
