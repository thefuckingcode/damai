package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "kotlinx/coroutines/experimental/JobSupport$awaitSuspend$2$1"}, k = 3, mv = {1, 1, 10})
/* compiled from: JobSupport.kt */
public final class JobSupport$awaitSuspend$$inlined$suspendCancellableCoroutine$lambda$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CancellableContinuation $cont;
    final /* synthetic */ JobSupport this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JobSupport$awaitSuspend$$inlined$suspendCancellableCoroutine$lambda$1(CancellableContinuation cancellableContinuation, JobSupport jobSupport) {
        super(1);
        this.$cont = cancellableContinuation;
        this.this$0 = jobSupport;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke(th);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        Object state$kotlinx_coroutines_core = this.this$0.getState$kotlinx_coroutines_core();
        if (!(!(state$kotlinx_coroutines_core instanceof Incomplete))) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            this.$cont.resumeWithException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause);
        } else {
            this.$cont.resume(state$kotlinx_coroutines_core);
        }
    }
}
