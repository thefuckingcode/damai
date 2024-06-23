package io.reactivex.internal.schedulers;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.a;
import io.reactivex.functions.Function;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tb.ff0;
import tb.jl0;

@Experimental
/* compiled from: Taobao */
public class SchedulerWhen extends Scheduler implements Disposable {
    static final Disposable DISPOSED = a.a();
    static final Disposable SUBSCRIBED = new SubscribedDisposable();
    private final Scheduler actualScheduler;
    private Disposable disposable;
    private final jl0<b<io.reactivex.a>> workerProcessor;

    /* compiled from: Taobao */
    static final class CreateWorkerFunction implements Function<ScheduledAction, io.reactivex.a> {
        final Scheduler.Worker actualWorker;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public final class WorkerCompletable extends io.reactivex.a {
            final ScheduledAction action;

            WorkerCompletable(ScheduledAction scheduledAction) {
                this.action = scheduledAction;
            }

            /* access modifiers changed from: protected */
            @Override // io.reactivex.a
            public void subscribeActual(CompletableObserver completableObserver) {
                completableObserver.onSubscribe(this.action);
                this.action.call(CreateWorkerFunction.this.actualWorker, completableObserver);
            }
        }

        CreateWorkerFunction(Scheduler.Worker worker) {
            this.actualWorker = worker;
        }

        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new WorkerCompletable(scheduledAction);
        }
    }

    /* compiled from: Taobao */
    static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        DelayedAction(Runnable runnable, long j, TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.schedule(new OnCompletedAction(this.action, completableObserver), this.delayTime, this.unit);
        }
    }

    /* compiled from: Taobao */
    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.schedule(new OnCompletedAction(this.action, completableObserver));
        }
    }

    /* compiled from: Taobao */
    static class OnCompletedAction implements Runnable {
        final Runnable action;
        final CompletableObserver actionCompletable;

        OnCompletedAction(Runnable runnable, CompletableObserver completableObserver) {
            this.action = runnable;
            this.actionCompletable = completableObserver;
        }

        public void run() {
            try {
                this.action.run();
            } finally {
                this.actionCompletable.onComplete();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        ScheduledAction() {
            super(SchedulerWhen.SUBSCRIBED);
        }

        /* access modifiers changed from: package-private */
        public void call(Scheduler.Worker worker, CompletableObserver completableObserver) {
            Disposable disposable;
            Disposable disposable2 = (Disposable) get();
            if (disposable2 != SchedulerWhen.DISPOSED && disposable2 == (disposable = SchedulerWhen.SUBSCRIBED)) {
                Disposable callActual = callActual(worker, completableObserver);
                if (!compareAndSet(disposable, callActual)) {
                    callActual.dispose();
                }
            }
        }

        /* access modifiers changed from: protected */
        public abstract Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver);

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable;
            Disposable disposable2 = SchedulerWhen.DISPOSED;
            do {
                disposable = (Disposable) get();
                if (disposable == SchedulerWhen.DISPOSED) {
                    return;
                }
            } while (!compareAndSet(disposable, disposable2));
            if (disposable != SchedulerWhen.SUBSCRIBED) {
                disposable.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return ((Disposable) get()).isDisposed();
        }
    }

    /* compiled from: Taobao */
    static final class SubscribedDisposable implements Disposable {
        SubscribedDisposable() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }
    }

    public SchedulerWhen(Function<b<b<io.reactivex.a>>, io.reactivex.a> function, Scheduler scheduler) {
        this.actualScheduler = scheduler;
        jl0<b<io.reactivex.a>> a = UnicastProcessor.c().a();
        this.workerProcessor = a;
        try {
            this.disposable = function.apply(a).subscribe();
        } catch (Throwable th) {
            ff0.a(th);
        }
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        Scheduler.Worker createWorker = this.actualScheduler.createWorker();
        jl0 a = UnicastProcessor.c().a();
        b<io.reactivex.a> map = a.map(new CreateWorkerFunction(createWorker));
        QueueWorker queueWorker = new QueueWorker(a, createWorker);
        this.workerProcessor.onNext(map);
        return queueWorker;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.disposable.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposable.isDisposed();
    }

    /* compiled from: Taobao */
    static final class QueueWorker extends Scheduler.Worker {
        private final jl0<ScheduledAction> actionProcessor;
        private final Scheduler.Worker actualWorker;
        private final AtomicBoolean unsubscribed = new AtomicBoolean();

        QueueWorker(jl0<ScheduledAction> jl0, Scheduler.Worker worker) {
            this.actionProcessor = jl0;
            this.actualWorker = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.unsubscribed.compareAndSet(false, true)) {
                this.actionProcessor.onComplete();
                this.actualWorker.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.unsubscribed.get();
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.actionProcessor.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.actionProcessor.onNext(immediateAction);
            return immediateAction;
        }
    }
}
