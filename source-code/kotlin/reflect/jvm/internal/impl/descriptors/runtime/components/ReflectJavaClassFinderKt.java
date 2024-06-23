package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReflectJavaClassFinder.kt */
public final class ReflectJavaClassFinderKt {
    public static final Class<?> tryLoadClass(ClassLoader classLoader, String str) {
        Intrinsics.checkParameterIsNotNull(classLoader, "$this$tryLoadClass");
        Intrinsics.checkParameterIsNotNull(str, "fqName");
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
