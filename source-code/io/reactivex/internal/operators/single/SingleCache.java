package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Taobao */
public final class SingleCache<T> extends e<T> implements SingleObserver<T> {
    static final CacheDisposable[] EMPTY = new CacheDisposable[0];
    static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
    Throwable error;
    final AtomicReference<CacheDisposable<T>[]> observers = new AtomicReference<>(EMPTY);
    final SingleSource<? extends T> source;
    T value;
    final AtomicInteger wip = new AtomicInteger();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 7514387411091976596L;
        final SingleObserver<? super T> actual;
        final SingleCache<T> parent;

        CacheDisposable(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            this.actual = singleObserver;
            this.parent = singleCache;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }
    }

    public SingleCache(SingleSource<? extends T> singleSource) {
        this.source = singleSource;
    }

    /* access modifiers changed from: package-private */
    public boolean add(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.observers.get();
            if (cacheDisposableArr == TERMINATED) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.observers.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        this.error = th;
        CacheDisposable<T>[] andSet = this.observers.getAndSet(TERMINATED);
        for (CacheDisposable<T> cacheDisposable : andSet) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onError(th);
            }
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t) {
        this.value = t;
        CacheDisposable<T>[] andSet = this.observers.getAndSet(TERMINATED);
        for (CacheDisposable<T> cacheDisposable : andSet) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onSuccess(t);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void remove(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.observers.get();
            int length = cacheDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (cacheDisposableArr[i2] == cacheDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        cacheDisposableArr2 = EMPTY;
                    } else {
                        CacheDisposable<T>[] cacheDisposableArr3 = new CacheDisposable[(length - 1)];
                        System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                        System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                        cacheDisposableArr2 = cacheDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.observers.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.e
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(singleObserver, this);
        singleObserver.onSubscribe(cacheDisposable);
        if (add(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                remove(cacheDisposable);
            }
            if (this.wip.getAndIncrement() == 0) {
                this.source.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess(this.value);
        }
    }
}
