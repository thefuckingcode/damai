package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: Taobao */
public final class b6 {
    /* access modifiers changed from: private */
    public static final boolean b(ClassDescriptor classDescriptor) {
        return a6.b().contains(DescriptorUtilsKt.i(classDescriptor)) || classDescriptor.getAnnotations().hasAnnotation(a6.f());
    }
}
