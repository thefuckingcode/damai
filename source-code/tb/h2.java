package tb;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class h2<F> {
    public abstract boolean a(F f);

    @NotNull
    public abstract Continuation<Unit>[] b(F f);
}
