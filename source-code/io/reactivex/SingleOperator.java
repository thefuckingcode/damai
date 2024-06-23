package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface SingleOperator<Downstream, Upstream> {
    @NonNull
    SingleObserver<? super Upstream> apply(@NonNull SingleObserver<? super Downstream> singleObserver) throws Exception;
}
