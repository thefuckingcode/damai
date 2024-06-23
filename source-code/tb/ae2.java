package tb;

import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ae2 extends uo2 {
    @NotNull
    private final g61 a;

    public ae2(@NotNull b bVar) {
        k21.i(bVar, "kotlinBuiltIns");
        ib2 I = bVar.I();
        k21.h(I, "kotlinBuiltIns.nullableAnyType");
        this.a = I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public g61 getType() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public TypeProjection refine(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return this;
    }
}
