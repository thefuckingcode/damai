package io.reactivex.rxkotlin;

import io.reactivex.functions.Function4;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0004\n\u0002\b\f\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u00012\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u00032\u0006\u0010\b\u001a\u0002H\u00042\u0006\u0010\t\u001a\u0002H\u0005H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "R", "T", "T1", "T2", "T3", "t", "t1", "t2", "t3", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 11})
/* compiled from: Flowables.kt */
public final class FlowablesKt$withLatestFrom$5<T1, T2, T3, T4, R> implements Function4<T, T1, T2, T3, R> {
    final /* synthetic */ kotlin.jvm.functions.Function4 $combiner;

    public FlowablesKt$withLatestFrom$5(kotlin.jvm.functions.Function4 function4) {
        this.$combiner = function4;
    }

    @Override // io.reactivex.functions.Function4
    public final R apply(T t, T1 t1, T2 t2, T3 t3) {
        return (R) this.$combiner.invoke(t, t1, t2, t3);
    }
}
