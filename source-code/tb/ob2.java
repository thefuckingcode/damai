package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ob2<T> {
    private T a;
    private T b;

    public ob2(T t, T t2) {
        this.a = t;
        this.b = t2;
    }

    public final T a() {
        return this.b;
    }

    public final T b() {
        return this.a;
    }

    public final void c(T t) {
        this.b = t;
    }

    public final void d(T t) {
        this.a = t;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ob2)) {
            return false;
        }
        ob2 ob2 = (ob2) obj;
        return k21.d(this.a, ob2.a) && k21.d(this.b, ob2.b);
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
        return "Size(width=" + ((Object) this.a) + ", height=" + ((Object) this.b) + ')';
    }
}
