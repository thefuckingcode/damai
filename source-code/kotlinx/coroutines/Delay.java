package kotlinx.coroutines;

import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.p30;
import tb.p40;
import tb.ur2;

@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH&J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00022\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/Delay;", "", "", "time", "Ltb/ur2;", "delay", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/coroutines/CoroutineContext;", WPKFactory.INIT_KEY_CONTEXT, "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface Delay {

    /* compiled from: Taobao */
    public static final class a {
        @Nullable
        public static Object a(@NotNull Delay delay, long j, @NotNull Continuation<? super ur2> continuation) {
            if (j <= 0) {
                return ur2.INSTANCE;
            }
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            delay.scheduleResumeAfterDelay(j, cancellableContinuationImpl);
            Object result = cancellableContinuationImpl.getResult();
            if (result == b.d()) {
                p30.c(continuation);
            }
            return result == b.d() ? result : ur2.INSTANCE;
        }

        @NotNull
        public static DisposableHandle b(@NotNull Delay delay, long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
            return p40.a().invokeOnTimeout(j, runnable, coroutineContext);
        }
    }

    @Nullable
    Object delay(long j, @NotNull Continuation<? super ur2> continuation);

    @NotNull
    DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext);

    void scheduleResumeAfterDelay(long j, @NotNull CancellableContinuation<? super ur2> cancellableContinuation);
}
