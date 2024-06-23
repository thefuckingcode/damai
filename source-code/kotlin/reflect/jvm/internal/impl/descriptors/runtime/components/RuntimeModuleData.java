package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.text.Typography;

/* compiled from: RuntimeModuleData.kt */
public final class RuntimeModuleData {
    public static final Companion Companion = new Companion(null);
    private final DeserializationComponents deserialization;
    private final PackagePartScopeCache packagePartScopeCache;

    private RuntimeModuleData(DeserializationComponents deserializationComponents, PackagePartScopeCache packagePartScopeCache2) {
        this.deserialization = deserializationComponents;
        this.packagePartScopeCache = packagePartScopeCache2;
    }

    public /* synthetic */ RuntimeModuleData(DeserializationComponents deserializationComponents, PackagePartScopeCache packagePartScopeCache2, DefaultConstructorMarker defaultConstructorMarker) {
        this(deserializationComponents, packagePartScopeCache2);
    }

    public final DeserializationComponents getDeserialization() {
        return this.deserialization;
    }

    public final PackagePartScopeCache getPackagePartScopeCache() {
        return this.packagePartScopeCache;
    }

    public final ModuleDescriptor getModule() {
        return this.deserialization.getModuleDescriptor();
    }

    /* compiled from: RuntimeModuleData.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RuntimeModuleData create(ClassLoader classLoader) {
            Intrinsics.checkParameterIsNotNull(classLoader, "classLoader");
            LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("RuntimeModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            Name special = Name.special("<runtime module for " + classLoader + Typography.greater);
            Intrinsics.checkExpressionValueIsNotNull(special, "Name.special(\"<runtime module for $classLoader>\")");
            ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(special, lockBasedStorageManager, jvmBuiltIns, null, null, null, 56, null);
            jvmBuiltIns.setBuiltInsModule(moduleDescriptorImpl);
            ModuleDescriptorImpl moduleDescriptorImpl2 = moduleDescriptorImpl;
            jvmBuiltIns.initialize(moduleDescriptorImpl2, true);
            ReflectKotlinClassFinder reflectKotlinClassFinder = new ReflectKotlinClassFinder(classLoader);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            SingleModuleClassResolver singleModuleClassResolver = new SingleModuleClassResolver();
            NotFoundClasses notFoundClasses = new NotFoundClasses(lockBasedStorageManager, moduleDescriptorImpl2);
            ReflectKotlinClassFinder reflectKotlinClassFinder2 = reflectKotlinClassFinder;
            LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentFromClassLoaderProvider$default = RuntimeModuleDataKt.makeLazyJavaPackageFragmentFromClassLoaderProvider$default(classLoader, moduleDescriptorImpl2, lockBasedStorageManager, notFoundClasses, reflectKotlinClassFinder2, deserializedDescriptorResolver, singleModuleClassResolver, null, 128, null);
            DeserializationComponentsForJava makeDeserializationComponentsForJava = RuntimeModuleDataKt.makeDeserializationComponentsForJava(moduleDescriptorImpl2, lockBasedStorageManager, notFoundClasses, makeLazyJavaPackageFragmentFromClassLoaderProvider$default, reflectKotlinClassFinder2, deserializedDescriptorResolver);
            deserializedDescriptorResolver.setComponents(makeDeserializationComponentsForJava);
            JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
            Intrinsics.checkExpressionValueIsNotNull(javaResolverCache, "JavaResolverCache.EMPTY");
            JavaDescriptorResolver javaDescriptorResolver = new JavaDescriptorResolver(makeLazyJavaPackageFragmentFromClassLoaderProvider$default, javaResolverCache);
            singleModuleClassResolver.setResolver(javaDescriptorResolver);
            ClassLoader classLoader2 = Unit.class.getClassLoader();
            Intrinsics.checkExpressionValueIsNotNull(classLoader2, "stdlibClassLoader");
            JvmBuiltInsPackageFragmentProvider jvmBuiltInsPackageFragmentProvider = new JvmBuiltInsPackageFragmentProvider(lockBasedStorageManager, new ReflectKotlinClassFinder(classLoader2), moduleDescriptorImpl2, notFoundClasses, jvmBuiltIns.getSettings(), jvmBuiltIns.getSettings(), DeserializationConfiguration.Default.INSTANCE, NewKotlinTypeChecker.Companion.getDefault());
            moduleDescriptorImpl.setDependencies(moduleDescriptorImpl);
            moduleDescriptorImpl.initialize(new CompositePackageFragmentProvider(CollectionsKt.listOf((Object[]) new PackageFragmentProvider[]{javaDescriptorResolver.getPackageFragmentProvider(), jvmBuiltInsPackageFragmentProvider})));
            return new RuntimeModuleData(makeDeserializationComponentsForJava.getComponents(), new PackagePartScopeCache(deserializedDescriptorResolver, reflectKotlinClassFinder), null);
        }
    }
}
