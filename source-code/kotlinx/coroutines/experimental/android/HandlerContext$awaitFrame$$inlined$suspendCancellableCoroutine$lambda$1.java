package kotlinx.coroutines.experimental.android;

import kotlin.Metadata;
import kotlinx.coroutines.experimental.CancellableContinuation;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/experimental/android/HandlerContext$awaitFrame$3$1"}, k = 3, mv = {1, 1, 10})
/* compiled from: HandlerContext.kt */
final class HandlerContext$awaitFrame$$inlined$suspendCancellableCoroutine$lambda$1 implements Runnable {
    final /* synthetic */ CancellableContinuation $cont;
    final /* synthetic */ HandlerContext this$0;

    HandlerContext$awaitFrame$$inlined$suspendCancellableCoroutine$lambda$1(CancellableContinuation cancellableContinuation, HandlerContext handlerContext) {
        this.$cont = cancellableContinuation;
        this.this$0 = handlerContext;
    }

    public final void run() {
        HandlerContext.access$updateChoreographerAndPostFrameCallback(this.this$0, this.$cont);
    }
}
