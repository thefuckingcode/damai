package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;

/* compiled from: ReflectKotlinClassFinder.kt */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {
    private final ClassLoader classLoader;

    public ReflectKotlinClassFinder(ClassLoader classLoader2) {
        Intrinsics.checkParameterIsNotNull(classLoader2, "classLoader");
        this.classLoader = classLoader2;
    }

    private final KotlinClassFinder.Result findKotlinClass(String str) {
        ReflectKotlinClass create;
        Class<?> tryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, str);
        return (tryLoadClass == null || (create = ReflectKotlinClass.Factory.create(tryLoadClass)) == null) ? null : new KotlinClassFinder.Result.KotlinClass(create);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        return findKotlinClass(ReflectKotlinClassFinderKt.access$toRuntimeFqName(classId));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(JavaClass javaClass) {
        String asString;
        Intrinsics.checkParameterIsNotNull(javaClass, "javaClass");
        FqName fqName = javaClass.getFqName();
        if (fqName == null || (asString = fqName.asString()) == null) {
            return null;
        }
        return findKotlinClass(asString);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    public InputStream findBuiltInsData(FqName fqName) {
        Intrinsics.checkParameterIsNotNull(fqName, "packageFqName");
        if (!fqName.startsWith(KotlinBuiltIns.BUILT_INS_PACKAGE_NAME)) {
            return null;
        }
        return this.classLoader.getResourceAsStream(BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(fqName));
    }
}
