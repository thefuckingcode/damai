package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import tb.ok2;
import tb.qn;
import tb.vs0;

public final /* synthetic */ class e {
    public static final <T> T a(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        CoroutineContext coroutineContext2;
        k kVar;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        if (continuationInterceptor == null) {
            kVar = ok2.INSTANCE.b();
            coroutineContext2 = qn.c(vs0.INSTANCE, coroutineContext.plus(kVar));
        } else {
            k kVar2 = null;
            k kVar3 = continuationInterceptor instanceof k ? (k) continuationInterceptor : null;
            if (kVar3 != null && kVar3.shouldBeProcessedFromContext()) {
                kVar2 = kVar3;
            }
            kVar = kVar2 == null ? ok2.INSTANCE.a() : kVar2;
            coroutineContext2 = qn.c(vs0.INSTANCE, coroutineContext);
        }
        c cVar = new c(coroutineContext2, currentThread, kVar);
        cVar.start(CoroutineStart.DEFAULT, cVar, function2);
        return (T) cVar.a();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return d.c(coroutineContext, function2);
    }
}
