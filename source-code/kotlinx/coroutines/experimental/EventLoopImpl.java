package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0005\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoopImpl;", "Lkotlinx/coroutines/experimental/ThreadEventLoop;", "thread", "Ljava/lang/Thread;", "(Ljava/lang/Thread;)V", "isCompleted", "", "()Z", "parentJob", "Lkotlinx/coroutines/experimental/Job;", "initParentJob", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: EventLoop.kt */
public final class EventLoopImpl extends ThreadEventLoop {
    private Job parentJob;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EventLoopImpl(Thread thread) {
        super(thread);
        Intrinsics.checkParameterIsNotNull(thread, "thread");
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.EventLoopBase
    public boolean isCompleted() {
        Job job = this.parentJob;
        return job != null && job.isCompleted();
    }

    public final void initParentJob(Job job) {
        Intrinsics.checkParameterIsNotNull(job, "parentJob");
        if (this.parentJob == null) {
            this.parentJob = job;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
