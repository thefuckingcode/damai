package kotlinx.coroutines.experimental;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"DefaultDelay", "Lkotlinx/coroutines/experimental/Delay;", "getDefaultDelay", "()Lkotlinx/coroutines/experimental/Delay;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: DefaultExecutor.kt */
public final class DefaultExecutorKt {
    private static final Delay DefaultDelay = DefaultExecutor.INSTANCE;

    public static final Delay getDefaultDelay() {
        return DefaultDelay;
    }
}
