package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import org.reactivestreams.Publisher;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class AbstractFlowableWithUpstream<T, R> extends b<R> implements HasUpstreamPublisher<T> {
    protected final b<T> source;

    AbstractFlowableWithUpstream(b<T> bVar) {
        this.source = (b) ObjectHelper.requireNonNull(bVar, "source is null");
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public final Publisher<T> source() {
        return this.source;
    }
}
