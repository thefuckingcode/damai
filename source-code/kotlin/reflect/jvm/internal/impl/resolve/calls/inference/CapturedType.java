package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedType extends SimpleType implements SubtypingRepresentatives, CapturedTypeMarker {
    private final Annotations annotations;
    private final CapturedTypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final TypeProjection typeProjection;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CapturedType(TypeProjection typeProjection2, CapturedTypeConstructor capturedTypeConstructor, boolean z, Annotations annotations2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection2, (i & 2) != 0 ? new CapturedTypeConstructorImpl(typeProjection2) : capturedTypeConstructor, (i & 4) != 0 ? false : z, (i & 8) != 0 ? Annotations.Companion.getEMPTY() : annotations2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public CapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    public CapturedType(TypeProjection typeProjection2, CapturedTypeConstructor capturedTypeConstructor, boolean z, Annotations annotations2) {
        Intrinsics.checkParameterIsNotNull(typeProjection2, "typeProjection");
        Intrinsics.checkParameterIsNotNull(capturedTypeConstructor, "constructor");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        this.typeProjection = typeProjection2;
        this.constructor = capturedTypeConstructor;
        this.isMarkedNullable = z;
        this.annotations = annotations2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        MemberScope createErrorScope = ErrorUtils.createErrorScope("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        Intrinsics.checkExpressionValueIsNotNull(createErrorScope, "ErrorUtils.createErrorSc…solution\", true\n        )");
        return createErrorScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives
    public KotlinType getSubTypeRepresentative() {
        Variance variance = Variance.OUT_VARIANCE;
        SimpleType nullableAnyType = TypeUtilsKt.getBuiltIns(this).getNullableAnyType();
        Intrinsics.checkExpressionValueIsNotNull(nullableAnyType, "builtIns.nullableAnyType");
        return representative(variance, nullableAnyType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives
    public KotlinType getSuperTypeRepresentative() {
        Variance variance = Variance.IN_VARIANCE;
        SimpleType nothingType = TypeUtilsKt.getBuiltIns(this).getNothingType();
        Intrinsics.checkExpressionValueIsNotNull(nothingType, "builtIns.nothingType");
        return representative(variance, nothingType);
    }

    private final KotlinType representative(Variance variance, KotlinType kotlinType) {
        if (this.typeProjection.getProjectionKind() == variance) {
            kotlinType = this.typeProjection.getType();
        }
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "if (typeProjection.proje…jection.type else default");
        return kotlinType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives
    public boolean sameTypeConstructor(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "type");
        return getConstructor() == kotlinType.getConstructor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Captured(");
        sb.append(this.typeProjection);
        sb.append(')');
        sb.append(isMarkedNullable() ? "?" : "");
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.SimpleType
    public CapturedType makeNullableAsSpecified(boolean z) {
        if (z == isMarkedNullable()) {
            return this;
        }
        return new CapturedType(this.typeProjection, getConstructor(), z, getAnnotations());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.SimpleType
    public CapturedType replaceAnnotations(Annotations annotations2) {
        Intrinsics.checkParameterIsNotNull(annotations2, "newAnnotations");
        return new CapturedType(this.typeProjection, getConstructor(), isMarkedNullable(), annotations2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public CapturedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection refine = this.typeProjection.refine(kotlinTypeRefiner);
        Intrinsics.checkExpressionValueIsNotNull(refine, "typeProjection.refine(kotlinTypeRefiner)");
        return new CapturedType(refine, getConstructor(), isMarkedNullable(), getAnnotations());
    }
}
