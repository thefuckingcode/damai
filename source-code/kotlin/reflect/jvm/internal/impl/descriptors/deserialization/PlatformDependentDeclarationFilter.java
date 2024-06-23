package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.qq1;

/* compiled from: Taobao */
public interface PlatformDependentDeclarationFilter {

    /* compiled from: Taobao */
    public static final class a implements PlatformDependentDeclarationFilter {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(@NotNull ClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
            k21.i(classDescriptor, "classDescriptor");
            k21.i(simpleFunctionDescriptor, "functionDescriptor");
            return true;
        }
    }

    /* compiled from: Taobao */
    public static final class b implements PlatformDependentDeclarationFilter {
        @NotNull
        public static final b INSTANCE = new b();

        private b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(@NotNull ClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
            k21.i(classDescriptor, "classDescriptor");
            k21.i(simpleFunctionDescriptor, "functionDescriptor");
            return !simpleFunctionDescriptor.getAnnotations().hasAnnotation(qq1.a());
        }
    }

    boolean isFunctionAvailable(@NotNull ClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor simpleFunctionDescriptor);
}
