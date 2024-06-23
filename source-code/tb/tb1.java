package tb;

import kotlin.SinceKotlin;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class tb1 extends sb1 {
    @SinceKotlin(version = "1.2")
    public static int a(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        } else if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        } else {
            if (d < -2.147483648E9d) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round(d);
        }
    }

    @SinceKotlin(version = "1.2")
    public static int b(float f) {
        if (!Float.isNaN(f)) {
            return Math.round(f);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }
}
