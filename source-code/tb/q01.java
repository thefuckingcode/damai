package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class q01<T> {
    private final T a;
    private final T b;
    @NotNull
    private final String c;
    @NotNull
    private final oi d;

    public q01(T t, T t2, @NotNull String str, @NotNull oi oiVar) {
        k21.i(str, "filePath");
        k21.i(oiVar, "classId");
        this.a = t;
        this.b = t2;
        this.c = str;
        this.d = oiVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q01)) {
            return false;
        }
        q01 q01 = (q01) obj;
        return k21.d(this.a, q01.a) && k21.d(this.b, q01.b) && k21.d(this.c, q01.c) && k21.d(this.d, q01.d);
    }

    public int hashCode() {
        T t = this.a;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return ((((hashCode + i) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    @NotNull
    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + ((Object) this.a) + ", expectedVersion=" + ((Object) this.b) + ", filePath=" + this.c + ", classId=" + this.d + ')';
    }
}
