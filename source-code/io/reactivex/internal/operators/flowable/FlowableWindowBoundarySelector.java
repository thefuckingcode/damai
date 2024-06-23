package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.k22;
import tb.ql;
import tb.x82;

/* compiled from: Taobao */
public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractFlowableWithUpstream<T, b<T>> {
    final int bufferSize;
    final Function<? super B, ? extends Publisher<V>> close;
    final Publisher<B> open;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class OperatorWindowBoundaryCloseSubscriber<T, V> extends io.reactivex.subscribers.b<V> {
        boolean done;
        final WindowBoundaryMainSubscriber<T, ?, V> parent;
        final UnicastProcessor<T> w;

        OperatorWindowBoundaryCloseSubscriber(WindowBoundaryMainSubscriber<T, ?, V> windowBoundaryMainSubscriber, UnicastProcessor<T> unicastProcessor) {
            this.parent = windowBoundaryMainSubscriber;
            this.w = unicastProcessor;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.parent.close(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                k22.u(th);
                return;
            }
            this.done = true;
            this.parent.error(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(V v) {
            if (!this.done) {
                this.done = true;
                cancel();
                this.parent.close(this);
            }
        }
    }

    /* compiled from: Taobao */
    static final class OperatorWindowBoundaryOpenSubscriber<T, B> extends io.reactivex.subscribers.b<B> {
        boolean done;
        final WindowBoundaryMainSubscriber<T, B, ?> parent;

        OperatorWindowBoundaryOpenSubscriber(WindowBoundaryMainSubscriber<T, B, ?> windowBoundaryMainSubscriber) {
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
            this.parent.error(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            if (!this.done) {
                this.parent.open(b);
            }
        }
    }

    /* compiled from: Taobao */
    static final class WindowBoundaryMainSubscriber<T, B, V> extends QueueDrainSubscriber<T, Object, b<T>> implements Subscription {
        final AtomicReference<Disposable> boundary = new AtomicReference<>();
        final int bufferSize;
        final Function<? super B, ? extends Publisher<V>> close;
        final Publisher<B> open;
        final ql resources;
        Subscription s;
        final AtomicLong windows;
        final List<UnicastProcessor<T>> ws;

        WindowBoundaryMainSubscriber(Subscriber<? super b<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
            super(subscriber, new MpscLinkedQueue());
            AtomicLong atomicLong = new AtomicLong();
            this.windows = atomicLong;
            this.open = publisher;
            this.close = function;
            this.bufferSize = i;
            this.resources = new ql();
            this.ws = new ArrayList();
            atomicLong.lazySet(1);
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public boolean accept(Subscriber<? super b<T>> subscriber, Object obj) {
            return false;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        /* access modifiers changed from: package-private */
        public void close(OperatorWindowBoundaryCloseSubscriber<T, V> operatorWindowBoundaryCloseSubscriber) {
            this.resources.delete(operatorWindowBoundaryCloseSubscriber);
            this.queue.offer((U) new WindowOperation(operatorWindowBoundaryCloseSubscriber.w, null));
            if (enter()) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        public void dispose() {
            this.resources.dispose();
            DisposableHelper.dispose(this.boundary);
        }

        /* access modifiers changed from: package-private */
        public void drainLoop() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            Subscriber<? super V> subscriber = this.actual;
            List<UnicastProcessor<T>> list = this.ws;
            int i = 1;
            while (true) {
                boolean z = this.done;
                U poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    dispose();
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
                    return;
                } else if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll instanceof WindowOperation) {
                    U u = poll;
                    UnicastProcessor<T> unicastProcessor3 = u.w;
                    if (unicastProcessor3 != null) {
                        if (list.remove(unicastProcessor3)) {
                            u.w.onComplete();
                            if (this.windows.decrementAndGet() == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.cancelled) {
                        UnicastProcessor<T> d = UnicastProcessor.d(this.bufferSize);
                        long requested = requested();
                        if (requested != 0) {
                            list.add(d);
                            subscriber.onNext(d);
                            if (requested != AbsPerformance.LONG_NIL) {
                                produced(1);
                            }
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.close.apply(u.open), "The publisher supplied is null");
                                OperatorWindowBoundaryCloseSubscriber operatorWindowBoundaryCloseSubscriber = new OperatorWindowBoundaryCloseSubscriber(this, d);
                                if (this.resources.add(operatorWindowBoundaryCloseSubscriber)) {
                                    this.windows.getAndIncrement();
                                    publisher.subscribe(operatorWindowBoundaryCloseSubscriber);
                                }
                            } catch (Throwable th2) {
                                this.cancelled = true;
                                subscriber.onError(th2);
                            }
                        } else {
                            this.cancelled = true;
                            subscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    for (UnicastProcessor<T> unicastProcessor4 : list) {
                        unicastProcessor4.onNext((T) NotificationLite.getValue(poll));
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void error(Throwable th) {
            this.s.cancel();
            this.resources.dispose();
            DisposableHelper.dispose(this.boundary);
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                if (enter()) {
                    drainLoop();
                }
                if (this.windows.decrementAndGet() == 0) {
                    this.resources.dispose();
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
                this.resources.dispose();
            }
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                if (fastEnter()) {
                    for (UnicastProcessor<T> unicastProcessor : this.ws) {
                        unicastProcessor.onNext(t);
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
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                if (!this.cancelled) {
                    OperatorWindowBoundaryOpenSubscriber operatorWindowBoundaryOpenSubscriber = new OperatorWindowBoundaryOpenSubscriber(this);
                    if (this.boundary.compareAndSet(null, operatorWindowBoundaryOpenSubscriber)) {
                        this.windows.getAndIncrement();
                        subscription.request(AbsPerformance.LONG_NIL);
                        this.open.subscribe(operatorWindowBoundaryOpenSubscriber);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void open(B b) {
            this.queue.offer((U) new WindowOperation(null, b));
            if (enter()) {
                drainLoop();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class WindowOperation<T, B> {
        final B open;
        final UnicastProcessor<T> w;

        WindowOperation(UnicastProcessor<T> unicastProcessor, B b) {
            this.w = unicastProcessor;
            this.open = b;
        }
    }

    public FlowableWindowBoundarySelector(b<T> bVar, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
        super(bVar);
        this.open = publisher;
        this.close = function;
        this.bufferSize = i;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super b<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber) new WindowBoundaryMainSubscriber(new x82(subscriber), this.open, this.close, this.bufferSize));
    }
}
