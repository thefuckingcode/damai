package tb;

import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class cp2 {
    @Nullable
    public static final g61 a(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        if (g61 instanceof TypeWithEnhancement) {
            return ((TypeWithEnhancement) g61).getEnhancement();
        }
        return null;
    }

    @NotNull
    public static final es2 b(@NotNull es2 es2, @NotNull g61 g61) {
        k21.i(es2, "<this>");
        k21.i(g61, "origin");
        return d(es2, a(g61));
    }

    @NotNull
    public static final g61 c(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        g61 a = a(g61);
        return a == null ? g61 : a;
    }

    @NotNull
    public static final es2 d(@NotNull es2 es2, @Nullable g61 g61) {
        k21.i(es2, "<this>");
        if (g61 == null) {
            return es2;
        }
        if (es2 instanceof ib2) {
            return new jb2((ib2) es2, g61);
        }
        if (es2 instanceof dj0) {
            return new fj0((dj0) es2, g61);
        }
        throw new NoWhenBranchMatchedException();
    }
}
