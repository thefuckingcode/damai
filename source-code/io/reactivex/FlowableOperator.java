package io.reactivex;

import io.reactivex.annotations.NonNull;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
public interface FlowableOperator<Downstream, Upstream> {
    @NonNull
    Subscriber<? super Upstream> apply(@NonNull Subscriber<? super Downstream> subscriber) throws Exception;
}
