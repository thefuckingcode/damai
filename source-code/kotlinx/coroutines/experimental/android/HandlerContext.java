package kotlinx.coroutines.experimental.android;

import android.os.Handler;
import android.view.Choreographer;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.experimental.CancellableContinuation;
import kotlinx.coroutines.experimental.CancellableContinuationImpl;
import kotlinx.coroutines.experimental.CoroutineDispatcher;
import kotlinx.coroutines.experimental.Delay;
import kotlinx.coroutines.experimental.DisposableHandle;

public final class HandlerContext extends CoroutineDispatcher implements Delay {
    private volatile Choreographer _choreographer;
    private final Handler handler;
    private final String name;

    @Override // kotlinx.coroutines.experimental.Delay
    public Object delay(long j, TimeUnit timeUnit, Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j, timeUnit, continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerContext(Handler handler2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler2, (i & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler2, String str) {
        Intrinsics.checkParameterIsNotNull(handler2, "handler");
        this.handler = handler2;
        this.name = str;
    }

    @Override // kotlinx.coroutines.experimental.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        this.handler.post(runnable);
    }

    @Override // kotlinx.coroutines.experimental.Delay
    public void scheduleResumeAfterDelay(long j, TimeUnit timeUnit, CancellableContinuation<? super Unit> cancellableContinuation) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "continuation");
        this.handler.postDelayed(new HandlerContext$scheduleResumeAfterDelay$1(this, cancellableContinuation), RangesKt.coerceAtMost(timeUnit.toMillis(j), 4611686018427387903L));
    }

    @Override // kotlinx.coroutines.experimental.Delay
    public DisposableHandle invokeOnTimeout(long j, TimeUnit timeUnit, Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        this.handler.postDelayed(runnable, RangesKt.coerceAtMost(timeUnit.toMillis(j), 4611686018427387903L));
        return new HandlerContext$invokeOnTimeout$1(this, runnable);
    }

    public final Object awaitFrame(Continuation<? super Long> continuation) {
        Choreographer choreographer = this._choreographer;
        if (choreographer != null) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            postFrameCallback(choreographer, cancellableContinuationImpl);
            return cancellableContinuationImpl.getResult();
        }
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 1);
        cancellableContinuationImpl2.initCancellability();
        this.handler.post(new HandlerContext$awaitFrame$$inlined$suspendCancellableCoroutine$lambda$1(cancellableContinuationImpl2, this));
        return cancellableContinuationImpl2.getResult();
    }

    /* access modifiers changed from: public */
    private final void updateChoreographerAndPostFrameCallback(CancellableContinuation<? super Long> cancellableContinuation) {
        Choreographer choreographer = this._choreographer;
        if (choreographer == null) {
            choreographer = Choreographer.getInstance();
            if (choreographer == null) {
                Intrinsics.throwNpe();
            }
            this._choreographer = choreographer;
        }
        postFrameCallback(choreographer, cancellableContinuation);
    }

    private final void postFrameCallback(Choreographer choreographer, CancellableContinuation<? super Long> cancellableContinuation) {
        choreographer.postFrameCallback(new HandlerContext$postFrameCallback$1(this, cancellableContinuation));
    }

    @Override // kotlinx.coroutines.experimental.CoroutineDispatcher
    public String toString() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        String handler2 = this.handler.toString();
        Intrinsics.checkExpressionValueIsNotNull(handler2, "handler.toString()");
        return handler2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).handler == this.handler;
    }

    public int hashCode() {
        return System.identityHashCode(this.handler);
    }
}
