package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/experimental/CompletedExceptionally;", "", "cause", "", "(Ljava/lang/Throwable;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: CompletedExceptionally.kt */
public class CompletedExceptionally {
    public final Throwable cause;

    public CompletedExceptionally(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "cause");
        this.cause = th;
    }

    public String toString() {
        return DebugKt.getClassSimpleName(this) + '[' + this.cause + ']';
    }
}
