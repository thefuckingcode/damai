package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.observers.b;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import tb.ff0;
import tb.k22;
import tb.u82;

/* compiled from: Taobao */
public final class ObservableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {
    final Callable<? extends ObservableSource<B>> boundarySupplier;
    final Callable<U> bufferSupplier;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends b<B> {
        boolean once;
        final BufferBoundarySupplierObserver<T, U, B> parent;

        BufferBoundaryObserver(BufferBoundarySupplierObserver<T, U, B> bufferBoundarySupplierObserver) {
            this.parent = bufferBoundarySupplierObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.once) {
                this.once = true;
                this.parent.next();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.once) {
                k22.u(th);
                return;
            }
            this.once = true;
            this.parent.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b) {
            if (!this.once) {
                this.once = true;
                dispose();
                this.parent.next();
            }
        }
    }

    /* compiled from: Taobao */
    static final class BufferBoundarySupplierObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T> {
        final Callable<? extends ObservableSource<B>> boundarySupplier;
        U buffer;
        final Callable<U> bufferSupplier;
        final AtomicReference<Disposable> other = new AtomicReference<>();
        Disposable s;

        BufferBoundarySupplierObserver(Observer<? super U> observer, Callable<U> callable, Callable<? extends ObservableSource<B>> callable2) {
            super(observer, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.boundarySupplier = callable2;
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.dispose();
                disposeOther();
                if (enter()) {
                    this.queue.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void disposeOther() {
            DisposableHelper.dispose(this.other);
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void next() {
            try {
                U u = (U) ((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null"));
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.boundarySupplier.call(), "The boundary ObservableSource supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    if (this.other.compareAndSet(this.other.get(), bufferBoundaryObserver)) {
                        synchronized (this) {
                            U u2 = this.buffer;
                            if (u2 != null) {
                                this.buffer = u;
                                observableSource.subscribe(bufferBoundaryObserver);
                                fastPathEmit(u2, false, this);
                            }
                        }
                    }
                } catch (Throwable th) {
                    ff0.b(th);
                    this.cancelled = true;
                    this.s.dispose();
                    this.actual.onError(th);
                }
            } catch (Throwable th2) {
                ff0.b(th2);
                dispose();
                this.actual.onError(th2);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            io.reactivex.internal.util.QueueDrainHelper.drainLoop(r3.queue, r3.actual, false, r3, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r3.queue.offer(r0);
            r3.done = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (enter() == false) goto L_?;
         */
        @Override // io.reactivex.Observer
        public void onComplete() {
            synchronized (this) {
                U u = this.buffer;
                if (u != null) {
                    this.buffer = null;
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            dispose();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                U u = this.buffer;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                Observer<? super V> observer = this.actual;
                try {
                    this.buffer = (U) ((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null"));
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.boundarySupplier.call(), "The boundary ObservableSource supplied is null");
                        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                        this.other.set(bufferBoundaryObserver);
                        observer.onSubscribe(this);
                        if (!this.cancelled) {
                            observableSource.subscribe(bufferBoundaryObserver);
                        }
                    } catch (Throwable th) {
                        ff0.b(th);
                        this.cancelled = true;
                        disposable.dispose();
                        EmptyDisposable.error(th, observer);
                    }
                } catch (Throwable th2) {
                    ff0.b(th2);
                    this.cancelled = true;
                    disposable.dispose();
                    EmptyDisposable.error(th2, observer);
                }
            }
        }

        public void accept(Observer<? super U> observer, U u) {
            this.actual.onNext(u);
        }
    }

    public ObservableBufferBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        super(observableSource);
        this.boundarySupplier = callable;
        this.bufferSupplier = callable2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new BufferBoundarySupplierObserver(new u82(observer), this.bufferSupplier, this.boundarySupplier));
    }
}
