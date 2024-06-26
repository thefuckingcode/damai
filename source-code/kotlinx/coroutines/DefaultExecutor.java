package kotlinx.coroutines;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.flutter.wpkbridge.WPKFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l2;
import tb.n30;
import tb.ok2;
import tb.ww1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b.\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\f\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u000f\u0010\u0014\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\nR\u0016\u0010\u0018\u001a\u00020\u00178\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010\u0013R\u0016\u0010!\u001a\u00020 8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020 8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b#\u0010\"R\u0016\u0010$\u001a\u00020 8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b%\u0010\"R\u0016\u0010&\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010'\u001a\u00020\u00068B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00048T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00068@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b,\u0010(¨\u0006/"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Thread;", "createThreadSync", "", "notifyStartup", "Ltb/ur2;", "acknowledgeShutdownIfNeeded", "", "timeMillis", "block", "Lkotlin/coroutines/CoroutineContext;", WPKFactory.INIT_KEY_CONTEXT, "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "run", "ensureStarted$kotlinx_coroutines_core", "()V", "ensureStarted", "timeout", "shutdown", "", "THREAD_NAME", "Ljava/lang/String;", "DEFAULT_KEEP_ALIVE", "J", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "", "FRESH", "I", "ACTIVE", "SHUTDOWN_REQ", "SHUTDOWN_ACK", "debugStatus", "isShutdownRequested", "()Z", "getThread", "()Ljava/lang/Thread;", "thread", "isThreadPresent$kotlinx_coroutines_core", "isThreadPresent", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    private static final int ACTIVE = 1;
    private static final long DEFAULT_KEEP_ALIVE = 1000;
    private static final int FRESH = 0;
    @NotNull
    public static final DefaultExecutor INSTANCE;
    private static final long KEEP_ALIVE_NANOS;
    private static final int SHUTDOWN_ACK = 3;
    private static final int SHUTDOWN_REQ = 2;
    @NotNull
    public static final String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";
    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long l;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        INSTANCE = defaultExecutor;
        k.incrementUseCount$default(defaultExecutor, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l.longValue());
    }

    private DefaultExecutor() {
    }

    private final synchronized void acknowledgeShutdownIfNeeded() {
        if (isShutdownRequested()) {
            debugStatus = 3;
            resetAll();
            notifyAll();
        }
    }

    private final synchronized Thread createThreadSync() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, THREAD_NAME);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private static /* synthetic */ void get_thread$annotations() {
    }

    private final boolean isShutdownRequested() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    private final synchronized boolean notifyStartup() {
        if (isShutdownRequested()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    public final synchronized void ensureStarted$kotlinx_coroutines_core() {
        boolean z = true;
        if (n30.a()) {
            if (!(_thread == null)) {
                throw new AssertionError();
            }
        }
        if (n30.a()) {
            if (debugStatus != 0) {
                if (debugStatus != 3) {
                    z = false;
                }
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        debugStatus = 0;
        createThreadSync();
        while (debugStatus == 0) {
            wait();
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.l
    @NotNull
    public Thread getThread() {
        Thread thread = _thread;
        return thread == null ? createThreadSync() : thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return scheduleInvokeOnTimeout(j, runnable);
    }

    public final boolean isThreadPresent$kotlinx_coroutines_core() {
        return _thread != null;
    }

    public void run() {
        ok2.INSTANCE.d(this);
        l2.a();
        try {
            if (notifyStartup()) {
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long processNextEvent = processNextEvent();
                    if (processNextEvent == AbsPerformance.LONG_NIL) {
                        l2.a();
                        long nanoTime = System.nanoTime();
                        if (j == AbsPerformance.LONG_NIL) {
                            j = KEEP_ALIVE_NANOS + nanoTime;
                        }
                        long j2 = j - nanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            l2.a();
                            if (!isEmpty()) {
                                getThread();
                                return;
                            }
                            return;
                        }
                        processNextEvent = ww1.e(processNextEvent, j2);
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (processNextEvent > 0) {
                        if (isShutdownRequested()) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            l2.a();
                            if (!isEmpty()) {
                                getThread();
                                return;
                            }
                            return;
                        }
                        l2.a();
                        LockSupport.parkNanos(this, processNextEvent);
                    }
                }
            }
        } finally {
            _thread = null;
            acknowledgeShutdownIfNeeded();
            l2.a();
            if (!isEmpty()) {
                getThread();
            }
        }
    }

    public final synchronized void shutdown(long j) {
        long currentTimeMillis = System.currentTimeMillis() + j;
        if (!isShutdownRequested()) {
            debugStatus = 2;
        }
        while (true) {
            if (debugStatus == 3 || _thread == null) {
                break;
            }
            Thread thread = _thread;
            if (thread != null) {
                l2.a();
                LockSupport.unpark(thread);
            }
            if (currentTimeMillis - System.currentTimeMillis() <= 0) {
                break;
            }
            wait(j);
        }
        debugStatus = 0;
    }
}
