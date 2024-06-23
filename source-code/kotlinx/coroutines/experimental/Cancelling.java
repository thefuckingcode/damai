package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/experimental/Cancelling;", "Lkotlinx/coroutines/experimental/NotCompleted;", "cancel", "Lkotlinx/coroutines/experimental/CancelledContinuation;", "(Lkotlinx/coroutines/experimental/CancelledContinuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: AbstractContinuation.kt */
public final class Cancelling implements NotCompleted {
    public final CancelledContinuation cancel;

    public Cancelling(CancelledContinuation cancelledContinuation) {
        Intrinsics.checkParameterIsNotNull(cancelledContinuation, "cancel");
        this.cancel = cancelledContinuation;
    }
}
