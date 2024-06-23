package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
/* compiled from: Taobao */
public interface FlowableConverter<T, R> {
    @NonNull
    R apply(@NonNull b<T> bVar);
}
