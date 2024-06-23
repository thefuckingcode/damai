package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ij1;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final /* synthetic */ class e {
    @Nullable
    public static final Object a(@NotNull Flow<?> flow, @NotNull Continuation<? super ur2> continuation) {
        Object collect = flow.collect(ij1.INSTANCE, continuation);
        return collect == b.d() ? collect : ur2.INSTANCE;
    }

    @Nullable
    public static final <T> Object b(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super ur2>, ? extends Object> function2, @NotNull Continuation<? super ur2> continuation) {
        Object d = c.d(f.b(c.v(flow, function2), 0, null, 2, null), continuation);
        return d == b.d() ? d : ur2.INSTANCE;
    }

    @Nullable
    public static final <T> Object c(@NotNull FlowCollector<? super T> flowCollector, @NotNull Flow<? extends T> flow, @NotNull Continuation<? super ur2> continuation) {
        c.k(flowCollector);
        Object collect = flow.collect(flowCollector, continuation);
        return collect == b.d() ? collect : ur2.INSTANCE;
    }
}
