package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0004\n\u0002\b\b\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00012\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u0002H\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "R", "T1", "T2", "t1", "t2", "apply", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 11})
/* compiled from: Observables.kt */
public final class Observables$combineLatest$1<T1, T2, R> implements BiFunction<T1, T2, R> {
    final /* synthetic */ Function2 $combineFunction;

    public Observables$combineLatest$1(Function2 function2) {
        this.$combineFunction = function2;
    }

    @Override // io.reactivex.functions.BiFunction
    public final R apply(T1 t1, T2 t2) {
        return (R) this.$combineFunction.invoke(t1, t2);
    }
}
