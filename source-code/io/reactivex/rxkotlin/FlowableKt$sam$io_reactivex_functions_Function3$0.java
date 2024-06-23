package io.reactivex.rxkotlin;

import io.reactivex.functions.Function3;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 11})
/* compiled from: flowable.kt */
final class FlowableKt$sam$io_reactivex_functions_Function3$0 implements Function3 {
    private final /* synthetic */ kotlin.jvm.functions.Function3 function;

    FlowableKt$sam$io_reactivex_functions_Function3$0(kotlin.jvm.functions.Function3 function3) {
        this.function = function3;
    }

    @Override // io.reactivex.functions.Function3
    public final /* synthetic */ R apply(T1 t1, T2 t2, T3 t3) {
        return (R) this.function.invoke(t1, t2, t3);
    }
}
