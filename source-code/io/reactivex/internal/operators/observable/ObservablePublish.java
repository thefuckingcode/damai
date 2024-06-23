package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tb.ff0;
import tb.jm;
import tb.k22;

/* compiled from: Taobao */
public final class ObservablePublish<T> extends jm<T> implements HasUpstreamObservableSource<T> {
    final AtomicReference<PublishObserver<T>> current;
    final ObservableSource<T> onSubscribe;
    final ObservableSource<T> source;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        private static final long serialVersionUID = -1100270633763673112L;
        final Observer<? super T> child;

        InnerDisposable(Observer<? super T> observer) {
            this.child = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((PublishObserver) andSet).remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == this;
        }

        /* access modifiers changed from: package-private */
        public void setParent(PublishObserver<T> publishObserver) {
            if (!compareAndSet(null, publishObserver)) {
                publishObserver.remove(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class PublishObserver<T> implements Observer<T>, Disposable {
        static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        final AtomicReference<PublishObserver<T>> current;
        final AtomicReference<InnerDisposable<T>[]> observers = new AtomicReference<>(EMPTY);
        final AtomicReference<Disposable> s = new AtomicReference<>();
        final AtomicBoolean shouldConnect;

        PublishObserver(AtomicReference<PublishObserver<T>> atomicReference) {
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
        }

        /* access modifiers changed from: package-private */
        public boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable<T>[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                if (innerDisposableArr == TERMINATED) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            InnerDisposable<T>[] innerDisposableArr = this.observers.get();
            InnerDisposable<T>[] innerDisposableArr2 = TERMINATED;
            if (innerDisposableArr != innerDisposableArr2 && this.observers.getAndSet(innerDisposableArr2) != innerDisposableArr2) {
                this.current.compareAndSet(this, null);
                DisposableHelper.dispose(this.s);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.current.compareAndSet(this, null);
            for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(TERMINATED)) {
                innerDisposable.child.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.current.compareAndSet(this, null);
            InnerDisposable<T>[] andSet = this.observers.getAndSet(TERMINATED);
            if (andSet.length != 0) {
                for (InnerDisposable<T> innerDisposable : andSet) {
                    innerDisposable.child.onError(th);
                }
                return;
            }
            k22.u(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                innerDisposable.child.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.s, disposable);
        }

        /* access modifiers changed from: package-private */
        public void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable<T>[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerDisposableArr[i2].equals(innerDisposable)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerDisposableArr2 = EMPTY;
                        } else {
                            InnerDisposable<T>[] innerDisposableArr3 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i);
                            System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr3, i, (length - i) - 1);
                            innerDisposableArr2 = innerDisposableArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class PublishSource<T> implements ObservableSource<T> {
        private final AtomicReference<PublishObserver<T>> curr;

        PublishSource(AtomicReference<PublishObserver<T>> atomicReference) {
            this.curr = atomicReference;
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            InnerDisposable innerDisposable = new InnerDisposable(observer);
            observer.onSubscribe(innerDisposable);
            while (true) {
                PublishObserver<T> publishObserver = this.curr.get();
                if (publishObserver == null || publishObserver.isDisposed()) {
                    PublishObserver<T> publishObserver2 = new PublishObserver<>(this.curr);
                    if (!this.curr.compareAndSet(publishObserver, publishObserver2)) {
                        continue;
                    } else {
                        publishObserver = publishObserver2;
                    }
                }
                if (publishObserver.add(innerDisposable)) {
                    innerDisposable.setParent(publishObserver);
                    return;
                }
            }
        }
    }

    private ObservablePublish(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<PublishObserver<T>> atomicReference) {
        this.onSubscribe = observableSource;
        this.source = observableSource2;
        this.current = atomicReference;
    }

    public static <T> jm<T> create(ObservableSource<T> observableSource) {
        AtomicReference atomicReference = new AtomicReference();
        return k22.r(new ObservablePublish(new PublishSource(atomicReference), observableSource, atomicReference));
    }

    @Override // tb.jm
    public void connect(Consumer<? super Disposable> consumer) {
        PublishObserver<T> publishObserver;
        while (true) {
            publishObserver = this.current.get();
            if (publishObserver != null && !publishObserver.isDisposed()) {
                break;
            }
            PublishObserver<T> publishObserver2 = new PublishObserver<>(this.current);
            if (this.current.compareAndSet(publishObserver, publishObserver2)) {
                publishObserver = publishObserver2;
                break;
            }
        }
        boolean z = true;
        if (publishObserver.shouldConnect.get() || !publishObserver.shouldConnect.compareAndSet(false, true)) {
            z = false;
        }
        try {
            consumer.accept(publishObserver);
            if (z) {
                this.source.subscribe(publishObserver);
            }
        } catch (Throwable th) {
            ff0.b(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        this.onSubscribe.subscribe(observer);
    }
}
