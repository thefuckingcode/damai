package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
/* compiled from: Taobao */
public interface SingleConverter<T, R> {
    @NonNull
    R apply(@NonNull e<T> eVar);
}
