package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final /* synthetic */ class FlowKt__DistinctKt {
    @NotNull
    private static final Function1<Object, Object> a = FlowKt__DistinctKt$defaultKeySelector$1.INSTANCE;
    @NotNull
    private static final Function2<Object, Object, Boolean> b = FlowKt__DistinctKt$defaultAreEquivalent$1.INSTANCE;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Flow<T> a(@NotNull Flow<? extends T> flow) {
        return flow instanceof StateFlow ? flow : b(flow, a, b);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Flow<T> b(Flow<? extends T> flow, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        if (flow instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) flow;
            if (distinctFlowImpl.b == function1 && distinctFlowImpl.c == function2) {
                return flow;
            }
        }
        return new DistinctFlowImpl(flow, function1, function2);
    }
}
