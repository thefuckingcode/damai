package tb;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
public final class r32<T> implements Observer<T>, Disposable {
    final Observer<? super T> a;
    Disposable b;
    boolean c;

    public r32(@NonNull Observer<? super T> observer) {
        this.a = observer;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.a.onError(nullPointerException);
            } catch (Throwable th) {
                ff0.b(th);
                k22.u(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            ff0.b(th2);
            k22.u(new CompositeException(nullPointerException, th2));
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.a.onError(nullPointerException);
            } catch (Throwable th) {
                ff0.b(th);
                k22.u(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            ff0.b(th2);
            k22.u(new CompositeException(nullPointerException, th2));
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.c) {
            this.c = true;
            if (this.b == null) {
                a();
                return;
            }
            try {
                this.a.onComplete();
            } catch (Throwable th) {
                ff0.b(th);
                k22.u(th);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(@NonNull Throwable th) {
        if (this.c) {
            k22.u(th);
            return;
        }
        this.c = true;
        if (this.b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.a.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.a.onError(new CompositeException(th, nullPointerException));
                } catch (Throwable th2) {
                    ff0.b(th2);
                    k22.u(new CompositeException(th, nullPointerException, th2));
                }
            } catch (Throwable th3) {
                ff0.b(th3);
                k22.u(new CompositeException(th, nullPointerException, th3));
            }
        } else {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.a.onError(th);
            } catch (Throwable th4) {
                ff0.b(th4);
                k22.u(new CompositeException(th, th4));
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(@NonNull T t) {
        if (!this.c) {
            if (this.b == null) {
                b();
            } else if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.b.dispose();
                    onError(nullPointerException);
                } catch (Throwable th) {
                    ff0.b(th);
                    onError(new CompositeException(nullPointerException, th));
                }
            } else {
                try {
                    this.a.onNext(t);
                } catch (Throwable th2) {
                    ff0.b(th2);
                    onError(new CompositeException(th, th2));
                }
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.b, disposable)) {
            this.b = disposable;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                ff0.b(th);
                k22.u(new CompositeException(th, th));
            }
        }
    }
}
