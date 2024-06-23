package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class FlowableTimeout<T, U, V> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<U> firstTimeoutIndicator;
    final Function<? super T, ? extends Publisher<V>> itemTimeoutIndicator;
    final Publisher<? extends T> other;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class TimeoutConsumer extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final TimeoutSelectorSupport parent;

        TimeoutConsumer(long j, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.idx = j;
            this.parent = timeoutSelectorSupport;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled((Subscription) get());
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.reactivex.internal.operators.flowable.FlowableTimeout$TimeoutConsumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.parent.onTimeout(this.idx);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.reactivex.internal.operators.flowable.FlowableTimeout$TimeoutConsumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.parent.onTimeoutError(this.idx, th);
                return;
            }
            k22.u(th);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.internal.operators.flowable.FlowableTimeout$TimeoutConsumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                lazySet(subscriptionHelper);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                subscription.request(AbsPerformance.LONG_NIL);
            }
        }
    }

    /* compiled from: Taobao */
    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Subscriber<? super T> actual;
        long consumed;
        Publisher<? extends T> fallback;
        final AtomicLong index;
        final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<Subscription> upstream = new AtomicReference<>();

        TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function, Publisher<? extends T> publisher) {
            this.actual = subscriber;
            this.itemTimeoutIndicator = function;
            this.fallback = publisher;
            this.index = new AtomicLong();
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.task.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.index.getAndSet(AbsPerformance.LONG_NIL) != AbsPerformance.LONG_NIL) {
                this.task.dispose();
                this.actual.onComplete();
                this.task.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.index.getAndSet(AbsPerformance.LONG_NIL) != AbsPerformance.LONG_NIL) {
                this.task.dispose();
                this.actual.onError(th);
                this.task.dispose();
                return;
            }
            k22.u(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.index.get();
            if (j != AbsPerformance.LONG_NIL) {
                long j2 = j + 1;
                if (this.index.compareAndSet(j, j2)) {
                    Disposable disposable = (Disposable) this.task.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.consumed++;
                    this.actual.onNext(t);
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (this.task.replace(timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        ff0.b(th);
                        this.upstream.get().cancel();
                        this.index.getAndSet(AbsPerformance.LONG_NIL);
                        this.actual.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                setSubscription(subscription);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void onTimeout(long j) {
            if (this.index.compareAndSet(j, AbsPerformance.LONG_NIL)) {
                SubscriptionHelper.cancel(this.upstream);
                Publisher<? extends T> publisher = this.fallback;
                this.fallback = null;
                long j2 = this.consumed;
                if (j2 != 0) {
                    produced(j2);
                }
                publisher.subscribe(new FlowableTimeoutTimed.FallbackSubscriber(this.actual, this));
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSelectorSupport
        public void onTimeoutError(long j, Throwable th) {
            if (this.index.compareAndSet(j, AbsPerformance.LONG_NIL)) {
                SubscriptionHelper.cancel(this.upstream);
                this.actual.onError(th);
                return;
            }
            k22.u(th);
        }

        /* access modifiers changed from: package-private */
        public void startFirstTimeout(Publisher<?> publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.task.replace(timeoutConsumer)) {
                    publisher.subscribe(timeoutConsumer);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface TimeoutSelectorSupport extends FlowableTimeoutTimed.TimeoutSupport {
        void onTimeoutError(long j, Throwable th);
    }

    /* compiled from: Taobao */
    static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Subscriber<? super T> actual;
        final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
        final AtomicLong requested = new AtomicLong();
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<Subscription> upstream = new AtomicReference<>();

        TimeoutSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function) {
            this.actual = subscriber;
            this.itemTimeoutIndicator = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.task.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (getAndSet(AbsPerformance.LONG_NIL) != AbsPerformance.LONG_NIL) {
                this.task.dispose();
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (getAndSet(AbsPerformance.LONG_NIL) != AbsPerformance.LONG_NIL) {
                this.task.dispose();
                this.actual.onError(th);
                return;
            }
            k22.u(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = get();
            if (j != AbsPerformance.LONG_NIL) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    Disposable disposable = (Disposable) this.task.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.actual.onNext(t);
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (this.task.replace(timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        ff0.b(th);
                        this.upstream.get().cancel();
                        getAndSet(AbsPerformance.LONG_NIL);
                        this.actual.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void onTimeout(long j) {
            if (compareAndSet(j, AbsPerformance.LONG_NIL)) {
                SubscriptionHelper.cancel(this.upstream);
                this.actual.onError(new TimeoutException());
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSelectorSupport
        public void onTimeoutError(long j, Throwable th) {
            if (compareAndSet(j, AbsPerformance.LONG_NIL)) {
                SubscriptionHelper.cancel(this.upstream);
                this.actual.onError(th);
                return;
            }
            k22.u(th);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        /* access modifiers changed from: package-private */
        public void startFirstTimeout(Publisher<?> publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.task.replace(timeoutConsumer)) {
                    publisher.subscribe(timeoutConsumer);
                }
            }
        }
    }

    public FlowableTimeout(b<T> bVar, Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        super(bVar);
        this.firstTimeoutIndicator = publisher;
        this.itemTimeoutIndicator = function;
        this.other = publisher2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.other == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.itemTimeoutIndicator);
            subscriber.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.startFirstTimeout(this.firstTimeoutIndicator);
            this.source.subscribe((FlowableSubscriber) timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(subscriber, this.itemTimeoutIndicator, this.other);
        subscriber.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.startFirstTimeout(this.firstTimeoutIndicator);
        this.source.subscribe((FlowableSubscriber) timeoutFallbackSubscriber);
    }
}
