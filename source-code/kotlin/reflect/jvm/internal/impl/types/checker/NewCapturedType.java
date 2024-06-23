package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;

/* compiled from: NewCapturedType.kt */
public final class NewCapturedType extends SimpleType implements CapturedTypeMarker {
    private final Annotations annotations;
    private final CaptureStatus captureStatus;
    private final NewCapturedTypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final UnwrappedType lowerType;

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public NewCapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    public final UnwrappedType getLowerType() {
        return this.lowerType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewCapturedType(CaptureStatus captureStatus2, NewCapturedTypeConstructor newCapturedTypeConstructor, UnwrappedType unwrappedType, Annotations annotations2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(captureStatus2, newCapturedTypeConstructor, unwrappedType, (i & 8) != 0 ? Annotations.Companion.getEMPTY() : annotations2, (i & 16) != 0 ? false : z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public NewCapturedType(CaptureStatus captureStatus2, NewCapturedTypeConstructor newCapturedTypeConstructor, UnwrappedType unwrappedType, Annotations annotations2, boolean z) {
        Intrinsics.checkParameterIsNotNull(captureStatus2, "captureStatus");
        Intrinsics.checkParameterIsNotNull(newCapturedTypeConstructor, "constructor");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        this.captureStatus = captureStatus2;
        this.constructor = newCapturedTypeConstructor;
        this.lowerType = unwrappedType;
        this.annotations = annotations2;
        this.isMarkedNullable = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NewCapturedType(CaptureStatus captureStatus2, UnwrappedType unwrappedType, TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        this(captureStatus2, new NewCapturedTypeConstructor(typeProjection, null, null, typeParameterDescriptor, 6, null), unwrappedType, null, false, 24, null);
        Intrinsics.checkParameterIsNotNull(captureStatus2, "captureStatus");
        Intrinsics.checkParameterIsNotNull(typeProjection, "projection");
        Intrinsics.checkParameterIsNotNull(typeParameterDescriptor, "typeParameter");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        MemberScope createErrorScope = ErrorUtils.createErrorScope("No member resolution should be done on captured type!", true);
        Intrinsics.checkExpressionValueIsNotNull(createErrorScope, "ErrorUtils.createErrorSc…on captured type!\", true)");
        return createErrorScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.SimpleType
    public NewCapturedType replaceAnnotations(Annotations annotations2) {
        Intrinsics.checkParameterIsNotNull(annotations2, "newAnnotations");
        return new NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, annotations2, isMarkedNullable());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.SimpleType
    public NewCapturedType makeNullableAsSpecified(boolean z) {
        return new NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, getAnnotations(), z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public NewCapturedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeRefiner, "kotlinTypeRefiner");
        CaptureStatus captureStatus2 = this.captureStatus;
        NewCapturedTypeConstructor refine = getConstructor().refine(kotlinTypeRefiner);
        UnwrappedType unwrappedType = this.lowerType;
        return new NewCapturedType(captureStatus2, refine, unwrappedType != null ? kotlinTypeRefiner.refineType(unwrappedType).unwrap() : null, getAnnotations(), isMarkedNullable());
    }
}
