package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.d;
import tb.u82;

/* compiled from: Taobao */
public final class ObservableSerialized<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableSerialized(d<T> dVar) {
        super(dVar);
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new u82(observer));
    }
}
