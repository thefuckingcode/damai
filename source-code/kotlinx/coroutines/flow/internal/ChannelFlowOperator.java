package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.o82;
import tb.ur2;

/* compiled from: Taobao */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {
    @JvmField
    @NotNull
    protected final Flow<S> d;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.flow.Flow<? extends S> */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(@NotNull Flow<? extends S> flow, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.d = flow;
    }

    static /* synthetic */ Object h(ChannelFlowOperator channelFlowOperator, FlowCollector flowCollector, Continuation continuation) {
        if (channelFlowOperator.b == -3) {
            CoroutineContext context = continuation.getContext();
            CoroutineContext plus = context.plus(channelFlowOperator.a);
            if (k21.d(plus, context)) {
                Object k = channelFlowOperator.k(flowCollector, continuation);
                return k == b.d() ? k : ur2.INSTANCE;
            }
            ContinuationInterceptor.b bVar = ContinuationInterceptor.Key;
            if (k21.d(plus.get(bVar), context.get(bVar))) {
                Object j = channelFlowOperator.j(flowCollector, plus, continuation);
                return j == b.d() ? j : ur2.INSTANCE;
            }
        }
        Object collect = super.collect(flowCollector, continuation);
        return collect == b.d() ? collect : ur2.INSTANCE;
    }

    static /* synthetic */ Object i(ChannelFlowOperator channelFlowOperator, ProducerScope producerScope, Continuation continuation) {
        Object k = channelFlowOperator.k(new o82(producerScope), continuation);
        return k == b.d() ? k : ur2.INSTANCE;
    }

    private final Object j(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext, Continuation<? super ur2> continuation) {
        Object c = a.c(coroutineContext, a.a(flowCollector, continuation.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), continuation, 4, null);
        return c == b.d() ? c : ur2.INSTANCE;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object c(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super ur2> continuation) {
        return i(this, producerScope, continuation);
    }

    @Override // kotlinx.coroutines.flow.Flow, kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super ur2> continuation) {
        return h(this, flowCollector, continuation);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract Object k(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super ur2> continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public String toString() {
        return this.d + " -> " + super.toString();
    }
}
