package io.reactivex.processors;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Nullable;
import io.reactivex.b;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.jl0;
import tb.k22;

/* compiled from: Taobao */
public final class UnicastProcessor<T> extends jl0<T> {
    final SpscLinkedArrayQueue<T> a;
    final AtomicReference<Runnable> b;
    final boolean c;
    volatile boolean d;
    Throwable e;
    final AtomicReference<Subscriber<? super T>> f;
    volatile boolean g;
    final AtomicBoolean h;
    final BasicIntQueueSubscription<T> i;
    final AtomicLong j;
    boolean k;

    /* compiled from: Taobao */
    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!UnicastProcessor.this.g) {
                UnicastProcessor.this.g = true;
                UnicastProcessor.this.f();
                UnicastProcessor unicastProcessor = UnicastProcessor.this;
                if (!unicastProcessor.k && unicastProcessor.i.getAndIncrement() == 0) {
                    UnicastProcessor.this.a.clear();
                    UnicastProcessor.this.f.lazySet(null);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastProcessor.this.a.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastProcessor.this.a.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            return UnicastProcessor.this.a.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(UnicastProcessor.this.j, j);
                UnicastProcessor.this.drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.k = true;
            return 2;
        }
    }

    UnicastProcessor(int i2) {
        this(i2, null, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> c() {
        return new UnicastProcessor<>(b.bufferSize());
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> d(int i2) {
        return new UnicastProcessor<>(i2);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> e(int i2, Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i2, runnable);
    }

    /* access modifiers changed from: package-private */
    public boolean b(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.g) {
            spscLinkedArrayQueue.clear();
            this.f.lazySet(null);
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (z && this.e != null) {
                spscLinkedArrayQueue.clear();
                this.f.lazySet(null);
                subscriber.onError(this.e);
                return true;
            } else if (!z3) {
                return false;
            } else {
                Throwable th = this.e;
                this.f.lazySet(null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void drain() {
        if (this.i.getAndIncrement() == 0) {
            int i2 = 1;
            Subscriber<? super T> subscriber = this.f.get();
            while (subscriber == null) {
                i2 = this.i.addAndGet(-i2);
                if (i2 != 0) {
                    subscriber = this.f.get();
                } else {
                    return;
                }
            }
            if (this.k) {
                g(subscriber);
            } else {
                h(subscriber);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        Runnable runnable = this.b.get();
        if (runnable != null && this.b.compareAndSet(runnable, null)) {
            runnable.run();
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.a;
        int i2 = 1;
        boolean z = !this.c;
        while (!this.g) {
            boolean z2 = this.d;
            if (!z || !z2 || this.e == null) {
                subscriber.onNext(null);
                if (z2) {
                    this.f.lazySet(null);
                    Throwable th = this.e;
                    if (th != null) {
                        subscriber.onError(th);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                } else {
                    i2 = this.i.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            } else {
                spscLinkedArrayQueue.clear();
                this.f.lazySet(null);
                subscriber.onError(this.e);
                return;
            }
        }
        spscLinkedArrayQueue.clear();
        this.f.lazySet(null);
    }

    /* access modifiers changed from: package-private */
    public void h(Subscriber<? super T> subscriber) {
        int i2;
        long j2;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.a;
        boolean z = !this.c;
        int i3 = 1;
        while (true) {
            long j3 = this.j.get();
            long j4 = 0;
            while (true) {
                i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
                if (i2 == 0) {
                    j2 = j4;
                    break;
                }
                boolean z2 = this.d;
                T poll = spscLinkedArrayQueue.poll();
                boolean z3 = poll == null;
                j2 = j4;
                if (!b(z, z2, z3, subscriber, spscLinkedArrayQueue)) {
                    if (z3) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j4 = 1 + j2;
                } else {
                    return;
                }
            }
            if (i2 != 0 || !b(z, this.d, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                if (!(j2 == 0 || j3 == AbsPerformance.LONG_NIL)) {
                    this.j.addAndGet(-j2);
                }
                i3 = this.i.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.d && !this.g) {
            this.d = true;
            f();
            drain();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.d || this.g) {
            k22.u(th);
            return;
        }
        this.e = th;
        this.d = true;
        f();
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.d && !this.g) {
            this.a.offer(t);
            drain();
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.d || this.g) {
            subscription.cancel();
        } else {
            subscription.request(AbsPerformance.LONG_NIL);
        }
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.h.get() || !this.h.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.onSubscribe(this.i);
        this.f.set(subscriber);
        if (this.g) {
            this.f.lazySet(null);
        } else {
            drain();
        }
    }

    UnicastProcessor(int i2, Runnable runnable) {
        this(i2, runnable, true);
    }

    UnicastProcessor(int i2, Runnable runnable, boolean z) {
        this.a = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i2, "capacityHint"));
        this.b = new AtomicReference<>(runnable);
        this.c = z;
        this.f = new AtomicReference<>();
        this.h = new AtomicBoolean();
        this.i = new UnicastQueueSubscription();
        this.j = new AtomicLong();
    }
}
