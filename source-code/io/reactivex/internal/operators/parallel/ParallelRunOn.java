package io.reactivex.internal.operators.parallel;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.k22;

/* compiled from: Taobao */
public final class ParallelRunOn<T> extends a<T> {
    final int prefetch;
    final Scheduler scheduler;
    final a<? extends T> source;

    /* compiled from: Taobao */
    static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final SpscArrayQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription s;
        final Scheduler.Worker worker;

        BaseRunOnSubscriber(int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker2) {
            this.prefetch = i;
            this.queue = spscArrayQueue;
            this.limit = i - (i >> 2);
            this.worker = worker2;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                this.worker.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                schedule();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                k22.u(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (!this.done) {
                if (!this.queue.offer(t)) {
                    this.s.cancel();
                    onError(new MissingBackpressureException("Queue is full?!"));
                    return;
                }
                schedule();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                schedule();
            }
        }

        /* access modifiers changed from: package-private */
        public final void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }
    }

    /* compiled from: Taobao */
    final class MultiWorkerCallback implements SchedulerMultiWorkerSupport.WorkerCallback {
        final Subscriber<T>[] parents;
        final Subscriber<? super T>[] subscribers;

        MultiWorkerCallback(Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2) {
            this.subscribers = subscriberArr;
            this.parents = subscriberArr2;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback
        public void onWorker(int i, Scheduler.Worker worker) {
            ParallelRunOn.this.createSubscriber(i, this.subscribers, this.parents, worker);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final ConditionalSubscriber<? super T> actual;

        RunOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request((long) this.prefetch);
            }
        }

        public void run() {
            int i;
            Throwable th;
            int i2 = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            int i3 = this.limit;
            int i4 = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    } else if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else {
                        boolean z = this.done;
                        if (!z || (th = this.error) == null) {
                            T poll = spscArrayQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                conditionalSubscriber.onComplete();
                                this.worker.dispose();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                if (conditionalSubscriber.tryOnNext(poll)) {
                                    j2++;
                                }
                                i2++;
                                if (i2 == i3) {
                                    this.s.request((long) i2);
                                    i2 = 0;
                                }
                            }
                        } else {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th);
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (i == 0) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            conditionalSubscriber.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (!(j2 == 0 || j == AbsPerformance.LONG_NIL)) {
                    this.requested.addAndGet(-j2);
                }
                int i5 = get();
                if (i5 == i4) {
                    this.consumed = i2;
                    i4 = addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    i4 = i5;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final Subscriber<? super T> actual;

        RunOnSubscriber(Subscriber<? super T> subscriber, int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            this.actual = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request((long) this.prefetch);
            }
        }

        public void run() {
            int i;
            Throwable th;
            int i2 = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            Subscriber<? super T> subscriber = this.actual;
            int i3 = this.limit;
            int i4 = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    } else if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else {
                        boolean z = this.done;
                        if (!z || (th = this.error) == null) {
                            T poll = spscArrayQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                subscriber.onComplete();
                                this.worker.dispose();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j2++;
                                i2++;
                                if (i2 == i3) {
                                    this.s.request((long) i2);
                                    i2 = 0;
                                }
                            }
                        } else {
                            spscArrayQueue.clear();
                            subscriber.onError(th);
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (i == 0) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            subscriber.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (!(j2 == 0 || j == AbsPerformance.LONG_NIL)) {
                    this.requested.addAndGet(-j2);
                }
                int i5 = get();
                if (i5 == i4) {
                    this.consumed = i2;
                    i4 = addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    i4 = i5;
                }
            }
        }
    }

    public ParallelRunOn(a<? extends T> aVar, Scheduler scheduler2, int i) {
        this.source = aVar;
        this.scheduler = scheduler2;
        this.prefetch = i;
    }

    /* access modifiers changed from: package-private */
    public void createSubscriber(int i, Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2, Scheduler.Worker worker) {
        Subscriber<? super T> subscriber = subscriberArr[i];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
        if (subscriber instanceof ConditionalSubscriber) {
            subscriberArr2[i] = new RunOnConditionalSubscriber((ConditionalSubscriber) subscriber, this.prefetch, spscArrayQueue, worker);
        } else {
            subscriberArr2[i] = new RunOnSubscriber(subscriber, this.prefetch, spscArrayQueue, worker);
        }
    }

    @Override // io.reactivex.parallel.a
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.a
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<T>[] subscriberArr2 = new Subscriber[length];
            Scheduler scheduler2 = this.scheduler;
            if (scheduler2 instanceof SchedulerMultiWorkerSupport) {
                ((SchedulerMultiWorkerSupport) scheduler2).createWorkers(length, new MultiWorkerCallback(subscriberArr, subscriberArr2));
            } else {
                for (int i = 0; i < length; i++) {
                    createSubscriber(i, subscriberArr, subscriberArr2, this.scheduler.createWorker());
                }
            }
            this.source.subscribe(subscriberArr2);
        }
    }
}
