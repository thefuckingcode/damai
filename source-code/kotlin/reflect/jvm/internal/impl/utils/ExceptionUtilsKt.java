package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: exceptionUtils.kt */
public final class ExceptionUtilsKt {
    public static final RuntimeException rethrow(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        throw th;
    }

    public static final boolean isProcessCanceledException(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "$this$isProcessCanceledException");
        Class<?> cls = th.getClass();
        while (!Intrinsics.areEqual(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }
}
