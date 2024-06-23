package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeWithEnhancement.kt */
public final class TypeWithEnhancementKt {
    public static final KotlinType getEnhancement(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$getEnhancement");
        if (kotlinType instanceof TypeWithEnhancement) {
            return ((TypeWithEnhancement) kotlinType).getEnhancement();
        }
        return null;
    }

    public static final KotlinType unwrapEnhancement(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$unwrapEnhancement");
        KotlinType enhancement = getEnhancement(kotlinType);
        return enhancement != null ? enhancement : kotlinType;
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType unwrappedType, KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(unwrappedType, "$this$inheritEnhancement");
        Intrinsics.checkParameterIsNotNull(kotlinType, "origin");
        return wrapEnhancement(unwrappedType, getEnhancement(kotlinType));
    }

    public static final UnwrappedType wrapEnhancement(UnwrappedType unwrappedType, KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(unwrappedType, "$this$wrapEnhancement");
        if (kotlinType == null) {
            return unwrappedType;
        }
        if (unwrappedType instanceof SimpleType) {
            return new SimpleTypeWithEnhancement((SimpleType) unwrappedType, kotlinType);
        }
        if (unwrappedType instanceof FlexibleType) {
            return new FlexibleTypeWithEnhancement((FlexibleType) unwrappedType, kotlinType);
        }
        throw new NoWhenBranchMatchedException();
    }
}
