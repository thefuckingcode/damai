package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aG\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\t¨\u0006\u000b"}, d2 = {"runBlocking", "T", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/CoroutineScope;", "Lkotlin/coroutines/experimental/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 10}, xs = "kotlinx/coroutines/experimental/BuildersKt")
/* compiled from: Builders.kt */
public final /* synthetic */ class BuildersKt__BuildersKt {
    public static /* bridge */ /* synthetic */ Object runBlocking$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return BuildersKt.runBlocking(coroutineContext, function2);
    }

    public static final <T> T runBlocking(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        Thread currentThread = Thread.currentThread();
        CoroutineContext.Element element = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        boolean z = element == null;
        if (z) {
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "currentThread");
            element = new BlockingEventLoop(currentThread);
        } else if (!(element instanceof EventLoop)) {
            element = null;
        }
        EventLoop eventLoop = (EventLoop) element;
        if (z) {
            if (eventLoop != null) {
                coroutineContext = coroutineContext.plus((ContinuationInterceptor) eventLoop);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.ContinuationInterceptor");
            }
        }
        CoroutineContext newCoroutineContext$default = CoroutineContextKt.newCoroutineContext$default(coroutineContext, null, 2, null);
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "currentThread");
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(newCoroutineContext$default, currentThread, eventLoop, z);
        blockingCoroutine.start(CoroutineStart.DEFAULT, blockingCoroutine, function2);
        return (T) blockingCoroutine.joinBlocking();
    }
}
