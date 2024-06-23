package kotlinx.coroutines;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gc0;
import tb.k12;
import tb.p30;
import tb.p40;
import tb.ur2;
import tb.ww1;

/* compiled from: Taobao */
public final class DelayKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final Object a(@NotNull Continuation<?> continuation) {
        DelayKt$awaitCancellation$1 delayKt$awaitCancellation$1;
        int i;
        if (continuation instanceof DelayKt$awaitCancellation$1) {
            delayKt$awaitCancellation$1 = (DelayKt$awaitCancellation$1) continuation;
            int i2 = delayKt$awaitCancellation$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                delayKt$awaitCancellation$1.label = i2 - Integer.MIN_VALUE;
                Object obj = delayKt$awaitCancellation$1.result;
                Object obj2 = b.d();
                i = delayKt$awaitCancellation$1.label;
                if (i != 0) {
                    k12.b(obj);
                    delayKt$awaitCancellation$1.label = 1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(delayKt$awaitCancellation$1), 1);
                    cancellableContinuationImpl.initCancellability();
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == b.d()) {
                        p30.c(delayKt$awaitCancellation$1);
                    }
                    if (result == obj2) {
                        return obj2;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    k12.b(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        delayKt$awaitCancellation$1 = new DelayKt$awaitCancellation$1(continuation);
        Object obj3 = delayKt$awaitCancellation$1.result;
        Object obj22 = b.d();
        i = delayKt$awaitCancellation$1.label;
        if (i != 0) {
        }
        throw new KotlinNothingValueException();
    }

    @Nullable
    public static final Object b(long j, @NotNull Continuation<? super ur2> continuation) {
        if (j <= 0) {
            return ur2.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (j < AbsPerformance.LONG_NIL) {
            c(cancellableContinuationImpl.getContext()).scheduleResumeAfterDelay(j, cancellableContinuationImpl);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == b.d()) {
            p30.c(continuation);
        }
        return result == b.d() ? result : ur2.INSTANCE;
    }

    @NotNull
    public static final Delay c(@NotNull CoroutineContext coroutineContext) {
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.Key);
        Delay delay = element instanceof Delay ? (Delay) element : null;
        return delay == null ? p40.a() : delay;
    }

    @ExperimentalTime
    public static final long d(long j) {
        if (gc0.d(j, gc0.Companion.a()) > 0) {
            return ww1.b(gc0.z(j), 1);
        }
        return 0;
    }
}
