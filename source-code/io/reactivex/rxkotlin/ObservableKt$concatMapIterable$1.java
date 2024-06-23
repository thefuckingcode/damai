package io.reactivex.rxkotlin;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "", "it", "apply"}, k = 3, mv = {1, 1, 11})
/* compiled from: observable.kt */
final class ObservableKt$concatMapIterable$1<T, R> implements Function<T, Iterable<? extends U>> {
    public static final ObservableKt$concatMapIterable$1 INSTANCE = new ObservableKt$concatMapIterable$1();

    ObservableKt$concatMapIterable$1() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Iterable<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Iterable<T> apply(Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "it");
        return iterable;
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((Iterable) ((Iterable) obj));
    }
}
