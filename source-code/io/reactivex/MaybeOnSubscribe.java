package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface MaybeOnSubscribe<T> {
    void subscribe(@NonNull MaybeEmitter<T> maybeEmitter) throws Exception;
}
