package kotlinx.coroutines.experimental;

import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.DispatchedTask;

public final class DispatchedContinuation<T> implements Continuation<T>, DispatchedTask<T> {
    private Object _state = DispatchedKt.UNDEFINED;
    public final Continuation<T> continuation;
    public final CoroutineDispatcher dispatcher;
    private int resumeMode;

    @Override // kotlin.coroutines.experimental.Continuation
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.coroutines.experimental.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation2) {
        Intrinsics.checkParameterIsNotNull(coroutineDispatcher, "dispatcher");
        Intrinsics.checkParameterIsNotNull(continuation2, "continuation");
        this.dispatcher = coroutineDispatcher;
        this.continuation = continuation2;
    }

    @Override // kotlinx.coroutines.experimental.DispatchedTask
    public Throwable getExceptionalResult(Object obj) {
        return DispatchedTask.DefaultImpls.getExceptionalResult(this, obj);
    }

    @Override // kotlinx.coroutines.experimental.DispatchedTask
    public <T> T getSuccessfulResult(Object obj) {
        return (T) DispatchedTask.DefaultImpls.getSuccessfulResult(this, obj);
    }

    @Override // kotlinx.coroutines.experimental.DispatchedTask
    public void run() {
        DispatchedTask.DefaultImpls.run(this);
    }

    @Override // kotlinx.coroutines.experimental.DispatchedTask
    public int getResumeMode() {
        return this.resumeMode;
    }

    public void setResumeMode(int i) {
        this.resumeMode = i;
    }

    @Override // kotlinx.coroutines.experimental.DispatchedTask
    public Object takeState() {
        Object obj = this._state;
        if (obj != DispatchedKt.UNDEFINED) {
            this._state = DispatchedKt.UNDEFINED;
            return obj;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // kotlinx.coroutines.experimental.DispatchedTask
    public Continuation<T> getDelegate() {
        return this;
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resume(T t) {
        CoroutineContext context = this.continuation.getContext();
        if (this.dispatcher.isDispatchNeeded(context)) {
            this._state = t;
            setResumeMode(0);
            this.dispatcher.dispatch(context, this);
            return;
        }
        String updateThreadContext = CoroutineContextKt.updateThreadContext(getContext());
        try {
            this.continuation.resume(t);
            Unit unit = Unit.INSTANCE;
        } finally {
            CoroutineContextKt.restoreThreadContext(updateThreadContext);
        }
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resumeWithException(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        CoroutineContext context = this.continuation.getContext();
        if (this.dispatcher.isDispatchNeeded(context)) {
            this._state = new CompletedExceptionally(th);
            setResumeMode(0);
            this.dispatcher.dispatch(context, this);
            return;
        }
        String updateThreadContext = CoroutineContextKt.updateThreadContext(getContext());
        try {
            this.continuation.resumeWithException(th);
            Unit unit = Unit.INSTANCE;
        } finally {
            CoroutineContextKt.restoreThreadContext(updateThreadContext);
        }
    }

    public final void resumeCancellable(T t) {
        CoroutineContext context = this.continuation.getContext();
        if (this.dispatcher.isDispatchNeeded(context)) {
            this._state = t;
            setResumeMode(1);
            this.dispatcher.dispatch(context, this);
            return;
        }
        String updateThreadContext = CoroutineContextKt.updateThreadContext(getContext());
        try {
            this.continuation.resume(t);
            Unit unit = Unit.INSTANCE;
        } finally {
            InlineMarker.finallyStart(1);
            CoroutineContextKt.restoreThreadContext(updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }

    public final void resumeCancellableWithException(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        CoroutineContext context = this.continuation.getContext();
        if (this.dispatcher.isDispatchNeeded(context)) {
            this._state = new CompletedExceptionally(th);
            setResumeMode(1);
            this.dispatcher.dispatch(context, this);
            return;
        }
        String updateThreadContext = CoroutineContextKt.updateThreadContext(getContext());
        try {
            this.continuation.resumeWithException(th);
            Unit unit = Unit.INSTANCE;
        } finally {
            InlineMarker.finallyStart(1);
            CoroutineContextKt.restoreThreadContext(updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }

    public final void resumeUndispatched(T t) {
        String updateThreadContext = CoroutineContextKt.updateThreadContext(getContext());
        try {
            this.continuation.resume(t);
            Unit unit = Unit.INSTANCE;
        } finally {
            InlineMarker.finallyStart(1);
            CoroutineContextKt.restoreThreadContext(updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }

    public final void resumeUndispatchedWithException(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        String updateThreadContext = CoroutineContextKt.updateThreadContext(getContext());
        try {
            this.continuation.resumeWithException(th);
            Unit unit = Unit.INSTANCE;
        } finally {
            InlineMarker.finallyStart(1);
            CoroutineContextKt.restoreThreadContext(updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }

    public final void dispatchYield$kotlinx_coroutines_core(T t) {
        CoroutineContext context = this.continuation.getContext();
        this._state = t;
        setResumeMode(1);
        this.dispatcher.dispatch(context, this);
    }

    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + DebugKt.toDebugString(this.continuation) + ']';
    }
}
