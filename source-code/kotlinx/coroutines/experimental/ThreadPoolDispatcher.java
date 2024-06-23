package kotlinx.coroutines.experimental;

import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.model.HttpHeaders;
import java.io.Closeable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/experimental/ThreadPoolDispatcher;", "Lkotlinx/coroutines/experimental/ExecutorCoroutineDispatcherBase;", "Ljava/io/Closeable;", "nThreads", "", SerializableCookie.NAME, "", "(ILjava/lang/String;)V", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "getExecutor$kotlinx_coroutines_core", "()Ljava/util/concurrent/ScheduledExecutorService;", "threadNo", "Ljava/util/concurrent/atomic/AtomicInteger;", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: ThreadPoolDispatcher.kt */
public final class ThreadPoolDispatcher extends ExecutorCoroutineDispatcherBase implements Closeable {
    private final ScheduledExecutorService executor;
    private final int nThreads;
    private final String name;
    private final AtomicInteger threadNo = new AtomicInteger();

    public ThreadPoolDispatcher(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
        this.nThreads = i;
        this.name = str;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(i, new ThreadPoolDispatcher$executor$1(this));
        Intrinsics.checkExpressionValueIsNotNull(newScheduledThreadPool, "Executors.newScheduledTh….incrementAndGet())\n    }");
        this.executor = newScheduledThreadPool;
    }

    @Override // kotlinx.coroutines.experimental.ExecutorCoroutineDispatcherBase
    public ScheduledExecutorService getExecutor$kotlinx_coroutines_core() {
        return this.executor;
    }

    @Override // java.io.Closeable, kotlinx.coroutines.experimental.ExecutorCoroutineDispatcherBase, java.lang.AutoCloseable
    public void close() {
        getExecutor$kotlinx_coroutines_core().shutdown();
    }

    @Override // kotlinx.coroutines.experimental.CoroutineDispatcher, kotlinx.coroutines.experimental.ExecutorCoroutineDispatcherBase
    public String toString() {
        return "ThreadPoolDispatcher[" + this.nThreads + ", " + this.name + ']';
    }
}
