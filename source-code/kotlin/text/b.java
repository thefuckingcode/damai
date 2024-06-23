package kotlin.text;

import kotlin.PublishedApi;
import tb.w11;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class b {
    @PublishedApi
    public static int a(int i) {
        if (new w11(2, 36).f(i)) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new w11(2, 36));
    }

    public static final int b(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static final boolean c(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}
