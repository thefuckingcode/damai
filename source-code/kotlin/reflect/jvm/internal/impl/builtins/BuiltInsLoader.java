package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface BuiltInsLoader {
    @NotNull
    public static final Companion Companion = Companion.a;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();
        @NotNull
        private static final Lazy<BuiltInsLoader> b = b.a(LazyThreadSafetyMode.PUBLICATION, BuiltInsLoader$Companion$Instance$2.INSTANCE);

        private Companion() {
        }

        @NotNull
        public final BuiltInsLoader a() {
            return b.getValue();
        }
    }

    @NotNull
    PackageFragmentProvider createPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Iterable<? extends ClassDescriptorFactory> iterable, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, boolean z);
}
