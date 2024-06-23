package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class e7<T> {
    private final T a;
    private final T b;

    public e7(T t, T t2) {
        this.a = t;
        this.b = t2;
    }

    public final T a() {
        return this.a;
    }

    public final T b() {
        return this.b;
    }

    public final T c() {
        return this.a;
    }

    public final T d() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e7)) {
            return false;
        }
        e7 e7Var = (e7) obj;
        return k21.d(this.a, e7Var.a) && k21.d(this.b, e7Var.b);
    }

    public int hashCode() {
        T t = this.a;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "ApproximationBounds(lower=" + ((Object) this.a) + ", upper=" + ((Object) this.b) + ')';
    }
}
