package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
/* compiled from: Taobao */
public interface CompletableConverter<R> {
    @NonNull
    R apply(@NonNull a aVar);
}
