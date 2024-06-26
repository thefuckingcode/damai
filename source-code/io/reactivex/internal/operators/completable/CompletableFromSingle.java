package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;

/* compiled from: Taobao */
public final class CompletableFromSingle<T> extends a {
    final SingleSource<T> single;

    /* compiled from: Taobao */
    static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {
        final CompletableObserver co;

        CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.co = completableObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.co.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.co.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.co.onComplete();
        }
    }

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.single = singleSource;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        this.single.subscribe(new CompletableFromSingleObserver(completableObserver));
    }
}
