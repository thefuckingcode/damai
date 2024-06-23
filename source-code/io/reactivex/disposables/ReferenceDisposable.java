package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Taobao */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    ReferenceDisposable(T t) {
        super(ObjectHelper.requireNonNull(t, "value is null"));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: io.reactivex.disposables.ReferenceDisposable<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Object andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            onDisposed(andSet);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return get() == null;
    }

    /* access modifiers changed from: protected */
    public abstract void onDisposed(@NonNull T t);
}
