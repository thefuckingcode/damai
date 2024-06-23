package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.k22;

/* compiled from: Taobao */
public final class FlowableTimeoutTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends T> other;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    /* compiled from: Taobao */
    static final class FallbackSubscriber<T> implements FlowableSubscriber<T> {
        final Subscriber<? super T> actual;
        final SubscriptionArbiter arbiter;

        FallbackSubscriber(Subscriber<? super T> subscriber, SubscriptionArbiter subscriptionArbiter) {
            this.actual = subscriber;
            this.arbiter = subscriptionArbiter;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.arbiter.setSubscription(subscription);
        }
    }

    /* compiled from: Taobao */
    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Subscriber<? super T> actual;
        long consumed;
        Publisher<? extends T> fallback;
        final AtomicLong index = new AtomicLong();
        final SequentialDisposable task = new SequentialDisposable();
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        final Scheduler.Worker worker;

        TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker2, Publisher<? extends T> publisher) {
            this.actual = subscriber;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = worker2;
            this.fallback = publisher;
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.index.getAndSet(AbsPerformance.LONG_NIL) != AbsPerformance.LONG_NIL) {
                this.task.dispose();
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.index.getAndSet(AbsPerformance.LONG_NIL) != AbsPerformance.LONG_NIL) {
                this.task.dispose();
                this.actual.onError(th);
                this.worker.dispose();
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
                    ((Disposable) this.task.get()).dispose();
                    this.consumed++;
                    this.actual.onNext(t);
                    startTimeout(j2);
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
                long j2 = this.consumed;
                if (j2 != 0) {
                    produced(j2);
                }
                Publisher<? extends T> publisher = this.fallback;
                this.fallback = null;
                publisher.subscribe(new FallbackSubscriber(this.actual, this));
                this.worker.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void startTimeout(long j) {
            this.task.replace(this.worker.schedule(new TimeoutTask(j, this), this.timeout, this.unit));
        }
    }

    /* compiled from: Taobao */
    static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Subscriber<? super T> actual;
        final AtomicLong requested = new AtomicLong();
        final SequentialDisposable task = new SequentialDisposable();
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        final Scheduler.Worker worker;

        TimeoutSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker2) {
            this.actual = subscriber;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = worker2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (getAndSet(AbsPerformance.LONG_NIL) != AbsPerformance.LONG_NIL) {
                this.task.dispose();
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (getAndSet(AbsPerformance.LONG_NIL) != AbsPerformance.LONG_NIL) {
                this.task.dispose();
                this.actual.onError(th);
                this.worker.dispose();
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
                    ((Disposable) this.task.get()).dispose();
                    this.actual.onNext(t);
                    startTimeout(j2);
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
                this.worker.dispose();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        /* access modifiers changed from: package-private */
        public void startTimeout(long j) {
            this.task.replace(this.worker.schedule(new TimeoutTask(j, this), this.timeout, this.unit));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface TimeoutSupport {
        void onTimeout(long j);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class TimeoutTask implements Runnable {
        final long idx;
        final TimeoutSupport parent;

        TimeoutTask(long j, TimeoutSupport timeoutSupport) {
            this.idx = j;
            this.parent = timeoutSupport;
        }

        public void run() {
            this.parent.onTimeout(this.idx);
        }
    }

    public FlowableTimeoutTimed(b<T> bVar, long j, TimeUnit timeUnit, Scheduler scheduler2, Publisher<? extends T> publisher) {
        super(bVar);
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.other = publisher;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.other == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.timeout, this.unit, this.scheduler.createWorker());
            subscriber.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.startTimeout(0);
            this.source.subscribe((FlowableSubscriber) timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(subscriber, this.timeout, this.unit, this.scheduler.createWorker(), this.other);
        subscriber.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.startTimeout(0);
        this.source.subscribe((FlowableSubscriber) timeoutFallbackSubscriber);
    }
}
