package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;
import tb.k21;

/* compiled from: Taobao */
public interface TypeMappingConfiguration<T> {

    /* compiled from: Taobao */
    public static final class a {
        @Nullable
        public static <T> String a(@NotNull TypeMappingConfiguration<? extends T> typeMappingConfiguration, @NotNull ClassDescriptor classDescriptor) {
            k21.i(typeMappingConfiguration, "this");
            k21.i(classDescriptor, "classDescriptor");
            return null;
        }

        @Nullable
        public static <T> g61 b(@NotNull TypeMappingConfiguration<? extends T> typeMappingConfiguration, @NotNull g61 g61) {
            k21.i(typeMappingConfiguration, "this");
            k21.i(g61, "kotlinType");
            return null;
        }

        public static <T> boolean c(@NotNull TypeMappingConfiguration<? extends T> typeMappingConfiguration) {
            k21.i(typeMappingConfiguration, "this");
            return true;
        }
    }

    @NotNull
    g61 commonSupertype(@NotNull Collection<g61> collection);

    @Nullable
    String getPredefinedFullInternalNameForClass(@NotNull ClassDescriptor classDescriptor);

    @Nullable
    String getPredefinedInternalNameForClass(@NotNull ClassDescriptor classDescriptor);

    @Nullable
    T getPredefinedTypeForClass(@NotNull ClassDescriptor classDescriptor);

    @Nullable
    g61 preprocessType(@NotNull g61 g61);

    void processErrorType(@NotNull g61 g61, @NotNull ClassDescriptor classDescriptor);

    boolean releaseCoroutines();
}
