package kotlinx.coroutines.experimental;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aU\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102-\b\u0002\u0010\u0011\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012j\u0004\u0018\u0001`\u00182'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001ae\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001aY\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u000e2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001aM\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u0002\u0004\n\u0002\b\t¨\u0006\u001e"}, d2 = {"async", "Lkotlinx/coroutines/experimental/Deferred;", "T", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "start", "", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/CoroutineScope;", "Lkotlin/coroutines/experimental/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/experimental/CoroutineContext;ZLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/Deferred;", "Lkotlinx/coroutines/experimental/CoroutineStart;", "parent", "Lkotlinx/coroutines/experimental/Job;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", SerializableCookie.NAME, "cause", "", "Lkotlinx/coroutines/experimental/CompletionHandler;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlinx/coroutines/experimental/CoroutineStart;Lkotlinx/coroutines/experimental/Job;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/Deferred;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlinx/coroutines/experimental/CoroutineStart;Lkotlinx/coroutines/experimental/Job;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/Deferred;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlinx/coroutines/experimental/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/Deferred;", "defer", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/Deferred;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Deferred.kt */
public final class DeferredKt {
    public static /* bridge */ /* synthetic */ Deferred async$default(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Job job, Function1 function1, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = CoroutineContextKt.getDefaultDispatcher();
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        if ((i & 4) != 0) {
            job = null;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        return async(coroutineContext, coroutineStart, job, function1, function2);
    }

    public static final <T> Deferred<T> async(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Job job, Function1<? super Throwable, Unit> function1, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        LazyDeferredCoroutine lazyDeferredCoroutine;
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineContext, job);
        if (coroutineStart.isLazy()) {
            lazyDeferredCoroutine = new LazyDeferredCoroutine(newCoroutineContext, function2);
        } else {
            lazyDeferredCoroutine = new DeferredCoroutine(newCoroutineContext, true);
        }
        if (function1 != null) {
            lazyDeferredCoroutine.invokeOnCompletion(function1);
        }
        lazyDeferredCoroutine.start(coroutineStart, lazyDeferredCoroutine, function2);
        return lazyDeferredCoroutine;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static /* bridge */ /* synthetic */ Deferred async$default(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Job job, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = CoroutineContextKt.getDefaultDispatcher();
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        if ((i & 4) != 0) {
            job = null;
        }
        return async(coroutineContext, coroutineStart, job, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ <T> Deferred<T> async(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Job job, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        return async$default(coroutineContext, coroutineStart, job, null, function2, 8, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static /* bridge */ /* synthetic */ Deferred async$default(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = CoroutineContextKt.getDefaultDispatcher();
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return async(coroutineContext, coroutineStart, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ <T> Deferred<T> async(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        return async$default(coroutineContext, coroutineStart, null, null, function2, 12, null);
    }

    @Deprecated(message = "Use `start = CoroutineStart.XXX` parameter", replaceWith = @ReplaceWith(expression = "async(context, if (start) CoroutineStart.DEFAULT else CoroutineStart.LAZY, block)", imports = {}))
    public static final <T> Deferred<T> async(CoroutineContext coroutineContext, boolean z, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        return async$default(coroutineContext, z ? CoroutineStart.DEFAULT : CoroutineStart.LAZY, null, null, function2, 12, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "`defer` was renamed to `async`", replaceWith = @ReplaceWith(expression = "async(context, block = block)", imports = {}))
    public static final <T> Deferred<T> defer(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        return async$default(coroutineContext, null, null, null, function2, 14, null);
    }
}
