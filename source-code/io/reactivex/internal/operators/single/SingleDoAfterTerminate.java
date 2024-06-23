package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.e;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class SingleDoAfterTerminate<T> extends e<T> {
    final Action onAfterTerminate;
    final SingleSource<T> source;

    /* compiled from: Taobao */
    static final class DoAfterTerminateObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> actual;
        Disposable d;
        final Action onAfterTerminate;

        DoAfterTerminateObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.actual = singleObserver;
            this.onAfterTerminate = action;
        }

        private void onAfterTerminate() {
            try {
                this.onAfterTerminate.run();
            } catch (Throwable th) {
                ff0.b(th);
                k22.u(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.actual.onError(th);
            onAfterTerminate();
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
            onAfterTerminate();
        }
    }

    public SingleDoAfterTerminate(SingleSource<T> singleSource, Action action) {
        this.source = singleSource;
        this.onAfterTerminate = action;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.e
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoAfterTerminateObserver(singleObserver, this.onAfterTerminate));
    }
}
