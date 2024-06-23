package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.EventLoopImplBase;
import org.jetbrains.annotations.NotNull;
import tb.l2;
import tb.n30;

/* compiled from: Taobao */
public abstract class l extends k {
    /* access modifiers changed from: protected */
    @NotNull
    public abstract Thread getThread();

    /* access modifiers changed from: protected */
    public final void reschedule(long j, @NotNull EventLoopImplBase.DelayedTask delayedTask) {
        if (n30.a()) {
            if (!(this != DefaultExecutor.INSTANCE)) {
                throw new AssertionError();
            }
        }
        DefaultExecutor.INSTANCE.schedule(j, delayedTask);
    }

    /* access modifiers changed from: protected */
    public final void unpark() {
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            l2.a();
            LockSupport.unpark(thread);
        }
    }
}
