package tb;

import java.io.InputStream;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class w41 extends AbstractDeserializedPackageFragmentProvider {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w41(@NotNull StorageManager storageManager, @NotNull KotlinClassFinder kotlinClassFinder, @NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull DeserializationConfiguration deserializationConfiguration, @NotNull NewKotlinTypeChecker newKotlinTypeChecker, @NotNull SamConversionResolver samConversionResolver) {
        super(storageManager, kotlinClassFinder, moduleDescriptor);
        k21.i(storageManager, "storageManager");
        k21.i(kotlinClassFinder, "finder");
        k21.i(moduleDescriptor, "moduleDescriptor");
        k21.i(notFoundClasses, "notFoundClasses");
        k21.i(additionalClassPartsProvider, "additionalClassPartsProvider");
        k21.i(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        k21.i(deserializationConfiguration, "deserializationConfiguration");
        k21.i(newKotlinTypeChecker, "kotlinTypeChecker");
        k21.i(samConversionResolver, "samConversionResolver");
        o60 o60 = new o60(this);
        id idVar = id.INSTANCE;
        x5 x5Var = new x5(moduleDescriptor, notFoundClasses, idVar);
        LocalClassifierTypeSettings.a aVar = LocalClassifierTypeSettings.a.INSTANCE;
        ErrorReporter errorReporter = ErrorReporter.DO_NOTHING;
        k21.h(errorReporter, "DO_NOTHING");
        f(new j60(storageManager, moduleDescriptor, deserializationConfiguration, o60, x5Var, this, aVar, errorReporter, LookupTracker.a.INSTANCE, FlexibleTypeDeserializer.a.INSTANCE, m.j(new hd(storageManager, moduleDescriptor), new JvmBuiltInClassDescriptorFactory(storageManager, moduleDescriptor, null, 4, null)), notFoundClasses, ContractDeserializer.Companion.a(), additionalClassPartsProvider, platformDependentDeclarationFilter, idVar.e(), newKotlinTypeChecker, samConversionResolver, null, 262144, null));
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider
    @Nullable
    public p60 a(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        InputStream findBuiltInsData = c().findBuiltInsData(en0);
        if (findBuiltInsData == null) {
            return null;
        }
        return kd.Companion.a(en0, e(), d(), findBuiltInsData, false);
    }
}
