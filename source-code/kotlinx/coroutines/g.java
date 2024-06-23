package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.l2;
import tb.qk;
import tb.rk;
import tb.ww1;

/* compiled from: Taobao */
public final class g extends ExecutorCoroutineDispatcher {
    @NotNull
    public static final g INSTANCE = new g();
    private static final int a;
    private static boolean b;
    @Nullable
    private static volatile Executor pool;

    static {
        String str;
        int i;
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            i = -1;
        } else {
            Integer num = n.k(str);
            if (num == null || num.intValue() < 1) {
                throw new IllegalStateException(k21.r("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", str).toString());
            }
            i = num.intValue();
        }
        a = i;
    }

    private g() {
    }

    private final ExecutorService c() {
        return Executors.newFixedThreadPool(g(), new rk(new AtomicInteger()));
    }

    /* access modifiers changed from: private */
    public static final Thread d(AtomicInteger atomicInteger, Runnable runnable) {
        Thread thread = new Thread(runnable, k21.r("CommonPool-worker-", Integer.valueOf(atomicInteger.incrementAndGet())));
        thread.setDaemon(true);
        return thread;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d  */
    private final ExecutorService e() {
        Class<?> cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return c();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return c();
        }
        if (!b && a < 0) {
            try {
                Object invoke = cls.getMethod("commonPool", new Class[0]).invoke(null, new Object[0]);
                if (invoke instanceof ExecutorService) {
                    executorService = (ExecutorService) invoke;
                    if (executorService != null) {
                        if (!INSTANCE.h(cls, executorService)) {
                            executorService = null;
                        }
                        if (executorService != null) {
                            return executorService;
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            executorService = null;
            if (executorService != null) {
            }
        }
        try {
            Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(INSTANCE.g()));
            if (newInstance instanceof ExecutorService) {
                executorService2 = (ExecutorService) newInstance;
            }
        } catch (Throwable unused3) {
        }
        return executorService2 == null ? c() : executorService2;
    }

    private final synchronized Executor f() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = e();
            pool = executor;
        }
        return executor;
    }

    private final int g() {
        Integer valueOf = Integer.valueOf(a);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf == null) {
            return ww1.a(Runtime.getRuntime().availableProcessors() - 1, 1);
        }
        return valueOf.intValue();
    }

    /* access modifiers changed from: private */
    public static final void j() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = f();
            }
            l2.a();
            executor.execute(runnable);
        } catch (RejectedExecutionException unused) {
            l2.a();
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    public final boolean h(@NotNull Class<?> cls, @NotNull ExecutorService executorService) {
        executorService.submit(qk.a);
        Integer num = null;
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (invoke instanceof Integer) {
                num = (Integer) invoke;
            }
        } catch (Throwable unused) {
        }
        if (num != null && num.intValue() >= 1) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "CommonPool";
    }
}
