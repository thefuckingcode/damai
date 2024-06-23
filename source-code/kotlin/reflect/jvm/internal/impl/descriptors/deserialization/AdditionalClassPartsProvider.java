package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;
import tb.og1;

/* compiled from: Taobao */
public interface AdditionalClassPartsProvider {

    /* compiled from: Taobao */
    public static final class a implements AdditionalClassPartsProvider {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        @NotNull
        public Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor classDescriptor) {
            k21.i(classDescriptor, "classDescriptor");
            return m.g();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        @NotNull
        public Collection<SimpleFunctionDescriptor> getFunctions(@NotNull og1 og1, @NotNull ClassDescriptor classDescriptor) {
            k21.i(og1, "name");
            k21.i(classDescriptor, "classDescriptor");
            return m.g();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        @NotNull
        public Collection<og1> getFunctionsNames(@NotNull ClassDescriptor classDescriptor) {
            k21.i(classDescriptor, "classDescriptor");
            return m.g();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        @NotNull
        public Collection<g61> getSupertypes(@NotNull ClassDescriptor classDescriptor) {
            k21.i(classDescriptor, "classDescriptor");
            return m.g();
        }
    }

    @NotNull
    Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<SimpleFunctionDescriptor> getFunctions(@NotNull og1 og1, @NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<og1> getFunctionsNames(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<g61> getSupertypes(@NotNull ClassDescriptor classDescriptor);
}
