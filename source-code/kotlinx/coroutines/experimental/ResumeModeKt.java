package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\u001a-\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0014\u001a\u0002H\u00122\u0006\u0010\u0015\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0016\u001a(\u0010\u0017\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e\"\u0018\u0010\u000f\u001a\u00020\r*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_DIRECT", "MODE_DIRECT$annotations", "MODE_IGNORE", "MODE_IGNORE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "resumeMode", "", "T", "Lkotlin/coroutines/experimental/Continuation;", "value", "mode", "(Lkotlin/coroutines/experimental/Continuation;Ljava/lang/Object;I)V", "resumeWithExceptionMode", "exception", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: ResumeMode.kt */
public final class ResumeModeKt {
    public static final int MODE_ATOMIC_DEFAULT = 0;
    public static final int MODE_CANCELLABLE = 1;
    public static final int MODE_DIRECT = 2;
    public static final int MODE_IGNORE = 4;
    public static final int MODE_UNDISPATCHED = 3;

    public static /* synthetic */ void MODE_ATOMIC_DEFAULT$annotations() {
    }

    public static /* synthetic */ void MODE_CANCELLABLE$annotations() {
    }

    public static /* synthetic */ void MODE_DIRECT$annotations() {
    }

    public static /* synthetic */ void MODE_IGNORE$annotations() {
    }

    public static /* synthetic */ void MODE_UNDISPATCHED$annotations() {
    }

    public static final boolean isCancellableMode(int i) {
        return i == 1;
    }

    public static final boolean isDispatchedMode(int i) {
        return i == 0 || i == 1;
    }

    public static final <T> void resumeMode(Continuation<? super T> continuation, T t, int i) {
        Intrinsics.checkParameterIsNotNull(continuation, "$receiver");
        if (i == 0) {
            continuation.resume(t);
        } else if (i == 1) {
            DispatchedKt.resumeCancellable(continuation, t);
        } else if (i == 2) {
            DispatchedKt.resumeDirect(continuation, t);
        } else if (i == 3) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            String updateThreadContext = CoroutineContextKt.updateThreadContext(dispatchedContinuation.getContext());
            try {
                dispatchedContinuation.continuation.resume(t);
                Unit unit = Unit.INSTANCE;
            } finally {
                CoroutineContextKt.restoreThreadContext(updateThreadContext);
            }
        } else if (i != 4) {
            throw new IllegalStateException(("Invalid mode " + i).toString());
        }
    }

    public static final <T> void resumeWithExceptionMode(Continuation<? super T> continuation, Throwable th, int i) {
        Intrinsics.checkParameterIsNotNull(continuation, "$receiver");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        if (i == 0) {
            continuation.resumeWithException(th);
        } else if (i == 1) {
            DispatchedKt.resumeCancellableWithException(continuation, th);
        } else if (i == 2) {
            DispatchedKt.resumeDirectWithException(continuation, th);
        } else if (i == 3) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            String updateThreadContext = CoroutineContextKt.updateThreadContext(dispatchedContinuation.getContext());
            try {
                dispatchedContinuation.continuation.resumeWithException(th);
                Unit unit = Unit.INSTANCE;
            } finally {
                CoroutineContextKt.restoreThreadContext(updateThreadContext);
            }
        } else if (i != 4) {
            throw new IllegalStateException(("Invalid mode " + i).toString());
        }
    }
}
