package tb;

import com.youku.live.dago.liveplayback.widget.pip.PipUtils;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class j60 {
    @NotNull
    private final StorageManager a;
    @NotNull
    private final ModuleDescriptor b;
    @NotNull
    private final DeserializationConfiguration c;
    @NotNull
    private final ClassDataFinder d;
    @NotNull
    private final AnnotationAndConstantLoader<AnnotationDescriptor, om<?>> e;
    @NotNull
    private final PackageFragmentProvider f;
    @NotNull
    private final LocalClassifierTypeSettings g;
    @NotNull
    private final ErrorReporter h;
    @NotNull
    private final LookupTracker i;
    @NotNull
    private final FlexibleTypeDeserializer j;
    @NotNull
    private final Iterable<ClassDescriptorFactory> k;
    @NotNull
    private final NotFoundClasses l;
    @NotNull
    private final ContractDeserializer m;
    @NotNull
    private final AdditionalClassPartsProvider n;
    @NotNull
    private final PlatformDependentDeclarationFilter o;
    @NotNull
    private final c p;
    @NotNull
    private final NewKotlinTypeChecker q;
    @NotNull
    private final SamConversionResolver r;
    @NotNull
    private final PlatformDependentTypeTransformer s;
    @NotNull
    private final ClassDeserializer t;

    /* JADX DEBUG: Multi-variable search result rejected for r21v0, resolved type: kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor, ? extends tb.om<?>> */
    /* JADX DEBUG: Multi-variable search result rejected for r27v0, resolved type: java.lang.Iterable<? extends kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory> */
    /* JADX WARN: Multi-variable type inference failed */
    public j60(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull DeserializationConfiguration deserializationConfiguration, @NotNull ClassDataFinder classDataFinder, @NotNull AnnotationAndConstantLoader<? extends AnnotationDescriptor, ? extends om<?>> annotationAndConstantLoader, @NotNull PackageFragmentProvider packageFragmentProvider, @NotNull LocalClassifierTypeSettings localClassifierTypeSettings, @NotNull ErrorReporter errorReporter, @NotNull LookupTracker lookupTracker, @NotNull FlexibleTypeDeserializer flexibleTypeDeserializer, @NotNull Iterable<? extends ClassDescriptorFactory> iterable, @NotNull NotFoundClasses notFoundClasses, @NotNull ContractDeserializer contractDeserializer, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull c cVar, @NotNull NewKotlinTypeChecker newKotlinTypeChecker, @NotNull SamConversionResolver samConversionResolver, @NotNull PlatformDependentTypeTransformer platformDependentTypeTransformer) {
        k21.i(storageManager, "storageManager");
        k21.i(moduleDescriptor, "moduleDescriptor");
        k21.i(deserializationConfiguration, PipUtils.DAGO_PIP_MODE_CONFIGURATION);
        k21.i(classDataFinder, "classDataFinder");
        k21.i(annotationAndConstantLoader, "annotationAndConstantLoader");
        k21.i(packageFragmentProvider, "packageFragmentProvider");
        k21.i(localClassifierTypeSettings, "localClassifierTypeSettings");
        k21.i(errorReporter, "errorReporter");
        k21.i(lookupTracker, "lookupTracker");
        k21.i(flexibleTypeDeserializer, "flexibleTypeDeserializer");
        k21.i(iterable, "fictitiousClassDescriptorFactories");
        k21.i(notFoundClasses, "notFoundClasses");
        k21.i(contractDeserializer, "contractDeserializer");
        k21.i(additionalClassPartsProvider, "additionalClassPartsProvider");
        k21.i(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        k21.i(cVar, "extensionRegistryLite");
        k21.i(newKotlinTypeChecker, "kotlinTypeChecker");
        k21.i(samConversionResolver, "samConversionResolver");
        k21.i(platformDependentTypeTransformer, "platformDependentTypeTransformer");
        this.a = storageManager;
        this.b = moduleDescriptor;
        this.c = deserializationConfiguration;
        this.d = classDataFinder;
        this.e = annotationAndConstantLoader;
        this.f = packageFragmentProvider;
        this.g = localClassifierTypeSettings;
        this.h = errorReporter;
        this.i = lookupTracker;
        this.j = flexibleTypeDeserializer;
        this.k = iterable;
        this.l = notFoundClasses;
        this.m = contractDeserializer;
        this.n = additionalClassPartsProvider;
        this.o = platformDependentDeclarationFilter;
        this.p = cVar;
        this.q = newKotlinTypeChecker;
        this.r = samConversionResolver;
        this.s = platformDependentTypeTransformer;
        this.t = new ClassDeserializer(this);
    }

    @NotNull
    public final l60 a(@NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull NameResolver nameResolver, @NotNull ap2 ap2, @NotNull fv2 fv2, @NotNull nb nbVar, @Nullable DeserializedContainerSource deserializedContainerSource) {
        k21.i(packageFragmentDescriptor, "descriptor");
        k21.i(nameResolver, "nameResolver");
        k21.i(ap2, "typeTable");
        k21.i(fv2, "versionRequirementTable");
        k21.i(nbVar, "metadataVersion");
        return new l60(this, nameResolver, packageFragmentDescriptor, ap2, fv2, nbVar, deserializedContainerSource, null, m.g());
    }

    @Nullable
    public final ClassDescriptor b(@NotNull oi oiVar) {
        k21.i(oiVar, "classId");
        return ClassDeserializer.e(this.t, oiVar, null, 2, null);
    }

    @NotNull
    public final AdditionalClassPartsProvider c() {
        return this.n;
    }

    @NotNull
    public final AnnotationAndConstantLoader<AnnotationDescriptor, om<?>> d() {
        return this.e;
    }

    @NotNull
    public final ClassDataFinder e() {
        return this.d;
    }

    @NotNull
    public final ClassDeserializer f() {
        return this.t;
    }

    @NotNull
    public final DeserializationConfiguration g() {
        return this.c;
    }

    @NotNull
    public final ContractDeserializer h() {
        return this.m;
    }

    @NotNull
    public final ErrorReporter i() {
        return this.h;
    }

    @NotNull
    public final c j() {
        return this.p;
    }

    @NotNull
    public final Iterable<ClassDescriptorFactory> k() {
        return this.k;
    }

    @NotNull
    public final FlexibleTypeDeserializer l() {
        return this.j;
    }

    @NotNull
    public final NewKotlinTypeChecker m() {
        return this.q;
    }

    @NotNull
    public final LocalClassifierTypeSettings n() {
        return this.g;
    }

    @NotNull
    public final LookupTracker o() {
        return this.i;
    }

    @NotNull
    public final ModuleDescriptor p() {
        return this.b;
    }

    @NotNull
    public final NotFoundClasses q() {
        return this.l;
    }

    @NotNull
    public final PackageFragmentProvider r() {
        return this.f;
    }

    @NotNull
    public final PlatformDependentDeclarationFilter s() {
        return this.o;
    }

    @NotNull
    public final PlatformDependentTypeTransformer t() {
        return this.s;
    }

    @NotNull
    public final StorageManager u() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j60(StorageManager storageManager, ModuleDescriptor moduleDescriptor, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder, AnnotationAndConstantLoader annotationAndConstantLoader, PackageFragmentProvider packageFragmentProvider, LocalClassifierTypeSettings localClassifierTypeSettings, ErrorReporter errorReporter, LookupTracker lookupTracker, FlexibleTypeDeserializer flexibleTypeDeserializer, Iterable iterable, NotFoundClasses notFoundClasses, ContractDeserializer contractDeserializer, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, c cVar, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver, PlatformDependentTypeTransformer platformDependentTypeTransformer, int i2, m40 m40) {
        this(storageManager, moduleDescriptor, deserializationConfiguration, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, localClassifierTypeSettings, errorReporter, lookupTracker, flexibleTypeDeserializer, iterable, notFoundClasses, contractDeserializer, (i2 & 8192) != 0 ? AdditionalClassPartsProvider.a.INSTANCE : additionalClassPartsProvider, (i2 & 16384) != 0 ? PlatformDependentDeclarationFilter.a.INSTANCE : platformDependentDeclarationFilter, cVar, (65536 & i2) != 0 ? NewKotlinTypeChecker.Companion.a() : newKotlinTypeChecker, samConversionResolver, (i2 & 262144) != 0 ? PlatformDependentTypeTransformer.a.INSTANCE : platformDependentTypeTransformer);
    }
}
