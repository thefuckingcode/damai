package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.Job;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/experimental/JobCancellationNode;", "J", "Lkotlinx/coroutines/experimental/Job;", "Lkotlinx/coroutines/experimental/JobNode;", "job", "(Lkotlinx/coroutines/experimental/Job;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: JobSupport.kt */
public abstract class JobCancellationNode<J extends Job> extends JobNode<J> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JobCancellationNode(J j) {
        super(j);
        Intrinsics.checkParameterIsNotNull(j, "job");
    }
}
