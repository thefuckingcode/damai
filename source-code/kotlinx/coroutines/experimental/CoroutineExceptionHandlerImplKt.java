package kotlinx.coroutines.experimental;

import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: CoroutineExceptionHandlerImpl.kt */
public final class CoroutineExceptionHandlerImplKt {
    public static final void handleCoroutineExceptionImpl(CoroutineContext coroutineContext, Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        ServiceLoader<CoroutineExceptionHandler> load = ServiceLoader.load(CoroutineExceptionHandler.class);
        Intrinsics.checkExpressionValueIsNotNull(load, "ServiceLoader.load(Corou…ptionHandler::class.java)");
        for (CoroutineExceptionHandler coroutineExceptionHandler : load) {
            coroutineExceptionHandler.handleException(coroutineContext, th);
        }
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "currentThread");
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
