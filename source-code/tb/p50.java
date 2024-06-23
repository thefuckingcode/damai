package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class p50 extends xo2 {
    @NotNull
    private final xo2 a;

    public p50(@NotNull xo2 xo2) {
        k21.i(xo2, "substitution");
        this.a = xo2;
    }

    @Override // tb.xo2
    public boolean a() {
        return this.a.a();
    }

    @Override // tb.xo2
    @NotNull
    public Annotations d(@NotNull Annotations annotations) {
        k21.i(annotations, "annotations");
        return this.a.d(annotations);
    }

    @Override // tb.xo2
    @Nullable
    public TypeProjection e(@NotNull g61 g61) {
        k21.i(g61, "key");
        return this.a.e(g61);
    }

    @Override // tb.xo2
    public boolean f() {
        return this.a.f();
    }

    @Override // tb.xo2
    @NotNull
    public g61 g(@NotNull g61 g61, @NotNull Variance variance) {
        k21.i(g61, "topLevelType");
        k21.i(variance, "position");
        return this.a.g(g61, variance);
    }
}
