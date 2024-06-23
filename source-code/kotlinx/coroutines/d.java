package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import tb.ur2;

public final class d {
    public static final Job a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super ur2>, ? extends Object> function2) {
        return f.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> T c(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        return (T) e.a(coroutineContext, function2);
    }

    public static final <T> Object e(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return f.c(coroutineContext, function2, continuation);
    }
}
