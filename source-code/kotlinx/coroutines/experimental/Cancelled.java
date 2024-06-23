package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/experimental/Cancelled;", "Lkotlinx/coroutines/experimental/CompletedExceptionally;", "job", "Lkotlinx/coroutines/experimental/Job;", "cause", "", "(Lkotlinx/coroutines/experimental/Job;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: CompletedExceptionally.kt */
public final class Cancelled extends CompletedExceptionally {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Cancelled(Job job, Throwable th) {
        super(th == null ? new JobCancellationException("Job was cancelled normally", null, job) : th);
        Intrinsics.checkParameterIsNotNull(job, "job");
    }
}
