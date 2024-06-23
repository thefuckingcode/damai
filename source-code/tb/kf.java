package tb;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class kf {
    @InternalCoroutinesApi
    public static final void a(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull DisposableHandle disposableHandle) {
        cancellableContinuation.invokeOnCancellation(new j90(disposableHandle));
    }

    @NotNull
    public static final <T> CancellableContinuationImpl<T> b(@NotNull Continuation<? super T> continuation) {
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl<>(continuation, 1);
        }
        CancellableContinuationImpl<T> claimReusableCancellableContinuation = ((DispatchedContinuation) continuation).claimReusableCancellableContinuation();
        if (claimReusableCancellableContinuation == null || !claimReusableCancellableContinuation.resetStateReusable()) {
            claimReusableCancellableContinuation = null;
        }
        return claimReusableCancellableContinuation == null ? new CancellableContinuationImpl<>(continuation, 2) : claimReusableCancellableContinuation;
    }

    public static final void c(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull b bVar) {
        cancellableContinuation.invokeOnCancellation(new rz1(bVar));
    }
}
