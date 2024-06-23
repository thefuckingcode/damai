package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;
import tb.ds1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class LongMath {

    /* compiled from: Taobao */
    private enum MillerRabinTester {
        SMALL {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j, long j2, long j3) {
                return (j * j2) % j3;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j, long j2) {
                return (j * j) % j2;
            }
        },
        LARGE {
            private long plusMod(long j, long j2, long j3) {
                int i = (j > (j3 - j2) ? 1 : (j == (j3 - j2) ? 0 : -1));
                long j4 = j + j2;
                return i >= 0 ? j4 - j3 : j4;
            }

            private long times2ToThe32Mod(long j, long j2) {
                int i = 32;
                do {
                    int min = Math.min(i, Long.numberOfLeadingZeros(j));
                    j = UnsignedLongs.e(j << min, j2);
                    i -= min;
                } while (i > 0);
                return j;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j, long j2, long j3) {
                long j4 = j >>> 32;
                long j5 = j2 >>> 32;
                long j6 = j & 4294967295L;
                long j7 = j2 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j4 * j5, j3) + (j4 * j7);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.e(times2ToThe32Mod, j3);
                }
                Long.signum(j6);
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j5 * j6), j3), UnsignedLongs.e(j6 * j7, j3), j3);
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j, long j2) {
                long j3 = j >>> 32;
                long j4 = j & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j3 * j3, j2);
                long j5 = j3 * j4 * 2;
                if (j5 < 0) {
                    j5 = UnsignedLongs.e(j5, j2);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j5, j2), UnsignedLongs.e(j4 * j4, j2), j2);
            }
        };

        private long powMod(long j, long j2, long j3) {
            long j4 = 1;
            while (j2 != 0) {
                if ((j2 & 1) != 0) {
                    j4 = mulMod(j4, j, j3);
                }
                j = squareMod(j, j3);
                j2 >>= 1;
            }
            return j4;
        }

        static boolean test(long j, long j2) {
            return (j2 <= 3037000499L ? SMALL : LARGE).testWitness(j, j2);
        }

        private boolean testWitness(long j, long j2) {
            long j3 = j2 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j3);
            long j4 = j3 >> numberOfTrailingZeros;
            long j5 = j % j2;
            if (j5 == 0) {
                return true;
            }
            long powMod = powMod(j5, j4, j2);
            if (powMod == 1) {
                return true;
            }
            int i = 0;
            while (powMod != j3) {
                i++;
                if (i == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j2);
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public abstract long mulMod(long j, long j2, long j3);

        /* access modifiers changed from: package-private */
        public abstract long squareMod(long j, long j2);

        /* synthetic */ MillerRabinTester(a aVar) {
            this();
        }
    }

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

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        if (r11 > 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (r10 > 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r10 < 0) goto L_0x0062;
     */
    @GwtIncompatible
    public static long a(long j, long j2, RoundingMode roundingMode) {
        ds1.p(roundingMode);
        long j3 = j / j2;
        long j4 = j - (j2 * j3);
        int i = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i == 0) {
            return j3;
        }
        int i2 = (int) ((j ^ j2) >> 63);
        boolean z = true;
        int i3 = i2 | 1;
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                if (i != 0) {
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
                long abs = Math.abs(j4);
                int i4 = ((abs - (Math.abs(j2) - abs)) > 0 ? 1 : ((abs - (Math.abs(j2) - abs)) == 0 ? 0 : -1));
                if (i4 == 0) {
                    boolean z2 = roundingMode == RoundingMode.HALF_UP;
                    boolean z3 = roundingMode == RoundingMode.HALF_EVEN;
                    if ((1 & j3) == 0) {
                        z = false;
                    }
                    z = (z & z3) | z2;
                    break;
                }
                break;
            default:
                throw new AssertionError();
        }
        return z ? j3 + ((long) i3) : j3;
    }
}
