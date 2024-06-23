package tb;

import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@InternalCoroutinesApi
/* compiled from: Taobao */
public final class zi1 implements ChildHandle, DisposableHandle {
    @NotNull
    public static final zi1 INSTANCE = new zi1();

    private zi1() {
    }

    @Override // kotlinx.coroutines.ChildHandle
    public boolean childCancelled(@NotNull Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
    }

    @Override // kotlinx.coroutines.ChildHandle
    @Nullable
    public Job getParent() {
        return null;
    }

    @NotNull
    public String toString() {
        return "NonDisposableHandle";
    }
}
