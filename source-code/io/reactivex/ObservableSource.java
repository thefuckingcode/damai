package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface ObservableSource<T> {
    void subscribe(@NonNull Observer<? super T> observer);
}
