package io.reactivex.functions;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface Function<T, R> {
    R apply(@NonNull T t) throws Exception;
}
