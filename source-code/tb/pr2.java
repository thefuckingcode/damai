package tb;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.d;
import kotlinx.coroutines.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class pr2 {
    /* JADX INFO: finally extract failed */
    public static final <T> void a(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Continuation a = p30.a(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object c = ThreadContextKt.c(context, null);
            if (function1 != null) {
                try {
                    Object invoke = ((Function1) po2.e(function1, 1)).invoke(a);
                    ThreadContextKt.a(context, c);
                    if (invoke != b.d()) {
                        Result.a aVar = Result.Companion;
                        a.resumeWith(Result.m913constructorimpl(invoke));
                    }
                } catch (Throwable th) {
                    ThreadContextKt.a(context, c);
                    throw th;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            a.resumeWith(Result.m913constructorimpl(k12.a(th2)));
        }
    }

    /* JADX INFO: finally extract failed */
    public static final <R, T> void b(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Continuation a = p30.a(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object c = ThreadContextKt.c(context, null);
            if (function2 != null) {
                try {
                    Object invoke = ((Function2) po2.e(function2, 2)).invoke(r, a);
                    ThreadContextKt.a(context, c);
                    if (invoke != b.d()) {
                        Result.a aVar = Result.Companion;
                        a.resumeWith(Result.m913constructorimpl(invoke));
                    }
                } catch (Throwable th) {
                    ThreadContextKt.a(context, c);
                    throw th;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            a.resumeWith(Result.m913constructorimpl(k12.a(th2)));
        }
    }

    public static final <T> void c(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Continuation a = p30.a(continuation);
        if (function1 != null) {
            try {
                Object invoke = ((Function1) po2.e(function1, 1)).invoke(a);
                if (invoke != b.d()) {
                    Result.a aVar = Result.Companion;
                    a.resumeWith(Result.m913constructorimpl(invoke));
                }
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                a.resumeWith(Result.m913constructorimpl(k12.a(th)));
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    public static final <R, T> void d(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Continuation a = p30.a(continuation);
        if (function2 != null) {
            try {
                Object invoke = ((Function2) po2.e(function2, 2)).invoke(r, a);
                if (invoke != b.d()) {
                    Result.a aVar = Result.Companion;
                    a.resumeWith(Result.m913constructorimpl(invoke));
                }
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                a.resumeWith(Result.m913constructorimpl(k12.a(th)));
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    @Nullable
    public static final <T, R> Object e(@NotNull d<? super T> dVar, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object obj;
        if (function2 != null) {
            try {
                obj = ((Function2) po2.e(function2, 2)).invoke(r, dVar);
            } catch (Throwable th) {
                obj = new hl(th, false, 2, null);
            }
            if (obj == b.d()) {
                return b.d();
            }
            Object makeCompletingOnce$kotlinx_coroutines_core = dVar.makeCompletingOnce$kotlinx_coroutines_core(obj);
            if (makeCompletingOnce$kotlinx_coroutines_core == q.COMPLETING_WAITING_CHILDREN) {
                return b.d();
            }
            if (!(makeCompletingOnce$kotlinx_coroutines_core instanceof hl)) {
                return q.h(makeCompletingOnce$kotlinx_coroutines_core);
            }
            Throwable th2 = ((hl) makeCompletingOnce$kotlinx_coroutines_core).a;
            Continuation<T> continuation = dVar.uCont;
            if (!n30.d()) {
                throw th2;
            } else if (!(continuation instanceof CoroutineStackFrame)) {
                throw th2;
            } else {
                throw sd2.a(th2, (CoroutineStackFrame) continuation);
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    @Nullable
    public static final <T, R> Object f(@NotNull d<? super T> dVar, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object obj;
        boolean z = false;
        if (function2 != null) {
            try {
                obj = ((Function2) po2.e(function2, 2)).invoke(r, dVar);
            } catch (Throwable th) {
                obj = new hl(th, false, 2, null);
            }
            if (obj == b.d()) {
                return b.d();
            }
            Object makeCompletingOnce$kotlinx_coroutines_core = dVar.makeCompletingOnce$kotlinx_coroutines_core(obj);
            if (makeCompletingOnce$kotlinx_coroutines_core == q.COMPLETING_WAITING_CHILDREN) {
                return b.d();
            }
            if (makeCompletingOnce$kotlinx_coroutines_core instanceof hl) {
                Throwable th2 = ((hl) makeCompletingOnce$kotlinx_coroutines_core).a;
                if (!(th2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th2).coroutine != dVar) {
                    z = true;
                }
                if (z) {
                    Continuation<T> continuation = dVar.uCont;
                    if (!n30.d()) {
                        throw th2;
                    } else if (!(continuation instanceof CoroutineStackFrame)) {
                        throw th2;
                    } else {
                        throw sd2.a(th2, (CoroutineStackFrame) continuation);
                    }
                } else if (obj instanceof hl) {
                    Throwable th3 = ((hl) obj).a;
                    Continuation<T> continuation2 = dVar.uCont;
                    if (!n30.d()) {
                        throw th3;
                    } else if (!(continuation2 instanceof CoroutineStackFrame)) {
                        throw th3;
                    } else {
                        throw sd2.a(th3, (CoroutineStackFrame) continuation2);
                    }
                }
            } else {
                obj = q.h(makeCompletingOnce$kotlinx_coroutines_core);
            }
            return obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }
}
