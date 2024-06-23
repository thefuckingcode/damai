package tb;

import java.util.Iterator;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.coroutines.intrinsics.b;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.3")
@RestrictsSuspension
/* compiled from: Taobao */
public abstract class s82<T> {
    @Nullable
    public abstract Object a(T t, @NotNull Continuation<? super ur2> continuation);

    @Nullable
    public abstract Object b(@NotNull Iterator<? extends T> it, @NotNull Continuation<? super ur2> continuation);

    @Nullable
    public final Object c(@NotNull Sequence<? extends T> sequence, @NotNull Continuation<? super ur2> continuation) {
        Object b = b(sequence.iterator(), continuation);
        return b == b.d() ? b : ur2.INSTANCE;
    }
}
