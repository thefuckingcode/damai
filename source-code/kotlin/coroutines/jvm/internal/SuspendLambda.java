package kotlin.coroutines.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dz1;
import tb.k21;

@SinceKotlin(version = "1.3")
/* compiled from: Taobao */
public abstract class SuspendLambda extends ContinuationImpl implements FunctionBase<Object>, SuspendFunction {
    private final int arity;

    public SuspendLambda(int i, @Nullable Continuation<Object> continuation) {
        super(continuation);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String k = dz1.k(this);
        k21.h(k, "renderLambdaToString(this)");
        return k;
    }

    public SuspendLambda(int i) {
        this(i, null);
    }
}
