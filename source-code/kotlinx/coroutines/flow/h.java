package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class h<T> extends AbstractFlow<T> {
    @NotNull
    private final Function2<FlowCollector<? super T>, Continuation<? super ur2>, Object> a;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super kotlin.coroutines.Continuation<? super tb.ur2>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super ur2>, ? extends Object> function2) {
        this.a = function2;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    @Nullable
    public Object a(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super ur2> continuation) {
        Object invoke = this.a.invoke(flowCollector, continuation);
        return invoke == b.d() ? invoke : ur2.INSTANCE;
    }
}
