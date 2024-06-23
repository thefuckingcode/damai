package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "T", "", "it", "apply"}, k = 3, mv = {1, 1, 11})
/* compiled from: observable.kt */
final class ObservableKt$concatAll$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    public static final ObservableKt$concatAll$1 INSTANCE = new ObservableKt$concatAll$1();

    ObservableKt$concatAll$1() {
    }

    public final Observable<T> apply(Observable<T> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "it");
        return observable;
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((Observable) ((Observable) obj));
    }
}
