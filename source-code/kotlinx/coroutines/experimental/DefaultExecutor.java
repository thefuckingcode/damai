package kotlinx.coroutines.experimental;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.RangesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\r\u0010\u0017\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0018J\b\u0010\u0019\u001a\u00020\u0011H\u0014J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\bJ\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118TX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, d2 = {"Lkotlinx/coroutines/experimental/DefaultExecutor;", "Lkotlinx/coroutines/experimental/EventLoopBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/experimental/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "_thread", "Ljava/lang/Thread;", "debugStatus", "isCompleted", "", "()Z", "isShutdownRequested", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "isCorrectThread", "notifyStartup", "run", "shutdown", "timeout", "thread", "unpark", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: DefaultExecutor.kt */
public final class DefaultExecutor extends EventLoopBase implements Runnable {
    private static final int ACTIVE = 1;
    private static final long DEFAULT_KEEP_ALIVE = 1000;
    private static final int FRESH = 0;
    public static final DefaultExecutor INSTANCE = new DefaultExecutor();
    private static final long KEEP_ALIVE_NANOS;
    private static final int SHUTDOWN_ACK = 3;
    private static final int SHUTDOWN_REQ = 2;
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.EventLoopBase
    public boolean isCompleted() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.EventLoopBase
    public boolean isCorrectThread() {
        return true;
    }

    static {
        Long l;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", (long) DEFAULT_KEEP_ALIVE);
        } catch (SecurityException unused) {
            l = Long.valueOf((long) DEFAULT_KEEP_ALIVE);
        }
        Intrinsics.checkExpressionValueIsNotNull(l, "try {\n            java.l…AULT_KEEP_ALIVE\n        }");
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l.longValue());
    }

    private DefaultExecutor() {
    }

    private final boolean isShutdownRequested() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    public void run() {
        TimeSourceKt.getTimeSource().registerTimeLoopThread();
        try {
            if (notifyStartup()) {
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long processNextEvent = processNextEvent();
                    if (processNextEvent == LongCompanionObject.MAX_VALUE) {
                        if (j == LongCompanionObject.MAX_VALUE) {
                            long nanoTime = TimeSourceKt.getTimeSource().nanoTime();
                            if (j == LongCompanionObject.MAX_VALUE) {
                                j = KEEP_ALIVE_NANOS + nanoTime;
                            }
                            long j2 = j - nanoTime;
                            if (j2 <= 0) {
                                _thread = null;
                                acknowledgeShutdownIfNeeded();
                                TimeSourceKt.getTimeSource().unregisterTimeLoopThread();
                                if (!isEmpty()) {
                                    thread();
                                    return;
                                }
                                return;
                            }
                            processNextEvent = RangesKt.coerceAtMost(processNextEvent, j2);
                        } else {
                            processNextEvent = RangesKt.coerceAtMost(processNextEvent, KEEP_ALIVE_NANOS);
                        }
                    }
                    if (processNextEvent > 0) {
                        if (isShutdownRequested()) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            TimeSourceKt.getTimeSource().unregisterTimeLoopThread();
                            if (!isEmpty()) {
                                thread();
                                return;
                            }
                            return;
                        }
                        TimeSourceKt.getTimeSource().parkNanos(this, processNextEvent);
                    }
                }
            }
        } finally {
            _thread = null;
            acknowledgeShutdownIfNeeded();
            TimeSourceKt.getTimeSource().unregisterTimeLoopThread();
            if (!isEmpty()) {
                thread();
            }
        }
    }

    private final Thread thread() {
        Thread thread = _thread;
        return thread != null ? thread : createThreadSync();
    }

    private final synchronized Thread createThreadSync() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.EventLoopBase
    public void unpark() {
        TimeSourceKt.getTimeSource().unpark(thread());
    }

    public final synchronized void ensureStarted$kotlinx_coroutines_core() {
        Thread thread = _thread;
        if (debugStatus != 0) {
            int i = debugStatus;
        }
        debugStatus = 0;
        createThreadSync();
        while (debugStatus == 0) {
            wait();
        }
    }

    private final synchronized boolean notifyStartup() {
        if (isShutdownRequested()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
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
                TimeSourceKt.getTimeSource().unpark(thread);
            }
            if (currentTimeMillis - System.currentTimeMillis() <= 0) {
                break;
            }
            wait(j);
        }
        debugStatus = 0;
    }

    private final synchronized void acknowledgeShutdownIfNeeded() {
        if (isShutdownRequested()) {
            debugStatus = 3;
            resetAll();
            notifyAll();
        }
    }
}
