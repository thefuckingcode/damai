package tb;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.k;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class d90 {
    public static final int MODE_ATOMIC = 0;
    public static final int MODE_CANCELLABLE = 1;
    public static final int MODE_CANCELLABLE_REUSABLE = 2;
    public static final int MODE_UNDISPATCHED = 4;
    public static final int MODE_UNINITIALIZED = -1;

    public static final <T> void a(@NotNull DispatchedTask<? super T> dispatchedTask, int i) {
        boolean z = true;
        if (n30.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        Continuation<? super T> delegate$kotlinx_coroutines_core = dispatchedTask.getDelegate$kotlinx_coroutines_core();
        if (i != 4) {
            z = false;
        }
        if (z || !(delegate$kotlinx_coroutines_core instanceof DispatchedContinuation) || b(i) != b(dispatchedTask.resumeMode)) {
            d(dispatchedTask, delegate$kotlinx_coroutines_core, z);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) delegate$kotlinx_coroutines_core).dispatcher;
        CoroutineContext context = delegate$kotlinx_coroutines_core.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, dispatchedTask);
        } else {
            e(dispatchedTask);
        }
    }

    public static final boolean b(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean c(int i) {
        return i == 2;
    }

    public static final <T> void d(@NotNull DispatchedTask<? super T> dispatchedTask, @NotNull Continuation<? super T> continuation, boolean z) {
        Object obj;
        Object takeState$kotlinx_coroutines_core = dispatchedTask.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = dispatchedTask.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            Result.a aVar = Result.Companion;
            obj = k12.a(exceptionalResult$kotlinx_coroutines_core);
        } else {
            Result.a aVar2 = Result.Companion;
            obj = dispatchedTask.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        }
        Object r3 = Result.m913constructorimpl(obj);
        if (z) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Continuation<T> continuation2 = dispatchedContinuation.continuation;
            Object obj2 = dispatchedContinuation.countOrElement;
            CoroutineContext context = continuation2.getContext();
            Object c = ThreadContextKt.c(context, obj2);
            or2<?> e = c != ThreadContextKt.NO_THREAD_ELEMENTS ? qn.e(continuation2, context, c) : null;
            try {
                dispatchedContinuation.continuation.resumeWith(r3);
                ur2 ur2 = ur2.INSTANCE;
            } finally {
                if (e == null || e.a()) {
                    ThreadContextKt.a(context, c);
                }
            }
        } else {
            continuation.resumeWith(r3);
        }
    }

    private static final void e(DispatchedTask<?> dispatchedTask) {
        k b = ok2.INSTANCE.b();
        if (b.isUnconfinedLoopActive()) {
            b.dispatchUnconfined(dispatchedTask);
            return;
        }
        b.incrementUseCount(true);
        try {
            d(dispatchedTask, dispatchedTask.getDelegate$kotlinx_coroutines_core(), true);
            do {
            } while (b.processUnconfinedEvent());
        } catch (Throwable th) {
            b.decrementUseCount(true);
            throw th;
        }
        b.decrementUseCount(true);
    }
}
