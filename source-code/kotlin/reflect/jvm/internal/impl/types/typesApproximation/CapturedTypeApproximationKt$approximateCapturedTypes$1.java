package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* access modifiers changed from: package-private */
/* compiled from: CapturedTypeApproximation.kt */
public final class CapturedTypeApproximationKt$approximateCapturedTypes$1 extends Lambda implements Function1<KotlinType, KotlinType> {
    final /* synthetic */ KotlinType $type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CapturedTypeApproximationKt$approximateCapturedTypes$1(KotlinType kotlinType) {
        super(1);
        this.$type = kotlinType;
    }

    public final KotlinType invoke(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$makeNullableIfNeeded");
        KotlinType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(kotlinType, this.$type.isMarkedNullable());
        Intrinsics.checkExpressionValueIsNotNull(makeNullableIfNeeded, "TypeUtils.makeNullableIf…s, type.isMarkedNullable)");
        return makeNullableIfNeeded;
    }
}
