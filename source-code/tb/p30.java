package tb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class p30 {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Continuation<T> a(@NotNull Continuation<? super T> continuation) {
        k21.i(continuation, "completion");
        return continuation;
    }

    @SinceKotlin(version = "1.3")
    public static final void b(@NotNull Continuation<?> continuation) {
        k21.i(continuation, TypedValues.Attributes.S_FRAME);
    }

    @SinceKotlin(version = "1.3")
    public static final void c(@NotNull Continuation<?> continuation) {
        k21.i(continuation, TypedValues.Attributes.S_FRAME);
    }
}
