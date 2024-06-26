package io.reactivex;

import io.reactivex.annotations.NonNull;
import org.reactivestreams.Publisher;

/* compiled from: Taobao */
public interface FlowableTransformer<Upstream, Downstream> {
    @NonNull
    Publisher<Downstream> apply(@NonNull b<Upstream> bVar);
}
