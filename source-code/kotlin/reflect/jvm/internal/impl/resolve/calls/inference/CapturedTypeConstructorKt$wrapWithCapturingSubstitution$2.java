package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import com.lzy.okgo.cache.CacheEntity;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2 extends DelegatedTypeSubstitution {
    final /* synthetic */ boolean $needApproximation;
    final /* synthetic */ TypeSubstitution $this_wrapWithCapturingSubstitution;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2(TypeSubstitution typeSubstitution, boolean z, TypeSubstitution typeSubstitution2) {
        super(typeSubstitution2);
        this.$this_wrapWithCapturingSubstitution = typeSubstitution;
        this.$needApproximation = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution, kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.$needApproximation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution, kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution
    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, CacheEntity.KEY);
        TypeProjection typeProjection = super.get(kotlinType);
        TypeParameterDescriptor typeParameterDescriptor = null;
        if (typeProjection == null) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            typeParameterDescriptor = declarationDescriptor;
        }
        return CapturedTypeConstructorKt.createCapturedIfNeeded(typeProjection, typeParameterDescriptor);
    }
}
