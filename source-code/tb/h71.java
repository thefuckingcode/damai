package tb;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
final class h71 extends ExecutorCoroutineDispatcher implements Executor, TaskContext {
    private static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(h71.class, "inFlightTasks");
    @NotNull
    private final wf0 a;
    private final int b;
    @Nullable
    private final String c;
    private final int d;
    @NotNull
    private final ConcurrentLinkedQueue<Runnable> e = new ConcurrentLinkedQueue<>();
    @NotNull
    private volatile /* synthetic */ int inFlightTasks = 0;

    public h71(@NotNull wf0 wf0, int i, @Nullable String str, int i2) {
        this.a = wf0;
        this.b = i;
        this.c = str;
        this.d = i2;
    }

    private final void a(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.b) {
                this.a.b(runnable, this, z);
                return;
            }
            this.e.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) < this.b) {
                runnable = this.e.poll();
            } else {
                return;
            }
        } while (runnable != null);
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
        Runnable poll = this.e.poll();
        if (poll != null) {
            this.a.b(poll, this, true);
            return;
        }
        f.decrementAndGet(this);
        Runnable poll2 = this.e.poll();
        if (poll2 != null) {
            a(poll2, true);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        a(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        a(runnable, true);
    }

    public void execute(@NotNull Runnable runnable) {
        a(runnable, false);
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return this.d;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.a + jl1.ARRAY_END;
    }
}
