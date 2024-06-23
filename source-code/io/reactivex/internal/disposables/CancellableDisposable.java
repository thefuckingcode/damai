package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import java.util.concurrent.atomic.AtomicReference;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class CancellableDisposable extends AtomicReference<Cancellable> implements Disposable {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(Cancellable cancellable) {
        super(cancellable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Cancellable cancellable;
        if (get() != null && (cancellable = (Cancellable) getAndSet(null)) != null) {
            try {
                cancellable.cancel();
            } catch (Exception e) {
                ff0.b(e);
                k22.u(e);
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get() == null;
    }
}
