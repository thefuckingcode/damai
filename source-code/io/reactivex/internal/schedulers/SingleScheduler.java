package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import tb.k22;
import tb.ql;

/* compiled from: Taobao */
public final class SingleScheduler extends Scheduler {
    private static final String KEY_SINGLE_PRIORITY = "rx2.single-priority";
    static final ScheduledExecutorService SHUTDOWN;
    static final RxThreadFactory SINGLE_THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_SINGLE_PRIORITY, 5).intValue())), true);
    private static final String THREAD_NAME_PREFIX = "RxSingleScheduler";
    final AtomicReference<ScheduledExecutorService> executor;
    final ThreadFactory threadFactory;

    /* compiled from: Taobao */
    static final class ScheduledWorker extends Scheduler.Worker {
        volatile boolean disposed;
        final ScheduledExecutorService executor;
        final ql tasks = new ql();

        ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.executor = scheduledExecutorService;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.tasks.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            Future<?> future;
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(k22.v(runnable), this.tasks);
            this.tasks.add(scheduledRunnable);
            if (j <= 0) {
                try {
                    future = this.executor.submit((Callable) scheduledRunnable);
                } catch (RejectedExecutionException e) {
                    dispose();
                    k22.u(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.executor.schedule((Callable) scheduledRunnable, j, timeUnit);
            }
            scheduledRunnable.setFuture(future);
            return scheduledRunnable;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        SHUTDOWN = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public SingleScheduler() {
        this(SINGLE_THREAD_FACTORY);
    }

    static ScheduledExecutorService createExecutor(ThreadFactory threadFactory2) {
        return SchedulerPoolFactory.create(threadFactory2);
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new ScheduledWorker(this.executor.get());
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(k22.v(runnable));
        if (j <= 0) {
            try {
                future = this.executor.get().submit(scheduledDirectTask);
            } catch (RejectedExecutionException e) {
                k22.u(e);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.executor.get().schedule(scheduledDirectTask, j, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> future;
        Runnable v = k22.v(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.executor.get();
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(v, scheduledExecutorService);
            if (j <= 0) {
                try {
                    future = scheduledExecutorService.submit(instantPeriodicTask);
                } catch (RejectedExecutionException e) {
                    k22.u(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(instantPeriodicTask, j, timeUnit);
            }
            instantPeriodicTask.setFirst(future);
            return instantPeriodicTask;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(v);
        try {
            scheduledDirectPeriodicTask.setFuture(this.executor.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            k22.u(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        ScheduledExecutorService andSet;
        ScheduledExecutorService scheduledExecutorService = this.executor.get();
        ScheduledExecutorService scheduledExecutorService2 = SHUTDOWN;
        if (scheduledExecutorService != scheduledExecutorService2 && (andSet = this.executor.getAndSet(scheduledExecutorService2)) != scheduledExecutorService2) {
            andSet.shutdownNow();
        }
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.executor.get();
            if (scheduledExecutorService != SHUTDOWN) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = createExecutor(this.threadFactory);
            }
        } while (!this.executor.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    public SingleScheduler(ThreadFactory threadFactory2) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.executor = atomicReference;
        this.threadFactory = threadFactory2;
        atomicReference.lazySet(createExecutor(threadFactory2));
    }
}
