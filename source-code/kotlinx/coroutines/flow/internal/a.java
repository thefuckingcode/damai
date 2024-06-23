package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import tb.ij1;
import tb.o82;
import tb.p30;
import tb.po2;

public final class a {
    /* JADX INFO: finally extract failed */
    public static final <T, V> Object b(CoroutineContext coroutineContext, V v, Object obj, Function2<? super V, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Object c = ThreadContextKt.c(coroutineContext, obj);
        try {
            c cVar = new c(continuation, coroutineContext);
            if (function2 != null) {
                Object invoke = ((Function2) po2.e(function2, 2)).invoke(v, cVar);
                ThreadContextKt.a(coroutineContext, c);
                if (invoke == b.d()) {
                    p30.c(continuation);
                }
                return invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            ThreadContextKt.a(coroutineContext, c);
            throw th;
        }
    }

    public static /* synthetic */ Object c(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation, int i, Object obj3) {
        if ((i & 4) != 0) {
            obj2 = ThreadContextKt.b(coroutineContext);
        }
        return b(coroutineContext, obj, obj2, function2, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> FlowCollector<T> d(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        return flowCollector instanceof o82 ? true : flowCollector instanceof ij1 ? flowCollector : new UndispatchedContextCollector(flowCollector, coroutineContext);
    }
}
