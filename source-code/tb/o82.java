package tb;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@InternalCoroutinesApi
/* compiled from: Taobao */
public final class o82<T> implements FlowCollector<T> {
    @NotNull
    private final SendChannel<T> a;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.channels.SendChannel<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public o82(@NotNull SendChannel<? super T> sendChannel) {
        this.a = sendChannel;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
        Object send = this.a.send(t, continuation);
        return send == b.d() ? send : ur2.INSTANCE;
    }
}
