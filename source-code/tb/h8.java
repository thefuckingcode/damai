package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class h8 {
    public j8<?> a;

    public abstract void a(@NotNull j8<?> j8Var, @Nullable Object obj);

    @NotNull
    public final j8<?> b() {
        j8<?> j8Var = this.a;
        if (j8Var != null) {
            return j8Var;
        }
        k21.A("atomicOp");
        throw null;
    }

    @Nullable
    public abstract Object c(@NotNull j8<?> j8Var);

    public final void d(@NotNull j8<?> j8Var) {
        this.a = j8Var;
    }
}
