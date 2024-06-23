package tb;

import com.youku.live.dago.liveplayback.widget.pip.PipUtils;
import java.util.List;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class k60 {
    @NotNull
    private final j60 a;

    public k60(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull DeserializationConfiguration deserializationConfiguration, @NotNull k31 k31, @NotNull mb mbVar, @NotNull LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, @NotNull NotFoundClasses notFoundClasses, @NotNull ErrorReporter errorReporter, @NotNull LookupTracker lookupTracker, @NotNull ContractDeserializer contractDeserializer, @NotNull NewKotlinTypeChecker newKotlinTypeChecker) {
        AdditionalClassPartsProvider additionalClassPartsProvider;
        k21.i(storageManager, "storageManager");
        k21.i(moduleDescriptor, "moduleDescriptor");
        k21.i(deserializationConfiguration, PipUtils.DAGO_PIP_MODE_CONFIGURATION);
        k21.i(k31, "classDataFinder");
        k21.i(mbVar, "annotationAndConstantLoader");
        k21.i(lazyJavaPackageFragmentProvider, "packageFragmentProvider");
        k21.i(notFoundClasses, "notFoundClasses");
        k21.i(errorReporter, "errorReporter");
        k21.i(lookupTracker, "lookupTracker");
        k21.i(contractDeserializer, "contractDeserializer");
        k21.i(newKotlinTypeChecker, "kotlinTypeChecker");
        b builtIns = moduleDescriptor.getBuiltIns();
        PlatformDependentDeclarationFilter platformDependentDeclarationFilter = null;
        JvmBuiltIns jvmBuiltIns = builtIns instanceof JvmBuiltIns ? (JvmBuiltIns) builtIns : null;
        LocalClassifierTypeSettings.a aVar = LocalClassifierTypeSettings.a.INSTANCE;
        q31 q31 = q31.INSTANCE;
        List list = m.g();
        if (jvmBuiltIns == null) {
            additionalClassPartsProvider = null;
        } else {
            additionalClassPartsProvider = jvmBuiltIns.P0();
        }
        additionalClassPartsProvider = additionalClassPartsProvider == null ? AdditionalClassPartsProvider.a.INSTANCE : additionalClassPartsProvider;
        platformDependentDeclarationFilter = jvmBuiltIns != null ? jvmBuiltIns.P0() : platformDependentDeclarationFilter;
        this.a = new j60(storageManager, moduleDescriptor, deserializationConfiguration, k31, mbVar, lazyJavaPackageFragmentProvider, aVar, errorReporter, lookupTracker, q31, list, notFoundClasses, contractDeserializer, additionalClassPartsProvider, platformDependentDeclarationFilter == null ? PlatformDependentDeclarationFilter.b.INSTANCE : platformDependentDeclarationFilter, i51.INSTANCE.a(), newKotlinTypeChecker, new u32(storageManager, m.g()), null, 262144, null);
    }

    @NotNull
    public final j60 a() {
        return this.a;
    }
}
