package tb;

import kotlinx.coroutines.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ok2 {
    @NotNull
    public static final ok2 INSTANCE = new ok2();
    @NotNull
    private static final ThreadLocal<k> a = new ThreadLocal<>();

    private ok2() {
    }

    @Nullable
    public final k a() {
        return a.get();
    }

    @NotNull
    public final k b() {
        ThreadLocal<k> threadLocal = a;
        k kVar = threadLocal.get();
        if (kVar != null) {
            return kVar;
        }
        k a2 = bf0.a();
        threadLocal.set(a2);
        return a2;
    }

    public final void c() {
        a.set(null);
    }

    public final void d(@NotNull k kVar) {
        a.set(kVar);
    }
}
