package kotlinx.coroutines;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hl;
import tb.k21;
import tb.l2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class c<T> extends a<T> {
    @NotNull
    private final Thread a;
    @Nullable
    private final k b;

    public c(@NotNull CoroutineContext coroutineContext, @NotNull Thread thread, @Nullable k kVar) {
        super(coroutineContext, true, true);
        this.a = thread;
        this.b = kVar;
    }

    /* JADX INFO: finally extract failed */
    public final T a() {
        l2.a();
        try {
            k kVar = this.b;
            T t = null;
            if (kVar != null) {
                k.incrementUseCount$default(kVar, false, 1, t);
            }
            while (!Thread.interrupted()) {
                try {
                    k kVar2 = this.b;
                    long processNextEvent = kVar2 == null ? AbsPerformance.LONG_NIL : kVar2.processNextEvent();
                    if (isCompleted()) {
                        l2.a();
                        T t2 = (T) q.h(getState$kotlinx_coroutines_core());
                        if (t2 instanceof hl) {
                            t = t2;
                        }
                        if (t == null) {
                            return t2;
                        }
                        throw t.a;
                    }
                    l2.a();
                    LockSupport.parkNanos(this, processNextEvent);
                } finally {
                    k kVar3 = this.b;
                    if (kVar3 != null) {
                        k.decrementUseCount$default(kVar3, false, 1, t);
                    }
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            cancelCoroutine(interruptedException);
            throw interruptedException;
        } catch (Throwable th) {
            l2.a();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public void afterCompletion(@Nullable Object obj) {
        if (!k21.d(Thread.currentThread(), this.a)) {
            Thread thread = this.a;
            l2.a();
            LockSupport.unpark(thread);
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public boolean isScopedCoroutine() {
        return true;
    }
}
