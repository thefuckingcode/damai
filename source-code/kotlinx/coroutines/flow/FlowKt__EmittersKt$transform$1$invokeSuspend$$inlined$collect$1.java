package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* compiled from: Taobao */
public final class FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Object> {
    final /* synthetic */ Function3 a;
    final /* synthetic */ FlowCollector b;

    public FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(Function3 function3, FlowCollector flowCollector) {
        this.a = function3;
        this.b = flowCollector;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(Object obj, @NotNull Continuation<? super ur2> continuation) {
        Object invoke = this.a.invoke(this.b, obj, continuation);
        return invoke == b.d() ? invoke : ur2.INSTANCE;
    }
}
