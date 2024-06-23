package kotlinx.coroutines.experimental.android;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.experimental.CancellableContinuation;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 10})
/* compiled from: HandlerContext.kt */
final class HandlerContext$scheduleResumeAfterDelay$1 implements Runnable {
    final /* synthetic */ CancellableContinuation $continuation;
    final /* synthetic */ HandlerContext this$0;

    HandlerContext$scheduleResumeAfterDelay$1(HandlerContext handlerContext, CancellableContinuation cancellableContinuation) {
        this.this$0 = handlerContext;
        this.$continuation = cancellableContinuation;
    }

    public final void run() {
        this.$continuation.resumeUndispatched(this.this$0, Unit.INSTANCE);
    }
}
