package kotlin.jvm.internal;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import tb.dz1;
import tb.k21;

/* compiled from: Taobao */
public abstract class Lambda<R> implements FunctionBase<R>, Serializable {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @NotNull
    public String toString() {
        String l = dz1.l(this);
        k21.h(l, "renderLambdaToString(this)");
        return l;
    }
}
