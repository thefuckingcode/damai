package kotlinx.coroutines.experimental;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 2}, d1 = {"kotlinx/coroutines/experimental/BuildersKt__BuildersKt", "kotlinx/coroutines/experimental/BuildersKt__Builders_commonKt"}, k = 4, mv = {1, 1, 10})
public final class BuildersKt {
    public static final Job launch(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Job job, Function1<? super Throwable, Unit> function1, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return BuildersKt__Builders_commonKt.launch(coroutineContext, coroutineStart, job, function1, function2);
    }

    @Deprecated(message = "Use `start = CoroutineStart.XXX` parameter", replaceWith = @ReplaceWith(expression = "launch(context, if (start) CoroutineStart.DEFAULT else CoroutineStart.LAZY, block)", imports = {}))
    public static final Job launch(CoroutineContext coroutineContext, boolean z, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return BuildersKt__Builders_commonKt.launch(coroutineContext, z, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `withContext`", replaceWith = @ReplaceWith(expression = "withContext(context, start, block)", imports = {}))
    public static final <T> Object run(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        return BuildersKt__Builders_commonKt.run(coroutineContext, coroutineStart, function1, continuation);
    }

    public static final <T> T runBlocking(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        return (T) BuildersKt__BuildersKt.runBlocking(coroutineContext, function2);
    }

    public static final <T> Object withContext(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        return BuildersKt__Builders_commonKt.withContext(coroutineContext, coroutineStart, function1, continuation);
    }
}
