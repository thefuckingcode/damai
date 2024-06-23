package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* access modifiers changed from: package-private */
/* compiled from: CapturedTypeApproximation.kt */
public final class CapturedTypeApproximationKt$toTypeProjection$2 extends Lambda implements Function1<Variance, Variance> {
    final /* synthetic */ TypeArgument $this_toTypeProjection;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CapturedTypeApproximationKt$toTypeProjection$2(TypeArgument typeArgument) {
        super(1);
        this.$this_toTypeProjection = typeArgument;
    }

    public final Variance invoke(Variance variance) {
        Intrinsics.checkParameterIsNotNull(variance, "variance");
        return variance == this.$this_toTypeProjection.getTypeParameter().getVariance() ? Variance.INVARIANT : variance;
    }
}
