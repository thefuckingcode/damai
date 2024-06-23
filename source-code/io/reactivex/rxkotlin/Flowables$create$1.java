package io.reactivex.rxkotlin;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u0001H\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "it", "Lio/reactivex/FlowableEmitter;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 1, 11})
/* compiled from: Flowables.kt */
public final class Flowables$create$1<T> implements FlowableOnSubscribe<T> {
    final /* synthetic */ Function1 $source;

    public Flowables$create$1(Function1 function1) {
        this.$source = function1;
    }

    @Override // io.reactivex.FlowableOnSubscribe
    public final void subscribe(FlowableEmitter<T> flowableEmitter) {
        Intrinsics.checkParameterIsNotNull(flowableEmitter, "it");
        this.$source.invoke(flowableEmitter);
    }
}
