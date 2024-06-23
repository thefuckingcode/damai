package io.reactivex.subjects;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.e;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tb.k22;

/* compiled from: Taobao */
public final class SingleSubject<T> extends e<T> implements SingleObserver<T> {
    static final SingleDisposable[] e = new SingleDisposable[0];
    static final SingleDisposable[] f = new SingleDisposable[0];
    final AtomicReference<SingleDisposable<T>[]> a = new AtomicReference<>(e);
    final AtomicBoolean b = new AtomicBoolean();
    T c;
    Throwable d;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final SingleObserver<? super T> actual;

        SingleDisposable(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
            this.actual = singleObserver;
            lazySet(singleSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SingleSubject singleSubject = (SingleSubject) getAndSet(null);
            if (singleSubject != null) {
                singleSubject.b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    SingleSubject() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(@NonNull SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable<T>[] singleDisposableArr2;
        do {
            singleDisposableArr = this.a.get();
            if (singleDisposableArr == f) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[(length + 1)];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!this.a.compareAndSet(singleDisposableArr, singleDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable<T>[] singleDisposableArr2;
        do {
            singleDisposableArr = this.a.get();
            int length = singleDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (singleDisposableArr[i2] == singleDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        singleDisposableArr2 = e;
                    } else {
                        SingleDisposable<T>[] singleDisposableArr3 = new SingleDisposable[(length - 1)];
                        System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i);
                        System.arraycopy(singleDisposableArr, i + 1, singleDisposableArr3, i, (length - i) - 1);
                        singleDisposableArr2 = singleDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.a.compareAndSet(singleDisposableArr, singleDisposableArr2));
    }

    @Override // io.reactivex.SingleObserver
    public void onError(@NonNull Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.b.compareAndSet(false, true)) {
            this.d = th;
            for (SingleDisposable<T> singleDisposable : this.a.getAndSet(f)) {
                singleDisposable.actual.onError(th);
            }
            return;
        }
        k22.u(th);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(@NonNull Disposable disposable) {
        if (this.a.get() == f) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(@NonNull T t) {
        ObjectHelper.requireNonNull(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.b.compareAndSet(false, true)) {
            this.c = t;
            for (SingleDisposable<T> singleDisposable : this.a.getAndSet(f)) {
                singleDisposable.actual.onSuccess(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.e
    public void subscribeActual(@NonNull SingleObserver<? super T> singleObserver) {
        SingleDisposable<T> singleDisposable = new SingleDisposable<>(singleObserver, this);
        singleObserver.onSubscribe(singleDisposable);
        if (!a(singleDisposable)) {
            Throwable th = this.d;
            if (th != null) {
                singleObserver.onError(th);
            } else {
                singleObserver.onSuccess(this.c);
            }
        } else if (singleDisposable.isDisposed()) {
            b(singleDisposable);
        }
    }
}
