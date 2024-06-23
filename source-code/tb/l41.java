package tb;

import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.JobSupport;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class l41 extends jl implements DisposableHandle, Incomplete {
    public JobSupport d;

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        v().removeNode$kotlinx_coroutines_core(this);
    }

    @Override // kotlinx.coroutines.Incomplete
    @Nullable
    public xi1 getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.b
    @NotNull
    public String toString() {
        return q30.a(this) + '@' + q30.b(this) + "[job@" + q30.b(v()) + jl1.ARRAY_END;
    }

    @NotNull
    public final JobSupport v() {
        JobSupport jobSupport = this.d;
        if (jobSupport != null) {
            return jobSupport;
        }
        k21.A("job");
        throw null;
    }

    public final void w(@NotNull JobSupport jobSupport) {
        this.d = jobSupport;
    }
}
