package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jh2;
import tb.k21;

/* compiled from: Taobao */
public final class ThreadContextKt {
    @JvmField
    @NotNull
    public static final jh2 NO_THREAD_ELEMENTS = new jh2("NO_THREAD_ELEMENTS");
    @NotNull
    private static final Function2<Object, CoroutineContext.Element, Object> a = ThreadContextKt$countAll$1.INSTANCE;
    @NotNull
    private static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> b = ThreadContextKt$findOne$1.INSTANCE;
    @NotNull
    private static final Function2<e, CoroutineContext.Element, e> c = ThreadContextKt$updateState$1.INSTANCE;

    public static final void a(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj != NO_THREAD_ELEMENTS) {
            if (obj instanceof e) {
                ((e) obj).b(coroutineContext);
                return;
            }
            Object fold = coroutineContext.fold(null, b);
            Objects.requireNonNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((ThreadContextElement) fold).restoreThreadContext(coroutineContext, obj);
        }
    }

    @NotNull
    public static final Object b(@NotNull CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, a);
        k21.f(fold);
        return fold;
    }

    @Nullable
    public static final Object c(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return NO_THREAD_ELEMENTS;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new e(coroutineContext, ((Number) obj).intValue()), c);
        }
        return ((ThreadContextElement) obj).updateThreadContext(coroutineContext);
    }
}
