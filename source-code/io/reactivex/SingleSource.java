package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface SingleSource<T> {
    void subscribe(@NonNull SingleObserver<? super T> singleObserver);
}
