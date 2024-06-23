package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class a {
    @NotNull
    private final TypeParameterDescriptor a;
    @NotNull
    private final g61 b;
    @NotNull
    private final g61 c;

    public a(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull g61 g61, @NotNull g61 g612) {
        k21.i(typeParameterDescriptor, "typeParameter");
        k21.i(g61, "inProjection");
        k21.i(g612, "outProjection");
        this.a = typeParameterDescriptor;
        this.b = g61;
        this.c = g612;
    }

    @NotNull
    public final g61 a() {
        return this.b;
    }

    @NotNull
    public final g61 b() {
        return this.c;
    }

    @NotNull
    public final TypeParameterDescriptor c() {
        return this.a;
    }

    public final boolean d() {
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(this.b, this.c);
    }
}
