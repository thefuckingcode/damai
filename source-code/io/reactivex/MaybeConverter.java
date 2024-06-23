package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
/* compiled from: Taobao */
public interface MaybeConverter<T, R> {
    @NonNull
    R apply(@NonNull c<T> cVar);
}
