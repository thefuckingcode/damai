package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.primitives.Ints;
import com.taobao.weex.common.Constants;
import java.math.RoundingMode;
import tb.ds1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class c {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
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
            a[RoundingMode.DOWN.ordinal()] = 2;
            a[RoundingMode.FLOOR.ordinal()] = 3;
            a[RoundingMode.UP.ordinal()] = 4;
            a[RoundingMode.CEILING.ordinal()] = 5;
            a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            a[RoundingMode.HALF_UP.ordinal()] = 7;
            a[RoundingMode.HALF_EVEN.ordinal()] = 8;
        }
    }

    public static int a(int i, int i2) {
        long j = ((long) i) + ((long) i2);
        int i3 = (int) j;
        e.b(j == ((long) i3), "checkedAdd", i, i2);
        return i3;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (((r7 == java.math.RoundingMode.HALF_EVEN) & ((r0 & 1) != 0)) != false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        if (r1 > 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (r5 > 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
        if (r5 < 0) goto L_0x0058;
     */
    public static int b(int i, int i2, RoundingMode roundingMode) {
        ds1.p(roundingMode);
        if (i2 != 0) {
            int i3 = i / i2;
            int i4 = i - (i2 * i3);
            if (i4 == 0) {
                return i3;
            }
            boolean z = true;
            int i5 = ((i ^ i2) >> 31) | 1;
            switch (a.a[roundingMode.ordinal()]) {
                case 1:
                    if (i4 != 0) {
                        z = false;
                    }
                    e.d(z);
                    z = false;
                    break;
                case 2:
                    z = false;
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                case 7:
                case 8:
                    int abs = Math.abs(i4);
                    int abs2 = abs - (Math.abs(i2) - abs);
                    if (abs2 == 0) {
                        if (roundingMode != RoundingMode.HALF_UP) {
                            break;
                        }
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            return z ? i3 + i5 : i3;
        }
        throw new ArithmeticException("/ by zero");
    }

    public static boolean c(int i) {
        boolean z = false;
        boolean z2 = i > 0;
        if ((i & (i - 1)) == 0) {
            z = true;
        }
        return z2 & z;
    }

    @VisibleForTesting
    static int d(int i, int i2) {
        return (~(~(i - i2))) >>> 31;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static int e(int i, RoundingMode roundingMode) {
        e.c(Constants.Name.X, i);
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                e.d(c(i));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - numberOfLeadingZeros) + d(-1257966797 >>> numberOfLeadingZeros, i);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    @Beta
    public static int f(int i, int i2) {
        return Ints.j(((long) i) + ((long) i2));
    }
}
