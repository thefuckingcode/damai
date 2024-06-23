package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> actual;
    final Action onDispose;
    final Consumer<? super Disposable> onSubscribe;
    Disposable s;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.actual = observer;
        this.onSubscribe = consumer;
        this.onDispose = action;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        try {
            this.onDispose.run();
        } catch (Throwable th) {
            ff0.b(th);
            k22.u(th);
        }
        this.s.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.s.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.s != DisposableHelper.DISPOSED) {
            this.actual.onComplete();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.s != DisposableHelper.DISPOSED) {
            this.actual.onError(th);
        } else {
            k22.u(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        try {
            this.onSubscribe.accept(disposable);
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        } catch (Throwable th) {
            ff0.b(th);
            disposable.dispose();
            this.s = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, this.actual);
        }
    }
}
