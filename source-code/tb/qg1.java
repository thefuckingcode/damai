package tb;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class qg1 {
    @NotNull
    public static final oi a(@NotNull NameResolver nameResolver, int i) {
        k21.i(nameResolver, "<this>");
        oi f = oi.f(nameResolver.getQualifiedClassName(i), nameResolver.isLocalClassName(i));
        k21.h(f, "fromString(getQualifiedClassName(index), isLocalClassName(index))");
        return f;
    }

    @NotNull
    public static final og1 b(@NotNull NameResolver nameResolver, int i) {
        k21.i(nameResolver, "<this>");
        og1 e = og1.e(nameResolver.getString(i));
        k21.h(e, "guessByFirstCharacter(getString(index))");
        return e;
    }
}
