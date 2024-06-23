package kotlinx.coroutines.experimental;

import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¨\u0006\b"}, d2 = {"cancelFutureOnCancellation", "", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "future", "Ljava/util/concurrent/Future;", "cancelFutureOnCompletion", "Lkotlinx/coroutines/experimental/DisposableHandle;", "Lkotlinx/coroutines/experimental/Job;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 10}, xs = "kotlinx/coroutines/experimental/JobKt")
/* compiled from: Future.kt */
public final /* synthetic */ class JobKt__FutureKt {
    public static final DisposableHandle cancelFutureOnCompletion(Job job, Future<?> future) {
        Intrinsics.checkParameterIsNotNull(job, "$receiver");
        Intrinsics.checkParameterIsNotNull(future, "future");
        return job.invokeOnCompletion(new CancelFutureOnCompletion(job, future));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Disposable handlers on regular completion are no longer supported", replaceWith = @ReplaceWith(expression = "cancelFutureOnCancellation(future)", imports = {}))
    public static final DisposableHandle cancelFutureOnCompletion(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "$receiver");
        Intrinsics.checkParameterIsNotNull(future, "future");
        JobKt.cancelFutureOnCancellation(cancellableContinuation, future);
        return NonDisposableHandle.INSTANCE;
    }

    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "$receiver");
        Intrinsics.checkParameterIsNotNull(future, "future");
        cancellableContinuation.invokeOnCancellation(new CancelFutureOnCancel(future));
    }
}
