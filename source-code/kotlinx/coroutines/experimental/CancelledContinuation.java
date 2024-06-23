package kotlinx.coroutines.experimental;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/experimental/CancelledContinuation;", "Lkotlinx/coroutines/experimental/CompletedExceptionally;", "continuation", "Lkotlin/coroutines/experimental/Continuation;", "cause", "", "(Lkotlin/coroutines/experimental/Continuation;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: CompletedExceptionally.kt */
public final class CancelledContinuation extends CompletedExceptionally {
    /* JADX WARNING: Illegal instructions before constructor call */
    public CancelledContinuation(Continuation<?> continuation, Throwable th) {
        super(th);
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        if (th == null) {
            th = new CancellationException("Continuation " + continuation + " was cancelled normally");
        }
    }
}
