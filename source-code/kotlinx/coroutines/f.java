package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.d;
import tb.j41;
import tb.k21;
import tb.lf;
import tb.or2;
import tb.p30;
import tb.pr2;
import tb.qn;
import tb.ur2;

public final /* synthetic */ class f {
    public static final Job a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super ur2>, ? extends Object> function2) {
        a aVar;
        CoroutineContext c = qn.c(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            aVar = new r(c, function2);
        } else {
            aVar = new w(c, true);
        }
        aVar.start(coroutineStart, aVar, function2);
        return aVar;
    }

    public static /* synthetic */ Job b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return d.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    /* JADX INFO: finally extract failed */
    public static final <T> Object c(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Object obj;
        CoroutineContext context = continuation.getContext();
        CoroutineContext plus = context.plus(coroutineContext);
        j41.f(plus);
        if (plus == context) {
            d dVar = new d(plus, continuation);
            obj = pr2.e(dVar, dVar, function2);
        } else {
            ContinuationInterceptor.b bVar = ContinuationInterceptor.Key;
            if (k21.d(plus.get(bVar), context.get(bVar))) {
                or2 or2 = new or2(plus, continuation);
                Object c = ThreadContextKt.c(plus, null);
                try {
                    Object e = pr2.e(or2, or2, function2);
                    ThreadContextKt.a(plus, c);
                    obj = e;
                } catch (Throwable th) {
                    ThreadContextKt.a(plus, c);
                    throw th;
                }
            } else {
                i iVar = new i(plus, continuation);
                lf.d(function2, iVar, iVar, null, 4, null);
                obj = iVar.a();
            }
        }
        if (obj == b.d()) {
            p30.c(continuation);
        }
        return obj;
    }
}
