package io.reactivex.subjects;

import io.reactivex.CompletableObserver;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tb.k22;

/* compiled from: Taobao */
public final class CompletableSubject extends a implements CompletableObserver {
    static final CompletableDisposable[] d = new CompletableDisposable[0];
    static final CompletableDisposable[] e = new CompletableDisposable[0];
    final AtomicReference<CompletableDisposable[]> a = new AtomicReference<>(d);
    final AtomicBoolean b = new AtomicBoolean();
    Throwable c;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final CompletableObserver actual;

        CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
            this.actual = completableObserver;
            lazySet(completableSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            CompletableSubject completableSubject = (CompletableSubject) getAndSet(null);
            if (completableSubject != null) {
                completableSubject.b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    CompletableSubject() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.a.get();
            if (completableDisposableArr == e) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[(length + 1)];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!this.a.compareAndSet(completableDisposableArr, completableDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.a.get();
            int length = completableDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (completableDisposableArr[i2] == completableDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        completableDisposableArr2 = d;
                    } else {
                        CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[(length - 1)];
                        System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i);
                        System.arraycopy(completableDisposableArr, i + 1, completableDisposableArr3, i, (length - i) - 1);
                        completableDisposableArr2 = completableDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.a.compareAndSet(completableDisposableArr, completableDisposableArr2));
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        if (this.b.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.a.getAndSet(e)) {
                completableDisposable.actual.onComplete();
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.b.compareAndSet(false, true)) {
            this.c = th;
            for (CompletableDisposable completableDisposable : this.a.getAndSet(e)) {
                completableDisposable.actual.onError(th);
            }
            return;
        }
        k22.u(th);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable disposable) {
        if (this.a.get() == e) {
            disposable.dispose();
        }
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        CompletableDisposable completableDisposable = new CompletableDisposable(completableObserver, this);
        completableObserver.onSubscribe(completableDisposable);
        if (!a(completableDisposable)) {
            Throwable th = this.c;
            if (th != null) {
                completableObserver.onError(th);
            } else {
                completableObserver.onComplete();
            }
        } else if (completableDisposable.isDisposed()) {
            b(completableDisposable);
        }
    }
}
