package kotlinx.coroutines.experimental.intrinsics;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.DispatchedKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001aP\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t2\u0006\u0010\n\u001a\u0002H\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\t¨\u0006\f"}, d2 = {"startCoroutineCancellable", "", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Cancellable.kt */
public final class CancellableKt {
    public static final <T> void startCoroutineCancellable(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        DispatchedKt.resumeCancellable(IntrinsicsKt.createCoroutineUnchecked(function1, continuation), Unit.INSTANCE);
    }

    public static final <R, T> void startCoroutineCancellable(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function2, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        DispatchedKt.resumeCancellable(IntrinsicsKt.createCoroutineUnchecked(function2, r, continuation), Unit.INSTANCE);
    }
}
