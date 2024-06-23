package tb;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class lf {
    public static final void a(Continuation<? super ur2> continuation, Continuation<?> continuation2) {
        try {
            Continuation continuation3 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
            Result.a aVar = Result.Companion;
            c90.c(continuation3, Result.m913constructorimpl(ur2.INSTANCE), null, 2, null);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            continuation2.resumeWith(Result.m913constructorimpl(k12.a(th)));
        }
    }

    public static final <T> void b(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        try {
            Continuation continuation2 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(function1, continuation));
            Result.a aVar = Result.Companion;
            c90.c(continuation2, Result.m913constructorimpl(ur2.INSTANCE), null, 2, null);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(k12.a(th)));
        }
    }

    public static final <R, T> void c(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation, Function1<? super Throwable, ur2> function1) {
        try {
            Continuation continuation2 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.b(function2, r, continuation));
            Result.a aVar = Result.Companion;
            c90.b(continuation2, Result.m913constructorimpl(ur2.INSTANCE), function1);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(k12.a(th)));
        }
    }

    public static /* synthetic */ void d(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i, Object obj2) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        c(function2, obj, continuation, function1);
    }
}
