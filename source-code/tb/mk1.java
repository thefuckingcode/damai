package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class mk1 {
    @NotNull
    private final String a;
    private final int b;

    public mk1(@NotNull String str, int i) {
        k21.i(str, "number");
        this.a = str;
        this.b = i;
    }

    @NotNull
    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mk1)) {
            return false;
        }
        mk1 mk1 = (mk1) obj;
        return k21.d(this.a, mk1.a) && this.b == mk1.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    @NotNull
    public String toString() {
        return "NumberWithRadix(number=" + this.a + ", radix=" + this.b + ')';
    }
}
