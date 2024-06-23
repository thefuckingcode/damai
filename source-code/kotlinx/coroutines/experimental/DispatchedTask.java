package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001d\u0010\u0010\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u000fH&R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/experimental/DispatchedTask;", "T", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/experimental/Runnable;", "delegate", "Lkotlin/coroutines/experimental/Continuation;", "getDelegate", "()Lkotlin/coroutines/experimental/Continuation;", "resumeMode", "", "getResumeMode", "()I", "getExceptionalResult", "", "state", "", "getSuccessfulResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "run", "", "takeState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Dispatched.kt */
public interface DispatchedTask<T> extends Runnable {
    Continuation<T> getDelegate();

    Throwable getExceptionalResult(Object obj);

    int getResumeMode();

    <T> T getSuccessfulResult(Object obj);

    void run();

    Object takeState();

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    /* compiled from: Dispatched.kt */
    public static final class DefaultImpls {
        public static <T> int getResumeMode(DispatchedTask<? super T> dispatchedTask) {
            return 1;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public static <T_I1, T> T getSuccessfulResult(DispatchedTask<? super T_I1> dispatchedTask, Object obj) {
            return obj;
        }

        public static <T> Throwable getExceptionalResult(DispatchedTask<? super T> dispatchedTask, Object obj) {
            if (!(obj instanceof CompletedExceptionally)) {
                obj = null;
            }
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            if (completedExceptionally != null) {
                return completedExceptionally.cause;
            }
            return null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: kotlin.coroutines.experimental.Continuation<T> */
        /* JADX WARN: Multi-variable type inference failed */
        public static <T> void run(DispatchedTask<? super T> dispatchedTask) {
            try {
                Continuation<? super T> delegate = dispatchedTask.getDelegate();
                if (delegate != null) {
                    Continuation<T> continuation = ((DispatchedContinuation) delegate).continuation;
                    CoroutineContext context = continuation.getContext();
                    Job job = ResumeModeKt.isCancellableMode(dispatchedTask.getResumeMode()) ? (Job) context.get(Job.Key) : null;
                    Object takeState = dispatchedTask.takeState();
                    String updateThreadContext = CoroutineContextKt.updateThreadContext(context);
                    if (job != null) {
                        try {
                            if (!job.isActive()) {
                                continuation.resumeWithException(job.getCancellationException());
                                Unit unit = Unit.INSTANCE;
                                CoroutineContextKt.restoreThreadContext(updateThreadContext);
                                return;
                            }
                        } catch (Throwable th) {
                            CoroutineContextKt.restoreThreadContext(updateThreadContext);
                            throw th;
                        }
                    }
                    Throwable exceptionalResult = dispatchedTask.getExceptionalResult(takeState);
                    if (exceptionalResult != null) {
                        continuation.resumeWithException(exceptionalResult);
                    } else {
                        continuation.resume(dispatchedTask.getSuccessfulResult(takeState));
                    }
                    Unit unit2 = Unit.INSTANCE;
                    CoroutineContextKt.restoreThreadContext(updateThreadContext);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.DispatchedContinuation<T>");
            } catch (Throwable th2) {
                throw new DispatchException("Unexpected exception running " + dispatchedTask, th2);
            }
        }
    }
}
