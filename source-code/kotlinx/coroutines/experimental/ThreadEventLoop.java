package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/experimental/ThreadEventLoop;", "Lkotlinx/coroutines/experimental/EventLoopBase;", "thread", "Ljava/lang/Thread;", "(Ljava/lang/Thread;)V", "isCorrectThread", "", "shutdown", "", "unpark", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: EventLoop.kt */
public abstract class ThreadEventLoop extends EventLoopBase {
    private final Thread thread;

    public ThreadEventLoop(Thread thread2) {
        Intrinsics.checkParameterIsNotNull(thread2, "thread");
        this.thread = thread2;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.EventLoopBase
    public boolean isCorrectThread() {
        return Thread.currentThread() == this.thread;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.EventLoopBase
    public void unpark() {
        if (Thread.currentThread() != this.thread) {
            TimeSourceKt.getTimeSource().unpark(this.thread);
        }
    }

    public final void shutdown() {
        closeQueue();
        isCorrectThread();
        do {
        } while (processNextEvent() <= 0);
        rescheduleAllDelayed();
    }
}
