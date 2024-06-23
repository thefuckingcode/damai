package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class qw2 {
    @NotNull
    private final String a;
    private final boolean b;

    protected qw2(@NotNull String str, boolean z) {
        k21.i(str, "name");
        this.a = str;
        this.b = z;
    }

    @Nullable
    public Integer a(@NotNull qw2 qw2) {
        k21.i(qw2, "visibility");
        return pw2.INSTANCE.a(this, qw2);
    }

    @NotNull
    public String b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }

    @NotNull
    public qw2 d() {
        return this;
    }

    @NotNull
    public final String toString() {
        return b();
    }
}
