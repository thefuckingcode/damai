package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.c;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
public final class MaybeFromFuture<T> extends c<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public MaybeFromFuture(Future<? extends T> future2, long j, TimeUnit timeUnit) {
        this.future = future2;
        this.timeout = j;
        this.unit = timeUnit;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.c
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable b = a.b();
        maybeObserver.onSubscribe(b);
        if (!b.isDisposed()) {
            try {
                long j = this.timeout;
                Object obj = j <= 0 ? (Object) this.future.get() : (Object) this.future.get(j, this.unit);
                if (b.isDisposed()) {
                    return;
                }
                if (obj == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(obj);
                }
            } catch (InterruptedException e) {
                if (!b.isDisposed()) {
                    maybeObserver.onError(e);
                }
            } catch (ExecutionException e2) {
                if (!b.isDisposed()) {
                    maybeObserver.onError(e2.getCause());
                }
            } catch (TimeoutException e3) {
                if (!b.isDisposed()) {
                    maybeObserver.onError(e3);
                }
            }
        }
    }
}
