package io.reactivex.internal.observers;

/* compiled from: Taobao */
public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.value = null;
        this.error = th;
        countDown();
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        this.value = t;
    }
}
