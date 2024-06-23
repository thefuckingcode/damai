package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.i61;
import tb.k21;
import tb.uo2;

/* compiled from: Taobao */
public final class StarProjectionImpl extends uo2 {
    @NotNull
    private final TypeParameterDescriptor a;
    @NotNull
    private final Lazy b = b.a(LazyThreadSafetyMode.PUBLICATION, new StarProjectionImpl$_type$2(this));

    public StarProjectionImpl(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        k21.i(typeParameterDescriptor, "typeParameter");
        this.a = typeParameterDescriptor;
    }

    private final g61 b() {
        return (g61) this.b.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public g61 getType() {
        return b();
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
