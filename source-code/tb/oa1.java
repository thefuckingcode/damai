package tb;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: Taobao */
public final class oa1<V> {
    @Nullable
    private final V a;
    @Nullable
    private final Throwable b;

    public oa1(V v) {
        this.a = v;
        this.b = null;
    }

    @Nullable
    public Throwable a() {
        return this.b;
    }

    @Nullable
    public V b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oa1)) {
            return false;
        }
        oa1 oa1 = (oa1) obj;
        if (b() != null && b().equals(oa1.b())) {
            return true;
        }
        if (a() == null || oa1.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public oa1(Throwable th) {
        this.b = th;
        this.a = null;
    }
}
