package kotlinx.coroutines.experimental;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a'\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\f\b\u0002\u0010\n\u001a\u00060\u000bj\u0002`\fH@ø\u0001\u0000¢\u0006\u0002\u0010\r\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0004\n\u0002\b\t¨\u0006\u000e"}, d2 = {"delay", "Lkotlinx/coroutines/experimental/Delay;", "Lkotlin/coroutines/experimental/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/experimental/CoroutineContext;)Lkotlinx/coroutines/experimental/Delay;", "", "time", "", "(ILkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlinx/coroutines/experimental/timeunit/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Delay.kt */
public final class DelayKt {
    public static final Object delay(int i, Continuation<? super Unit> continuation) {
        return delay((long) i, TimeUnit.MILLISECONDS, continuation);
    }

    public static /* bridge */ /* synthetic */ Object delay$default(long j, TimeUnit timeUnit, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return delay(j, timeUnit, continuation);
    }

    public static final Object delay(long j, TimeUnit timeUnit, Continuation<? super Unit> continuation) {
        if (j <= 0) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        getDelay(cancellableContinuationImpl2.getContext()).scheduleResumeAfterDelay(j, timeUnit, cancellableContinuationImpl2);
        return cancellableContinuationImpl.getResult();
    }

    public static final Delay getDelay(CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "$receiver");
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.Key);
        if (!(element instanceof Delay)) {
            element = null;
        }
        Delay delay = (Delay) element;
        return delay != null ? delay : DefaultExecutorKt.getDefaultDelay();
    }
}
