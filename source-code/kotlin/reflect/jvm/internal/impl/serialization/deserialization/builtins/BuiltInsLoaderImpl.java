package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.id;
import tb.j60;
import tb.k21;
import tb.kd;
import tb.md;
import tb.o60;
import tb.u32;
import tb.x5;

/* compiled from: Taobao */
public final class BuiltInsLoaderImpl implements BuiltInsLoader {
    @NotNull
    private final md a = new md();

    @NotNull
    public final PackageFragmentProvider a(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Set<en0> set, @NotNull Iterable<? extends ClassDescriptorFactory> iterable, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, boolean z, @NotNull Function1<? super String, ? extends InputStream> function1) {
        k21.i(storageManager, "storageManager");
        k21.i(moduleDescriptor, "module");
        k21.i(set, "packageFqNames");
        k21.i(iterable, "classDescriptorFactories");
        k21.i(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        k21.i(additionalClassPartsProvider, "additionalClassPartsProvider");
        k21.i(function1, "loadResource");
        ArrayList<kd> arrayList = new ArrayList(n.q(set, 10));
        for (T t : set) {
            String n = id.INSTANCE.n(t);
            InputStream inputStream = (InputStream) function1.invoke(n);
            if (inputStream != null) {
                arrayList.add(kd.Companion.a(t, storageManager, moduleDescriptor, inputStream, z));
            } else {
                throw new IllegalStateException(k21.r("Resource not found in classpath: ", n));
            }
        }
        PackageFragmentProviderImpl packageFragmentProviderImpl = new PackageFragmentProviderImpl(arrayList);
        NotFoundClasses notFoundClasses = new NotFoundClasses(storageManager, moduleDescriptor);
        DeserializationConfiguration.a aVar = DeserializationConfiguration.a.INSTANCE;
        o60 o60 = new o60(packageFragmentProviderImpl);
        id idVar = id.INSTANCE;
        x5 x5Var = new x5(moduleDescriptor, notFoundClasses, idVar);
        LocalClassifierTypeSettings.a aVar2 = LocalClassifierTypeSettings.a.INSTANCE;
        ErrorReporter errorReporter = ErrorReporter.DO_NOTHING;
        k21.h(errorReporter, "DO_NOTHING");
        j60 j60 = new j60(storageManager, moduleDescriptor, aVar, o60, x5Var, packageFragmentProviderImpl, aVar2, errorReporter, LookupTracker.a.INSTANCE, FlexibleTypeDeserializer.a.INSTANCE, iterable, notFoundClasses, ContractDeserializer.Companion.a(), additionalClassPartsProvider, platformDependentDeclarationFilter, idVar.e(), null, new u32(storageManager, m.g()), null, 327680, null);
        for (kd kdVar : arrayList) {
            kdVar.f(j60);
        }
        return packageFragmentProviderImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader
    @NotNull
    public PackageFragmentProvider createPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Iterable<? extends ClassDescriptorFactory> iterable, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, boolean z) {
        k21.i(storageManager, "storageManager");
        k21.i(moduleDescriptor, "builtInsModule");
        k21.i(iterable, "classDescriptorFactories");
        k21.i(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        k21.i(additionalClassPartsProvider, "additionalClassPartsProvider");
        return a(storageManager, moduleDescriptor, c.BUILT_INS_PACKAGE_FQ_NAMES, iterable, platformDependentDeclarationFilter, additionalClassPartsProvider, z, new BuiltInsLoaderImpl$createPackageFragmentProvider$1(this.a));
    }
}
