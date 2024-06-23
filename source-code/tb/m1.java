package tb;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.3")
@ExperimentalStdlibApi
/* compiled from: Taobao */
public abstract class m1<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {
    @NotNull
    private final Function1<CoroutineContext.Element, E> a;
    @NotNull
    private final CoroutineContext.Key<?> b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: kotlin.coroutines.CoroutineContext$Key<?> */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext$Element, ? extends E extends B>, java.lang.Object, kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext$Element, E extends B>] */
    public m1(@NotNull CoroutineContext.Key<B> key, @NotNull Function1<? super CoroutineContext.Element, ? extends E> function1) {
        k21.i(key, "baseKey");
        k21.i(function1, "safeCast");
        this.a = function1;
        this.b = key instanceof m1 ? (CoroutineContext.Key<B>) ((m1) key).b : key;
    }

    public final boolean a(@NotNull CoroutineContext.Key<?> key) {
        k21.i(key, "key");
        return key == this || this.b == key;
    }

    @Nullable
    public final E b(@NotNull CoroutineContext.Element element) {
        k21.i(element, "element");
        return this.a.invoke(element);
    }
}
