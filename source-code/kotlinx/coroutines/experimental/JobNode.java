package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.Job;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b \u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u0006\u001a\u00028\u00008\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/experimental/JobNode;", "J", "Lkotlinx/coroutines/experimental/Job;", "Lkotlinx/coroutines/experimental/CompletionHandlerBase;", "Lkotlinx/coroutines/experimental/DisposableHandle;", "Lkotlinx/coroutines/experimental/Incomplete;", "job", "(Lkotlinx/coroutines/experimental/Job;)V", "isActive", "", "()Z", "Lkotlinx/coroutines/experimental/Job;", "list", "Lkotlinx/coroutines/experimental/NodeList;", "getList", "()Lkotlinx/coroutines/experimental/NodeList;", "dispose", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: JobSupport.kt */
public abstract class JobNode<J extends Job> extends CompletionHandlerBase implements DisposableHandle, Incomplete {
    public final J job;

    @Override // kotlinx.coroutines.experimental.Incomplete
    public NodeList getList() {
        return null;
    }

    @Override // kotlinx.coroutines.experimental.Incomplete
    public boolean isActive() {
        return true;
    }

    public JobNode(J j) {
        Intrinsics.checkParameterIsNotNull(j, "job");
        this.job = j;
    }

    @Override // kotlinx.coroutines.experimental.DisposableHandle
    public void dispose() {
        J j = this.job;
        if (j != null) {
            ((JobSupport) j).removeNode$kotlinx_coroutines_core(this);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.JobSupport");
    }
}
