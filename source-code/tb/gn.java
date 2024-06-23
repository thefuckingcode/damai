package tb;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class gn implements CoroutineScope {
    @NotNull
    private final CoroutineContext a;

    public gn(@NotNull CoroutineContext coroutineContext) {
        this.a = coroutineContext;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.a;
    }

    @NotNull
    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
