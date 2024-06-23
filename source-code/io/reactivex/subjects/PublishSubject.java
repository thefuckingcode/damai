package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tb.k22;
import tb.pg2;

/* compiled from: Taobao */
public final class PublishSubject<T> extends pg2<T> {
    static final PublishDisposable[] c = new PublishDisposable[0];
    static final PublishDisposable[] d = new PublishDisposable[0];
    final AtomicReference<PublishDisposable<T>[]> a = new AtomicReference<>(d);
    Throwable b;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        final Observer<? super T> actual;
        final PublishSubject<T> parent;

        PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.actual = observer;
            this.parent = publishSubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.d(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (!get()) {
                this.actual.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (get()) {
                k22.u(th);
            } else {
                this.actual.onError(th);
            }
        }

        public void onNext(T t) {
            if (!get()) {
                this.actual.onNext(t);
            }
        }
    }

    PublishSubject() {
    }

    @CheckReturnValue
    public static <T> PublishSubject<T> c() {
        return new PublishSubject<>();
    }

    /* access modifiers changed from: package-private */
    public boolean b(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable<T>[] publishDisposableArr2;
        do {
            publishDisposableArr = this.a.get();
            if (publishDisposableArr == c) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[(length + 1)];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!this.a.compareAndSet(publishDisposableArr, publishDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable<T>[] publishDisposableArr2;
        do {
            publishDisposableArr = this.a.get();
            if (publishDisposableArr != c && publishDisposableArr != d) {
                int length = publishDisposableArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (publishDisposableArr[i2] == publishDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        publishDisposableArr2 = d;
                    } else {
                        PublishDisposable<T>[] publishDisposableArr3 = new PublishDisposable[(length - 1)];
                        System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i);
                        System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr3, i, (length - i) - 1);
                        publishDisposableArr2 = publishDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.a.compareAndSet(publishDisposableArr, publishDisposableArr2));
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.a.get();
        PublishDisposable<T>[] publishDisposableArr2 = c;
        if (publishDisposableArr != publishDisposableArr2) {
            for (PublishDisposable<T> publishDisposable : this.a.getAndSet(publishDisposableArr2)) {
                publishDisposable.onComplete();
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.a.get();
        PublishDisposable<T>[] publishDisposableArr2 = c;
        if (publishDisposableArr == publishDisposableArr2) {
            k22.u(th);
            return;
        }
        this.b = th;
        for (PublishDisposable<T> publishDisposable : this.a.getAndSet(publishDisposableArr2)) {
            publishDisposable.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.a.get() != c) {
            for (PublishDisposable<T> publishDisposable : this.a.get()) {
                publishDisposable.onNext(t);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.a.get() == c) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(observer, this);
        observer.onSubscribe(publishDisposable);
        if (!b(publishDisposable)) {
            Throwable th = this.b;
            if (th != null) {
                observer.onError(th);
            } else {
                observer.onComplete();
            }
        } else if (publishDisposable.isDisposed()) {
            d(publishDisposable);
        }
    }
}
