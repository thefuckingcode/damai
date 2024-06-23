package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.c;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
public final class MaybeNever extends c<Object> {
    public static final MaybeNever INSTANCE = new MaybeNever();

    /* access modifiers changed from: protected */
    @Override // io.reactivex.c
    public void subscribeActual(MaybeObserver<? super Object> maybeObserver) {
        maybeObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
