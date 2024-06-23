package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Nullable;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tb.k22;
import tb.pg2;

/* compiled from: Taobao */
public final class UnicastSubject<T> extends pg2<T> {
    final SpscLinkedArrayQueue<T> a;
    final AtomicReference<Observer<? super T>> b;
    final AtomicReference<Runnable> c;
    final boolean d;
    volatile boolean e;
    volatile boolean f;
    Throwable g;
    final AtomicBoolean h;
    final BasicIntQueueDisposable<T> i;
    boolean j;

    /* compiled from: Taobao */
    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        UnicastQueueDisposable() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastSubject.this.a.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!UnicastSubject.this.e) {
                UnicastSubject.this.e = true;
                UnicastSubject.this.e();
                UnicastSubject.this.b.lazySet(null);
                if (UnicastSubject.this.i.getAndIncrement() == 0) {
                    UnicastSubject.this.b.lazySet(null);
                    UnicastSubject.this.a.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return UnicastSubject.this.e;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastSubject.this.a.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            return UnicastSubject.this.a.poll();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.j = true;
            return 2;
        }
    }

    UnicastSubject(int i2, boolean z) {
        this.a = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i2, "capacityHint"));
        this.c = new AtomicReference<>();
        this.d = z;
        this.b = new AtomicReference<>();
        this.h = new AtomicBoolean();
        this.i = new UnicastQueueDisposable();
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> b() {
        return new UnicastSubject<>(d.bufferSize(), true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> c(int i2) {
        return new UnicastSubject<>(i2, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> d(int i2, Runnable runnable) {
        return new UnicastSubject<>(i2, runnable, true);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        Runnable runnable = this.c.get();
        if (runnable != null && this.c.compareAndSet(runnable, null)) {
            runnable.run();
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.i.getAndIncrement() == 0) {
            Observer<? super T> observer = this.b.get();
            int i2 = 1;
            while (observer == null) {
                i2 = this.i.addAndGet(-i2);
                if (i2 != 0) {
                    observer = this.b.get();
                } else {
                    return;
                }
            }
            if (this.j) {
                g(observer);
            } else {
                h(observer);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.a;
        int i2 = 1;
        boolean z = !this.d;
        while (!this.e) {
            boolean z2 = this.f;
            if (!z || !z2 || !j(spscLinkedArrayQueue, observer)) {
                observer.onNext(null);
                if (z2) {
                    i(observer);
                    return;
                }
                i2 = this.i.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.b.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    /* access modifiers changed from: package-private */
    public void h(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.a;
        boolean z = !this.d;
        boolean z2 = true;
        int i2 = 1;
        while (!this.e) {
            boolean z3 = this.f;
            T poll = this.a.poll();
            boolean z4 = poll == null;
            if (z3) {
                if (z && z2) {
                    if (!j(spscLinkedArrayQueue, observer)) {
                        z2 = false;
                    } else {
                        return;
                    }
                }
                if (z4) {
                    i(observer);
                    return;
                }
            }
            if (z4) {
                i2 = this.i.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                observer.onNext(poll);
            }
        }
        this.b.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    /* access modifiers changed from: package-private */
    public void i(Observer<? super T> observer) {
        this.b.lazySet(null);
        Throwable th = this.g;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean j(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th = this.g;
        if (th == null) {
            return false;
        }
        this.b.lazySet(null);
        simpleQueue.clear();
        observer.onError(th);
        return true;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.f && !this.e) {
            this.f = true;
            e();
            f();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f || this.e) {
            k22.u(th);
            return;
        }
        this.g = th;
        this.f = true;
        e();
        f();
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f && !this.e) {
            this.a.offer(t);
            f();
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f || this.e) {
            disposable.dispose();
        }
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        if (this.h.get() || !this.h.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), observer);
            return;
        }
        observer.onSubscribe(this.i);
        this.b.lazySet(observer);
        if (this.e) {
            this.b.lazySet(null);
        } else {
            f();
        }
    }

    UnicastSubject(int i2, Runnable runnable, boolean z) {
        this.a = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i2, "capacityHint"));
        this.c = new AtomicReference<>(ObjectHelper.requireNonNull(runnable, "onTerminate"));
        this.d = z;
        this.b = new AtomicReference<>();
        this.h = new AtomicBoolean();
        this.i = new UnicastQueueDisposable();
    }
}
