package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0005\u001a\u00020\u00068\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/experimental/BlockingEventLoop;", "Lkotlinx/coroutines/experimental/ThreadEventLoop;", "thread", "Ljava/lang/Thread;", "(Ljava/lang/Thread;)V", "isCompleted", "", "()Z", "setCompleted", "(Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: EventLoop.kt */
public final class BlockingEventLoop extends ThreadEventLoop {
    private volatile boolean isCompleted;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlockingEventLoop(Thread thread) {
        super(thread);
        Intrinsics.checkParameterIsNotNull(thread, "thread");
    }

    @Override // kotlinx.coroutines.experimental.EventLoopBase
    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void setCompleted(boolean z) {
        this.isCompleted = z;
    }
}
