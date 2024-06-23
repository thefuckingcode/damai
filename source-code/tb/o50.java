package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class o50 extends h60 {
    @NotNull
    private final qw2 a;

    public o50(@NotNull qw2 qw2) {
        k21.i(qw2, "delegate");
        this.a = qw2;
    }

    @Override // tb.h60
    @NotNull
    public qw2 b() {
        return this.a;
    }

    @Override // tb.h60
    @NotNull
    public String c() {
        return b().b();
    }

    @Override // tb.h60
    @NotNull
    public h60 f() {
        h60 j = g60.j(b().d());
        k21.h(j, "toDescriptorVisibility(delegate.normalize())");
        return j;
    }
}
