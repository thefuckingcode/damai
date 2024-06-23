package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.x82;

/* compiled from: Taobao */
public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, b<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    /* compiled from: Taobao */
    static final class WindowExactBoundedSubscriber<T> extends QueueDrainSubscriber<T, Object, b<T>> implements Subscription {
        final int bufferSize;
        long count;
        final long maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        Subscription s;
        final Scheduler scheduler;
        volatile boolean terminated;
        final SequentialDisposable timer = new SequentialDisposable();
        final long timespan;
        final TimeUnit unit;
        UnicastProcessor<T> window;
        final Scheduler.Worker worker;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public static final class ConsumerIndexHolder implements Runnable {
            final long index;
            final WindowExactBoundedSubscriber<?> parent;

            ConsumerIndexHolder(long j, WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber) {
                this.index = j;
                this.parent = windowExactBoundedSubscriber;
            }

            public void run() {
                WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber = this.parent;
                if (!((QueueDrainSubscriber) windowExactBoundedSubscriber).cancelled) {
                    ((QueueDrainSubscriber) windowExactBoundedSubscriber).queue.offer(this);
                } else {
                    windowExactBoundedSubscriber.terminated = true;
                    windowExactBoundedSubscriber.dispose();
                }
                if (windowExactBoundedSubscriber.enter()) {
                    windowExactBoundedSubscriber.drainLoop();
                }
            }
        }

        WindowExactBoundedSubscriber(Subscriber<? super b<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler2, int i, long j2, boolean z) {
            super(subscriber, new MpscLinkedQueue());
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.bufferSize = i;
            this.maxSize = j2;
            this.restartTimerOnMaxSize = z;
            if (z) {
                this.worker = scheduler2.createWorker();
            } else {
                this.worker = null;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        public void dispose() {
            DisposableHelper.dispose(this.timer);
            Scheduler.Worker worker2 = this.worker;
            if (worker2 != null) {
                worker2.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void drainLoop() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            Subscriber<? super V> subscriber = this.actual;
            UnicastProcessor<T> unicastProcessor = this.window;
            int i = 1;
            while (!this.terminated) {
                boolean z = this.done;
                U poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof ConsumerIndexHolder;
                if (z && (z2 || z3)) {
                    this.window = null;
                    simplePlainQueue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        unicastProcessor.onError(th);
                    } else {
                        unicastProcessor.onComplete();
                    }
                    dispose();
                    return;
                } else if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    if (z3) {
                        U u = poll;
                        if (this.restartTimerOnMaxSize || this.producerIndex == u.index) {
                            unicastProcessor.onComplete();
                            this.count = 0;
                            unicastProcessor = UnicastProcessor.d(this.bufferSize);
                            this.window = unicastProcessor;
                            long requested = requested();
                            if (requested != 0) {
                                subscriber.onNext(unicastProcessor);
                                if (requested != AbsPerformance.LONG_NIL) {
                                    produced(1);
                                }
                            } else {
                                this.window = null;
                                this.queue.clear();
                                this.s.cancel();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                dispose();
                                return;
                            }
                        }
                    } else {
                        unicastProcessor.onNext(NotificationLite.getValue(poll));
                        long j = this.count + 1;
                        if (j >= this.maxSize) {
                            this.producerIndex++;
                            this.count = 0;
                            unicastProcessor.onComplete();
                            long requested2 = requested();
                            if (requested2 != 0) {
                                UnicastProcessor<T> d = UnicastProcessor.d(this.bufferSize);
                                this.window = d;
                                this.actual.onNext(d);
                                if (requested2 != AbsPerformance.LONG_NIL) {
                                    produced(1);
                                }
                                if (this.restartTimerOnMaxSize) {
                                    Disposable disposable = (Disposable) this.timer.get();
                                    disposable.dispose();
                                    Scheduler.Worker worker2 = this.worker;
                                    ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                                    long j2 = this.timespan;
                                    Disposable schedulePeriodically = worker2.schedulePeriodically(consumerIndexHolder, j2, j2, this.unit);
                                    if (!this.timer.compareAndSet(disposable, schedulePeriodically)) {
                                        schedulePeriodically.dispose();
                                    }
                                }
                                unicastProcessor = d;
                            } else {
                                this.window = null;
                                this.s.cancel();
                                this.actual.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                                dispose();
                                return;
                            }
                        } else {
                            this.count = j;
                        }
                    }
                    i = i;
                }
            }
            this.s.cancel();
            simplePlainQueue.clear();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.terminated) {
                if (fastEnter()) {
                    UnicastProcessor<T> unicastProcessor = this.window;
                    unicastProcessor.onNext(t);
                    long j = this.count + 1;
                    if (j >= this.maxSize) {
                        this.producerIndex++;
                        this.count = 0;
                        unicastProcessor.onComplete();
                        long requested = requested();
                        if (requested != 0) {
                            UnicastProcessor<T> d = UnicastProcessor.d(this.bufferSize);
                            this.window = d;
                            this.actual.onNext(d);
                            if (requested != AbsPerformance.LONG_NIL) {
                                produced(1);
                            }
                            if (this.restartTimerOnMaxSize) {
                                Disposable disposable = (Disposable) this.timer.get();
                                disposable.dispose();
                                Scheduler.Worker worker2 = this.worker;
                                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                                long j2 = this.timespan;
                                Disposable schedulePeriodically = worker2.schedulePeriodically(consumerIndexHolder, j2, j2, this.unit);
                                if (!this.timer.compareAndSet(disposable, schedulePeriodically)) {
                                    schedulePeriodically.dispose();
                                }
                            }
                        } else {
                            this.window = null;
                            this.s.cancel();
                            this.actual.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                            dispose();
                            return;
                        }
                    } else {
                        this.count = j;
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.queue.offer((U) NotificationLite.next(t));
                    if (!enter()) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Disposable disposable;
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                Subscriber<? super V> subscriber = this.actual;
                subscriber.onSubscribe(this);
                if (!this.cancelled) {
                    UnicastProcessor<T> d = UnicastProcessor.d(this.bufferSize);
                    this.window = d;
                    long requested = requested();
                    if (requested != 0) {
                        subscriber.onNext(d);
                        if (requested != AbsPerformance.LONG_NIL) {
                            produced(1);
                        }
                        ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                        if (this.restartTimerOnMaxSize) {
                            Scheduler.Worker worker2 = this.worker;
                            long j = this.timespan;
                            disposable = worker2.schedulePeriodically(consumerIndexHolder, j, j, this.unit);
                        } else {
                            Scheduler scheduler2 = this.scheduler;
                            long j2 = this.timespan;
                            disposable = scheduler2.schedulePeriodicallyDirect(consumerIndexHolder, j2, j2, this.unit);
                        }
                        if (this.timer.replace(disposable)) {
                            subscription.request(AbsPerformance.LONG_NIL);
                            return;
                        }
                        return;
                    }
                    this.cancelled = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }
    }

    /* compiled from: Taobao */
    static final class WindowExactUnboundedSubscriber<T> extends QueueDrainSubscriber<T, Object, b<T>> implements FlowableSubscriber<T>, Subscription {
        static final Object NEXT = new Object();
        final int bufferSize;
        Subscription s;
        final Scheduler scheduler;
        volatile boolean terminated;
        final SequentialDisposable timer = new SequentialDisposable();
        final long timespan;
        final TimeUnit unit;
        UnicastProcessor<T> window;

        WindowExactUnboundedSubscriber(Subscriber<? super b<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler2, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.bufferSize = i;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        public void dispose() {
            DisposableHelper.dispose(this.timer);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: io.reactivex.processors.UnicastProcessor */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public void drainLoop() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            Subscriber<? super V> subscriber = this.actual;
            UnicastProcessor<T> unicastProcessor = this.window;
            int i = 1;
            while (true) {
                boolean z = this.terminated;
                boolean z2 = this.done;
                U poll = simplePlainQueue.poll();
                if (!z2 || !(poll == null || poll == NEXT)) {
                    if (poll == null) {
                        i = leave(-i);
                        if (i == 0) {
                            return;
                        }
                    } else if (poll == NEXT) {
                        unicastProcessor.onComplete();
                        if (!z) {
                            unicastProcessor = (UnicastProcessor<T>) UnicastProcessor.d(this.bufferSize);
                            this.window = unicastProcessor;
                            long requested = requested();
                            if (requested != 0) {
                                subscriber.onNext(unicastProcessor);
                                if (requested != AbsPerformance.LONG_NIL) {
                                    produced(1);
                                }
                            } else {
                                this.window = null;
                                this.queue.clear();
                                this.s.cancel();
                                dispose();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                return;
                            }
                        } else {
                            this.s.cancel();
                        }
                    } else {
                        unicastProcessor.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
            this.window = null;
            simplePlainQueue.clear();
            dispose();
            Throwable th = this.error;
            if (th != null) {
                unicastProcessor.onError(th);
            } else {
                unicastProcessor.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.terminated) {
                if (fastEnter()) {
                    this.window.onNext(t);
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.queue.offer((U) NotificationLite.next(t));
                    if (!enter()) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.window = UnicastProcessor.d(this.bufferSize);
                Subscriber<? super V> subscriber = this.actual;
                subscriber.onSubscribe(this);
                long requested = requested();
                if (requested != 0) {
                    subscriber.onNext(this.window);
                    if (requested != AbsPerformance.LONG_NIL) {
                        produced(1);
                    }
                    if (!this.cancelled) {
                        SequentialDisposable sequentialDisposable = this.timer;
                        Scheduler scheduler2 = this.scheduler;
                        long j = this.timespan;
                        if (sequentialDisposable.replace(scheduler2.schedulePeriodicallyDirect(this, j, j, this.unit))) {
                            subscription.request(AbsPerformance.LONG_NIL);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.cancelled = true;
                subscription.cancel();
                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        public void run() {
            if (this.cancelled) {
                this.terminated = true;
                dispose();
            }
            this.queue.offer((U) NEXT);
            if (enter()) {
                drainLoop();
            }
        }
    }

    /* compiled from: Taobao */
    static final class WindowSkipSubscriber<T> extends QueueDrainSubscriber<T, Object, b<T>> implements Subscription, Runnable {
        final int bufferSize;
        Subscription s;
        volatile boolean terminated;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        final List<UnicastProcessor<T>> windows = new LinkedList();
        final Scheduler.Worker worker;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public final class Completion implements Runnable {
            private final UnicastProcessor<T> processor;

            Completion(UnicastProcessor<T> unicastProcessor) {
                this.processor = unicastProcessor;
            }

            public void run() {
                WindowSkipSubscriber.this.complete(this.processor);
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public static final class SubjectWork<T> {
            final boolean open;
            final UnicastProcessor<T> w;

            SubjectWork(UnicastProcessor<T> unicastProcessor, boolean z) {
                this.w = unicastProcessor;
                this.open = z;
            }
        }

        WindowSkipSubscriber(Subscriber<? super b<T>> subscriber, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker2, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.timespan = j;
            this.timeskip = j2;
            this.unit = timeUnit;
            this.worker = worker2;
            this.bufferSize = i;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        /* access modifiers changed from: package-private */
        public void complete(UnicastProcessor<T> unicastProcessor) {
            this.queue.offer((U) new SubjectWork(unicastProcessor, false));
            if (enter()) {
                drainLoop();
            }
        }

        public void dispose() {
            this.worker.dispose();
        }

        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
        /* access modifiers changed from: package-private */
        public void drainLoop() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            Subscriber<? super V> subscriber = this.actual;
            List<UnicastProcessor<T>> list = this.windows;
            int i = 1;
            while (!this.terminated) {
                boolean z = this.done;
                U poll = simplePlainQueue.poll();
                boolean z2 = poll == 0;
                boolean z3 = poll instanceof SubjectWork;
                if (z && (z2 || z3)) {
                    simplePlainQueue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        for (UnicastProcessor<T> unicastProcessor : list) {
                            unicastProcessor.onError(th);
                        }
                    } else {
                        for (UnicastProcessor<T> unicastProcessor2 : list) {
                            unicastProcessor2.onComplete();
                        }
                    }
                    list.clear();
                    dispose();
                    return;
                } else if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    U u = poll;
                    if (!u.open) {
                        list.remove(u.w);
                        u.w.onComplete();
                        if (list.isEmpty() && this.cancelled) {
                            this.terminated = true;
                        }
                    } else if (!this.cancelled) {
                        long requested = requested();
                        if (requested != 0) {
                            UnicastProcessor<T> d = UnicastProcessor.d(this.bufferSize);
                            list.add(d);
                            subscriber.onNext(d);
                            if (requested != AbsPerformance.LONG_NIL) {
                                produced(1);
                            }
                            this.worker.schedule(new Completion(d), this.timespan, this.unit);
                        } else {
                            subscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    for (UnicastProcessor<T> unicastProcessor3 : list) {
                        unicastProcessor3.onNext(poll);
                    }
                }
            }
            this.s.cancel();
            dispose();
            simplePlainQueue.clear();
            list.clear();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (fastEnter()) {
                for (UnicastProcessor<T> unicastProcessor : this.windows) {
                    unicastProcessor.onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t);
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                if (!this.cancelled) {
                    long requested = requested();
                    if (requested != 0) {
                        UnicastProcessor<T> d = UnicastProcessor.d(this.bufferSize);
                        this.windows.add(d);
                        this.actual.onNext(d);
                        if (requested != AbsPerformance.LONG_NIL) {
                            produced(1);
                        }
                        this.worker.schedule(new Completion(d), this.timespan, this.unit);
                        Scheduler.Worker worker2 = this.worker;
                        long j = this.timeskip;
                        worker2.schedulePeriodically(this, j, j, this.unit);
                        subscription.request(AbsPerformance.LONG_NIL);
                        return;
                    }
                    subscription.cancel();
                    this.actual.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastProcessor.d(this.bufferSize), true);
            if (!this.cancelled) {
                this.queue.offer(subjectWork);
            }
            if (enter()) {
                drainLoop();
            }
        }
    }

    public FlowableWindowTimed(b<T> bVar, long j, long j2, TimeUnit timeUnit, Scheduler scheduler2, long j3, int i, boolean z) {
        super(bVar);
        this.timespan = j;
        this.timeskip = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.maxSize = j3;
        this.bufferSize = i;
        this.restartTimerOnMaxSize = z;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super b<T>> subscriber) {
        x82 x82 = new x82(subscriber);
        long j = this.timespan;
        long j2 = this.timeskip;
        if (j == j2) {
            long j3 = this.maxSize;
            if (j3 == AbsPerformance.LONG_NIL) {
                this.source.subscribe((FlowableSubscriber) new WindowExactUnboundedSubscriber(x82, this.timespan, this.unit, this.scheduler, this.bufferSize));
            } else {
                this.source.subscribe((FlowableSubscriber) new WindowExactBoundedSubscriber(x82, j, this.unit, this.scheduler, this.bufferSize, j3, this.restartTimerOnMaxSize));
            }
        } else {
            this.source.subscribe((FlowableSubscriber) new WindowSkipSubscriber(x82, j, j2, this.unit, this.scheduler.createWorker(), this.bufferSize));
        }
    }
}
