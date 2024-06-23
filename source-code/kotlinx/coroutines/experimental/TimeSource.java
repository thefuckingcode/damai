package kotlinx.coroutines.experimental;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00060\nj\u0002`\u000b2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH&J\b\u0010\r\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/experimental/TimeSource;", "", "nanoTime", "", "parkNanos", "", "blocker", "nanos", "registerTimeLoopThread", "trackTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/experimental/Runnable;", "block", "unTrackTask", "unpark", "thread", "Ljava/lang/Thread;", "unregisterTimeLoopThread", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: TimeSource.kt */
public interface TimeSource {
    long nanoTime();

    void parkNanos(Object obj, long j);

    void registerTimeLoopThread();

    Runnable trackTask(Runnable runnable);

    void unTrackTask();

    void unpark(Thread thread);

    void unregisterTimeLoopThread();
}
