package tb;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ij1 implements FlowCollector<Object> {
    @NotNull
    public static final ij1 INSTANCE = new ij1();

    private ij1() {
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(@Nullable Object obj, @NotNull Continuation<? super ur2> continuation) {
        return ur2.INSTANCE;
    }
}
