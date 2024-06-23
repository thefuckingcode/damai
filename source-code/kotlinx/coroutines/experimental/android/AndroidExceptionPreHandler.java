package kotlinx.coroutines.experimental.android;

import java.lang.Thread;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.coroutines.experimental.AbstractCoroutineContextElement;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CoroutineExceptionHandler;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/experimental/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/experimental/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/experimental/CoroutineExceptionHandler;", "()V", "handleException", "", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "exception", "", "kotlinx-coroutines-android"}, k = 1, mv = {1, 1, 10})
/* compiled from: AndroidExceptionPreHandler.kt */
public final class AndroidExceptionPreHandler extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.Key);
    }

    @Override // kotlinx.coroutines.experimental.CoroutineExceptionHandler
    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        Method method = AndroidExceptionPreHandlerKt.getter;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
        Object invoke = method != null ? method.invoke(null, new Object[0]) : null;
        if (invoke instanceof Thread.UncaughtExceptionHandler) {
            uncaughtExceptionHandler = invoke;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = uncaughtExceptionHandler;
        if (uncaughtExceptionHandler2 != null) {
            uncaughtExceptionHandler2.uncaughtException(Thread.currentThread(), th);
        }
    }
}
