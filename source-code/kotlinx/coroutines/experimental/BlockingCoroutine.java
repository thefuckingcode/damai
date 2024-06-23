package kotlinx.coroutines.experimental;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0010¢\u0006\u0002\b\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/experimental/BlockingCoroutine;", "T", "Lkotlinx/coroutines/experimental/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/experimental/EventLoop;", "privateEventLoop", "", "(Lkotlin/coroutines/experimental/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/experimental/EventLoop;Z)V", "joinBlocking", "()Ljava/lang/Object;", "onCancellationInternal", "", "exceptionally", "Lkotlinx/coroutines/experimental/CompletedExceptionally;", "onCancellationInternal$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Builders.kt */
final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    private final Thread blockedThread;
    private final EventLoop eventLoop;
    private final boolean privateEventLoop;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlockingCoroutine(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop2, boolean z) {
        super(coroutineContext, true);
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(thread, "blockedThread");
        this.blockedThread = thread;
        this.eventLoop = eventLoop2;
        this.privateEventLoop = z;
        if (z && !(eventLoop2 instanceof BlockingEventLoop)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @Override // kotlinx.coroutines.experimental.AbstractCoroutine, kotlinx.coroutines.experimental.JobSupport
    public void onCancellationInternal$kotlinx_coroutines_core(CompletedExceptionally completedExceptionally) {
        if (!Intrinsics.areEqual(Thread.currentThread(), this.blockedThread)) {
            LockSupport.unpark(this.blockedThread);
        }
    }

    public final T joinBlocking() {
        TimeSourceKt.getTimeSource().registerTimeLoopThread();
        while (!Thread.interrupted()) {
            EventLoop eventLoop2 = this.eventLoop;
            long processNextEvent = eventLoop2 != null ? eventLoop2.processNextEvent() : LongCompanionObject.MAX_VALUE;
            if (isCompleted()) {
                if (this.privateEventLoop) {
                    EventLoop eventLoop3 = this.eventLoop;
                    if (eventLoop3 != null) {
                        BlockingEventLoop blockingEventLoop = (BlockingEventLoop) eventLoop3;
                        blockingEventLoop.setCompleted(true);
                        blockingEventLoop.shutdown();
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.BlockingEventLoop");
                    }
                }
                TimeSourceKt.getTimeSource().unregisterTimeLoopThread();
                T t = (T) getState$kotlinx_coroutines_core();
                CompletedExceptionally completedExceptionally = !(t instanceof CompletedExceptionally) ? null : t;
                if (completedExceptionally == null) {
                    return t;
                }
                throw completedExceptionally.cause;
            }
            TimeSourceKt.getTimeSource().parkNanos(this, processNextEvent);
        }
        InterruptedException interruptedException = new InterruptedException();
        cancel(interruptedException);
        throw interruptedException;
    }
}
