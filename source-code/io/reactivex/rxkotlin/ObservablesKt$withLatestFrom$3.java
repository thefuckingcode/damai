package io.reactivex.rxkotlin;

import io.reactivex.functions.Function3;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0004\n\u0002\b\n\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00012\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u00032\u0006\u0010\u0007\u001a\u0002H\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "R", "T", "T1", "T2", "t", "t1", "t2", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 11})
/* compiled from: Observables.kt */
public final class ObservablesKt$withLatestFrom$3<T1, T2, T3, R> implements Function3<T, T1, T2, R> {
    final /* synthetic */ kotlin.jvm.functions.Function3 $combiner;

    public ObservablesKt$withLatestFrom$3(kotlin.jvm.functions.Function3 function3) {
        this.$combiner = function3;
    }

    @Override // io.reactivex.functions.Function3
    public final R apply(T t, T1 t1, T2 t2) {
        return (R) this.$combiner.invoke(t, t1, t2);
    }
}
