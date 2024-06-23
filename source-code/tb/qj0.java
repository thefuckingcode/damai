package tb;

import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class qj0 {
    public static final void a(@NotNull AbortFlowException abortFlowException, @NotNull FlowCollector<?> flowCollector) {
        if (abortFlowException.getOwner() != flowCollector) {
            throw abortFlowException;
        }
    }
}
