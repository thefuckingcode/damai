package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.d;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class AbstractObservableWithUpstream<T, U> extends d<U> implements HasUpstreamObservableSource<T> {
    protected final ObservableSource<T> source;

    AbstractObservableWithUpstream(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public final ObservableSource<T> source() {
        return this.source;
    }
}
