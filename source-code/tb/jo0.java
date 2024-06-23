package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class jo0 {
    @NotNull
    private final nq0 a;
    @NotNull
    private final nq0 b;
    @NotNull
    private final nq0 c;
    @NotNull
    private final nq0 d;
    @NotNull
    private final ko0 e;

    public jo0(@NotNull nq0 nq0, @NotNull nq0 nq02, @NotNull nq0 nq03, @NotNull nq0 nq04, @NotNull ko0 ko0) {
        k21.i(nq0, "xOffset");
        k21.i(nq02, "yOffset");
        k21.i(nq03, "blurOffset");
        k21.i(nq04, "spreadOffset");
        k21.i(ko0, "color");
        this.a = nq0;
        this.b = nq02;
        this.c = nq03;
        this.d = nq04;
        this.e = ko0;
    }

    @NotNull
    public final nq0 a() {
        return this.c;
    }

    @NotNull
    public final ko0 b() {
        return this.e;
    }

    @NotNull
    public final nq0 c() {
        return this.d;
    }

    @NotNull
    public final nq0 d() {
        return this.a;
    }

    @NotNull
    public final nq0 e() {
        return this.b;
    }
}
