package tb;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

public final /* synthetic */ class k41 {
    public static final CompletableJob a(Job job) {
        return new i41(job);
    }

    public static /* synthetic */ CompletableJob b(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return j41.a(job);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static /* synthetic */ void d(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        j41.c(coroutineContext, cancellationException);
    }

    public static final DisposableHandle e(Job job, DisposableHandle disposableHandle) {
        return job.invokeOnCompletion(new k90(disposableHandle));
    }

    public static final void f(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            j41.g(job);
        }
    }

    public static final void g(Job job) {
        if (!job.isActive()) {
            throw job.getCancellationException();
        }
    }

    public static final Job h(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(k21.r("Current context doesn't contain Job in it: ", coroutineContext).toString());
    }

    public static final boolean i(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        return k21.d(job == null ? null : Boolean.valueOf(job.isActive()), Boolean.TRUE);
    }
}
