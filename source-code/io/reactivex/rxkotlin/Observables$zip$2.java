package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u0002H\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "T1", "T2", "t1", "t2", "apply", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, k = 3, mv = {1, 1, 11})
/* compiled from: Observables.kt */
final class Observables$zip$2<T1, T2, R> implements BiFunction<T1, T2, Pair<? extends T1, ? extends T2>> {
    public static final Observables$zip$2 INSTANCE = new Observables$zip$2();

    Observables$zip$2() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Pair<T1, T2> apply(T1 t1, T2 t2) {
        return TuplesKt.to(t1, t2);
    }
}
