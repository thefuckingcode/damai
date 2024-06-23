package kotlinx.coroutines.experimental;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/experimental/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/experimental/ExecutorCoroutineDispatcherBase;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getExecutor$kotlinx_coroutines_core", "()Ljava/util/concurrent/Executor;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Executors.kt */
final class ExecutorCoroutineDispatcher extends ExecutorCoroutineDispatcherBase {
    private final Executor executor;

    public ExecutorCoroutineDispatcher(Executor executor2) {
        Intrinsics.checkParameterIsNotNull(executor2, "executor");
        this.executor = executor2;
    }

    @Override // kotlinx.coroutines.experimental.ExecutorCoroutineDispatcherBase
    public Executor getExecutor$kotlinx_coroutines_core() {
        return this.executor;
    }
}
