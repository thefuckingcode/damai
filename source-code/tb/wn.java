package tb;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.d;

public final class wn {
    public static final CoroutineScope a(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.Key) == null) {
            coroutineContext = coroutineContext.plus(k41.b(null, 1, null));
        }
        return new gn(coroutineContext);
    }

    public static final void b(CoroutineScope coroutineScope, CancellationException cancellationException) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
            return;
        }
        throw new IllegalStateException(k21.r("Scope cannot be cancelled because it does not have a job: ", coroutineScope).toString());
    }

    public static /* synthetic */ void c(CoroutineScope coroutineScope, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        b(coroutineScope, cancellationException);
    }

    public static final <R> Object d(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        d dVar = new d(continuation.getContext(), continuation);
        Object e = pr2.e(dVar, dVar, function2);
        if (e == b.d()) {
            p30.c(continuation);
        }
        return e;
    }
}
