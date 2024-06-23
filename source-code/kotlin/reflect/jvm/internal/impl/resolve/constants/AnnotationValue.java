package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: constantValues.kt */
public final class AnnotationValue extends ConstantValue<AnnotationDescriptor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnnotationValue(AnnotationDescriptor annotationDescriptor) {
        super(annotationDescriptor);
        Intrinsics.checkParameterIsNotNull(annotationDescriptor, "value");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        return ((AnnotationDescriptor) getValue()).getType();
    }
}
