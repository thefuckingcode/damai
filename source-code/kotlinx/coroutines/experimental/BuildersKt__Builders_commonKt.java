package kotlinx.coroutines.experimental;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012-\b\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001aY\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aM\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u000e2'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001aG\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u000e2\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a=\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001aG\u0010\u001e\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u000e2\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u0002\u0004\n\u0002\b\t¨\u0006\u001f"}, d2 = {"launch", "Lkotlinx/coroutines/experimental/Job;", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "start", "", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/CoroutineScope;", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/experimental/CoroutineContext;ZLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/Job;", "Lkotlinx/coroutines/experimental/CoroutineStart;", "parent", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", SerializableCookie.NAME, "cause", "Lkotlinx/coroutines/experimental/CompletionHandler;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlinx/coroutines/experimental/CoroutineStart;Lkotlinx/coroutines/experimental/Job;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/Job;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlinx/coroutines/experimental/CoroutineStart;Lkotlinx/coroutines/experimental/Job;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/Job;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlinx/coroutines/experimental/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/Job;", "run", "T", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlinx/coroutines/experimental/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "withContext", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 10}, xs = "kotlinx/coroutines/experimental/BuildersKt")
/* compiled from: Builders.common.kt */
public final /* synthetic */ class BuildersKt__Builders_commonKt {
    public static /* bridge */ /* synthetic */ Job launch$default(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Job job, Function1 function1, Function2 function2, int i, Object obj) {
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
        return BuildersKt.launch(coroutineContext, coroutineStart, job, function1, function2);
    }

    public static final Job launch(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Job job, Function1<? super Throwable, Unit> function1, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        LazyStandaloneCoroutine lazyStandaloneCoroutine;
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineContext, job);
        if (coroutineStart.isLazy()) {
            lazyStandaloneCoroutine = new LazyStandaloneCoroutine(newCoroutineContext, function2);
        } else {
            lazyStandaloneCoroutine = new StandaloneCoroutine(newCoroutineContext, true);
        }
        if (function1 != null) {
            lazyStandaloneCoroutine.invokeOnCompletion(function1);
        }
        lazyStandaloneCoroutine.start(coroutineStart, lazyStandaloneCoroutine, function2);
        return lazyStandaloneCoroutine;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static /* bridge */ /* synthetic */ Job launch$default(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Job job, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = CoroutineContextKt.getDefaultDispatcher();
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        if ((i & 4) != 0) {
            job = null;
        }
        return launch(coroutineContext, coroutineStart, job, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Job launch(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Job job, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        return launch$default(coroutineContext, coroutineStart, job, null, function2, 8, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static /* bridge */ /* synthetic */ Job launch$default(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = CoroutineContextKt.getDefaultDispatcher();
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return launch(coroutineContext, coroutineStart, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Job launch(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        return launch$default(coroutineContext, coroutineStart, null, null, function2, 12, null);
    }

    @Deprecated(message = "Use `start = CoroutineStart.XXX` parameter", replaceWith = @ReplaceWith(expression = "launch(context, if (start) CoroutineStart.DEFAULT else CoroutineStart.LAZY, block)", imports = {}))
    public static final Job launch(CoroutineContext coroutineContext, boolean z, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        return launch$default(coroutineContext, z ? CoroutineStart.DEFAULT : CoroutineStart.LAZY, null, null, function2, 12, null);
    }

    public static /* bridge */ /* synthetic */ Object withContext$default(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.withContext(coroutineContext, coroutineStart, function1, continuation);
    }

    public static final <T> Object withContext(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Continuation normalizeContinuation = CoroutineIntrinsics.normalizeContinuation(continuation);
        CoroutineContext context = normalizeContinuation.getContext();
        int i = 1;
        if (coroutineContext != context && (!(coroutineContext instanceof CoroutineContext.Element) || context.get(((CoroutineContext.Element) coroutineContext).getKey()) != coroutineContext)) {
            CoroutineContext plus = context.plus(coroutineContext);
            if (plus == context) {
                if (function1 != null) {
                    return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(normalizeContinuation);
                }
                throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
            } else if (Intrinsics.areEqual((ContinuationInterceptor) plus.get(ContinuationInterceptor.Key), (ContinuationInterceptor) context.get(ContinuationInterceptor.Key))) {
                RunContinuationDirect runContinuationDirect = new RunContinuationDirect(plus, normalizeContinuation);
                if (function1 != null) {
                    return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(runContinuationDirect);
                }
                throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
            } else if (!coroutineStart.isLazy()) {
                if (coroutineStart == CoroutineStart.ATOMIC) {
                    i = 0;
                }
                RunCompletion runCompletion = new RunCompletion(plus, normalizeContinuation, i);
                runCompletion.initParentJobInternal$kotlinx_coroutines_core((Job) plus.get(Job.Key));
                coroutineStart.invoke(function1, runCompletion);
                return runCompletion.getResult();
            } else {
                throw new IllegalArgumentException((coroutineStart + " start is not supported").toString());
            }
        } else if (function1 != null) {
            return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(normalizeContinuation);
        } else {
            throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `withContext`", replaceWith = @ReplaceWith(expression = "withContext(context, start, block)", imports = {}))
    public static /* bridge */ /* synthetic */ Object run$default(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.run(coroutineContext, coroutineStart, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `withContext`", replaceWith = @ReplaceWith(expression = "withContext(context, start, block)", imports = {}))
    public static final <T> Object run(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        return BuildersKt.withContext(coroutineContext, coroutineStart, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "It is here for binary compatibility only")
    public static final /* synthetic */ <T> Object run(CoroutineContext coroutineContext, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        return BuildersKt.withContext(coroutineContext, CoroutineStart.ATOMIC, function1, continuation);
    }
}
