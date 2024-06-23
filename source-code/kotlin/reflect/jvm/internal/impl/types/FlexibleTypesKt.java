package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: flexibleTypes.kt */
public final class FlexibleTypesKt {
    public static final boolean isFlexible(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$isFlexible");
        return kotlinType.unwrap() instanceof FlexibleType;
    }

    public static final FlexibleType asFlexibleType(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$asFlexibleType");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap != null) {
            return (FlexibleType) unwrap;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
    }

    public static final SimpleType lowerIfFlexible(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$lowerIfFlexible");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            return ((FlexibleType) unwrap).getLowerBound();
        }
        if (unwrap instanceof SimpleType) {
            return (SimpleType) unwrap;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final SimpleType upperIfFlexible(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$upperIfFlexible");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            return ((FlexibleType) unwrap).getUpperBound();
        }
        if (unwrap instanceof SimpleType) {
            return (SimpleType) unwrap;
        }
        throw new NoWhenBranchMatchedException();
    }
}
