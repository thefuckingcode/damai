package tb;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class lj2 {
    @JvmField
    public static final int BLOCKING_DEFAULT_PARALLELISM = oh2.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
    @JvmField
    public static final int CORE_POOL_SIZE;
    @NotNull
    public static final String DEFAULT_DISPATCHER_NAME = "Dispatchers.Default";
    @NotNull
    public static final String DEFAULT_SCHEDULER_NAME = "DefaultDispatcher";
    @JvmField
    public static final long IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(oh2.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));
    @JvmField
    public static final int MAX_POOL_SIZE;
    public static final int TASK_NON_BLOCKING = 0;
    public static final int TASK_PROBABLY_BLOCKING = 1;
    @JvmField
    public static final long WORK_STEALING_TIME_RESOLUTION_NS = oh2.e("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);
    @JvmField
    @NotNull
    public static g42 a = tg1.INSTANCE;

    static {
        int i = oh2.d("kotlinx.coroutines.scheduler.core.pool.size", ww1.a(mh2.a(), 2), 1, 0, 8, null);
        CORE_POOL_SIZE = i;
        MAX_POOL_SIZE = oh2.d("kotlinx.coroutines.scheduler.max.pool.size", ww1.f(mh2.a() * 128, i, CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE), 0, CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE, 4, null);
    }
}
