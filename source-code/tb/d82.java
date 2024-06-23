package tb;

import java.util.Objects;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.c82;

@JvmInline
/* compiled from: Taobao */
public final class d82<S extends c82<S>> {
    @NotNull
    public static <S extends c82<S>> Object a(@Nullable Object obj) {
        return obj;
    }

    @NotNull
    public static final S b(Object obj) {
        if (obj != sl.a()) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (S) ((c82) obj);
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static final boolean c(Object obj) {
        return obj == sl.a();
    }
}
