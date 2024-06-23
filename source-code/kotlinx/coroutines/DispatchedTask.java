package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d90;
import tb.hl;
import tb.if0;
import tb.k12;
import tb.k21;
import tb.n30;
import tb.or2;
import tb.qn;
import tb.sd2;
import tb.sn;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b!\u0010\"J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0004H ¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000e\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0016\u001a\u00020\u000bJ\u001a\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\tR\u0016\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8 @ X \u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "takenState", "", "cause", "Ltb/ur2;", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "state", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "run", "exception", "finallyException", "handleFatalException", "", "resumeMode", "I", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "<init>", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public abstract class DispatchedTask<T> extends Task {
    @JvmField
    public int resumeMode;

    public DispatchedTask(int i) {
        this.resumeMode = i;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object obj, @NotNull Throwable th) {
    }

    @NotNull
    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object obj) {
        hl hlVar = obj instanceof hl ? (hl) obj : null;
        if (hlVar == null) {
            return null;
        }
        return hlVar.a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object obj) {
        return obj;
    }

    public final void handleFatalException(@Nullable Throwable th, @Nullable Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                if0.a(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            k21.f(th);
            sn.a(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    public final void run() {
        Object obj;
        Object obj2;
        if (n30.a()) {
            if (!(this.resumeMode != -1)) {
                throw new AssertionError();
            }
        }
        TaskContext taskContext = this.taskContext;
        try {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) getDelegate$kotlinx_coroutines_core();
            Continuation<T> continuation = dispatchedContinuation.continuation;
            Object obj3 = dispatchedContinuation.countOrElement;
            CoroutineContext context = continuation.getContext();
            Object c = ThreadContextKt.c(context, obj3);
            or2<?> e = c != ThreadContextKt.NO_THREAD_ELEMENTS ? qn.e(continuation, context, c) : null;
            try {
                CoroutineContext context2 = continuation.getContext();
                Object takeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
                Job job = (exceptionalResult$kotlinx_coroutines_core != null || !d90.b(this.resumeMode)) ? null : (Job) context2.get(Job.Key);
                if (job != null && !job.isActive()) {
                    Throwable cancellationException = job.getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core, cancellationException);
                    Result.a aVar = Result.Companion;
                    if (n30.d()) {
                        if (continuation instanceof CoroutineStackFrame) {
                            cancellationException = sd2.a(cancellationException, (CoroutineStackFrame) continuation);
                        }
                    }
                    continuation.resumeWith(Result.m913constructorimpl(k12.a(cancellationException)));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    Result.a aVar2 = Result.Companion;
                    continuation.resumeWith(Result.m913constructorimpl(k12.a(exceptionalResult$kotlinx_coroutines_core)));
                } else {
                    T successfulResult$kotlinx_coroutines_core = getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
                    Result.a aVar3 = Result.Companion;
                    continuation.resumeWith(Result.m913constructorimpl(successfulResult$kotlinx_coroutines_core));
                }
                ur2 ur2 = ur2.INSTANCE;
                try {
                    Result.a aVar4 = Result.Companion;
                    taskContext.afterTask();
                    obj2 = Result.m913constructorimpl(ur2);
                } catch (Throwable th) {
                    Result.a aVar5 = Result.Companion;
                    obj2 = Result.m913constructorimpl(k12.a(th));
                }
                handleFatalException(null, Result.m916exceptionOrNullimpl(obj2));
                return;
            } finally {
                if (e == null || e.a()) {
                    ThreadContextKt.a(context, c);
                }
            }
        } catch (Throwable th2) {
            Result.a aVar6 = Result.Companion;
            obj = Result.m913constructorimpl(k12.a(th2));
        }
        handleFatalException(th, Result.m916exceptionOrNullimpl(obj));
    }

    @Nullable
    public abstract Object takeState$kotlinx_coroutines_core();
}
