package kotlin.coroutines;

import io.flutter.wpkbridge.WPKFactory;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@SinceKotlin(version = "1.3")
/* compiled from: Taobao */
public interface CoroutineContext {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @NotNull
        public static CoroutineContext a(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext coroutineContext2) {
            k21.i(coroutineContext2, WPKFactory.INIT_KEY_CONTEXT);
            return coroutineContext2 == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, CoroutineContext$plus$1.INSTANCE);
        }
    }

    /* compiled from: Taobao */
    public interface Element extends CoroutineContext {

        /* compiled from: Taobao */
        public static final class a {
            public static <R> R a(@NotNull Element element, R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
                k21.i(function2, "operation");
                return (R) function2.invoke(r, element);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.CoroutineContext$Element */
            /* JADX WARN: Multi-variable type inference failed */
            @Nullable
            public static <E extends Element> E b(@NotNull Element element, @NotNull Key<E> key) {
                k21.i(key, "key");
                if (!k21.d(element.getKey(), key)) {
                    return null;
                }
                k21.g(element, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return element;
            }

            @NotNull
            public static CoroutineContext c(@NotNull Element element, @NotNull Key<?> key) {
                k21.i(key, "key");
                return k21.d(element.getKey(), key) ? EmptyCoroutineContext.INSTANCE : element;
            }

            @NotNull
            public static CoroutineContext d(@NotNull Element element, @NotNull CoroutineContext coroutineContext) {
                k21.i(coroutineContext, WPKFactory.INIT_KEY_CONTEXT);
                return DefaultImpls.a(element, coroutineContext);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <R> R fold(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2);

        @Override // kotlin.coroutines.CoroutineContext
        @Nullable
        <E extends Element> E get(@NotNull Key<E> key);

        @NotNull
        Key<?> getKey();

        @Override // kotlin.coroutines.CoroutineContext
        @NotNull
        CoroutineContext minusKey(@NotNull Key<?> key);
    }

    /* compiled from: Taobao */
    public interface Key<E extends Element> {
    }

    <R> R fold(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2);

    @Nullable
    <E extends Element> E get(@NotNull Key<E> key);

    @NotNull
    CoroutineContext minusKey(@NotNull Key<?> key);

    @NotNull
    CoroutineContext plus(@NotNull CoroutineContext coroutineContext);
}
