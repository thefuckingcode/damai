package kotlinx.coroutines.experimental.android;

import android.view.Choreographer;
import kotlin.Metadata;
import kotlinx.coroutines.experimental.CancellableContinuation;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "nanos", "", "doFrame"}, k = 3, mv = {1, 1, 10})
/* compiled from: HandlerContext.kt */
final class HandlerContext$postFrameCallback$1 implements Choreographer.FrameCallback {
    final /* synthetic */ CancellableContinuation $cont;
    final /* synthetic */ HandlerContext this$0;

    HandlerContext$postFrameCallback$1(HandlerContext handlerContext, CancellableContinuation cancellableContinuation) {
        this.this$0 = handlerContext;
        this.$cont = cancellableContinuation;
    }

    public final void doFrame(long j) {
        this.$cont.resumeUndispatched(this.this$0, Long.valueOf(j));
    }
}
