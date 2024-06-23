package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ox1<T> {
    private T a;
    private T b;
    private T c;
    private T d;

    public ox1(T t, T t2, T t3, T t4) {
        this.a = t;
        this.b = t2;
        this.c = t3;
        this.d = t4;
    }

    public final T a() {
        return this.d;
    }

    public final T b() {
        return this.b;
    }

    public final T c() {
        return this.a;
    }

    public final T d() {
        return this.c;
    }

    public final void e(T t) {
        this.d = t;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ox1)) {
            return false;
        }
        ox1 ox1 = (ox1) obj;
        return k21.d(this.a, ox1.a) && k21.d(this.b, ox1.b) && k21.d(this.c, ox1.c) && k21.d(this.d, ox1.d);
    }

    public final void f(T t) {
        this.b = t;
    }

    public final void g(T t) {
        this.a = t;
    }

    public final void h(T t) {
        this.c = t;
    }

    public int hashCode() {
        T t = this.a;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.b;
        int hashCode2 = (hashCode + (t2 == null ? 0 : t2.hashCode())) * 31;
        T t3 = this.c;
        int hashCode3 = (hashCode2 + (t3 == null ? 0 : t3.hashCode())) * 31;
        T t4 = this.d;
        if (t4 != null) {
            i = t4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        return "Rect(start=" + ((Object) this.a) + ", end=" + ((Object) this.b) + ", top=" + ((Object) this.c) + ", bottom=" + ((Object) this.d) + ')';
    }
}
