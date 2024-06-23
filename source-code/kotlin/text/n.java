package kotlin.text;

import com.alibaba.poplayerconsole.lib.StandOutWindow;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class n extends m {
    @SinceKotlin(version = "1.1")
    @Nullable
    public static Byte j(@NotNull String str, int i) {
        int intValue;
        k21.i(str, "<this>");
        Integer num = l(str, i);
        if (num == null || (intValue = num.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Integer k(@NotNull String str) {
        k21.i(str, "<this>");
        return l(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Integer l(@NotNull String str, int i) {
        boolean z;
        int i2;
        k21.i(str, "<this>");
        int unused = b.a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = str.charAt(0);
        int k = k21.k(charAt, 48);
        int i4 = StandOutWindow.StandOutLayoutParams.AUTO_POSITION;
        int i5 = 1;
        if (k >= 0) {
            z = false;
            i5 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                i4 = Integer.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z = false;
            }
        }
        int i6 = -59652323;
        while (i5 < length) {
            int b = b.b(str.charAt(i5), i);
            if (b < 0) {
                return null;
            }
            if ((i3 < i6 && (i6 != -59652323 || i3 < (i6 = i4 / i))) || (i2 = i3 * i) < i4 + b) {
                return null;
            }
            i3 = i2 - b;
            i5++;
        }
        return z ? Integer.valueOf(i3) : Integer.valueOf(-i3);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Long m(@NotNull String str) {
        k21.i(str, "<this>");
        return n(str, 10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007a  */
    @SinceKotlin(version = "1.1")
    @Nullable
    public static Long n(@NotNull String str, int i) {
        k21.i(str, "<this>");
        int unused = b.a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        long j = -9223372036854775807L;
        boolean z = true;
        if (k21.k(charAt, 48) < 0) {
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                j = Long.MIN_VALUE;
                i2 = 1;
                long j2 = -256204778801521550L;
                long j3 = 0;
                long j4 = -256204778801521550L;
                while (i2 < length) {
                    int b = b.b(str.charAt(i2), i);
                    if (b < 0) {
                        return null;
                    }
                    if (j3 < j4) {
                        if (j4 == j2) {
                            j4 = j / ((long) i);
                            if (j3 < j4) {
                            }
                        }
                        return null;
                    }
                    long j5 = j3 * ((long) i);
                    long j6 = (long) b;
                    if (j5 < j + j6) {
                        return null;
                    }
                    j3 = j5 - j6;
                    i2++;
                    j2 = -256204778801521550L;
                }
                return !z ? Long.valueOf(j3) : Long.valueOf(-j3);
            } else if (charAt != '+') {
                return null;
            } else {
                i2 = 1;
            }
        }
        z = false;
        long j22 = -256204778801521550L;
        long j32 = 0;
        long j42 = -256204778801521550L;
        while (i2 < length) {
        }
        if (!z) {
        }
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Short o(@NotNull String str, int i) {
        int intValue;
        k21.i(str, "<this>");
        Integer num = l(str, i);
        if (num == null || (intValue = num.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }
}
