package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 11})
/* compiled from: flowable.kt */
final class FlowableKt$sam$io_reactivex_functions_BiFunction$0 implements BiFunction {
    private final /* synthetic */ Function2 function;

    FlowableKt$sam$io_reactivex_functions_BiFunction$0(Function2 function2) {
        this.function = function2;
    }

    @Override // io.reactivex.functions.BiFunction
    public final /* synthetic */ R apply(T1 t1, T2 t2) {
        return (R) this.function.invoke(t1, t2);
    }
}
