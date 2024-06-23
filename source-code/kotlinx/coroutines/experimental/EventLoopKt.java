package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.internal.Symbol;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000*\u001e\b\u0002\u0010\u000e\u001a\u0004\b\u0000\u0010\u000f\"\b\u0012\u0004\u0012\u0002H\u000f0\u00102\b\u0012\u0004\u0012\u0002H\u000f0\u0010¨\u0006\u0011"}, d2 = {"CLOSED_EMPTY", "Lkotlinx/coroutines/experimental/internal/Symbol;", "CLOSED_EMPTY$annotations", "()V", "DELAYED", "", "REMOVED", "RESCHEDULED", "EventLoop", "Lkotlinx/coroutines/experimental/CoroutineDispatcher;", "thread", "Ljava/lang/Thread;", "parentJob", "Lkotlinx/coroutines/experimental/Job;", "Queue", "T", "Lkotlinx/coroutines/experimental/internal/LockFreeMPSCQueueCore;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: EventLoop.kt */
public final class EventLoopKt {
    private static final Symbol CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");
    private static final int DELAYED = 0;
    private static final int REMOVED = 1;
    private static final int RESCHEDULED = 2;

    private static /* synthetic */ void CLOSED_EMPTY$annotations() {
    }

    public static /* bridge */ /* synthetic */ CoroutineDispatcher EventLoop$default(Thread thread, Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            thread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(thread, "Thread.currentThread()");
        }
        if ((i & 2) != 0) {
            job = null;
        }
        return EventLoop(thread, job);
    }

    public static final CoroutineDispatcher EventLoop(Thread thread, Job job) {
        Intrinsics.checkParameterIsNotNull(thread, "thread");
        EventLoopImpl eventLoopImpl = new EventLoopImpl(thread);
        if (job != null) {
            eventLoopImpl.initParentJob(job);
        }
        return eventLoopImpl;
    }
}
