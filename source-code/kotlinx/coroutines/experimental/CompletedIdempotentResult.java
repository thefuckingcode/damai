package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/experimental/CompletedIdempotentResult;", "", "idempotentResume", "result", "token", "Lkotlinx/coroutines/experimental/NotCompleted;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/experimental/NotCompleted;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: CancellableContinuation.kt */
final class CompletedIdempotentResult {
    public final Object idempotentResume;
    public final Object result;
    public final NotCompleted token;

    public CompletedIdempotentResult(Object obj, Object obj2, NotCompleted notCompleted) {
        Intrinsics.checkParameterIsNotNull(notCompleted, "token");
        this.idempotentResume = obj;
        this.result = obj2;
        this.token = notCompleted;
    }

    public String toString() {
        return "CompletedIdempotentResult[" + this.result + ']';
    }
}
