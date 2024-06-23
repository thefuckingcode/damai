package tb;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class q30 {
    @NotNull
    public static final String a(@NotNull Object obj) {
        return obj.getClass().getSimpleName();
    }

    @NotNull
    public static final String b(@NotNull Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @NotNull
    public static final String c(@NotNull Continuation<?> continuation) {
        Object obj;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m913constructorimpl(continuation + '@' + b(continuation));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m913constructorimpl(k12.a(th));
        }
        if (Result.m916exceptionOrNullimpl(obj) != null) {
            obj = ((Object) continuation.getClass().getName()) + '@' + b(continuation);
        }
        return (String) obj;
    }
}
