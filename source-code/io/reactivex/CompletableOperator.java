package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface CompletableOperator {
    @NonNull
    CompletableObserver apply(@NonNull CompletableObserver completableObserver) throws Exception;
}
