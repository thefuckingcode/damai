package tb;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.k;

public final class c90 {
    public static final jh2 REUSABLE_CLAIMED = new jh2("REUSABLE_CLAIMED");
    private static final jh2 a = new jh2("UNDEFINED");

    public static final <T> void b(Continuation<? super T> continuation, Object obj, Function1<? super Throwable, ur2> function1) {
        boolean z;
        if (continuation instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Object b = kl.b(obj, function1);
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(dispatchedContinuation.getContext())) {
                dispatchedContinuation._state = b;
                dispatchedContinuation.resumeMode = 1;
                dispatchedContinuation.dispatcher.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
                return;
            }
            n30.a();
            k b2 = ok2.INSTANCE.b();
            if (b2.isUnconfinedLoopActive()) {
                dispatchedContinuation._state = b;
                dispatchedContinuation.resumeMode = 1;
                b2.dispatchUnconfined(dispatchedContinuation);
                return;
            }
            b2.incrementUseCount(true);
            try {
                Job job = (Job) dispatchedContinuation.getContext().get(Job.Key);
                if (job == null || job.isActive()) {
                    z = false;
                } else {
                    CancellationException cancellationException = job.getCancellationException();
                    dispatchedContinuation.cancelCompletedResult$kotlinx_coroutines_core(b, cancellationException);
                    Result.a aVar = Result.Companion;
                    dispatchedContinuation.resumeWith(Result.m913constructorimpl(k12.a(cancellationException)));
                    z = true;
                }
                if (!z) {
                    Continuation<T> continuation2 = dispatchedContinuation.continuation;
                    Object obj2 = dispatchedContinuation.countOrElement;
                    CoroutineContext context = continuation2.getContext();
                    Object c = ThreadContextKt.c(context, obj2);
                    or2<?> e = c != ThreadContextKt.NO_THREAD_ELEMENTS ? qn.e(continuation2, context, c) : null;
                    try {
                        dispatchedContinuation.continuation.resumeWith(obj);
                        ur2 ur2 = ur2.INSTANCE;
                    } finally {
                        if (e == null || e.a()) {
                            ThreadContextKt.a(context, c);
                        }
                    }
                }
                do {
                } while (b2.processUnconfinedEvent());
            } catch (Throwable th) {
                b2.decrementUseCount(true);
                throw th;
            }
            b2.decrementUseCount(true);
            return;
        }
        continuation.resumeWith(obj);
    }

    public static /* synthetic */ void c(Continuation continuation, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        b(continuation, obj, function1);
    }

    public static final boolean d(DispatchedContinuation<? super ur2> dispatchedContinuation) {
        ur2 ur2 = ur2.INSTANCE;
        n30.a();
        k b = ok2.INSTANCE.b();
        if (b.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (b.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = ur2;
            dispatchedContinuation.resumeMode = 1;
            b.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        b.incrementUseCount(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (b.processUnconfinedEvent());
        } catch (Throwable th) {
            b.decrementUseCount(true);
            throw th;
        }
        b.decrementUseCount(true);
        return false;
    }
}
