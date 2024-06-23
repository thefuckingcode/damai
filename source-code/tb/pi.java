package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class pi {
    @NotNull
    private final oi a;
    private final int b;

    public pi(@NotNull oi oiVar, int i) {
        k21.i(oiVar, "classId");
        this.a = oiVar;
        this.b = i;
    }

    @NotNull
    public final oi a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.b;
    }

    @NotNull
    public final oi d() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pi)) {
            return false;
        }
        pi piVar = (pi) obj;
        return k21.d(this.a, piVar.a) && this.b == piVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int c = c();
        for (int i = 0; i < c; i++) {
            sb.append("kotlin/Array<");
        }
        sb.append(d());
        int c2 = c();
        for (int i2 = 0; i2 < c2; i2++) {
            sb.append(jl1.G);
        }
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
