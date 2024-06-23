package kotlinx.coroutines.experimental;

import com.lzy.okgo.model.HttpHeaders;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.Delay;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0016J*\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X \u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\""}, d2 = {"Lkotlinx/coroutines/experimental/ExecutorCoroutineDispatcherBase;", "Lkotlinx/coroutines/experimental/CloseableCoroutineDispatcher;", "Lkotlinx/coroutines/experimental/Delay;", "()V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor$kotlinx_coroutines_core", "()Ljava/util/concurrent/Executor;", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "", "dispatch", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/experimental/Runnable;", "equals", "", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/experimental/DisposableHandle;", "time", "", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlinx/coroutines/experimental/timeunit/TimeUnit;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Executors.kt */
public abstract class ExecutorCoroutineDispatcherBase extends CloseableCoroutineDispatcher implements Delay {
    public abstract Executor getExecutor$kotlinx_coroutines_core();

    @Override // kotlinx.coroutines.experimental.Delay
    public Object delay(long j, TimeUnit timeUnit, Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j, timeUnit, continuation);
    }

    @Override // kotlinx.coroutines.experimental.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        try {
            getExecutor$kotlinx_coroutines_core().execute(TimeSourceKt.getTimeSource().trackTask(runnable));
        } catch (RejectedExecutionException unused) {
            TimeSourceKt.getTimeSource().unTrackTask();
            DefaultExecutor.INSTANCE.execute$kotlinx_coroutines_core(runnable);
        }
    }

    @Override // kotlinx.coroutines.experimental.Delay
    public void scheduleResumeAfterDelay(long j, TimeUnit timeUnit, CancellableContinuation<? super Unit> cancellableContinuation) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "continuation");
        ScheduledFuture<?> scheduledFuture = null;
        try {
            Executor executor$kotlinx_coroutines_core = getExecutor$kotlinx_coroutines_core();
            if (!(executor$kotlinx_coroutines_core instanceof ScheduledExecutorService)) {
                executor$kotlinx_coroutines_core = null;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) executor$kotlinx_coroutines_core;
            if (scheduledExecutorService != null) {
                scheduledFuture = scheduledExecutorService.schedule(new ResumeUndispatchedRunnable(this, cancellableContinuation), j, timeUnit);
            }
        } catch (RejectedExecutionException unused) {
        }
        if (scheduledFuture != null) {
            JobKt.cancelFutureOnCancellation(cancellableContinuation, scheduledFuture);
        } else {
            DefaultExecutor.INSTANCE.scheduleResumeAfterDelay(j, timeUnit, cancellableContinuation);
        }
    }

    @Override // kotlinx.coroutines.experimental.Delay
    public DisposableHandle invokeOnTimeout(long j, TimeUnit timeUnit, Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        ScheduledFuture<?> scheduledFuture = null;
        try {
            Executor executor$kotlinx_coroutines_core = getExecutor$kotlinx_coroutines_core();
            if (!(executor$kotlinx_coroutines_core instanceof ScheduledExecutorService)) {
                executor$kotlinx_coroutines_core = null;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) executor$kotlinx_coroutines_core;
            if (scheduledExecutorService != null) {
                scheduledFuture = scheduledExecutorService.schedule(runnable, j, timeUnit);
            }
        } catch (RejectedExecutionException unused) {
        }
        if (scheduledFuture != null) {
            return new DisposableFutureHandle(scheduledFuture);
        }
        return DefaultExecutor.INSTANCE.invokeOnTimeout(j, timeUnit, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executor$kotlinx_coroutines_core = getExecutor$kotlinx_coroutines_core();
        if (!(executor$kotlinx_coroutines_core instanceof ExecutorService)) {
            executor$kotlinx_coroutines_core = null;
        }
        ExecutorService executorService = (ExecutorService) executor$kotlinx_coroutines_core;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.experimental.CoroutineDispatcher
    public String toString() {
        return getExecutor$kotlinx_coroutines_core().toString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ExecutorCoroutineDispatcherBase) && ((ExecutorCoroutineDispatcherBase) obj).getExecutor$kotlinx_coroutines_core() == getExecutor$kotlinx_coroutines_core();
    }

    public int hashCode() {
        return System.identityHashCode(getExecutor$kotlinx_coroutines_core());
    }
}
