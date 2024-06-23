package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable, SchedulerRunnableIntrospection {
    protected static final FutureTask<Void> DISPOSED;
    protected static final FutureTask<Void> FINISHED;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;

    static {
        Runnable runnable2 = Functions.EMPTY_RUNNABLE;
        FINISHED = new FutureTask<>(runnable2, null);
        DISPOSED = new FutureTask<>(runnable2, null);
    }

    AbstractDirectTask(Runnable runnable2) {
        this.runnable = runnable2;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future future = (Future) get();
        if (future != FINISHED && future != (futureTask = DISPOSED) && compareAndSet(future, futureTask) && future != null) {
            future.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
    public Runnable getWrappedRunnable() {
        return this.runnable;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        Future future = (Future) get();
        return future == FINISHED || future == DISPOSED;
    }

    public final void setFuture(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 != FINISHED) {
                if (future2 == DISPOSED) {
                    future.cancel(this.runner != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
