package io.reactivex.rxkotlin;

import io.reactivex.functions.Function8;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0004\n\u0002\b\u0014\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u0007\"\u0004\b\u0006\u0010\b\"\u0004\b\u0007\u0010\t\"\u0004\b\b\u0010\u00012\u0006\u0010\n\u001a\u0002H\u00022\u0006\u0010\u000b\u001a\u0002H\u00032\u0006\u0010\f\u001a\u0002H\u00042\u0006\u0010\r\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u0002H\u00062\u0006\u0010\u000f\u001a\u0002H\u00072\u0006\u0010\u0010\u001a\u0002H\b2\u0006\u0010\u0011\u001a\u0002H\tH\n¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"<anonymous>", "R", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 11})
/* compiled from: Flowables.kt */
public final class Flowables$zip$9<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> {
    final /* synthetic */ kotlin.jvm.functions.Function8 $combineFunction;

    public Flowables$zip$9(kotlin.jvm.functions.Function8 function8) {
        this.$combineFunction = function8;
    }

    @Override // io.reactivex.functions.Function8
    public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        return (R) this.$combineFunction.invoke(t1, t2, t3, t4, t5, t6, t7, t8);
    }
}
