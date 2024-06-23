package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface CompletableSource {
    void subscribe(@NonNull CompletableObserver completableObserver);
}
