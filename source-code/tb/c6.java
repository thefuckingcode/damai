package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class c6 extends om<AnnotationDescriptor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c6(@NotNull AnnotationDescriptor annotationDescriptor) {
        super(annotationDescriptor);
        k21.i(annotationDescriptor, "value");
    }

    @Override // tb.om
    @NotNull
    public g61 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        return ((AnnotationDescriptor) b()).getType();
    }
}
