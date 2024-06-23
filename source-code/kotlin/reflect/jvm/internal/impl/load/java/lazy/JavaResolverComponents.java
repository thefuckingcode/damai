package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* compiled from: context.kt */
public final class JavaResolverComponents {
    private final AnnotationTypeQualifierResolver annotationTypeQualifierResolver;
    private final DeserializedDescriptorResolver deserializedDescriptorResolver;
    private final ErrorReporter errorReporter;
    private final JavaClassFinder finder;
    private final JavaClassesTracker javaClassesTracker;
    private final JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator;
    private final JavaResolverCache javaResolverCache;
    private final KotlinClassFinder kotlinClassFinder;
    private final NewKotlinTypeChecker kotlinTypeChecker;
    private final LookupTracker lookupTracker;
    private final ModuleDescriptor module;
    private final ModuleClassResolver moduleClassResolver;
    private final PackagePartProvider packagePartProvider;
    private final ReflectionTypes reflectionTypes;
    private final SamConversionResolver samConversionResolver;
    private final JavaResolverSettings settings;
    private final SignatureEnhancement signatureEnhancement;
    private final SignaturePropagator signaturePropagator;
    private final JavaSourceElementFactory sourceElementFactory;
    private final StorageManager storageManager;
    private final SupertypeLoopChecker supertypeLoopChecker;

    public JavaResolverComponents(StorageManager storageManager2, JavaClassFinder javaClassFinder, KotlinClassFinder kotlinClassFinder2, DeserializedDescriptorResolver deserializedDescriptorResolver2, SignaturePropagator signaturePropagator2, ErrorReporter errorReporter2, JavaResolverCache javaResolverCache2, JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator2, SamConversionResolver samConversionResolver2, JavaSourceElementFactory javaSourceElementFactory, ModuleClassResolver moduleClassResolver2, PackagePartProvider packagePartProvider2, SupertypeLoopChecker supertypeLoopChecker2, LookupTracker lookupTracker2, ModuleDescriptor moduleDescriptor, ReflectionTypes reflectionTypes2, AnnotationTypeQualifierResolver annotationTypeQualifierResolver2, SignatureEnhancement signatureEnhancement2, JavaClassesTracker javaClassesTracker2, JavaResolverSettings javaResolverSettings, NewKotlinTypeChecker newKotlinTypeChecker) {
        Intrinsics.checkParameterIsNotNull(storageManager2, "storageManager");
        Intrinsics.checkParameterIsNotNull(javaClassFinder, "finder");
        Intrinsics.checkParameterIsNotNull(kotlinClassFinder2, "kotlinClassFinder");
        Intrinsics.checkParameterIsNotNull(deserializedDescriptorResolver2, "deserializedDescriptorResolver");
        Intrinsics.checkParameterIsNotNull(signaturePropagator2, "signaturePropagator");
        Intrinsics.checkParameterIsNotNull(errorReporter2, "errorReporter");
        Intrinsics.checkParameterIsNotNull(javaResolverCache2, "javaResolverCache");
        Intrinsics.checkParameterIsNotNull(javaPropertyInitializerEvaluator2, "javaPropertyInitializerEvaluator");
        Intrinsics.checkParameterIsNotNull(samConversionResolver2, "samConversionResolver");
        Intrinsics.checkParameterIsNotNull(javaSourceElementFactory, "sourceElementFactory");
        Intrinsics.checkParameterIsNotNull(moduleClassResolver2, "moduleClassResolver");
        Intrinsics.checkParameterIsNotNull(packagePartProvider2, "packagePartProvider");
        Intrinsics.checkParameterIsNotNull(supertypeLoopChecker2, "supertypeLoopChecker");
        Intrinsics.checkParameterIsNotNull(lookupTracker2, "lookupTracker");
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        Intrinsics.checkParameterIsNotNull(reflectionTypes2, "reflectionTypes");
        Intrinsics.checkParameterIsNotNull(annotationTypeQualifierResolver2, "annotationTypeQualifierResolver");
        Intrinsics.checkParameterIsNotNull(signatureEnhancement2, "signatureEnhancement");
        Intrinsics.checkParameterIsNotNull(javaClassesTracker2, "javaClassesTracker");
        Intrinsics.checkParameterIsNotNull(javaResolverSettings, "settings");
        Intrinsics.checkParameterIsNotNull(newKotlinTypeChecker, "kotlinTypeChecker");
        this.storageManager = storageManager2;
        this.finder = javaClassFinder;
        this.kotlinClassFinder = kotlinClassFinder2;
        this.deserializedDescriptorResolver = deserializedDescriptorResolver2;
        this.signaturePropagator = signaturePropagator2;
        this.errorReporter = errorReporter2;
        this.javaResolverCache = javaResolverCache2;
        this.javaPropertyInitializerEvaluator = javaPropertyInitializerEvaluator2;
        this.samConversionResolver = samConversionResolver2;
        this.sourceElementFactory = javaSourceElementFactory;
        this.moduleClassResolver = moduleClassResolver2;
        this.packagePartProvider = packagePartProvider2;
        this.supertypeLoopChecker = supertypeLoopChecker2;
        this.lookupTracker = lookupTracker2;
        this.module = moduleDescriptor;
        this.reflectionTypes = reflectionTypes2;
        this.annotationTypeQualifierResolver = annotationTypeQualifierResolver2;
        this.signatureEnhancement = signatureEnhancement2;
        this.javaClassesTracker = javaClassesTracker2;
        this.settings = javaResolverSettings;
        this.kotlinTypeChecker = newKotlinTypeChecker;
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public final JavaClassFinder getFinder() {
        return this.finder;
    }

    public final KotlinClassFinder getKotlinClassFinder() {
        return this.kotlinClassFinder;
    }

    public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
        return this.deserializedDescriptorResolver;
    }

