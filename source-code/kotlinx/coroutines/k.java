package kotlinx.coroutines;

import com.youku.arch.v3.data.Constants;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.n30;
import tb.s7;

/* compiled from: Taobao */
public abstract class k extends CoroutineDispatcher {
    private boolean shared;
    @Nullable
    private s7<DispatchedTask<?>> unconfinedQueue;
    private long useCount;

    public static /* synthetic */ void decrementUseCount$default(k kVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            kVar.decrementUseCount(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long delta(boolean z) {
        if (z) {
            return Constants.RequestStrategy.LOCAL_FIRST;
        }
        return 1;
    }

    public static /* synthetic */ void incrementUseCount$default(k kVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            kVar.incrementUseCount(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void decrementUseCount(boolean z) {
        long delta = this.useCount - delta(z);
        this.useCount = delta;
        if (delta <= 0) {
            if (n30.a()) {
                if (!(this.useCount == 0)) {
                    throw new AssertionError();
                }
            }
            if (this.shared) {
                shutdown();
            }
        }
    }

    public final void dispatchUnconfined(@NotNull DispatchedTask<?> dispatchedTask) {
        s7<DispatchedTask<?>> s7Var = this.unconfinedQueue;
        if (s7Var == null) {
            s7Var = new s7<>();
            this.unconfinedQueue = s7Var;
        }
        s7Var.a(dispatchedTask);
    }

    /* access modifiers changed from: protected */
    public long getNextTime() {
        s7<DispatchedTask<?>> s7Var = this.unconfinedQueue;
        if (s7Var != null && !s7Var.c()) {
            return 0;
        }
        return AbsPerformance.LONG_NIL;
    }

    public final void incrementUseCount(boolean z) {
        this.useCount += delta(z);
        if (!z) {
            this.shared = true;
        }
    }

    public final boolean isActive() {
        return this.useCount > 0;
    }

    /* access modifiers changed from: protected */
    public boolean isEmpty() {
        return isUnconfinedQueueEmpty();
    }

    public final boolean isUnconfinedLoopActive() {
        return this.useCount >= delta(true);
    }

    public final boolean isUnconfinedQueueEmpty() {
        s7<DispatchedTask<?>> s7Var = this.unconfinedQueue;
        if (s7Var == null) {
            return true;
        }
        return s7Var.c();
    }

    public long processNextEvent() {
        if (!processUnconfinedEvent()) {
            return AbsPerformance.LONG_NIL;
        }
        return 0;
    }

    public final boolean processUnconfinedEvent() {
        DispatchedTask<?> d;
        s7<DispatchedTask<?>> s7Var = this.unconfinedQueue;
        if (s7Var == null || (d = s7Var.d()) == null) {
            return false;
        }
        d.run();
        return true;
    }

    public boolean shouldBeProcessedFromContext() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
    }
}
