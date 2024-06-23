package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;

/* compiled from: ModuleClassResolver.kt */
public final class SingleModuleClassResolver implements ModuleClassResolver {
    public JavaDescriptorResolver resolver;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver
    public ClassDescriptor resolveClass(JavaClass javaClass) {
        Intrinsics.checkParameterIsNotNull(javaClass, "javaClass");
        JavaDescriptorResolver javaDescriptorResolver = this.resolver;
        if (javaDescriptorResolver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resolver");
        }
        return javaDescriptorResolver.resolveClass(javaClass);
    }

    public final void setResolver(JavaDescriptorResolver javaDescriptorResolver) {
        Intrinsics.checkParameterIsNotNull(javaDescriptorResolver, "<set-?>");
        this.resolver = javaDescriptorResolver;
    }
}
