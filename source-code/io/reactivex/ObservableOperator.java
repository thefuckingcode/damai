package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
public interface ObservableOperator<Downstream, Upstream> {
    @NonNull
    Observer<? super Upstream> apply(@NonNull Observer<? super Downstream> observer) throws Exception;
}
