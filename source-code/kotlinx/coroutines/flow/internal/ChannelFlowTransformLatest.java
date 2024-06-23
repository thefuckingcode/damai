package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m40;
import tb.n30;
import tb.o82;
import tb.pj0;
import tb.qc;
import tb.ur2;

/* compiled from: Taobao */
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {
    @NotNull
    private final Function3<FlowCollector<? super R>, T, Continuation<? super ur2>, Object> e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelFlowTransformLatest(Function3 function3, Flow flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, m40 m40) {
        this(function3, flow, (i2 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 8) != 0 ? -2 : i, (i2 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ChannelFlow<R> d(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.e, this.d, coroutineContext, i, bufferOverflow);
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    @Nullable
    public Object k(@NotNull FlowCollector<? super R> flowCollector, @NotNull Continuation<? super ur2> continuation) {
        if (!n30.a() || qc.a(flowCollector instanceof o82).booleanValue()) {
            Object a = pj0.a(new ChannelFlowTransformLatest$flowCollect$3(this, flowCollector, null), continuation);
            return a == b.d() ? a : ur2.INSTANCE;
        }
        throw new AssertionError();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T, ? super kotlin.coroutines.Continuation<? super tb.ur2>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(@NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super ur2>, ? extends Object> function3, @NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        super(flow, coroutineContext, i, bufferOverflow);
        this.e = function3;
    }
}
