package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
/* compiled from: KotlinTypeFactory.kt */
public final class NullableSimpleType extends DelegatingSimpleTypeImpl {
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NullableSimpleType(SimpleType simpleType) {
        super(simpleType);
        Intrinsics.checkParameterIsNotNull(simpleType, "delegate");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public NullableSimpleType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkParameterIsNotNull(simpleType, "delegate");
        return new NullableSimpleType(simpleType);
    }
}
