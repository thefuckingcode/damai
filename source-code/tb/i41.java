package tb;

import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class i41 extends JobSupport implements CompletableJob {
    private final boolean a = a();

    public i41(@Nullable Job job) {
        super(true);
        initParentJob(job);
    }

    private final boolean a() {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        uh uhVar = parentHandle$kotlinx_coroutines_core instanceof uh ? (uh) parentHandle$kotlinx_coroutines_core : null;
        if (uhVar == null) {
            return false;
        }
        JobSupport v = uhVar.v();
        while (!v.getHandlesException$kotlinx_coroutines_core()) {
            ChildHandle parentHandle$kotlinx_coroutines_core2 = v.getParentHandle$kotlinx_coroutines_core();
            uh uhVar2 = parentHandle$kotlinx_coroutines_core2 instanceof uh ? (uh) parentHandle$kotlinx_coroutines_core2 : null;
            if (uhVar2 == null) {
                return false;
            }
            v = uhVar2.v();
        }
        return true;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean complete() {
        return makeCompleting$kotlinx_coroutines_core(ur2.INSTANCE);
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean completeExceptionally(@NotNull Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new hl(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.a;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
