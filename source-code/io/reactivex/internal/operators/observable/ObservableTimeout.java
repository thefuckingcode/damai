package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ObserverFullArbiter;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.FullArbiterObserver;
import io.reactivex.observers.b;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import tb.ff0;
import tb.k22;
import tb.u82;

/* compiled from: Taobao */
public final class ObservableTimeout<T, U, V> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<U> firstTimeoutIndicator;
    final Function<? super T, ? extends ObservableSource<V>> itemTimeoutIndicator;
    final ObservableSource<? extends T> other;

    /* compiled from: Taobao */
    interface OnTimeout {
        void innerError(Throwable th);

        void timeout(long j);
    }

    /* compiled from: Taobao */
    static final class TimeoutInnerObserver<T, U, V> extends b<Object> {
        boolean done;
        final long index;
        final OnTimeout parent;

        TimeoutInnerObserver(OnTimeout onTimeout, long j) {
            this.parent = onTimeout;
            this.index = j;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.parent.timeout(this.index);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                k22.u(th);
                return;
            }
            this.done = true;
            this.parent.innerError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            if (!this.done) {
                this.done = true;
                dispose();
                this.parent.timeout(this.index);
            }
        }
    }

    /* compiled from: Taobao */
    static final class TimeoutObserver<T, U, V> extends AtomicReference<Disposable> implements Observer<T>, Disposable, OnTimeout {
        private static final long serialVersionUID = 2672739326310051084L;
        final Observer<? super T> actual;
        final ObservableSource<U> firstTimeoutIndicator;
        volatile long index;
        final Function<? super T, ? extends ObservableSource<V>> itemTimeoutIndicator;
        Disposable s;

        TimeoutObserver(Observer<? super T> observer, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
            this.actual = observer;
            this.firstTimeoutIndicator = observableSource;
            this.itemTimeoutIndicator = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (DisposableHelper.dispose(this)) {
                this.s.dispose();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.OnTimeout
        public void innerError(Throwable th) {
            this.s.dispose();
            this.actual.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this);
            this.actual.onError(th);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.internal.operators.observable.ObservableTimeout$TimeoutObserver<T, U, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t) {
            long j = this.index + 1;
            this.index = j;
            this.actual.onNext(t);
            Disposable disposable = (Disposable) get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t), "The ObservableSource returned is null");
                TimeoutInnerObserver timeoutInnerObserver = new TimeoutInnerObserver(this, j);
                if (compareAndSet(disposable, timeoutInnerObserver)) {
                    observableSource.subscribe(timeoutInnerObserver);
                }
            } catch (Throwable th) {
                ff0.b(th);
                dispose();
                this.actual.onError(th);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.internal.operators.observable.ObservableTimeout$TimeoutObserver<T, U, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                Observer<? super T> observer = this.actual;
                ObservableSource<U> observableSource = this.firstTimeoutIndicator;
                if (observableSource != null) {
                    TimeoutInnerObserver timeoutInnerObserver = new TimeoutInnerObserver(this, 0);
                    if (compareAndSet(null, timeoutInnerObserver)) {
                        observer.onSubscribe(this);
                        observableSource.subscribe(timeoutInnerObserver);
                        return;
                    }
                    return;
                }
                observer.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.OnTimeout
        public void timeout(long j) {
            if (j == this.index) {
                dispose();
                this.actual.onError(new TimeoutException());
            }
        }
    }

    /* compiled from: Taobao */
    static final class TimeoutOtherObserver<T, U, V> extends AtomicReference<Disposable> implements Observer<T>, Disposable, OnTimeout {
        private static final long serialVersionUID = -1957813281749686898L;
        final Observer<? super T> actual;
        final ObserverFullArbiter<T> arbiter;
        boolean done;
        final ObservableSource<U> firstTimeoutIndicator;
        volatile long index;
        final Function<? super T, ? extends ObservableSource<V>> itemTimeoutIndicator;
        final ObservableSource<? extends T> other;
        Disposable s;

        TimeoutOtherObserver(Observer<? super T> observer, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
            this.actual = observer;
            this.firstTimeoutIndicator = observableSource;
            this.itemTimeoutIndicator = function;
            this.other = observableSource2;
            this.arbiter = new ObserverFullArbiter<>(observer, this, 8);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (DisposableHelper.dispose(this)) {
                this.s.dispose();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.OnTimeout
        public void innerError(Throwable th) {
            this.s.dispose();
            this.actual.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                dispose();
                this.arbiter.onComplete(this.s);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                k22.u(th);
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.onError(th, this.s);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.internal.operators.observable.ObservableTimeout$TimeoutOtherObserver<T, U, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.done) {
                long j = this.index + 1;
                this.index = j;
                if (this.arbiter.onNext(t, this.s)) {
                    Disposable disposable = (Disposable) get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t), "The ObservableSource returned is null");
                        TimeoutInnerObserver timeoutInnerObserver = new TimeoutInnerObserver(this, j);
                        if (compareAndSet(disposable, timeoutInnerObserver)) {
                            observableSource.subscribe(timeoutInnerObserver);
                        }
                    } catch (Throwable th) {
                        ff0.b(th);
                        this.actual.onError(th);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.internal.operators.observable.ObservableTimeout$TimeoutOtherObserver<T, U, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.arbiter.setDisposable(disposable);
                Observer<? super T> observer = this.actual;
                ObservableSource<U> observableSource = this.firstTimeoutIndicator;
                if (observableSource != null) {
                    TimeoutInnerObserver timeoutInnerObserver = new TimeoutInnerObserver(this, 0);
                    if (compareAndSet(null, timeoutInnerObserver)) {
                        observer.onSubscribe(this.arbiter);
                        observableSource.subscribe(timeoutInnerObserver);
                        return;
                    }
                    return;
                }
                observer.onSubscribe(this.arbiter);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.OnTimeout
        public void timeout(long j) {
            if (j == this.index) {
                dispose();
                this.other.subscribe(new FullArbiterObserver(this.arbiter));
            }
        }
    }

    public ObservableTimeout(ObservableSource<T> observableSource, ObservableSource<U> observableSource2, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource3) {
        super(observableSource);
        this.firstTimeoutIndicator = observableSource2;
        this.itemTimeoutIndicator = function;
        this.other = observableSource3;
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        if (this.other == null) {
            this.source.subscribe(new TimeoutObserver(new u82(observer), this.firstTimeoutIndicator, this.itemTimeoutIndicator));
        } else {
            this.source.subscribe(new TimeoutOtherObserver(observer, this.firstTimeoutIndicator, this.itemTimeoutIndicator, this.other));
        }
    }
}
