package kotlinx.coroutines.experimental.intrinsics;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.experimental.AbstractCoroutine;
import kotlinx.coroutines.experimental.CompletedExceptionally;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001aP\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t2\u0006\u0010\n\u001a\u0002H\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aW\u0010\f\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0006\u0010\n\u001a\u0002H\b2'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t¢\u0006\u0002\b\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a>\u0010\f\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a+\u0010\u0012\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0014H\b\u0002\u0004\n\u0002\b\t¨\u0006\u0015"}, d2 = {"startCoroutineUndispatched", "", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)V", "startUndispatchedOrReturn", "Lkotlinx/coroutines/experimental/AbstractCoroutine;", "block", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/experimental/AbstractCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "(Lkotlinx/coroutines/experimental/AbstractCoroutine;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "undispatchedResult", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Undispatched.kt */
public final class UndispatchedKt {
    public static final <T> void startCoroutineUndispatched(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        try {
            Object invoke = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(continuation);
            if (invoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                continuation.resume(invoke);
            }
        } catch (Throwable th) {
            continuation.resumeWithException(th);
        }
    }

    public static final <R, T> void startCoroutineUndispatched(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function2, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        try {
            Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, continuation);
            if (invoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                continuation.resume(invoke);
            }
        } catch (Throwable th) {
            continuation.resumeWithException(th);
        }
    }

    public static final <T> Object startUndispatchedOrReturn(AbstractCoroutine<? super T> abstractCoroutine, Function1<? super Continuation<? super T>, ? extends Object> function1) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(abstractCoroutine, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        abstractCoroutine.initParentJob$kotlinx_coroutines_core();
        try {
            obj = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(abstractCoroutine);
        } catch (Throwable th) {
            obj = new CompletedExceptionally(th);
        }
        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (!abstractCoroutine.makeCompletingOnce$kotlinx_coroutines_core(obj, 4)) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (!(obj instanceof CompletedExceptionally)) {
            return obj;
        }
        throw ((CompletedExceptionally) obj).cause;
    }

    public static final <T, R> Object startUndispatchedOrReturn(AbstractCoroutine<? super T> abstractCoroutine, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(abstractCoroutine, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        abstractCoroutine.initParentJob$kotlinx_coroutines_core();
        try {
            obj = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, abstractCoroutine);
        } catch (Throwable th) {
            obj = new CompletedExceptionally(th);
        }
        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (!abstractCoroutine.makeCompletingOnce$kotlinx_coroutines_core(obj, 4)) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (!(obj instanceof CompletedExceptionally)) {
            return obj;
        }
        throw ((CompletedExceptionally) obj).cause;
    }

    private static final <T> Object undispatchedResult(AbstractCoroutine<? super T> abstractCoroutine, Function0<? extends Object> function0) {
        Object obj;
        try {
            obj = function0.invoke();
        } catch (Throwable th) {
            obj = new CompletedExceptionally(th);
        }
        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (!abstractCoroutine.makeCompletingOnce$kotlinx_coroutines_core(obj, 4)) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (!(obj instanceof CompletedExceptionally)) {
            return obj;
        }
        throw ((CompletedExceptionally) obj).cause;
    }
}
