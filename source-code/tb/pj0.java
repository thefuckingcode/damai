package tb;

import kotlin.BuilderInference;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class pj0 {
    @Nullable
    public static final <R> Object a(@BuilderInference @NotNull Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        oj0 oj0 = new oj0(continuation.getContext(), continuation);
        Object e = pr2.e(oj0, oj0, function2);
        if (e == b.d()) {
            p30.c(continuation);
        }
        return e;
    }
}
