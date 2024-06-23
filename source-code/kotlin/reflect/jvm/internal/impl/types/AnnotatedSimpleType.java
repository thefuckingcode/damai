package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* access modifiers changed from: package-private */
/* compiled from: KotlinTypeFactory.kt */
public final class AnnotatedSimpleType extends DelegatingSimpleTypeImpl {
    private final Annotations annotations;

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnnotatedSimpleType(SimpleType simpleType, Annotations annotations2) {
        super(simpleType);
        Intrinsics.checkParameterIsNotNull(simpleType, "delegate");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        this.annotations = annotations2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public AnnotatedSimpleType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkParameterIsNotNull(simpleType, "delegate");
        return new AnnotatedSimpleType(simpleType, getAnnotations());
    }
}
