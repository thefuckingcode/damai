package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class om<T> {
    private final T a;

    public om(T t) {
        this.a = t;
    }

    @NotNull
    public abstract g61 a(@NotNull ModuleDescriptor moduleDescriptor);

    public T b() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            T b = b();
            Object obj2 = null;
            om omVar = obj instanceof om ? (om) obj : null;
            if (omVar != null) {
                obj2 = omVar.b();
            }
            return k21.d(b, obj2);
        }
    }

    public int hashCode() {
        T b = b();
        if (b == null) {
            return 0;
        }
        return b.hashCode();
    }

    @NotNull
    public String toString() {
        return String.valueOf(b());
    }
}
