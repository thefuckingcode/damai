package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068&@'X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/ChildHandle;", "Lkotlinx/coroutines/DisposableHandle;", "", "cause", "", "childCancelled", "Lkotlinx/coroutines/Job;", "getParent", "()Lkotlinx/coroutines/Job;", "getParent$annotations", "()V", "parent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface ChildHandle extends DisposableHandle {
    @InternalCoroutinesApi
    boolean childCancelled(@NotNull Throwable th);

    @Nullable
    Job getParent();
}
