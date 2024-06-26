package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface MaybeTransformer<Upstream, Downstream> {
    @NonNull
    MaybeSource<Downstream> apply(@NonNull c<Upstream> cVar);
}
