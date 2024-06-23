package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class UndispatchedContextCollector<T> implements FlowCollector<T> {
    @NotNull
    private final CoroutineContext a;
    @NotNull
    private final Object b;
    @NotNull
    private final Function2<T, Continuation<? super ur2>, Object> c;

    public UndispatchedContextCollector(@NotNull FlowCollector<? super T> flowCollector, @NotNull CoroutineContext coroutineContext) {
        this.a = coroutineContext;
        this.b = ThreadContextKt.b(coroutineContext);
        this.c = new UndispatchedContextCollector$emitRef$1(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
        Object b2 = a.b(this.a, t, this.b, this.c, continuation);
        return b2 == b.d() ? b2 : ur2.INSTANCE;
    }
}
