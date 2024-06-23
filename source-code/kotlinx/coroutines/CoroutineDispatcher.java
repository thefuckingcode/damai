package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l1;
import tb.m1;
import tb.m40;
import tb.q30;

/* compiled from: Taobao */
public abstract class CoroutineDispatcher extends l1 implements ContinuationInterceptor {
    @NotNull
    public static final Key Key = new Key(null);

    @ExperimentalStdlibApi
    /* compiled from: Taobao */
    public static final class Key extends m1<ContinuationInterceptor, CoroutineDispatcher> {
        private Key() {
            super(ContinuationInterceptor.Key, AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ Key(m40 m40) {
            this();
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.Key);
    }

    public abstract void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable);

    @InternalCoroutinesApi
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        dispatch(coroutineContext, runnable);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.ContinuationInterceptor, tb.l1, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) ContinuationInterceptor.a.a(this, key);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    @NotNull
    public final <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> continuation) {
        return new DispatchedContinuation(this, continuation);
    }

    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.ContinuationInterceptor, tb.l1, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return ContinuationInterceptor.a.b(this, key);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    @NotNull
    public final CoroutineDispatcher plus(@NotNull CoroutineDispatcher coroutineDispatcher) {
        return coroutineDispatcher;
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    @InternalCoroutinesApi
    public void releaseInterceptedContinuation(@NotNull Continuation<?> continuation) {
        ((DispatchedContinuation) continuation).release();
    }

    @NotNull
    public String toString() {
        return q30.a(this) + '@' + q30.b(this);
    }
}
