package tb;

import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ww1 extends vw1 {
    public static int a(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static long b(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static float c(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static int d(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long e(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static int f(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
        } else if (i < i2) {
            return i2;
        } else {
            return i > i3 ? i3 : i;
        }
    }

    @NotNull
    public static u11 g(int i, int i2) {
        return u11.Companion.a(i, i2, -1);
    }

    @NotNull
    public static w11 h(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return w11.Companion.a();
        }
        return new w11(i, i2 - 1);
    }
}
