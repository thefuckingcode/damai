package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.math.RoundingMode;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.jl1;

/* access modifiers changed from: package-private */
@CanIgnoreReturnValue
@GwtCompatible
/* compiled from: Taobao */
public final class e {
    static void a(boolean z, double d, RoundingMode roundingMode) {
        if (!z) {
            throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + roundingMode);
        }
    }

    static void b(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new ArithmeticException("overflow: " + str + jl1.BRACKET_START_STR + i + AVFSCacheConstants.COMMA_SEP + i2 + jl1.BRACKET_END_STR);
        }
    }

    static int c(@NullableDecl String str, int i) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " (" + i + ") must be > 0");
    }

    static void d(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
