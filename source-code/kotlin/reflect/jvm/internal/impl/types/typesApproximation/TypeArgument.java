package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

/* access modifiers changed from: package-private */
/* compiled from: CapturedTypeApproximation.kt */
public final class TypeArgument {
    private final KotlinType inProjection;
    private final KotlinType outProjection;
    private final TypeParameterDescriptor typeParameter;

    public TypeArgument(TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.checkParameterIsNotNull(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkParameterIsNotNull(kotlinType, "inProjection");
        Intrinsics.checkParameterIsNotNull(kotlinType2, "outProjection");
        this.typeParameter = typeParameterDescriptor;
        this.inProjection = kotlinType;
        this.outProjection = kotlinType2;
    }

    public final TypeParameterDescriptor getTypeParameter() {
        return this.typeParameter;
    }

    public final KotlinType getInProjection() {
        return this.inProjection;
    }

    public final KotlinType getOutProjection() {
        return this.outProjection;
    }

    public final boolean isConsistent() {
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(this.inProjection, this.outProjection);
    }
}
