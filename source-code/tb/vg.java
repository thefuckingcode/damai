package tb;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class vg<T> extends ChannelFlowOperator<T, T> {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ vg(Flow flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, m40 m40) {
        this(flow, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 4) != 0 ? -3 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ChannelFlow<T> d(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return new vg(this.d, coroutineContext, i, bufferOverflow);
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    @Nullable
    public Object k(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super ur2> continuation) {
        Object collect = this.d.collect(flowCollector, continuation);
        return collect == b.d() ? collect : ur2.INSTANCE;
    }

    public vg(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        super(flow, coroutineContext, i, bufferOverflow);
    }
}
