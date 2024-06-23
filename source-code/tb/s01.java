package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class s01<T> {
    private final int a;
    private final T b;

    public s01(int i, T t) {
        this.a = i;
        this.b = t;
    }

    public final int a() {
        return this.a;
    }

    public final T b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public final T d() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s01)) {
            return false;
        }
        s01 s01 = (s01) obj;
        return this.a == s01.a && k21.d(this.b, s01.b);
    }

    public int hashCode() {
        int i = this.a * 31;
        T t = this.b;
        return i + (t == null ? 0 : t.hashCode());
    }

    @NotNull
    public String toString() {
        return "IndexedValue(index=" + this.a + ", value=" + ((Object) this.b) + ')';
    }
}
