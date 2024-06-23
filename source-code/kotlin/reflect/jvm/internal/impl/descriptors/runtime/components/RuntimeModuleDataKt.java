package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JavaClassDataFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.Jsr305State;

public final class RuntimeModuleDataKt {
    public static /* synthetic */ LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentFromClassLoaderProvider$default(ClassLoader classLoader, ModuleDescriptor moduleDescriptor, StorageManager storageManager, NotFoundClasses notFoundClasses, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, int i, Object obj) {
        return makeLazyJavaPackageFragmentFromClassLoaderProvider(classLoader, moduleDescriptor, storageManager, notFoundClasses, kotlinClassFinder, deserializedDescriptorResolver, moduleClassResolver, (i & 128) != 0 ? PackagePartProvider.Empty.INSTANCE : packagePartProvider);
    }

    public static final LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentFromClassLoaderProvider(ClassLoader classLoader, ModuleDescriptor moduleDescriptor, StorageManager storageManager, NotFoundClasses notFoundClasses, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider) {
        Intrinsics.checkParameterIsNotNull(classLoader, "classLoader");
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(notFoundClasses, "notFoundClasses");
        Intrinsics.checkParameterIsNotNull(kotlinClassFinder, "reflectKotlinClassFinder");
        Intrinsics.checkParameterIsNotNull(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        Intrinsics.checkParameterIsNotNull(moduleClassResolver, "singleModuleClassResolver");
        Intrinsics.checkParameterIsNotNull(packagePartProvider, "packagePartProvider");
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver = new AnnotationTypeQualifierResolver(storageManager, Jsr305State.DISABLED);
        SignaturePropagator signaturePropagator = SignaturePropagator.DO_NOTHING;
        Intrinsics.checkExpressionValueIsNotNull(signaturePropagator, "SignaturePropagator.DO_NOTHING");
        RuntimeErrorReporter runtimeErrorReporter = RuntimeErrorReporter.INSTANCE;
        JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
        Intrinsics.checkExpressionValueIsNotNull(javaResolverCache, "JavaResolverCache.EMPTY");
        return new LazyJavaPackageFragmentProvider(new JavaResolverComponents(storageManager, new ReflectJavaClassFinder(classLoader), kotlinClassFinder, deserializedDescriptorResolver, signaturePropagator, runtimeErrorReporter, javaResolverCache, JavaPropertyInitializerEvaluator.DoNothing.INSTANCE, SamConversionResolver.Empty.INSTANCE, RuntimeSourceElementFactory.INSTANCE, moduleClassResolver, packagePartProvider, SupertypeLoopChecker.EMPTY.INSTANCE, LookupTracker.DO_NOTHING.INSTANCE, moduleDescriptor, new ReflectionTypes(moduleDescriptor, notFoundClasses), annotationTypeQualifierResolver, new SignatureEnhancement(annotationTypeQualifierResolver, Jsr305State.DISABLED), JavaClassesTracker.Default.INSTANCE, JavaResolverSettings.Default.INSTANCE, NewKotlinTypeChecker.Companion.getDefault()));
    }

    public static final DeserializationComponentsForJava makeDeserializationComponentsForJava(ModuleDescriptor moduleDescriptor, StorageManager storageManager, NotFoundClasses notFoundClasses, LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(notFoundClasses, "notFoundClasses");
        Intrinsics.checkParameterIsNotNull(lazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
        Intrinsics.checkParameterIsNotNull(kotlinClassFinder, "reflectKotlinClassFinder");
        Intrinsics.checkParameterIsNotNull(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        return new DeserializationComponentsForJava(storageManager, moduleDescriptor, DeserializationConfiguration.Default.INSTANCE, new JavaClassDataFinder(kotlinClassFinder, deserializedDescriptorResolver), new BinaryClassAnnotationAndConstantLoaderImpl(moduleDescriptor, notFoundClasses, storageManager, kotlinClassFinder), lazyJavaPackageFragmentProvider, notFoundClasses, RuntimeErrorReporter.INSTANCE, LookupTracker.DO_NOTHING.INSTANCE, ContractDeserializer.Companion.getDEFAULT(), NewKotlinTypeChecker.Companion.getDefault());
    }
}
