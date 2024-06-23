package kotlinx.coroutines.experimental;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\b¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u001c\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\u0010\r\u001a\u00060\u0017j\u0002`\u0018H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0002J\r\u0010\u001a\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\b\u0010 \u001a\u00020\u0004H\u0016J\r\u0010\t\u001a\u00020\u0014H\u0000¢\u0006\u0002\b!R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkotlinx/coroutines/experimental/CommonPool;", "Lkotlinx/coroutines/experimental/CoroutineDispatcher;", "()V", "DEFAULT_PARALLELISM_PROPERTY_NAME", "", "parallelism", "", "pool", "Ljava/util/concurrent/Executor;", "usePrivatePool", "", "Try", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "createPlainPool", "Ljava/util/concurrent/ExecutorService;", "createPool", "dispatch", "", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/experimental/Runnable;", "getOrCreatePoolSync", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "", "shutdown$kotlinx_coroutines_core", "toString", "usePrivatePool$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: CommonPool.kt */
public final class CommonPool extends CoroutineDispatcher {
    public static final String DEFAULT_PARALLELISM_PROPERTY_NAME = "kotlinx.coroutines.default.parallelism";
    public static final CommonPool INSTANCE = new CommonPool();
    private static final int parallelism;
    private static volatile Executor pool;
    private static boolean usePrivatePool;

    @Override // kotlinx.coroutines.experimental.CoroutineDispatcher
    public String toString() {
        return "CommonPool";
    }

    static {
        String str;
        int i;
        try {
            str = System.getProperty(DEFAULT_PARALLELISM_PROPERTY_NAME);
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            i = RangesKt.coerceAtLeast(Runtime.getRuntime().availableProcessors() - 1, 1);
        } else {
            Integer intOrNull = StringsKt.toIntOrNull(str);
            if (intOrNull == null || intOrNull.intValue() < 1) {
                throw new IllegalStateException(("Expected positive number in kotlinx.coroutines.default.parallelism, but has " + str).toString());
            }
            i = intOrNull.intValue();
        }
        parallelism = i;
    }

    private CommonPool() {
    }

    private final <T> T Try(Function0<? extends T> function0) {
        try {
            return (T) function0.invoke();
        } catch (Throwable unused) {
            return null;
        }
    }

    private final ExecutorService createPool() {
        Class<?> cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return createPlainPool();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return createPlainPool();
        }
        if (!usePrivatePool) {
            try {
                Method method = cls.getMethod("commonPool", new Class[0]);
                Object invoke = method != null ? method.invoke(null, new Object[0]) : null;
                if (!(invoke instanceof ExecutorService)) {
                    invoke = null;
                }
                executorService = (ExecutorService) invoke;
            } catch (Throwable unused2) {
                executorService = null;
            }
            if (executorService != null) {
                return executorService;
            }
        }
        try {
            Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(parallelism));
            if (!(newInstance instanceof ExecutorService)) {
                newInstance = null;
            }
            executorService2 = (ExecutorService) newInstance;
        } catch (Throwable unused3) {
        }
        if (executorService2 != null) {
            return executorService2;
        }
        return createPlainPool();
    }

    private final ExecutorService createPlainPool() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(parallelism, new CommonPool$createPlainPool$1(new AtomicInteger()));
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "Executors.newFixedThread…Daemon = true }\n        }");
        return newFixedThreadPool;
    }

    private final synchronized Executor getOrCreatePoolSync() {
        ExecutorService executorService;
        executorService = pool;
        if (executorService == null) {
            ExecutorService createPool = createPool();
            pool = createPool;
            executorService = createPool;
        }
        return executorService;
    }

    @Override // kotlinx.coroutines.experimental.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = getOrCreatePoolSync();
            }
            executor.execute(TimeSourceKt.getTimeSource().trackTask(runnable));
        } catch (RejectedExecutionException unused) {
            TimeSourceKt.getTimeSource().unTrackTask();
            DefaultExecutor.INSTANCE.execute$kotlinx_coroutines_core(runnable);
        }
    }

    public final synchronized void usePrivatePool$kotlinx_coroutines_core() {
        shutdown$kotlinx_coroutines_core(0);
        usePrivatePool = true;
        pool = null;
    }

    public final synchronized void shutdown$kotlinx_coroutines_core(long j) {
        Executor executor = pool;
        if (!(executor instanceof ExecutorService)) {
            executor = null;
        }
        ExecutorService executorService = (ExecutorService) executor;
        if (executorService != null) {
            executorService.shutdown();
            if (j > 0) {
                executorService.awaitTermination(j, TimeUnit.MILLISECONDS);
            }
            List<Runnable> shutdownNow = executorService.shutdownNow();
            Intrinsics.checkExpressionValueIsNotNull(shutdownNow, "shutdownNow()");
            for (T t : shutdownNow) {
                DefaultExecutor defaultExecutor = DefaultExecutor.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(t, "it");
                defaultExecutor.execute$kotlinx_coroutines_core(t);
            }
        }
        pool = CommonPool$shutdown$2.INSTANCE;
    }

    public final synchronized void restore$kotlinx_coroutines_core() {
        shutdown$kotlinx_coroutines_core(0);
        usePrivatePool = false;
        pool = null;
    }
}
