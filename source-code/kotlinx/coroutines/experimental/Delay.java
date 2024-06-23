package kotlinx.coroutines.experimental;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\b\u0002\u0010\u0006\u001a\u00060\u0007j\u0002`\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\n\u0010\f\u001a\u00060\rj\u0002`\u000eH\u0016J*\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H&\u0002\u0004\n\u0002\b\t¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/experimental/Delay;", "", "delay", "", "time", "", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlinx/coroutines/experimental/timeunit/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "invokeOnTimeout", "Lkotlinx/coroutines/experimental/DisposableHandle;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/experimental/Runnable;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Delay.kt */
public interface Delay {
    Object delay(long j, TimeUnit timeUnit, Continuation<? super Unit> continuation);

    DisposableHandle invokeOnTimeout(long j, TimeUnit timeUnit, Runnable runnable);

    void scheduleResumeAfterDelay(long j, TimeUnit timeUnit, CancellableContinuation<? super Unit> cancellableContinuation);

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    /* compiled from: Delay.kt */
    public static final class DefaultImpls {
        public static /* bridge */ /* synthetic */ Object delay$default(Delay delay, long j, TimeUnit timeUnit, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    timeUnit = TimeUnit.MILLISECONDS;
                }
                return delay.delay(j, timeUnit, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delay");
        }

        public static Object delay(Delay delay, long j, TimeUnit timeUnit, Continuation<? super Unit> continuation) {
            if (j <= 0) {
                return Unit.INSTANCE;
            }
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            delay.scheduleResumeAfterDelay(j, timeUnit, cancellableContinuationImpl);
            return cancellableContinuationImpl.getResult();
        }

        public static DisposableHandle invokeOnTimeout(Delay delay, long j, TimeUnit timeUnit, Runnable runnable) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
            Intrinsics.checkParameterIsNotNull(runnable, "block");
            return DefaultExecutorKt.getDefaultDelay().invokeOnTimeout(j, timeUnit, runnable);
        }
    }
}