    public final SignaturePropagator getSignaturePropagator() {
        return this.signaturePropagator;
    }

    public final ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    public final JavaResolverCache getJavaResolverCache() {
        return this.javaResolverCache;
    }

    public final JavaPropertyInitializerEvaluator getJavaPropertyInitializerEvaluator() {
        return this.javaPropertyInitializerEvaluator;
    }

    public final JavaSourceElementFactory getSourceElementFactory() {
        return this.sourceElementFactory;
    }

    public final ModuleClassResolver getModuleClassResolver() {
        return this.moduleClassResolver;
    }

    public final PackagePartProvider getPackagePartProvider() {
        return this.packagePartProvider;
    }

    public final SupertypeLoopChecker getSupertypeLoopChecker() {
        return this.supertypeLoopChecker;
    }

    public final LookupTracker getLookupTracker() {
        return this.lookupTracker;
    }

    public final ModuleDescriptor getModule() {
        return this.module;
    }

    public final ReflectionTypes getReflectionTypes() {
        return this.reflectionTypes;
    }

    public final AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver() {
        return this.annotationTypeQualifierResolver;
    }

    public final SignatureEnhancement getSignatureEnhancement() {
        return this.signatureEnhancement;
    }

    public final JavaClassesTracker getJavaClassesTracker() {
        return this.javaClassesTracker;
    }

    public final JavaResolverSettings getSettings() {
        return this.settings;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.kotlinTypeChecker;
    }

    public final JavaResolverComponents replace(JavaResolverCache javaResolverCache2) {
        Intrinsics.checkParameterIsNotNull(javaResolverCache2, "javaResolverCache");
        return new JavaResolverComponents(this.storageManager, this.finder, this.kotlinClassFinder, this.deserializedDescriptorResolver, this.signaturePropagator, this.errorReporter, javaResolverCache2, this.javaPropertyInitializerEvaluator, this.samConversionResolver, this.sourceElementFactory, this.moduleClassResolver, this.packagePartProvider, this.supertypeLoopChecker, this.lookupTracker, this.module, this.reflectionTypes, this.annotationTypeQualifierResolver, this.signatureEnhancement, this.javaClassesTracker, this.settings, this.kotlinTypeChecker);
    }
}
