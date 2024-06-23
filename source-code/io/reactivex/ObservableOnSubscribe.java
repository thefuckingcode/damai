package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface ObservableOnSubscribe<T> {
    void subscribe(@NonNull ObservableEmitter<T> observableEmitter) throws Exception;
}
