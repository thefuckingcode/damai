package tb;

import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class xy2 {
    @NotNull
    private final WeakReference<ClassLoader> a;
    private final int b;

    public xy2(@NotNull ClassLoader classLoader) {
        k21.i(classLoader, "classLoader");
        this.a = new WeakReference<>(classLoader);
        this.b = System.identityHashCode(classLoader);
    }

    public final void a(@Nullable ClassLoader classLoader) {
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof xy2) && this.a.get() == ((xy2) obj).a.get();
    }

    public int hashCode() {
        return this.b;
    }

    @NotNull
    public String toString() {
        String classLoader;
        ClassLoader classLoader2 = this.a.get();
        return (classLoader2 == null || (classLoader = classLoader2.toString()) == null) ? "<null>" : classLoader;
    }
}
