package kotlinx.coroutines.experimental;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00060\fj\u0002`\r2\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/experimental/DefaultTimeSource;", "Lkotlinx/coroutines/experimental/TimeSource;", "()V", "nanoTime", "", "parkNanos", "", "blocker", "", "nanos", "registerTimeLoopThread", "trackTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/experimental/Runnable;", "block", "unTrackTask", "unpark", "thread", "Ljava/lang/Thread;", "unregisterTimeLoopThread", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: TimeSource.kt */
public final class DefaultTimeSource implements TimeSource {
    public static final DefaultTimeSource INSTANCE = new DefaultTimeSource();

    @Override // kotlinx.coroutines.experimental.TimeSource
    public void registerTimeLoopThread() {
    }

    @Override // kotlinx.coroutines.experimental.TimeSource
    public Runnable trackTask(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        return runnable;
    }

    @Override // kotlinx.coroutines.experimental.TimeSource
    public void unTrackTask() {
    }

    @Override // kotlinx.coroutines.experimental.TimeSource
    public void unregisterTimeLoopThread() {
    }

    private DefaultTimeSource() {
    }

    @Override // kotlinx.coroutines.experimental.TimeSource
    public long nanoTime() {
        return System.nanoTime();
    }

    @Override // kotlinx.coroutines.experimental.TimeSource
    public void parkNanos(Object obj, long j) {
        Intrinsics.checkParameterIsNotNull(obj, "blocker");
        LockSupport.parkNanos(obj, j);
    }

    @Override // kotlinx.coroutines.experimental.TimeSource
    public void unpark(Thread thread) {
        Intrinsics.checkParameterIsNotNull(thread, "thread");
        LockSupport.unpark(thread);
    }
}
