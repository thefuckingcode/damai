package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import tb.k22;
import tb.pg2;

/* compiled from: Taobao */
public final class AsyncSubject<T> extends pg2<T> {

    /* compiled from: Taobao */
    static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncSubject<T> parent;

        AsyncDisposable(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
            super(observer);
        }

        @Override // io.reactivex.disposables.Disposable, io.reactivex.internal.observers.DeferredScalarDisposable
        public void dispose() {
            if (super.tryDispose()) {
                throw null;
            }
        }

        /* access modifiers changed from: package-private */
        public void onComplete() {
            if (!isDisposed()) {
                this.actual.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable th) {
            if (isDisposed()) {
                k22.u(th);
            } else {
                this.actual.onError(th);
            }
        }
    }
}
