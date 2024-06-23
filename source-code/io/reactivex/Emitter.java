package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface Emitter<T> {
    void onComplete();

    void onError(@NonNull Throwable th);

    void onNext(@NonNull T t);
}
