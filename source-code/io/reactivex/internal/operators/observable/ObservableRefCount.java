package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.a;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import tb.jm;
import tb.ql;

/* compiled from: Taobao */
public final class ObservableRefCount<T> extends AbstractObservableWithUpstream<T, T> {
    volatile ql baseDisposable = new ql();
    final ReentrantLock lock = new ReentrantLock();
    final jm<? extends T> source;
    final AtomicInteger subscriptionCount = new AtomicInteger();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class ConnectionObserver extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 3813126992133394324L;
        final ql currentBase;
        final Disposable resource;
        final Observer<? super T> subscriber;

        ConnectionObserver(Observer<? super T> observer, ql qlVar, Disposable disposable) {
            this.subscriber = observer;
            this.currentBase = qlVar;
            this.resource = disposable;
        }

        /* access modifiers changed from: package-private */
        public void cleanup() {
            ObservableRefCount.this.lock.lock();
            try {
                if (ObservableRefCount.this.baseDisposable == this.currentBase) {
                    jm<? extends T> jmVar = ObservableRefCount.this.source;
                    if (jmVar instanceof Disposable) {
                        ((Disposable) jmVar).dispose();
                    }
                    ObservableRefCount.this.baseDisposable.dispose();
                    ObservableRefCount.this.baseDisposable = new ql();
                    ObservableRefCount.this.subscriptionCount.set(0);
                }
            } finally {
                ObservableRefCount.this.lock.unlock();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            this.resource.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class DisposeConsumer implements Consumer<Disposable> {
        private final Observer<? super T> observer;
        private final AtomicBoolean writeLocked;

        DisposeConsumer(Observer<? super T> observer2, AtomicBoolean atomicBoolean) {
            this.observer = observer2;
            this.writeLocked = atomicBoolean;
        }

        public void accept(Disposable disposable) {
            try {
                ObservableRefCount.this.baseDisposable.add(disposable);
                ObservableRefCount observableRefCount = ObservableRefCount.this;
                observableRefCount.doSubscribe(this.observer, observableRefCount.baseDisposable);
            } finally {
                ObservableRefCount.this.lock.unlock();
                this.writeLocked.set(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class DisposeTask implements Runnable {
        private final ql current;

        DisposeTask(ql qlVar) {
            this.current = qlVar;
        }

        public void run() {
            ObservableRefCount.this.lock.lock();
            try {
                if (ObservableRefCount.this.baseDisposable == this.current && ObservableRefCount.this.subscriptionCount.decrementAndGet() == 0) {
                    jm<? extends T> jmVar = ObservableRefCount.this.source;
                    if (jmVar instanceof Disposable) {
                        ((Disposable) jmVar).dispose();
                    }
                    ObservableRefCount.this.baseDisposable.dispose();
                    ObservableRefCount.this.baseDisposable = new ql();
                }
            } finally {
                ObservableRefCount.this.lock.unlock();
            }
        }
    }

    public ObservableRefCount(jm<T> jmVar) {
        super(jmVar);
        this.source = jmVar;
    }

    private Disposable disconnect(ql qlVar) {
        return a.c(new DisposeTask(qlVar));
    }

    private Consumer<Disposable> onSubscribe(Observer<? super T> observer, AtomicBoolean atomicBoolean) {
        return new DisposeConsumer(observer, atomicBoolean);
    }

    /* access modifiers changed from: package-private */
    public void doSubscribe(Observer<? super T> observer, ql qlVar) {
        ConnectionObserver connectionObserver = new ConnectionObserver(observer, qlVar, disconnect(qlVar));
        observer.onSubscribe(connectionObserver);
        this.source.subscribe(connectionObserver);
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        this.lock.lock();
        if (this.subscriptionCount.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.source.connect(onSubscribe(observer, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                    this.lock.unlock();
                }
            }
        } else {
            try {
                doSubscribe(observer, this.baseDisposable);
            } finally {
                this.lock.unlock();
            }
        }
    }
}
