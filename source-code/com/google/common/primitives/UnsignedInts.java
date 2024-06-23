package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Comparator;
import tb.ds1;

@Beta
@GwtCompatible
/* compiled from: Taobao */
public final class UnsignedInts {

    /* compiled from: Taobao */
    enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }

        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i = 0; i < min; i++) {
                if (iArr[i] != iArr2[i]) {
                    return UnsignedInts.a(iArr[i], iArr2[i]);
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    public static int a(int i, int i2) {
        return Ints.d(c(i), c(i2));
    }

    public static int b(int i, int i2) {
        return (int) (f(i) / f(i2));
    }

    static int c(int i) {
        return i ^ Integer.MIN_VALUE;
    }

    @CanIgnoreReturnValue
    public static int d(String str, int i) {
        ds1.p(str);
        long parseLong = Long.parseLong(str, i);
        if ((4294967295L & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new NumberFormatException("Input " + str + " in base " + i + " is not in the range of an unsigned integer");
    }

    public static int e(int i, int i2) {
        return (int) (f(i) % f(i2));
    }

    public static long f(int i) {
        return ((long) i) & 4294967295L;
    }

    public static String g(int i, int i2) {
        return Long.toString(((long) i) & 4294967295L, i2);
    }
}
