package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface FlowableOnSubscribe<T> {
    void subscribe(@NonNull FlowableEmitter<T> flowableEmitter) throws Exception;
}
