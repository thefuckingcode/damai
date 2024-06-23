package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import tb.ff0;
import tb.pg2;

/* compiled from: Taobao */
public final class ObservableRetryWhen<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super d<Throwable>, ? extends ObservableSource<?>> handler;

    /* compiled from: Taobao */
    static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final Observer<? super T> actual;
        final AtomicReference<Disposable> d = new AtomicReference<>();
        final AtomicThrowable error = new AtomicThrowable();
        final RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();
        final pg2<Throwable> signaller;
        final ObservableSource<T> source;
        final AtomicInteger wip = new AtomicInteger();

        /* compiled from: Taobao */
        final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            InnerRepeatObserver() {
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                RepeatWhenObserver.this.innerComplete();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RepeatWhenObserver.this.innerError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(Object obj) {
                RepeatWhenObserver.this.innerNext();
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        RepeatWhenObserver(Observer<? super T> observer, pg2<Throwable> pg2, ObservableSource<T> observableSource) {
            this.actual = observer;
            this.signaller = pg2;
            this.source = observableSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.d);
            DisposableHelper.dispose(this.inner);
        }

        /* access modifiers changed from: package-private */
        public void innerComplete() {
            DisposableHelper.dispose(this.d);
            HalfSerializer.onComplete(this.actual, this, this.error);
        }

        /* access modifiers changed from: package-private */
        public void innerError(Throwable th) {
            DisposableHelper.dispose(this.d);
            HalfSerializer.onError(this.actual, th, this, this.error);
        }

        /* access modifiers changed from: package-private */
        public void innerNext() {
            subscribeNext();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.d.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.inner);
            HalfSerializer.onComplete(this.actual, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.active = false;
            this.signaller.onNext(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            HalfSerializer.onNext(this.actual, t, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.d, disposable);
        }

        /* access modifiers changed from: package-private */
        public void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRetryWhen(ObservableSource<T> observableSource, Function<? super d<Throwable>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.handler = function;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        pg2<T> a = PublishSubject.c().a();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.handler.apply(a), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, a, this.source);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.inner);
            repeatWhenObserver.subscribeNext();
        } catch (Throwable th) {
            ff0.b(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
