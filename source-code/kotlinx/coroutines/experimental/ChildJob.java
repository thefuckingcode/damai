package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/experimental/ChildJob;", "Lkotlinx/coroutines/experimental/JobCancellationNode;", "Lkotlinx/coroutines/experimental/JobSupport;", "parent", "childJob", "Lkotlinx/coroutines/experimental/Job;", "(Lkotlinx/coroutines/experimental/JobSupport;Lkotlinx/coroutines/experimental/Job;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: JobSupport.kt */
public final class ChildJob extends JobCancellationNode<JobSupport> {
    public final Job childJob;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChildJob(JobSupport jobSupport, Job job) {
        super(jobSupport);
        Intrinsics.checkParameterIsNotNull(jobSupport, "parent");
        Intrinsics.checkParameterIsNotNull(job, "childJob");
        this.childJob = job;
    }

    @Override // kotlinx.coroutines.experimental.CompletionHandlerBase
    public void invoke(Throwable th) {
        this.childJob.cancel(((JobSupport) this.job).getCancellationException());
    }

    @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode
    public String toString() {
        return "ChildJob[" + this.childJob + ']';
    }
}
