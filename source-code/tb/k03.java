package tb;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class k03 {
    @Nullable
    public static final Object a(@NotNull Continuation<? super ur2> continuation) {
        Object obj;
        CoroutineContext context = continuation.getContext();
        j41.f(context);
        Continuation continuation2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        DispatchedContinuation dispatchedContinuation = continuation2 instanceof DispatchedContinuation ? (DispatchedContinuation) continuation2 : null;
        if (dispatchedContinuation == null) {
            obj = ur2.INSTANCE;
        } else {
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(context, ur2.INSTANCE);
            } else {
                j03 j03 = new j03();
                CoroutineContext plus = context.plus(j03);
                ur2 ur2 = ur2.INSTANCE;
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(plus, ur2);
                if (j03.a) {
                    obj = c90.d(dispatchedContinuation) ? b.d() : ur2;
                }
            }
            obj = b.d();
        }
        if (obj == b.d()) {
            p30.c(continuation);
        }
        return obj == b.d() ? obj : ur2.INSTANCE;
    }
}
