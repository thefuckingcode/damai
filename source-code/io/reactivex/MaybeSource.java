package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface MaybeSource<T> {
    void subscribe(@NonNull MaybeObserver<? super T> maybeObserver);
}
