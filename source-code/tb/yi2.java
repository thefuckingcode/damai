package tb;

import android.taobao.windvane.config.WVAppParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class yi2 extends WVAppParams {
    private boolean a;
    @NotNull
    private final String b;
    private final boolean c;

    public yi2(@NotNull String str, boolean z) {
        k21.i(str, "uaExtra");
        this.b = str;
        this.c = z;
    }

    public final boolean a() {
        return this.c;
    }

    @NotNull
    public final String b() {
        return this.b;
    }

    public final boolean c() {
        return this.a;
    }

    public final void d(boolean z) {
        this.a = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yi2)) {
            return false;
        }
        yi2 yi2 = (yi2) obj;
        return k21.d(this.b, yi2.b) && this.c == yi2.c;
    }

    public int hashCode() {
        String str = this.b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "TaoMaiH5Config(uaExtra=" + this.b + ", online=" + this.c + jl1.BRACKET_END_STR;
    }
}
