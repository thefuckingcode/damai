package tb;

import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class f22 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final j60 a;
    @NotNull
    private final kn1 b;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final f22 a(@NotNull ClassLoader classLoader) {
            k21.i(classLoader, "classLoader");
            LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("RuntimeModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            og1 i = og1.i("<runtime module for " + classLoader + '>');
            k21.h(i, "special(\"<runtime module for $classLoader>\")");
            ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(i, lockBasedStorageManager, jvmBuiltIns, null, null, null, 56, null);
            jvmBuiltIns.L0(moduleDescriptorImpl);
            jvmBuiltIns.Q0(moduleDescriptorImpl, true);
            xy1 xy1 = new xy1(classLoader);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            kb2 kb2 = new kb2();
            NotFoundClasses notFoundClasses = new NotFoundClasses(lockBasedStorageManager, moduleDescriptorImpl);
            LazyJavaPackageFragmentProvider c = g22.c(classLoader, moduleDescriptorImpl, lockBasedStorageManager, notFoundClasses, xy1, deserializedDescriptorResolver, kb2, null, 128, null);
            k60 a = g22.a(moduleDescriptorImpl, lockBasedStorageManager, notFoundClasses, c, xy1, deserializedDescriptorResolver);
            deserializedDescriptorResolver.o(a);
            JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
            k21.h(javaResolverCache, "EMPTY");
            n31 n31 = new n31(c, javaResolverCache);
            kb2.b(n31);
            ClassLoader classLoader2 = ur2.class.getClassLoader();
            k21.h(classLoader2, "stdlibClassLoader");
            w41 w41 = new w41(lockBasedStorageManager, new xy1(classLoader2), moduleDescriptorImpl, notFoundClasses, jvmBuiltIns.P0(), jvmBuiltIns.P0(), DeserializationConfiguration.a.INSTANCE, NewKotlinTypeChecker.Companion.a(), new u32(lockBasedStorageManager, m.g()));
            moduleDescriptorImpl.r(moduleDescriptorImpl);
            moduleDescriptorImpl.l(new rl(m.j(n31.a(), w41)));
            return new f22(a.a(), new kn1(deserializedDescriptorResolver, xy1), null);
        }
    }

    private f22(j60 j60, kn1 kn1) {
        this.a = j60;
        this.b = kn1;
    }

    public /* synthetic */ f22(j60 j60, kn1 kn1, m40 m40) {
        this(j60, kn1);
    }

    @NotNull
    public final j60 a() {
        return this.a;
    }

    @NotNull
    public final ModuleDescriptor b() {
        return this.a.p();
    }

    @NotNull
    public final kn1 c() {
        return this.b;
    }
}
