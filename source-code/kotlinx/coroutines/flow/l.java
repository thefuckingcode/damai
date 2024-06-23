package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import tb.ca2;
import tb.ek1;
import tb.jh2;
import tb.n30;

/* compiled from: Taobao */
public final class l {
    @NotNull
    private static final jh2 a = new jh2("NONE");
    @NotNull
    private static final jh2 b = new jh2("PENDING");

    @NotNull
    public static final <T> MutableStateFlow<T> a(T t) {
        if (t == null) {
            t = (T) ek1.NULL;
        }
        return new StateFlowImpl(t);
    }

    @NotNull
    public static final <T> Flow<T> d(@NotNull StateFlow<? extends T> stateFlow, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        boolean z = true;
        if (n30.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        if (i < 0 || i > 1) {
            z = false;
        }
        if ((z || i == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) {
            return stateFlow;
        }
        return ca2.a(stateFlow, coroutineContext, i, bufferOverflow);
    }

    public static final void e(@NotNull MutableStateFlow<Integer> mutableStateFlow, int i) {
        int intValue;
        do {
            intValue = mutableStateFlow.getValue().intValue();
        } while (!mutableStateFlow.compareAndSet(Integer.valueOf(intValue), Integer.valueOf(intValue + i)));
    }
}
