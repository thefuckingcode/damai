package kotlinx.coroutines.experimental;

import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;

@Metadata(bv = {1, 0, 2}, d1 = {"kotlinx/coroutines/experimental/JobKt__FutureKt", "kotlinx/coroutines/experimental/JobKt__JobKt"}, k = 4, mv = {1, 1, 10})
public final class JobKt {
    public static final Job Job(Job job) {
        return JobKt__JobKt.Job(job);
    }

    public static final boolean cancel(CoroutineContext coroutineContext, Throwable th) {
        return JobKt__JobKt.cancel(coroutineContext, th);
    }

    public static final Object cancelAndJoin(Job job, Continuation<? super Unit> continuation) {
        return JobKt__JobKt.cancelAndJoin(job, continuation);
    }

    public static final void cancelChildren(CoroutineContext coroutineContext, Throwable th) {
        JobKt__JobKt.cancelChildren(coroutineContext, th);
    }

    public static final void cancelChildren(Job job, Throwable th) {
        JobKt__JobKt.cancelChildren(job, th);
    }

    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        JobKt__FutureKt.cancelFutureOnCancellation(cancellableContinuation, future);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Disposable handlers on regular completion are no longer supported", replaceWith = @ReplaceWith(expression = "cancelFutureOnCancellation(future)", imports = {}))
    public static final DisposableHandle cancelFutureOnCompletion(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        return JobKt__FutureKt.cancelFutureOnCompletion(cancellableContinuation, future);
    }

    public static final DisposableHandle cancelFutureOnCompletion(Job job, Future<?> future) {
        return JobKt__FutureKt.cancelFutureOnCompletion(job, future);
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        return JobKt__JobKt.disposeOnCompletion(job, disposableHandle);
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        return JobKt__JobKt.isActive(coroutineContext);
    }

    @Deprecated(message = "`join` is now a member function of `Job`")
    public static final Object join(Job job, Continuation<? super Unit> continuation) {
        return JobKt__JobKt.join(job, continuation);
    }

    public static final Object joinChildren(Job job, Continuation<? super Unit> continuation) {
        return JobKt__JobKt.joinChildren(job, continuation);
    }

    @Deprecated(message = "Renamed to `disposeOnCompletion`", replaceWith = @ReplaceWith(expression = "disposeOnCompletion(registration)", imports = {}))
    public static final DisposableHandle unregisterOnCompletion(Job job, DisposableHandle disposableHandle) {
        return JobKt__JobKt.unregisterOnCompletion(job, disposableHandle);
    }
}
