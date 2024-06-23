package tb;

import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class zk2 implements FlowCollector<Object> {
    @JvmField
    @NotNull
    public final Throwable a;

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(@Nullable Object obj, @NotNull Continuation<? super ur2> continuation) {
        throw this.a;
    }
}
