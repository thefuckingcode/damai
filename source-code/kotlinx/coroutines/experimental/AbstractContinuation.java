package kotlinx.coroutines.experimental;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.DispatchedTask;
import kotlinx.coroutines.experimental.Job;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\"\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\f2\u0006\u0010)\u001a\u00020\u0006H\u0004J\n\u0010*\u001a\u0004\u0018\u00010\fH\u0001J\u0010\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u001fH\u0002J\u0017\u0010-\u001a\u00020!2\b\u0010.\u001a\u0004\u0018\u00010/H\u0000¢\u0006\u0002\b0J/\u00101\u001a\u00020!2'\u00102\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001f¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020!03j\u0002`6J\u001f\u00107\u001a\u0002082\u0014\u00109\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020!03H\bJ1\u0010:\u001a\u00020;2'\u00102\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001f¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020!03j\u0002`6H\u0002J\b\u0010<\u001a\u00020=H\u0014J\u0010\u0010>\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0006H\u0002J\u0015\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010AJ\u001a\u0010B\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0004J\u0010\u0010C\u001a\u00020!2\u0006\u0010,\u001a\u00020\u001fH\u0016J\b\u0010D\u001a\u00020=H\u0002J\n\u0010E\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010F\u001a\u00020=H\u0016J\u001a\u0010G\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010H\u001a\u00020\u0010H\u0002J\b\u0010I\u001a\u00020\u0010H\u0002J\u001a\u0010J\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\fH\u0004J\"\u0010K\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\b\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010)\u001a\u00020\u0006H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00108TX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011¨\u0006L"}, d2 = {"Lkotlinx/coroutines/experimental/AbstractContinuation;", "T", "Lkotlin/coroutines/experimental/Continuation;", "Lkotlinx/coroutines/experimental/DispatchedTask;", "delegate", "resumeMode", "", "(Lkotlin/coroutines/experimental/Continuation;I)V", "_decision", "Lkotlinx/atomicfu/AtomicInt;", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "getDelegate", "()Lkotlin/coroutines/experimental/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "parentHandle", "Lkotlinx/coroutines/experimental/DisposableHandle;", "getResumeMode", "()I", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "useCancellingState", "getUseCancellingState", "cancel", "cause", "", "coerceWithException", "", "Lkotlinx/coroutines/experimental/Cancelling;", "proposedUpdate", "Lkotlinx/coroutines/experimental/CompletedExceptionally;", "completeStateUpdate", "expect", "Lkotlinx/coroutines/experimental/NotCompleted;", "update", "mode", "getResult", "handleException", "exception", "initParentJobInternal", "parent", "Lkotlinx/coroutines/experimental/Job;", "initParentJobInternal$kotlinx_coroutines_core", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", SerializableCookie.NAME, "Lkotlinx/coroutines/experimental/CompletionHandler;", "loopOnState", "", "block", "makeHandler", "Lkotlinx/coroutines/experimental/CancelHandler;", "nameString", "", "onCompletionInternal", "resume", "value", "(Ljava/lang/Object;)V", "resumeImpl", "resumeWithException", "stateString", "takeState", "toString", "tryCancel", "tryResume", "trySuspend", "tryUpdateStateToFinal", "updateStateToFinal", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: AbstractContinuation.kt */
public abstract class AbstractContinuation<T> implements Continuation<T>, DispatchedTask<T> {
    private static final AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(AbstractContinuation.class, "_decision");
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(AbstractContinuation.class, Object.class, "_state");
    private volatile int _decision = 0;
    private volatile Object _state = AbstractContinuationKt.ACTIVE;
    private final Continuation<T> delegate;
    private volatile DisposableHandle parentHandle;
    private final int resumeMode;

    /* access modifiers changed from: protected */
    public boolean getUseCancellingState() {
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.coroutines.experimental.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractContinuation(Continuation<? super T> continuation, int i) {
        Intrinsics.checkParameterIsNotNull(continuation, "delegate");
        this.delegate = continuation;
        this.resumeMode = i;
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
    public final Continuation<T> getDelegate() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.experimental.DispatchedTask
    public final int getResumeMode() {
        return this.resumeMode;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return this._state;
    }

    public final boolean isActive() {
        return getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    public final boolean isCancelled() {
        return getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    public final void initParentJobInternal$kotlinx_coroutines_core(Job job) {
        if (!(this.parentHandle == null)) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (job == null) {
            this.parentHandle = NonDisposableHandle.INSTANCE;
        } else {
            job.start();
            DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new ChildContinuation(job, this), 2, null);
            this.parentHandle = invokeOnCompletion$default;
            if (isCompleted()) {
                invokeOnCompletion$default.dispose();
                this.parentHandle = NonDisposableHandle.INSTANCE;
            }
        }
    }

    @Override // kotlinx.coroutines.experimental.DispatchedTask
    public Object takeState() {
        return getState$kotlinx_coroutines_core();
    }

    public final Object getResult() {
        if (trySuspend()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
            return getSuccessfulResult(state$kotlinx_coroutines_core);
        }
        throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resume(T t) {
        resumeImpl(t, this.resumeMode);
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resumeWithException(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        resumeImpl(new CompletedExceptionally(th), this.resumeMode);
    }

    public final void invokeOnCancellation(Function1<? super Throwable, Unit> function1) {
        Object state$kotlinx_coroutines_core;
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        Throwable th = null;
        CancelHandler cancelHandler = null;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Active) {
                if (cancelHandler == null) {
                    cancelHandler = makeHandler(function1);
                }
            } else if (state$kotlinx_coroutines_core instanceof CancelHandler) {
                throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + state$kotlinx_coroutines_core).toString());
            } else if (state$kotlinx_coroutines_core instanceof CancelledContinuation) {
                if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                    state$kotlinx_coroutines_core = null;
                }
                CompletedExceptionally completedExceptionally = (CompletedExceptionally) state$kotlinx_coroutines_core;
                if (completedExceptionally != null) {
                    th = completedExceptionally.cause;
                }
                function1.invoke(th);
                return;
            } else if (state$kotlinx_coroutines_core instanceof Cancelling) {
                throw new IllegalStateException("Cancellation handlers for continuations with 'Cancelling' state are not supported".toString());
            } else {
                return;
            }
        } while (!_state$FU.compareAndSet(this, state$kotlinx_coroutines_core, cancelHandler));
    }

    private final CancelHandler makeHandler(Function1<? super Throwable, Unit> function1) {
        return function1 instanceof CancelHandler ? (CancelHandler) function1 : new InvokeOnCancel(function1);
    }

    private final boolean tryCancel(NotCompleted notCompleted, Throwable th) {
        if (!getUseCancellingState()) {
            return updateStateToFinal(notCompleted, new CancelledContinuation(this, th), 0);
        }
        if (!(notCompleted instanceof CancelHandler)) {
            return _state$FU.compareAndSet(this, notCompleted, new Cancelling(new CancelledContinuation(this, th)));
        }
        throw new IllegalArgumentException("Invariant: 'Cancelling' state and cancellation handlers cannot be used together".toString());
    }

    private final void onCompletionInternal(int i) {
        if (!tryResume()) {
            DispatchedKt.dispatch(this, i);
        }
    }

    /* access modifiers changed from: protected */
    public final Void loopOnState(Function1<Object, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        while (true) {
            function1.invoke(getState$kotlinx_coroutines_core());
        }
    }

    private final void coerceWithException(Cancelling cancelling, CompletedExceptionally completedExceptionally) {
        CancelledContinuation cancelledContinuation = cancelling.cancel;
        Throwable th = cancelledContinuation.cause;
        Throwable th2 = completedExceptionally.cause;
        if (!((cancelledContinuation.cause instanceof CancellationException) && th.getCause() == th2.getCause()) && th.getCause() != th2) {
            ExceptionsKt.addSuppressed(completedExceptionally.cause, th);
        }
    }

    private final boolean updateStateToFinal(NotCompleted notCompleted, Object obj, int i) {
        if (!tryUpdateStateToFinal(notCompleted, obj)) {
            return false;
        }
        completeStateUpdate(notCompleted, obj, i);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean tryUpdateStateToFinal(NotCompleted notCompleted, Object obj) {
        Intrinsics.checkParameterIsNotNull(notCompleted, "expect");
        if (!(!(obj instanceof NotCompleted))) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!_state$FU.compareAndSet(this, notCompleted, obj)) {
            return false;
        } else {
            DisposableHandle disposableHandle = this.parentHandle;
            if (disposableHandle != null) {
                disposableHandle.dispose();
                this.parentHandle = NonDisposableHandle.INSTANCE;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final void completeStateUpdate(NotCompleted notCompleted, Object obj, int i) {
        Intrinsics.checkParameterIsNotNull(notCompleted, "expect");
        Throwable th = null;
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(obj instanceof CompletedExceptionally) ? null : obj);
        onCompletionInternal(i);
        if ((obj instanceof CancelledContinuation) && (notCompleted instanceof CancelHandler)) {
            try {
                CancelHandler cancelHandler = (CancelHandler) notCompleted;
                if (completedExceptionally != null) {
                    th = completedExceptionally.cause;
                }
                cancelHandler.invoke(th);
            } catch (Throwable th2) {
                handleException(new CompletionHandlerException("Exception in completion handler " + notCompleted + " for " + this, th2));
            }
        }
    }

    private final void handleException(Throwable th) {
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
    }

    public String toString() {
        return nameString() + '{' + stateString() + "}@" + DebugKt.getHexAddress(this);
    }

    /* access modifiers changed from: protected */
    public String nameString() {
        return DebugKt.getClassSimpleName(this);
    }

    private final String stateString() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof NotCompleted) {
            return "Active";
        }
        if (state$kotlinx_coroutines_core instanceof CancelledContinuation) {
            return "Cancelled";
        }
        return state$kotlinx_coroutines_core instanceof CompletedExceptionally ? "CompletedExceptionally" : "Completed";
    }

    public final boolean cancel(Throwable th) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof NotCompleted) || (state$kotlinx_coroutines_core instanceof Cancelling)) {
                return false;
            }
        } while (!tryCancel((NotCompleted) state$kotlinx_coroutines_core, th));
        return true;
    }

    private final boolean trySuspend() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 1));
        return true;
    }

    private final boolean tryResume() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 2));
        return true;
    }

    /* access modifiers changed from: protected */
    public final void resumeImpl(Object obj, int i) {
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Cancelling) {
                if (!(obj instanceof CompletedExceptionally)) {
                    if (updateStateToFinal((NotCompleted) state$kotlinx_coroutines_core, ((Cancelling) state$kotlinx_coroutines_core).cancel, i)) {
                        return;
                    }
                } else {
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                    if (completedExceptionally.cause instanceof CancellationException) {
                        coerceWithException((Cancelling) state$kotlinx_coroutines_core, completedExceptionally);
                    } else {
                        Throwable th = completedExceptionally.cause;
                        Throwable th2 = ((Cancelling) state$kotlinx_coroutines_core).cancel.cause;
                        if (!(th2 instanceof CancellationException) || th2.getCause() != th) {
                            ExceptionsKt.addSuppressed(th, th2);
                        }
                        completedExceptionally = new CompletedExceptionally(th);
                    }
                    if (updateStateToFinal((NotCompleted) state$kotlinx_coroutines_core, completedExceptionally, i)) {
                        return;
                    }
                }
            } else if (state$kotlinx_coroutines_core instanceof NotCompleted) {
                if (updateStateToFinal((NotCompleted) state$kotlinx_coroutines_core, obj, i)) {
                    return;
                }
            } else if (!(state$kotlinx_coroutines_core instanceof CancelledContinuation)) {
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            } else if ((obj instanceof NotCompleted) || (obj instanceof CompletedExceptionally)) {
                throw new IllegalStateException(("Unexpected update, state: " + state$kotlinx_coroutines_core + ", update: " + obj).toString());
            } else {
                return;
            }
        }
    }
}
