package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.internal.Symbol;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\u001a \u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a%\u0010\n\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\f\u001a\u0002H\u0006H\u0000¢\u0006\u0002\u0010\r\u001a \u0010\u000e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a%\u0010\u0011\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\f\u001a\u0002H\u0006H\u0000¢\u0006\u0002\u0010\r\u001a \u0010\u0012\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\u0013"}, d2 = {"UNDEFINED", "Lkotlinx/coroutines/experimental/internal/Symbol;", "UNDEFINED$annotations", "()V", "dispatch", "", "T", "Lkotlinx/coroutines/experimental/DispatchedTask;", "mode", "", "resumeCancellable", "Lkotlin/coroutines/experimental/Continuation;", "value", "(Lkotlin/coroutines/experimental/Continuation;Ljava/lang/Object;)V", "resumeCancellableWithException", "exception", "", "resumeDirect", "resumeDirectWithException", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Dispatched.kt */
public final class DispatchedKt {
    private static final Symbol UNDEFINED = new Symbol("UNDEFINED");

    private static /* synthetic */ void UNDEFINED$annotations() {
    }

    public static final <T> void resumeCancellable(Continuation<? super T> continuation, T t) {
        Intrinsics.checkParameterIsNotNull(continuation, "$receiver");
        if (continuation instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            CoroutineContext context = dispatchedContinuation.continuation.getContext();
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
                DispatchedContinuation.access$set_state$p(dispatchedContinuation, t);
                dispatchedContinuation.setResumeMode(1);
                dispatchedContinuation.dispatcher.dispatch(context, dispatchedContinuation);
                return;
            }
            String updateThreadContext = CoroutineContextKt.updateThreadContext(dispatchedContinuation.getContext());
            try {
                dispatchedContinuation.continuation.resume(t);
                Unit unit = Unit.INSTANCE;
            } finally {
                CoroutineContextKt.restoreThreadContext(updateThreadContext);
            }
        } else {
            continuation.resume(t);
        }
    }

    public static final <T> void resumeCancellableWithException(Continuation<? super T> continuation, Throwable th) {
        Intrinsics.checkParameterIsNotNull(continuation, "$receiver");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        if (continuation instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            CoroutineContext context = dispatchedContinuation.continuation.getContext();
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
                DispatchedContinuation.access$set_state$p(dispatchedContinuation, new CompletedExceptionally(th));
                dispatchedContinuation.setResumeMode(1);
                dispatchedContinuation.dispatcher.dispatch(context, dispatchedContinuation);
                return;
            }
            String updateThreadContext = CoroutineContextKt.updateThreadContext(dispatchedContinuation.getContext());
            try {
                dispatchedContinuation.continuation.resumeWithException(th);
                Unit unit = Unit.INSTANCE;
            } finally {
                CoroutineContextKt.restoreThreadContext(updateThreadContext);
            }
        } else {
            continuation.resumeWithException(th);
        }
    }

    public static final <T> void resumeDirect(Continuation<? super T> continuation, T t) {
        Intrinsics.checkParameterIsNotNull(continuation, "$receiver");
        if (continuation instanceof DispatchedContinuation) {
            ((DispatchedContinuation) continuation).continuation.resume(t);
        } else {
            continuation.resume(t);
        }
    }

    public static final <T> void resumeDirectWithException(Continuation<? super T> continuation, Throwable th) {
        Intrinsics.checkParameterIsNotNull(continuation, "$receiver");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        if (continuation instanceof DispatchedContinuation) {
            ((DispatchedContinuation) continuation).continuation.resumeWithException(th);
        } else {
            continuation.resumeWithException(th);
        }
    }

    public static /* bridge */ /* synthetic */ void dispatch$default(DispatchedTask dispatchedTask, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        dispatch(dispatchedTask, i);
    }

    public static final <T> void dispatch(DispatchedTask<? super T> dispatchedTask, int i) {
        Intrinsics.checkParameterIsNotNull(dispatchedTask, "$receiver");
        Continuation<? super T> delegate = dispatchedTask.getDelegate();
        if (ResumeModeKt.isDispatchedMode(i) && (delegate instanceof DispatchedContinuation) && ResumeModeKt.isCancellableMode(i) == ResumeModeKt.isCancellableMode(dispatchedTask.getResumeMode())) {
            CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) delegate).dispatcher;
            CoroutineContext context = delegate.getContext();
            if (coroutineDispatcher.isDispatchNeeded(context)) {
                coroutineDispatcher.dispatch(context, dispatchedTask);
                return;
            }
            i = 3;
        }
        Object takeState = dispatchedTask.takeState();
        Throwable exceptionalResult = dispatchedTask.getExceptionalResult(takeState);
        if (exceptionalResult != null) {
            ResumeModeKt.resumeWithExceptionMode(delegate, exceptionalResult, i);
        } else {
            ResumeModeKt.resumeMode(delegate, dispatchedTask.getSuccessfulResult(takeState), i);
        }
    }
}
