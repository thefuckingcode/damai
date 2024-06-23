package io.reactivex.rxkotlin;

import io.reactivex.functions.Function5;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0004\n\u0002\b\u000e\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u00012\u0006\u0010\u0007\u001a\u0002H\u00022\u0006\u0010\b\u001a\u0002H\u00032\u0006\u0010\t\u001a\u0002H\u00042\u0006\u0010\n\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u0002H\u0006H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"<anonymous>", "R", "T1", "T2", "T3", "T4", "T5", "t1", "t2", "t3", "t4", "t5", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 11})
/* compiled from: Flowables.kt */
public final class Flowables$zip$6<T1, T2, T3, T4, T5, R> implements Function5<T1, T2, T3, T4, T5, R> {
    final /* synthetic */ kotlin.jvm.functions.Function5 $combineFunction;

    public Flowables$zip$6(kotlin.jvm.functions.Function5 function5) {
        this.$combineFunction = function5;
    }

    @Override // io.reactivex.functions.Function5
    public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        return (R) this.$combineFunction.invoke(t1, t2, t3, t4, t5);
    }
}
