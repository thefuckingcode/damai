package kotlinx.coroutines.experimental;

import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u00012\u001a\b\u0004\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\b\u001a\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"CoroutineExceptionHandler", "Lkotlinx/coroutines/experimental/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: CoroutineExceptionHandler.kt */
public final class CoroutineExceptionHandlerKt {
    public static final void handleCoroutineException(CoroutineContext coroutineContext, Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.Key);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } else if (!(th instanceof CancellationException)) {
                Job job = (Job) coroutineContext.get(Job.Key);
                if (job != null) {
                    job.cancel(th);
                }
                CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(coroutineContext, th);
            }
        } catch (Throwable th2) {
            if (th2 == th) {
                throw th;
            }
            RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th);
            ExceptionsKt.addSuppressed(runtimeException, th2);
            throw runtimeException;
        }
    }

    public static final CoroutineExceptionHandler CoroutineExceptionHandler(Function2<? super CoroutineContext, ? super Throwable, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "handler");
        return new CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1(function2, CoroutineExceptionHandler.Key);
    }
}
