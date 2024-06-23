package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.c;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class AbstractMaybeWithUpstream<T, R> extends c<R> implements HasUpstreamMaybeSource<T> {
    protected final MaybeSource<T> source;

    AbstractMaybeWithUpstream(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public final MaybeSource<T> source() {
        return this.source;
    }
}
