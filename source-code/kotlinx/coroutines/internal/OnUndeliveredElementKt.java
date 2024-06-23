package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import tb.jf0;
import tb.k21;
import tb.sn;
import tb.ur2;

public final class OnUndeliveredElementKt {
    public static final <E> Function1<Throwable, ur2> a(Function1<? super E, ur2> function1, E e, CoroutineContext coroutineContext) {
        return new OnUndeliveredElementKt$bindCancellationFun$1(function1, e, coroutineContext);
    }

    public static final <E> void b(Function1<? super E, ur2> function1, E e, CoroutineContext coroutineContext) {
        UndeliveredElementException c = c(function1, e, null);
        if (c != null) {
            sn.a(coroutineContext, c);
        }
    }

    public static final <E> UndeliveredElementException c(Function1<? super E, ur2> function1, E e, UndeliveredElementException undeliveredElementException) {
        try {
            function1.invoke(e);
        } catch (Throwable th) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th) {
                return new UndeliveredElementException(k21.r("Exception in undelivered element handler for ", e), th);
            }
            jf0.a(undeliveredElementException, th);
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException d(Function1 function1, Object obj, UndeliveredElementException undeliveredElementException, int i, Object obj2) {
        if ((i & 2) != 0) {
            undeliveredElementException = null;
        }
        return c(function1, obj, undeliveredElementException);
    }
}
