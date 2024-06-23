package tb;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

public final class kl {
    public static final <T> Object a(Object obj, Continuation<? super T> continuation) {
        if (obj instanceof hl) {
            Result.a aVar = Result.Companion;
            Throwable th = ((hl) obj).a;
            if (n30.d() && (continuation instanceof CoroutineStackFrame)) {
                th = sd2.j(th, (CoroutineStackFrame) continuation);
            }
            return Result.m913constructorimpl(k12.a(th));
        }
        Result.a aVar2 = Result.Companion;
        return Result.m913constructorimpl(obj);
    }

    public static final <T> Object b(Object obj, Function1<? super Throwable, ur2> function1) {
        Throwable r0 = Result.m916exceptionOrNullimpl(obj);
        if (r0 != null) {
            return new hl(r0, false, 2, null);
        }
        if (function1 != null) {
            return new il(obj, function1);
        }
        return obj;
    }

    public static final <T> Object c(Object obj, CancellableContinuation<?> cancellableContinuation) {
        Throwable r0 = Result.m916exceptionOrNullimpl(obj);
        if (r0 != null) {
            if (n30.d() && (cancellableContinuation instanceof CoroutineStackFrame)) {
                r0 = sd2.j(r0, (CoroutineStackFrame) cancellableContinuation);
            }
            obj = new hl(r0, false, 2, null);
        }
        return obj;
    }

    public static /* synthetic */ Object d(Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return b(obj, function1);
    }
}
