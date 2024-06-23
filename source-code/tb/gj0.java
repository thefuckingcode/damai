package tb;

import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class gj0 {
    @NotNull
    public static final dj0 a(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        return (dj0) g61.f();
    }

    public static final boolean b(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        return g61.f() instanceof dj0;
    }

    @NotNull
    public static final ib2 c(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        es2 f = g61.f();
        if (f instanceof dj0) {
            return ((dj0) f).k();
        }
        if (f instanceof ib2) {
            return (ib2) f;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final ib2 d(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        es2 f = g61.f();
        if (f instanceof dj0) {
            return ((dj0) f).l();
        }
        if (f instanceof ib2) {
            return (ib2) f;
        }
        throw new NoWhenBranchMatchedException();
    }
}
