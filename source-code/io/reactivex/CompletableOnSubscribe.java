package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface CompletableOnSubscribe {
    void subscribe(@NonNull CompletableEmitter completableEmitter) throws Exception;
}
