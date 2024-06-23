package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class pb1 {
    @NotNull
    private final String a;
    @NotNull
    private final w11 b;

    public pb1(@NotNull String str, @NotNull w11 w11) {
        k21.i(str, "value");
        k21.i(w11, "range");
        this.a = str;
        this.b = w11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pb1)) {
            return false;
        }
        pb1 pb1 = (pb1) obj;
        return k21.d(this.a, pb1.a) && k21.d(this.b, pb1.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    @NotNull
    public String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.b + ')';
    }
}
