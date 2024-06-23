package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ef0 {
    public static final boolean a(@NotNull Throwable th) {
        k21.i(th, "<this>");
        Class<?> cls = th.getClass();
        while (!k21.d(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final RuntimeException b(@NotNull Throwable th) {
        k21.i(th, "e");
        throw th;
    }
}
