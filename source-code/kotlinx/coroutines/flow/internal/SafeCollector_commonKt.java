package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class SafeCollector_commonKt {
    @JvmName(name = "checkContext")
    public static final void a(@NotNull SafeCollector<?> safeCollector, @NotNull CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new SafeCollector_commonKt$checkContext$result$1(safeCollector))).intValue() != safeCollector.collectContextSize) {
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
        }
    }

    @Nullable
    public static final Job b(@Nullable Job job, @Nullable Job job2) {
        while (job != null) {
            if (job == job2 || !(job instanceof d)) {
                return job;
            }
            job = ((d) job).getParent$kotlinx_coroutines_core();
        }
        return null;
    }
}
