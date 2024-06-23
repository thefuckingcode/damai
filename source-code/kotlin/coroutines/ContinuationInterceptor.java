package kotlin.coroutines;

import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m1;

@SinceKotlin(version = "1.3")
/* compiled from: Taobao */
public interface ContinuationInterceptor extends CoroutineContext.Element {
    @NotNull
    public static final b Key = b.a;

    /* compiled from: Taobao */
    public static final class a {
        @Nullable
        public static <E extends CoroutineContext.Element> E a(@NotNull ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext.Key<E> key) {
            k21.i(key, "key");
            if (key instanceof m1) {
                m1 m1Var = (m1) key;
                if (!m1Var.a(continuationInterceptor.getKey())) {
                    return null;
                }
                E e = (E) m1Var.b(continuationInterceptor);
                if (e instanceof CoroutineContext.Element) {
                    return e;
                }
                return null;
            } else if (ContinuationInterceptor.Key != key) {
                return null;
            } else {
                k21.g(continuationInterceptor, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return continuationInterceptor;
            }
        }

        @NotNull
        public static CoroutineContext b(@NotNull ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext.Key<?> key) {
            k21.i(key, "key");
            if (!(key instanceof m1)) {
                return ContinuationInterceptor.Key == key ? EmptyCoroutineContext.INSTANCE : continuationInterceptor;
            }
            m1 m1Var = (m1) key;
            return (!m1Var.a(continuationInterceptor.getKey()) || m1Var.b(continuationInterceptor) == null) ? continuationInterceptor : EmptyCoroutineContext.INSTANCE;
        }
    }

    /* compiled from: Taobao */
    public static final class b implements CoroutineContext.Key<ContinuationInterceptor> {
        static final /* synthetic */ b a = new b();

        private b() {
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key);

    @NotNull
    <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> continuation);

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key);

    void releaseInterceptedContinuation(@NotNull Continuation<?> continuation);
}
