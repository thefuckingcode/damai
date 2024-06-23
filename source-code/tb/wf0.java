package tb;

import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;

@InternalCoroutinesApi
/* compiled from: Taobao */
public class wf0 extends ExecutorCoroutineDispatcher {
    private final int a;
    private final int b;
    private final long c;
    @NotNull
    private final String d;
    @NotNull
    private CoroutineScheduler e;

    public wf0(int i, int i2, long j, @NotNull String str) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = str;
        this.e = a();
    }

    private final CoroutineScheduler a() {
        return new CoroutineScheduler(this.a, this.b, this.c, this.d);
    }

    public final void b(@NotNull Runnable runnable, @NotNull TaskContext taskContext, boolean z) {
        try {
            this.e.f(runnable, taskContext, z);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.enqueue(this.e.d(runnable, taskContext));
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.g(this.e, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.dispatch(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.g(this.e, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.dispatchYield(coroutineContext, runnable);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ wf0(int i, int i2, String str, int i3, m40 m40) {
        this((i3 & 1) != 0 ? lj2.CORE_POOL_SIZE : i, (i3 & 2) != 0 ? lj2.MAX_POOL_SIZE : i2, (i3 & 4) != 0 ? lj2.DEFAULT_SCHEDULER_NAME : str);
    }

    public wf0(int i, int i2, @NotNull String str) {
        this(i, i2, lj2.IDLE_WORKER_KEEP_ALIVE_NS, str);
    }
}
