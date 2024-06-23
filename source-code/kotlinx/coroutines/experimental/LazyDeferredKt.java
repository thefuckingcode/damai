package kotlinx.coroutines.experimental;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aM\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000b*V\b\u0007\u0010\f\u001a\u0004\b\u0000\u0010\u0002\"\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0012\u0004\u0012\u0002H\u00020\u0001B6\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\n\b\u0010\u0012\u0006\b\n0\u00118\u0012\u0012\u001c\b\u0013\u0012\u0018\b\u000bB\u0014\b\u0014\u0012\u0006\b\u0015\u0012\u0002\b\f\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0002\u0004\n\u0002\b\t¨\u0006\u0018"}, d2 = {"lazyDefer", "Lkotlinx/coroutines/experimental/Deferred;", "T", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/CoroutineScope;", "Lkotlin/coroutines/experimental/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/Deferred;", "LazyDeferred", "Lkotlin/Deprecated;", "message", "`Deferred` incorporates functionality of `LazyDeferred`", "level", "Lkotlin/DeprecationLevel;", "WARNING", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "Deferred", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: LazyDeferred.kt */
public final class LazyDeferredKt {
    @Deprecated(level = DeprecationLevel.WARNING, message = "`Deferred` incorporates functionality of `LazyDeferred`", replaceWith = @ReplaceWith(expression = "Deferred", imports = {}))
    public static /* synthetic */ void LazyDeferred$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This functionality is incorporated into `async", replaceWith = @ReplaceWith(expression = "async(context, start = false, block = block)", imports = {}))
    public static final <T> Deferred<T> lazyDefer(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        return DeferredKt.async(coroutineContext, false, (Function2) function2);
    }
}
