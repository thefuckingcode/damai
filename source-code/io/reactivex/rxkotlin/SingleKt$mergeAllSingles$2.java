package io.reactivex.rxkotlin;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "T", "", "it", "apply"}, k = 3, mv = {1, 1, 11})
/* compiled from: single.kt */
final class SingleKt$mergeAllSingles$2<T, R> implements Function<T, SingleSource<? extends R>> {
    public static final SingleKt$mergeAllSingles$2 INSTANCE = new SingleKt$mergeAllSingles$2();

    SingleKt$mergeAllSingles$2() {
    }

    public final Single<T> apply(Single<T> single) {
        Intrinsics.checkParameterIsNotNull(single, "it");
        return single;
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((Single) ((Single) obj));
    }
}
