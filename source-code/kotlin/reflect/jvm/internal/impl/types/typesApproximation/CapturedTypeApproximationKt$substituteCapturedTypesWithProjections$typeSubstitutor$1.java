package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import com.lzy.okgo.cache.CacheEntity;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: CapturedTypeApproximation.kt */
public final class CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1 extends TypeConstructorSubstitution {
    CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
    public TypeProjection get(TypeConstructor typeConstructor) {
        Intrinsics.checkParameterIsNotNull(typeConstructor, CacheEntity.KEY);
        if (!(typeConstructor instanceof CapturedTypeConstructor)) {
            typeConstructor = null;
        }
        CapturedTypeConstructor capturedTypeConstructor = (CapturedTypeConstructor) typeConstructor;
        if (capturedTypeConstructor == null) {
            return null;
        }
        if (capturedTypeConstructor.getProjection().isStarProjection()) {
            return new TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.getProjection().getType());
        }
        return capturedTypeConstructor.getProjection();
    }
}
