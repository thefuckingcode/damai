package io.reactivex.parallel;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
/* compiled from: Taobao */
public interface ParallelTransformer<Upstream, Downstream> {
    @NonNull
    a<Downstream> apply(@NonNull a<Upstream> aVar);
}
