package io.reactivex.parallel;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
/* compiled from: Taobao */
public interface ParallelFlowableConverter<T, R> {
    @NonNull
    R apply(@NonNull a<T> aVar);
}
