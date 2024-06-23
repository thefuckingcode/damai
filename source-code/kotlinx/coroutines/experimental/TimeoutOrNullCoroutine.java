package kotlinx.coroutines.experimental;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0004\u0012\u0002H\u00010\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t¢\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/experimental/TimeoutOrNullCoroutine;", "T", "Lkotlinx/coroutines/experimental/TimeoutCoroutine;", "time", "", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlinx/coroutines/experimental/timeunit/TimeUnit;", "cont", "Lkotlin/coroutines/experimental/Continuation;", "(JLjava/util/concurrent/TimeUnit;Lkotlin/coroutines/experimental/Continuation;)V", "onCompletionInternal", "", "state", "", "mode", "", "onCompletionInternal$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Scheduled.kt */
final class TimeoutOrNullCoroutine<T> extends TimeoutCoroutine<T, T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeoutOrNullCoroutine(long j, TimeUnit timeUnit, Continuation<? super T> continuation) {
        super(j, timeUnit, continuation);
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(continuation, "cont");
    }

    @Override // kotlinx.coroutines.experimental.AbstractCoroutine, kotlinx.coroutines.experimental.JobSupport, kotlinx.coroutines.experimental.TimeoutCoroutine
    public void onCompletionInternal$kotlinx_coroutines_core(Object obj, int i) {
        if (obj instanceof CompletedExceptionally) {
            Throwable th = ((CompletedExceptionally) obj).cause;
            if (!(th instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th).coroutine != this) {
                ResumeModeKt.resumeWithExceptionMode(this.cont, th, i);
            } else {
                ResumeModeKt.resumeMode(this.cont, null, i);
            }
        } else {
            ResumeModeKt.resumeMode(this.cont, obj, i);
        }
    }
}
