package tb;

import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;

public final class g22 {
    public static final k60 a(ModuleDescriptor moduleDescriptor, StorageManager storageManager, NotFoundClasses notFoundClasses, LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver) {
        k21.i(moduleDescriptor, "module");
        k21.i(storageManager, "storageManager");
        k21.i(notFoundClasses, "notFoundClasses");
        k21.i(lazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
        k21.i(kotlinClassFinder, "reflectKotlinClassFinder");
        k21.i(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        return new k60(storageManager, moduleDescriptor, DeserializationConfiguration.a.INSTANCE, new k31(kotlinClassFinder, deserializedDescriptorResolver), new mb(moduleDescriptor, notFoundClasses, storageManager, kotlinClassFinder), lazyJavaPackageFragmentProvider, notFoundClasses, d22.INSTANCE, LookupTracker.a.INSTANCE, ContractDeserializer.Companion.a(), NewKotlinTypeChecker.Companion.a());
    }

    public static final LazyJavaPackageFragmentProvider b(ClassLoader classLoader, ModuleDescriptor moduleDescriptor, StorageManager storageManager, NotFoundClasses notFoundClasses, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider) {
        k21.i(classLoader, "classLoader");
        k21.i(moduleDescriptor, "module");
        k21.i(storageManager, "storageManager");
        k21.i(notFoundClasses, "notFoundClasses");
        k21.i(kotlinClassFinder, "reflectKotlinClassFinder");
        k21.i(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        k21.i(moduleClassResolver, "singleModuleClassResolver");
        k21.i(packagePartProvider, "packagePartProvider");
        JavaTypeEnhancementState javaTypeEnhancementState = JavaTypeEnhancementState.DISABLED_JSR_305;
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver = new AnnotationTypeQualifierResolver(storageManager, javaTypeEnhancementState);
        ey1 ey1 = new ey1(classLoader);
        SignaturePropagator signaturePropagator = SignaturePropagator.DO_NOTHING;
        k21.h(signaturePropagator, "DO_NOTHING");
        d22 d22 = d22.INSTANCE;
        JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
        k21.h(javaResolverCache, "EMPTY");
        JavaPropertyInitializerEvaluator.a aVar = JavaPropertyInitializerEvaluator.a.INSTANCE;
        u32 u32 = new u32(storageManager, m.g());
        h22 h22 = h22.INSTANCE;
        SupertypeLoopChecker.a aVar2 = SupertypeLoopChecker.a.INSTANCE;
        LookupTracker.a aVar3 = LookupTracker.a.INSTANCE;
        ReflectionTypes reflectionTypes = new ReflectionTypes(moduleDescriptor, notFoundClasses);
        JavaResolverSettings.b bVar = JavaResolverSettings.b.INSTANCE;
        return new LazyJavaPackageFragmentProvider(new v31(storageManager, ey1, kotlinClassFinder, deserializedDescriptorResolver, signaturePropagator, d22, javaResolverCache, aVar, u32, h22, moduleClassResolver, packagePartProvider, aVar2, aVar3, moduleDescriptor, reflectionTypes, annotationTypeQualifierResolver, new SignatureEnhancement(annotationTypeQualifierResolver, javaTypeEnhancementState, new z31(bVar)), JavaClassesTracker.a.INSTANCE, bVar, NewKotlinTypeChecker.Companion.a(), javaTypeEnhancementState));
    }

    public static /* synthetic */ LazyJavaPackageFragmentProvider c(ClassLoader classLoader, ModuleDescriptor moduleDescriptor, StorageManager storageManager, NotFoundClasses notFoundClasses, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, int i, Object obj) {
        return b(classLoader, moduleDescriptor, storageManager, notFoundClasses, kotlinClassFinder, deserializedDescriptorResolver, moduleClassResolver, (i & 128) != 0 ? PackagePartProvider.a.INSTANCE : packagePartProvider);
    }
}
