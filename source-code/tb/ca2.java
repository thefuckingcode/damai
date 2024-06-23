package tb;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ca2 {
    @JvmField
    @NotNull
    public static final jh2 NO_VALUE = new jh2("NO_VALUE");

    @NotNull
    public static final <T> Flow<T> a(@NotNull SharedFlow<? extends T> sharedFlow, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        if ((i == 0 || i == -3) && bufferOverflow == BufferOverflow.SUSPEND) {
            return sharedFlow;
        }
        return new vg(sharedFlow, coroutineContext, i, bufferOverflow);
    }
}
