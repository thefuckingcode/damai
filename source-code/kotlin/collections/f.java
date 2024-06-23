package kotlin.collections;

import kotlin.SinceKotlin;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class f {
    @SinceKotlin(version = "1.3")
    public static final void a(int i, int i2) {
        if (i > i2) {
            throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
        }
    }
}
