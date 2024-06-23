package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* compiled from: Taobao */
final class g<T> implements StateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    @Nullable
    private final Job a;
    private final /* synthetic */ StateFlow<T> b;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.flow.StateFlow<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull StateFlow<? extends T> stateFlow, @Nullable Job job) {
        this.a = job;
        this.b = stateFlow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @InternalCoroutinesApi
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super ur2> continuation) {
        return this.b.collect(flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return l.d(this, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    @NotNull
    public List<T> getReplayCache() {
        return this.b.getReplayCache();
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        return this.b.getValue();
    }
}
