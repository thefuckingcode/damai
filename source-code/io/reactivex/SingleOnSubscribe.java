package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface SingleOnSubscribe<T> {
    void subscribe(@NonNull SingleEmitter<T> singleEmitter) throws Exception;
}
