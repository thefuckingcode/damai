package tb;

import kotlinx.coroutines.EventLoopImplBase;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class hc extends EventLoopImplBase {
    @NotNull
    private final Thread a;

    public hc(@NotNull Thread thread) {
        this.a = thread;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.l
    @NotNull
    public Thread getThread() {
        return this.a;
    }
}
