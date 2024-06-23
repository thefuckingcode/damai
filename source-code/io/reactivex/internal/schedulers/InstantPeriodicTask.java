package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import tb.k22;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class InstantPeriodicTask implements Callable<Void>, Disposable {
    static final FutureTask<Void> CANCELLED = new FutureTask<>(Functions.EMPTY_RUNNABLE, null);
    final ExecutorService executor;
    final AtomicReference<Future<?>> first = new AtomicReference<>();
    final AtomicReference<Future<?>> rest = new AtomicReference<>();
    Thread runner;
    final Runnable task;

    InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.task = runnable;
        this.executor = executorService;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.first;
        FutureTask<Void> futureTask = CANCELLED;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        boolean z = true;
        if (!(andSet == null || andSet == futureTask)) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.rest.getAndSet(futureTask);
        if (andSet2 != null && andSet2 != futureTask) {
            if (this.runner == Thread.currentThread()) {
                z = false;
            }
            andSet2.cancel(z);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.first.get() == CANCELLED;
    }

    /* access modifiers changed from: package-private */
    public void setFirst(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.first.get();
            if (future2 == CANCELLED) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.first.compareAndSet(future2, future));
    }

    /* access modifiers changed from: package-private */
    public void setRest(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.rest.get();
            if (future2 == CANCELLED) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.rest.compareAndSet(future2, future));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Void, java.lang.Thread] */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        Thread thread = 0;
        try {
            thread = Thread.currentThread();
            try {
                this.task.run();
                setRest(this.executor.submit(this));
            } catch (Throwable th) {
                k22.u(th);
            }
            this.runner = thread;
            return thread;
        } finally {
            this.runner = thread;
        }
    }
}
