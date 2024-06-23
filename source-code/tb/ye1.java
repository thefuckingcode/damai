package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ye1 {
    @NotNull
    public static final MemberScope a(@NotNull ClassDescriptor classDescriptor, @NotNull xo2 xo2, @NotNull i61 i61) {
        k21.i(classDescriptor, "<this>");
        k21.i(xo2, "typeSubstitution");
        k21.i(i61, "kotlinTypeRefiner");
        return xe1.Companion.a(classDescriptor, xo2, i61);
    }

    @NotNull
    public static final MemberScope b(@NotNull ClassDescriptor classDescriptor, @NotNull i61 i61) {
        k21.i(classDescriptor, "<this>");
        k21.i(i61, "kotlinTypeRefiner");
        return xe1.Companion.b(classDescriptor, i61);
    }
}
