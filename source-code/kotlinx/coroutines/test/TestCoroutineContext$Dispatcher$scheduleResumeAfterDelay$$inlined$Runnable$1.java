package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0000H\n¨\u0006\u0001"}, d2 = {"Ltb/ur2;", "kotlinx/coroutines/RunnableKt$Runnable$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ CancellableContinuation $continuation$inlined;
    final /* synthetic */ a this$0;

    public TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1(CancellableContinuation cancellableContinuation, a aVar) {
        this.$continuation$inlined = cancellableContinuation;
    }

    public final void run() {
        this.$continuation$inlined.resumeUndispatched(this.this$0, ur2.INSTANCE);
    }
}
