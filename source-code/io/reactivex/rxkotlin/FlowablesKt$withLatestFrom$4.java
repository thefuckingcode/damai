package io.reactivex.rxkotlin;

import io.reactivex.functions.Function3;
import kotlin.Metadata;
import kotlin.Triple;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u00032\u0006\u0010\u0007\u001a\u0002H\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "T", "T1", "T2", "t", "t1", "t2", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;"}, k = 3, mv = {1, 1, 11})
/* compiled from: Flowables.kt */
final class FlowablesKt$withLatestFrom$4<T1, T2, T3, R> implements Function3<T, T1, T2, Triple<? extends T, ? extends T1, ? extends T2>> {
    public static final FlowablesKt$withLatestFrom$4 INSTANCE = new FlowablesKt$withLatestFrom$4();

    FlowablesKt$withLatestFrom$4() {
    }

    @Override // io.reactivex.functions.Function3
    public final Triple<T, T1, T2> apply(T t, T1 t1, T2 t2) {
        return new Triple<>(t, t1, t2);
    }
}
