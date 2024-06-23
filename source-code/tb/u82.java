package tb;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;

/* compiled from: Taobao */
public final class u82<T> implements Observer<T>, Disposable {
    final Observer<? super T> a;
    final boolean b;
    Disposable c;
    boolean d;
    AppendOnlyLinkedArrayList<Object> e;
    volatile boolean f;

    public u82(@NonNull Observer<? super T> observer) {
        this(observer, false);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Observer<? super T>, io.reactivex.Observer<? super U> */
    /* access modifiers changed from: package-private */
    public void a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.e;
                if (appendOnlyLinkedArrayList == null) {
                    this.d = false;
                    return;
                }
                this.e = null;
            }
        } while (!appendOnlyLinkedArrayList.accept((Observer<? super T>) this.a));
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.c.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.f) {
            synchronized (this) {
                if (!this.f) {
                    if (this.d) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.e;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.e = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f = true;
                    this.d = true;
                    this.a.onComplete();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        tb.k22.u(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    @Override // io.reactivex.Observer
    public void onError(@NonNull Throwable th) {
        if (this.f) {
            k22.u(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f) {
                if (this.d) {
                    this.f = true;
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.e;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.e = appendOnlyLinkedArrayList;
                    }
                    Object error = NotificationLite.error(th);
                    if (this.b) {
                        appendOnlyLinkedArrayList.add(error);
                    } else {
                        appendOnlyLinkedArrayList.setFirst(error);
                    }
                    return;
                }
                this.f = true;
                this.d = true;
                z = false;
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(@NonNull T t) {
        if (!this.f) {
            if (t == null) {
                this.c.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f) {
                    if (this.d) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.e;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.e = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                        return;
                    }
                    this.d = true;
                    this.a.onNext(t);
                    a();
                }
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.c, disposable)) {
            this.c = disposable;
            this.a.onSubscribe(this);
        }
    }

    public u82(@NonNull Observer<? super T> observer, boolean z) {
        this.a = observer;
        this.b = z;
    }
}
