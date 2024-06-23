package tb;

import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.text.b;
import org.jetbrains.annotations.NotNull;

@JvmName(name = "UnsignedKt")
/* compiled from: Taobao */
public final class bs2 {
    @PublishedApi
    public static final int a(int i, int i2) {
        return k21.k(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    public static final int b(long j, long j2) {
        return k21.l(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    @NotNull
    public static final String c(long j) {
        return d(j, 10);
    }

    @NotNull
    public static final String d(long j, int i) {
        if (j >= 0) {
            String l = Long.toString(j, b.a(i));
            k21.h(l, "toString(this, checkRadix(radix))");
            return l;
        }
        long j2 = (long) i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String l2 = Long.toString(j3, b.a(i));
        k21.h(l2, "toString(this, checkRadix(radix))");
        sb.append(l2);
        String l3 = Long.toString(j4, b.a(i));
        k21.h(l3, "toString(this, checkRadix(radix))");
        sb.append(l3);
        return sb.toString();
    }
}
