package kotlinx.coroutines.debug.internal;

import org.jetbrains.annotations.NotNull;
import tb.jh2;
import tb.k21;

/* compiled from: Taobao */
public final class a {
    @NotNull
    private static final jh2 a = new jh2("REHASH");
    @NotNull
    private static final d b = new d(null);
    @NotNull
    private static final d c = new d(Boolean.TRUE);

    /* access modifiers changed from: private */
    public static final d d(Object obj) {
        if (obj == null) {
            return b;
        }
        if (k21.d(obj, Boolean.TRUE)) {
            return c;
        }
        return new d(obj);
    }

    /* access modifiers changed from: private */
    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
