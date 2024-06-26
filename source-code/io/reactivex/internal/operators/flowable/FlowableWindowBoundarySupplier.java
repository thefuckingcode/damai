package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.ff0;
import tb.k22;
import tb.x82;

/* compiled from: Taobao */
public final class FlowableWindowBoundarySupplier<T, B> extends AbstractFlowableWithUpstream<T, b<T>> {
    final int bufferSize;
    final Callable<? extends Publisher<B>> other;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class WindowBoundaryInnerSubscriber<T, B> extends io.reactivex.subscribers.b<B> {
        boolean done;
        final WindowBoundaryMainSubscriber<T, B> parent;

        WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.parent = windowBoundaryMainSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.parent.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                k22.u(th);
                return;
            }
            this.done = true;
            this.parent.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            if (!this.done) {
                this.done = true;
                cancel();
                this.parent.next();
            }
        }
    }

    /* compiled from: Taobao */
    static final class WindowBoundaryMainSubscriber<T, B> extends QueueDrainSubscriber<T, Object, b<T>> implements Subscription {
        static final Object NEXT = new Object();
        final AtomicReference<Disposable> boundary = new AtomicReference<>();
        final int bufferSize;
        final Callable<? extends Publisher<B>> other;
        Subscription s;
        UnicastProcessor<T> window;
        final AtomicLong windows;

        WindowBoundaryMainSubscriber(Subscriber<? super b<T>> subscriber, Callable<? extends Publisher<B>> callable, int i) {
            super(subscriber, new MpscLinkedQueue());
            AtomicLong atomicLong = new AtomicLong();
            this.windows = atomicLong;
            this.other = callable;
            this.bufferSize = i;
            atomicLong.lazySet(1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0008 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x0008 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [io.reactivex.processors.UnicastProcessor] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* access modifiers changed from: package-private */
        public void drainLoop() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            Subscriber<? super V> subscriber = this.actual;
            UnicastProcessor<T> unicastProcessor = this.window;
            int i = 1;
            while (true) {
                boolean z = this.done;
                U poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    DisposableHelper.dispose(this.boundary);
                    Throwable th = this.error;
                    if (th != null) {
                        unicastProcessor.onError(th);
                        return;
                    } else {
                        unicastProcessor.onComplete();
                        return;
                    }
                } else if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll == NEXT) {
                    unicastProcessor.onComplete();
                    if (this.windows.decrementAndGet() == 0) {
                        DisposableHelper.dispose(this.boundary);
                        return;
                    } else if (!this.cancelled) {
                        try {
                            Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.other.call(), "The publisher supplied is null");
                            UnicastProcessor<T> d = UnicastProcessor.d(this.bufferSize);
                            long requested = requested();
                            if (requested != 0) {
                                this.windows.getAndIncrement();
                                subscriber.onNext(d);
                                if (requested != AbsPerformance.LONG_NIL) {
                                    produced(1);
                                }
                                this.window = d;
                                WindowBoundaryInnerSubscriber windowBoundaryInnerSubscriber = new WindowBoundaryInnerSubscriber(this);
                                AtomicReference<Disposable> atomicReference = this.boundary;
                                if (atomicReference.compareAndSet(atomicReference.get(), windowBoundaryInnerSubscriber)) {
                                    publisher.subscribe(windowBoundaryInnerSubscriber);
                                }
                            } else {
                                this.cancelled = true;
                                subscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                            }
                            unicastProcessor = d;
                        } catch (Throwable th2) {
                            ff0.b(th2);
                            DisposableHelper.dispose(this.boundary);
                            subscriber.onError(th2);
                            return;
                        }
                    }
                } else {
                    unicastProcessor.onNext(NotificationLite.getValue(poll));
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void next() {
            this.queue.offer((U) NEXT);
            if (enter()) {
                drainLoop();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                if (enter()) {
                    drainLoop();
                }
                if (this.windows.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.boundary);
                }
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                k22.u(th);
                return;
            }
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            if (this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.boundary);
            }
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
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
                Subscriber<? super V> subscriber = this.actual;
                subscriber.onSubscribe(this);
                if (!this.cancelled) {
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.other.call(), "The first window publisher supplied is null");
                        UnicastProcessor<T> d = UnicastProcessor.d(this.bufferSize);
                        long requested = requested();
                        if (requested != 0) {
                            subscriber.onNext(d);
                            if (requested != AbsPerformance.LONG_NIL) {
                                produced(1);
                            }
                            this.window = d;
                            WindowBoundaryInnerSubscriber windowBoundaryInnerSubscriber = new WindowBoundaryInnerSubscriber(this);
                            if (this.boundary.compareAndSet(null, windowBoundaryInnerSubscriber)) {
                                this.windows.getAndIncrement();
                                subscription.request(AbsPerformance.LONG_NIL);
                                publisher.subscribe(windowBoundaryInnerSubscriber);
                                return;
                            }
                            return;
                        }
                        subscription.cancel();
                        subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests"));
                    } catch (Throwable th) {
                        ff0.b(th);
                        subscription.cancel();
                        subscriber.onError(th);
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }
    }

    public FlowableWindowBoundarySupplier(b<T> bVar, Callable<? extends Publisher<B>> callable, int i) {
        super(bVar);
        this.other = callable;
        this.bufferSize = i;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super b<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber) new WindowBoundaryMainSubscriber(new x82(subscriber), this.other, this.bufferSize));
    }
}
