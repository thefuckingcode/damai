package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class cl1 {
    @Nullable
    public abstract j8<?> a();

    public final boolean b(@NotNull cl1 cl1) {
        j8<?> a;
        j8<?> a2 = a();
        if (a2 == null || (a = cl1.a()) == null || a2.g() >= a.g()) {
            return false;
        }
        return true;
    }

    @Nullable
    public abstract Object c(@Nullable Object obj);

    @NotNull
    public String toString() {
        return q30.a(this) + '@' + q30.b(this);
    }
}
